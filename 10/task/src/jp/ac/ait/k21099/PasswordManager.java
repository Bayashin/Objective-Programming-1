package jp.ac.ait.k21099;

import java.util.*;

public class PasswordManager {
    public static boolean validate(String password) throws PasswordRulesViolationException {
        //入力可能な記号をリストで保持
        List<Character> symbolList = Arrays.asList(',', '.', '+', '-', '*', '/', '=', '_', '#', '!', '?', '@', ' ');
        //使ってはいけない文字列をリストで保持
        Set<String> unusableStringSet = new HashSet<>(Arrays.asList("password", "p@ssw0rd", "p@55w0rd", "qwerty", "asdfgh", "zxcvbn", "abcdef", "123456"));

        if (password.length() > 128 || password.length() < 16) throw new PasswordRulesViolationException("Please make sure that the number of characters is between 16 and 128.");

       if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*d).{16,128}")){
           throw new PasswordRulesViolationException("Password is weak.");
       }

        boolean judge = false;
        for (int i = 0; i < password.length(); i++) {
            for (char symbol : symbolList) {
                if (Objects.equals(password.charAt(i), symbol)) {
                    judge = true;
                    break;
                }
            }
            if (judge) break;
        }
        if (!judge) throw new PasswordRulesViolationException("Include the symbols");

        for (String str: unusableStringSet) {
            if (password.toLowerCase().contains(str)){
                throw new PasswordRulesViolationException("Contains strings that cannot be used");
            }
        }
        return true;
    }
}
