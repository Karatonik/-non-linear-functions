package nonLinearFunctionsProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Math.PI;
import static java.lang.Math.sin;

public class EditionController implements Initializable {
    public void initialize(URL url, ResourceBundle rb) {
        switch (MainController.select) {
            case 1:
                text.setText("sinus = a * sin(b * x) + c ");
                break;
            case 2:
                text.setText("exponenital = ax^b + c ");
                break;
            case 3:
                text.setText(" pulse = xxx");
                break;
            case 4:
                text.setText("unit-line = xxx");
        }
    }
    @FXML
    Button showButton;
    @FXML
    TextField aField,bField,cField;
@FXML
Label text;


    @FXML
    public void onActionShowButton(){
        double a=1,b=1,c=0;
        //a=Double.valueOf(this.aField.getText());
       // b=Double.valueOf(this.bField.getText());
       // c=Double.valueOf(this.cField.getText()); //napiać regex
        switch (MainController.select){
            case 1:
                displaySinGraph(a,b,c);
                //okno funkcji sinus
                break;
            case 2:
                displayExpGraph(a,b,c);
                //okno funkcji exp
                break;
            case 3:
                displayPulseGraph(a,b,c);
                //okno funckji pulse
                break;
            case 4:
                displayUnitGraph(a,b,c);
                //okno funckji unite
                break;
        }
    }



   public static ObservableList<Points>sinPoints=FXCollections.observableArrayList();
    public void displaySinGraph(double a,double b,double c){
sinPoints.removeAll();
double y1=0;
        for(  double x=-(2*PI);x<(2*PI);x=(x+0.1)) {
            y1 = a * sin(b *x) + c;
            Points p= new Points(x,y1);
            sinPoints.add(p);
        }
        funInit("functionGraph.fxml","Sin");



    }
    public void displayExpGraph(double a,double b,double c){
    }
    public void displayPulseGraph(double a,double b,double c){

    }
    public void displayUnitGraph(double a,double b,double c){
    }





    public void funInit(String fxml ,String name){

        try{
            Stage stage=new Stage();
            FXMLLoader fxmlLoader=new FXMLLoader();
            Pane root =fxmlLoader.load(getClass().getResource(fxml));
            FunctionController functionController =fxmlLoader.getController();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.setTitle(name);
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
