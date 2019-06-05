package Rain.HelperClasses;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyCombination.Modifier;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;

import java.util.Optional;

public class Validation {
    public Validation() {
    }

    //Performs input validation on fields that should only have numbers
    public static void numericField(final TextField field) {
        field.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("[\\d-]")) {
                field.setText(newValue.replaceAll("[^\\d-]", ""));
            }
        });
    }

    //Performs input validation on spinners that should only have numbers
    //Also performs increments and decrements on spinners when arrow keys are pressed
    public static void numericSpinner(final Spinner spinner) {
        spinner.getEditor().textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                if (!newValue.matches("[\\d-]")) {
                    spinner.getEditor().setText(newValue.replaceAll("[^\\d-]", ""));
                }
        });
        final KeyCombination arrow = new KeyCodeCombination(KeyCode.UP, new Modifier[0]);
        final KeyCombination arrowD = new KeyCodeCombination(KeyCode.DOWN, new Modifier[0]);
        spinner.getEditor().setOnKeyPressed((KeyEvent event) -> {
                if (arrow.match(event)) {
                    spinner.increment();
                } else if (arrowD.match(event)) {
                    spinner.decrement();
                }
        });
    }

    //If current health is set above max health, prompt user if they want to increase max health. Thi is
    //implemented just in-case the user levels up their health in the normal health field instead of max health field
    public static void maxHPPrompt(final Spinner health, final Spinner maxHealth) {
        health.getEditor().focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            int maxHitPoints = Integer.parseInt(maxHealth.getEditor().getText());
            int currentHitPoints = Integer.parseInt(health.getEditor().getText());
            if (currentHitPoints > maxHitPoints) {
                Alert changeHitPoints = new Alert(AlertType.CONFIRMATION);
                changeHitPoints.setHeaderText("Would you like to change your max health?");
                    ButtonType yes = new ButtonType("Yes");
                    ButtonType no = new ButtonType("No");
                changeHitPoints.getButtonTypes().clear();
                changeHitPoints.getButtonTypes().addAll(new ButtonType[]{yes, no});
                changeHitPoints.initModality(Modality.APPLICATION_MODAL);
                Optional<ButtonType> options = changeHitPoints.showAndWait();
                    if (options.get() == yes) {
                        maxHealth.getEditor().setText(health.getEditor().getText());
                    } else if (options.get() == no) {
                        health.getEditor().setText(maxHealth.getEditor().getText());
                    }
                }
        });
    }
}
