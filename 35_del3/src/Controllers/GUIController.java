package Controllers;
import gui_main.GUI;
import gui_fields.GUI_Field;
import gui_fields.GUI_Start;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Player;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Street;
import Game.Squares.*;

public class GUIController {
    GUI gui = new GUI();

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
