import java.util.*;

class Palidrome {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to confirm if palindrome : ");
        String inputWord = scanner.next();
        scanner.close();    
        for (int i = 0; i < inputWord.length(); i++) {
            stack.push(inputWord.charAt(i));
        }
        String outputWord = "";
        for (int i = 0; i < inputWord.length(); i++) {
            outputWord += stack.pop();
        }

        if (outputWord.equals(inputWord)) {
            System.out.println("\nThe string is a palindrome");
        } else {
            System.out.println("\nThe string is not a palindrome");
        }

        System.out.println("\nThe original string was : " + inputWord);
        System.out.println("The output string is : " + outputWord+"\n");
    
    }
}