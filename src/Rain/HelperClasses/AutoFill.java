package Rain.HelperClasses;

import Rain.MainPackage.CharacterSheetController;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class AutoFill {

    /*
    Class full of methods for auto calculation of numbers
    If any of these change, changes saved state
     */
    public AutoFill() {
    }

    /*
    Method used to register a listener for when the ability score is changed.
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

                //Sets the sign for the ability modifier
                if (score > 0) {
                    modifierSymbol.setText("+");
                } else if (score < 0) {
                    modifierSymbol.setText("-");
                } else {
                    modifierSymbol.setText("");
                }

                //If the score is chosen for initiative, toggle it unselected then reselect it so it updates
                if (initiativeUpdater.isSelected()) {
                    initiativeUpdater.setSelected(!initiativeUpdater.isSelected());
                    initiativeUpdater.setSelected(!initiativeUpdater.isSelected());
                }

                CharacterSheetController.setUnSaved();
            }
        });
    }

    /*
    Auto calculates proficiency bonus from player level
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

    /*
    Calculates the bonus from a skill if you have proficiency in it
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

    /*
    Sees if proficiency bonus has a custom addition/subtraction and has been changed
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
            CharacterSheetController.setUnSaved();
        });
    }

    /*
    Calculates the bonus of a skill
     */
    public static void registerSkill(TextField skillBonus, ChoiceBox proficiencyChoice, TextField proficiency, TextField abilityScore, ChoiceBox customProficiencySign, TextField customProficiency) {
        proficiencyChoice.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (!abilityScore.getText().isEmpty() && !abilityScore.getText().matches("-")) {
                //Calculates the amount to get as a bonus. Uses the score and not the modifier because the score doesn't indicate if it is negative or not
                int score = Integer.parseInt(abilityScore.getText());
                score -= 10;
                score /= 2;
                score += Integer.parseInt(proficiency.getText()) * proficiencyChoice.getSelectionModel().getSelectedIndex();
                int proficiencyBonus = Integer.parseInt(customProficiency.getText()) * proficiencyChoice.getSelectionModel().getSelectedIndex();
                if (customProficiencySign.getSelectionModel().getSelectedIndex() == 0) {
                    proficiencyBonus = -proficiencyBonus;
                }

                //Add proficiency
                score += proficiencyBonus;
                String bonus = skillBonus.getText();
                bonus = bonus.substring(0, bonus.indexOf(": ") + 2);
                skillBonus.setText(bonus + score);
            }
            CharacterSheetController.setUnSaved();
        });
    }

    /*
    Update the skills number if you change proficiency
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

    /*
    Calculates passive perception
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

    /*
    Appends the amount of XP needed to level to the end of current xp upon level up
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
                CharacterSheetController.setUnSaved();
            }
        });
    }
}
