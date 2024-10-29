import java.util.Arrays;
import java.util.Comparator;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSenten;
    private String longestWord;

    public TextData(String text) {
        //this.fileName = fileName;
        this.text = text;
        this.numberOfVowels = countVowels(text);
        this.numberOfConsonants = countConsonants(text);
        this.numberOfLetters = countLetters(text);
        this.numberOfSenten = countSentences(text);
        this.longestWord = findLongestWord(text);
    }
    private int countVowels(String text) {
        return (int) text.chars()
                .filter(c -> "AEIOUaeiou".indexOf(c) != -1)
                .count();
    }

    private int countConsonants(String text) {
        return (int) text.chars()
                .filter(c -> Character.isLetter(c) && "AEIOUaeiou".indexOf(c) == -1)
                .count();
    }

    private int countLetters(String text) {
        return (int) text.chars()
                .filter(Character::isLetter)
                .count();
    }

    private int countSentences(String text) {
        return text.split("[.!?]").length;
    }

    private String findLongestWord(String text) {
        return Arrays.stream(text.split("\\s+"))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }

    public void display() {
        System.out.println("Text: " + getText() +
                "\nFile Name: " + getFileName() +
                "\nNumber of Vowels: " + getNumberOfVowels() +
                "\nNumber of Consonants: " + getNumberOfConsonants() +
                "\nNumber of Letters: " + getNumberOfLetters() +
                "\nNumber of Sentences: " + getNumberOfSenten() +
                "\nLongest Word: " + getLongestWord());
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public void setNumberOfVowels(int numberOfVowels) {
        this.numberOfVowels = numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public void setNumberOfConsonants(int numberOfConsonants) {
        this.numberOfConsonants = numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public void setNumberOfLetters(int numberOfLetters) {
        this.numberOfLetters = numberOfLetters;
    }

    public int getNumberOfSenten() {
        return numberOfSenten;
    }

    public void setNumberOfSenten(int numberOfSenten) {
        this.numberOfSenten = numberOfSenten;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public void setLongestWord(String longestWord) {
        this.longestWord = longestWord;
    }
}
