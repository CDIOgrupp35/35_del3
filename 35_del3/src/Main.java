import Controllers.*;
import Game.*;
import Game.Player.*;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
public class Main {

    public static void main(String[] args) {

        GameBoard board = new GameBoard();
        GUIController gui = new GUIController();
        Game monopoly = new Game(board, gui);

        //Opsætning af GUIBoard
        GUI_Field[] guiFields = gui.createGUIFields(monopoly.getBoard().getSquares());
        gui.createBoard(guiFields, monopoly.getBoard().getSquares());

        gui.showMessage("Velkomment til Monopoly!");
        int participants = gui.enterInt();
        Player[] playersArr = monopoly.setPlayers(participants);

        // Spillere instantieres og Gui sættes op
        GUI_Player[] guiPlayersArr = gui.createPlayers(playersArr);
        gui.addPlayers(guiPlayersArr);

        while (monopoly.getPlay()) {
            for (int i = 0; i < playersArr.length; i++) {
                Player cPlayer = playersArr[i];
                gui.showMessage(cPlayer.getName() + ", det er din tur. \nTryk enter, eller click 'OK' for at rulle med terningen");
                monopoly.playTurn(cPlayer);
                int faceValue = monopoly.getDie().getFaceValue(0);
                gui.showRoll(faceValue);
                gui.updatePlayerLocation(playersArr, guiFields, guiPlayersArr);
                monopoly.playTurn2(cPlayer);
                gui.updatePlayerLocation(playersArr, guiFields, guiPlayersArr);
                //TODO square message
                if (monopoly.endGame(playersArr)) {
                    monopoly.setPlay(false);
                    break;
                }
            }
        }
        Player winner = monopoly.winner(playersArr);
        gui.showMessage("Tillykke " + winner.getName() + ", du har vundet spillet!");
    }
}