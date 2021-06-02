package com.mycompany.testpassword;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pablo
 */
public class PasswordTest {

    public static void main(String[] args) {
        String word = password();
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\"\\W\"g]).{8,20}$";
        boolean validPassword = isValidPassword(word, regex);
        System.out.println(validPassword);
    }

    public boolean testUpperCase() {
        String word = password();
        return !word.equals(word.toLowerCase());
    }


    public boolean testLowerCase() {
        String word = password();
        return !word.equals(word.toUpperCase());
    }


    public boolean testNumber() {
        String word = password();
        char[] wordNumber = word.toCharArray();
        for (int i = 0; i < wordNumber.length; i++) {
            if (Character.isDigit(wordNumber[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean testSpecialCharacte() {
        String word = password();
        String regex = "^(?=.*[\"\\W\"g])$";
        boolean specialCharacter = isValidPassword(word, regex);
        return specialCharacter;
    }


    public boolean testLongerPass() {
        String word = password();
        int number = word.length();
        return number >= 8;
    }

    public boolean testShorterPass() {
        String word = password();
        int number = word.length();
        return number <= 20;
    }

    public boolean testNoSpaces() {
        String word = password();
        return !word.contains(" ");
    }

    public static boolean isValidPassword(String password, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static String password() {
        Scanner input = new Scanner(System.in);
        System.out.print("Give me the password: ");
        String password = String.valueOf(input.nextLine());
        return password;
    }
}
