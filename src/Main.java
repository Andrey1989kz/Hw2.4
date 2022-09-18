public class Main {
    public static void main(String[] args) {

        String login = "fes_curren";
        String password = "787AAaa_3G";
        String confirmPassword = "787AAaa_3G";
        System.out.println(registration(login, password, confirmPassword));
    }

    public static boolean registration(String login, String password, String confirmPassword) {

        try {
            checkLongLogin(login);
            checkLongPassword(password);
            checkSymbolLogin(login);
            checkSymbolPassword(password);
            checkPassword(password, confirmPassword);
            checkOther(password, login);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        System.out.println("Регистрация прошла успешно");
        return true;
    }

    public static boolean checkLongLogin(String login) {
        if (login.length() <= 20) {
            return true;
        }
        throw new WrongLoginException("Слишком длинный login");
    }

    public static boolean checkSymbolLogin(String login) {
        if (login.matches("^[a-z\\d_]+$")) {
            return true;
        }
        throw new WrongLoginException("Не допустимые символы в login");
    }

    public static boolean checkLongPassword(String password) {
        if (password.length() < 20) {
            return true;
        }
        throw new WrongPasswordException("Слишком длинный пароль");
    }

    public static boolean checkSymbolPassword(String password) {
        if (password.matches("^\\w+$")) {
            return true;
        }
        throw new WrongPasswordException("Введены не допустимые символы password");
    }

    public static boolean checkPassword(String password, String confirmPassword) {
        if (password.length() == confirmPassword.length()) {
            return true;
        }
        throw new WrongPasswordException("password и confirmPassword не совпадают");
    }

    public static boolean checkOther(String password, String login) {
        if (password == null) {
            throw new WrongPasswordException("не заполнен password ");
        }
        if (login == null) {
            throw new WrongLoginException("не заполнен login");
        }
        return true;
    }
}
