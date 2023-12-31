package org.example;

public class Test {
    public static void main (String[] args) {
        CuckooHash game = new CuckooHash<Game>(3, 15, k->k.getId()%15,k->(k.getId()*13)%15,k->((k.getId()*19)/2)%15);
        game.add(new Game("name2", "publisher2",  "description2", "originalDeveloper2", "gamesMachine2", 20369, "image2"));
        game.add(new Game("name1", "publisher1",  "description1", "originalDeveloper1", "gamesMachine1", 20031, "image1"));
        game.add(new Game("name7", "publisher1",  "description1", "originalDeveloper1", "gamesMachine1", 20031, "image1"));
        game.add(new Game("name7", "publisher1",  "description1", "originalDeveloper1", "gamesMachine1", 20031, "image1"));
        System.out.println(game.displayHashTables());       //Display entire table
        System.out.println(game.displayElements());         //Display just the elements in game
        System.out.println(game.search("name2"));     //search for a game called name2


        //Games machine currently needs a getID() and setID() method for the following code to work.

        CuckooHash gamesMachine = new CuckooHash<GamesMachine>(3, 15, k->k.getId()%10,k->(k.getId()*13)%10,k->((k.getId()*19)/2)%10);
        gamesMachine.add(new GamesMachine("machineName", "manufacturer", "description", "type", "media", 2003, 19.99, "image"));
        gamesMachine.add(new GamesMachine("machineName2", "manufacturer2", "description2", "type2", "media2", 2003, 19.99, "image2"));
        gamesMachine.add(new GamesMachine("machineName2", "manufacturer2", "description2", "type2", "media2", 2003, 19.99, "image2"));
        System.out.println(gamesMachine.displayHashTables());
        System.out.println(gamesMachine.displayElements());
        System.out.println(game.search("machineName2"));

        CuckooHash gamePort = new CuckooHash<GamePort>(3,15, k->k.getId()%10,k->(k.getId()*13)%10,k->((k.getId()*19)/2)%10);
        gamePort.add(new GamePort("PS3","PS4", "Infinity Ward", 2017, "placeholder-image3"));
        gamePort.add(new GamePort("PS2","PS5", "Rockstar Games", 2022, "placeholder-image34"));
        gamePort.add(new GamePort("Xbox","PC", "SEGA", 2009, "placeholder-image47"));
        gamePort.add(new GamePort("Nintendo 64","PC", "Funny Games", 2020, "placeholder-image1"));
        System.out.println(gamePort.displayHashTables());
        System.out.println(gamePort.displayElements());

        // Create an instance of a game port and add games
        GamePort gamePort1 = new GamePort("PS1", "PS2", "Activision", 2017, "coverart");
        System.out.println(gamePort1);
        /*gamePort1.addGame(game1);
        gamePort1.addGame(game2);*/

        // Create an instance of a game machine and add game ports
        /*GameMachine gameMachine = new GameMachine();
        gameMachine.addGamePort(gamePort1);

        // Print the current state of the game machine
        printGameMachineState(gameMachine);

        // Delete a game from the game port
        gamePort1.deleteGame(game1);

        // Print the updated state
        printGameMachineState(gameMachine);

        // Delete a game port from the game machine
        gameMachine.deleteGamePort(gamePort1);

        // Print the final state
        printGameMachineState(gameMachine);

        private static void printGameMachineState(GamesMachine gamesMachine) {
            System.out.println("Current state of the game machine:");
            for (GamePort gamePort : gameMachine.getGamePorts()) {
                System.out.println("Game Port:");
                for (Game game : gamePort.getOriginalGamePort) {
                    System.out.println("- " + game.getName());
                }
            }
            System.out.println();
        }*/
    }
}