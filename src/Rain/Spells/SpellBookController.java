package Rain.Spells;

import Rain.HelperClasses.XmlFilter;
import Rain.HelperClasses.XmlHandler;
import Rain.MainPackage.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileFilter;

public class SpellBookController {
    private Spell selectedSpell;                //Placeholder for the currently selected spell
    private boolean justSwitched = false;       //Records whether or not a spell was just prepared/unprepared
    //<editor-fold desc="FXML Declarations">
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
    private TableView unpreparedSpells;
    @FXML
    private TableColumn unpreparedSpellName;
    @FXML
    private TableColumn unpreparedSpellLevel;
    @FXML
    private TableColumn unpreparedSpellSchool;
    @FXML
    private TableColumn unpreparedSpellCastTime;
    //</editor-fold>
    private ObservableList<Spell> unpreparedSpellList = FXCollections.observableArrayList();
    private ObservableList<Spell> preparedSpellList = FXCollections.observableArrayList();

    @FXML
    protected void initialize() {
        tableSetup();
    }

    /**
     * Binds the table columns to the data in a spell object
     */
    public void tableSetup() {
        preparedSpellName.setCellValueFactory(new PropertyValueFactory<Spell, String>("spellName"));
        preparedSpellLevel.setCellValueFactory(new PropertyValueFactory<Spell, String>("level"));
        preparedSpellSchool.setCellValueFactory(new PropertyValueFactory<Spell, String>("school"));
        preparedSpellCastTime.setCellValueFactory(new PropertyValueFactory<Spell, String>("castTime"));
        preparedSpells.setItems(preparedSpellList);

        //When a selected row is clicked again, deselct that row. The input of selecting that row is also processed, opening
        //the spelleditor
        preparedSpells.setRowFactory((param) -> {
            TableRow<Spell> selected = new TableRow<>();
            selected.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    int index = selected.getIndex();
                    if (index >= 0 && index < preparedSpells.getItems().size() && preparedSpells.getSelectionModel().isSelected(index)) {
                        preparedSpells.getSelectionModel().clearSelection(index);
                    }
                }
            });
            return selected;
        });

        //Change listener for when a user selects a row open the spell editor
        //If the user just prepared/unprepared a spell, it does not open upon a new selection.
        preparedSpells.getSelectionModel().selectedItemProperty().addListener((obs, oldSelect, newSelect) -> {
            if (newSelect != null && !justSwitched) {
                selectedSpell = preparedSpellList.get(preparedSpells.getSelectionModel().getSelectedIndex());
                Stage popup = new Stage();
                FXMLLoader fxmlFile = new FXMLLoader(getClass().getResource("/Rain/Spells/SpellEditor.fxml"));
                try {
                    Parent parent = fxmlFile.load();
                    popup.setScene(new Scene(parent));
                } catch (Exception x) {
                    x.printStackTrace();
                }
                popup.initModality(Modality.APPLICATION_MODAL);
                popup.setTitle("Spell Editor");
                popup.centerOnScreen();
                popup.show();
            }
            justSwitched = false;
        });


        unpreparedSpellName.setCellValueFactory(new PropertyValueFactory<Spell, String>("spellName"));
        unpreparedSpellLevel.setCellValueFactory(new PropertyValueFactory<Spell, String>("level"));
        unpreparedSpellSchool.setCellValueFactory(new PropertyValueFactory<Spell, String>("school"));
        unpreparedSpellCastTime.setCellValueFactory(new PropertyValueFactory<Spell, String>("castTime"));
        unpreparedSpells.setItems(unpreparedSpellList);

        //When a selected row is clicked again, deselect that row. The input of selecting that row is also processed, opening
        //the spelleditor
        unpreparedSpells.setRowFactory((param) -> {
            TableRow<Spell> selected = new TableRow<>();
            selected.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    int index = selected.getIndex();
                    if (index >= 0 && index < unpreparedSpells.getItems().size() && unpreparedSpells.getSelectionModel().isSelected(index)) {
                        unpreparedSpells.getSelectionModel().clearSelection(index);
                    }
                }
            });
            return selected;
        });

        //Change listener for when a user selects a row open the spell editor
        //If the user just prepared/unprepared a spell, it does not open upon a new selection.
        unpreparedSpells.getSelectionModel().selectedItemProperty().addListener((obs, oldSelect, newSelect) -> {
            if (newSelect != null && !justSwitched) {
                selectedSpell = unpreparedSpellList.get(unpreparedSpells.getSelectionModel().getSelectedIndex());
                Stage popup = new Stage();
                FXMLLoader fxmlFile = new FXMLLoader(getClass().getResource("/Rain/Spells/SpellEditor.fxml"));
                try {
                    Parent parent = fxmlFile.load();
                    popup.setScene(new Scene(parent));
                } catch (Exception x) {
                    x.printStackTrace();
                }
                popup.initModality(Modality.APPLICATION_MODAL);
                popup.setTitle("Spell Editor");
                popup.centerOnScreen();
                popup.show();
            }
            justSwitched = false;
        });
    }

    @FXML
    public void saveSpells() {
        try {
            XmlHandler.convertToXML(unpreparedSpellList, Main.getController().getCurrentCharacter().getCharacterName());
            XmlHandler.convertToXML(preparedSpellList, Main.getController().getCurrentCharacter().getCharacterName());
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    /**
     * Loads a folder from a directory chooser and filters those files to only include the xml files.
     * It then sorts the spells loaded into the proper list
     */
    @FXML
    private void loadSpells() {
        ObservableList<Spell> unsorted = FXCollections.observableArrayList();
        File spells = chooser();
        try {
            FileFilter filter = new XmlFilter("XML filter");
            unsorted = XmlHandler.convertToObject(spells.listFiles(filter));
        } catch (Exception x) {
            x.printStackTrace();
        }

        for (Spell spell : unsorted) {
            if (spell.isPrepared()) {
                preparedSpellList.add(spell);
            } else {
                unpreparedSpellList.add(spell);
            }
        }
    }

    /**
     * Save selection prompt
     *
     * @return selected file or NULL if no file is selected
     */
    private File chooser() {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Open SpellBook");
        chooser.setInitialDirectory(new File("saves/"));
        File selected = chooser.showDialog(spellBookPane.getScene().getWindow());
        return selected;
    }

    @FXML
    private void makeSpell() {
        spellPopup(new Spell());
        Main.getController().setUnSaved();
    }

    /**
     * Creates a new blank spell with the vanilla name of just blank spell
     */
    public Spell spellPopup(Spell currentSpell) {
        Stage popup = new Stage();
        FXMLLoader fxmlFile = new FXMLLoader(getClass().getResource("/Rain/Spells/NewSpell.fxml"));
        try {
            Parent parent = fxmlFile.load();
            popup.setScene(new Scene(parent));
        } catch (Exception x) {
            x.printStackTrace();
        }
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("New Spell");
        popup.centerOnScreen();
        popup.show();

        return currentSpell;
    }

    public void addSpell(Spell newSpell) {
        unpreparedSpellList.add(newSpell);
    }

    public Spell getSelectedSpell() {
        return selectedSpell;
    }

    public void updateSpell(Spell spell) {
        if (spell.isPrepared()) {
            preparedSpellList.get(preparedSpells.getSelectionModel().getSelectedIndex()).setSpellName(spell.getSpellName());
            preparedSpellList.get(preparedSpells.getSelectionModel().getSelectedIndex()).setLevel(spell.getLevel());
            preparedSpellList.get(preparedSpells.getSelectionModel().getSelectedIndex()).setSchool(spell.getSchool());
            preparedSpellList.get(preparedSpells.getSelectionModel().getSelectedIndex()).setCastTime(spell.getCastTime());
            preparedSpellList.get(preparedSpells.getSelectionModel().getSelectedIndex()).setRange(spell.getRange());
            preparedSpellList.get(preparedSpells.getSelectionModel().getSelectedIndex()).setComponents(spell.getComponents());
            preparedSpellList.get(preparedSpells.getSelectionModel().getSelectedIndex()).setDuration(spell.getDuration());
            preparedSpellList.get(preparedSpells.getSelectionModel().getSelectedIndex()).setDescription(spell.getDescription());
            preparedSpells.refresh();
        } else {
            unpreparedSpellList.get(unpreparedSpells.getSelectionModel().getSelectedIndex()).setSpellName(spell.getSpellName());
            unpreparedSpellList.get(unpreparedSpells.getSelectionModel().getSelectedIndex()).setLevel(spell.getLevel());
            unpreparedSpellList.get(unpreparedSpells.getSelectionModel().getSelectedIndex()).setSchool(spell.getSchool());
            unpreparedSpellList.get(unpreparedSpells.getSelectionModel().getSelectedIndex()).setCastTime(spell.getCastTime());
            unpreparedSpellList.get(unpreparedSpells.getSelectionModel().getSelectedIndex()).setRange(spell.getRange());
            unpreparedSpellList.get(unpreparedSpells.getSelectionModel().getSelectedIndex()).setComponents(spell.getComponents());
            unpreparedSpellList.get(unpreparedSpells.getSelectionModel().getSelectedIndex()).setDuration(spell.getDuration());
            unpreparedSpellList.get(unpreparedSpells.getSelectionModel().getSelectedIndex()).setDescription(spell.getDescription());
            unpreparedSpells.refresh();
        }

        Main.getController().setUnSaved();
    }

    /**
     * Changes the table when a spell is prepared or unprepared
     * Toggles the justSwitched boolean to true so the program does not immediately open another spell
     *
     * @param spell The spell to be moved
     */
    public void switchTable(Spell spell) {
        justSwitched = true;
        if (spell.isPrepared()) {
            preparedSpells.getItems().remove(preparedSpells.getSelectionModel().getSelectedIndex());
            unpreparedSpellList.add(spell);
        } else {
            unpreparedSpells.getItems().remove(unpreparedSpells.getSelectionModel().getSelectedIndex());
            preparedSpellList.add(spell);
        }

        unpreparedSpells.refresh();
        preparedSpells.refresh();

        if (spell.isPrepared()) {
            spell.setPrepared(false);
        } else {
            spell.setPrepared(true);
        }

        Main.getController().setUnSaved();
    }

}
