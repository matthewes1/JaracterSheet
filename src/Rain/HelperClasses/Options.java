package Rain.HelperClasses;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.Properties;

public class Options {
    //Add @FXML stuff etc.
    public ColorPicker BackGroundColor;
    public ColorPicker OctColor;
    private Properties properties = new Properties();
    private File propertyFile = new File("saves/config.properties");

    public Options() {
    }

    @FXML
    public void initialize() {
        loadProperties();
        this.BackGroundColor.setValue(Color.valueOf(properties.getProperty("MainBackgroundColor")));
        this.OctColor.setValue(Color.valueOf(properties.getProperty("OctColor")));
    }

    public void loadProperties() {
        File file = new File("saves/");
        if (!file.exists()) {
            file.mkdir();
        }

        if (!propertyFile.exists()) {
            this.properties.setProperty("MainBackgroundColor", "ALICEBLUE");
            this.properties.setProperty("OctColor", "LIGHTSKYBLUE");
            this.saveProps();
        }

        try {
            InputStream in = new FileInputStream(propertyFile);
            this.properties.load(in);
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }

    public void saveProps() {
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(propertyFile);
            this.properties.store(out, null);
        } catch (IOException var11) {
            var11.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException var10) {
                    var10.printStackTrace();
                }
            }

        }

    }

    public void BackgroundColor() {
    }

    public void Cancel() {
        Stage t = (Stage)this.OctColor.getScene().getWindow();
        t.close();
    }

    public void Save() {
        properties.setProperty("MainBackgroundColor", (this.BackGroundColor.getValue()).toString());
        properties.setProperty("OctColor", (this.OctColor.getValue()).toString());
        Stage t = (Stage)this.OctColor.getScene().getWindow();
        saveProps();
        t.fireEvent(
                new WindowEvent(
                        t,
                        WindowEvent.WINDOW_CLOSE_REQUEST
                )
        );
        t.close();
    }

    public void OctColor() {
    }
}