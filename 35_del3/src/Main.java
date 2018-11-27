import Controllers.*;
import Game.*;
import Game.Player.*;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class Main{

    public static void main(String[] args) {

        GameBoard board = new GameBoard();
        GUIController gui = new GUIController();
        Game monopoly = new Game(board, gui);
        Scanner scan = new Scanner(System.in);

        gui.showMessage("Angiv antallet af spillere (2-4)");
        int participants = scan.nextInt();
        Player[] playersArr = new Player[participants];
        if (participants >= 2 && participants <= 4){
            playersArr = monopoly.setPlayers(participants);
        }


        // Opsætning af GuiBoard
        GUI_Field[] guiFields = gui.createGUIFields(monopoly.getBoard().getSquares());
        gui.createBoard(guiFields, monopoly.getBoard().getSquares());


        // Spillere instantieres og Gui sættes op
        GUI_Player[] guiPlayersArr = gui.createPlayers(playersArr);
        gui.addPlayers(guiPlayersArr);

        while (monopoly.getPlay()){
            for (int i = 0; i < playersArr.length; i++){
                monopoly.playTurn(playersArr[i]);
                gui.showRoll(monopoly.getDie().getFaceValue(0));
                gui.updatePlayerLocation(playersArr, guiFields, guiPlayersArr);
                //TODO square message
                if (monopoly.endGame(playersArr)){
                    monopoly.setPlay(false);
                    break;
                }
            }
        }
        monopoly.winner(playersArr);


//        String jFile = "";
//
//        /** Welcoming players to the game.
//         * Defining the players and dice. **/
//
//
//
//        System.out.println("Welcome to IOOuterActive Adventure Controllers.Game (please select language) \n 1) English \n 2) Dansk");
//        Scanner scan = new Scanner(System.in);
//        int input = scan.nextInt();
//        if(input == 1)
//            jFile ="./test.json";
//        else if (input == 2)
//            jFile ="./test_da.json";
//        else
//            System.out.println("Not applicable option");
//        try{JSONParser parser = new JSONParser();
//            Object obj = parser.parse(new FileReader(jFile));
//            JSONObject jason = (JSONObject) obj;
//        System.out.println(jason.get("enter1"));
//        Player player1 = new Player(scan.next());
//        System.out.println(jason.get("enter2"));
//        Player player2 = new Player(scan.next());
//        Game game = new Game(jason);
//
//        System.out.println(jason.get("rules"));
//        System.out.println("\n " + player1.getName() + jason.get("start"));
//
//        player1.setTurn(true);
//
//        /** Defining that both players can't play at once. **/
//        while(game.getPlay()) {
//            input = scan.nextInt();
//            game.playing(input, player1, player2);
//        }
//
//        } catch(FileNotFoundException e){
//            e.printStackTrace();
//        }catch(IOException e){
//            e.printStackTrace();
//        }catch(ParseException f){
//            f.printStackTrace();
//        }
    }
}