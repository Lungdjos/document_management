package com.dms.document_management.managers;

import com.dms.document_management.dto.sysdtos.ResultDto;
import com.dms.document_management.enums.FileSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

public interface FileSystemManager {
    String getFileSystemRootArchive(); // Root directory for the archive file system

    String getFileSystemRootMain(); // Root directory for the main file system

    ResultDto decryptFile(String filePath, FileSource source); // Decrypts a file at the specified path from the given source

    ResultDto encryptFile(String filePath, FileSource source); // Encrypts a file at the specified path from the given source

    CompletableFuture<String> initializeFileStore(); // Initializes the file store and returns the path

    ResultDto moveFileFromArchive(String filePath); // Moves a file from the archive to the main file system

    ResultDto moveFileToArchive(String filePath); // Moves a file from the main file system to the archive

    CompletableFuture<ResultDto<ByteArrayOutputStream>> readFileFromFileStore(String filePath, FileSource source); // Reads a file from the file store and returns it as a memory stream

    String readFileFromFileStoreAsBlob(String filePath, FileSource source); // Reads a file from the file store and returns it as a blob

    byte[] readFileFromFileStoreAsBytes(String path, FileSource source) throws IOException; // Reads a file from the file store and returns it as a byte array

    CompletableFuture<ResultDto<String>> writeFileToStore(InputStream inputStream, String fileStore); // Writes a file to the file store from an input stream and returns the path

    CompletableFuture<Void> fileStoreCleanUp();
}
