package Rain.HelperClasses;

import Rain.MainPackage.Main;
import Rain.MainPackage.CharacterSheetController;
import Rain.PlayableThings.DnDCharacter;
import Rain.Spells.Spell;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Loader {
    private static DnDCharacter ch;
    public static Spell spell;

    public Loader() {
    }

    public static DnDCharacter getCharacter() {
        File t = Main.chooser();
        if (!t.equals(new File(""))) {
            try {
                FileInputStream fIn = new FileInputStream(t);
                ObjectInputStream in = new ObjectInputStream(fIn);
                ch = (DnDCharacter)in.readObject();
                in.close();
                fIn.close();
            } catch (IOException var3) {
                var3.printStackTrace();
            } catch (ClassNotFoundException var4) {
                var4.printStackTrace();
            }
        }

        return ch;
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
        } catch (ClassNotFoundException var5) {
            var5.printStackTrace();
        }

        CharacterSheetController c = (CharacterSheetController)Main.getRootClass().getController();
        c.addSpell(spell);
    }
}
