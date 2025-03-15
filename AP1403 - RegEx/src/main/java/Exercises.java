import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {
    public boolean validateEmail(String email) {
        Pattern ptrn = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9]+([.-][a-zA-Z0-9]+)*\\.[a-zA-Z]{2,}$");
        Matcher matcher = ptrn.matcher(email);
        return matcher.matches();
    }
    
    public String findDate(String string) {
        String regex = "\\b(0?[1-9]|[12]\\d|3[01])[/-](0?[1-9]|1[0-2])[/-](\\d{4})\\b" // (DD/MM/YYYY)
                     + "|\\b(0?[1-9]|1[0-2])[/-](0?[1-9]|[12]\\d|3[01])[/-](\\d{4})\\b" // (MM/DD/YYYY)
                     + "|\\b(\\d{4})[/-](0[1-9]|1[0-2])[/-](0[1-9]|[12]\\d|3[01])\\b";

        Pattern ptrn = Pattern.compile(regex);
        Matcher matcher = ptrn.matcher(string);

        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
    
    public int findValidPasswords(String input) {
        if (input == null || input.trim().isEmpty()) return 0;
        int validCount = 0;
        String[] passwords = input.split("\\s+");
        String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[^\\s]{8,}";
        Pattern compiledPattern = Pattern.compile(regex);
        for (String p : passwords) {
            if (compiledPattern.matcher(p).matches()) {
                validCount++;
            }
        }
        return validCount;
    }
    
    public List<String> findPalindromes(String string) {
        List<String> palindromes = new ArrayList<>();
        String[] words = string.split("[^a-zA-Z0-9]+");

        for (String word : words) {
            if (word.length() >= 3) {
                String lowerWord = word.toLowerCase();
                String reversed = "";
                for (int i = lowerWord.length() - 1; i >= 0; i--) {
                    reversed += lowerWord.charAt(i);
                }
                
                if (lowerWord.equals(reversed)) {
                    palindromes.add(word);
                }
            }
        }

        return palindromes;
    }
    public static void main(String[] args) {
        // you can test your code here
    }
}