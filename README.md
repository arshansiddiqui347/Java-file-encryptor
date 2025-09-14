# Java File Encryptor 🔐

A secure Java application for file encryption and decryption using AES (Advanced Encryption Standard) algorithm with 128-bit key encryption.

## ✨ Features

- **AES Encryption**: Military-grade encryption algorithm
- **Password-Based Key Derivation**: Uses PBKDF2 for secure key generation
- **File Handling**: Encrypts and decrypts any file type
- **Error Handling**: Robust exception handling and user feedback
- **CLI Interface**: Simple command-line interface for easy use

## 🚀 How to Use

### Prerequisites
- Java JDK 8 or higher
- Basic knowledge of command line

### Compilation
```bash
javac FileEncryptor.java
```

### Encryption
```bash
java FileEncryptor
# Choose option 1 (Encrypt)
# Input file: sample.txt
# Output file: encrypted.enc
# Password: your-secure-password
```

### Decryption
```bash
java FileEncryptor
# Choose option 2 (Decrypt)
# Input file: encrypted.enc
# Output file: decrypted.txt
# Password: your-secure-password
```

## 🛠️ Technical Implementation

### Encryption Algorithm
- **Algorithm**: AES (Advanced Encryption Standard)
- **Key Size**: 128-bit
- **Mode**: ECB (Electronic Codebook)
- **Padding**: PKCS5Padding
- **Key Derivation**: PBKDF2WithHmacSHA1 with 65536 iterations

### Security Features
- Password-based key derivation with salt
- Secure byte processing using Java Cryptography Extension (JCE)
- Proper resource management and cleanup

## 📁 Project Structure
```
java-file-encryptor/
├── FileEncryptor.java  # Main application
├── sample.txt          # Sample file for testing
└── README.md          # Project documentation
```

## 🔧 Code Highlights

- Uses javax.crypto package for encryption operations
- Implements try-with-resources for automatic resource management
- Includes comprehensive error handling
- Demonstrates object-oriented programming principles

## 🎯 Learning Outcomes

This project demonstrates understanding of:
- Cryptography concepts and AES encryption
- File I/O operations in Java
- Password-based key derivation
- Exception handling and robust programming
- Command-line interface design

## ⚠️ Important Notes

- This is for educational purposes only
- Always use strong, unique passwords for encryption
- Keep your encryption passwords secure
- The same password must be used for encryption and decryption

## Developer

Created by ARSHAN as a demonstration of cryptography and secure programming skills.
