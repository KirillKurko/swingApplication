package application.verifiers.checkers;

import application.verifiers.checkers.Checker;

public class DayChecker extends Checker {

    @Override
    boolean check(String value) {
        for (int i = 0; i < value.length(); ++i) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        int day = Integer.parseInt(value);
        return day > 0 && day <= 31;
    }
}