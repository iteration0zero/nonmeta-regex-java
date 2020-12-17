import java.util.Scanner;

public class NonmetaRegex {

    public static String getMatches(String input, String regex) {

        int regexPos = 0;
        String output = "";

        String currentMatch = "";

        int i = 0;
        while(i < input.length()) {

            if(input.charAt(i) == regex.charAt(regexPos)) {
                currentMatch += i + " ";
                if(regexPos == regex.length() - 1) {
                    output += currentMatch;
                    currentMatch = "";
                    regexPos = 0;
                }
                else {
                    regexPos++;
                }
                i++;
            }
            else {
                if (regexPos > 0) {
                    currentMatch = "";
                    regexPos = 0;
                }
                else {
                    i++;
                }
            }
        }

        return output;
    }

    public static String maskWithMatches(String input, String matches, String regex) {
        int regexPos = 0;
        String output = "";

        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == regex.charAt(regexPos)) {
                output += input.charAt(i);
                if (regexPos == regex.length() - 1) {
                    regexPos = 0;
                }
                else {
                    regexPos++;
                }
            }
            else {
                output += "_";
                regexPos = 0;
            }
        }

        return output;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string: ");
        String input = scanner.nextLine();
        System.out.println("Regex: ");
        String regex = scanner.nextLine();

        System.out.println(maskWithMatches(input, getMatches(input, regex), regex));

    }

}
