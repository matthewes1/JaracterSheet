package Rain.HelperClasses;

import Rain.Spells.SpellCard;
import java.util.Collections;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class Sorter {
    public Sorter() {
    }

    public static void sort(VBox t) {
        ObservableList<Node> nodes = FXCollections.observableArrayList(t.getChildren());
        Collections.sort(nodes, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                SpellCard s1 = (SpellCard)o1.getUserData();
                SpellCard s2 = (SpellCard)o2.getUserData();
                String st1 = s1.spell.getName().toLowerCase();
                String st2 = s2.spell.getName().toLowerCase();
                return st1.compareTo(st2);
            }
        });
        t.getChildren().setAll(nodes);
    }
}
