package Rain.HelperClasses;

import java.io.File;
import java.io.FileFilter;

/**
 * Small class to check if a file is an XML file
 */
public class XmlFilter implements FileFilter {
    String extension = ".xml";
    String description;

    public XmlFilter(String description) {
        this.description = description;
    }

    /**
     * Returns true if file is an XML file
     *
     * @param path The folder that has the files
     * @return True if file is an XML file, otherwise false
     */
    @Override
    public boolean accept(File path) {
        if (path.isDirectory()) {
            return false;
        } else {
            String pathString = path.getAbsolutePath().toLowerCase();
            if (pathString.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}