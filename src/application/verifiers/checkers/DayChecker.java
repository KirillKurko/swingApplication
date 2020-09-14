package application.verifiers.checkers;

public class DayChecker extends Checker {

    @Override
    public boolean check(String value) {
        if (value.length() == 0) {
            return false;
        }
        for (int i = 0; i < value.length(); ++i) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        int day = Integer.parseInt(value);
        return day > 0 && day <= 31;
    }
}
