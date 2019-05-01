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
import java.util.ResourceBundle;

import static java.lang.Math.*;

public class EditionController implements Initializable {

    public static ObservableList<Points> sinPoints = FXCollections.observableArrayList();

    @FXML
    Button showButton;
    @FXML
    TextField aField, bField, cField,quanPoints,max,min;
    @FXML
    Label text;
    @FXML
     Label test;
    @FXML
    private Button goBack;


    public void initialize(URL url, ResourceBundle rb) {
        switch (MainController.select) {
            case 1:
                text.setText("sinus = a * sin(b * x) + c ");
                break;
            case 2:
                text.setText("exponenital = ab^x + c ");
                break;
            case 3:
                text.setText(" pulse = xxx");
                break;
            case 4:
                text.setText("unit-line = xxx");
        }
    }

    @FXML
    public void onActionShowButton() {
        Double a=1.0 ;
               Double b=1.0 ;
               Double c =1.0;
        Double maxI=1.0;
        Double minI=1.0;
        Double quanPI=1.0;

       // a=Double.valueOf(this.aField.getText());
        // b=Double.valueOf(this.bField.getText());
       //  c=Double.valueOf(this.cField.getText()); //napiać regex
       // maxI=Double.valueOf(this.max.getText());
       // minI=Double.valueOf(this.min.getText());
       // quanPI=Double.valueOf(this.quanPoints.getText());
     //   test.setText(b.toString());
        switch (MainController.select) {
            case 1:
                displaySinGraph(a, b, c, maxI, minI, quanPI);
                //okno funkcji sinus
                break;
            case 2:
                displayExpGraph(a, b, c, maxI, minI,quanPI);
                //okno funkcji exp
                break;
            case 3:
                displayPulseGraph(a, b, c, maxI, minI,quanPI);
                //okno funckji pulse
                break;
            case 4:
               displayUnitGraph(a, b, c, maxI, minI,quanPI);
                //okno funckji unite
                break;
        }
    }




    public void displaySinGraph(double a, double b, double c,double maxI,double minI,double quanPI) {
        sinPoints.removeAll();
        double y1 = 0;
        for (double x = -(2 * PI); x < (2 * PI); x = (x + 0.1)) {
        //(double x = minI;x<maxI; x = (x +quanPI)) {
            y1 = a * sin(b * x) + c;
            Points p = new Points(x, y1);
            sinPoints.add(p);
        }
        funInit("functionGraph.fxml", "Sin");


    }

    public void displayExpGraph(double a, double b, double c,double maxI,double minI,double quanPI) {

        sinPoints.removeAll();
        double y1 = 0;
        for (int x =-10; x <= 10; x++) {
            y1 = a*pow(b,x) +c;
            Points p = new Points(x, y1);
            sinPoints.add(p);
        }
        funInit("functionGraph.fxml", "Exp");


    }

    public void displayPulseGraph(double a, double b, double c,double maxI,double minI,double quanPI) {



        funInit("functionGraph.fxml", "Exp");
    }

    public void displayUnitGraph(double a, double b, double c,double maxI,double minI,double quanPI) {




        funInit("functionGraph.fxml", "Exp");
    }


    public void funInit(String fxml, String name) {

        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane root = fxmlLoader.load(getClass().getResource(fxml));
            FunctionController functionController = fxmlLoader.getController();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(name);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void goBackAction(){
        Stage stage =(Stage) goBack.getScene().getWindow();
        stage.close();
        try {
            Pane root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            stage.setTitle("Non-linear functions");
            stage.setScene(new Scene(root, 500, 400));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
