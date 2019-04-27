package nonLinearFunctionsProject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
public class MainController {

    @FXML
    Button sinButton,expButton,pulseButton,unitButton;
//Zmienna nadzorujaca wybrana funkcje
   public static int select=0;
    @FXML
    public void onActionSinButton(){
        select=1;
        Stage stage = (Stage) this.sinButton.getScene().getWindow();
        stage.close();
        onActionButtons();
    }


    @FXML
    public void onActionExpButton(){
        select=2;
        Stage stage = (Stage) this.expButton.getScene().getWindow();
        stage.close();
        onActionButtons();
    }

    @FXML
    public void onActionPulseButton(){
        select=3;
        Stage stage = (Stage) this.pulseButton.getScene().getWindow();
        stage.close();
        onActionButtons();
    }

    @FXML
    public void onActionUnitButton(){
        select=4;
        Stage stage = (Stage) this.unitButton.getScene().getWindow();
        stage.close();
        onActionButtons();
    }


    public void onActionButtons(){
        try {
            Stage newStage = new Stage();
            FXMLLoader newfxmlLoader = new FXMLLoader();
            Pane root = newfxmlLoader.load(getClass().getResource("editionWindow.fxml").openStream());
            EditionController editionController = newfxmlLoader.getController();

            Scene newscene = new Scene(root);

            newStage.setScene(newscene);
            newStage.setTitle("Edition");
            newStage.setResizable(false);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
