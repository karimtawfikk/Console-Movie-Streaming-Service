package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static utils.Constants.DATA_DIRECTORY;
import static utils.Constants.REGULAR_PATH;


public class FileUtil {
    public static void deleteFileContentBeforeWritingNewOne(String filePath) //beymsa7 kol  el maktoob fl file
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            // No need to write anything; the file content will be deleted
            //we gowa el body fady fa da ma3nah eno msh hayktb wala hga hayms7 bs

        } catch (IOException e) {
            System.err.println("Error erasing content: " + e.getMessage());
        }
    }
}
