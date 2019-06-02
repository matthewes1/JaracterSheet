package Rain.HelperClasses;

import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCombination.Modifier;
import javafx.stage.Modality;

public class Validation {
    public Validation() {
    }

    public static void numericField(final TextField field) {
        field.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("[\\d-]")) {
                    field.setText(newValue.replaceAll("[^\\d-]", ""));
                }

            }
        });
    }

    public static void numericSpinner(final Spinner spin) {
        spin.getEditor().textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("[\\d-]")) {
                    spin.getEditor().setText(newValue.replaceAll("[^\\d-]", ""));
                }

            }
        });
        final KeyCombination arrow = new KeyCodeCombination(KeyCode.UP, new Modifier[0]);
        final KeyCombination arrowD = new KeyCodeCombination(KeyCode.DOWN, new Modifier[0]);
        spin.getEditor().setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (arrow.match(event)) {
                    spin.increment();
                } else if (arrowD.match(event)) {
                    spin.decrement();
                }

            }
        });
    }

    public static void maxHPPrompt(final Spinner hp, final Spinner max) {
        hp.getEditor().focusedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                int x = Integer.parseInt(max.getEditor().getText());
                int s = Integer.parseInt(hp.getEditor().getText());
                if (s > x) {
                    Alert changeHP = new Alert(AlertType.CONFIRMATION);
                    changeHP.setHeaderText("Would you like to change your max health?");
                    ButtonType yes = new ButtonType("Yes");
                    ButtonType no = new ButtonType("No");
                    changeHP.getButtonTypes().clear();
                    changeHP.getButtonTypes().addAll(new ButtonType[]{yes, no});
                    changeHP.initModality(Modality.APPLICATION_MODAL);
                    Optional<ButtonType> options = changeHP.showAndWait();
                    if (options.get() == yes) {
                        max.getEditor().setText(hp.getEditor().getText());
                    } else if (options.get() == no) {
                        hp.getEditor().setText(max.getEditor().getText());
                    }
                }

            }
        });
    }
}
