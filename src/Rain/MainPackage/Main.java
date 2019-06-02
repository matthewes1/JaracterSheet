package Rain.MainPackage;

import Rain.HelperClasses.Saver;
import java.io.File;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
    private static Stage mainStage;
    public static FXMLLoader forOtherClasses;

    private EventHandler<WindowEvent> promptSave = (event) -> {
        if (!CharacterSheetController.getSavedState()) {
            Alert closeSave = new Alert(AlertType.CONFIRMATION);
            closeSave.setHeaderText("Do you want to save?");
            ButtonType save = new ButtonType("Save");
            ButtonType close = new ButtonType("Exit Anyways");
            ButtonType cancel = new ButtonType("Cancel");
            closeSave.getButtonTypes().clear();
            closeSave.getButtonTypes().addAll(new ButtonType[]{save, cancel, close});
            Optional<ButtonType> options = closeSave.showAndWait();
            if (options.get() == save) {
                //Saver.saveChar(CharacterSheetController.getChar());
            } else if (options.get() == cancel) {
                event.consume();
            } else {
                Platform.exit();
            }
        }

    };

    //Catch error when loading and not selecting?

    public Main() {
    }

    public void start(Stage primaryStage) throws Exception {
        forOtherClasses = new FXMLLoader(this.getClass().getResource("CharacterSheet.fxml"));
        Parent root = (Parent)forOtherClasses.load();
        primaryStage.setTitle("Dnd Character Creator Beta 1.5.0");
        primaryStage.setScene(new Scene(root, 1250.0D, 725.0D));
        primaryStage.setOnCloseRequest(this.promptSave);
        primaryStage.setMinWidth(1250);
        primaryStage.setMinHeight(725);
        mainStage = primaryStage;
        primaryStage.show();
    }

    public static Stage getStage() {
        return mainStage;
    }

    public static FXMLLoader getRootClass() {
        return forOtherClasses;
    }

    public static File chooser() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Character");
        chooser.setInitialDirectory(new File("saves/"));
        File f = chooser.showOpenDialog(mainStage);
        if (f != null) {
            return f;
        } else {
            f = new File("");
            return f;
        }
    }

    public static File chooserSpell() {
        File t = new File("saves/");
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setInitialDirectory(t);
        chooser.setTitle("Open Spellbook");
        File f = chooser.showDialog(mainStage);
        if (f != null) {
            return f;
        } else {
            f = new File("");
            return f;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
