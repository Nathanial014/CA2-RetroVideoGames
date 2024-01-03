package org.example;

import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.*;

import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseButton.PRIMARY;

import com.thoughtworks.xstream.XStream;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Menu {

    @FXML
    private TextField machineName, manufacturer, type, media, initialLaunchYear, initialPrice, image, gameName, publisher, originalDeveloper, gamesMachine, coverArt, yearOfRelease, originalGame, portedGamesMachine, portDeveloper, releaseYear, portCoverArt, gameMachineSearch, gameSearch, gamePortSearch;

    @FXML
    private TextArea gamesMachineDescription, gameDescription;

    @FXML
    private ListView<String> gamesMachineView, gamesView, gamePortsView, gameMachineDisplay, gameDisplay, gamePortDisplay;

    CuckooHash gamesMachineHash = new CuckooHash<GamesMachine>(7, 15, k->k.getId()%15,k->(k.getId()*13)%15,k->((k.getId()*19)/2)%15,k->(k.getId()*17)%15,k->(k.getId()+7)%15,k->(k.getId()*k.getId()+12)%15,k->(k.getId()*3+5)%15);

    CuckooHash gameHash = new CuckooHash<Game>(7, 15, k->k.getId()%15,k->(k.getId()*13)%15,k->((k.getId()*19)/2)%15,k->(k.getId()*17)%15,k->(k.getId()+7)%15,k->(k.getId()*k.getId()+12)%15,k->(k.getId()*3+5)%15);

    CuckooHash gamePortsHash = new CuckooHash<GamePort>(7, 15, k->k.getId()%15,k->(k.getId()*13)%15,k->((k.getId()*19)/2)%15,k->(k.getId()*17)%15,k->(k.getId()+7)%15,k->(k.getId()*k.getId()+12)%15,k->(k.getId()*3+5)%15);

    public void initialize() throws Exception{
        load();
    }

    public void addGamesMachine() throws Exception{
        gamesMachineHash.add(new GamesMachine(machineName.getText(), manufacturer.getText(),gamesMachineDescription.getText(), type.getText(), media.getText(), initialLaunchYear.getText(), initialPrice.getText(), image.getText()));
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
        gameHash.add(new Game(gameName.getText(), publisher.getText(),gameDescription.getText(), originalDeveloper.getText(), gamesMachine.getText(), yearOfRelease.getText(), coverArt.getText()));
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

    public void addGamePort() throws Exception {
        gamePortsHash.add(new GamePort(originalGame.getText(), portedGamesMachine.getText(), portDeveloper.getText(), releaseYear.getText(), portCoverArt.getText()));
        gamePortsView.getItems().add(originalGame.getText());
        originalGame.clear();
        portedGamesMachine.clear();
        portDeveloper.clear();
        releaseYear.clear();
        portCoverArt.clear();
        save();
    }

    public void searchGamesMachine() {
        if(gameMachineSearch != null) {
            gamesMachineView.getItems().clear();
            for (GamesMachine gameMachine : (GamesMachine[]) gamesMachineHash.searchList(GamesMachine.class, gameMachineSearch.getText())) {
                if (gameMachine == null)
                    break;
                gamesMachineView.getItems().add(gameMachine.getMachineName());
            }
        }
        else{
            gamesMachineView.getItems().clear();
            for(GamesMachine gamesMachineTemp : (GamesMachine[])gamesMachineHash.returnElements(GamesMachine.class))
                gamesMachineView.getItems().add(gamesMachineTemp.getMachineName());
        }
    }

    public void searchGames() {
        if(gameSearch != null) {
            gamesView.getItems().clear();
            for (Game game : (Game[]) gameHash.searchList(Game.class, gameSearch.getText())) {
                if (game == null)
                    break;
                gamesView.getItems().add(game.getName());
            }
        }
        else{
            gamesView.getItems().clear();
            for(Game games : (Game[])gameHash.returnElements(Game.class))
                gamesView.getItems().add(games.getName());
        }
    }

    public void searchGamePorts() {
        if(gamePortSearch != null) {
            gamePortsView.getItems().clear();
            for (GamePort gamePort : (GamePort[]) gamePortsHash.searchList(GamePort.class, gamePortSearch.getText())) {
                if (gamePort == null)
                    break;
                gamePortsView.getItems().add(gamePort.getOriginalGamePort());
            }
        }
        else{
            gamePortsView.getItems().clear();
            for(GamePort gamePort : (GamePort[])gamePortsHash.returnElements(GamePort.class))
                gamePortsView.getItems().add(gamePort.getOriginalGamePort());
        }
    }

    public void displayGameMachine(MouseEvent mouseEvent) {
        if (mouseEvent.getButton().equals(PRIMARY) && gamesMachineView.getSelectionModel().getSelectedItem() != null) {
            GamesMachine gameMachine = (GamesMachine) gamesMachineHash.search(gamesMachineView.getSelectionModel().getSelectedItem());
            gameMachineDisplay.getItems().clear();
            gameMachineDisplay.getItems().add("Machine Name: " + gameMachine.getMachineName());
            gameMachineDisplay.getItems().add("Manufacturer: " + gameMachine.getManufacturer());
            gameMachineDisplay.getItems().add("Description: " + gameMachine.getDescription());
            gameMachineDisplay.getItems().add("Type: " + gameMachine.getType());
            gameMachineDisplay.getItems().add("Media: " + gameMachine.getMedia());
            gameMachineDisplay.getItems().add("Initial Launch Year: " + gameMachine.getInitialLaunchYear());
            gameMachineDisplay.getItems().add("Initial Price: " + gameMachine.getInitialPrice());
        }
    }

    public void displayGame(MouseEvent mouseEvent) {
        if (mouseEvent.getButton().equals(PRIMARY) && gamesView.getSelectionModel().getSelectedItem() != null) {
            Game game = (Game) gameHash.search(gamesView.getSelectionModel().getSelectedItem());
            gameDisplay.getItems().clear();
            gameDisplay.getItems().add("Name: " + game.getName());
            gameDisplay.getItems().add("Publisher: " + game.getPublisher());
            gameDisplay.getItems().add("Description: " + game.getDescription());
            gameDisplay.getItems().add("Original Developer: " + game.getOriginalDeveloper());
            gameDisplay.getItems().add("Original Game Machine: " + game.getGamesMachine());
            gameDisplay.getItems().add("Year Of Release: " + game.getYearOfRelease());
        }
    }

    public void displayGamePort(MouseEvent mouseEvent) {
        if (mouseEvent.getButton().equals(PRIMARY) && gamePortsView.getSelectionModel().getSelectedItem() != null) {
            GamePort gamePort = (GamePort) gamePortsHash.search(gamePortsView.getSelectionModel().getSelectedItem());
            gamePortDisplay.getItems().clear();
            gamePortDisplay.getItems().add("Original Game: " + gamePort.getOriginalGamePort());
            gamePortDisplay.getItems().add("New Game Machine: " + gamePort.getNewGameMachinePortTo());
            gamePortDisplay.getItems().add("Port Developer: " + gamePort.getPortDeveloper());
            gamePortDisplay.getItems().add("Release Year" + gamePort.getReleaseYearOfPort());
        }
    }

    public void deleteGameMachine() throws Exception{
        gamesMachineHash.delete(gamesMachineView.getSelectionModel().getSelectedItem());
        gamesMachineView.getItems().remove(gamesMachineView.getSelectionModel().getSelectedItem());
        save();
    }

    public void deleteGame() throws Exception{
        gameHash.delete(gamesView.getSelectionModel().getSelectedItem());
        gamesView.getItems().remove(gamesView.getSelectionModel().getSelectedItem());
        save();
    }

    public void deleteGamePort() throws Exception{
        gamePortsHash.delete(gamePortsView.getSelectionModel().getSelectedItem());
        gamePortsView.getItems().remove(gamePortsView.getSelectionModel().getSelectedItem());
        save();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());

        ObjectOutputStream gamesMachineOut = xstream.createObjectOutputStream(new FileWriter("gamesMachine"));
        ObjectOutputStream gamesOut = xstream.createObjectOutputStream(new FileWriter("games"));
        ObjectOutputStream gamePortsOut = xstream.createObjectOutputStream(new FileWriter("gamePorts"));

        gamesMachineOut.writeObject(gamesMachineHash);
        gamesOut.writeObject(gameHash);
        gamePortsOut.writeObject(gamePortsHash);

        gamesMachineOut.close();
        gamesOut.close();
        gamePortsOut.close();
    }

    public void load() throws Exception {
        Class<?>[] classes = new Class[]{CuckooHash.class, GamesMachine.class, Game.class, GamePort.class};

        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        ObjectInputStream gamesMachineIn = xstream.createObjectInputStream(new FileReader("gamesMachine"));
        ObjectInputStream gamesIn = xstream.createObjectInputStream(new FileReader("games"));
        ObjectInputStream gamePortsIn = xstream.createObjectInputStream(new FileReader("gamePorts"));

        gamesMachineHash = (CuckooHash<GamesMachine>) gamesMachineIn.readObject();
        gameHash = (CuckooHash<Game>) gamesIn.readObject();
        gamePortsHash = (CuckooHash<GamePort>) gamePortsIn.readObject();

        gamesMachineHash.setHashFunctions(k->((GamesMachine)k).getId()%15,k->(((GamesMachine)k).getId()*13)%15,k->((((GamesMachine)k).getId()*19)/2)%15,k->(((GamesMachine)k).getId()*17)%15,k->(((GamesMachine)k).getId()+7)%15,k->(((GamesMachine)k).getId()*((GamesMachine)k).getId()+12)%15,k->(((GamesMachine)k).getId()*3+5)%15);
        gameHash.setHashFunctions(k->((Game)k).getId()%15,k->(((Game)k).getId()*13)%15,k->((((Game)k).getId()*19)/2)%15,k->(((Game)k).getId()*17)%15,k->(((Game)k).getId()+7)%15,k->((Game)k).getId()*(((Game)k).getId()+12)%15,k->(((Game)k).getId()*3+5)%15);
        gamePortsHash.setHashFunctions(k->((GamePort)k).getId()%15,k->(((GamePort)k).getId()*13)%15,k->((((GamePort)k).getId()*19)/2)%15,k->(((GamePort)k).getId()*17)%15,k->(((GamePort)k).getId()+7)%15,k->((GamePort)k).getId()*(((GamePort)k).getId()+12)%15,k->(((GamePort)k).getId()*3+5)%15);

        for(GamesMachine gamesMachineTemp : (GamesMachine[])gamesMachineHash.returnElements(GamesMachine.class))
            gamesMachineView.getItems().add(gamesMachineTemp.getMachineName());
        for(Game gameTemp : (Game[])gameHash.returnElements(Game.class))
            gamesView.getItems().add(gameTemp.getName());
        for(GamePort gamePortTemp : (GamePort[])gamePortsHash.returnElements(GamePort.class))
            gamePortsView.getItems().add(gamePortTemp.getOriginalGamePort());

        gamesMachineIn.close();
        gamesIn.close();
        gamePortsIn.close();
    }
}
