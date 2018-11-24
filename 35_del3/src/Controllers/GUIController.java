package Controllers;
import gui_main.GUI;

public class GUIController {
    GUI gui = new GUI();

    public void showMessage(String jakobErEnNar){
        gui.showMessage(jakobErEnNar);
    }

    public void showRoll(int jakobStemmerPåAlternativet){
        gui.setDie(jakobStemmerPåAlternativet);
    }

    public void showTurn(String jakobHarMerit){
        gui.showMessage(jakobHarMerit);
    }

}
