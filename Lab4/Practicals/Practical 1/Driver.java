public class Driver {

    public static void main(String[] args) {

        String[] passwords = {
                "abc",
                "Password",
                "Password1",
                "Abcd1234!"
        };

        for (String pw : passwords) {

            System.out.println("Password: " + pw);
            System.out.println("Length >= 8: " + PasswordChecker.hasLength(pw));
            System.out.println("Has Uppercase: " + PasswordChecker.hasUpperCase(pw));
            System.out.println("Has Digit: " + PasswordChecker.hasDigit(pw));
            System.out.println("Has Special Character: " + PasswordChecker.hasSpecialCharacter(pw));
            System.out.println("Strength: " + PasswordChecker.strength(pw));
            System.out.println("---------------------------------");

        }
    }
}