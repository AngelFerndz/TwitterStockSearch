package dev.angelf.twitterstocksearch.filesystem;

import java.io.File;
import java.io.IOException;

public class CreateFile {

    public static void create(String FilePath, String FileName) {

        try {
            File file = new File(FilePath + "/" + FileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
