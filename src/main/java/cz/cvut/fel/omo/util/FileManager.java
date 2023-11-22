package cz.cvut.fel.omo.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class represents file manager to write into file.
 */
public class FileManager {


    /**
     * Generates report from to the specified file name with specified text report.
     *
     * @param name   file name
     * @param report report text
     * @throws IOException when the directory does not exist
     */
    public static void generateReport(String name, String report) throws IOException {
        writeToFile(openFile("reports/", name), report);
    }

    /**
     * Generates documentation from to the specified file name with specified text documentation.
     *
     * @param name file name
     * @param text manual text
     * @throws IOException when the directory does not exist
     */
    public static void generateManual(String name, String text) throws IOException {
        writeToFile(openFile("manual/", name), text);
    }

    /**
     * Generates documentation from to the specified file name with specified text documentation.
     *
     * @param path - path to file
     * @param name - name of file
     * @throws IOException when the directory does not exist
     */
    private static File openFile(String path, String name) throws IOException {
        File file = new File(path + name + ".txt");
        file.getParentFile().mkdirs();
        file.createNewFile();
        return file;
    }

    /**
     * Write to file.
     *
     * @param file to write
     * @param text text to write to file
     * @throws IOException
     */
    private static void writeToFile(File file, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(file.getCanonicalPath());
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(text);
        printWriter.close();
    }


}
