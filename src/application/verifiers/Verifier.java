package application.verifiers;

import application.verifiers.checkers.Checker;

import javax.swing.*;
import java.awt.*;

public class Verifier extends InputVerifier {

    private JButton confirmButton;
    private Checker checker;

    public Verifier(JButton confirmButton, Checker checker) {
        this.confirmButton = confirmButton;
        this.checker = checker;
    }

    @Override
    public boolean verify(JComponent input) {
        JTextField textField = (JTextField) input;
        String value = textField.getText();
        boolean isCorrect = checker.check(value);
        confirmButton.setEnabled(isCorrect);
        if (!isCorrect) {
            textField.setBackground(Color.RED);
        }
        else {
            textField.setBackground(Color.WHITE);
        }
        return isCorrect;
    }
}
