package org.example;

import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.*;
import java.security.spec.ECField;

import com.thoughtworks.xstream.XStream;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Menu {

    @FXML
    private TextField machineName, manufacturer, type, media, initialLaunchYear, initialPrice, image, gameName, publisher, originalDeveloper, gamesMachine, coverArt, yearOfRelease;

    @FXML
    private TextArea gamesMachineDescription, gameDescription;

    @FXML
    private ListView<String> gamesMachineView, gamesView;

    CuckooHash gamesMachineHash = new CuckooHash<GamesMachine>(7, 15, k->k.getId()%15,k->(k.getId()*13)%15,k->((k.getId()*19)/2)%15,k->(k.getId()*17)%15,k->(k.getId()+7)%15,k->(k.getId()*k.getId()+12)%15,k->(k.getId()*3+5)%15);

    CuckooHash gameHash = new CuckooHash<Game>(7, 15, k->k.getId()%15,k->(k.getId()*13)%15,k->((k.getId()*19)/2)%15,k->(k.getId()*17)%15,k->(k.getId()+7)%15,k->(k.getId()*k.getId()+12)%15,k->(k.getId()*3+5)%15);
    public void initialize() {
//        load();
//        gamesMachineListView.getItems().addAll(file.toString());
    }

    public void addGamesMachine() throws Exception{
        gamesMachineHash.add(new GamesMachine(machineName.getText(), manufacturer.getText(),gamesMachineDescription.getText(), type.getText(), media.getText(), Integer.parseInt(initialLaunchYear.getText()), Integer.parseInt(initialPrice.getText()), image.getText()));
        gamesMachineView.getItems().add(machineName.getText());
        machineName.clear();
        manufacturer.clear();
        type.clear();
        media.clear();
        initialLaunchYear.clear();
        initialPrice.clear();
        image.clear();
        gamesMachineDescription.clear();
        save();
    }

    public void addGame() throws Exception {
        gameHash.add(new Game(gameName.getText(), publisher.getText(),gameDescription.getText(), originalDeveloper.getText(), gamesMachine.getText(), Integer.parseInt(yearOfRelease.getText()), coverArt.getText()));
        gamesView.getItems().add(gameName.getText());
        gameName.clear();
        publisher.clear();
        gameDescription.clear();
        originalDeveloper.clear();
        gamesMachine.clear();
        yearOfRelease.clear();
        coverArt.clear();
        save();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream gamesMachineOut = xstream.createObjectOutputStream(new FileWriter("gamesMachine"));
        ObjectOutputStream gamesOut = xstream.createObjectOutputStream(new FileWriter("games"));
        gamesMachineOut.writeObject(gamesMachineHash);
        gamesOut.writeObject(gameHash);
        gamesMachineOut.close();
        gamesOut.close();
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{CuckooHash.class, GamesMachine.class, Game.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream gamesMachineIn = xstream.createObjectInputStream(new FileReader("gamesMachine"));
        ObjectInputStream gamesIn = xstream.createObjectInputStream(new FileReader("games"));
        gamesMachineHash = (CuckooHash<GamesMachine>) gamesMachineIn.readObject();
        gameHash = (CuckooHash<Game>) gamesIn.readObject();
        gamesMachineIn.close();
        gamesIn.close();
    }

//    public String fileName(){
//        return this.file.toString();
//    }

}
