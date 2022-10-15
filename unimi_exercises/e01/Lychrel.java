package unimi_exercises.e01;
import java.util.ArrayList;

public class Lychrel {
  static int lychrelNumbers(int numb) {
    String numberInString = Integer.toString(numb);
    String reversedString = "";
    for (int i = 0; i < numberInString.length(); i++) {
      reversedString = numberInString.charAt(i) + reversedString;
    }
    int newNumber = Integer.parseInt(reversedString);
    return newNumber+numb;
  }

  static boolean isPalindrome(int numb) {
    String numberInString = Integer.toString(numb);
    for (int i = 0; i < numberInString.length(); i++) {
      if (numberInString.charAt(i) != numberInString.charAt(numberInString.length()-i-1)) {
        return false;
      }
    }
    return true;
  }

  static ArrayList<Integer> findPalindrome(int arg) {
    ArrayList<Integer> integerList = new ArrayList<Integer>();
    int numb = arg;
    while (!isPalindrome(numb)) {
      integerList.add(numb);
      numb = lychrelNumbers(numb);
    }
    integerList.add(numb);
    return integerList;
  }

  static Integer[] createListIntegers(int numb) {
    Integer[] list = new Integer[0];
    list = (findPalindrome(numb).toArray(list));
    return list;
  }

  public static void main() {
    Integer[] list = createListIntegers(59);
    for (int j = 0; j<list.length; j++) {
      System.out.println(list[j]);
    }
    System.out.println("\n");
    list = new Integer[0];
    list = createListIntegers(1709);
    for (int i = 0; i<list.length; i++) {
      System.out.println(list[i]);
    }
    System.out.println("\n");
    list = new Integer[0];
    list = createListIntegers(6174);
    for (int j = 0; j<list.length; j++) {
      System.out.println(list[j]);
    }
  }
}