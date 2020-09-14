package application.verifiers.checkers;

import application.verifiers.checkers.Checker;

import java.util.Calendar;

public class YearChecker extends Checker {

    @Override
    boolean check(String value) {
        for (int i = 0; i < value.length(); ++i) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        int year = Integer.parseInt(value);
        return year >= Calendar.getInstance().get(Calendar.YEAR);
    }
}
