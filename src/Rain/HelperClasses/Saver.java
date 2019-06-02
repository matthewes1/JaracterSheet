package Rain.HelperClasses;

import Rain.MainPackage.CharacterSheetController;
import Rain.PlayableThings.DnDCharacter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Saver {
    public Saver() {
    }

    public static void changesTF(TextField t) {
        t.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                CharacterSheetController.setUnSaved();
            }
        });
    }

    public static void changesTA(TextArea t) {
        t.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                CharacterSheetController.setUnSaved();
            }
        });
    }

    public static void changesSp(Spinner t) {
        t.getEditor().textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                CharacterSheetController.setUnSaved();
            }
        });
    }

    public static void changesCh(ChoiceBox t) {
        t.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                CharacterSheetController.setUnSaved();
            }
        });
    }

    public static void changesRb(RadioButton t) {
        t.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                CharacterSheetController.setUnSaved();
            }
        });
    }

    public static void changesCb(ComboBox t) {
        t.valueProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                CharacterSheetController.setUnSaved();
            }
        });
    }

    public static void changesCb2(ChoiceBox t) {
        t.valueProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                CharacterSheetController.setUnSaved();
            }
        });
    }
}
