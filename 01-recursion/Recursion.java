public class Recursion {
  public static void main(String[] args){
    int n = Integer.parseInt(args[0]);
    System.out.println(fibIter(n,0,1));
    //printAllWords(n);
    //printNoDoubleLetterWords(3, new char[]{'a','z','f'});
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
  public static void printNoDoubleLetterWords(int length,char[] letters){
    printNoDoubleLetterWords(length,"",letters);
  }
  public static void printNoDoubleLetterWords(int length,String word,char[]letters){
    if (word.length() >= length){
      System.out.println(word);
    } else {
      for (int i = 0; i<letters.length; i++){
        if (word.length() == 0 || word.lastIndexOf(letters[i]) != word.length()-1){
          printNoDoubleLetterWords(length, word+letters[i], letters);
        }
      }
    }
  }
  public static String reverse(String s){
    if (s.length() <= 1) return s;
    return reverse(s.substring(1))+s.charAt(0);
  }
  public static long countNoDoubleLetterWords(int length,String word){
    long count = 0;
    if (word.length() >= length){
      count = 1;
    } else {
      for (char c = 'a'; c<='z'; c++){
        if (word.length() == 0 || word.lastIndexOf(c) != word.length()-1){
          count += countNoDoubleLetterWords(length, word+c);
        }
      }
    }
    return count;
  }
  public static double sqrt(double n) {
    if (n == 0) return 0;
    return sqrt(n, 1);
  }
  public static double sqrt(double n, double guess) {
    if (guess*guess < n*1.00001 && guess*guess > n*0.99999) return guess;
    return sqrt(n, ( n / guess + guess) / 2);
  }
  public int fibIter(int n, int f1, int f2){
    if (n == 0) return f1;
    if (n == 1) return f2;
    return fibIter(n-1, f2, f1+f2);
          //DO NOT call fibIter more than once
  }
}
