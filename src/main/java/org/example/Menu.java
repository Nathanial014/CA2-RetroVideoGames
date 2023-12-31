package org.example;

import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.*;

import com.thoughtworks.xstream.XStream;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Menu {

    @FXML
    private TextField machineName, manufacturer, type, media, initialLaunchYear, initialPrice, image, name, publisher, originalDeveloper, gamesMachine, coverArt, yearOfRelease;

    @FXML
    private TextArea gamesMachineDescription, gameDescription;

    @FXML
    private ListView<String> gamesMachineView;

    @FXML
    private ListView<String> gamesView;

    private File file;

    CuckooHash gamesMachineHash = new CuckooHash<GamesMachine>(7, 15, k->k.getId()%15,k->(k.getId()*13)%15,k->((k.getId()*19)/2)%15,k->(k.getId()*17)%15,k->(k.getId()+7)%15,k->(k.getId()*k.getId()+12)%15,k->(k.getId()*3+5)%15);

    CuckooHash gameHash = new CuckooHash<Game>(7, 15, k->k.getId()%15,k->(k.getId()*13)%15,k->((k.getId()*19)/2)%15,k->(k.getId()*17)%15,k->(k.getId()+7)%15,k->(k.getId()*k.getId()+12)%15,k->(k.getId()*3+5)%15);
    public void initialize() {
//        load();
//        gamesMachineListView.getItems().addAll(file.toString());
        this.file = new File("retroVideoGames");
    }

    public void addGamesMachine() {
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
    }

    public void addGame() {
        gameHash.add(new Game(name.getText(), publisher.getText(),gameDescription.getText(), originalDeveloper.getText(), gamesMachine.getText(), Integer.parseInt(yearOfRelease.getText()), coverArt.getText()));
        gamesView.getItems().add(name.getText());
        name.clear();
        publisher.clear();
        gameDescription.clear();
        originalDeveloper.clear();
        gamesMachine.clear();
        yearOfRelease.clear();
        coverArt.clear();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(file));
        out.writeObject(gamesMachine);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{GamesMachine.class, Game.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader(file));
        gamesMachineHash = (CuckooHash<Game>) in.readObject();
        in.close();
    }

    public String fileName(){
        return this.file.toString();
    }

}
