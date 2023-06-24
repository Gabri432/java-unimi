package random_programs;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * This class provides a series of methods to verify if a word is a typo. <br /><br />
 * It also returns the most similar words in the vocabulary to the typo.
 */
public class TypoChecker {
    private final String typo = "bice"; //Typo Example

    private final Set<String> vocabulary; //Using a vocabulary as set of words to compare.

    //Representation Invariant: 'vocabulary' cannot be a null or empty set.
    //Abstraction Function: 'vocabulary' is a Set of String objects.

    /**
     * Generates a vocabulary to use for the comparisons between typo and possible words.
     */
    public TypoChecker() {
        Set<String> mySet = new HashSet<>();
        mySet.add("animal"); //Adding some words
        mySet.add("house");
        mySet.add("mother");
        mySet.add("door");
        mySet.add("bread");
        mySet.add("rice");
        mySet.add("ball");
        mySet.add("hamburger");
        mySet.add("biology");
        this.vocabulary = mySet;
    }

    /**
     * Generates a vocabulary to use for the comparisons between typo and possible words.
     * @throws NullPointerException if vocabulary is null or contains null strings.
     * @throws IllegalArgumentException if vocabulary contains any empty string.
     */
    public TypoChecker(Set<String> vocabulary) {
        for (var word : vocabulary) {
            if (word.isEmpty()) throw new IllegalArgumentException("Vocabulary cannot contain any empty string.");
        }
        this.vocabulary = Set.copyOf(vocabulary);
    }

    /**
     * Prints the entire vocabulary.
     */
    public void printVocabulary() {
        System.out.println(vocabulary);
    }

    /**
     * Returns the set of words that are similar in length to the given one.
     * @param typo a String representing the typo the programs wants to compare.
     * @return a Set of strings representing all the words from the vocabulary that have same length of typo. <br /><br />
     * That is, if their lengths x is in range: typo.length-1 <= x <= typo.length+1.
     * @throws NullPointerException if typo is null.
     * @throws IllegalArgumentException if typo is an empty string.
     */
    public Set<String> sameLengthWords(String typo) {
        Set<String> answer = new HashSet<>();
        checkTypoValidity(typo);
        for (var word : vocabulary) {
            if (word.length() <= typo.length() + 1 && word.length() >= typo.length() - 1 ) answer.add(word);
        }
        return answer;
    }

    /**
     * Returns the set of words that share the same start to the given one.
     * @param typo a String representing the typo the programs wants to compare.
     * @return a Set of strings representing all the words from the vocabulary that have beginning. <br /><br />
     * That is, those words starts with the same letters of the typo.
     * @throws NullPointerException if typo is null.
     * @throws IllegalArgumentException if typo is an empty string.
     */
    public Set<String> compareBeginnings(String typo) {
        Set<String> answer = new HashSet<>();
        checkTypoValidity(typo);
        for (var word : vocabulary) {
            if (word.startsWith(typo) || typo.startsWith(word)) {
                answer.add(word);
                continue;
            }
            if (typo.charAt(0) == word.charAt(0)) answer.add(word);
        }
        return answer;
    }

    /**
     * Returns the set of words that share the same end to the given one.
     * @param typo a String representing the typo the programs wants to compare.
     * @return a Set of strings representing all the words from the vocabulary that have ending. <br /><br />
     * That is, those words ends with the same letters of the typo.
     * @throws NullPointerException if typo is null.
     * @throws IllegalArgumentException if typo is an empty string.
     */
    public Set<String> compareEndings(String typo) {
        Set<String> answer = new HashSet<>();
        checkTypoValidity(typo);
        for (var word : vocabulary) {
            if (word.endsWith(typo) || typo.endsWith(word)) {
                answer.add(word);
                continue;
            }
            if (typo.charAt(typo.length()-1) == word.charAt(word.length()-1)) answer.add(word);
        }
        return answer;
    }

    /**
     * Returns the set of words that are the most similar to the given typo.
     * @param typo a String representing the typo the program wants to compare.
     * @return the set of words that are the most similar to the given typo. <br /><br />
     * That is, the set of words that share similiar length, beginning and ending.
     * if no word shares the same beginning or ending it will return the set of words with similar length.
     * If no word with same length was found then it returns an empty set. 
     * @throws NullPointerException if typo is null.
     * @throws IllegalArgumentException if typo is an empty string.
     */
    public Set<String> bestMatches(String typo) {
        Set<String> closeLength = sameLengthWords(typo);
        if (closeLength.isEmpty()) return new HashSet<>();
        Set<String> closeBeginnings = compareBeginnings(typo);
        Set<String> closeEndings = compareEndings(typo);
        if (closeBeginnings.isEmpty() && closeEndings.isEmpty()) return closeLength; 
        Set<String> sameLengthAndBegin = findMatches(closeLength, closeBeginnings);
        Set<String> sameLengthAndEnd = findMatches(closeLength, closeEndings);
        Set<String> answer = findMatches(sameLengthAndBegin, sameLengthAndEnd);
        if (answer.isEmpty()) {
            answer.addAll(sameLengthAndBegin);
            answer.addAll(sameLengthAndEnd);
        }
        return answer;
    }

    /**
     * Returns the set of strings in common among the two sets.
     * @param set1 a set of strings.
     * @param set2 a set of strings.
     * @return the set of strings in commong among the two sets.
     * @throws NullPointerException if either one of the two sets is null.
     * @throws IllegalArgumentException if either one of the two sets is empty.
     */
    private Set<String> findMatches(Set<String> set1, Set<String> set2) {
        Objects.requireNonNull(set1, "Cannot have null sets.");
        Objects.requireNonNull(set2, "Cannot have null sets.");
        if (set1.isEmpty() || set2.isEmpty()) throw new IllegalArgumentException("Cannot have empty sets.");
        Set<String> answer = new HashSet<>();
        Set<String> shortestSet = (set1.size() <= set2.size()) ? set1 : set2;
        Set<String> longestSet = !(set1.size() <= set2.size()) ? set1 : set2;
        for (var word : shortestSet) {
            if (longestSet.contains(word)) answer.add(word);
        }
        return answer;
    }

    /**
     * Checks if the typo is a null or empty string.
     * @param typo a String representing the typo to fix.
     * @throws NullPointerException if typo is null.
     * @throws IllegalArgumentException if typo is an empty string.
     */
    private void checkTypoValidity(String typo) {
        if (Objects.requireNonNull(typo, "typo cannot be null").isEmpty()) throw new IllegalArgumentException("Cannot use empty strings!");
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("The typo: "+typo + "\n");
        s.append("Words with the same (or close) length: " + sameLengthWords(typo) + "\n");
        s.append("Words with the same beginning: "+ compareBeginnings(typo) + "\n");
        s.append("Words with the same ending: "+compareEndings(typo) + "\n");
        s.append("Best matches: "+ bestMatches(typo) + "\n");
        return s.toString();
    }
    
}
