package Rain.HelperClasses;

import Rain.MainPackage.Main;
import Rain.MainPackage.CharacterSheetController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Options {
    public ColorPicker BackGroundColor;
    public ColorPicker OctColor;
    CharacterSheetController c = (CharacterSheetController)Main.getRootClass().getController();

    public Options() {
    }

    @FXML
    public void initialize() {
        CharacterSheetController var10001 = this.c;
        this.BackGroundColor.setValue(Color.valueOf(CharacterSheetController.props.getProperty("MainBackgroundColor")));
        var10001 = this.c;
        this.OctColor.setValue(Color.valueOf(CharacterSheetController.props.getProperty("OctColor")));
    }

    public void BackgroundColor(ActionEvent actionEvent) {
    }

    public void Cancel(ActionEvent actionEvent) {
        Stage t = (Stage)this.OctColor.getScene().getWindow();
        t.close();
    }

    public void Save(ActionEvent actionEvent) {
        CharacterSheetController var10000 = this.c;
        CharacterSheetController.props.setProperty("MainBackgroundColor", ((Color)this.BackGroundColor.getValue()).toString());
        var10000 = this.c;
        CharacterSheetController.props.setProperty("OctColor", ((Color)this.OctColor.getValue()).toString());
        this.c.saveProps();
        this.c.colors();
        Stage t = (Stage)this.OctColor.getScene().getWindow();
        t.close();
    }

    public void OctColor(ActionEvent actionEvent) {
    }
}