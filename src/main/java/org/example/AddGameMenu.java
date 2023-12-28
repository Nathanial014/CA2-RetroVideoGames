package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddGameMenu {

    @FXML
    private TextField name, publisher, originalDeveloper, gamesMachine, yearOfRelease, coverArt;

    @FXML
    private TextArea description;

    CuckooHash game = new CuckooHash<Game>(3, 15, k->k.getID()%15,k->(k.getID()*13)%15,k->((k.getID()*19)/2)%15);

    //game.add(new Game(name.getText(), publisher.getText(), description.getText(), originalDeveloper.getText(), gamesMachine.getText(), Integer.parseInt(yearOfRelease.getText()), coverArt.getText()));

    @FXML
    private void addGame() {

    }
}
