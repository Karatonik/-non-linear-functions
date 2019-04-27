package nonLinearFunctionsProject;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class EditionController  {
    EditionController(){
        switch (MainController.select){
            case 1:
            textFunction.setText("sinus = a * sin(b * x) + c ");
            break;
            case 2:
                textFunction.setText("exponenital = ax^b + c ");
                break;
            case 3:
                textFunction.setText(" pulse = xxx");
                break;
            case 4:
                textFunction.setText("unit-line = xxx");

        }
    }

    @FXML
    Label textFunction;
    @FXML
    Button showButton;
    @FXML
    TextField aField,bField,cField;

    @FXML
    public void onActionShowButton(){
        double a,b,c=1;
        a=Double.valueOf(this.aField.getText());
        b=Double.valueOf(this.bField.getText());
        c=Double.valueOf(this.cField.getText()); //napiać regex
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




    public void displaySinGraph(double a,double b,double c){

    }
    public void displayExpGraph(double a,double b,double c){

    }
    public void displayPulseGraph(double a,double b,double c){

    }
    public void displayUnitGraph(double a,double b,double c){

    }
}
