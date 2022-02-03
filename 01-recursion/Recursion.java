public class Recursion {
  public static void main(String[] args){
    //int n = Integer.parseInt(args[0]);
    //System.out.println();
    //printAllWords(n);
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
  /*Print all words that are made of the characters in the array of letters.
  *There may not be consecutive equal letters, so:
  *aax is not allowed, but axa is allowed.
  *@param length : the length of the words that are to be printed
          *@param letters: the letters you should be using,
          *@precondition: letters contains at least 2 characters, and has no duplicates.
          */
  public static void printNoDoubleLetterWords(int length,char[] letters){
    printNoDoubleLetterWords(length,"",letters);
  }

          /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
          *aax is not allowed, but axa is allowed.
          *@param length : either how many more letters need to be
          *@param word   : the partial word so far.
          *@param letters: the letters you should be using
          */
  public static void printNoDoubleLetterWords(int length,String word,char[]letters){
    if (word.length() >= length){
      System.out.println(word);
    } else {
      for (int i = 0; i<letters.length; i++){
        if (word.lastIndexOf(letters[i]) != words.length()-1){
          printNoDoubleLetterWords(length, word+letters[i], letters);
        }
      }
    }
  }
}
