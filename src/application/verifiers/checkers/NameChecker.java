package application.verifiers.checkers;

public class NameChecker extends Checker {

    @Override
    public boolean check(String value) {
        if (value.length() == 0) {
            return false;
        }
        return value.matches("([A-Z][a-z]+ )([A-Z][a-z]+ )([A-Z][a-z]+)");
    }
}
