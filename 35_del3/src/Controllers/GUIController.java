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

import Game.Squares.*;

import java.awt.*;

public class GUIController {
    GUI gui;
    private GUI_Player[] gPlayers;

    /**
     * Creating GUIFields
     *
     * @param squares
     * @return
     */
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
            }
        }
        return guiFields;
    }

    /**
     * Creating Board and sets text (setSubText)
     *
     * @param guiFields
     * @param squares
     */
    public void createBoard(GUI_Field[] guiFields, Square[] squares){

        for (int i = 0; i<guiFields.length; i++){
            guiFields[i].setTitle(squares[i].getSqName());
            if(squares[i] instanceof Property) {
                guiFields[i].setSubText("M" + squares[i].getPrice());
            }
            else if (squares[i] instanceof Jail){
                guiFields[i].setSubText("FÆNGSEL");
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
                }
            }
            guiFields[i].setDescription(squares[i].getSqMessage());
        }
        gui = new GUI(guiFields);
    }

    /**
     * Adding players
     *
     * @param guiPlayers
     */
    public void addPlayers(GUI_Player[] guiPlayers){
        for(int i = 0; i<guiPlayers.length; i++)
            gui.addPlayer(guiPlayers[i]);
    }

    /**
     * Adding players to the game; g_Players
     *
     * @param players
     * @return
     */
    public GUI_Player[] createPlayers(Player[] players){
        gPlayers = new GUI_Player[players.length];
        for (int i =0; i<players.length; i++){
            gPlayers[i] = new GUI_Player(players[i].getName(), players[i].getBalance().getPoints());
        }
        for (int i =0; i < gPlayers.length; i++) {
            switch (i) {
                case 0:
                    gPlayers[i].getCar().setPrimaryColor(Color.red);
                    break;
                case 1:
                    gPlayers[i].getCar().setPrimaryColor(Color.blue);
                    break;
                case 2:
                    gPlayers[i].getCar().setPrimaryColor(Color.orange);
                    break;
                case 3:
                    gPlayers[i].getCar().setPrimaryColor(Color.magenta);
                    break;
                default:
                    gui.showMessage("Error setting colors of cars.");
            }
        }
        return gPlayers;
    }

    /**
     * Moving players around the board; getLocation
     *
     * @param players
     * @param gFields
     * @param gPlayers
     */
    public void updatePlayerLocation(Player [] players, GUI_Field[] gFields, GUI_Player[] gPlayers){
        for (int i =0; i<gFields.length; i++)
            gFields[i].removeAllCars();
        for (int i = 0; i<players.length; i++)
            gFields[players[i].getLocation()].setCar(gPlayers[i], true);
    }

    /**
     * Updating players balances
     *
     * @param players
     */
    public void updatePlayerBalance(Player[] players){
        for(int i = 0; i < players.length; i++){
            gPlayers[i].setBalance(players[i].getBalance().getPoints());
        }
    }

    /**
     * gui.showMessage
     *
     * @param message
     */
    public void showMessage(String message){
        gui.showMessage(message);
    }

    /**
     * setDie(roll)
     *
     * @param roll
     */
    public void showRoll(int roll){
        gui.setDie(roll);
    }

    /**
     * Getter for amount of players
     *
     * @return
     */
    public int enterInt(){
        return gui.getUserInteger("Indtast venligst antallet af spillere (2-4)", 2, 4);
    }

    /**
     * Receiving string input
     *
     * @param disText
     * @return
     */
    public String makeText(String disText){
        return gui.getUserString(disText);
    }
}
