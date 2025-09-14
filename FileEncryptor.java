import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.spec.KeySpec;
import java.util.Scanner;

public class FileEncryptor {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("🔐 Java File Encryptor 🔐");
        System.out.println("1. Encrypt a File");
        System.out.println("2. Decrypt a File");
        System.out.print("Choose an option (1 or 2): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            System.out.print("Enter input file path: ");
            String inputFile = scanner.nextLine();
            
            System.out.print("Enter output file path: ");
            String outputFile = scanner.nextLine();
            
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (choice == 1) {
                encryptFile(password, inputFile, outputFile);
                System.out.println("✅ File encrypted successfully!");
            } else if (choice == 2) {
                decryptFile(password, inputFile, outputFile);
                System.out.println("✅ File decrypted successfully!");
            } else {
                System.out.println("❌ Invalid choice!");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        
        scanner.close();
    }

    public static void encryptFile(String password, String inputFile, String outputFile) throws Exception {
        processFile(Cipher.ENCRYPT_MODE, password, inputFile, outputFile);
    }

    public static void decryptFile(String password, String inputFile, String outputFile) throws Exception {
        processFile(Cipher.DECRYPT_MODE, password, inputFile, outputFile);
    }

    private static void processFile(int cipherMode, String password, String inputFile, String outputFile) throws Exception {
        try {
            SecretKey secretKey = generateKey(password);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) new File(inputFile).length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            throw new Exception("File processing failed. Check password/filename.", e);
        }
    }

    private static SecretKey generateKey(String password) throws Exception {
        byte[] salt = new byte[8]; // Simple salt for demonstration
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKey tmp = factory.generateSecret(spec);
        return new SecretKeySpec(tmp.getEncoded(), ALGORITHM);
    }
          }
