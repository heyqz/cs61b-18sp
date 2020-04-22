public class Palindrome {
    /** Task2 wordToDeque.
     * Transform String to Deque.
     * @param word
     * @return wordDeque(Deque)
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque= new ArrayDeque<>();
        for (int i = 0; i < word.length(); i+=1) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    /** Task3B isPalindrome.
     * check whether a given string is a palindrome.
     */
    public boolean isPalindrome(String word) {
        Deque wordDeque = wordToDeque(word);
        return isPalindromeHelper(wordDeque);
    }
    /* private helper for using recursion.*/
    private boolean isPalindromeHelper(Deque d) {
        if (d.size() <= 1) {
            return true;
        } else if (d.removeFirst() != d.removeLast()) {
            return false;
        } else {
            return isPalindromeHelper(d);
        }
    }
    /** Task 4 Generalized Palindrome and OffByOne.*/
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque wordDeque = wordToDeque(word);
        return isPalindromeHelper(wordDeque, cc);
    }

    private boolean isPalindromeHelper(Deque d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        } else if (!cc.equalChars((char)d.removeFirst(), (char)d.removeLast())) {
            return false;
        } else {
            return isPalindromeHelper(d, cc);
        }
    }


}
