public class Recursion {
  public static void main(String[] args){
    //int n = Integer.parseInt(args[0]);
    //System.out.println();
    //printAllWords(n);
    printNoDoubleLetterWords(3, new char[]{'a','z','f'});
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
}
