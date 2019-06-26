package Rain.MainPackage;

import Rain.HelperClasses.*;
import Rain.PlayableThings.DnDCharacter;
import Rain.Spells.Spell;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.Properties;

/**
 * Controller for the main panel and all its tabs. Also houses many methods for assigning character data
 */
public class JaracterSheetController {
    //TODO Spell ui overhaul
    //TODO possible higher resolution version
    //TODO add Apache license after confirmation if controlsfx is needed and find SRD license
    //TODO save file loading filtering

    private static DnDCharacter currentCharacter = new DnDCharacter();
    private static boolean saved = true;
    private File propertyFile = new File("saves/config.properties");
    private Properties properties = new Properties();
    private ObservableList<Spell> spells = FXCollections.observableArrayList();

    //<editor-fold desc="FXML declarations">
    @FXML
    private ScrollPane mainPane;
    @FXML
    private GridPane characterPane;
    @FXML
    private Menu file;
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem load;
    @FXML
    private Menu options;
    @FXML
    private MenuItem colorOptions;
    @FXML
    private TextField strengthField;
    @FXML
    private TextField strengthModifierField;
    @FXML
    private TextField strengthSymbol;
    @FXML
    private ChoiceBox strengthChoice;
    @FXML
    private TextField strengthSave;
    @FXML
    private ChoiceBox athleticsChoice;
    @FXML
    private TextField athletics;
    @FXML
    private TextField dexterityField;
    @FXML
    private TextField dexterityModifier;
    @FXML
    private TextField dexteritySymbol;
    @FXML
    private ChoiceBox dexterityChoice;
    @FXML
    private TextField dexteritySave;
    @FXML
    private TextField acrobatics;
    @FXML
    private ChoiceBox acrobaticsChoice;
    @FXML
    private ChoiceBox sleightOfHandChoice;
    @FXML
    private TextField sleightOfHand;
    @FXML
    private ChoiceBox stealthChoice;
    @FXML
    private TextField stealth;
    @FXML
    private TextField constitutionField;
    @FXML
    private TextField constitutionModifier;
    @FXML
    private TextField constitutionSymbol;
    @FXML
    private ChoiceBox constitutionChoice;
    @FXML
    private TextField constitutionSave;
    @FXML
    private TextField intelligenceField;
    @FXML
    private TextField intelligenceModifier;
    @FXML
    private TextField intelligenceSymbol;
    @FXML
    private ChoiceBox intelligenceChoice;
    @FXML
    private TextField intelligenceSave;
    @FXML
    private ChoiceBox arcanaChoice;
    @FXML
    private TextField arcana;
    @FXML
    private ChoiceBox historyChoice;
    @FXML
    private TextField history;
    @FXML
    private ChoiceBox investigationChoice;
    @FXML
    private TextField investigation;
    @FXML
    private ChoiceBox natureChoice;
    @FXML
    private TextField nature;
    @FXML
    private ChoiceBox religionChoice;
    @FXML
    private TextField religion;
    @FXML
    private TextField wisdomField;
    @FXML
    private TextField wisdomModifier;
    @FXML
    private TextField wisdomSymbol;
    @FXML
    private ChoiceBox wisdomChoice;
    @FXML
    private TextField wisdomSave;
    @FXML
    private ChoiceBox animalChoice;
    @FXML
    private TextField animalHandling;
    @FXML
    private ChoiceBox insightChoice;
    @FXML
    private TextField insight;
    @FXML
    private ChoiceBox medicineChoice;
    @FXML
    private TextField medicine;
    @FXML
    private ChoiceBox perceptionChoice;
    @FXML
    private TextField perception;
    @FXML
    private ChoiceBox survivalChoice;
    @FXML
    private TextField survival;
    @FXML
    private TextField charismaField;
    @FXML
    private TextField charismaModifier;
    @FXML
    private TextField charismaSymbol;
    @FXML
    private ChoiceBox charismaChoice;
    @FXML
    private TextField charismaSave;
    @FXML
    private ChoiceBox deceptionChoice;
    @FXML
    private TextField deception;
    @FXML
    private ChoiceBox intimidationChoice;
    @FXML
    private TextField intimidation;
    @FXML
    private ChoiceBox performanceChoice;
    @FXML
    private TextField performance;
    @FXML
    private ChoiceBox persuasionChoice;
    @FXML
    private TextField persuasion;
    @FXML
    private Polygon speedOctagon;
    @FXML
    private Polygon acOctagon;
    @FXML
    private Polygon initiativeOctagon;
    @FXML
    private Polygon hitDiceOctagon;
    @FXML
    private Polygon currentHPOctagon;
    @FXML
    private Polygon deathSavesOctagon;
    @FXML
    private Spinner currentHPSpinner;
    @FXML
    private Spinner tempHPSpinner;
    @FXML
    private Spinner maxHpSpinner;
    @FXML
    private TextField acField;
    @FXML
    private TextField initiativeField;
    @FXML
    private CheckMenuItem strengthInitiative;
    @FXML
    private CheckMenuItem dexterityInitiative;
    @FXML
    private CheckMenuItem constitutionInitiative;
    @FXML
    private CheckMenuItem intelligenceInitiative;
    @FXML
    private CheckMenuItem wisdomInitiative;
    @FXML
    private CheckMenuItem charismaInitiative;
    @FXML
    private CheckMenuItem customInitiative;
    @FXML
    private Spinner hitDieSpinner;
    @FXML
    private ChoiceBox hitDieType;
    @FXML
    private TextField speedField;
    @FXML
    private RadioButton deathSaveOne;
    @FXML
    private RadioButton deathSaveTwo;
    @FXML
    private RadioButton deathSaveThree;
    @FXML
    private RadioButton deathFailOne;
    @FXML
    private RadioButton deathFailTwo;
    @FXML
    private RadioButton deathFailThree;
    @FXML
    private TextField proficiencyBonus;
    @FXML
    private ChoiceBox proficiencyBonusSymbol;
    @FXML
    private TextField proficiencyBonusExtra;
    @FXML
    private TextArea traitsField;
    @FXML
    private TextArea idealsField;
    @FXML
    private TextArea bondsField;
    @FXML
    private TextArea flawsField;
    @FXML
    private TextField characterName;
    @FXML
    private TextField classField;
    @FXML
    private Spinner levelSpinner;
    @FXML
    private TextField playerNameField;
    @FXML
    private TextField raceField;
    @FXML
    private ComboBox alignmentField;
    @FXML
    private TextField experienceField;
    @FXML
    private RadioButton inspirationOne;
    @FXML
    private RadioButton inspirationTwo;
    @FXML
    private RadioButton inspirationThree;
    @FXML
    private RadioButton inspirationFour;
    @FXML
    private RadioButton inspirationFive;
    @FXML
    private TextField passivePerceptionField;
    @FXML
    private TextField weaponNameOne;
    @FXML
    private TextField attackBonusOne;
    @FXML
    private TextField damageOne;
    @FXML
    private TextField weaponNameTwo;
    @FXML
    private TextField attackBonusTwo;
    @FXML
    private TextField damageTwo;
    @FXML
    private TextField weaponNameThree;
    @FXML
    private TextField attackBonusThree;
    @FXML
    private TextField damageThree;
    @FXML
    private Spinner customInitiativeField;
    @FXML
    private TextArea weapons;
    @FXML
    private TextArea armor;
    @FXML
    private TextField counterOne;
    @FXML
    private Spinner<?> spinnerOne;
    @FXML
    private TextField counterTwo;
    @FXML
    private Spinner<?> spinnerTwo;
    @FXML
    private TextField counterThree;
    @FXML
    private Spinner<?> spinnerThree;
    @FXML
    private TextField counterFour;
    @FXML
    private Spinner<?> spinnerFour;
    @FXML
    private TextField counterFive;
    @FXML
    private Spinner<?> spinnerFive;
    @FXML
    private TextField counterSix;
    @FXML
    private Spinner<?> spinnerSix;
    @FXML
    private TextField counterSeven;
    @FXML
    private Spinner<?> spinnerSeven;
    @FXML
    private TextField counterEight;
    @FXML
    private Spinner<?> spinnerEight;
    @FXML
    private TextField counterNine;
    @FXML
    private Spinner<?> spinnerNine;
    @FXML
    private TextField counterTen;
    @FXML
    private Spinner<?> spinnerTen;
    @FXML
    private TextField counterEleven;
    @FXML
    private Spinner<?> spinnerEleven;
    @FXML
    private TextField counterTwelve;
    @FXML
    private Spinner<?> spinnerTwelve;
    @FXML
    private TextField counterThirteen;
    @FXML
    private Spinner<?> spinnerThirteen;
    @FXML
    private TextField counterFourteen;
    @FXML
    private Spinner<?> spinnerFourteen;
    @FXML
    private TextField counterFifteen;
    @FXML
    private Spinner<?> spinnerFifteen;
    @FXML
    private TextField counterSixteen;
    @FXML
    private Spinner<?> spinnerSixteen;
    @FXML
    private Spinner copper;
    @FXML
    private Spinner silver;
    @FXML
    private Spinner electrum;
    @FXML
    private Spinner gold;
    @FXML
    private Spinner platinum;
    @FXML
    private TextArea miscellaneousOne;
    @FXML
    private TextArea inventoryOne;
    @FXML
    private TextArea inventoryTwo;
    @FXML
    private TextArea inventoryThree;
    @FXML
    private TextArea inventoryFour;
    @FXML
    private TextField ageField;
    @FXML
    private TextField eyes;
    @FXML
    private TextField height;
    @FXML
    private TextField skin;
    @FXML
    private TextField hair;
    @FXML
    private TextField weightField;
    @FXML
    private TextArea language;
    @FXML
    private TextArea feats;
    @FXML
    private TextArea backStory;
    @FXML
    private GridPane spellBookPane;
    @FXML
    private TableView preparedSpells;
    @FXML
    private TableColumn preparedSpellName;
    @FXML
    private TableColumn preparedSpellLevel;
    @FXML
    private TableColumn preparedSpellSchool;
    @FXML
    private TableColumn preparedSpellCastTime;
    @FXML
    private TableColumn preparedSpellRange;
    @FXML
    private TableColumn preparedSpellComponents;
    @FXML
    private TableView unpreparedSpells;
    @FXML
    private TableColumn unpreparedSpellName;
    @FXML
    private TableColumn unpreparedSpellLevel;
    @FXML
    private TableColumn unpreparedSpellSchool;
    @FXML
    private TableColumn unpreparedSpellCastTime;
    @FXML
    private TableColumn unpreparedSpellRange;
    @FXML
    private TableColumn unpreparedSpellComponents;
    //</editor-fold>
    /**
     * Called when options pane is closed so the colors update
     */
    private EventHandler<WindowEvent> loadPropertiesOnClose = (event) -> {
        loadProperties();
        event.consume();
    };

    public JaracterSheetController() {
    }

    public static void setUnSaved() {
        saved = false;
    }

    public static boolean getSavedState() {
        return saved;
    }

    public static DnDCharacter getChar() {
        return currentCharacter;
    }

    @FXML
    protected void initialize() {
        loadProperties();
        setSpinnersAlignment();
        inputValidation();
        autoFill();
        registerSavedState();
        levelSpinner.increment();
        setupTable();
        saved = true;
        License.printLicenses();
    }

    private void loadProperties() {
        File file = new File("saves/");
        if (!file.exists()) {
            file.mkdir();
        }

        if (!propertyFile.exists()) {
            properties.setProperty("mainBackgroundColor", "ALICEBLUE");
            properties.setProperty("octagonColor", "LIGHTSKYBLUE");
            saveProperties();
        }

        InputStream input = null;
        try {
            input = new FileInputStream(propertyFile);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        colors();
    }

    public void saveProperties() {
        File propertyFile = new File("saves/config.properties");

        FileOutputStream output = null;
        try {
            output = new FileOutputStream(propertyFile);
            properties.store(output, null);
        } catch (IOException var11) {
            var11.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Opens pane containing options for program customization
     *
     * @throws IOException
     */
    @FXML
    public void colorOptions() throws IOException {
        Stage optionsPopup = new Stage();
        FXMLLoader fxmlFile = new FXMLLoader(getClass().getResource("/Rain/MainPackage/Options.fxml"));
        Parent parent = fxmlFile.load();
        optionsPopup.initModality(Modality.APPLICATION_MODAL);
        optionsPopup.initOwner(mainPane.getScene().getWindow());
        optionsPopup.centerOnScreen();
        optionsPopup.setScene(new Scene(parent, 600.0D, 400.0D));
        optionsPopup.show();
        optionsPopup.setOnCloseRequest(loadPropertiesOnClose);
    }

    /**
     * Opens pane for licenses
     *
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    private void showLicense(ActionEvent actionEvent) throws IOException {
        Stage license = new Stage();
        FXMLLoader fxmlFile = new FXMLLoader(getClass().getResource("/Rain/MainPackage/License.fxml"));
        Parent parent = fxmlFile.load();
        license.initModality(Modality.APPLICATION_MODAL);
        license.initOwner(mainPane.getScene().getWindow());
        license.centerOnScreen();
        license.setScene(new Scene(parent, 600.0D, 400.0D));
        license.show();
    }

    /**
     * Save selection prompt
     *
     * @return selected file or NULL if no file is selected
     */
    private File chooser() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Character");
        chooser.setInitialDirectory(new File("saves/"));
        File selected = chooser.showOpenDialog(mainPane.getScene().getWindow());
        return selected;
    }

    /**
     * Applies colors from the property file to the appropriate elements
     */
    public void colors() {
        characterPane.setBackground(new Background(new BackgroundFill[]{new BackgroundFill(Color.valueOf(properties.getProperty("mainBackgroundColor")), null, null)}));
        speedOctagon.setFill(Color.valueOf(properties.getProperty("octagonColor")));
        acOctagon.setFill(Color.valueOf(properties.getProperty("octagonColor")));
        initiativeOctagon.setFill(Color.valueOf(properties.getProperty("octagonColor")));
        hitDiceOctagon.setFill(Color.valueOf(properties.getProperty("octagonColor")));
        currentHPOctagon.setFill(Color.valueOf(properties.getProperty("octagonColor")));
        deathSavesOctagon.setFill(Color.valueOf(properties.getProperty("octagonColor")));
    }

    /**
     * Some minor adjustments to a few of the spinners text alignment
     */
    private void setSpinnersAlignment() {
        currentHPSpinner.getEditor().setAlignment(Pos.CENTER_RIGHT);
        maxHpSpinner.getEditor().setAlignment(Pos.CENTER_RIGHT);
        tempHPSpinner.getEditor().setAlignment(Pos.CENTER_RIGHT);
        hitDieSpinner.getEditor().setAlignment(Pos.CENTER_RIGHT);
    }

    /**
     * Registers the elements with their needed input validation
     */
    private void inputValidation() {
        Validation.numericField(strengthField);
        Validation.numericField(dexterityField);
        Validation.numericField(constitutionField);
        Validation.numericField(intelligenceField);
        Validation.numericField(wisdomField);
        Validation.numericField(charismaField);
        Validation.numericField(speedField);
        Validation.numericField(ageField);
        Validation.numericField(weightField);
        Validation.numericField(proficiencyBonus);
        Validation.numericField(acField);
        Validation.numericField(proficiencyBonusExtra);
        Validation.numericSpinner(currentHPSpinner);
        Validation.numericSpinner(maxHpSpinner);
        Validation.numericSpinner(tempHPSpinner);
        Validation.maxHPPrompt(currentHPSpinner, maxHpSpinner);
        Validation.numericSpinner(hitDieSpinner);
        Validation.numericSpinner(levelSpinner);
        Validation.numericSpinner(copper);
        Validation.numericSpinner(silver);
        Validation.numericSpinner(electrum);
        Validation.numericSpinner(gold);
        Validation.numericSpinner(platinum);
        Validation.numericSpinner(spinnerOne);
        Validation.numericSpinner(spinnerTwo);
        Validation.numericSpinner(spinnerThree);
        Validation.numericSpinner(spinnerFour);
        Validation.numericSpinner(spinnerFive);
        Validation.numericSpinner(spinnerSix);
        Validation.numericSpinner(spinnerSeven);
        Validation.numericSpinner(spinnerEight);
        Validation.numericSpinner(spinnerNine);
        Validation.numericSpinner(spinnerTen);
        Validation.numericSpinner(spinnerEleven);
        Validation.numericSpinner(spinnerTwelve);
        Validation.numericSpinner(spinnerThirteen);
        Validation.numericSpinner(spinnerFourteen);
        Validation.numericSpinner(spinnerFifteen);
        Validation.numericSpinner(spinnerSixteen);
    }

    /**
     * Registers the auto calculations for stats.
     */
    private void autoFill() {
        //Registers initiative selection
        strengthInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            JaracterSheetController.this.updateInit();
        });
        dexterityInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            JaracterSheetController.this.updateInit();
        });
        constitutionInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            JaracterSheetController.this.updateInit();
        });
        intelligenceInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            JaracterSheetController.this.updateInit();
        });
        wisdomInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            JaracterSheetController.this.updateInit();
        });
        charismaInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            JaracterSheetController.this.updateInit();
        });
        customInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            JaracterSheetController.this.updateInit();
            JaracterSheetController.setUnSaved();
        });
        customInitiativeField.getEditor().textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            JaracterSheetController.this.updateInit();
            JaracterSheetController.setUnSaved();
        });

        //Register ability modifiers and ability scores
        AutoFill.registerAbilityScore(strengthField, strengthModifierField, strengthSymbol, dexterityInitiative);
        AutoFill.registerAbilityScore(dexterityField, dexterityModifier, dexteritySymbol, dexterityInitiative);
        AutoFill.registerAbilityScore(constitutionField, constitutionModifier, constitutionSymbol, dexterityInitiative);
        AutoFill.registerAbilityScore(intelligenceField, intelligenceModifier, intelligenceSymbol, dexterityInitiative);
        AutoFill.registerAbilityScore(wisdomField, wisdomModifier, wisdomSymbol, dexterityInitiative);
        AutoFill.registerAbilityScore(charismaField, charismaModifier, charismaSymbol, dexterityInitiative);

        AutoFill.registerProficiency(levelSpinner, proficiencyBonus);

        //Strength related stuff
        AutoFill.registerSkill(strengthSave, strengthChoice, proficiencyBonus, strengthField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(athletics, athleticsChoice, proficiencyBonus, strengthField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.updateSkillsProficiency(proficiencyBonus, strengthChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, athleticsChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, strengthChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, athleticsChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, strengthChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, athleticsChoice);
        AutoFill.linkStats(strengthModifierField, strengthChoice);
        AutoFill.linkStats(strengthModifierField, athleticsChoice);

        //Dexterity Stuff
        AutoFill.registerSkill(dexteritySave, dexterityChoice, proficiencyBonus, dexterityField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(acrobatics, acrobaticsChoice, proficiencyBonus, dexterityField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(sleightOfHand, sleightOfHandChoice, proficiencyBonus, dexterityField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(stealth, stealthChoice, proficiencyBonus, dexterityField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.updateSkillsProficiency(proficiencyBonus, dexterityChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, acrobaticsChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, sleightOfHandChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, stealthChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, dexterityChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, acrobaticsChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, sleightOfHandChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, stealthChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, dexterityChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, acrobaticsChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, sleightOfHandChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, stealthChoice);
        AutoFill.linkStats(dexterityModifier, dexterityChoice);
        AutoFill.linkStats(dexterityModifier, acrobaticsChoice);
        AutoFill.linkStats(dexterityModifier, sleightOfHandChoice);
        AutoFill.linkStats(dexterityModifier, stealthChoice);

        //Constitution Stuff
        AutoFill.registerSkill(constitutionSave, constitutionChoice, proficiencyBonus, constitutionField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.updateSkillsProficiency(proficiencyBonus, constitutionChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, constitutionChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, constitutionChoice);
        AutoFill.linkStats(constitutionModifier, constitutionChoice);

        //Intelligence Stuff
        AutoFill.registerSkill(intelligenceSave, intelligenceChoice, proficiencyBonus, intelligenceField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(arcana, arcanaChoice, proficiencyBonus, intelligenceField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(history, historyChoice, proficiencyBonus, intelligenceField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(investigation, investigationChoice, proficiencyBonus, intelligenceField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(nature, natureChoice, proficiencyBonus, intelligenceField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(religion, religionChoice, proficiencyBonus, intelligenceField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.updateSkillsProficiency(proficiencyBonus, intelligenceChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, arcanaChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, historyChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, investigationChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, natureChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, religionChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, historyChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, intelligenceChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, arcanaChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, historyChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, investigationChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, natureChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, religionChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, historyChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, intelligenceChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, arcanaChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, historyChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, investigationChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, natureChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, religionChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, historyChoice);
        AutoFill.linkStats(intelligenceModifier, intelligenceChoice);
        AutoFill.linkStats(intelligenceModifier, arcanaChoice);
        AutoFill.linkStats(intelligenceModifier, historyChoice);
        AutoFill.linkStats(intelligenceModifier, investigationChoice);
        AutoFill.linkStats(intelligenceModifier, natureChoice);
        AutoFill.linkStats(intelligenceModifier, religionChoice);

        //Wisdom Stuff
        AutoFill.registerSkill(wisdomSave, wisdomChoice, proficiencyBonus, wisdomField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(animalHandling, animalChoice, proficiencyBonus, wisdomField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(medicine, medicineChoice, proficiencyBonus, wisdomField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(perception, perceptionChoice, proficiencyBonus, wisdomField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(survival, survivalChoice, proficiencyBonus, wisdomField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(insight, insightChoice, proficiencyBonus, wisdomField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.updateSkillsProficiency(proficiencyBonus, wisdomChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, animalChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, medicineChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, perceptionChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, survivalChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, insightChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, wisdomChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, animalChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, medicineChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, perceptionChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, survivalChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, insightChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, wisdomChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, animalChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, medicineChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, perceptionChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, survivalChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, insightChoice);
        AutoFill.linkStats(wisdomModifier, wisdomChoice);
        AutoFill.linkStats(wisdomModifier, animalChoice);
        AutoFill.linkStats(wisdomModifier, historyChoice);
        AutoFill.linkStats(wisdomModifier, medicineChoice);
        AutoFill.linkStats(wisdomModifier, perceptionChoice);
        AutoFill.linkStats(wisdomModifier, survivalChoice);
        AutoFill.linkStats(wisdomModifier, insightChoice);

        //Charisma Stuff
        AutoFill.registerSkill(charismaSave, charismaChoice, proficiencyBonus, charismaField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(deception, deceptionChoice, proficiencyBonus, charismaField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(intimidation, intimidationChoice, proficiencyBonus, charismaField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(performance, performanceChoice, proficiencyBonus, charismaField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.registerSkill(persuasion, persuasionChoice, proficiencyBonus, charismaField, proficiencyBonusSymbol, proficiencyBonusExtra);
        AutoFill.updateSkillsProficiency(proficiencyBonus, charismaChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, deceptionChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, intimidationChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, performanceChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonus, persuasionChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, charismaChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, deceptionChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, intimidationChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, performanceChoice);
        AutoFill.updateSkillsProficiency(proficiencyBonusExtra, persuasionChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, charismaChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, deceptionChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, intimidationChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, performanceChoice);
        AutoFill.registerProficiencySymbol(proficiencyBonusSymbol, persuasionChoice);
        AutoFill.passivePerception(passivePerceptionField, perception);
        AutoFill.linkStats(charismaModifier, charismaChoice);
        AutoFill.linkStats(charismaModifier, deceptionChoice);
        AutoFill.linkStats(charismaModifier, intimidationChoice);
        AutoFill.linkStats(charismaModifier, performanceChoice);
        AutoFill.linkStats(charismaModifier, persuasionChoice);

        AutoFill.experienceFiller(experienceField, levelSpinner);
    }

    /**
     * Registers saved state togglers
     * Certain fields like modifiers are note here because their change listener for autocalculation includes saved state toggling
     */
    public void registerSavedState() {
        SavedToggler.changesTextField(speedField);
        SavedToggler.changesTextField(experienceField);
        SavedToggler.changesTextField(ageField);
        SavedToggler.changesTextField(weightField);
        SavedToggler.changesTextField(acField);
        SavedToggler.changesTextArea(traitsField);
        SavedToggler.changesTextArea(idealsField);
        SavedToggler.changesTextArea(bondsField);
        SavedToggler.changesTextArea(flawsField);
        SavedToggler.changesSpinner(currentHPSpinner);
        SavedToggler.changesSpinner(maxHpSpinner);
        SavedToggler.changesSpinner(tempHPSpinner);
        SavedToggler.changesSpinner(hitDieSpinner);
        SavedToggler.changesSpinner(levelSpinner);
        SavedToggler.changesSpinner(copper);
        SavedToggler.changesSpinner(silver);
        SavedToggler.changesSpinner(electrum);
        SavedToggler.changesSpinner(gold);
        SavedToggler.changesSpinner(platinum);
        SavedToggler.changesSpinner(spinnerOne);
        SavedToggler.changesSpinner(spinnerTwo);
        SavedToggler.changesSpinner(spinnerThree);
        SavedToggler.changesSpinner(spinnerFour);
        SavedToggler.changesSpinner(spinnerFive);
        SavedToggler.changesSpinner(spinnerSix);
        SavedToggler.changesSpinner(spinnerSeven);
        SavedToggler.changesSpinner(spinnerEight);
        SavedToggler.changesSpinner(spinnerNine);
        SavedToggler.changesSpinner(spinnerTen);
        SavedToggler.changesSpinner(spinnerEleven);
        SavedToggler.changesSpinner(spinnerTwelve);
        SavedToggler.changesSpinner(spinnerThirteen);
        SavedToggler.changesSpinner(spinnerFourteen);
        SavedToggler.changesSpinner(spinnerFifteen);
        SavedToggler.changesSpinner(spinnerSixteen);
        SavedToggler.changesTextField(characterName);
        SavedToggler.changesTextField(classField);
        SavedToggler.changesTextField(raceField);
        SavedToggler.changesTextField(playerNameField);
        SavedToggler.changesTextField(passivePerceptionField);
        SavedToggler.changesRadioButton(deathFailOne);
        SavedToggler.changesRadioButton(deathFailTwo);
        SavedToggler.changesRadioButton(deathFailThree);
        SavedToggler.changesRadioButton(deathSaveOne);
        SavedToggler.changesRadioButton(deathSaveTwo);
        SavedToggler.changesRadioButton(deathSaveThree);
        SavedToggler.changesTextField(eyes);
        SavedToggler.changesTextField(height);
        SavedToggler.changesTextField(skin);
        SavedToggler.changesTextField(hair);
        SavedToggler.changesTextArea(language);
        SavedToggler.changesTextArea(feats);
        SavedToggler.changesComboBox(alignmentField);
        SavedToggler.changesChoiceBox(hitDieType);
        SavedToggler.changesRadioButton(inspirationOne);
        SavedToggler.changesRadioButton(inspirationTwo);
        SavedToggler.changesRadioButton(inspirationFour);
        SavedToggler.changesRadioButton(inspirationThree);
        SavedToggler.changesRadioButton(inspirationFive);
        SavedToggler.changesTextArea(miscellaneousOne);
        SavedToggler.changesTextField(weaponNameOne);
        SavedToggler.changesTextField(weaponNameThree);
        SavedToggler.changesTextField(weaponNameTwo);
        SavedToggler.changesTextField(attackBonusOne);
        SavedToggler.changesTextField(attackBonusThree);
        SavedToggler.changesTextField(attackBonusTwo);
        SavedToggler.changesTextField(damageOne);
        SavedToggler.changesTextField(damageThree);
        SavedToggler.changesTextField(damageTwo);
        SavedToggler.changesTextArea(weapons);
        SavedToggler.changesTextArea(armor);
        SavedToggler.changesTextField(counterOne);
        SavedToggler.changesTextField(counterTwo);
        SavedToggler.changesTextField(counterThree);
        SavedToggler.changesTextField(counterFour);
        SavedToggler.changesTextField(counterFive);
        SavedToggler.changesTextField(counterSix);
        SavedToggler.changesTextField(counterSeven);
        SavedToggler.changesTextField(counterEight);
        SavedToggler.changesTextField(counterNine);
        SavedToggler.changesTextField(counterTen);
        SavedToggler.changesTextField(counterEleven);
        SavedToggler.changesTextField(counterTwelve);
        SavedToggler.changesTextField(counterThirteen);
        SavedToggler.changesTextField(counterFourteen);
        SavedToggler.changesTextField(counterFifteen);
        SavedToggler.changesTextField(counterSixteen);
        SavedToggler.changesTextArea(inventoryOne);
        SavedToggler.changesTextArea(inventoryTwo);
        SavedToggler.changesTextArea(inventoryThree);
        SavedToggler.changesTextArea(inventoryFour);
        SavedToggler.changesTextArea(backStory);
    }

    /**
     * Used to calculate the Initiative
     * Not included in Autofill because it does not use change listeners
     */
    private void updateInit() {
        int initiative = 0;
        if (strengthInitiative.isSelected() && !strengthModifierField.getText().equals("")) {
            initiative += Integer.parseInt(strengthSymbol.getText() + strengthModifierField.getText());
        }

        if (dexterityInitiative.isSelected() && !dexterityModifier.getText().equals("")) {
            initiative += Integer.parseInt(dexteritySymbol.getText() + dexterityModifier.getText());
        }

        if (constitutionInitiative.isSelected() && !constitutionModifier.getText().equals("")) {
            initiative += Integer.parseInt(constitutionSymbol.getText() + constitutionModifier.getText());
        }

        if (intelligenceInitiative.isSelected() && !intelligenceModifier.getText().equals("")) {
            initiative += Integer.parseInt(intelligenceSymbol.getText() + intelligenceModifier.getText());
        }

        if (wisdomInitiative.isSelected() && !wisdomModifier.getText().equals("")) {
            initiative += Integer.parseInt(wisdomSymbol.getText() + wisdomModifier.getText());
        }

        if (charismaInitiative.isSelected() && !charismaModifier.getText().equals("")) {
            initiative += Integer.parseInt(charismaSymbol.getText() + charismaModifier.getText());
        }

        if (customInitiative.isSelected() && !customInitiativeField.getEditor().getText().equals("")) {
            initiative += Integer.parseInt(customInitiativeField.getEditor().getText());
        }

        initiativeField.setText(String.valueOf(initiative));
    }

    @FXML
    public void saveButton() {
        save();
    }

    /**
     * Saves all of the current fields to the character and sends it to XMLhandler
     */
    private void save() {
        currentCharacter.setCharismaField(charismaField.getText());
        currentCharacter.setStrengthField(strengthField.getText());
        currentCharacter.setDexterityField(dexterityField.getText());
        currentCharacter.setConstitutionField(constitutionField.getText());
        currentCharacter.setIntelligenceField(intelligenceField.getText());
        currentCharacter.setWisdomField(wisdomField.getText());
        currentCharacter.setStrengthModifierField(strengthModifierField.getText());
        currentCharacter.setDexterityModifier(dexterityModifier.getText());
        currentCharacter.setConstitutionModifier(constitutionModifier.getText());
        currentCharacter.setIntelligenceModifier(intelligenceModifier.getText());
        currentCharacter.setWisdomModifier(wisdomModifier.getText());
        currentCharacter.setCharismaModifier(charismaModifier.getText());
        currentCharacter.setStrengthInitiative(strengthInitiative.isSelected());
        currentCharacter.setDexterityInitiative(dexterityInitiative.isSelected());
        currentCharacter.setConstitutionInitiative(constitutionInitiative.isSelected());
        currentCharacter.setIntelligenceInitiative(intelligenceInitiative.isSelected());
        currentCharacter.setWisdomInitiative(wisdomInitiative.isSelected());
        currentCharacter.setCharismaInitiative(charismaInitiative.isSelected());
        currentCharacter.setCustomInitiative(customInitiative.isSelected());
        currentCharacter.setCustomInitiativeField(customInitiativeField.getEditor().getText());
        currentCharacter.setAlignment(alignmentField.getSelectionModel().getSelectedIndex());
        currentCharacter.setCharismaSave(charismaSave.getText());
        currentCharacter.setConstitutionSave(constitutionSave.getText());
        currentCharacter.setIntelligenceSave(intelligenceSave.getText());
        currentCharacter.setDexteritySave(dexteritySave.getText());
        currentCharacter.setStrengthSave(strengthSave.getText());
        currentCharacter.setWisdomSave(wisdomSave.getText());
        currentCharacter.setAcrobatics(acrobatics.getText());
        currentCharacter.setAnimalHandling(animalHandling.getText());
        currentCharacter.setArcana(arcana.getText());
        currentCharacter.setAthletics(athletics.getText());
        currentCharacter.setDeception(deception.getText());
        currentCharacter.setHistory(history.getText());
        currentCharacter.setInsight(insight.getText());
        currentCharacter.setIntimidation(intimidation.getText());
        currentCharacter.setInvestigation(investigation.getText());
        currentCharacter.setMedicine(medicine.getText());
        currentCharacter.setPerception(perception.getText());
        currentCharacter.setPerformance(performance.getText());
        currentCharacter.setPersuasion(persuasion.getText());
        currentCharacter.setReligion(religion.getText());
        currentCharacter.setSleightOfHand(sleightOfHand.getText());
        currentCharacter.setStealth(stealth.getText());
        currentCharacter.setSurvival(survival.getText());
        currentCharacter.setInitiativeField(initiativeField.getText());
        currentCharacter.setPassivePerceptionField(passivePerceptionField.getText());
        currentCharacter.setNature(nature.getText());
        currentCharacter.setCounterOne(counterOne.getText());
        currentCharacter.setCounterTwo(counterTwo.getText());
        currentCharacter.setCounterThree(counterThree.getText());
        currentCharacter.setCounterFour(counterFour.getText());
        currentCharacter.setCounterFive(counterFive.getText());
        currentCharacter.setCounterSix(counterSix.getText());
        currentCharacter.setCounterSeven(counterSeven.getText());
        currentCharacter.setCounterEight(counterEight.getText());
        currentCharacter.setSpinnerOne(spinnerOne.getEditor().getText());
        currentCharacter.setSpinnerTwo(spinnerTwo.getEditor().getText());
        currentCharacter.setSpinnerThree(spinnerThree.getEditor().getText());
        currentCharacter.setSpinnerFour(spinnerFour.getEditor().getText());
        currentCharacter.setSpinnerFive(spinnerFive.getEditor().getText());
        currentCharacter.setSpinnerSix(spinnerSix.getEditor().getText());
        currentCharacter.setSpinnerSeven(spinnerSeven.getEditor().getText());
        currentCharacter.setSpinnerEight(spinnerEight.getEditor().getText());
        currentCharacter.setCounterSixteen(counterSixteen.getText());
        currentCharacter.setCounterFifteen(counterFifteen.getText());
        currentCharacter.setCounterFourteen(counterFourteen.getText());
        currentCharacter.setCounterThirteen(counterThirteen.getText());
        currentCharacter.setCounterTwelve(counterTwelve.getText());
        currentCharacter.setCounterEleven(counterEleven.getText());
        currentCharacter.setCounterTen(counterTen.getText());
        currentCharacter.setCounterNine(counterNine.getText());
        currentCharacter.setSpinnerSixteen(spinnerSixteen.getEditor().getText());
        currentCharacter.setSpinnerFifteen(spinnerFifteen.getEditor().getText());
        currentCharacter.setSpinnerFourteen(spinnerFourteen.getEditor().getText());
        currentCharacter.setSpinnerThirteen(spinnerThirteen.getEditor().getText());
        currentCharacter.setSpinnerTwelve(spinnerTwelve.getEditor().getText());
        currentCharacter.setSpinnerEleven(spinnerEleven.getEditor().getText());
        currentCharacter.setSpinnerTen(spinnerTen.getEditor().getText());
        currentCharacter.setSpinnerNine(spinnerNine.getEditor().getText());
        currentCharacter.setSpeedField(speedField.getText());
        currentCharacter.setProficiencyBonus(proficiencyBonus.getText());
        currentCharacter.setMaxHpString(maxHpSpinner.getEditor().getText());
        currentCharacter.setHitDieString(hitDieSpinner.getEditor().getText());
        currentCharacter.setAcField(acField.getText());
        currentCharacter.setTempHPString(tempHPSpinner.getEditor().getText());
        currentCharacter.setInitiativeField(initiativeField.getText());
        currentCharacter.setAcField(acField.getText());
        currentCharacter.setHitDieType(hitDieType.getSelectionModel().getSelectedIndex());
        currentCharacter.setExperienceField(experienceField.getText());
        currentCharacter.setCharacterName(characterName.getText());
        currentCharacter.setClassField(classField.getText());
        currentCharacter.setRaceField(raceField.getText());
        currentCharacter.setLevelString(levelSpinner.getEditor().getText());
        currentCharacter.setPlayerNameField(playerNameField.getText());
        currentCharacter.setExperienceField(experienceField.getText());
        currentCharacter.setAgeField(ageField.getText());
        currentCharacter.setWeightField(weightField.getText());
        currentCharacter.setLevelString(levelSpinner.getEditor().getText());
        currentCharacter.setCopper(copper.getEditor().getText());
        currentCharacter.setSilver(silver.getEditor().getText());
        currentCharacter.setElectrum(electrum.getEditor().getText());
        currentCharacter.setGold(gold.getEditor().getText());
        currentCharacter.setPlatinum(platinum.getEditor().getText());
        currentCharacter.setWeaponNameOne(weaponNameOne.getText());
        currentCharacter.setWeaponNameTwo(weaponNameTwo.getText());
        currentCharacter.setWeaponNameThree(weaponNameThree.getText());
        currentCharacter.setAttackBonusOne(attackBonusOne.getText());
        currentCharacter.setAttackBonusTwo(attackBonusTwo.getText());
        currentCharacter.setAttackBonusThree(attackBonusThree.getText());
        currentCharacter.setDamageOne(damageOne.getText());
        currentCharacter.setDamageTwo(damageTwo.getText());
        currentCharacter.setDamageThree(damageThree.getText());
        currentCharacter.setEyes(eyes.getText());
        currentCharacter.setHeight(height.getText());
        currentCharacter.setSkin(skin.getText());
        currentCharacter.setHair(hair.getText());
        currentCharacter.setInventoryOne(inventoryOne.getText());
        currentCharacter.setInventoryTwo(inventoryTwo.getText());
        currentCharacter.setInventoryThree(inventoryThree.getText());
        currentCharacter.setInventoryFour(inventoryFour.getText());
        currentCharacter.setBackStory(backStory.getText());
        currentCharacter.setTraitsField(traitsField.getText());
        currentCharacter.setIdealsField(idealsField.getText());
        currentCharacter.setBondsField(bondsField.getText());
        currentCharacter.setFlawsField(flawsField.getText());
        currentCharacter.setWeapons(weapons.getText());
        currentCharacter.setArmor(armor.getText());
        currentCharacter.setLanguage(language.getText());
        currentCharacter.setFeats(feats.getText());
        currentCharacter.setMiscellaneousOne(miscellaneousOne.getText());
        currentCharacter.setStrengthChoice(strengthChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setDexterityChoice(dexterityChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setConstitutionChoice(constitutionChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setIntelligenceChoice(intelligenceChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setWisdomChoice(wisdomChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setCharismaChoice(charismaChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setAcrobaticsChoice(acrobaticsChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setAnimalChoice(animalChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setArcanaChoice(arcanaChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setAthleticsChoice(athleticsChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setDeceptionChoice(deceptionChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setHistoryChoice(historyChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setInsightChoice(insightChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setIntimidationChoice(intimidationChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setInvestigationChoice(investigationChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setMedicineChoice(medicineChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setNatureChoice(natureChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setPerceptionChoice(perceptionChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setPerformanceChoice(performanceChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setPersuasionChoice(persuasionChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setReligionChoice(religionChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setSleightOfHandChoice(sleightOfHandChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setStealthChoice(stealthChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setSurvivalChoice(survivalChoice.getSelectionModel().getSelectedIndex());
        currentCharacter.setDeathFailOne(deathFailOne.isSelected());
        currentCharacter.setDeathFailTwo(deathFailTwo.isSelected());
        currentCharacter.setDeathFailThree(deathFailThree.isSelected());
        currentCharacter.setDeathSaveOne(deathSaveOne.isSelected());
        currentCharacter.setDeathSaveTwo(deathSaveTwo.isSelected());
        currentCharacter.setDeathSaveThree(deathSaveThree.isSelected());
        currentCharacter.setInspirationOne(inspirationOne.isSelected());
        currentCharacter.setInspirationTwo(inspirationTwo.isSelected());
        currentCharacter.setInspirationThree(inspirationThree.isSelected());
        currentCharacter.setInspirationFour(inspirationFour.isSelected());
        currentCharacter.setInspirationFive(inspirationFive.isSelected());
        characterPane.requestFocus();
        currentCharacter.setCurrentHPString(currentHPSpinner.getEditor().getText());
        currentCharacter.setProficiencyBonusExtra(proficiencyBonusExtra.getText());

        try {
            XmlHandler.convertToXML(currentCharacter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saved = true;
    }

    /**
     * Gets character from XMLHandler and applies the data to the fields
     */
    @FXML
    public void load() {
        try {
            File character = chooser();
            if (character != null) {
                currentCharacter = XmlHandler.convertToObject(character);
                charismaField.setText(currentCharacter.getCharismaField());
                strengthField.setText(currentCharacter.getStrengthField());
                dexterityField.setText(currentCharacter.getDexterityField());
                constitutionField.setText(currentCharacter.getConstitutionField());
                intelligenceField.setText(currentCharacter.getIntelligenceField());
                wisdomField.setText(currentCharacter.getWisdomField());
                strengthModifierField.setText(currentCharacter.getStrengthModifierField());
                dexterityModifier.setText(currentCharacter.getDexterityModifier());
                constitutionModifier.setText(currentCharacter.getConstitutionModifier());
                intelligenceModifier.setText(currentCharacter.getIntelligenceModifier());
                wisdomModifier.setText(currentCharacter.getWisdomModifier());
                charismaModifier.setText(currentCharacter.getCharismaModifier());
                alignmentField.getSelectionModel().select(currentCharacter.getAlignment());
                charismaSave.setText(currentCharacter.getCharismaSave());
                constitutionSave.setText(currentCharacter.getConstitutionSave());
                intelligenceSave.setText(currentCharacter.getIntelligenceSave());
                dexteritySave.setText(currentCharacter.getDexteritySave());
                strengthSave.setText(currentCharacter.getStrengthSave());
                wisdomSave.setText(currentCharacter.getWisdomSave());
                acrobatics.setText(currentCharacter.getAcrobatics());
                animalHandling.setText(currentCharacter.getAnimalHandling());
                arcana.setText(currentCharacter.getArcana());
                athletics.setText(currentCharacter.getAthletics());
                deception.setText(currentCharacter.getDeception());
                history.setText(currentCharacter.getHistory());
                insight.setText(currentCharacter.getInsight());
                intimidation.setText(currentCharacter.getIntimidation());
                investigation.setText(currentCharacter.getInvestigation());
                medicine.setText(currentCharacter.getMedicine());
                perception.setText(currentCharacter.getPerception());
                performance.setText(currentCharacter.getPerformance());
                persuasion.setText(currentCharacter.getPersuasion());
                religion.setText(currentCharacter.getReligion());
                sleightOfHand.setText(currentCharacter.getSleightOfHand());
                stealth.setText(currentCharacter.getStealth());
                survival.setText(currentCharacter.getSurvival());
                initiativeField.setText(currentCharacter.getInitiativeField());
                passivePerceptionField.setText(currentCharacter.getPassivePerceptionField());
                nature.setText(currentCharacter.getNature());
                counterOne.setText(currentCharacter.getCounterOne());
                counterTwo.setText(currentCharacter.getCounterTwo());
                counterThree.setText(currentCharacter.getCounterThree());
                counterFour.setText(currentCharacter.getCounterFour());
                counterFive.setText(currentCharacter.getCounterFive());
                counterSix.setText(currentCharacter.getCounterSix());
                counterSeven.setText(currentCharacter.getCounterSeven());
                counterEight.setText(currentCharacter.getCounterEight());
                spinnerOne.getEditor().setText(currentCharacter.getSpinnerOne());
                spinnerTwo.getEditor().setText(currentCharacter.getSpinnerTwo());
                spinnerThree.getEditor().setText(currentCharacter.getSpinnerThree());
                spinnerFour.getEditor().setText(currentCharacter.getSpinnerFour());
                spinnerFive.getEditor().setText(currentCharacter.getSpinnerFive());
                spinnerSix.getEditor().setText(currentCharacter.getSpinnerSix());
                spinnerSeven.getEditor().setText(currentCharacter.getSpinnerSeven());
                spinnerEight.getEditor().setText(currentCharacter.getSpinnerEight());
                counterSixteen.setText(currentCharacter.getCounterSixteen());
                counterFifteen.setText(currentCharacter.getCounterFifteen());
                counterFourteen.setText(currentCharacter.getCounterFourteen());
                counterThirteen.setText(currentCharacter.getCounterThirteen());
                counterTwelve.setText(currentCharacter.getCounterTwelve());
                counterEleven.setText(currentCharacter.getCounterEleven());
                counterTen.setText(currentCharacter.getCounterTen());
                counterNine.setText(currentCharacter.getCounterNine());
                spinnerSixteen.getEditor().setText(currentCharacter.getSpinnerSixteen());
                spinnerFifteen.getEditor().setText(currentCharacter.getSpinnerFifteen());
                spinnerFourteen.getEditor().setText(currentCharacter.getSpinnerFourteen());
                spinnerThirteen.getEditor().setText(currentCharacter.getSpinnerThirteen());
                spinnerTwelve.getEditor().setText(currentCharacter.getSpinnerTwelve());
                spinnerEleven.getEditor().setText(currentCharacter.getSpinnerEleven());
                spinnerTen.getEditor().setText(currentCharacter.getSpinnerTen());
                spinnerNine.getEditor().setText(currentCharacter.getSpinnerNine());
                speedField.setText(currentCharacter.getSpeedField());
                proficiencyBonus.setText(currentCharacter.getProficiencyBonus());
                currentHPSpinner.getEditor().setText(currentCharacter.getCurrentHPString());
                maxHpSpinner.getEditor().setText(currentCharacter.getMaxHpString());
                hitDieSpinner.getEditor().setText(currentCharacter.getHitDieString());
                acField.setText(currentCharacter.getAcField());
                tempHPSpinner.getEditor().setText(currentCharacter.getTempHPString());
                initiativeField.setText(currentCharacter.getInitiativeField());
                acField.setText(currentCharacter.getAcField());
                hitDieType.getSelectionModel().select(currentCharacter.getHitDieType());
                experienceField.setText(currentCharacter.getExperienceField());
                characterName.setText(currentCharacter.getCharacterName());
                classField.setText(currentCharacter.getClassField());
                raceField.setText(currentCharacter.getRaceField());
                levelSpinner.getEditor().setText(currentCharacter.getLevelString());
                playerNameField.setText(currentCharacter.getPlayerNameField());
                experienceField.setText(currentCharacter.getExperienceField());
                ageField.setText(currentCharacter.getAgeField());
                weightField.setText(currentCharacter.getWeightField());
                levelSpinner.getEditor().setText(currentCharacter.getLevelString());
                copper.getEditor().setText(currentCharacter.getCopper());
                silver.getEditor().setText(currentCharacter.getSilver());
                electrum.getEditor().setText(currentCharacter.getElectrum());
                gold.getEditor().setText(currentCharacter.getGold());
                platinum.getEditor().setText(currentCharacter.getPlatinum());
                weaponNameOne.setText(currentCharacter.getWeaponNameOne());
                weaponNameTwo.setText(currentCharacter.getWeaponNameTwo());
                weaponNameThree.setText(currentCharacter.getWeaponNameThree());
                attackBonusOne.setText(currentCharacter.getAttackBonusOne());
                attackBonusTwo.setText(currentCharacter.getAttackBonusTwo());
                attackBonusThree.setText(currentCharacter.getAttackBonusThree());
                damageOne.setText(currentCharacter.getDamageOne());
                damageTwo.setText(currentCharacter.getDamageTwo());
                damageThree.setText(currentCharacter.getDamageThree());
                eyes.setText(currentCharacter.getEyes());
                height.setText(currentCharacter.getHeight());
                skin.setText(currentCharacter.getSkin());
                hair.setText(currentCharacter.getHair());
                traitsField.setText(currentCharacter.getTraitsField());
                idealsField.setText(currentCharacter.getIdealsField());
                bondsField.setText(currentCharacter.getBondsField());
                flawsField.setText(currentCharacter.getFlawsField());
                weapons.setText(currentCharacter.getWeapons());
                armor.setText(currentCharacter.getArmor());
                language.setText(currentCharacter.getLanguage());
                feats.setText(currentCharacter.getFeats());
                miscellaneousOne.setText(currentCharacter.getMiscellaneousOne());
                inventoryOne.setText(currentCharacter.getInventoryOne());
                inventoryTwo.setText(currentCharacter.getInventoryTwo());
                inventoryThree.setText(currentCharacter.getInventoryThree());
                inventoryFour.setText(currentCharacter.getInventoryFour());
                backStory.setText(currentCharacter.getBackStory());
                strengthChoice.getSelectionModel().select(currentCharacter.getStrengthChoice());
                dexterityChoice.getSelectionModel().select(currentCharacter.getDexterityChoice());
                constitutionChoice.getSelectionModel().select(currentCharacter.getConstitutionChoice());
                intelligenceChoice.getSelectionModel().select(currentCharacter.getIntelligenceChoice());
                wisdomChoice.getSelectionModel().select(currentCharacter.getWisdomChoice());
                charismaChoice.getSelectionModel().select(currentCharacter.getCharismaChoice());
                acrobaticsChoice.getSelectionModel().select(currentCharacter.getAcrobaticsChoice());
                animalChoice.getSelectionModel().select(currentCharacter.getAnimalChoice());
                arcanaChoice.getSelectionModel().select(currentCharacter.getArcanaChoice());
                athleticsChoice.getSelectionModel().select(currentCharacter.getAthleticsChoice());
                deceptionChoice.getSelectionModel().select(currentCharacter.getDeceptionChoice());
                historyChoice.getSelectionModel().select(currentCharacter.getHistoryChoice());
                insightChoice.getSelectionModel().select(currentCharacter.getInsightChoice());
                intimidationChoice.getSelectionModel().select(currentCharacter.getIntimidationChoice());
                investigationChoice.getSelectionModel().select(currentCharacter.getInvestigationChoice());
                medicineChoice.getSelectionModel().select(currentCharacter.getMedicineChoice());
                natureChoice.getSelectionModel().select(currentCharacter.getNatureChoice());
                perceptionChoice.getSelectionModel().select(currentCharacter.getPerceptionChoice());
                performanceChoice.getSelectionModel().select(currentCharacter.getPerformanceChoice());
                persuasionChoice.getSelectionModel().select(currentCharacter.getPersuasionChoice());
                religionChoice.getSelectionModel().select(currentCharacter.getReligionChoice());
                sleightOfHandChoice.getSelectionModel().select(currentCharacter.getSleightOfHandChoice());
                stealthChoice.getSelectionModel().select(currentCharacter.getStealthChoice());
                survivalChoice.getSelectionModel().select(currentCharacter.getSurvivalChoice());
                deathFailOne.setSelected(currentCharacter.getDeathFailOne());
                deathFailTwo.setSelected(currentCharacter.getDeathFailTwo());
                deathFailThree.setSelected(currentCharacter.getDeathFailThree());
                deathSaveOne.setSelected(currentCharacter.getDeathSaveOne());
                deathSaveTwo.setSelected(currentCharacter.getDeathSaveTwo());
                deathSaveThree.setSelected(currentCharacter.getDeathSaveThree());
                inspirationOne.setSelected(currentCharacter.getInspirationOne());
                inspirationTwo.setSelected(currentCharacter.getInspirationTwo());
                inspirationThree.setSelected(currentCharacter.getInspirationThree());
                inspirationFour.setSelected(currentCharacter.getInspirationFour());
                inspirationFive.setSelected(currentCharacter.getInspirationFive());
                strengthInitiative.setSelected(currentCharacter.getStrengthInitiative());
                dexterityInitiative.setSelected(currentCharacter.getDexterityInitiative());
                constitutionInitiative.setSelected(currentCharacter.getConstitutionInitiative());
                intelligenceInitiative.setSelected(currentCharacter.getIntelligenceInitiative());
                wisdomInitiative.setSelected(currentCharacter.getWisdomInitiative());
                charismaInitiative.setSelected(currentCharacter.getCharismaInitiative());
                customInitiative.setSelected(currentCharacter.getCustomInitiative());
                customInitiativeField.getEditor().setText(currentCharacter.getCustomInitiativeField());
                proficiencyBonusExtra.setText(currentCharacter.getProficiencyBonusExtra());
                saved = true;
                updateInit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Spellbook setup
     */
    private void setupTable() {
        Spell test = new Spell();
        test.setCastTime("test");

        spells.add(test);
    }

    @FXML
    private void loadSpells(ActionEvent actionEvent) {
    }

    @FXML
    private void saveSpells(ActionEvent actionEvent) {
    }

    /**
     * Creates a blank new spell
     *
     * @param actionEvent
     */
    @FXML
    private void makeSpell(ActionEvent actionEvent) {
        Spell newSpell = new Spell();
        newSpell.setSpellName("New Spell");
        spells.add(newSpell);
    }
}