package Rain.HelperClasses;

import Rain.MainPackage.CharacterSheetController;
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
            CharacterSheetController.setUnSaved();
        });
    }

    public static void changesTextArea(TextArea area) {
        area.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            CharacterSheetController.setUnSaved();
        });
    }

    public static void changesSpinner(Spinner spinner) {
        spinner.getEditor().textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            CharacterSheetController.setUnSaved();
        });
    }

    public static void changesRadioButton(RadioButton button) {
        button.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            CharacterSheetController.setUnSaved();
        });
    }

    public static void changesComboBox(ComboBox box) {
        box.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            CharacterSheetController.setUnSaved();
        });
    }

    public static void changesChoiceBox(ChoiceBox box) {
        box.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            CharacterSheetController.setUnSaved();
        });
    }
}
