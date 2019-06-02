package Rain.MainPackage;

import Rain.HelperClasses.*;
import Rain.PlayableThings.DnDCharacter;
import Rain.Spells.Spell;
import Rain.Spells.SpellCard;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CharacterSheetController {
    public static DnDCharacter currentChar = new DnDCharacter();
    private static boolean saved = true;
    public File propFile = new File("saves/config.properties");
    public static Properties props = new Properties();

    //<editor-fold desc="FXML declarations">
    @FXML
    private ScrollPane mainPane;
    @FXML
    private GridPane characterPane;
    @FXML
    private MenuBar menuPane;
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
    private GridPane statisticPane;
    @FXML
    private Pane strengthPane;
    @FXML
    private Polygon strengthOctagon;
    @FXML
    private TextField strengthField;
    @FXML
    private Text strengthLabel;
    @FXML
    private Polygon strengthModifierOctagon;
    @FXML
    private TextField strengthModifierField;
    @FXML
    private TextField strengthSymbol;
    @FXML
    private Pane strengthProficiencies;
    @FXML
    private ChoiceBox strengthChoice;
    @FXML
    private TextField strengthSave;
    @FXML
    private ChoiceBox athleticsChoice;
    @FXML
    private TextField athletics;
    @FXML
    private Pane dexterityPane;
    @FXML
    private TextField dexterityField;
    @FXML
    private TextField dexterityModifier;
    @FXML
    private TextField dexteritySymbol;
    @FXML
    private Pane dexterityProficiencies;
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
    private Pane constitution;
    @FXML
    private TextField constitutionField;
    @FXML
    private TextField constitutionModifier;
    @FXML
    private TextField constitutionSymbol;
    @FXML
    private Pane constitutionProficiencies;
    @FXML
    private ChoiceBox constitutionChoice;
    @FXML
    private TextField constitutionSave;
    @FXML
    private Pane intelligence;
    @FXML
    private TextField intelligenceField;
    @FXML
    private TextField intelligenceModifier;
    @FXML
    private TextField intelligenceSymbol;
    @FXML
    private Pane intelligenceProficiencies;
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
    private Pane wisdom;
    @FXML
    private TextField wisdomField;
    @FXML
    private TextField wisdomModifier;
    @FXML
    private TextField wisdomSymbol;
    @FXML
    private Pane wisdomProficiencies;
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
    private Pane charisma;
    @FXML
    private TextField charismaField;
    @FXML
    private TextField charismaModifier;
    @FXML
    private TextField charismaSymbol;
    @FXML
    private Pane charismaProficiencies;
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
    private AnchorPane acPane;
    @FXML
    private Pane healthPane;
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
    private MenuButton modifiers;
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
    private TextField speedLabel;
    @FXML
    private TextField initiativeLabel;
    @FXML
    private TextField deathLabel;
    @FXML
    private TextField savesLabel;
    @FXML
    private TextField hitDieLabel;
    @FXML
    private TextField healthLabel;
    @FXML
    private TextField acLabel;
    @FXML
    private TextField maxHPLabel;
    @FXML
    private TextField temporaryHPLabel;
    @FXML
    private TextField deathLabelOne;
    @FXML
    private TextField deathLabelTwo;
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
    private TextField hitDieLabelOne;
    @FXML
    private AnchorPane proficiencyPane;
    @FXML
    private TextField proficiencyBonus;
    @FXML
    private ChoiceBox proficiencyBonusSymbol;
    @FXML
    private TextField proficiencyBonusExtra;
    @FXML
    private AnchorPane traits;
    @FXML
    private TextArea traitsField;
    @FXML
    private TextArea idealsField;
    @FXML
    private TextArea bondsField;
    @FXML
    private TextArea flawsField;
    @FXML
    private AnchorPane nameArea;
    @FXML
    private TextField characterName;
    @FXML
    private TextField classField;
    @FXML
    private Spinner levelSpinner;
    @FXML
    private TextField levelLabel;
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
    private Label passivePerceptionLabel;
    @FXML
    private TextField inspirationLabel;
    @FXML
    private AnchorPane inventoryPane;
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
    private TextField c1F;
    @FXML
    private Spinner c1;
    @FXML
    private TextField c2F;
    @FXML
    private Spinner c2;
    @FXML
    private TextField c3F;
    @FXML
    private Spinner c3;
    @FXML
    private TextField c4F;
    @FXML
    private Spinner c4;
    @FXML
    private TextField c5F;
    @FXML
    private Spinner c5;
    @FXML
    private TextField c6F;
    @FXML
    private Spinner c6;
    @FXML
    private TextField c7F;
    @FXML
    private Spinner c7;
    @FXML
    private TextField c8F;
    @FXML
    private Spinner c8;
    @FXML
    private TextField x8F;
    @FXML
    private Spinner x8;
    @FXML
    private TextField x7F;
    @FXML
    private Spinner x7;
    @FXML
    private TextField x6F;
    @FXML
    private Spinner x6;
    @FXML
    private TextField x5F;
    @FXML
    private Spinner x5;
    @FXML
    private TextField x4F;
    @FXML
    private Spinner x4;
    @FXML
    private TextField x3F;
    @FXML
    private Spinner x3;
    @FXML
    private TextField x2F;
    @FXML
    private Spinner x2;
    @FXML
    private TextField x1F;
    @FXML
    private Spinner x1;
    @FXML
    private VBox money;
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
    private MenuItem saveSpells;
    @FXML
    private MenuItem loadSpells;
    @FXML
    private MenuItem spellSlots;
    @FXML
    private VBox spellbookBoxP;
    @FXML
    private VBox CantripsP;
    @FXML
    private VBox firstLvlP;
    @FXML
    private VBox secondLvlP;
    @FXML
    private VBox thirdLvlP;
    @FXML
    private VBox fourthLvlP;
    @FXML
    private VBox fifthLvlP;
    @FXML
    private VBox sixthLvlP;
    @FXML
    private VBox seventhLvlP;
    @FXML
    private VBox eighthLvlP;
    @FXML
    private VBox ninthLvlP;
    @FXML
    private VBox aboveNinthLvlP;
    @FXML
    private Button MakeSpellBttn;
    @FXML
    private VBox spellbookBox;
    @FXML
    private VBox Cantrips;
    @FXML
    private VBox firstLvl;
    @FXML
    private VBox secondLvl;
    @FXML
    private VBox thirdLvl;
    @FXML
    private VBox fourthLvl;
    @FXML
    private VBox fifthLvl;
    @FXML
    private VBox sixthLvl;
    @FXML
    private VBox seventhLvl;
    @FXML
    private VBox eighthLvl;
    @FXML
    private VBox ninthLvl;
    @FXML
    private VBox aboveNinthLvl;
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

    public void property() {
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
            props.store(out, (String)null);
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
        this.characterPane.setBackground(new Background(new BackgroundFill[]{new BackgroundFill(Color.valueOf(props.getProperty("MainBackgroundColor")), (CornerRadii)null, (Insets)null)}));
        this.speedOctagon.setFill(Color.valueOf(props.getProperty("OctColor")));
        this.acOctagon.setFill(Color.valueOf(props.getProperty("OctColor")));
        this.initiativeOctagon.setFill(Color.valueOf(props.getProperty("OctColor")));
        this.hitDiceOctagon.setFill(Color.valueOf(props.getProperty("OctColor")));
        this.currentHPOctagon.setFill(Color.valueOf(props.getProperty("OctColor")));
        this.deathSavesOctagon.setFill(Color.valueOf(props.getProperty("OctColor")));
    }

    public void setSpinnersAlignment() {
        this.currentHPSpinner.getEditor().setAlignment(Pos.CENTER_RIGHT);
        this.maxHpSpinner.getEditor().setAlignment(Pos.CENTER_RIGHT);
        this.tempHPSpinner.getEditor().setAlignment(Pos.CENTER_RIGHT);
        this.hitDieSpinner.getEditor().setAlignment(Pos.CENTER_RIGHT);
    }

    public void inputValidation() {
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
        Validation.numericSpinner(this.x1);
        Validation.numericSpinner(this.x2);
        Validation.numericSpinner(this.x3);
        Validation.numericSpinner(this.x4);
        Validation.numericSpinner(this.x5);
        Validation.numericSpinner(this.x6);
        Validation.numericSpinner(this.x7);
        Validation.numericSpinner(this.x8);
        Validation.numericSpinner(this.c8);
        Validation.numericSpinner(this.c7);
        Validation.numericSpinner(this.c6);
        Validation.numericSpinner(this.c5);
        Validation.numericSpinner(this.c4);
        Validation.numericSpinner(this.c3);
        Validation.numericSpinner(this.c2);
        Validation.numericSpinner(this.c1);
    }

    public void save() {
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
        currentChar.setC1F(this.c1F.getText());
        currentChar.setC2F(this.c2F.getText());
        currentChar.setC3F(this.c3F.getText());
        currentChar.setC4F(this.c4F.getText());
        currentChar.setC5F(this.c5F.getText());
        currentChar.setC6F(this.c6F.getText());
        currentChar.setC7F(this.c7F.getText());
        currentChar.setC8F(this.c8F.getText());
        currentChar.setC1(this.c1.getEditor().getText());
        currentChar.setC2(this.c2.getEditor().getText());
        currentChar.setC3(this.c3.getEditor().getText());
        currentChar.setC4(this.c4.getEditor().getText());
        currentChar.setC5(this.c5.getEditor().getText());
        currentChar.setC6(this.c6.getEditor().getText());
        currentChar.setC7(this.c7.getEditor().getText());
        currentChar.setC8(this.c8.getEditor().getText());
        currentChar.setX1F(this.x1F.getText());
        currentChar.setX2F(this.x2F.getText());
        currentChar.setX3F(this.x3F.getText());
        currentChar.setX4F(this.x4F.getText());
        currentChar.setX5F(this.x5F.getText());
        currentChar.setX6F(this.x6F.getText());
        currentChar.setX7F(this.x7F.getText());
        currentChar.setX8F(this.x8F.getText());
        currentChar.setX1(this.x1.getEditor().getText());
        currentChar.setX2(this.x2.getEditor().getText());
        currentChar.setX3(this.x3.getEditor().getText());
        currentChar.setX4(this.x4.getEditor().getText());
        currentChar.setX5(this.x5.getEditor().getText());
        currentChar.setX6(this.x6.getEditor().getText());
        currentChar.setX7(this.x7.getEditor().getText());
        currentChar.setX8(this.x8.getEditor().getText());
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
        currentChar.setBackstory(this.backStory.getText());
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
    public void autoFill() {
        //Registers initiative selection
        this.strengthInitiative.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                CharacterSheetController.this.updateInit();
            }
        });
        this.dexterityInitiative.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                CharacterSheetController.this.updateInit();
            }
        });
        this.constitutionInitiative.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                CharacterSheetController.this.updateInit();
            }
        });
        this.intelligenceInitiative.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                CharacterSheetController.this.updateInit();
            }
        });
        this.wisdomInitiative.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                CharacterSheetController.this.updateInit();
            }
        });
        this.charismaInitiative.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                CharacterSheetController.this.updateInit();
            }
        });
        this.customInitiative.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                CharacterSheetController.this.updateInit();
                CharacterSheetController.setUnSaved();
            }
        });
        this.customInitiativeField.getEditor().textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                CharacterSheetController.this.updateInit();
                CharacterSheetController.setUnSaved();
            }
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
        AutoFill.passivePerception(this.wisdomField, this.passivePerceptionField);
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
            currentChar = XmlHandler.convertToObject();
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
        this.c1F.setText(currentChar.getC1F());
        this.c2F.setText(currentChar.getC2F());
        this.c3F.setText(currentChar.getC3F());
        this.c4F.setText(currentChar.getC4F());
        this.c5F.setText(currentChar.getC5F());
        this.c6F.setText(currentChar.getC6F());
        this.c7F.setText(currentChar.getC7F());
        this.c8F.setText(currentChar.getC8F());
        this.c1.getEditor().setText(currentChar.getC1());
        this.c2.getEditor().setText(currentChar.getC2());
        this.c3.getEditor().setText(currentChar.getC3());
        this.c4.getEditor().setText(currentChar.getC4());
        this.c5.getEditor().setText(currentChar.getC5());
        this.c6.getEditor().setText(currentChar.getC6());
        this.c7.getEditor().setText(currentChar.getC7());
        this.c8.getEditor().setText(currentChar.getC8());
        this.x1F.setText(currentChar.getX1F());
        this.x2F.setText(currentChar.getX2F());
        this.x3F.setText(currentChar.getX3F());
        this.x4F.setText(currentChar.getX4F());
        this.x5F.setText(currentChar.getX5F());
        this.x6F.setText(currentChar.getX6F());
        this.x7F.setText(currentChar.getX7F());
        this.x8F.setText(currentChar.getX8F());
        this.x1.getEditor().setText(currentChar.getX1());
        this.x2.getEditor().setText(currentChar.getX2());
        this.x3.getEditor().setText(currentChar.getX3());
        this.x4.getEditor().setText(currentChar.getX4());
        this.x5.getEditor().setText(currentChar.getX5());
        this.x6.getEditor().setText(currentChar.getX6());
        this.x7.getEditor().setText(currentChar.getX7());
        this.x8.getEditor().setText(currentChar.getX8());
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
        this.backStory.setText(currentChar.getBackstory());
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
        Saver.changesTF(this.speedField);
        Saver.changesTF(this.experienceField);
        Saver.changesTF(this.ageField);
        Saver.changesTF(this.weightField);
        Saver.changesTF(this.acField);
        Saver.changesTA(this.traitsField);
        Saver.changesTA(this.idealsField);
        Saver.changesTA(this.bondsField);
        Saver.changesTA(this.flawsField);
        Saver.changesSp(this.currentHPSpinner);
        Saver.changesSp(this.maxHpSpinner);
        Saver.changesSp(this.tempHPSpinner);
        Saver.changesSp(this.hitDieSpinner);
        Saver.changesSp(this.levelSpinner);
        Saver.changesSp(this.copper);
        Saver.changesSp(this.silver);
        Saver.changesSp(this.electrum);
        Saver.changesSp(this.gold);
        Saver.changesSp(this.platinum);
        Saver.changesSp(this.x2);
        Saver.changesSp(this.x1);
        Saver.changesSp(this.x3);
        Saver.changesSp(this.x4);
        Saver.changesSp(this.x5);
        Saver.changesSp(this.x6);
        Saver.changesSp(this.x7);
        Saver.changesSp(this.x8);
        Saver.changesSp(this.c8);
        Saver.changesSp(this.c7);
        Saver.changesSp(this.c6);
        Saver.changesSp(this.c5);
        Saver.changesSp(this.c4);
        Saver.changesSp(this.c3);
        Saver.changesSp(this.c2);
        Saver.changesSp(this.c1);
        Saver.changesTF(this.characterName);
        Saver.changesTF(this.classField);
        Saver.changesTF(this.raceField);
        Saver.changesTF(this.playerNameField);
        Saver.changesTF(this.passivePerceptionField);
        Saver.changesRb(this.deathFailOne);
        Saver.changesRb(this.deathFailTwo);
        Saver.changesRb(this.deathFailThree);
        Saver.changesRb(this.deathSaveOne);
        Saver.changesRb(this.deathSaveTwo);
        Saver.changesRb(this.deathSaveThree);
        Saver.changesTF(this.eyes);
        Saver.changesTF(this.height);
        Saver.changesTF(this.skin);
        Saver.changesTF(this.hair);
        Saver.changesTA(this.language);
        Saver.changesTA(this.feats);
        Saver.changesCb(this.alignmentField);
        Saver.changesCb2(this.hitDieType);
        Saver.changesRb(this.inspirationOne);
        Saver.changesRb(this.inspirationTwo);
        Saver.changesRb(this.inspirationFour);
        Saver.changesRb(this.inspirationThree);
        Saver.changesRb(this.inspirationFive);
        Saver.changesTA(this.miscellaneousOne);
        Saver.changesTF(this.weaponNameOne);
        Saver.changesTF(this.weaponNameThree);
        Saver.changesTF(this.weaponNameTwo);
        Saver.changesTF(this.attackBonusOne);
        Saver.changesTF(this.attackBonusThree);
        Saver.changesTF(this.attackBonusTwo);
        Saver.changesTF(this.damageOne);
        Saver.changesTF(this.damageThree);
        Saver.changesTF(this.damageTwo);
        Saver.changesTA(this.weapons);
        Saver.changesTA(this.armor);
        Saver.changesTF(this.c1F);
        Saver.changesTF(this.c2F);
        Saver.changesTF(this.c3F);
        Saver.changesTF(this.c4F);
        Saver.changesTF(this.c5F);
        Saver.changesTF(this.c6F);
        Saver.changesTF(this.c7F);
        Saver.changesTF(this.c8F);
        Saver.changesTF(this.x1F);
        Saver.changesTF(this.x2F);
        Saver.changesTF(this.x3F);
        Saver.changesTF(this.x4F);
        Saver.changesTF(this.x5F);
        Saver.changesTF(this.x6F);
        Saver.changesTF(this.x7F);
        Saver.changesTF(this.x8F);
        Saver.changesTA(this.inventoryOne);
        Saver.changesTA(this.inventoryTwo);
        Saver.changesTA(this.inventoryThree);
        Saver.changesTA(this.inventoryFour);
        Saver.changesTA(this.backStory);
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
        Parent load = (Parent)loader.load();
        SpellPopup.initModality(Modality.APPLICATION_MODAL);
        SpellPopup.initOwner(Main.getStage());
        SpellPopup.centerOnScreen();
        SpellPopup.setScene(new Scene(load, 602.0D, 425.0D));
        SpellPopup.show();
    }

    public void addSpell(Spell t) throws Exception {
        FXMLLoader spellFXML = new FXMLLoader(this.getClass().getResource("/Rain/Spells/SpellCard.fxml"));
        Parent par = (Parent)spellFXML.load();
        int index = t.getLvl();
        SpellCard spellCont;
        if (t.isPrepared()) {
            if (index == 0) {
                this.CantripsP.getChildren().add(par);
                spellCont = (SpellCard)((Node)this.CantripsP.getChildren().get(this.CantripsP.getChildren().indexOf(par))).getUserData();
                spellCont.prepare();
            } else if (index == 1) {
                this.firstLvlP.getChildren().add(par);
                spellCont = (SpellCard)((Node)this.firstLvlP.getChildren().get(this.firstLvlP.getChildren().indexOf(par))).getUserData();
                spellCont.prepare();
            } else if (index == 2) {
                this.secondLvlP.getChildren().add(par);
                spellCont = (SpellCard)((Node)this.secondLvlP.getChildren().get(this.secondLvlP.getChildren().indexOf(par))).getUserData();
                spellCont.prepare();
            } else if (index == 3) {
                this.thirdLvlP.getChildren().add(par);
                spellCont = (SpellCard)((Node)this.thirdLvlP.getChildren().get(this.thirdLvlP.getChildren().indexOf(par))).getUserData();
                spellCont.prepare();
            } else if (index == 4) {
                this.fourthLvlP.getChildren().add(par);
                spellCont = (SpellCard)((Node)this.fourthLvlP.getChildren().get(this.fourthLvlP.getChildren().indexOf(par))).getUserData();
                spellCont.prepare();
            } else if (index == 5) {
                this.fifthLvlP.getChildren().add(par);
                spellCont = (SpellCard)((Node)this.fifthLvlP.getChildren().get(this.fifthLvlP.getChildren().indexOf(par))).getUserData();
                spellCont.prepare();
            } else if (index == 6) {
                this.sixthLvlP.getChildren().add(par);
                spellCont = (SpellCard)((Node)this.sixthLvlP.getChildren().get(this.sixthLvlP.getChildren().indexOf(par))).getUserData();
                spellCont.prepare();
            } else if (index == 7) {
                this.seventhLvlP.getChildren().add(par);
                spellCont = (SpellCard)((Node)this.seventhLvlP.getChildren().get(this.seventhLvlP.getChildren().indexOf(par))).getUserData();
                spellCont.prepare();
            } else if (index == 8) {
                this.eighthLvlP.getChildren().add(par);
                spellCont = (SpellCard)((Node)this.eighthLvlP.getChildren().get(this.eighthLvlP.getChildren().indexOf(par))).getUserData();
                spellCont.prepare();
            } else if (index == 9) {
                this.ninthLvlP.getChildren().add(par);
                spellCont = (SpellCard)((Node)this.ninthLvlP.getChildren().get(this.ninthLvlP.getChildren().indexOf(par))).getUserData();
                spellCont.prepare();
            } else {
                this.aboveNinthLvlP.getChildren().add(par);
                spellCont = (SpellCard)((Node)this.aboveNinthLvlP.getChildren().get(this.aboveNinthLvlP.getChildren().indexOf(par))).getUserData();
            }
        } else if (index == 0) {
            this.Cantrips.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.Cantrips.getChildren().get(this.Cantrips.getChildren().indexOf(par))).getUserData();
        } else if (index == 1) {
            this.firstLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.firstLvl.getChildren().get(this.firstLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 2) {
            this.secondLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.secondLvl.getChildren().get(this.secondLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 3) {
            this.thirdLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.thirdLvl.getChildren().get(this.thirdLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 4) {
            this.fourthLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.fourthLvl.getChildren().get(this.fourthLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 5) {
            this.fifthLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.fifthLvl.getChildren().get(this.fifthLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 6) {
            this.sixthLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.sixthLvl.getChildren().get(this.sixthLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 7) {
            this.seventhLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.seventhLvl.getChildren().get(this.seventhLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 8) {
            this.eighthLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.eighthLvl.getChildren().get(this.eighthLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 9) {
            this.ninthLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.ninthLvl.getChildren().get(this.ninthLvl.getChildren().indexOf(par))).getUserData();
        } else {
            this.aboveNinthLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.aboveNinthLvl.getChildren().get(this.aboveNinthLvl.getChildren().indexOf(par))).getUserData();
        }

        spellCont.setSpell(t);
        spellCont.load();
        this.sortSpells();
    }

    public void prepare(Spell spell, Parent par) {
        int index = spell.getLvl();
        SpellCard spellCont;
        if (index == 0) {
            this.Cantrips.getChildren().remove(this.Cantrips.getChildren().indexOf(par));
            this.CantripsP.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.CantripsP.getChildren().get(this.CantripsP.getChildren().indexOf(par))).getUserData();
        } else if (index == 1) {
            this.firstLvl.getChildren().remove(this.firstLvl.getChildren().indexOf(par));
            this.firstLvlP.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.firstLvlP.getChildren().get(this.firstLvlP.getChildren().indexOf(par))).getUserData();
        } else if (index == 2) {
            this.secondLvl.getChildren().remove(this.secondLvl.getChildren().indexOf(par));
            this.secondLvlP.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.secondLvlP.getChildren().get(this.secondLvlP.getChildren().indexOf(par))).getUserData();
        } else if (index == 3) {
            this.thirdLvl.getChildren().remove(this.thirdLvl.getChildren().indexOf(par));
            this.thirdLvlP.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.thirdLvlP.getChildren().get(this.thirdLvlP.getChildren().indexOf(par))).getUserData();
        } else if (index == 4) {
            this.fourthLvl.getChildren().remove(this.fourthLvl.getChildren().indexOf(par));
            this.fourthLvlP.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.fourthLvlP.getChildren().get(this.fourthLvlP.getChildren().indexOf(par))).getUserData();
        } else if (index == 5) {
            this.fifthLvl.getChildren().remove(this.fifthLvl.getChildren().indexOf(par));
            this.fifthLvlP.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.fifthLvlP.getChildren().get(this.fifthLvlP.getChildren().indexOf(par))).getUserData();
        } else if (index == 6) {
            this.sixthLvl.getChildren().remove(this.sixthLvl.getChildren().indexOf(par));
            this.sixthLvlP.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.sixthLvlP.getChildren().get(this.sixthLvlP.getChildren().indexOf(par))).getUserData();
        } else if (index == 7) {
            this.seventhLvl.getChildren().remove(this.seventhLvl.getChildren().indexOf(par));
            this.seventhLvlP.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.seventhLvlP.getChildren().get(this.seventhLvlP.getChildren().indexOf(par))).getUserData();
        } else if (index == 8) {
            this.eighthLvl.getChildren().remove(this.eighthLvl.getChildren().indexOf(par));
            this.eighthLvlP.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.eighthLvlP.getChildren().get(this.eighthLvlP.getChildren().indexOf(par))).getUserData();
        } else if (index == 9) {
            this.ninthLvl.getChildren().remove(this.ninthLvl.getChildren().indexOf(par));
            this.ninthLvlP.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.ninthLvlP.getChildren().get(this.ninthLvlP.getChildren().indexOf(par))).getUserData();
        } else {
            this.aboveNinthLvl.getChildren().remove(this.aboveNinthLvl.getChildren().indexOf(par));
            this.aboveNinthLvlP.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.aboveNinthLvlP.getChildren().get(this.aboveNinthLvlP.getChildren().indexOf(par))).getUserData();
        }

        spellCont.setSpell(spell);
        spellCont.load();
        spellCont.prep();
        this.sortSpells();
    }

    public void unPrepare(Spell spell, Parent par) {
        int index = spell.getLvl();
        SpellCard spellCont;
        if (index == 0) {
            this.CantripsP.getChildren().remove(this.CantripsP.getChildren().indexOf(par));
            this.Cantrips.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.Cantrips.getChildren().get(this.Cantrips.getChildren().indexOf(par))).getUserData();
        } else if (index == 1) {
            this.firstLvlP.getChildren().remove(this.firstLvlP.getChildren().indexOf(par));
            this.firstLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.firstLvl.getChildren().get(this.firstLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 2) {
            this.secondLvlP.getChildren().remove(this.secondLvlP.getChildren().indexOf(par));
            this.secondLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.secondLvl.getChildren().get(this.secondLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 3) {
            this.thirdLvlP.getChildren().remove(this.thirdLvlP.getChildren().indexOf(par));
            this.thirdLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.thirdLvl.getChildren().get(this.thirdLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 4) {
            this.fourthLvlP.getChildren().remove(this.fourthLvlP.getChildren().indexOf(par));
            this.fourthLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.fourthLvl.getChildren().get(this.fourthLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 5) {
            this.fifthLvlP.getChildren().remove(this.fifthLvlP.getChildren().indexOf(par));
            this.fifthLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.fifthLvl.getChildren().get(this.fifthLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 6) {
            this.sixthLvlP.getChildren().remove(this.sixthLvlP.getChildren().indexOf(par));
            this.sixthLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.sixthLvl.getChildren().get(this.sixthLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 7) {
            this.seventhLvlP.getChildren().remove(this.seventhLvlP.getChildren().indexOf(par));
            this.seventhLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.seventhLvl.getChildren().get(this.seventhLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 8) {
            this.eighthLvlP.getChildren().remove(this.eighthLvlP.getChildren().indexOf(par));
            this.eighthLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.eighthLvl.getChildren().get(this.eighthLvl.getChildren().indexOf(par))).getUserData();
        } else if (index == 9) {
            this.ninthLvlP.getChildren().remove(this.ninthLvlP.getChildren().indexOf(par));
            this.ninthLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.ninthLvl.getChildren().get(this.ninthLvl.getChildren().indexOf(par))).getUserData();
        } else {
            this.aboveNinthLvlP.getChildren().remove(this.aboveNinthLvlP.getChildren().indexOf(par));
            this.aboveNinthLvl.getChildren().add(par);
            spellCont = (SpellCard)((Node)this.aboveNinthLvl.getChildren().get(this.aboveNinthLvl.getChildren().indexOf(par))).getUserData();
        }

        spellCont.setSpell(spell);
        spellCont.load();
        spellCont.uPrep();
        this.sortSpells();
    }

    public void deleteSpell(Spell spell, Parent par, boolean prepared) {
        int index;
        if (prepared) {
            index = spell.getLvl();
            if (index == 0) {
                this.CantripsP.getChildren().remove(this.CantripsP.getChildren().indexOf(par));
            } else if (index == 1) {
                this.firstLvlP.getChildren().remove(this.firstLvlP.getChildren().indexOf(par));
            } else if (index == 2) {
                this.secondLvlP.getChildren().remove(this.secondLvlP.getChildren().indexOf(par));
            } else if (index == 3) {
                this.thirdLvlP.getChildren().remove(this.thirdLvlP.getChildren().indexOf(par));
            } else if (index == 4) {
                this.fourthLvlP.getChildren().remove(this.fourthLvlP.getChildren().indexOf(par));
            } else if (index == 5) {
                this.fifthLvlP.getChildren().remove(this.fifthLvlP.getChildren().indexOf(par));
            } else if (index == 6) {
                this.sixthLvlP.getChildren().remove(this.sixthLvlP.getChildren().indexOf(par));
            } else if (index == 7) {
                this.seventhLvlP.getChildren().remove(this.seventhLvlP.getChildren().indexOf(par));
            } else if (index == 8) {
                this.eighthLvlP.getChildren().remove(this.eighthLvlP.getChildren().indexOf(par));
            } else if (index == 9) {
                this.ninthLvlP.getChildren().remove(this.ninthLvlP.getChildren().indexOf(par));
            } else {
                this.aboveNinthLvlP.getChildren().remove(this.aboveNinthLvlP.getChildren().indexOf(par));
            }
        } else {
            index = spell.getLvl();
            if (index == 0) {
                this.Cantrips.getChildren().remove(this.Cantrips.getChildren().indexOf(par));
            } else if (index == 1) {
                this.firstLvl.getChildren().remove(this.firstLvl.getChildren().indexOf(par));
            } else if (index == 2) {
                this.secondLvl.getChildren().remove(this.secondLvl.getChildren().indexOf(par));
            } else if (index == 3) {
                this.thirdLvl.getChildren().remove(this.thirdLvl.getChildren().indexOf(par));
            } else if (index == 4) {
                this.fourthLvl.getChildren().remove(this.fourthLvl.getChildren().indexOf(par));
            } else if (index == 5) {
                this.fifthLvl.getChildren().remove(this.fifthLvl.getChildren().indexOf(par));
            } else if (index == 6) {
                this.sixthLvl.getChildren().remove(this.sixthLvl.getChildren().indexOf(par));
            } else if (index == 7) {
                this.seventhLvl.getChildren().remove(this.seventhLvl.getChildren().indexOf(par));
            } else if (index == 8) {
                this.eighthLvl.getChildren().remove(this.eighthLvl.getChildren().indexOf(par));
            } else if (index == 9) {
                this.ninthLvl.getChildren().remove(this.ninthLvl.getChildren().indexOf(par));
            } else {
                this.aboveNinthLvl.getChildren().remove(this.aboveNinthLvl.getChildren().indexOf(par));
            }
        }

        this.sortSpells();
    }

    public void saveSpells(ActionEvent actionEvent) {
        Iterator var2 = this.Cantrips.getChildren().iterator();

        Node t;
        SpellCard spellCard;
        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.firstLvl.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.secondLvl.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.thirdLvl.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.fourthLvl.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.fifthLvl.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.sixthLvl.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.seventhLvl.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.eighthLvl.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.ninthLvl.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.aboveNinthLvl.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.CantripsP.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.firstLvlP.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.secondLvlP.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.thirdLvlP.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.fourthLvlP.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.fifthLvlP.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.sixthLvlP.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.seventhLvlP.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.eighthLvlP.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.ninthLvlP.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

        var2 = this.aboveNinthLvlP.getChildren().iterator();

        while(var2.hasNext()) {
            t = (Node)var2.next();
            spellCard = (SpellCard)t.getUserData();
            spellCard.saveSpell();
        }

    }

    public String getCharName() {
        return this.characterName.getText();
    }

    public void sortSpells() {
        Sorter.sort(this.CantripsP);
        Sorter.sort(this.firstLvlP);
        Sorter.sort(this.secondLvlP);
        Sorter.sort(this.thirdLvlP);
        Sorter.sort(this.fourthLvlP);
        Sorter.sort(this.fifthLvlP);
        Sorter.sort(this.sixthLvlP);
        Sorter.sort(this.seventhLvlP);
        Sorter.sort(this.eighthLvlP);
        Sorter.sort(this.ninthLvlP);
        Sorter.sort(this.aboveNinthLvlP);
        Sorter.sort(this.Cantrips);
        Sorter.sort(this.firstLvl);
        Sorter.sort(this.secondLvl);
        Sorter.sort(this.thirdLvl);
        Sorter.sort(this.fourthLvl);
        Sorter.sort(this.fifthLvl);
        Sorter.sort(this.sixthLvl);
        Sorter.sort(this.seventhLvl);
        Sorter.sort(this.eighthLvl);
        Sorter.sort(this.ninthLvl);
        Sorter.sort(this.aboveNinthLvl);
    }

    public void loadSpells(ActionEvent actionEvent) throws Exception {
        File spellFolder = Main.chooserSpell();
        File[] listFiles = spellFolder.listFiles();
        Loader loader = new Loader();
        File[] var5 = listFiles;
        int var6 = listFiles.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            File f = var5[var7];
            loader.loadSpell(f);
        }

        this.sortSpells();
    }

    /*
    Used to calculate the Initiative
    Not coded in Autofill because it does not use change listeners
     */
    public void updateInit() {
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
        Parent load = (Parent)loader.load();
        OptionsPop.initModality(Modality.APPLICATION_MODAL);
        OptionsPop.initOwner(Main.getStage());
        OptionsPop.centerOnScreen();
        OptionsPop.setScene(new Scene(load, 600.0D, 400.0D));
        OptionsPop.show();
    }
}
