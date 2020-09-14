package application.verifiers.checkers;

import application.verifiers.checkers.Checker;

public class MonthChecker extends Checker {

    @Override
    boolean check(String value) {
        for (int i = 0; i < value.length(); ++i) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        int month = Integer.parseInt(value);
        return month > 0 && month <= 12;
    }
}

