package Rain.HelperClasses;

import Rain.MainPackage.CharacterSheetController;
import Rain.MainPackage.Main;
import Rain.Spells.Spell;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Loader {
    public static Spell spell;

    public Loader() {
    }

    public void loadSpell(File t) throws Exception {
        try {
            FileInputStream fIn = new FileInputStream(t);
            ObjectInputStream in = new ObjectInputStream(fIn);
            spell = (Spell)in.readObject();
            in.close();
            fIn.close();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        CharacterSheetController c = Main.getRootClass().getController();
        c.addSpell(spell);
    }
}
