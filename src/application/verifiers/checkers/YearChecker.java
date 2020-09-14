package application.verifiers.checkers;

import java.util.Calendar;

public class YearChecker extends Checker {

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
        int year = Integer.parseInt(value);
        return year >= Calendar.getInstance().get(Calendar.YEAR);
    }
}
