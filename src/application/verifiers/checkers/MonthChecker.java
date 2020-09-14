package application.verifiers.checkers;

public class MonthChecker extends Checker {

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
        int month = Integer.parseInt(value);
        return month > 0 && month <= 12;
    }
}

