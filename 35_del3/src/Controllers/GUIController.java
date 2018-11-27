package Controllers;
import Game.Player.Player;
import gui_main.GUI;
import gui_fields.GUI_Field;
import gui_fields.GUI_Start;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Player;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Street;
import gui_fields.GUI_Board;

import Game.Squares.*;

public class GUIController {
    GUI gui;


    public GUI_Field[] createGUIFields(Square[] squares){
        GUI_Field[] guiFields = new GUI_Field[squares.length];
        for (int i = 0; i<squares.length; i++){
            if(i == 0){
                guiFields[i] = new GUI_Start();
            }else if (i == 3 || i == 9 || i == 15 || i == 21){
                guiFields[i] = new GUI_Chance();
            }else if (i == 6 || i == 12){
                guiFields[i] = new GUI_Refuge();
            }else if (i == 18){
                guiFields[i] = new GUI_Jail();
            }else{
                guiFields[i] = new GUI_Street();
                //count ++;
            }
        }
        return guiFields;
    }

    public void createBoard(GUI_Field[] guiFields, Square[] squares){

        for (int i = 0; i<guiFields.length; i++){
            guiFields[i].setTitle(squares[i].getSqName());
            if(squares[i] instanceof Property) {
                guiFields[i].setSubText("M" + squares[i].getPrice());
            }
            else if (squares[i] instanceof Jail){
                guiFields[i].setSubText("FÆNGSEL");
                guiFields[i].setDescription("GÅ I FÆNGSEL");
            }
            else if (squares[i] instanceof UneventfulSq){
                if (squares[i].getSqName().equalsIgnoreCase("Start")){
                    guiFields[i].setSubText("");
                }
                else if (squares[i].getSqName().equalsIgnoreCase("På besøg")){
                    guiFields[i].setSubText("PÅ BESØG");
                }
                else if (squares[i].getSqName().equalsIgnoreCase("Gratis Parkering")){
                    guiFields[i].setSubText("PARKERING");
                    guiFields[i].setDescription("GRATIS PARKERING");
                }
            }
        }
        gui = new GUI(guiFields);
    }

    public void addPlayers(GUI_Player[] guiPlayers){
        for(int i = 0; i<guiPlayers.length; i++)
            gui.addPlayer(guiPlayers[i]);
    }

    public GUI_Player[] createPlayers(Player[] players){
        GUI_Player[] gPlayers = new GUI_Player[players.length];
        for (int i =0; i<players.length; i++){
            gPlayers[i] = new GUI_Player(players[i].getName(), players[i].getBalance().getPoints());
        }
        return gPlayers;
    }

    public void updatePlayerLocation(Player [] players, GUI_Field[] gFields, GUI_Player[] gPlayers){
        for (int i =0; i<gFields.length; i++)
            gFields[i].removeAllCars();
        for (int i = 0; i<players.length; i++)
            gFields[players[i].getLocation()].setCar(gPlayers[i], true);
    }

    public void showMessage(String message){
        gui.showMessage(message);
    }

    public void showRoll(int roll){
        gui.setDie(roll);
    }

    public void showTurn(String jakobHarMerit){
        gui.showMessage(jakobHarMerit);
    }


}
