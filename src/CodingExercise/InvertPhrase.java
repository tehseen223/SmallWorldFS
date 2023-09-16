package CodingExercise;

import java.util.regex.*;
import java.util.*;

public class InvertPhrase {
    public static String invertPhrase(String inputPhrase) {
        // Tokenize the input phrase into words and punctuation marks
        Pattern pattern = Pattern.compile("\\b\\w+(-\\w+)?\\b|[.,!?;]");
        Matcher matcher = pattern.matcher(inputPhrase);
        List<String> tokens = new ArrayList<>();
        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        // Reverse the order of the words and add a space between them
        Collections.reverse(tokens);

        // Reconstruct the inverted phrase
        StringBuilder invertedPhrase = new StringBuilder();
        boolean lastTokenWasWord = false; // Track if the last token was a word
        for (String token : tokens) {
            if (token.matches("[.,!?;]")) {
                // If the token is a punctuation mark, add it without a space
                invertedPhrase.append(token);
            } else {
                // If the token is a word, add it with a space (if the last token was also a word)
                if (lastTokenWasWord) {
                    invertedPhrase.append(" ");
                }
                invertedPhrase.append(token);
                lastTokenWasWord = true;
            }
        }

        return invertedPhrase.toString().trim(); // Trim to remove trailing space
    }

    public static void main(String[] args) {
        String input1 = "Good afternoon";
        String output1 = invertPhrase(input1);
        System.out.println("Input : " + input1 + " Output : " + output1);  // Output: "afternoon Good"

        String input2 = "Hello, how are you?";
        String output2 = invertPhrase(input2);
        System.out.println("Input : " + input2 + " Output : " + output2);  // Output: "?you are how, Hello"

        String input3 = "Are you twenty-one years old?";
        String output3 = invertPhrase(input3);
        System.out.println("Input : " + input3 + " Output : " + output3);  // Output: "?old years twenty-one you Are"
    }
}


