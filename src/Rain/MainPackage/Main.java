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
    static JaracterSheetController controller;

    /**
     * Prompts the user to save when they close the program if the character isn't saved
     */
    private EventHandler<WindowEvent> promptSave = (event) -> {
        if (!Main.getController().getSavedState()) {
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
                    XmlHandler.convertToXML(Main.getController().getChar());
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

    public Main() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static JaracterSheetController getController() {
        return controller;
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("JaracterSheet.fxml"));
        Parent root = loader.load();
        controller = (JaracterSheetController) loader.getController();
        primaryStage.setTitle("Jaracter Sheet Beta 1.6.0");
        primaryStage.setScene(new Scene(root, 1250.0D, 725.0D));
        primaryStage.setOnCloseRequest(this.promptSave);
        primaryStage.setMinWidth(1250);
        primaryStage.setMinHeight(725);
        primaryStage.show();
    }
}
