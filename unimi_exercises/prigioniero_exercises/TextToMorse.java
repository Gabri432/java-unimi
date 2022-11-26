package unimi_exercises.prigioniero_exercises;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class TextToMorse {

    public static HashMap<String, String> generateHashMap() {
        HashMap<String, String> morseAphabetMap = new HashMap<String, String>();
        morseAphabetMap.put("A", ".-");
        morseAphabetMap.put("B", "-...");
        morseAphabetMap.put("C", "-.-.");
        morseAphabetMap.put("D", "-..");
        morseAphabetMap.put("E", ".");
        morseAphabetMap.put("F", "..-.");
        morseAphabetMap.put("G", "--.");
        morseAphabetMap.put("H", "....");
        morseAphabetMap.put("I", "..");
        morseAphabetMap.put("J", ".---");
        morseAphabetMap.put("K", "-.-");
        morseAphabetMap.put("L", ".-..");
        morseAphabetMap.put("M", "--");
        morseAphabetMap.put("N", "-.");
        morseAphabetMap.put("O", "---");
        morseAphabetMap.put("P", ".--.");
        morseAphabetMap.put("Q", "--.-");
        morseAphabetMap.put("R", ".-.");
        morseAphabetMap.put("S", "...");
        morseAphabetMap.put("T", "-");
        morseAphabetMap.put("U", "..-");
        morseAphabetMap.put("V", "...-");
        morseAphabetMap.put("W", ".--");
        morseAphabetMap.put("X", "-..-");
        morseAphabetMap.put("Y", "-.--");
        morseAphabetMap.put("Z", "--..");
        morseAphabetMap.put("\s", "");
        return morseAphabetMap;
    }

    public static String removeNonAlphabeticCharacters(String line) {
        return line.replaceAll("[^a-zA-Z ]", "").toUpperCase(); //keeping letters (and spaces) only and converting them in upper case.
    }

    public static String toMorse(String exp) {
        char[] chars = exp.toCharArray();
        HashMap<String, String> morseAlhpabet = generateHashMap();
        String result = "";
        for (char c : chars) {
            result += morseAlhpabet.get(String.valueOf(c)) + " "; //each letter is space-separated.
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        ArrayList<String> elements = new ArrayList<String>(); //this will be an arrayList of only uppercased alphabetic characters strings.
        while (myObj.hasNextLine()) {
            elements.add(removeNonAlphabeticCharacters((myObj.nextLine()))); 
        }
        myObj.close();
        for (String el : elements) {
            System.out.print(toMorse(el) + "");
        }
    }
    
}
