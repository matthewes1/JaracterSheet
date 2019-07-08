package Rain.Spells;

import Rain.MainPackage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class SpellEditorController {
    private Spell spell;
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
    @FXML
    private Button prepareButton;

    public SpellEditorController() {
    }

    @FXML
    protected void initialize() {
        spell = Main.getController().getSpellBookController().getSelectedSpell();
        if (spell.isPrepared()) {
            prepareButton.setText("Unprepare");
        }
        spellName.setText(spell.getSpellName());
        spellCastTime.setText(spell.getCastTime());
        spellComponents.setText(spell.getComponents());
        spellDescription.setText(spell.getDescription());
        spellDuration.setText(spell.getDuration());
        spellLevel.setText(spell.getLevel());
        spellRange.setText(spell.getRange());
        spellSchool.setText(spell.getSchool());
    }

    @FXML
    void cancel(ActionEvent event) {
        Stage stage = (Stage) this.spellPopup.getScene().getWindow();
        event.consume();
        stage.close();
    }

    @FXML
    void save(ActionEvent event) {
        saveSpell();
        Stage stage = (Stage) this.spellPopup.getScene().getWindow();
        event.consume();
        stage.close();
    }

    private void saveSpell() {
        spell.setSpellName(spellName.getText());
        spell.setLevel(spellLevel.getText());
        spell.setSchool(spellSchool.getText());
        spell.setCastTime(spellCastTime.getText());
        spell.setDuration(spellDuration.getText());
        spell.setRange(spellRange.getText());
        spell.setComponents(spellComponents.getText());
        spell.setDescription(spellDescription.getText());
        Main.getController().getSpellBookController().updateSpell(spell);
    }

    @FXML
    private void switchTable(ActionEvent actionEvent) {
        saveSpell();
        Main.getController().getSpellBookController().switchTable(spell);
        Stage stage = (Stage) this.spellPopup.getScene().getWindow();
        actionEvent.consume();
        stage.close();
    }
}
