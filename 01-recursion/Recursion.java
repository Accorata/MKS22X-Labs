public class Recursion {
  public static void main(String[] args){
    int n = Integer.parseInt(args[0]);
    //System.out.println();
    printAllWords(n);
  }
  public static void printAllWords(int length){
    printAllWords(length,"");
  }
  public static void printAllWords(int length,String word){
    if (word.length() >= length){
      System.out.println(word);
    } else {
      for (char c = 'a'; c<='e'; c++){
        printAllWords(length, word+c);
      }
    }
  }
}
