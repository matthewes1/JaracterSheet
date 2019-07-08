package Rain.HelperClasses;

import Rain.PlayableThings.DnDCharacter;
import Rain.Spells.Spell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;

public class XmlHandler {
    /**
     * Creates an XML format for the character class and creates a save from the provided character
     *
     * @param character Character object to be turned into an XML file
     * @throws Exception
     */
    public static void convertToXML(DnDCharacter character) throws Exception {
        JAXBContext xmlContext = JAXBContext.newInstance(DnDCharacter.class);
        Marshaller marshaller = xmlContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        String saveName = "saves/" + character.getCharacterName();

        //Checks if the character folder exists
        File checkDir = new File(saveName);
        if (!checkDir.exists()) {
            //If still having issues with saving for others, try checking return of this
            checkDir.mkdir();
        }

        saveName += "/" + character.getCharacterName() + ".xml";

        marshaller.marshal(character, new FileOutputStream(saveName));
    }

    /**
     * Creates XML format for spell class and saves the list provided
     *
     * @param spells        The list of spells to be saved
     * @param characterName The name of the character that has the spells
     * @throws Exception
     */
    public static void convertToXML(ObservableList<Spell> spells, String characterName) throws Exception {
        JAXBContext xmlContext = JAXBContext.newInstance(Spell.class);
        Marshaller marshaller = xmlContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        String directory = "saves/" + characterName;
        //Checks if the character folder exists
        File checkDir = new File(directory);
        if (!checkDir.exists()) {
            //If still having issues with saving for others, try checking return of this
            checkDir.mkdir();
        }

        directory += "/spells/";
        checkDir = new File(directory);
        if (!checkDir.exists()) {
            //If still having issues with saving for others, try checking return of this
            checkDir.mkdir();
        }

        String spellSaveName;
        for (Spell currentSpell : spells) {
            spellSaveName = directory + currentSpell.getSpellName() + ".xml";
            marshaller.marshal(currentSpell, new FileOutputStream(spellSaveName));
        }
    }

    /**
     * Creates character object from an XML file
     * @param file          The file to be loaded
     * @return Returns the character object created
     * @throws Exception
     */
    public static DnDCharacter convertToObject(File file) throws Exception {
        JAXBContext context = JAXBContext.newInstance(DnDCharacter.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (DnDCharacter) unmarshaller.unmarshal(file);
    }

    /**
     * Creates character object from an XML file
     *
     * @param fileList The files to be loaded
     * @return Returns the character object created
     * @throws Exception
     */
    public static ObservableList<Spell> convertToObject(File[] fileList) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Spell.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ObservableList<Spell> spells = FXCollections.observableArrayList();

        for (File file : fileList) {
            spells.add((Spell) unmarshaller.unmarshal(file));
        }

        return spells;
    }
}
