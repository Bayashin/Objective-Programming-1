package jp.ac.ait.k21099;

import java.util.Scanner;

public class Kadai2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("パスワードの入力 > ");
        String password = in.nextLine();

        try{
            PasswordManager.validate(password);
        } catch (PasswordRulesViolationException e) {
            System.out.println("パスワードのルール基準を満たしていません" + e.getMessage());
        }

    }
}
