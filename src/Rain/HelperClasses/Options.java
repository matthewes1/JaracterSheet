package Rain.HelperClasses;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.Properties;

/**
 * Controller for the options pane
 */
public class Options {
    @FXML
    private ColorPicker backgroundColor;
    @FXML
    private ColorPicker octagonColor;
    private Properties properties = new Properties();
    private File propertyFile = new File("saves/config.properties");

    public Options() {
    }

    /**
     * Loads property file and sets the color pickers to the current colors
     */
    @FXML
    public void initialize() {
        loadProperties();
        backgroundColor.setValue(Color.valueOf(properties.getProperty("mainBackgroundColor")));
        octagonColor.setValue(Color.valueOf(properties.getProperty("octagonColor")));
    }

    public void loadProperties() {
        //Check for saves folder and if the property file exists
        File saveFolder = new File("saves/");
        if (!saveFolder.exists()) {
            saveFolder.mkdir();
        }

        if (!propertyFile.exists()) {
            properties.setProperty("mainBackgroundColor", "ALICEBLUE");
            properties.setProperty("octagonColor", "LIGHTSKYBLUE");
            saveProperties();
        }


        InputStream read = null;
        try {
            read = new FileInputStream(propertyFile);
            properties.load(read);
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveProperties() {
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(propertyFile);
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Cancel() {
        Stage options = (Stage) this.octagonColor.getScene().getWindow();
        options.close();
    }

    /**
     * Called when the user clicks save, triggers window close event so the main panel runs color assignment
     */
    public void Save() {
        properties.setProperty("mainBackgroundColor", (this.backgroundColor.getValue()).toString());
        properties.setProperty("octagonColor", (this.octagonColor.getValue()).toString());
        Stage options = (Stage) this.octagonColor.getScene().getWindow();
        saveProperties();
        options.fireEvent(
                new WindowEvent(
                        options,
                        WindowEvent.WINDOW_CLOSE_REQUEST
                )
        );
        options.close();
    }
}