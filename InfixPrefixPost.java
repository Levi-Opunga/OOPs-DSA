import java.util.*;

public class InfixPrefixPost {
    public static void main(String[] args) {
        run();
    }

    private static ArrayList<String> logs = new ArrayList<>();
    private static int option;

    private static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What kind of operation do you want to do?");
        System.out.println(
                "1.Convert infix to post\n2.Convert infix to prefix\n3.Convert infix to both prefix and post and postfix");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input only [1,2,3] are allowed retry:");
            scanner.next();
        }
        option = scanner.nextInt();
        if (option > 3 || option < 0) {
            System.out.println("Invalid input only [1,2,3] are allowed");
            run();
        }
        System.out.println("Enter the infix statement: ");

        var infixString = scanner.next();
        if (option == 1) {

            var postFixString = PostFixConverter(infixString);
            if (!logs.isEmpty()) {
                System.out.println("\nLogs");
                logs.forEach(System.out::println);
            }
            
            System.out.println("\n\nInfix expression: " + infixString);
            System.out.println("Postfix: " + postFixString);
        } else if (option == 2) {

            var preFixString = PreFixConverter(infixString);
            if (!logs.isEmpty()) {
                System.out.println("\nLogs");
                logs.forEach(System.out::println);
            }

            System.out.println("\n\nInfix expression: " + infixString);
            System.out.println("Prefix: " + preFixString);
        } else {
            var postFixString = PostFixConverter(infixString);
            if (!logs.isEmpty()) {
                System.out.println("\nLogs");
                logs.forEach(System.out::println);
            }

            System.out.println("\n\nInfix expression: " + infixString);
            System.out.println("Postfix: " + postFixString +"\n");

            var preFixString = PreFixConverter(infixString);
            if (!logs.isEmpty()) {
                System.out.println("\nLogs");
                logs.forEach(System.out::println);
            }

            System.out.println("\n\nInfix expression: " + infixString);
            System.out.println("Prefix: " + preFixString);

        }

        scanner.close();

    }

    private static String PostFixConverter(String infix) {
        String postFixString = new String("");
        Stack<Character> postFixStack = new Stack<Character>();
        for (int i = 0; i < infix.length(); i++) {
            Character c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postFixString += c;
            } else if (c == '(') {
                postFixStack.push(c);
            } else if (c == ')') {
                // handles
                if (postFixStack.isEmpty() || !postFixStack.contains('(')) {
                    logs.add("PostfixLog: input contained a misplaced closing bracket [)] at element " + (i + 1)
                            + "that was removed");
                    continue;
                }
                while (!postFixStack.isEmpty() && postFixStack.peek() != '(') {
                    postFixString += postFixStack.pop();
                }

                postFixStack.pop();
            } else {
                while (!postFixStack.isEmpty() && checkPresedence(c) <= checkPresedence(postFixStack.peek())) {
                    postFixString += postFixStack.pop();
                }
                postFixStack.push(c);
            }

        }
        while (!postFixStack.isEmpty()) {
            if (postFixStack.peek() == '(' || postFixStack.peek() == ')') {
                System.out.println("Postfix Error : Invalid Epression with most likel an unclosed parentheses or unopened. please retry\n");
                run();
            }
            ;
            postFixString += postFixStack.pop();
        }

        return postFixString;
    }

    private static int checkPresedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }

        return -1;
    }

    private static String PreFixConverter(String infix) {
        String preFixString = new String("");
        Stack<Character> preFixStack = new Stack<Character>();

        String reverseInfix = new StringBuilder(infix).reverse().toString();

        for (int i = 0; i < reverseInfix.length(); i++) {
            Character c = reverseInfix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                preFixString += c;
            } else if (c == ')') {
                preFixStack.push(c);
            } else if (c == '(') {
                if (preFixStack.isEmpty() || !preFixStack.contains(')')) {
                    logs.add("PrefixLog: input contained a misplaced opening bracket [)] at element " + (i + 1)
                            + "that was removed");
                    continue;
                }
                while (!preFixStack.isEmpty() && preFixStack.peek() != ')') {
                    preFixString += preFixStack.pop();
                }
                if (preFixStack.isEmpty()) {
                    continue;
                }
                preFixStack.pop();
            } else {
                while (!preFixStack.isEmpty() && checkPresedence(c) < checkPresedence(preFixStack.peek())) {
                    preFixString += preFixStack.pop();
                }
                preFixStack.push(c);
            }

        }
        while (!preFixStack.isEmpty()) {
            if (preFixStack.peek() == '(' || preFixStack.peek() == ')') {
                System.out.println("\n Prefix Errror: Invalid Epression with most likel an unclosed or unopened parentheses. please retry\n");
                run();
            }
            preFixString += preFixStack.pop();
        }
        preFixString = new StringBuilder(preFixString).reverse().toString();
        return preFixString;
    }

}
