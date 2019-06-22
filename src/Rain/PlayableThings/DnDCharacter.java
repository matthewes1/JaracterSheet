package Rain.PlayableThings;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Character object for dnd 5e SRD and some added homebrew customizations such as the following:
 * Custom skills for initiative
 * Custom bonus to proficiency
 * Custom bonus to initiative
 */
@XmlRootElement
public class DnDCharacter {
    private String strengthField;
    private String dexterityField;
    private String constitutionField;
    private String intelligenceField;
    private String wisdomField;
    private String charismaField;
    private String speedField;
    private String experienceField;
    private String ageField;
    private String weightField;
    private String proficiencyBonus;
    private String acField;
    private String strengthModifierField;
    private String dexterityModifier;
    private String constitutionModifier;
    private String intelligenceModifier;
    private String wisdomModifier;
    private String charismaModifier;
    private String charismaSave;
    private String constitutionSave;
    private String intelligenceSave;
    private String dexteritySave;
    private String strengthSave;
    private String wisdomSave;
    private String acrobatics;
    private String animalHandling;
    private String arcana;
    private String athletics;
    private String deception;
    private String history;
    private String insight;
    private String intimidation;
    private String investigation;
    private String medicine;
    private String nature;
    private String perception;
    private String performance;
    private String persuasion;
    private String religion;
    private String sleightOfHand;
    private String stealth;
    private String survival;
    private String initiativeField;
    private String characterName;
    private String classField;
    private String raceField;
    private String playerNameField;
    private String passivePerceptionField;
    private String counterOne;
    private String counterTwo;
    private String counterThree;
    private String counterFour;
    private String counterFive;
    private String counterSix;
    private String counterSeven;
    private String counterEight;
    private String counterNine;
    private String counterTen;
    private String counterEleven;
    private String counterTwelve;
    private String counterThirteen;
    private String counterFourteen;
    private String counterFifteen;
    private String counterSixteen;
    private String weaponNameOne;
    private String weaponNameThree;
    private String weaponNameTwo;
    private String attackBonusOne;
    private String attackBonusTwo;
    private String attackBonusThree;
    private String damageThree;
    private String damageOne;
    private String damageTwo;
    private String eyes;
    private String height;
    private String skin;
    private String hair;
    private String backStory;
    private String inventoryThree;
    private String inventoryFour;
    private String traitsField;
    private String idealsField;
    private String bondsField;
    private String flawsField;
    private String weapons;
    private String armor;
    private String language;
    private String feats;
    private String miscellaneousOne;
    private String currentHPString;
    private String maxHpString;
    private String tempHPString;
    private String hitDieString;
    private String levelString;
    private String copper;
    private String silver;
    private String electrum;
    private String gold;
    private String platinum;
    private String spinnerOne;
    private String spinnerTwo;
    private String spinnerThree;
    private String spinnerFour;
    private String spinnerFive;
    private String spinnerSix;
    private String spinnerSeven;
    private String spinnerEight;
    private String spinnerNine;
    private String spinnerTen;
    private String spinnerEleven;
    private String spinnerTwelve;
    private String spinnerThirteen;
    private String spinnerFourteen;
    private String spinnerFifteen;
    private String spinnerSixteen;
    private String inventoryOne;
    private String inventoryTwo;
    private String customInitiativeField;
    private String proficiencyBonusExtra;
    private int strengthChoice;
    private int dexterityChoice;
    private int constitutionChoice;
    private int intelligenceChoice;
    private int wisdomChoice;
    private int charismaChoice;
    private int acrobaticsChoice;
    private int animalChoice;
    private int arcanaChoice;
    private int athleticsChoice;
    private int deceptionChoice;
    private int historyChoice;
    private int insightChoice;
    private int intimidationChoice;
    private int investigationChoice;
    private int medicineChoice;
    private int natureChoice;
    private int perceptionChoice;
    private int performanceChoice;
    private int persuasionChoice;
    private int religionChoice;
    private int sleightOfHandChoice;
    private int stealthChoice;
    private int survivalChoice;
    private int alignment;
    private int hitDieType;
    private Boolean deathFailOne;
    private Boolean deathFailTwo;
    private Boolean deathFailThree;
    private Boolean deathSaveOne;
    private Boolean deathSaveTwo;
    private Boolean deathSaveThree;
    private Boolean inspirationOne;
    private Boolean inspirationTwo;
    private Boolean inspirationFour;
    private Boolean inspirationThree;
    private Boolean inspirationFive;
    private Boolean strengthInitiative;
    private Boolean dexterityInitiative;
    private Boolean constitutionInitiative;
    private Boolean intelligenceInitiative;
    private Boolean wisdomInitiative;
    private Boolean charismaInitiative;
    private Boolean customInitiative;

    public DnDCharacter() {
    }

    //PlayerNameArea
    @XmlElement
    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    @XmlElement
    public String getClassField() {
        return classField;
    }

    public void setClassField(String classField) {
        this.classField = classField;
    }

    @XmlElement
    public String getLevelString() {
        return levelString;
    }

    public void setLevelString(String levelString) {
        this.levelString = levelString;
    }

    @XmlElement
    public String getPlayerNameField() {
        return playerNameField;
    }

    public void setPlayerNameField(String playerNameField) {
        this.playerNameField = playerNameField;
    }

    @XmlElement
    public String getRaceField() {
        return raceField;
    }

    public void setRaceField(String raceField) {
        this.raceField = raceField;
    }

    @XmlElement
    public int getAlignment() {
        return alignment;
    }

    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    @XmlElement
    public String getStrengthField() {
        return strengthField;
    }

    public void setStrengthField(String strengthField) {
        this.strengthField = strengthField;
    }

    @XmlElement
    public String getDexterityField() {
        return dexterityField;
    }

    public void setDexterityField(String dexterityField) {
        this.dexterityField = dexterityField;
    }

    @XmlElement
    public String getConstitutionField() {
        return constitutionField;
    }

    public void setConstitutionField(String constitutionField) {
        this.constitutionField = constitutionField;
    }

    @XmlElement
    public String getIntelligenceField() {
        return intelligenceField;
    }

    public void setIntelligenceField(String intelligenceField) {
        this.intelligenceField = intelligenceField;
    }

    @XmlElement
    public String getWisdomField() {
        return wisdomField;
    }

    public void setWisdomField(String wisdomField) {
        this.wisdomField = wisdomField;
    }

    @XmlElement
    public String getCharismaField() {
        return charismaField;
    }

    public void setCharismaField(String charismaField) {
        this.charismaField = charismaField;
    }

    @XmlElement
    public String getSpeedField() {
        return speedField;
    }

    public void setSpeedField(String speedField) {
        this.speedField = speedField;
    }

    @XmlElement
    public String getExperienceField() {
        return experienceField;
    }

    public void setExperienceField(String experienceField) {
        this.experienceField = experienceField;
    }

    @XmlElement
    public String getAgeField() {
        return ageField;
    }

    public void setAgeField(String ageField) {
        this.ageField = ageField;
    }

    @XmlElement
    public String getWeightField() {
        return weightField;
    }

    public void setWeightField(String weightField) {
        this.weightField = weightField;
    }

    @XmlElement
    public String getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(String proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    @XmlElement
    public String getAcField() {
        return acField;
    }

    public void setAcField(String acField) {
        this.acField = acField;
    }

    @XmlElement
    public String getStrengthModifierField() {
        return strengthModifierField;
    }

    public void setStrengthModifierField(String strengthModifierField) {
        this.strengthModifierField = strengthModifierField;
    }

    @XmlElement
    public String getDexterityModifier() {
        return dexterityModifier;
    }

    public void setDexterityModifier(String dexterityModifier) {
        this.dexterityModifier = dexterityModifier;
    }

    @XmlElement
    public String getConstitutionModifier() {
        return constitutionModifier;
    }

    public void setConstitutionModifier(String constitutionModifier) {
        this.constitutionModifier = constitutionModifier;
    }

    @XmlElement
    public String getIntelligenceModifier() {
        return intelligenceModifier;
    }

    public void setIntelligenceModifier(String intelligenceModifier) {
        this.intelligenceModifier = intelligenceModifier;
    }

    @XmlElement
    public String getWisdomModifier() {
        return wisdomModifier;
    }

    public void setWisdomModifier(String wisdomModifier) {
        this.wisdomModifier = wisdomModifier;
    }

    @XmlElement
    public String getCharismaModifier() {
        return charismaModifier;
    }

    public void setCharismaModifier(String charismaModifier) {
        this.charismaModifier = charismaModifier;
    }

    @XmlElement
    public String getCharismaSave() {
        return charismaSave;
    }

    public void setCharismaSave(String charismaSave) {
        this.charismaSave = charismaSave;
    }

    @XmlElement
    public String getIntelligenceSave() {
        return intelligenceSave;
    }

    public void setIntelligenceSave(String intelligenceSave) {
        this.intelligenceSave = intelligenceSave;
    }

    @XmlElement
    public String getDexteritySave() {
        return dexteritySave;
    }

    public void setDexteritySave(String dexteritySave) {
        this.dexteritySave = dexteritySave;
    }

    @XmlElement
    public String getStrengthSave() {
        return strengthSave;
    }

    public void setStrengthSave(String strengthSave) {
        this.strengthSave = strengthSave;
    }

    @XmlElement
    public String getWisdomSave() {
        return wisdomSave;
    }

    public void setWisdomSave(String wisdomSave) {
        this.wisdomSave = wisdomSave;
    }

    @XmlElement
    public String getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(String acrobatics) {
        this.acrobatics = acrobatics;
    }

    @XmlElement
    public String getAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(String animalHandling) {
        this.animalHandling = animalHandling;
    }

    @XmlElement
    public String getArcana() {
        return arcana;
    }

    public void setArcana(String arcana) {
        this.arcana = arcana;
    }

    @XmlElement
    public String getAthletics() {
        return athletics;
    }

    public void setAthletics(String athletics) {
        this.athletics = athletics;
    }

    @XmlElement
    public String getDeception() {
        return deception;
    }

    public void setDeception(String deception) {
        this.deception = deception;
    }

    @XmlElement
    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @XmlElement
    public String getInsight() {
        return insight;
    }

    public void setInsight(String insight) {
        this.insight = insight;
    }

    @XmlElement
    public String getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(String intimidation) {
        this.intimidation = intimidation;
    }

    @XmlElement
    public String getInvestigation() {
        return investigation;
    }

    public void setInvestigation(String investigation) {
        this.investigation = investigation;
    }

    @XmlElement
    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    @XmlElement
    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    @XmlElement
    public String getPerception() {
        return perception;
    }

    public void setPerception(String perception) {
        this.perception = perception;
    }

    @XmlElement
    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @XmlElement
    public String getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(String persuasion) {
        this.persuasion = persuasion;
    }

    @XmlElement
    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    @XmlElement
    public String getSleightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(String sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
    }

    @XmlElement
    public String getStealth() {
        return stealth;
    }

    public void setStealth(String stealth) {
        this.stealth = stealth;
    }

    @XmlElement
    public String getSurvival() {
        return survival;
    }

    public void setSurvival(String survival) {
        this.survival = survival;
    }

    @XmlElement
    public String getInitiativeField() {
        return initiativeField;
    }

    public void setInitiativeField(String initiativeField) {
        this.initiativeField = initiativeField;
    }

    @XmlElement
    public String getPassivePerceptionField() {
        return passivePerceptionField;
    }

    public void setPassivePerceptionField(String passivePerceptionField) {
        this.passivePerceptionField = passivePerceptionField;
    }

    @XmlElement
    public String getCounterOne() {
        return counterOne;
    }

    public void setCounterOne(String counterOne) {
        this.counterOne = counterOne;
    }

    @XmlElement
    public String getCounterTwo() {
        return counterTwo;
    }

    public void setCounterTwo(String counterTwo) {
        this.counterTwo = counterTwo;
    }

    @XmlElement
    public String getCounterThree() {
        return counterThree;
    }

    public void setCounterThree(String counterThree) {
        this.counterThree = counterThree;
    }

    @XmlElement
    public String getCounterFour() {
        return counterFour;
    }

    public void setCounterFour(String counterFour) {
        this.counterFour = counterFour;
    }

    @XmlElement
    public String getCounterFive() {
        return counterFive;
    }

    public void setCounterFive(String counterFive) {
        this.counterFive = counterFive;
    }

    @XmlElement
    public String getCounterSix() {
        return counterSix;
    }

    public void setCounterSix(String counterSix) {
        this.counterSix = counterSix;
    }

    @XmlElement
    public String getCounterSeven() {
        return counterSeven;
    }

    public void setCounterSeven(String counterSeven) {
        this.counterSeven = counterSeven;
    }

    @XmlElement
    public String getCounterEight() {
        return counterEight;
    }

    public void setCounterEight(String counterEight) {
        this.counterEight = counterEight;
    }

    @XmlElement
    public String getCounterSixteen() {
        return counterSixteen;
    }

    public void setCounterSixteen(String counterSixteen) {
        this.counterSixteen = counterSixteen;
    }

    @XmlElement
    public String getCounterFifteen() {
        return counterFifteen;
    }

    public void setCounterFifteen(String counterFifteen) {
        this.counterFifteen = counterFifteen;
    }

    @XmlElement
    public String getCounterFourteen() {
        return counterFourteen;
    }

    public void setCounterFourteen(String counterFourteen) {
        this.counterFourteen = counterFourteen;
    }

    @XmlElement
    public String getCounterThirteen() {
        return counterThirteen;
    }

    public void setCounterThirteen(String counterThirteen) {
        this.counterThirteen = counterThirteen;
    }

    @XmlElement
    public String getCounterTwelve() {
        return counterTwelve;
    }

    public void setCounterTwelve(String counterTwelve) {
        this.counterTwelve = counterTwelve;
    }

    @XmlElement
    public String getCounterEleven() {
        return counterEleven;
    }

    public void setCounterEleven(String counterEleven) {
        this.counterEleven = counterEleven;
    }

    @XmlElement
    public String getCounterTen() {
        return counterTen;
    }

    public void setCounterTen(String counterTen) {
        this.counterTen = counterTen;
    }

    @XmlElement
    public String getCounterNine() {
        return counterNine;
    }

    public void setCounterNine(String counterNine) {
        this.counterNine = counterNine;
    }

    @XmlElement
    public String getWeaponNameOne() {
        return weaponNameOne;
    }

    public void setWeaponNameOne(String weaponNameOne) {
        this.weaponNameOne = weaponNameOne;
    }

    @XmlElement
    public String getWeaponNameThree() {
        return weaponNameThree;
    }

    public void setWeaponNameThree(String weaponNameThree) {
        this.weaponNameThree = weaponNameThree;
    }

    @XmlElement
    public String getWeaponNameTwo() {
        return weaponNameTwo;
    }

    public void setWeaponNameTwo(String weaponNameTwo) {
        this.weaponNameTwo = weaponNameTwo;
    }

    @XmlElement
    public String getAttackBonusOne() {
        return attackBonusOne;
    }

    public void setAttackBonusOne(String attackBonusOne) {
        this.attackBonusOne = attackBonusOne;
    }

    @XmlElement
    public String getAttackBonusTwo() {
        return attackBonusTwo;
    }

    public void setAttackBonusTwo(String attackBonusTwo) {
        this.attackBonusTwo = attackBonusTwo;
    }

    @XmlElement
    public String getAttackBonusThree() {
        return attackBonusThree;
    }

    public void setAttackBonusThree(String attackBonusThree) {
        this.attackBonusThree = attackBonusThree;
    }

    @XmlElement
    public String getDamageThree() {
        return damageThree;
    }

    public void setDamageThree(String damageThree) {
        this.damageThree = damageThree;
    }

    @XmlElement
    public String getDamageOne() {
        return damageOne;
    }

    public void setDamageOne(String damageOne) {
        this.damageOne = damageOne;
    }

    @XmlElement
    public String getDamageTwo() {
        return damageTwo;
    }

    public void setDamageTwo(String damageTwo) {
        this.damageTwo = damageTwo;
    }

    @XmlElement
    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    @XmlElement
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @XmlElement
    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    @XmlElement
    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    @XmlElement
    public String getBackStory() {
        return backStory;
    }

    public void setBackStory(String backStory) {
        this.backStory = backStory;
    }

    @XmlElement
    public String getInventoryThree() {
        return inventoryThree;
    }

    public void setInventoryThree(String inventoryThree) {
        this.inventoryThree = inventoryThree;
    }

    @XmlElement
    public String getInventoryFour() {
        return inventoryFour;
    }

    public void setInventoryFour(String inventoryFour) {
        this.inventoryFour = inventoryFour;
    }

    @XmlElement
    public String getTraitsField() {
        return traitsField;
    }

    public void setTraitsField(String traitsField) {
        this.traitsField = traitsField;
    }

    @XmlElement
    public String getIdealsField() {
        return idealsField;
    }

    public void setIdealsField(String idealsField) {
        this.idealsField = idealsField;
    }

    @XmlElement
    public String getBondsField() {
        return bondsField;
    }

    public void setBondsField(String bondsField) {
        this.bondsField = bondsField;
    }

    @XmlElement
    public String getFlawsField() {
        return flawsField;
    }

    public void setFlawsField(String flawsField) {
        this.flawsField = flawsField;
    }

    @XmlElement
    public String getWeapons() {
        return weapons;
    }

    public void setWeapons(String weapons) {
        this.weapons = weapons;
    }

    @XmlElement
    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    @XmlElement
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @XmlElement
    public String getFeats() {
        return feats;
    }

    public void setFeats(String feats) {
        this.feats = feats;
    }

    @XmlElement
    public String getMiscellaneousOne() {
        return miscellaneousOne;
    }

    public void setMiscellaneousOne(String miscellaneousOne) {
        this.miscellaneousOne = miscellaneousOne;
    }

    @XmlElement
    public String getCurrentHPString() {
        return currentHPString;
    }

    public void setCurrentHPString(String currentHPString) {
        this.currentHPString = currentHPString;
    }

    @XmlElement
    public String getMaxHpString() {
        return maxHpString;
    }

    public void setMaxHpString(String maxHpString) {
        this.maxHpString = maxHpString;
    }

    @XmlElement
    public String getTempHPString() {
        return tempHPString;
    }

    public void setTempHPString(String tempHPString) {
        this.tempHPString = tempHPString;
    }

    @XmlElement
    public String getHitDieString() {
        return hitDieString;
    }

    public void setHitDieString(String hitDieString) {
        this.hitDieString = hitDieString;
    }

    @XmlElement
    public String getCopper() {
        return copper;
    }

    public void setCopper(String copper) {
        this.copper = copper;
    }

    @XmlElement
    public String getSilver() {
        return silver;
    }

    public void setSilver(String silver) {
        this.silver = silver;
    }

    @XmlElement
    public String getElectrum() {
        return electrum;
    }

    public void setElectrum(String electrum) {
        this.electrum = electrum;
    }

    @XmlElement
    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    @XmlElement
    public String getPlatinum() {
        return platinum;
    }

    public void setPlatinum(String platinum) {
        this.platinum = platinum;
    }

    @XmlElement
    public String getSpinnerFifteen() {
        return spinnerFifteen;
    }

    public void setSpinnerFifteen(String spinnerFifteen) {
        this.spinnerFifteen = spinnerFifteen;
    }

    @XmlElement
    public String getSpinnerSixteen() {
        return spinnerSixteen;
    }

    public void setSpinnerSixteen(String spinnerSixteen) {
        this.spinnerSixteen = spinnerSixteen;
    }

    @XmlElement
    public String getSpinnerFourteen() {
        return spinnerFourteen;
    }

    public void setSpinnerFourteen(String spinnerFourteen) {
        this.spinnerFourteen = spinnerFourteen;
    }

    @XmlElement
    public String getSpinnerThirteen() {
        return spinnerThirteen;
    }

    public void setSpinnerThirteen(String spinnerThirteen) {
        this.spinnerThirteen = spinnerThirteen;
    }

    @XmlElement
    public String getSpinnerTwelve() {
        return spinnerTwelve;
    }

    public void setSpinnerTwelve(String spinnerTwelve) {
        this.spinnerTwelve = spinnerTwelve;
    }

    @XmlElement
    public String getSpinnerEleven() {
        return spinnerEleven;
    }

    public void setSpinnerEleven(String spinnerEleven) {
        this.spinnerEleven = spinnerEleven;
    }

    @XmlElement
    public String getSpinnerTen() {
        return spinnerTen;
    }

    public void setSpinnerTen(String spinnerTen) {
        this.spinnerTen = spinnerTen;
    }

    @XmlElement
    public String getSpinnerNine() {
        return spinnerNine;
    }

    public void setSpinnerNine(String spinnerNine) {
        this.spinnerNine = spinnerNine;
    }

    @XmlElement
    public String getSpinnerEight() {
        return spinnerEight;
    }

    public void setSpinnerEight(String spinnerEight) {
        this.spinnerEight = spinnerEight;
    }

    @XmlElement
    public String getSpinnerSeven() {
        return spinnerSeven;
    }

    public void setSpinnerSeven(String spinnerSeven) {
        this.spinnerSeven = spinnerSeven;
    }

    @XmlElement
    public String getSpinnerSix() {
        return spinnerSix;
    }

    public void setSpinnerSix(String spinnerSix) {
        this.spinnerSix = spinnerSix;
    }

    @XmlElement
    public String getSpinnerFive() {
        return spinnerFive;
    }

    public void setSpinnerFive(String spinnerFive) {
        this.spinnerFive = spinnerFive;
    }

    @XmlElement
    public String getSpinnerFour() {
        return spinnerFour;
    }

    public void setSpinnerFour(String spinnerFour) {
        this.spinnerFour = spinnerFour;
    }

    @XmlElement
    public String getSpinnerThree() {
        return spinnerThree;
    }

    public void setSpinnerThree(String spinnerThree) {
        this.spinnerThree = spinnerThree;
    }

    @XmlElement
    public String getSpinnerTwo() {
        return spinnerTwo;
    }

    public void setSpinnerTwo(String spinnerTwo) {
        this.spinnerTwo = spinnerTwo;
    }

    @XmlElement
    public String getSpinnerOne() {
        return spinnerOne;
    }

    public void setSpinnerOne(String spinnerOne) {
        this.spinnerOne = spinnerOne;
    }

    @XmlElement
    public String getInventoryOne() {
        return inventoryOne;
    }

    public void setInventoryOne(String inventoryOne) {
        this.inventoryOne = inventoryOne;
    }

    @XmlElement
    public String getInventoryTwo() {
        return inventoryTwo;
    }

    public void setInventoryTwo(String inventoryTwo) {
        this.inventoryTwo = inventoryTwo;
    }

    @XmlElement
    public String getCustomInitiativeField() {
        return customInitiativeField;
    }

    public void setCustomInitiativeField(String customInitiativeField) {
        this.customInitiativeField = customInitiativeField;
    }

    @XmlElement
    public String getProficiencyBonusExtra() {
        return proficiencyBonusExtra;
    }

    public void setProficiencyBonusExtra(String proficiencyBonusExtra) {
        this.proficiencyBonusExtra = proficiencyBonusExtra;
    }

    @XmlElement
    public int getStrengthChoice() {
        return strengthChoice;
    }

    public void setStrengthChoice(int strengthChoice) {
        this.strengthChoice = strengthChoice;
    }

    @XmlElement
    public int getDexterityChoice() {
        return dexterityChoice;
    }

    public void setDexterityChoice(int dexterityChoice) {
        this.dexterityChoice = dexterityChoice;
    }

    @XmlElement
    public int getConstitutionChoice() {
        return constitutionChoice;
    }

    public void setConstitutionChoice(int constitutionChoice) {
        this.constitutionChoice = constitutionChoice;
    }

    @XmlElement
    public int getIntelligenceChoice() {
        return intelligenceChoice;
    }

    public void setIntelligenceChoice(int intelligenceChoice) {
        this.intelligenceChoice = intelligenceChoice;
    }

    @XmlElement
    public int getWisdomChoice() {
        return wisdomChoice;
    }

    public void setWisdomChoice(int wisdomChoice) {
        this.wisdomChoice = wisdomChoice;
    }

    @XmlElement
    public int getCharismaChoice() {
        return charismaChoice;
    }

    public void setCharismaChoice(int charismaChoice) {
        this.charismaChoice = charismaChoice;
    }

    @XmlElement
    public int getAcrobaticsChoice() {
        return acrobaticsChoice;
    }

    public void setAcrobaticsChoice(int acrobaticsChoice) {
        this.acrobaticsChoice = acrobaticsChoice;
    }

    @XmlElement
    public int getAnimalChoice() {
        return animalChoice;
    }

    public void setAnimalChoice(int animalChoice) {
        this.animalChoice = animalChoice;
    }

    @XmlElement
    public int getArcanaChoice() {
        return arcanaChoice;
    }

    public void setArcanaChoice(int arcanaChoice) {
        this.arcanaChoice = arcanaChoice;
    }

    @XmlElement
    public int getAthleticsChoice() {
        return athleticsChoice;
    }

    public void setAthleticsChoice(int athleticsChoice) {
        this.athleticsChoice = athleticsChoice;
    }

    @XmlElement
    public int getDeceptionChoice() {
        return deceptionChoice;
    }

    public void setDeceptionChoice(int deceptionChoice) {
        this.deceptionChoice = deceptionChoice;
    }

    @XmlElement
    public int getHistoryChoice() {
        return historyChoice;
    }

    public void setHistoryChoice(int historyChoice) {
        this.historyChoice = historyChoice;
    }

    @XmlElement
    public int getInsightChoice() {
        return insightChoice;
    }

    public void setInsightChoice(int insightChoice) {
        this.insightChoice = insightChoice;
    }

    @XmlElement
    public int getIntimidationChoice() {
        return intimidationChoice;
    }

    public void setIntimidationChoice(int intimidationChoice) {
        this.intimidationChoice = intimidationChoice;
    }

    @XmlElement
    public int getInvestigationChoice() {
        return investigationChoice;
    }

    public void setInvestigationChoice(int investigationChoice) {
        this.investigationChoice = investigationChoice;
    }

    @XmlElement
    public int getMedicineChoice() {
        return medicineChoice;
    }

    public void setMedicineChoice(int medicineChoice) {
        this.medicineChoice = medicineChoice;
    }

    @XmlElement
    public int getNatureChoice() {
        return natureChoice;
    }

    public void setNatureChoice(int natureChoice) {
        this.natureChoice = natureChoice;
    }

    @XmlElement
    public int getPerceptionChoice() {
        return perceptionChoice;
    }

    public void setPerceptionChoice(int perceptionChoice) {
        this.perceptionChoice = perceptionChoice;
    }

    @XmlElement
    public int getPerformanceChoice() {
        return performanceChoice;
    }

    public void setPerformanceChoice(int performanceChoice) {
        this.performanceChoice = performanceChoice;
    }

    @XmlElement
    public int getPersuasionChoice() {
        return persuasionChoice;
    }

    public void setPersuasionChoice(int persuasionChoice) {
        this.persuasionChoice = persuasionChoice;
    }

    @XmlElement
    public int getReligionChoice() {
        return religionChoice;
    }

    public void setReligionChoice(int religionChoice) {
        this.religionChoice = religionChoice;
    }

    @XmlElement
    public int getSleightOfHandChoice() {
        return sleightOfHandChoice;
    }

    public void setSleightOfHandChoice(int sleightOfHandChoice) {
        this.sleightOfHandChoice = sleightOfHandChoice;
    }

    @XmlElement
    public int getStealthChoice() {
        return stealthChoice;
    }

    public void setStealthChoice(int stealthChoice) {
        this.stealthChoice = stealthChoice;
    }

    @XmlElement
    public int getSurvivalChoice() {
        return survivalChoice;
    }

    public void setSurvivalChoice(int survivalChoice) {
        this.survivalChoice = survivalChoice;
    }

    @XmlElement
    public int getHitDieType() {
        return hitDieType;
    }

    public void setHitDieType(int hitDieType) {
        this.hitDieType = hitDieType;
    }

    @XmlElement
    public Boolean getDeathFailOne() {
        return deathFailOne;
    }

    public void setDeathFailOne(Boolean deathFailOne) {
        this.deathFailOne = deathFailOne;
    }

    @XmlElement
    public Boolean getDeathFailTwo() {
        return deathFailTwo;
    }

    public void setDeathFailTwo(Boolean deathFailTwo) {
        this.deathFailTwo = deathFailTwo;
    }

    @XmlElement
    public Boolean getDeathFailThree() {
        return deathFailThree;
    }

    public void setDeathFailThree(Boolean deathFailThree) {
        this.deathFailThree = deathFailThree;
    }

    @XmlElement
    public Boolean getDeathSaveOne() {
        return deathSaveOne;
    }

    public void setDeathSaveOne(Boolean deathSaveOne) {
        this.deathSaveOne = deathSaveOne;
    }

    @XmlElement
    public Boolean getDeathSaveTwo() {
        return deathSaveTwo;
    }

    public void setDeathSaveTwo(Boolean deathSaveTwo) {
        this.deathSaveTwo = deathSaveTwo;
    }

    @XmlElement
    public Boolean getDeathSaveThree() {
        return deathSaveThree;
    }

    public void setDeathSaveThree(Boolean deathSaveThree) {
        this.deathSaveThree = deathSaveThree;
    }

    @XmlElement
    public Boolean getInspirationOne() {
        return inspirationOne;
    }

    public void setInspirationOne(Boolean inspirationOne) {
        this.inspirationOne = inspirationOne;
    }

    @XmlElement
    public Boolean getInspirationTwo() {
        return inspirationTwo;
    }

    public void setInspirationTwo(Boolean inspirationTwo) {
        this.inspirationTwo = inspirationTwo;
    }

    @XmlElement
    public Boolean getInspirationFour() {
        return inspirationFour;
    }

    public void setInspirationFour(Boolean inspirationFour) {
        this.inspirationFour = inspirationFour;
    }

    @XmlElement
    public Boolean getInspirationThree() {
        return inspirationThree;
    }

    public void setInspirationThree(Boolean inspirationThree) {
        this.inspirationThree = inspirationThree;
    }

    @XmlElement
    public Boolean getInspirationFive() {
        return inspirationFive;
    }

    public void setInspirationFive(Boolean inspirationFive) {
        this.inspirationFive = inspirationFive;
    }

    @XmlElement
    public Boolean getStrengthInitiative() {
        return strengthInitiative;
    }

    public void setStrengthInitiative(Boolean strengthInitiative) {
        this.strengthInitiative = strengthInitiative;
    }

    @XmlElement
    public Boolean getDexterityInitiative() {
        return dexterityInitiative;
    }

    public void setDexterityInitiative(Boolean dexterityInitiative) {
        this.dexterityInitiative = dexterityInitiative;
    }

    @XmlElement
    public Boolean getConstitutionInitiative() {
        return constitutionInitiative;
    }

    public void setConstitutionInitiative(Boolean constitutionInitiative) {
        this.constitutionInitiative = constitutionInitiative;
    }

    @XmlElement
    public Boolean getIntelligenceInitiative() {
        return intelligenceInitiative;
    }

    public void setIntelligenceInitiative(Boolean intelligenceinitiative) {
        this.intelligenceInitiative = intelligenceinitiative;
    }

    @XmlElement
    public Boolean getWisdomInitiative() {
        return wisdomInitiative;
    }

    public void setWisdomInitiative(Boolean wisdomInitiative) {
        this.wisdomInitiative = wisdomInitiative;
    }

    @XmlElement
    public Boolean getCharismaInitiative() {
        return charismaInitiative;
    }

    public void setCharismaInitiative(Boolean charismaInitiative) {
        this.charismaInitiative = charismaInitiative;
    }

    @XmlElement
    public Boolean getCustomInitiative() {
        return customInitiative;
    }

    public void setCustomInitiative(Boolean customInitiative) {
        this.customInitiative = customInitiative;
    }

    @XmlElement
    public String getConstitutionSave() {
        return constitutionSave;
    }

    public void setConstitutionSave(String constitutionSave) {
        this.constitutionSave = constitutionSave;
    }
}
