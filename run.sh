#!/bin/bash

# Java File Encryptor Build and Run Script
echo "🔨 Building Java File Encryptor..."
javac FileEncryptor.java

if [ $? -eq 0 ]; then
    echo "✅ Build successful!"
    echo "🔐 Starting File Encryptor..."
    echo "============================="
    java FileEncryptor
else
    echo "❌ Build failed!"
    exit 1
fi
