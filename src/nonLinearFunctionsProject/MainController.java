package nonLinearFunctionsProject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    public static int select=0;
    @FXML
    Button sinButton,expButton,pulseButton,unitButton;

    @FXML
    public void onActionSinButton(){
        select=1;
      Stage  stage = (Stage) this.sinButton.getScene().getWindow();
        stage.close();
        LoadFunction(stage);
    }

    @FXML
    public void onActionExpButton(){
        select=2;
        Stage  stage = (Stage) this.sinButton.getScene().getWindow();
        stage.close();
        LoadFunction(stage);
    }

    @FXML
    public void onActionPulseButton(){
        select=3;
        Stage  stage = (Stage) this.sinButton.getScene().getWindow();
        stage.close();
        LoadFunction(stage);
    }

    @FXML
    public void onActionUnitButton(){
        select=4;
        Stage  stage = (Stage) this.sinButton.getScene().getWindow();
        stage.close();
        LoadFunction(stage);
    }

    public void LoadFunction(Stage stage){
        try{
            FXMLLoader fxmlLoader=new FXMLLoader();
            Pane root =fxmlLoader.load(getClass().getResource("editionWindow.fxml"));
            EditionController editionController =fxmlLoader.getController();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Edition");
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
