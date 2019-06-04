package Rain.MainPackage;

import Rain.HelperClasses.AutoFill;
import Rain.HelperClasses.SavedToggler;
import Rain.HelperClasses.Validation;
import Rain.HelperClasses.XmlHandler;
import Rain.PlayableThings.DnDCharacter;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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

import java.io.*;
import java.util.Properties;

public class CharacterSheetController {
    //TODO Spell ui overhaul
    //TODO Comment more code/cleanup code
    //TODO possible higher resolution version
    //TODO finish AutoFill renaming method variables. ALso remove unnecessary calculations such as recalculating ability modifier for no reason
    //TODO Config changes


    private static DnDCharacter currentChar = new DnDCharacter();
    private static boolean saved = true;
    private File propFile = new File("saves/config.properties");
    public static Properties props = new Properties();

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
    //</editor-fold>

    public CharacterSheetController() {
    }
    @FXML
    protected void initialize() {
        this.property();
        this.colors();
        this.setSpinnersAlignment();
        this.inputValidation();
        this.autoFill();
        this.registerSavedState();
        this.levelSpinner.increment();
        saved = true;
    }

    private void property() {
        File file = new File("saves/");
        if (!file.exists()) {
            file.mkdir();
        }

        if (!this.propFile.exists()) {
            props.setProperty("MainBackgroundColor", "ALICEBLUE");
            props.setProperty("OctColor", "LIGHTSKYBLUE");
            this.saveProps();
        }

        try {
            InputStream in = new FileInputStream(this.propFile);
            props.load(in);
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public void saveProps() {
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(this.propFile);
            props.store(out, null);
        } catch (IOException var11) {
            var11.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException var10) {
                    var10.printStackTrace();
                }
            }

        }

    }

    public void colors() {
        this.characterPane.setBackground(new Background(new BackgroundFill[]{new BackgroundFill(Color.valueOf(props.getProperty("MainBackgroundColor")), null, null)}));
        this.speedOctagon.setFill(Color.valueOf(props.getProperty("OctColor")));
        this.acOctagon.setFill(Color.valueOf(props.getProperty("OctColor")));
        this.initiativeOctagon.setFill(Color.valueOf(props.getProperty("OctColor")));
        this.hitDiceOctagon.setFill(Color.valueOf(props.getProperty("OctColor")));
        this.currentHPOctagon.setFill(Color.valueOf(props.getProperty("OctColor")));
        this.deathSavesOctagon.setFill(Color.valueOf(props.getProperty("OctColor")));
    }

    private void setSpinnersAlignment() {
        this.currentHPSpinner.getEditor().setAlignment(Pos.CENTER_RIGHT);
        this.maxHpSpinner.getEditor().setAlignment(Pos.CENTER_RIGHT);
        this.tempHPSpinner.getEditor().setAlignment(Pos.CENTER_RIGHT);
        this.hitDieSpinner.getEditor().setAlignment(Pos.CENTER_RIGHT);
    }

    private void inputValidation() {
        Validation.numericField(this.strengthField);
        Validation.numericField(this.dexterityField);
        Validation.numericField(this.constitutionField);
        Validation.numericField(this.intelligenceField);
        Validation.numericField(this.wisdomField);
        Validation.numericField(this.charismaField);
        Validation.numericField(this.speedField);
        Validation.numericField(this.ageField);
        Validation.numericField(this.weightField);
        Validation.numericField(this.proficiencyBonus);
        Validation.numericField(this.acField);
        Validation.numericField(proficiencyBonusExtra);
        Validation.numericSpinner(this.currentHPSpinner);
        Validation.numericSpinner(this.maxHpSpinner);
        Validation.numericSpinner(this.tempHPSpinner);
        Validation.maxHPPrompt(this.currentHPSpinner, this.maxHpSpinner);
        Validation.numericSpinner(this.hitDieSpinner);
        Validation.numericSpinner(this.levelSpinner);
        Validation.numericSpinner(this.copper);
        Validation.numericSpinner(this.silver);
        Validation.numericSpinner(this.electrum);
        Validation.numericSpinner(this.gold);
        Validation.numericSpinner(this.platinum);
        Validation.numericSpinner(this.spinnerOne);
        Validation.numericSpinner(this.spinnerTwo);
        Validation.numericSpinner(this.spinnerThree);
        Validation.numericSpinner(this.spinnerFour);
        Validation.numericSpinner(this.spinnerFive);
        Validation.numericSpinner(this.spinnerSix);
        Validation.numericSpinner(this.spinnerSeven);
        Validation.numericSpinner(this.spinnerEight);
        Validation.numericSpinner(this.spinnerNine);
        Validation.numericSpinner(this.spinnerTen);
        Validation.numericSpinner(this.spinnerEleven);
        Validation.numericSpinner(this.spinnerTwelve);
        Validation.numericSpinner(this.spinnerThirteen);
        Validation.numericSpinner(this.spinnerFourteen);
        Validation.numericSpinner(this.spinnerFifteen);
        Validation.numericSpinner(this.spinnerSixteen);
    }

    private void save() {
        currentChar.setCharismaField(this.charismaField.getText());
        currentChar.setStrengthField(this.strengthField.getText());
        currentChar.setDexterityField(this.dexterityField.getText());
        currentChar.setConstitutionField(this.constitutionField.getText());
        currentChar.setIntelligenceField(this.intelligenceField.getText());
        currentChar.setWisdomField(this.wisdomField.getText());
        currentChar.setStrengthModifierField(this.strengthModifierField.getText());
        currentChar.setDexterityModifier(this.dexterityModifier.getText());
        currentChar.setConstitutionModifier(this.constitutionModifier.getText());
        currentChar.setIntelligenceModifier(this.intelligenceModifier.getText());
        currentChar.setWisdomModifier(this.wisdomModifier.getText());
        currentChar.setCharismaModifier(this.charismaModifier.getText());
        currentChar.setStrengthInitiative(this.strengthInitiative.isSelected());
        currentChar.setDexterityInitiative(this.dexterityInitiative.isSelected());
        currentChar.setConstitutionInitiative(this.constitutionInitiative.isSelected());
        currentChar.setIntelligenceInitiative(this.intelligenceInitiative.isSelected());
        currentChar.setWisdomInitiative(this.wisdomInitiative.isSelected());
        currentChar.setCharismaInitiative(this.charismaInitiative.isSelected());
        currentChar.setCustomInitiative(this.customInitiative.isSelected());
        currentChar.setCustomInitiativeField(this.customInitiativeField.getEditor().getText());
        currentChar.setAlignment(this.alignmentField.getSelectionModel().getSelectedIndex());
        currentChar.setCharismaSave(this.charismaSave.getText());
        currentChar.setConstitutionSave(this.constitutionSave.getText());
        currentChar.setIntelligenceSave(this.intelligenceSave.getText());
        currentChar.setDexteritySave(this.dexteritySave.getText());
        currentChar.setStrengthSave(this.strengthSave.getText());
        currentChar.setWisdomSave(this.wisdomSave.getText());
        currentChar.setAcrobatics(this.acrobatics.getText());
        currentChar.setAnimalHandling(this.animalHandling.getText());
        currentChar.setArcana(this.arcana.getText());
        currentChar.setAthletics(this.athletics.getText());
        currentChar.setDeception(this.deception.getText());
        currentChar.setHistory(this.history.getText());
        currentChar.setInsight(this.insight.getText());
        currentChar.setIntimidation(this.intimidation.getText());
        currentChar.setInvestigation(this.investigation.getText());
        currentChar.setMedicine(this.medicine.getText());
        currentChar.setPerception(this.perception.getText());
        currentChar.setPerformance(this.performance.getText());
        currentChar.setPersuasion(this.persuasion.getText());
        currentChar.setReligion(this.religion.getText());
        currentChar.setSleightOfHand(this.sleightOfHand.getText());
        currentChar.setStealth(this.stealth.getText());
        currentChar.setSurvival(this.survival.getText());
        currentChar.setInitiativeField(this.initiativeField.getText());
        currentChar.setPassivePerceptionField(this.passivePerceptionField.getText());
        currentChar.setNature(this.nature.getText());
        currentChar.setCounterOne(this.counterOne.getText());
        currentChar.setCounterTwo(this.counterTwo.getText());
        currentChar.setCounterThree(this.counterThree.getText());
        currentChar.setCounterFour(this.counterFour.getText());
        currentChar.setCounterFive(this.counterFive.getText());
        currentChar.setCounterSix(this.counterSix.getText());
        currentChar.setCounterSeven(this.counterSeven.getText());
        currentChar.setCounterEight(this.counterEight.getText());
        currentChar.setSpinnerOne(this.spinnerOne.getEditor().getText());
        currentChar.setSpinnerTwo(this.spinnerTwo.getEditor().getText());
        currentChar.setSpinnerThree(this.spinnerThree.getEditor().getText());
        currentChar.setSpinnerFour(this.spinnerFour.getEditor().getText());
        currentChar.setSpinnerFive(this.spinnerFive.getEditor().getText());
        currentChar.setSpinnerSix(this.spinnerSix.getEditor().getText());
        currentChar.setSpinnerSeven(this.spinnerSeven.getEditor().getText());
        currentChar.setSpinnerEight(this.spinnerEight.getEditor().getText());
        currentChar.setCounterSixteen(this.counterSixteen.getText());
        currentChar.setCounterFifteen(this.counterFifteen.getText());
        currentChar.setCounterFourteen(this.counterFourteen.getText());
        currentChar.setCounterThirteen(this.counterThirteen.getText());
        currentChar.setCounterTwelve(this.counterTwelve.getText());
        currentChar.setCounterEleven(this.counterEleven.getText());
        currentChar.setCounterTen(this.counterTen.getText());
        currentChar.setCounterNine(this.counterNine.getText());
        currentChar.setSpinnerSixteen(this.spinnerSixteen.getEditor().getText());
        currentChar.setSpinnerFifteen(this.spinnerFifteen.getEditor().getText());
        currentChar.setSpinnerFourteen(this.spinnerFourteen.getEditor().getText());
        currentChar.setSpinnerThirteen(this.spinnerThirteen.getEditor().getText());
        currentChar.setSpinnerTwelve(this.spinnerTwelve.getEditor().getText());
        currentChar.setSpinnerEleven(this.spinnerEleven.getEditor().getText());
        currentChar.setSpinnerTen(this.spinnerTen.getEditor().getText());
        currentChar.setSpinnerNine(this.spinnerNine.getEditor().getText());
        currentChar.setSpeedField(this.speedField.getText());
        currentChar.setProficiencyBonus(this.proficiencyBonus.getText());
        currentChar.setMaxHpString(this.maxHpSpinner.getEditor().getText());
        currentChar.setHitDieString(this.hitDieSpinner.getEditor().getText());
        currentChar.setAcField(this.acField.getText());
        currentChar.setTempHPString(this.tempHPSpinner.getEditor().getText());
        currentChar.setInitiativeField(this.initiativeField.getText());
        currentChar.setAcField(this.acField.getText());
        currentChar.setHitDieType(this.hitDieType.getSelectionModel().getSelectedIndex());
        currentChar.setExperienceField(this.experienceField.getText());
        currentChar.setCharacterName(this.characterName.getText());
        currentChar.setClassField(this.classField.getText());
        currentChar.setRaceField(this.raceField.getText());
        currentChar.setLevelString(this.levelSpinner.getEditor().getText());
        currentChar.setPlayerNameField(this.playerNameField.getText());
        currentChar.setExperienceField(this.experienceField.getText());
        currentChar.setAgeField(this.ageField.getText());
        currentChar.setWeightField(this.weightField.getText());
        currentChar.setLevelString(this.levelSpinner.getEditor().getText());
        currentChar.setCopper(this.copper.getEditor().getText());
        currentChar.setSilver(this.silver.getEditor().getText());
        currentChar.setElectrum(this.electrum.getEditor().getText());
        currentChar.setGold(this.gold.getEditor().getText());
        currentChar.setPlatinum(this.platinum.getEditor().getText());
        currentChar.setWeaponNameOne(this.weaponNameOne.getText());
        currentChar.setWeaponNameTwo(this.weaponNameTwo.getText());
        currentChar.setWeaponNameThree(this.weaponNameThree.getText());
        currentChar.setAttackBonusOne(this.attackBonusOne.getText());
        currentChar.setAttackBonusTwo(this.attackBonusTwo.getText());
        currentChar.setAttackBonusThree(this.attackBonusThree.getText());
        currentChar.setDamageOne(this.damageOne.getText());
        currentChar.setDamageTwo(this.damageTwo.getText());
        currentChar.setDamageThree(this.damageThree.getText());
        currentChar.setEyes(this.eyes.getText());
        currentChar.setHeight(this.height.getText());
        currentChar.setSkin(this.skin.getText());
        currentChar.setHair(this.hair.getText());
        currentChar.setInventoryOne(this.inventoryOne.getText());
        currentChar.setInventoryTwo(this.inventoryTwo.getText());
        currentChar.setInventoryThree(this.inventoryThree.getText());
        currentChar.setInventoryFour(this.inventoryFour.getText());
        currentChar.setBackStory(this.backStory.getText());
        currentChar.setTraitsField(this.traitsField.getText());
        currentChar.setIdealsField(this.idealsField.getText());
        currentChar.setBondsField(this.bondsField.getText());
        currentChar.setFlawsField(this.flawsField.getText());
        currentChar.setWeapons(this.weapons.getText());
        currentChar.setArmor(this.armor.getText());
        currentChar.setLanguage(this.language.getText());
        currentChar.setFeats(this.feats.getText());
        currentChar.setMiscellaneousOne(this.miscellaneousOne.getText());
        currentChar.setStrengthChoice(this.strengthChoice.getSelectionModel().getSelectedIndex());
        currentChar.setDexterityChoice(this.dexterityChoice.getSelectionModel().getSelectedIndex());
        currentChar.setConstitutionChoice(this.constitutionChoice.getSelectionModel().getSelectedIndex());
        currentChar.setIntelligenceChoice(this.intelligenceChoice.getSelectionModel().getSelectedIndex());
        currentChar.setWisdomChoice(this.wisdomChoice.getSelectionModel().getSelectedIndex());
        currentChar.setCharismaChoice(this.charismaChoice.getSelectionModel().getSelectedIndex());
        currentChar.setAcrobaticsChoice(this.acrobaticsChoice.getSelectionModel().getSelectedIndex());
        currentChar.setAnimalChoice(this.animalChoice.getSelectionModel().getSelectedIndex());
        currentChar.setArcanaChoice(this.arcanaChoice.getSelectionModel().getSelectedIndex());
        currentChar.setAthleticsChoice(this.athleticsChoice.getSelectionModel().getSelectedIndex());
        currentChar.setDeceptionChoice(this.deceptionChoice.getSelectionModel().getSelectedIndex());
        currentChar.setHistoryChoice(this.historyChoice.getSelectionModel().getSelectedIndex());
        currentChar.setInsightChoice(this.insightChoice.getSelectionModel().getSelectedIndex());
        currentChar.setIntimidationChoice(this.intimidationChoice.getSelectionModel().getSelectedIndex());
        currentChar.setInvestigationChoice(this.investigationChoice.getSelectionModel().getSelectedIndex());
        currentChar.setMedicineChoice(this.medicineChoice.getSelectionModel().getSelectedIndex());
        currentChar.setNatureChoice(this.natureChoice.getSelectionModel().getSelectedIndex());
        currentChar.setPerceptionChoice(this.perceptionChoice.getSelectionModel().getSelectedIndex());
        currentChar.setPerformanceChoice(this.performanceChoice.getSelectionModel().getSelectedIndex());
        currentChar.setPersuasionChoice(this.persuasionChoice.getSelectionModel().getSelectedIndex());
        currentChar.setReligionChoice(this.religionChoice.getSelectionModel().getSelectedIndex());
        currentChar.setSleightOfHandChoice(this.sleightOfHandChoice.getSelectionModel().getSelectedIndex());
        currentChar.setStealthChoice(this.stealthChoice.getSelectionModel().getSelectedIndex());
        currentChar.setSurvivalChoice(this.survivalChoice.getSelectionModel().getSelectedIndex());
        currentChar.setDeathFailOne(this.deathFailOne.isSelected());
        currentChar.setDeathFailTwo(this.deathFailTwo.isSelected());
        currentChar.setDeathFailThree(this.deathFailThree.isSelected());
        currentChar.setDeathSaveOne(this.deathSaveOne.isSelected());
        currentChar.setDeathSaveTwo(this.deathSaveTwo.isSelected());
        currentChar.setDeathSaveThree(this.deathSaveThree.isSelected());
        currentChar.setInspirationOne(this.inspirationOne.isSelected());
        currentChar.setInspirationTwo(this.inspirationTwo.isSelected());
        currentChar.setInspirationThree(this.inspirationThree.isSelected());
        currentChar.setInspirationFour(this.inspirationFour.isSelected());
        currentChar.setInspirationFive(this.inspirationFive.isSelected());
        this.characterPane.requestFocus();
        currentChar.setCurrentHPString(this.currentHPSpinner.getEditor().getText());
        currentChar.setProficiencyBonusExtra(this.proficiencyBonusExtra.getText());

        try {
            XmlHandler.convertToXML(currentChar);
        } catch(Exception e) {
            e.printStackTrace();
        }
        saved = true;
    }

    public void saveButton(ActionEvent actionEvent) {
        this.save();
    }

    //Used to generate prof bonus etc.
    private void autoFill() {
        //Registers initiative selection
        this.strengthInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                CharacterSheetController.this.updateInit();
        });
        this.dexterityInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                CharacterSheetController.this.updateInit();
        });
        this.constitutionInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                CharacterSheetController.this.updateInit();
        });
        this.intelligenceInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                CharacterSheetController.this.updateInit();
        });
        this.wisdomInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                CharacterSheetController.this.updateInit();
        });
        this.charismaInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                CharacterSheetController.this.updateInit();
        });
        this.customInitiative.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                CharacterSheetController.this.updateInit();
                CharacterSheetController.setUnSaved();
        });
        this.customInitiativeField.getEditor().textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                CharacterSheetController.this.updateInit();
                CharacterSheetController.setUnSaved();
        });

        //Register ability modifiers and ability scores
        AutoFill.registerAbilityScore(this.strengthField, this.strengthModifierField, this.strengthSymbol, this.dexterityInitiative);
        AutoFill.registerAbilityScore(this.dexterityField, this.dexterityModifier, this.dexteritySymbol, this.dexterityInitiative);
        AutoFill.registerAbilityScore(this.constitutionField, this.constitutionModifier, this.constitutionSymbol, this.dexterityInitiative);
        AutoFill.registerAbilityScore(this.intelligenceField, this.intelligenceModifier, this.intelligenceSymbol, this.dexterityInitiative);
        AutoFill.registerAbilityScore(this.wisdomField, this.wisdomModifier, this.wisdomSymbol, this.dexterityInitiative);
        AutoFill.registerAbilityScore(this.charismaField, this.charismaModifier, this.charismaSymbol, this.dexterityInitiative);

        AutoFill.registerProficiency(this.levelSpinner, this.proficiencyBonus);

        //Strength related stuff
        AutoFill.registerSkill(this.strengthSave, this.strengthChoice, this.proficiencyBonus, this.strengthField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.athletics, this.athleticsChoice, this.proficiencyBonus, this.strengthField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.strengthChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.athleticsChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.strengthChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.athleticsChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.strengthChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.athleticsChoice);
        AutoFill.linkStats(this.strengthModifierField, this.strengthChoice);
        AutoFill.linkStats(this.strengthModifierField, this.athleticsChoice);

        //Dexterity Stuff
        AutoFill.registerSkill(this.dexteritySave, this.dexterityChoice, this.proficiencyBonus, this.dexterityField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.acrobatics, this.acrobaticsChoice, this.proficiencyBonus, this.dexterityField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.sleightOfHand, this.sleightOfHandChoice, this.proficiencyBonus, this.dexterityField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.stealth, this.stealthChoice, this.proficiencyBonus, this.dexterityField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.dexterityChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.acrobaticsChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.sleightOfHandChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.stealthChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.dexterityChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.acrobaticsChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.sleightOfHandChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.stealthChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.dexterityChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.acrobaticsChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.sleightOfHandChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.stealthChoice);
        AutoFill.linkStats(this.dexterityModifier, this.dexterityChoice);
        AutoFill.linkStats(this.dexterityModifier, this.acrobaticsChoice);
        AutoFill.linkStats(this.dexterityModifier, this.sleightOfHandChoice);
        AutoFill.linkStats(this.dexterityModifier, this.stealthChoice);

        //Constitution Stuff
        AutoFill.registerSkill(this.constitutionSave, this.constitutionChoice, this.proficiencyBonus, this.constitutionField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.constitutionChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.constitutionChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.constitutionChoice);
        AutoFill.linkStats(this.constitutionModifier, this.constitutionChoice);

        //Intelligence Stuff
        AutoFill.registerSkill(this.intelligenceSave, this.intelligenceChoice, this.proficiencyBonus, this.intelligenceField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.arcana, this.arcanaChoice, this.proficiencyBonus, this.intelligenceField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.history, this.historyChoice, this.proficiencyBonus, this.intelligenceField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.investigation, this.investigationChoice, this.proficiencyBonus, this.intelligenceField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.nature, this.natureChoice, this.proficiencyBonus, this.intelligenceField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.religion, this.religionChoice, this.proficiencyBonus, this.intelligenceField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.intelligenceChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.arcanaChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.historyChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.investigationChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.natureChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.religionChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.historyChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.intelligenceChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.arcanaChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.historyChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.investigationChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.natureChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.religionChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.historyChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.intelligenceChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.arcanaChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.historyChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.investigationChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.natureChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.religionChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.historyChoice);
        AutoFill.linkStats(this.intelligenceModifier, this.intelligenceChoice);
        AutoFill.linkStats(this.intelligenceModifier, this.arcanaChoice);
        AutoFill.linkStats(this.intelligenceModifier, this.historyChoice);
        AutoFill.linkStats(this.intelligenceModifier, this.investigationChoice);
        AutoFill.linkStats(this.intelligenceModifier, this.natureChoice);
        AutoFill.linkStats(this.intelligenceModifier, this.religionChoice);

        //Wisdom Stuff
        AutoFill.registerSkill(this.wisdomSave, this.wisdomChoice, this.proficiencyBonus, this.wisdomField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.animalHandling, this.animalChoice, this.proficiencyBonus, this.wisdomField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.medicine, this.medicineChoice, this.proficiencyBonus, this.wisdomField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.perception, this.perceptionChoice, this.proficiencyBonus, this.wisdomField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.survival, this.survivalChoice, this.proficiencyBonus, this.wisdomField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.insight, this.insightChoice, this.proficiencyBonus, this.wisdomField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.wisdomChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.animalChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.medicineChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.perceptionChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.survivalChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.insightChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.wisdomChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.animalChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.medicineChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.perceptionChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.survivalChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.insightChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.wisdomChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.animalChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.medicineChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.perceptionChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.survivalChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.insightChoice);
        AutoFill.linkStats(this.wisdomModifier, this.wisdomChoice);
        AutoFill.linkStats(this.wisdomModifier, this.animalChoice);
        AutoFill.linkStats(this.wisdomModifier, this.historyChoice);
        AutoFill.linkStats(this.wisdomModifier, this.medicineChoice);
        AutoFill.linkStats(this.wisdomModifier, this.perceptionChoice);
        AutoFill.linkStats(this.wisdomModifier, this.survivalChoice);
        AutoFill.linkStats(this.wisdomModifier, this.insightChoice);

        //Charisma Stuff
        AutoFill.registerSkill(this.charismaSave, this.charismaChoice, this.proficiencyBonus, this.charismaField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.deception, this.deceptionChoice, this.proficiencyBonus, this.charismaField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.intimidation, this.intimidationChoice, this.proficiencyBonus, this.charismaField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.performance, this.performanceChoice, this.proficiencyBonus, this.charismaField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.registerSkill(this.persuasion, this.persuasionChoice, this.proficiencyBonus, this.charismaField, this.proficiencyBonusSymbol, this.proficiencyBonusExtra);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.charismaChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.deceptionChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.intimidationChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.performanceChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonus, this.persuasionChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.charismaChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.deceptionChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.intimidationChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.performanceChoice);
        AutoFill.updateSkillsProficiency(this.proficiencyBonusExtra, this.persuasionChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.charismaChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.deceptionChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.intimidationChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.performanceChoice);
        AutoFill.registerProficiencySymbol(this.proficiencyBonusSymbol, this.persuasionChoice);
        AutoFill.passivePerception(this.passivePerceptionField, this.perception);
        AutoFill.linkStats(this.charismaModifier, this.charismaChoice);
        AutoFill.linkStats(this.charismaModifier, this.deceptionChoice);
        AutoFill.linkStats(this.charismaModifier, this.intimidationChoice);
        AutoFill.linkStats(this.charismaModifier, this.performanceChoice);
        AutoFill.linkStats(this.charismaModifier, this.persuasionChoice);

        AutoFill.experienceFiller(this.experienceField, this.levelSpinner);
    }

    /*
    On load event, load character and set the current character to the loaded one
     */
    public void load(ActionEvent actionEvent) {
        try {
            currentChar = XmlHandler.convertToObject(chooser());
        } catch(Exception e) {
            e.printStackTrace();
        }
        this.charismaField.setText(currentChar.getCharismaField());
        this.strengthField.setText(currentChar.getStrengthField());
        this.dexterityField.setText(currentChar.getDexterityField());
        this.constitutionField.setText(currentChar.getConstitutionField());
        this.intelligenceField.setText(currentChar.getIntelligenceField());
        this.wisdomField.setText(currentChar.getWisdomField());
        this.strengthModifierField.setText(currentChar.getStrengthModifierField());
        this.dexterityModifier.setText(currentChar.getDexterityModifier());
        this.constitutionModifier.setText(currentChar.getConstitutionModifier());
        this.intelligenceModifier.setText(currentChar.getIntelligenceModifier());
        this.wisdomModifier.setText(currentChar.getWisdomModifier());
        this.charismaModifier.setText(currentChar.getCharismaModifier());
        this.alignmentField.getSelectionModel().select(currentChar.getAlignment());
        this.charismaSave.setText(currentChar.getCharismaSave());
        this.constitutionSave.setText(currentChar.getConstitutionSave());
        this.intelligenceSave.setText(currentChar.getIntelligenceSave());
        this.dexteritySave.setText(currentChar.getDexteritySave());
        this.strengthSave.setText(currentChar.getStrengthSave());
        this.wisdomSave.setText(currentChar.getWisdomSave());
        this.acrobatics.setText(currentChar.getAcrobatics());
        this.animalHandling.setText(currentChar.getAnimalHandling());
        this.arcana.setText(currentChar.getArcana());
        this.athletics.setText(currentChar.getAthletics());
        this.deception.setText(currentChar.getDeception());
        this.history.setText(currentChar.getHistory());
        this.insight.setText(currentChar.getInsight());
        this.intimidation.setText(currentChar.getIntimidation());
        this.investigation.setText(currentChar.getInvestigation());
        this.medicine.setText(currentChar.getMedicine());
        this.perception.setText(currentChar.getPerception());
        this.performance.setText(currentChar.getPerformance());
        this.persuasion.setText(currentChar.getPersuasion());
        this.religion.setText(currentChar.getReligion());
        this.sleightOfHand.setText(currentChar.getSleightOfHand());
        this.stealth.setText(currentChar.getStealth());
        this.survival.setText(currentChar.getSurvival());
        this.initiativeField.setText(currentChar.getInitiativeField());
        this.passivePerceptionField.setText(currentChar.getPassivePerceptionField());
        this.nature.setText(currentChar.getNature());
        this.counterOne.setText(currentChar.getCounterOne());
        this.counterTwo.setText(currentChar.getCounterTwo());
        this.counterThree.setText(currentChar.getCounterThree());
        this.counterFour.setText(currentChar.getCounterFour());
        this.counterFive.setText(currentChar.getCounterFive());
        this.counterSix.setText(currentChar.getCounterSix());
        this.counterSeven.setText(currentChar.getCounterSeven());
        this.counterEight.setText(currentChar.getCounterEight());
        this.spinnerOne.getEditor().setText(currentChar.getSpinnerOne());
        this.spinnerTwo.getEditor().setText(currentChar.getSpinnerTwo());
        this.spinnerThree.getEditor().setText(currentChar.getSpinnerThree());
        this.spinnerFour.getEditor().setText(currentChar.getSpinnerFour());
        this.spinnerFive.getEditor().setText(currentChar.getSpinnerFive());
        this.spinnerSix.getEditor().setText(currentChar.getSpinnerSix());
        this.spinnerSeven.getEditor().setText(currentChar.getSpinnerSeven());
        this.spinnerEight.getEditor().setText(currentChar.getSpinnerEight());
        this.counterSixteen.setText(currentChar.getCounterSixteen());
        this.counterFifteen.setText(currentChar.getCounterFifteen());
        this.counterFourteen.setText(currentChar.getCounterFourteen());
        this.counterThirteen.setText(currentChar.getCounterThirteen());
        this.counterTwelve.setText(currentChar.getCounterTwelve());
        this.counterEleven.setText(currentChar.getCounterEleven());
        this.counterTen.setText(currentChar.getCounterTen());
        this.counterNine.setText(currentChar.getCounterNine());
        this.spinnerSixteen.getEditor().setText(currentChar.getSpinnerSixteen());
        this.spinnerFifteen.getEditor().setText(currentChar.getSpinnerFifteen());
        this.spinnerFourteen.getEditor().setText(currentChar.getSpinnerFourteen());
        this.spinnerThirteen.getEditor().setText(currentChar.getSpinnerThirteen());
        this.spinnerTwelve.getEditor().setText(currentChar.getSpinnerTwelve());
        this.spinnerEleven.getEditor().setText(currentChar.getSpinnerEleven());
        this.spinnerTen.getEditor().setText(currentChar.getSpinnerTen());
        this.spinnerNine.getEditor().setText(currentChar.getSpinnerNine());
        this.speedField.setText(currentChar.getSpeedField());
        this.proficiencyBonus.setText(currentChar.getProficiencyBonus());
        this.currentHPSpinner.getEditor().setText(currentChar.getCurrentHPString());
        this.maxHpSpinner.getEditor().setText(currentChar.getMaxHpString());
        this.hitDieSpinner.getEditor().setText(currentChar.getHitDieString());
        this.acField.setText(currentChar.getAcField());
        this.tempHPSpinner.getEditor().setText(currentChar.getTempHPString());
        this.initiativeField.setText(currentChar.getInitiativeField());
        this.acField.setText(currentChar.getAcField());
        this.hitDieType.getSelectionModel().select(currentChar.getHitDieType());
        this.experienceField.setText(currentChar.getExperienceField());
        this.characterName.setText(currentChar.getCharacterName());
        this.classField.setText(currentChar.getClassField());
        this.raceField.setText(currentChar.getRaceField());
        this.levelSpinner.getEditor().setText(currentChar.getLevelString());
        this.playerNameField.setText(currentChar.getPlayerNameField());
        this.experienceField.setText(currentChar.getExperienceField());
        this.ageField.setText(currentChar.getAgeField());
        this.weightField.setText(currentChar.getWeightField());
        this.levelSpinner.getEditor().setText(currentChar.getLevelString());
        this.copper.getEditor().setText(currentChar.getCopper());
        this.silver.getEditor().setText(currentChar.getSilver());
        this.electrum.getEditor().setText(currentChar.getElectrum());
        this.gold.getEditor().setText(currentChar.getGold());
        this.platinum.getEditor().setText(currentChar.getPlatinum());
        this.weaponNameOne.setText(currentChar.getWeaponNameOne());
        this.weaponNameTwo.setText(currentChar.getWeaponNameTwo());
        this.weaponNameThree.setText(currentChar.getWeaponNameThree());
        this.attackBonusOne.setText(currentChar.getAttackBonusOne());
        this.attackBonusTwo.setText(currentChar.getAttackBonusTwo());
        this.attackBonusThree.setText(currentChar.getAttackBonusThree());
        this.damageOne.setText(currentChar.getDamageOne());
        this.damageTwo.setText(currentChar.getDamageTwo());
        this.damageThree.setText(currentChar.getDamageThree());
        this.eyes.setText(currentChar.getEyes());
        this.height.setText(currentChar.getHeight());
        this.skin.setText(currentChar.getSkin());
        this.hair.setText(currentChar.getHair());
        this.traitsField.setText(currentChar.getTraitsField());
        this.idealsField.setText(currentChar.getIdealsField());
        this.bondsField.setText(currentChar.getBondsField());
        this.flawsField.setText(currentChar.getFlawsField());
        this.weapons.setText(currentChar.getWeapons());
        this.armor.setText(currentChar.getArmor());
        this.language.setText(currentChar.getLanguage());
        this.feats.setText(currentChar.getFeats());
        this.miscellaneousOne.setText(currentChar.getMiscellaneousOne());
        this.inventoryOne.setText(currentChar.getInventoryOne());
        this.inventoryTwo.setText(currentChar.getInventoryTwo());
        this.inventoryThree.setText(currentChar.getInventoryThree());
        this.inventoryFour.setText(currentChar.getInventoryFour());
        this.backStory.setText(currentChar.getBackStory());
        this.strengthChoice.getSelectionModel().select(currentChar.getStrengthChoice());
        this.dexterityChoice.getSelectionModel().select(currentChar.getDexterityChoice());
        this.constitutionChoice.getSelectionModel().select(currentChar.getConstitutionChoice());
        this.intelligenceChoice.getSelectionModel().select(currentChar.getIntelligenceChoice());
        this.wisdomChoice.getSelectionModel().select(currentChar.getWisdomChoice());
        this.charismaChoice.getSelectionModel().select(currentChar.getCharismaChoice());
        this.acrobaticsChoice.getSelectionModel().select(currentChar.getAcrobaticsChoice());
        this.animalChoice.getSelectionModel().select(currentChar.getAnimalChoice());
        this.arcanaChoice.getSelectionModel().select(currentChar.getArcanaChoice());
        this.athleticsChoice.getSelectionModel().select(currentChar.getAthleticsChoice());
        this.deceptionChoice.getSelectionModel().select(currentChar.getDeceptionChoice());
        this.historyChoice.getSelectionModel().select(currentChar.getHistoryChoice());
        this.insightChoice.getSelectionModel().select(currentChar.getInsightChoice());
        this.intimidationChoice.getSelectionModel().select(currentChar.getIntimidationChoice());
        this.investigationChoice.getSelectionModel().select(currentChar.getInvestigationChoice());
        this.medicineChoice.getSelectionModel().select(currentChar.getMedicineChoice());
        this.natureChoice.getSelectionModel().select(currentChar.getNatureChoice());
        this.perceptionChoice.getSelectionModel().select(currentChar.getPerceptionChoice());
        this.performanceChoice.getSelectionModel().select(currentChar.getPerformanceChoice());
        this.persuasionChoice.getSelectionModel().select(currentChar.getPersuasionChoice());
        this.religionChoice.getSelectionModel().select(currentChar.getReligionChoice());
        this.sleightOfHandChoice.getSelectionModel().select(currentChar.getSleightOfHandChoice());
        this.stealthChoice.getSelectionModel().select(currentChar.getStealthChoice());
        this.survivalChoice.getSelectionModel().select(currentChar.getSurvivalChoice());
        this.deathFailOne.setSelected(currentChar.getDeathFailOne());
        this.deathFailTwo.setSelected(currentChar.getDeathFailTwo());
        this.deathFailThree.setSelected(currentChar.getDeathFailThree());
        this.deathSaveOne.setSelected(currentChar.getDeathSaveOne());
        this.deathSaveTwo.setSelected(currentChar.getDeathSaveTwo());
        this.deathSaveThree.setSelected(currentChar.getDeathSaveThree());
        this.inspirationOne.setSelected(currentChar.getInspirationOne());
        this.inspirationTwo.setSelected(currentChar.getInspirationTwo());
        this.inspirationThree.setSelected(currentChar.getInspirationThree());
        this.inspirationFour.setSelected(currentChar.getInspirationFour());
        this.inspirationFive.setSelected(currentChar.getInspirationFive());
        this.strengthInitiative.setSelected(currentChar.getStrengthInitiative());
        this.dexterityInitiative.setSelected(currentChar.getDexterityInitiative());
        this.constitutionInitiative.setSelected(currentChar.getConstitutionInitiative());
        this.intelligenceInitiative.setSelected(currentChar.getIntelligenceInitiative());
        this.wisdomInitiative.setSelected(currentChar.getWisdomInitiative());
        this.charismaInitiative.setSelected(currentChar.getCharismaInitiative());
        this.customInitiative.setSelected(currentChar.getCustomInitiative());
        this.customInitiativeField.getEditor().setText(currentChar.getCustomInitiativeField());
        this.proficiencyBonusExtra.setText(currentChar.getProficiencyBonusExtra());
        saved = true;
        this.updateInit();
    }

    /*
    Used to set current character as unsaved
     */
    public static void setUnSaved() {
        saved = false;
    }

    public void registerSavedState() {
        SavedToggler.changesTF(this.speedField);
        SavedToggler.changesTF(this.experienceField);
        SavedToggler.changesTF(this.ageField);
        SavedToggler.changesTF(this.weightField);
        SavedToggler.changesTF(this.acField);
        SavedToggler.changesTA(this.traitsField);
        SavedToggler.changesTA(this.idealsField);
        SavedToggler.changesTA(this.bondsField);
        SavedToggler.changesTA(this.flawsField);
        SavedToggler.changesSp(this.currentHPSpinner);
        SavedToggler.changesSp(this.maxHpSpinner);
        SavedToggler.changesSp(this.tempHPSpinner);
        SavedToggler.changesSp(this.hitDieSpinner);
        SavedToggler.changesSp(this.levelSpinner);
        SavedToggler.changesSp(this.copper);
        SavedToggler.changesSp(this.silver);
        SavedToggler.changesSp(this.electrum);
        SavedToggler.changesSp(this.gold);
        SavedToggler.changesSp(this.platinum);
        SavedToggler.changesSp(this.spinnerOne);
        SavedToggler.changesSp(this.spinnerTwo);
        SavedToggler.changesSp(this.spinnerThree);
        SavedToggler.changesSp(this.spinnerFour);
        SavedToggler.changesSp(this.spinnerFive);
        SavedToggler.changesSp(this.spinnerSix);
        SavedToggler.changesSp(this.spinnerSeven);
        SavedToggler.changesSp(this.spinnerEight);
        SavedToggler.changesSp(this.spinnerNine);
        SavedToggler.changesSp(this.spinnerTen);
        SavedToggler.changesSp(this.spinnerEleven);
        SavedToggler.changesSp(this.spinnerTwelve);
        SavedToggler.changesSp(this.spinnerThirteen);
        SavedToggler.changesSp(this.spinnerFourteen);
        SavedToggler.changesSp(this.spinnerFifteen);
        SavedToggler.changesSp(this.spinnerSixteen);
        SavedToggler.changesTF(this.characterName);
        SavedToggler.changesTF(this.classField);
        SavedToggler.changesTF(this.raceField);
        SavedToggler.changesTF(this.playerNameField);
        SavedToggler.changesTF(this.passivePerceptionField);
        SavedToggler.changesRb(this.deathFailOne);
        SavedToggler.changesRb(this.deathFailTwo);
        SavedToggler.changesRb(this.deathFailThree);
        SavedToggler.changesRb(this.deathSaveOne);
        SavedToggler.changesRb(this.deathSaveTwo);
        SavedToggler.changesRb(this.deathSaveThree);
        SavedToggler.changesTF(this.eyes);
        SavedToggler.changesTF(this.height);
        SavedToggler.changesTF(this.skin);
        SavedToggler.changesTF(this.hair);
        SavedToggler.changesTA(this.language);
        SavedToggler.changesTA(this.feats);
        SavedToggler.changesCb(this.alignmentField);
        SavedToggler.changesCb2(this.hitDieType);
        SavedToggler.changesRb(this.inspirationOne);
        SavedToggler.changesRb(this.inspirationTwo);
        SavedToggler.changesRb(this.inspirationFour);
        SavedToggler.changesRb(this.inspirationThree);
        SavedToggler.changesRb(this.inspirationFive);
        SavedToggler.changesTA(this.miscellaneousOne);
        SavedToggler.changesTF(this.weaponNameOne);
        SavedToggler.changesTF(this.weaponNameThree);
        SavedToggler.changesTF(this.weaponNameTwo);
        SavedToggler.changesTF(this.attackBonusOne);
        SavedToggler.changesTF(this.attackBonusThree);
        SavedToggler.changesTF(this.attackBonusTwo);
        SavedToggler.changesTF(this.damageOne);
        SavedToggler.changesTF(this.damageThree);
        SavedToggler.changesTF(this.damageTwo);
        SavedToggler.changesTA(this.weapons);
        SavedToggler.changesTA(this.armor);
        SavedToggler.changesTF(this.counterOne);
        SavedToggler.changesTF(this.counterTwo);
        SavedToggler.changesTF(this.counterThree);
        SavedToggler.changesTF(this.counterFour);
        SavedToggler.changesTF(this.counterFive);
        SavedToggler.changesTF(this.counterSix);
        SavedToggler.changesTF(this.counterSeven);
        SavedToggler.changesTF(this.counterEight);
        SavedToggler.changesTF(this.counterNine);
        SavedToggler.changesTF(this.counterTen);
        SavedToggler.changesTF(this.counterEleven);
        SavedToggler.changesTF(this.counterTwelve);
        SavedToggler.changesTF(this.counterThirteen);
        SavedToggler.changesTF(this.counterFourteen);
        SavedToggler.changesTF(this.counterFifteen);
        SavedToggler.changesTF(this.counterSixteen);
        SavedToggler.changesTA(this.inventoryOne);
        SavedToggler.changesTA(this.inventoryTwo);
        SavedToggler.changesTA(this.inventoryThree);
        SavedToggler.changesTA(this.inventoryFour);
        SavedToggler.changesTA(this.backStory);
    }

    public static DnDCharacter getChar() {
        return currentChar;
    }

    public static boolean getSavedState() {
        return saved;
    }

    public void makeSpell(ActionEvent actionEvent) throws Exception {
        Stage SpellPopup = new Stage();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Rain/Spells/SpellPopup.fxml"));
        Parent load = loader.load();
        SpellPopup.initModality(Modality.APPLICATION_MODAL);
        SpellPopup.initOwner(Main.getStage());
        SpellPopup.centerOnScreen();
        SpellPopup.setScene(new Scene(load, 602.0D, 425.0D));
        SpellPopup.show();
    }

    /*
    Used to calculate the Initiative
    Not coded in Autofill because it does not use change listeners
     */
    private void updateInit() {
        int init = 0;
        if (this.strengthInitiative.isSelected() && !this.strengthModifierField.getText().equals("")) {
            init += Integer.parseInt(this.strengthSymbol.getText() + this.strengthModifierField.getText());
        }

        if (this.dexterityInitiative.isSelected() && !this.dexterityModifier.getText().equals("")) {
            init += Integer.parseInt(this.dexteritySymbol.getText() + this.dexterityModifier.getText());
        }

        if (this.constitutionInitiative.isSelected() && !this.constitutionModifier.getText().equals("")) {
            init += Integer.parseInt(this.constitutionSymbol.getText() + this.constitutionModifier.getText());
        }

        if (this.intelligenceInitiative.isSelected() && !this.intelligenceModifier.getText().equals("")) {
            init += Integer.parseInt(this.intelligenceSymbol.getText() + this.intelligenceModifier.getText());
        }

        if (this.wisdomInitiative.isSelected() && !this.wisdomModifier.getText().equals("")) {
            init += Integer.parseInt(this.wisdomSymbol.getText() + this.wisdomModifier.getText());
        }

        if (this.charismaInitiative.isSelected() && !this.charismaModifier.getText().equals("")) {
            init += Integer.parseInt(this.charismaSymbol.getText() + this.charismaModifier.getText());
        }

        if (this.customInitiative.isSelected() && !this.customInitiativeField.getEditor().getText().equals("")) {
            init += Integer.parseInt(this.customInitiativeField.getEditor().getText());
        }

        this.initiativeField.setText(String.valueOf(init));
    }

    public void colorOptions(ActionEvent actionEvent) throws IOException {
        Stage OptionsPop = new Stage();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Rain/MainPackage/Options.fxml"));
        Parent load = loader.load();
        OptionsPop.initModality(Modality.APPLICATION_MODAL);
        OptionsPop.initOwner(mainPane.getScene().getWindow());
        OptionsPop.centerOnScreen();
        OptionsPop.setScene(new Scene(load, 600.0D, 400.0D));
        OptionsPop.show();
    }

    private File chooser() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Character");
        chooser.setInitialDirectory(new File("saves/"));
        File f = chooser.showOpenDialog(mainPane.getScene().getWindow());
        if (f != null) {
            return f;
        } else {
            f = new File("");
            return f;
        }
    }
}
