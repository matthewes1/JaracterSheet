package Rain.Spells;

import Rain.MainPackage.Main;
import Rain.MainPackage.CharacterSheetController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SpellController {
    public FXMLLoader fxml;
    public SpellCard spellCard;
    public Spell spell;
    public ChoiceBox SpellLevel;
    public ComboBox SchoolBox;
    public TextField customSchool;
    public TextField SpellName;
    public TextField CastTime;
    public TextField Range;
    public RadioButton Verbal;
    public RadioButton Somatic;
    public RadioButton Material;
    public TextField Duration;
    public TextArea Desc;
    public TextArea HigherLvl;
    public TextField spellClass;
    public Button Cancel;

    public SpellController() {
    }

    @FXML
    protected void initialize() {
        this.comboBox();
    }

    public void setSpell(Spell spell, SpellCard spellCard) {
        this.spell = spell;
        this.SpellLevel.getSelectionModel().select(spell.getLvl());
        this.SchoolBox.getSelectionModel().select(spell.getSchool());
        this.customSchool.setText(spell.getCustomSchool());
        this.SpellName.setText(spell.getName());
        this.CastTime.setText(spell.getCastTime());
        this.Range.setText(spell.getRange());
        this.Verbal.selectedProperty().setValue(spell.isVerbal());
        this.Somatic.selectedProperty().setValue(spell.isSomatic());
        this.Material.selectedProperty().setValue(spell.isMaterial());
        this.Duration.setText(spell.getDuration());
        this.Desc.setText(spell.getDesc());
        this.HigherLvl.setText(spell.getHigherLvl());
        this.spellClass.setText(spell.getSpellClass());
        this.spellCard = spellCard;
    }

    public void comboBox() {
        this.SchoolBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int t = newValue.intValue();
                if (t == 8) {
                    SpellController.this.customSchool.disableProperty().set(false);
                } else {
                    SpellController.this.customSchool.disableProperty().set(true);
                }

            }
        });
    }

    public void setFxml(FXMLLoader fxml) {
        this.fxml = fxml;
    }

    public void Save(ActionEvent actionEvent) throws Exception {
        this.spell = new Spell(this.Verbal.isSelected(), this.Somatic.isSelected(), this.Material.isSelected(), this.SpellLevel.getSelectionModel().getSelectedIndex(), this.SchoolBox.getSelectionModel().getSelectedIndex(), this.SpellName.getText(), this.spellClass.getText(), this.customSchool.getText(), this.CastTime.getText(), this.Range.getText(), this.Duration.getText(), this.Desc.getText(), this.HigherLvl.getText());
        CharacterSheetController c = (CharacterSheetController)Main.getRootClass().getController();
        c.addSpell(this.spell);
        Stage t = (Stage)this.Cancel.getScene().getWindow();
        t.close();
    }

    public void Cancel(ActionEvent actionEvent) {
        Stage t = (Stage)this.Cancel.getScene().getWindow();
        t.close();
    }

    public void SaveEdit(ActionEvent actionEvent) {
        this.spell = new Spell(this.Verbal.isSelected(), this.Somatic.isSelected(), this.Material.isSelected(), this.SpellLevel.getSelectionModel().getSelectedIndex(), this.SchoolBox.getSelectionModel().getSelectedIndex(), this.SpellName.getText(), this.spellClass.getText(), this.customSchool.getText(), this.CastTime.getText(), this.Range.getText(), this.Duration.getText(), this.Desc.getText(), this.HigherLvl.getText());
        this.spellCard.setSpell(this.spell);
        this.spellCard.load();
        Stage t = (Stage)this.Cancel.getScene().getWindow();
        t.close();
    }
}
