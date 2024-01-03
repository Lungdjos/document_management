package com.dms.document_management.managers.implementation.sys;

import com.dms.document_management.dto.sysdtos.ResultDto;
import com.dms.document_management.enums.FileSource;
import com.dms.document_management.managers.FileSystemManager;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

@Service
public class FileSystemMangeImpl implements FileSystemManager {
    @Override
    public String getFileSystemRootArchive() {
        return null;
    }

    @Override
    public String getFileSystemRootMain() {
        return null;
    }

    @Override
    public ResultDto decryptFile(String filePath, FileSource source) {
        return null;
    }

    @Override
    public ResultDto encryptFile(String filePath, FileSource source) {
        return null;
    }

    @Override
    public CompletableFuture<String> initializeFileStore() {
        return null;
    }

    @Override
    public ResultDto moveFileFromArchive(String filePath) {
        return null;
    }

    @Override
    public ResultDto moveFileToArchive(String filePath) {
        return null;
    }

    @Override
    public CompletableFuture<ResultDto<ByteArrayOutputStream>> readFileFromFileStore(String filePath, FileSource source) {
        return null;
    }

    @Override
    public String readFileFromFileStoreAsBlob(String filePath, FileSource source) {
        return null;
    }

    @Override
    public byte[] readFileFromFileStoreAsBytes(String path, FileSource source) throws IOException {
        return new byte[0];
    }

    @Override
    public CompletableFuture<ResultDto<String>> writeFileToStore(InputStream inputStream, String fileStore) {
        return null;
    }

    @Override
    public CompletableFuture<Void> fileStoreCleanUp() {
        return null;
    }
}
