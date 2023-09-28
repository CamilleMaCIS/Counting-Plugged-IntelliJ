import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class WordFileReader {
    //the WordFileReader class takes in a file name, reads the file,
    //and returns an ArrayList that separates the file by spaces: " "

    //property: an ArrayList that contains all words in the file
    private ArrayList<String> wordList = new ArrayList<>();

    //constructor
    public WordFileReader(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner s = new Scanner(file);
        while(s.hasNext()){
            String word = s.next();
            wordList.add(word);
        }
        s.close();
    }

    public ArrayList<String> getWordList() {
        return wordList;
    }
}

