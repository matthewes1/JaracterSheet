package Rain.HelperClasses;

import Rain.MainPackage.JaracterSheetController;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

/**
 * Class full of methods for auto calculation of numbers and listening to changing fields
 * If some of these change, it changes the saved state
 */
public class AutoFill {
    public AutoFill() {
    }

    /**
     * Registers a listener to the abilityScore provided. When it changes, it updates the modifier and sign
     * @param abilityScore          The score that will listened to
     * @param abilityModifier       The modifier that is calculated from the score
     * @param modifierSymbol        The symbol used to display the sign of the modifier
     * @param initiativeUpdater     Initiative selection box, used to update initiative if the abilityScore is selected for initiative calculation
     */
    public static void registerAbilityScore(TextField abilityScore, TextField abilityModifier, TextField modifierSymbol, CheckMenuItem initiativeUpdater) {
        abilityScore.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.isEmpty() && !newValue.matches("-") && !newValue.matches(oldValue)) {
                //Calculates the ability modifier from the new score
                double score = Double.parseDouble(newValue);
                score -= 10;
                score /= 2;
                if (score < 0 && (score % 1 != 0)) {
                    score -= .5;
                }
                abilityModifier.setText(String.valueOf(Math.abs((int) score)));

                if (score > 0) {
                    modifierSymbol.setText("+");
                } else if (score < 0) {
                    modifierSymbol.setText("-");
                } else {
                    modifierSymbol.setText("");
                }

                if (initiativeUpdater.isSelected()) {
                    initiativeUpdater.setSelected(!initiativeUpdater.isSelected());
                    initiativeUpdater.setSelected(!initiativeUpdater.isSelected());
                }

                JaracterSheetController.setUnSaved();
            }
        });
    }

    /**
     * Calculates proficiency bonus from player level whenever player level is changed
     * @param level         Spinner that contains the character level
     * @param proficiency   Field that contains the characters proficiency bonus
     */
    public static void registerProficiency(Spinner level, TextField proficiency) {
        level.getEditor().textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.isEmpty() && !newValue.matches("-")) {
                int levelNumber = Integer.parseInt(newValue);
                if (levelNumber < 5) {
                    proficiency.setText("2");
                } else if (levelNumber < 9) {
                    proficiency.setText("3");
                } else if (levelNumber < 13) {
                    proficiency.setText("4");
                } else if (levelNumber < 17) {
                    proficiency.setText("5");
                } else {
                    proficiency.setText("6");
                }
            }
        });
    }

    /**
     * Updates the skill bonus if the character changes proficiency in that skill
     * @param skillBonus                Field that contains the bonus
     * @param proficiencySelection      Contains the proficiency bonus the character has
     */
    public static void updateSkillsProficiency(TextField skillBonus, ChoiceBox proficiencySelection) {
        skillBonus.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            int selected = proficiencySelection.getSelectionModel().getSelectedIndex();
            if (selected == 0) {
                proficiencySelection.getSelectionModel().select(1);
            } else {
                proficiencySelection.getSelectionModel().select(0);
            }

            //Toggles the selection so the bonus updates
            proficiencySelection.getSelectionModel().select(selected);
        });
    }

    /**
     * Updates the skill bonuses if a character gets a custom proficiency
     * @param proficiencyBonus          The proficiency bonus symbol
     * @param proficiencySelection      The skill to be toggled for updating
     */
    public static void registerProficiencySymbol(ChoiceBox proficiencyBonus, ChoiceBox proficiencySelection) {
        proficiencyBonus.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            int selected = proficiencySelection.getSelectionModel().getSelectedIndex();
            if (selected == 0) {
                proficiencySelection.getSelectionModel().select(1);
            } else {
                proficiencySelection.getSelectionModel().select(0);
            }

            //Toggles selection to auto update
            proficiencySelection.getSelectionModel().select(selected);
            JaracterSheetController.setUnSaved();
        });
    }

    /**
     * Calculates the skill bonus a character has. This method uses the ability score instead of the modifier
     * because the modifier by itself does not entail whether or not it is negative
     * @param skillBonus                The bonus field
     * @param proficiencyChoice         Box that holds the level of proficiency in the skill
     * @param proficiency               Proficiency bonus
     * @param abilityScore              The score of the ability the skill depends on
     * @param customProficiencySign     The sign of the custom proficiency
     * @param customProficiency         Custom proficiency bonus
     */
    public static void registerSkill(TextField skillBonus, ChoiceBox proficiencyChoice, TextField proficiency, TextField abilityScore, ChoiceBox customProficiencySign, TextField customProficiency) {
        proficiencyChoice.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (!abilityScore.getText().isEmpty() && !abilityScore.getText().matches("-")) {
                int score = Integer.parseInt(abilityScore.getText());
                score -= 10;
                score /= 2;
                score += Integer.parseInt(proficiency.getText()) * proficiencyChoice.getSelectionModel().getSelectedIndex();
                int proficiencyBonus = Integer.parseInt(customProficiency.getText()) * proficiencyChoice.getSelectionModel().getSelectedIndex();
                if (customProficiencySign.getSelectionModel().getSelectedIndex() == 0) {
                    proficiencyBonus = -proficiencyBonus;
                }

                score += proficiencyBonus;
                String bonus = skillBonus.getText();
                bonus = bonus.substring(0, bonus.indexOf(": ") + 2);
                skillBonus.setText(bonus + score);
            }
            JaracterSheetController.setUnSaved();
        });
    }

    /**
     * Updates the skill if the modifier gets updated
     * @param abilityModifier       The modifier that the skill uses
     * @param proficiencyChoice     The selection of proficiency in the skill
     */
    public static void linkStats(TextField abilityModifier, ChoiceBox proficiencyChoice) {
        abilityModifier.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!oldValue.matches(newValue)) {
                int proficiency = proficiencyChoice.getSelectionModel().getSelectedIndex();
                if (proficiency == 0) {
                    proficiencyChoice.getSelectionModel().select(1);
                } else {
                    proficiencyChoice.getSelectionModel().select(0);
                }

                proficiencyChoice.getSelectionModel().select(proficiency);
            }
        });
    }

    /**
     * Calculates passive perception
     * @param passivePerception     Field that contains passive perception
     * @param perception            Perception skill
     */
    public static void passivePerception(TextField passivePerception, TextField perception) {
        perception.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!oldValue.matches(newValue) && !newValue.matches("")) {
                String perceptionModifier = perception.getText();
                perceptionModifier = perceptionModifier.substring(12);

                int passivePerceptionString = 10;
                passivePerceptionString += Integer.valueOf(perceptionModifier);
                passivePerception.setText(String.valueOf(passivePerceptionString));
            }
        });
    }

    /**
     * Appends the experience needed for the next level to the current experience
     * @param experience        Experience field
     * @param levelSpinner      Character level
     */
    public static void experienceFiller(TextField experience, Spinner levelSpinner) {
        levelSpinner.getEditor().textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!oldValue.matches(newValue)) {
                int level = Integer.parseInt(newValue);
                String experienceString = experience.getText();
                experienceString = experienceString.substring(0, experienceString.indexOf("/"));

                //Decides which XP is needed
                if (level == 1) {
                    experienceString = experienceString.concat("/300");
                } else if (level == 2) {
                    experienceString = experienceString.concat("/900");
                } else if (level == 3) {
                    experienceString = experienceString.concat("/2,700");
                } else if (level == 4) {
                    experienceString = experienceString.concat("/6,500");
                } else if (level == 5) {
                    experienceString = experienceString.concat("/14,000");
                } else if (level == 6) {
                    experienceString = experienceString.concat("/23,000");
                } else if (level == 7) {
                    experienceString = experienceString.concat("/34,000");
                } else if (level == 8) {
                    experienceString = experienceString.concat("/48,000");
                } else if (level == 9) {
                    experienceString = experienceString.concat("/64,000");
                } else if (level == 10) {
                    experienceString = experienceString.concat("/85,000");
                } else if (level == 11) {
                    experienceString = experienceString.concat("/100,000");
                } else if (level == 12) {
                    experienceString = experienceString.concat("/120,000");
                } else if (level == 13) {
                    experienceString = experienceString.concat("/140,000");
                } else if (level == 14) {
                    experienceString = experienceString.concat("/165,000");
                } else if (level == 15) {
                    experienceString = experienceString.concat("/195,000");
                } else if (level == 16) {
                    experienceString = experienceString.concat("/225,000");
                } else if (level == 17) {
                    experienceString = experienceString.concat("/265,000");
                } else if (level == 18) {
                    experienceString = experienceString.concat("/305,000");
                } else if (level == 19) {
                    experienceString = experienceString.concat("/355,000");
                } else if (level == 20) {
                    experienceString = experienceString.concat("/355,000");
                } else if (level == 0) {
                    experienceString = experienceString.concat("/300");
                } else {
                    experienceString = experienceString.concat("/355,000");
                }

                experience.setText(experienceString);
                JaracterSheetController.setUnSaved();
            }
        });
    }
}
