package Rain.Spells;

import Rain.MainPackage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewSpellController {
    @FXML
    private AnchorPane spellPopup;
    @FXML
    private TextField spellName;
    @FXML
    private TextField spellLevel;
    @FXML
    private TextField spellSchool;
    @FXML
    private TextField spellCastTime;
    @FXML
    private TextField spellDuration;
    @FXML
    private TextField spellRange;
    @FXML
    private TextArea spellComponents;
    @FXML
    private TextArea spellDescription;

    public NewSpellController() {

    }

    /**
     * Sets the spell fields the user has filled out to a spell object and passes it back to the spellbook controller
     *
     * @param actionEvent Auto generated, consumed to delete it
     */
    @FXML
    private void save(ActionEvent actionEvent) {
        Spell spell = new Spell();
        spell.setSpellName(spellName.getText());
        spell.setLevel(spellLevel.getText());
        spell.setSchool(spellSchool.getText());
        spell.setCastTime(spellCastTime.getText());
        spell.setDuration(spellDuration.getText());
        spell.setRange(spellRange.getText());
        spell.setComponents(spellComponents.getText());
        spell.setDescription(spellDescription.getText());
        spell.setPrepared(false);
        Main.getController().getSpellBookController().addSpell(spell);
        Stage stage = (Stage) this.spellPopup.getScene().getWindow();
        actionEvent.consume();
        stage.close();
    }

    @FXML
    private void cancel(ActionEvent actionEvent) {
        Stage stage = (Stage) this.spellPopup.getScene().getWindow();
        actionEvent.consume();
        stage.close();
    }
}
