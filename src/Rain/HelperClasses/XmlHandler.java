package Rain.HelperClasses;

import Rain.PlayableThings.DnDCharacter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;

public class XmlHandler {
    //Converts the character object to an xml context and file
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

    //Loads character from an xml file
    public static DnDCharacter convertToObject(File file) throws Exception {
        JAXBContext context = JAXBContext.newInstance(DnDCharacter.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (DnDCharacter) unmarshaller.unmarshal(file);
    }
}
