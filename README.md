# Jaracter Sheet #

About the Program:\
I personally did not like how information was displayed by the character sheets stored online, and I wanted to be able to save my characters locally. I created this with what my friends and I think is the most used information at the front. Since starting this project, I have found some other downloadable character sheet programs but I decided to keep going with this to practice programming.\
I named it Jaracter Sheet because I am not creative and it is purely a mix between java and character.

Requirements and installation:\
The download is located at this link: https://github.com/matthewes1/JaracterSheet/releases<br>
Uses Java 8 and I compile it in intellij idea.\
The executable that I provide should be able to be run anywhere, but note that whatever directory it is in it will create a folder named saves. This will probably change, but for now that is where it stores saved character for ease of access.

Current version and most recent changelog:\
1.6.0\
-Spellbook ui changed\
-Full spellbook functionality implemented\
-Some under the hood changes to how the program transfers data between controllers\
-Changed where some files are stored internally, no affect on saves\
-Spellbook features are as follows\
-Full ability to add custom information for all spells\
-Sorting of spells\
-Ability to edit, save, and load spells even across different characters\
    This is done by simply opening another characters spell book\
-No ability to delete spell, will be added in the next update\
-Having two spells with the exact same name will only save one of them. The next update will disallow you from creating the same spell name\

Current features and issues:\
All features of a standard 5e character sheet are implemented.\
Custom initiative bonuses and modifiers, double proficiency, and custom proficiency bonuses are implemented.\
Characters are saved in an XML format.\
Currently you can change the size of the window but it does not scale the elements. I plan to add better screen size support later\
Full spellbook, although spell deletion can only be done manually in the file system currently

To Do:\
Finish small features missing from spellbook\
Move to a better release scheme, possibly using the github releases feature\
Redesign of some of the core code to be more modular and readable\
Check for updates button\
Different resolution support\
Add a changelog either on github or in the program itself

Possible Features/ideas:\
Possible ability to load character sheets from other sources\
Possible recent characters feature\
Support to print a paper copy\
Any ideas users submit and maybe an FAQ

Other notes:\
Primarily uses JavaFX in Java 8.\
Saves stored using JAXB.\
If you have any suggestions or issues, please post them! This is my first program outside of college projects and I hope to use it to become better at programming.\
If my license is missing anything or I missed a license I needed to provide, please let me know via the issuetracker on github.
