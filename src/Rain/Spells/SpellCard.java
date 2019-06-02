package Rain.Spells;

import Rain.MainPackage.Main;
import Rain.MainPackage.CharacterSheetController;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SpellCard {
    public Spell spell;
    public Label Name;
    public Label Level;
    public Label Comp;
    public Label CastTime;
    public Button prepare;

    public SpellCard() {
    }

    @FXML
    protected void initialize() {
    }

    public void setSpell(Spell t) {
        this.spell = t;
    }

    public void load() {
        this.Name.setText(this.spell.getName());
        this.Level.setText(this.levels());
        this.Comp.setText(this.comps());
        this.CastTime.setText(this.spell.getCastTime());
    }

    public String comps() {
        String t = "Components: ";
        if (this.spell.isVerbal()) {
            t = t.concat("V, ");
        }

        if (this.spell.isSomatic()) {
            t = t.concat("S, ");
        }

        if (this.spell.isMaterial()) {
            t = t.concat("M");
        }

        return t;
    }

    public String levels() {
        int index = this.spell.getLvl();
        String x;
        if (index == 0) {
            x = "Cantrip ";
        } else if (index == 1) {
            x = "1st level ";
        } else if (index == 2) {
            x = "2nd level ";
        } else if (index == 3) {
            x = "3rd level ";
        } else if (index == 4) {
            x = "4th level ";
        } else if (index == 5) {
            x = "5th level ";
        } else if (index == 6) {
            x = "6th level ";
        } else if (index == 7) {
            x = "7th level ";
        } else if (index == 8) {
            x = "8th level ";
        } else if (index == 9) {
            x = "9th level ";
        } else {
            x = "Above 9th level ";
        }

        index = this.spell.getSchool();
        if (index == 0) {
            x = x.concat("Abjuration ");
        } else if (index == 1) {
            x = x.concat("Conjuration ");
        } else if (index == 2) {
            x = x.concat("Divination  ");
        } else if (index == 3) {
            x = x.concat("Enchantment ");
        } else if (index == 4) {
            x = x.concat("Evocation ");
        } else if (index == 5) {
            x = x.concat("Illusion ");
        } else if (index == 6) {
            x = x.concat("Necromancy ");
        } else {
            x = x.concat(this.spell.getCustomSchool());
        }

        x = x.concat(this.spell.getSpellClass());
        x = x.concat(" spell");
        return x;
    }

    public void fullCard(MouseEvent mouseEvent) throws Exception {
        Stage SpellPopup = new Stage();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Rain/Spells/SpellPopupClick.fxml"));
        Parent load = (Parent)loader.load();
        SpellController spellCont = (SpellController)load.getUserData();
        SpellPopup.initModality(Modality.APPLICATION_MODAL);
        SpellPopup.initOwner(Main.getStage());
        SpellPopup.centerOnScreen();
        SpellPopup.setScene(new Scene(load, 602.0D, 425.0D));
        spellCont.setSpell(this.spell, this);
        SpellPopup.show();
    }

    public void prepareSpell(ActionEvent actionEvent) {
        CharacterSheetController c;
        Parent par;
        if (this.prepare.getText().startsWith("P")) {
            c = (CharacterSheetController)Main.getRootClass().getController();
            par = this.Name.getParent();
            this.spell.setPrepared(true);
            c.prepare(this.spell, par);
        } else {
            c = (CharacterSheetController)Main.getRootClass().getController();
            par = this.Name.getParent();
            this.spell.setPrepared(false);
            c.unPrepare(this.spell, par);
        }

    }

    public void prepare() {
        this.prep();
    }

    public void prep() {
        this.prepare.setText("Unprepare");
    }

    public void uPrep() {
        this.prepare.setText("Prepare");
    }

    public void deleteSpell(ActionEvent actionEvent) {
        CharacterSheetController c = (CharacterSheetController)Main.getRootClass().getController();
        Parent par = this.Name.getParent();
        boolean prepared = false;
        if (this.prepare.getText().startsWith("U")) {
            prepared = true;
        }

        c.deleteSpell(this.spell, par, prepared);
    }

    public void saveSpell() {
        CharacterSheetController c = (CharacterSheetController)Main.getRootClass().getController();
        if (this.Level.getText().matches("Cantrip")) {
            this.spell.setLvl(0);
        }

        File dir = new File("saves");
        if (!dir.exists() && dir.mkdir()) {
        }

        dir = new File("saves/" + c.getCharName());
        if (!dir.exists() && dir.mkdir()) {
        }

        dir = new File("saves/" + c.getCharName() + "/Spells");
        if (!dir.exists() && dir.mkdir()) {
        }

        String t = "saves/" + c.getCharName() + "/Spells/" + this.spell.getName() + ".ser";
        File tFile = new File(t);

        try {
            FileOutputStream fOut = new FileOutputStream(tFile);
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            out.writeObject(this.spell);
            out.close();
            fOut.close();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }
}
