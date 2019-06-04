package Rain.MainPackage;

import Rain.HelperClasses.XmlHandler;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class Main extends Application {
    private static Stage mainStage;
    private static FXMLLoader forOtherClasses;

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
                try {
                    XmlHandler.convertToXML(CharacterSheetController.getChar());
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

    //Remove mainStage
    public static Stage getStage() {
        return mainStage;
    }

    public void start(Stage primaryStage) throws Exception {
        forOtherClasses = new FXMLLoader(this.getClass().getResource("CharacterSheet.fxml"));
        Parent root = forOtherClasses.load();
        primaryStage.setTitle("Dnd Character Creator Beta 1.5.0");
        primaryStage.setScene(new Scene(root, 1250.0D, 725.0D));
        primaryStage.setOnCloseRequest(this.promptSave);
        primaryStage.setMinWidth(1250);
        primaryStage.setMinHeight(725);
        mainStage = primaryStage;
        primaryStage.show();
    }

    public static FXMLLoader getRootClass() {
        return forOtherClasses;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
