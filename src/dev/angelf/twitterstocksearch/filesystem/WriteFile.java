package dev.angelf.twitterstocksearch.filesystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void write(String Text, String FilePath, String FileName) {
        try {
            FileWriter myWriter = new FileWriter(FilePath + "/" + FileName);
            myWriter.write(Text);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String Text, String FileName) {
        try {
            FileWriter myWriter = new FileWriter(FileName);
            myWriter.write(Text);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendNewLine(String FilePath, String FileName, String Text) {

        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(FilePath + "/" + FileName, true)  //Set true for append mode
            );
            writer.newLine();
            writer.write(Text);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
