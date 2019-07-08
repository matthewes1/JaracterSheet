package Rain.HelperClasses;

import Rain.MainPackage.Main;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;

/**
 * Contains methods used to register when certain things are changed.
 */
public class SavedToggler {
    public SavedToggler() {
    }

    public static void changesTextField(TextField field) {
        field.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            Main.getController().setUnSaved();
        });
    }

    public static void changesTextArea(TextArea area) {
        area.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            Main.getController().setUnSaved();
        });
    }

    public static void changesSpinner(Spinner spinner) {
        spinner.getEditor().textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            Main.getController().setUnSaved();
        });
    }

    public static void changesRadioButton(RadioButton button) {
        button.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            Main.getController().setUnSaved();
        });
    }

    public static void changesComboBox(ComboBox box) {
        box.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            Main.getController().setUnSaved();
        });
    }

    public static void changesChoiceBox(ChoiceBox box) {
        box.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            Main.getController().setUnSaved();
        });
    }
}
