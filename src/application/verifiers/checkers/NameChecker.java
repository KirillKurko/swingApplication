package application.verifiers.checkers;

import application.verifiers.checkers.Checker;

public class NameChecker extends Checker {

    @Override
    boolean check(String value) {
        return value.matches("([A-Z][a-z]+ )([A-Z][a-z]+ )([A-Z][a-z]+)");
    }
}
