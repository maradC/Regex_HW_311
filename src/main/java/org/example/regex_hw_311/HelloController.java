package org.example.regex_hw_311;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class HelloController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField dobField;
    @FXML
    private TextField zipCodeField;
    @FXML
    private Button addButton;
    @FXML
    private Label validationMessage;

    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z]{2,25}$");
    private static final Pattern DOB_PATTERN = Pattern.compile("^(0[1-9]|1[0-2])/([0-2][0-9]|3[01])/\\d{4}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@farmingdale\\.edu$");
    private static final Pattern ZIP_PATTERN = Pattern.compile("^\\d{5}$");
    
    @FXML
    public void initialize() {
        addButton.setDisable(true);
        setupListeners();

    }
    private void setupListeners() {
        firstNameField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) validateFirstName();
        });

        lastNameField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) validateLastName();
        });

        emailField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) validateEmail();
        });

        dobField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) validateDOB();
        });

        zipCodeField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) validateZipCode();
        });
    }

    private void validateFirstName() {
        String firstName = firstNameField.getText();
        if (!NAME_PATTERN.matcher(firstName).matches()) {
            validationMessage.setText("Invalid First Name. It must be 2-25 characters long.");
            addButton.setDisable(true);
        } else {
            validationMessage.setText("");
            checkAllFields();
        }
    }

    private void validateLastName() {
        String lastName = lastNameField.getText();
        if (!NAME_PATTERN.matcher(lastName).matches()) {
            validationMessage.setText("Invalid Last Name. It must be 2-25 characters long.");
            addButton.setDisable(true);
        } else {
            validationMessage.setText("");
            checkAllFields();
        }
    }

    private void validateEmail() {
        String email = emailField.getText();
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            validationMessage.setText("Invalid Email. It must be a valid Farmingdale email.");
            addButton.setDisable(true);
        } else {
            validationMessage.setText("");
            checkAllFields();
        }
    }

    private void validateDOB() {
        String dob = dobField.getText();
        if (!DOB_PATTERN.matcher(dob).matches()) {
            validationMessage.setText("Invalid Date of Birth. Use the format MM/DD/YYYY.");
            addButton.setDisable(true);
        } else {
            validationMessage.setText("");
            checkAllFields();
        }
    }

    private void validateZipCode() {
        String zipCode = zipCodeField.getText();
        if (!ZIP_PATTERN.matcher(zipCode).matches()) {
            validationMessage.setText("Invalid Zip Code. It must be a 5-digit number.");
            addButton.setDisable(true);
        } else {
            validationMessage.setText("");
            checkAllFields();
        }
    }

    private void checkAllFields() {
        boolean allValid = NAME_PATTERN.matcher(firstNameField.getText()).matches() &&
                NAME_PATTERN.matcher(lastNameField.getText()).matches() &&
                EMAIL_PATTERN.matcher(emailField.getText()).matches() &&
                DOB_PATTERN.matcher(dobField.getText()).matches() &&
                ZIP_PATTERN.matcher(zipCodeField.getText()).matches();

        addButton.setDisable(!allValid); // Enable the button only if all fields are valid
    }

    @FXML
    private void addUser() {
        // Clear validation messages and perform action to switch to a new UI
        validationMessage.setText("Registration successful!");
        // Logic to load the new UI goes here
    }
}