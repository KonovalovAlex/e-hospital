package kz.online.ehospital.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;


public class FileUtil {

    public static String decodeStringToUTF8(String encodeStr) {
        String decodeStr = new String(encodeStr.getBytes(), Charset.forName("utf-8"));
        if (encodeStr.matches("[(A-Za-zА-Яа-я\\.\\-_ 0-9)]*")) return encodeStr;
        return decodeStr.replaceAll("[^(A-Za-zА-Яа-я\\.\\-_ 0-9)]*", "");
//        [^(A-Za-zА-Яа-я\. 0-9)]*
    }


    public static void recursiveDecodeFileAndFolderNameToUtf8(File folder) {
        if (!folder.exists()) return;
        String decodedName = null;
        String path = null;
        for (final File fileEntry : folder.listFiles()) {
            decodedName = decodeStringToUTF8(fileEntry.getName());
            path = fileEntry.getAbsolutePath().replace(fileEntry.getName(), decodedName);
            System.out.println(path);
            if (fileEntry.isDirectory()) {
                recursiveDecodeFileAndFolderNameToUtf8(fileEntry);
                fileEntry.renameTo(new File(path));
            } else {
                fileEntry.renameTo(new File(path));
            }
        }
    }

    public static void recursiveDeleteAllFoldersAndFiles(File folder) {
        String decodedName = null;
        String path = null;
        for (final File fileEntry : folder.listFiles()) {
            decodedName = decodeStringToUTF8(fileEntry.getName());
            path = fileEntry.getAbsolutePath().replace(fileEntry.getName(), decodedName);
            System.out.println(path);
            if (fileEntry.isDirectory()) {
                recursiveDeleteAllFoldersAndFiles(fileEntry);
                fileEntry.delete();
            } else {
                fileEntry.delete();
            }
        }
    }

    public static void copyFolder(File src, File dest) {
        if (!src.exists()) {
            System.out.println("Directory or file does not exist.");
            return;
        }
        if (src.isDirectory()) {
            //if directory not exists, create it
            if (!dest.exists()) {
                dest.mkdir();
                System.out.println("Directory copied from "
                        + src + "  to " + dest);
            }
            //list all the directory contents
            String files[] = src.list();

            for (String file : files) {
                //construct the src and dest file structure
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                //recursive copy
                copyFolder(srcFile, destFile);
            }
        } else {
            //if file, then copy it
            //Use bytes stream to support all file types
            try {
                InputStream in = new FileInputStream(src);
                OutputStream out = new FileOutputStream(dest);

                byte[] buffer = new byte[1024];
                int length;
                //copy the file content in bytes
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("File copied from " + src + " to " + dest);
        }
    }
}