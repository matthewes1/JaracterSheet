package Rain.HelperClasses;

import Rain.MainPackage.CharacterSheetController;
import javafx.beans.value.ChangeListener;
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
    public static void registerAbilityScore(TextField start, final TextField modifier, final TextField sym, final CheckMenuItem initUpdater) {
        start.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.isEmpty() && !newValue.matches("-") && !newValue.matches(oldValue)) {
                    //Calculates the ability modifier from the new score
                    double t = Double.parseDouble(newValue);
                    t -= 10;
                    t /= 2;
                    if(t < 0 && (t % 1 != 0)){
                        t -= .5;
                    }
                    modifier.setText(String.valueOf(Math.abs((int)t)));

                    //Sets the sign for the ability modifier
                    if (t > 0) {
                        sym.setText("+");
                    } else if (t < 0) {
                        sym.setText("-");
                    } else {
                        sym.setText("");
                    }

                    //If the score is chosen for initiative, toggle it unselected then reselect it so it updates
                    if(initUpdater.isSelected()) {
                        initUpdater.setSelected(!initUpdater.isSelected());
                        initUpdater.setSelected(!initUpdater.isSelected());
                    }

                    CharacterSheetController.setUnSaved();
                }

            }
        });
    }

    /*
    Auto calculates proficiency bonus from player level
     */
    public static void registerProficiency(Spinner start, final TextField end) {
        start.getEditor().textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.isEmpty() && !newValue.matches("-")) {
                    int t = Integer.parseInt(newValue);
                    if (t < 5) {
                        end.setText("2");
                    } else if (t < 9 && t > 4) {
                        end.setText("3");
                    } else if (t < 13 && t > 8) {
                        end.setText("4");
                    } else if (t < 17 && t > 12) {
                        end.setText("5");
                    } else {
                        end.setText("6");
                    }
                }

            }
        });
    }

    /*
    Calculates the bonus from a skill if you have proficiency in it
     */
    public static void updateSkillsProficiency(TextField prof, final ChoiceBox box) {
        prof.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int t = box.getSelectionModel().getSelectedIndex();
                if (t == 0) {
                    box.getSelectionModel().select(1);
                } else {
                    box.getSelectionModel().select(0);
                }

                //Toggles the selection so the bonus updates
                box.getSelectionModel().select(t);
            }
        });
    }

    /*
    Sees if proficiency bonus has a custom addition/subtraction and has been changed
     */
    public static void registerProficiencySymbol(ChoiceBox sym, final ChoiceBox box) {
        sym.valueProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int t = box.getSelectionModel().getSelectedIndex();
                if (t == 0) {
                    box.getSelectionModel().select(1);
                } else {
                    box.getSelectionModel().select(0);
                }

                //Toggles selection to auto update
                box.getSelectionModel().select(t);
                CharacterSheetController.setUnSaved();
            }
        });
    }

    /*
    Calculates the bonus of a skill
     */
    public static void registerSkill(final TextField outPut, final ChoiceBox box, final TextField prof, final TextField mod, final ChoiceBox sym, final TextField extra) {
        box.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (!mod.getText().isEmpty() && !mod.getText().matches("-")) {
                    //Calculates the amount to get as a bonus. Uses the score and not the modifier because the score doesn't indicate if it is negative or not
                    int t = Integer.parseInt(mod.getText());
                    t -= 10;
                    t /= 2;
                    t += Integer.parseInt(prof.getText()) * box.getSelectionModel().getSelectedIndex();
                    int profBonus = Integer.parseInt(extra.getText()) * box.getSelectionModel().getSelectedIndex();
                    if (sym.getSelectionModel().getSelectedIndex() == 0) {
                        profBonus = -profBonus;
                    }

                    //Add proficiency
                    t += profBonus;
                    String x = outPut.getText();
                    x = x.substring(0, x.indexOf(": ") + 2);
                    outPut.setText(x + String.valueOf(t));
                }
                CharacterSheetController.setUnSaved();
            }
        });
    }

    /*
    Update the skills number if you change proficiency
     */
    public static void linkStats(TextField mod, final ChoiceBox box) {
        mod.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!oldValue.matches(newValue)) {
                    int t = box.getSelectionModel().getSelectedIndex();
                    if (t == 0) {
                        box.getSelectionModel().select(1);
                    } else {
                        box.getSelectionModel().select(0);
                    }

                    box.getSelectionModel().select(t);
                }

            }
        });
    }

    /*
    Calculates passive perception
     */
    public static void passivePerception(TextField mod, final TextField perc) {
        mod.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!oldValue.matches(newValue) && !newValue.matches("")) {
                    int t = Integer.parseInt(newValue);
                    t -= 10;
                    t /= 2;
                    t += 10;
                    perc.setText(String.valueOf(t));
                }

            }
        });
    }

    /*
    Appends the amount of XP needed to level to the end of current xp upon level up
     */
    public static void experienceFiller(final TextField exp, Spinner lvl) {
        lvl.getEditor().textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!oldValue.matches(newValue)) {
                    int x = Integer.parseInt(newValue);
                    String t = exp.getText();
                    t = t.substring(0, t.indexOf("/"));

                    //Decides which XP is needed
                    if (x == 1) {
                        t = t.concat("/300");
                    } else if (x == 2) {
                        t = t.concat("/900");
                    } else if (x == 3) {
                        t = t.concat("/2,700");
                    } else if (x == 4) {
                        t = t.concat("/6,500");
                    } else if (x == 5) {
                        t = t.concat("/14,000");
                    } else if (x == 6) {
                        t = t.concat("/23,000");
                    } else if (x == 7) {
                        t = t.concat("/34,000");
                    } else if (x == 8) {
                        t = t.concat("/48,000");
                    } else if (x == 9) {
                        t = t.concat("/64,000");
                    } else if (x == 10) {
                        t = t.concat("/85,000");
                    } else if (x == 11) {
                        t = t.concat("/100,000");
                    } else if (x == 12) {
                        t = t.concat("/120,000");
                    } else if (x == 13) {
                        t = t.concat("/140,000");
                    } else if (x == 14) {
                        t = t.concat("/165,000");
                    } else if (x == 15) {
                        t = t.concat("/195,000");
                    } else if (x == 16) {
                        t = t.concat("/225,000");
                    } else if (x == 17) {
                        t = t.concat("/265,000");
                    } else if (x == 18) {
                        t = t.concat("/305,000");
                    } else if (x == 19) {
                        t = t.concat("/355,000");
                    } else if (x == 20) {
                        t = t.concat("/355,000");
                    } else if (x == 0) {
                        t = t.concat("/300");
                    } else {
                        t = t.concat("/355,000");
                    }

                    exp.setText(t);
                    CharacterSheetController.setUnSaved();
                }

            }
        });
    }
}
