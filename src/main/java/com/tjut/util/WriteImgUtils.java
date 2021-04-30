package com.tjut.util;

import org.apache.commons.fileupload.FileItem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WriteImgUtils {
    public static void write(FileItem item, String fileName) throws IOException {
        long sizeInBytes = item.getSize();
        int len;
        InputStream in = item.getInputStream();
        OutputStream out = new FileOutputStream(fileName);
        byte[] buffer = new byte[Math.toIntExact(sizeInBytes)];
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
    }
}
