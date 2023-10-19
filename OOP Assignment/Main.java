import java.util.Arrays;
import java.util.*;

class GameWord {
  // 11 - normal
  // 12 - double letter
  // 13 - triple letter
  // 21 - double word
  // 31 - triple word
  
  int [][]board={
      {31,11,11,12,11,11,11,31,11,11,11,12,11,11,31},
      {11,21,11,11,11,13,11,11,11,13,11,11,11,21,11},
      {11,11,21,11,11,11,21,11,12,11,11,11,21,11,11},
      {12,11,11,21,11,11,11,12,11,11,11,21,11,11,12},
      {11,11,11,11,21,11,11,11,11,11,21,11,11,11,11},
      {11,13,11,11,11,13,11,11,11,13,11,11,11,13,11},
      {11,11,12,11,11,11,12,11,12,11,11,11,12,11,11},
      {31,11,11,12,11,11,11,21,11,11,11,12,11,11,31},
      {11,11,12,11,11,11,12,11,21,11,11,11,12,11,11},
      {11,13,11,11,11,13,11,11,11,21,11,11,11,13,11},
      {11,11,11,11,21,11,11,11,11,11,21,11,11,11,11},
      {12,11,11,21,11,11,11,12,11,11,11,21,11,11,12},
      {11,11,21,11,11,11,12,11,12,11,11,11,21,11,11},
      {11,21,11,11,11,13,11,11,11,13,11,11,11,21,11},
      {31,11,11,12,11,11,11,31,11,11,11,12,11,11,31}
  };
  public static final int RIGHT = 1;
  public static final int DOWN = 2;

  private String contents;

  public GameWord(String c) {
    contents=c;
  }

  public String reverse() {
    String reversed = "";
    
    for(int j = 0; j < contents.length(); j++) {
     reversed = contents.charAt(j) + reversed;
    }
    return reversed;
  }

  public boolean anagram(String otherWord) {
    char[] contentWordChars = contents.toCharArray();
    char[] otherWordChars = otherWord.toCharArray();

    if(contentWordChars.length == otherWordChars.length){

      for(int i=0; i<contentWordChars.length; i++){
        contentWordChars[i] = Character.toUpperCase(contentWordChars[i]);
        otherWordChars[i] = Character.toUpperCase(contentWordChars[i]);
      }
      Arrays.sort(contentWordChars);
      Arrays.sort(otherWordChars);
      
      for(int i=0; i<contentWordChars.length; i++){
        if(contentWordChars[i] != otherWordChars[i]){
          return false;
        }
      }
      return true;
    }else{
      return false;
    }
  }

  public boolean anagram(GameWord otherWord) {
    char[] contentWordChars = contents.toCharArray();
    char[] otherWordChars = otherWord.toString().toCharArray();

    if(contentWordChars.length == otherWordChars.length){
      for(int i=0; i<contentWordChars.length; i++){
        contentWordChars[i] = Character.toUpperCase(contentWordChars[i]);
        otherWordChars[i] = Character.toUpperCase(contentWordChars[i]);
      }
      Arrays.sort(contentWordChars);
      Arrays.sort(otherWordChars);
      
      for(int i=0; i<contentWordChars.length; i++){
        if(contentWordChars[i] != otherWordChars[i]){
          return false;
        }
      }
      return true;
    }else{
      return false;
    }
  }

  public int pointValue(int x, int y, int direction) {
    int points=0;
    int fullWordMultiplier=1;
    int []letterWorth = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    
    for(int i=0; i<contents.length(); i++){
      points+=letterWorth[Character.toUpperCase(contents.charAt(i))-'A'] * (board[x+i*(direction==GameWord.RIGHT ? 1:0)][y+i*(direction==GameWord.DOWN ? 1:0)]%10);    
      fullWordMultiplier *= board[x+i*(direction==GameWord.RIGHT ? 1:0)][y+i*(direction==GameWord.DOWN ? 1:0)]/10;
    }
    System.out.println(fullWordMultiplier);
    return points*fullWordMultiplier;
  }

  public ArrayList<String> permutations() {
    permutationsCalc(contents, "");
    return perms;
  }

  private ArrayList <String> perms = new ArrayList<String>();
  private void permutationsCalc(String letters, String word){
    if(letters.length()<=0){
      perms.add(word);
      return;
    }
    for(int i=letters.length()-1; i>=0; i--){
      String tmp = letters.substring(0, i) + letters.substring(i + 1);
      permutationsCalc(tmp, word+letters.charAt(i));
    }
    return;
  }
  
  @Override
  public String toString(){
    return contents;
  }
  
}

class Main{
  public static void main(String[] args) {
    GameWord a = new GameWord("hello");
    System.out.println(a.reverse());
    System.out.println(a.anagram("elloh"));
    System.out.println(a.anagram("eloho"));

    GameWord b = new GameWord("elloh");
    System.out.println(a.anagram(b));
    System.out.println(a.pointValue(0,0,1));
    System.out.println(a.permutations());


    
  }
}
