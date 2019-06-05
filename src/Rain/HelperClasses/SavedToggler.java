package Rain.HelperClasses;

import Rain.MainPackage.CharacterSheetController;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;

public class SavedToggler {
    public SavedToggler() {
    }

    //Toggles saved state of the character if a text field is changed
    public static void changesTextField(TextField field) {
        field.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                CharacterSheetController.setUnSaved();
        });
    }

    //Toggles saved state of the character when a text area is changed
    public static void changesTextArea(TextArea area) {
        area.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                CharacterSheetController.setUnSaved();
        });
    }

    //Toggles saved state of the character when a spinner is changed
    public static void changesSpinner(Spinner spinner) {
        spinner.getEditor().textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                CharacterSheetController.setUnSaved();
        });
    }

    //Toggles saved state of the character when a button is changed
    public static void changesRadioButton(RadioButton button) {
        button.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                CharacterSheetController.setUnSaved();
        });
    }

    //Toggles saved state of the character when a combo box is changed
    public static void changesComboBox(ComboBox box) {
        box.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                CharacterSheetController.setUnSaved();
        });
    }

    //Toggles saved state of the character when a choice box is changed
    public static void changesChoiceBox(ChoiceBox box) {
        box.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                CharacterSheetController.setUnSaved();
        });
    }
}
