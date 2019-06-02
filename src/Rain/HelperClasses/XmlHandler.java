package Rain.HelperClasses;

import Rain.PlayableThings.DnDCharacter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;

public class XmlHandler {
    public static void convertToXML(DnDCharacter character) throws Exception {
        JAXBContext context = JAXBContext.newInstance(DnDCharacter.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        String fileName = "saves/" + character.getCharacterName();
        File checkDir = new File(fileName);
        if (!checkDir.exists()) {
            //If still having issues with saving for others, try checking return of this
            checkDir.mkdir();
        }

        fileName += "/" + character.getCharacterName() + ".xml";

        marshaller.marshal(character, new FileOutputStream(fileName));
    }

    public static DnDCharacter convertToObject(File file) throws Exception {
        //File file = new File("saves/char.xml");
        JAXBContext context = JAXBContext.newInstance(DnDCharacter.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (DnDCharacter) unmarshaller.unmarshal(file);
    }
}
