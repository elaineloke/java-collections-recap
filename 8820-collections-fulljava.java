import java.util.ArrayList;
import java.util.Random;
import java.util.*;

/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    private Random randomNum;
    private ArrayList<Integer> list;
    private HashMap<String, Integer> wordFreq;
    private String lyrics;
    private String[] suits = {"Club","Diamond","Heart","Spade"};
    private String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private ArrayList<String> cards;
    private String[] deck = new String[52];

    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        list = new ArrayList<>();
        lyrics = "Sing, sing a song/Let the world sing along/" +
        "Sing of love there could be/Sing for you and for me/" +
        "Sing, sing a song/Make it simple to last/" +
        "Your whole life long/Don't worry that it's not/" +
        "Good enough for anyone/Else to hear/" +
        "Just sing, sing a song";

        wordFreq = new HashMap<>();
        setHashMap();        
    }

    /**
     * PART A - ARRAYLIST
     * Question 1 and 2
     */
    public ArrayList<Integer> numbers (int num, int max) 
    {
        for(int i=0; i < num; i++) {
            int randomInt = (int) (Math.random()* max + 1);
            list.add(randomInt);
            Collections.sort(list);
        }
        System.out.println(list);
        return list; 
    }

    /**
     * PART B - HASHMAP 
     * Question 3a
     */
    public void lyricWords() {
        lyrics = lyrics.replaceAll("\\p{Punct}", " ");
        int words = lyrics.split(" ").length;
        System.out.println(words);
    }

    public HashMap setHashMap(){
        lyrics = lyrics.replace("/", " ").replaceAll("\\p{Punct}", "");
        String[] words = lyrics.toLowerCase().split(" ");
        for(String word : words){
            int counter = wordFreq.getOrDefault(word, 0);
            wordFreq.put(word, counter + 1);
        }
        return wordFreq;
    }

    /**
     * PART B - HASHMAP
     * Question 3b
     */
    public void allWordFrequency() {
        for(String allWords : wordFreq.keySet()){
            System.out.println(allWords + ": " + wordFreq.get(allWords));
        }
        for(String eachWord : wordFreq.keySet()){
            if(wordFreq.get(eachWord) > 1){
                System.out.println("The word " + "<" + eachWord + ">" + " occurs " + wordFreq.get(eachWord) + " times");
            }
        }
    }

    /**
     * PART B - HASHMAP
     * Question 3c
     */
    public void mostFreqWord(){
        int max = Collections.max(wordFreq.values());
        for(Map.Entry<String, Integer> entry : wordFreq.entrySet()){
            if(entry.getValue()==max){
                System.out.println(entry.getKey());
            } 
        }
    }

    /**
     * PART C - ARRAY
     * Question 4a
     */
    /*public void cardsArrayList(){
        List<String> cards = new ArrayList<String>();
        for (int i = 0; i<suits.length; i++) {
            for(int j=0; j<ranks.length; j++){
                cards.add(suits[i] + " " + ranks[j]);
            }
        }  
        //Convert cards ArrayList to deck Array;
        String[] deck = cards.toArray(new String[0]);
        //Print deck Array
        for(String s : deck){
            System.out.println(s);
        }
    }*/

    /**
     * PART C - ARRAY
     * Question 4a
     */
    public String[] cardsArrayAgain(){ 
        for(int i=0; i<ranks.length; i++){
            for(int j=0; j<suits.length;j++){
                deck[(ranks.length*j + i)] = suits[j] + " " + ranks[i];
            }
        }
        return deck;
    }

    public void printDeck(){
        String[] decks = cardsArrayAgain();
        for(int index = 0; index < decks.length; index++) {
            System.out.println(decks[index]);
        }
    }

    /**
     * PART C - ARRAY
     * Question 4b
     */
    public void shuffleDeck(){
        Random random = new Random();
        String[] mixed = new String[52];
        String[] deck = cardsArrayAgain();
        HashSet<Integer>existingIndex = new HashSet<>();
        for(int i=0; i < deck.length; i++){
            int randomInt = random.nextInt(deck.length);
            while(existingIndex.contains(randomInt)){
                randomInt = random.nextInt(deck.length);
            }
            existingIndex.add(randomInt);
            mixed[i] = deck[randomInt];
        }
        for(String s : mixed){
            System.out.println(s);
        }
    }
}


