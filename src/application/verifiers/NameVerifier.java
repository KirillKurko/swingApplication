package application.verifiers;

import javax.swing.*;
import java.awt.*;

public class NameVerifier extends InputVerifier {

    private JButton confirmButton;

    public NameVerifier(JButton confirmButton) {
        this.confirmButton = confirmButton;
    }

    @Override
    public boolean verify(JComponent input) {
        JTextField nameTextField = (JTextField) input;
        String name = nameTextField.getText();
        boolean isCorrect = name.matches("([A-Z][a-z]+ )([A-Z][a-z]+ )([A-Z][a-z]+)");
        confirmButton.setEnabled(isCorrect);
        if (!isCorrect) {
            nameTextField.setBackground(Color.RED);
        }
        else {
            nameTextField.setBackground(Color.WHITE);
        }
        return isCorrect;
    }
}
