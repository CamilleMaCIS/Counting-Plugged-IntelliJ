import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> punctuations = new ArrayList<>(Arrays.asList("!", ".", ",", "?", "\"", "/", "&", "(", ")", "@"));

        /**Test WordFileReader and WordProcessor 1*/
        WordFileReader wFR = new WordFileReader("Short-test.txt");
        System.out.println(wFR.getWordList());

        WordProcessor wP = new WordProcessor(wFR.getWordList(), punctuations);
        System.out.println(wP.getProcessedList());

        /**Test WordFileReader and WordProcessor 2*/
        WordFileReader wFR2 = new WordFileReader("WordProcessorTest.txt");
        System.out.println(wFR2.getWordList());

        WordProcessor wP2 = new WordProcessor(wFR2.getWordList(), punctuations);
        System.out.println(wP2.getProcessedList());

        /**Test WordCounter Constructor*/
        //ArrayList for commonWords
        WordFileReader commonWords = new WordFileReader("commonWords.txt");
        WordProcessor processedCommonWords = new WordProcessor(commonWords.getWordList(), punctuations);

        //ArrayList for words in file
        //change "textOne.txt" to "textTwo.txt" when testing other text file
        WordFileReader unprocessedFile = new WordFileReader("textOne.txt");
        WordProcessor processedWords = new WordProcessor(unprocessedFile.getWordList(), punctuations);

        WordCounter wC = new WordCounter(processedWords.getProcessedList(), processedCommonWords.getProcessedList());
        System.out.println(wC.getWordsExcludingCommonWords());
        System.out.println(wC.getFrequencyOfWords());

        //Parallel ArrayLists must have same size, output should be "true"
        System.out.println(wC.getWordsExcludingCommonWords().size() == wC.getFrequencyOfWords().size());

        /**Test Top Five Indexes*/
        System.out.println("Top Five Indexes:");

        ArrayList<ArrayList<Integer>> topFiveIndexes = wC.getTopFiveIndexes();
        for (ArrayList<Integer> aL : topFiveIndexes){
            for (Integer index : aL){
                System.out.print(index + " ");
            }
            System.out.println();
        }

        /**Test Top Five Frequencies*/
        System.out.println("Top Five Frequencies:");

        ArrayList<ArrayList<Integer>> topFiveFreq = wC.getTopFiveFrequencies();
        for (ArrayList<Integer> aL : topFiveFreq){
            for (Integer freq : aL){
                System.out.print(freq + " ");
            }
            System.out.println();
        }

        /**Test Top Five Words*/
        System.out.println("Top Five Words:");

        ArrayList<ArrayList<String>> topFiveWords = wC.getTopFiveWords();
        for (ArrayList<String> aL : topFiveWords){
            for (String word : aL){
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}