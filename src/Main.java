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
        } catch (WrongLoginException  | WrongPasswordException | NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        }
        System.out.println("Регистрация прошла успешно");
        return true;
    }

    public static boolean checkLongLogin(String login) {
        if (login.length() >= 20) {
            throw new WrongLoginException("login больше 20 символов");
        }
        return true;
    }

    public static boolean checkSymbolLogin(String login) {
        if (login.matches("\\w+")) {
            return true;
        }
        throw new WrongLoginException("Не допустимые символы в login");
    }

    public static boolean checkLongPassword(String password) {
        if (password.length() < 20) {
            return true;
        }
        System.out.println("password должен быть меньше 20 символов");
        return false;
    }

    public static boolean checkSymbolPassword(String password) {
        if (password.matches("\\w+")) {
            return true;
        }
        System.out.println("Введены не допустимые символы password");
        return false;
    }

    public static boolean checkPassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            return true;
        }
        throw new WrongPasswordException("password и confirmPassword не совпадают");
    }

    public static boolean checkOther(String password, String login) {
        if (password == null||login == null) {
            throw new NullPointerException("Заполните все строки");
        }
        return true;
    }
}
