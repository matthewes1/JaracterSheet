package Rain.HelperClasses;

import Rain.MainPackage.CharacterSheetController;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;

public class SavedToggler {
    public SavedToggler() {
    }

    public static void changesTF(TextField t) {
        t.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                CharacterSheetController.setUnSaved();
        });
    }

    public static void changesTA(TextArea t) {
        t.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                CharacterSheetController.setUnSaved();
        });
    }

    public static void changesSp(Spinner t) {
        t.getEditor().textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                CharacterSheetController.setUnSaved();
        });
    }

    public static void changesCh(ChoiceBox t) {
        t.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                CharacterSheetController.setUnSaved();
        });
    }

    public static void changesRb(RadioButton t) {
        t.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                CharacterSheetController.setUnSaved();
        });
    }

    public static void changesCb(ComboBox t) {
        t.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                CharacterSheetController.setUnSaved();
        });
    }

    public static void changesCb2(ChoiceBox t) {
        t.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                CharacterSheetController.setUnSaved();
        });
    }
}
