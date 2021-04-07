import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
/*
Exercise 3
    Write a program that reads a file with n number of strings separated by line breaks.
    The program determines and prints how many words are in the file.
 */

public class Exercise3 {
    public static void main(String[] args) throws IOException {

        ArrayList<String> wordList = new ArrayList<String>(Files.readAllLines(Paths.get("src/Vuffelivov")));
        int numberOfWords = wordList.size();

        System.out.println("There are " + numberOfWords + " words in the document.");

    }
}
