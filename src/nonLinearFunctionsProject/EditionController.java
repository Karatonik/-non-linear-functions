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

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Math.*;

public class EditionController implements Initializable {

    public static ObservableList<Points> sinPoints = FXCollections.observableArrayList();

    @FXML
    Button showButton;
    @FXML
    TextField aField, bField, cField, quanPoints, max, min;
    @FXML
    Label text;
    @FXML
    Label test;
    @FXML
    private Button goBack;
    static double value = 0;
    @FXML
    private Button auto;

    boolean ver=true;

    @FXML
    private Label Labela,Labelb,labelc,labelmax,labelmin,labelquan;

    static boolean autoValue = true;
    Double a = 1.0;
    Double b = 1.0;
    Double c = 0.0;
    Double maxI = 100.0;
    Double minI = 0.0;
    static Double quanPI = 1.0;


    public void initialize(URL url, ResourceBundle rb) {
        switch (MainController.select) {
            case 1:
                text.setText("sinus = a * sin(b * x) + c ");
                break;
            case 2:
                text.setText("exponenital = ab^x + c ");
                break;
            case 3:
                text.setText("pulse = 1(t-t0)"); //dla wiekszych od 0;
                    aField.setPromptText("co ile skok");
                    bField.setPromptText("jak długi skok ( wyskokość)");
                    cField.setVisible(false);
                quanPoints.setVisible(false);
                labelc.setVisible(false);
                labelquan.setVisible(false);
                break;
            case 4:
                text.setText("unit-line = ax *b");
                cField.setVisible(false);
                labelc.setVisible(false);
        }
    }

    @FXML
    public void onActionShowButton() {
        Regex regex = new Regex();
        sinPoints.clear();
        ver = true;

        if (!autoValue) {
            if ((regex.Verification(this.aField.getText())) && (regex.Verification(this.bField.getText())) &&
                    (regex.Verification(this.max.getText())) && (regex.Verification(this.min.getText()))) {
                a = Double.valueOf(this.aField.getText());
                b = Double.valueOf(this.bField.getText());
                maxI = Double.valueOf(this.max.getText());
                minI = Double.valueOf(this.min.getText());
                ver = true;
                System.out.println("a b max min true");
            } else {
                ver = false;
                System.out.println("a b max min false");
            }
            if (MainController.select == 1 || MainController.select == 2) {
                if (regex.Verification(this.cField.getText())) {
                    c = Double.valueOf(this.cField.getText());
                    ver = true;
                    System.out.println("c true");
                } else {
                    ver = false;
                    System.out.println("c false");
                }
            }
            if (MainController.select != 3) {
                if (regex.Verification(this.quanPoints.getText())) {
                    quanPI = Double.valueOf(this.quanPoints.getText());
                    ver = true;
                    System.out.println("quan true");
                } else {
                    ver = false;
                    System.out.println("quan false");
                }
            }
            value = (maxI - minI) / quanPI;

        } else {
            a = 1.0;
            b = 1.0;
            c = 0.0;
            maxI = 100.0;
            minI = 0.0;
            quanPI = 1.0;

        }
        if (!ver) {
            this.test.setText("Nie poprawne dane");
            System.out.println("ver true");
        } else {
            this.test.setText("poprawne");
            System.out.println("ver false");
            if (value > 30000) {
                this.test.setText("Za duża ilośc punktów");
            } else {
                if (maxI < minI) {
                    this.test.setText("max<min");
                } else {
                    switch (MainController.select) {
                        case 1:
                            displaySinGraph(a, b, c, maxI, minI, quanPI);
                            //okno funkcji sinus
                            break;
                        case 2:
                            displayExpGraph(a, b, c, maxI, minI, quanPI);
                            //okno funkcji exp
                            break;
                        case 3:
                            displayPulseGraph(a, b, c, maxI, minI, quanPI);
                            //okno funckji pulse
                            break;
                        case 4:
                            displayUnitGraph(a, b, c, maxI, minI, quanPI);
                            //okno funckji unite
                            break;
                    }
                }
            }
        }
        this.max.setText("");
        this.aField.setText("");
        this.bField.setText("");
        this.cField.setText("");
        this.min.setText("");
        this.quanPoints.setText("");
    }


    private void displaySinGraph(double a, double b, double c, double maxI, double minI, double quanPI) {
        sinPoints.clear();
        double y1 = 0.0;
        if (!autoValue) {
            for (double x = minI; x <= maxI; x = (x + quanPI)) {
                y1 = (a * sin(b * x)) + c;
                if (b == 0) {
                    y1 = c;
                }
                Points p = new Points(x, y1);
                sinPoints.add(p);
                //System.out.println("non auto" + x + "  " + y1);
            }
        } else {
            for (double x = -(2 * PI); x < (2 * PI); x = (x + 0.1)) {

                y1 = (a * sin(b * x)) + c;
                Points p = new Points(x, y1);
                sinPoints.add(p);
                //System.out.println("auto" + x + "  " + y1);
            }
        }
        funInit("functionGraph.fxml", "Sin");


    }

    private void displayExpGraph(double a, double b, double c, double maxI, double minI, double quanPI) {
        double y1 = 0;
        sinPoints.clear();
        if (!autoValue) {
            for (double x = minI; x <= maxI; x = x + quanPI) {
                y1 = (a * pow(b, x)) + c;
               // System.out.println("nonAuto" + x + "  " + y1);
                Points p = new Points(x, y1);
                sinPoints.add(p);
            }
        } else {
            b = 2;
            for (int x = 0; x <= 10; x++) {
                y1 = (a * pow(b, x)) + c;
               // System.out.println("Auto" + x + "  " + y1);
                Points p = new Points(x, y1);
                sinPoints.add(p);
            }
        }
        funInit("functionGraph.fxml", "Exp");

    }

    private void displayPulseGraph(double a, double b, double c, double maxI, double minI, double quanPI) {
        double y1 = 0;
        sinPoints.clear();
        if (autoValue) {
            Points p;
            for (double x = 0; x <= 10; x += 0.1) {
                if (x %2 < 1) {
                    y1 = 1;
                    p = new Points(x, y1);
                } else {
                    y1 = 0;
                    p = new Points(x, y1);
                }
                //System.out.println("Auto" + x + "  " + y1 + " " + x % 2);

                sinPoints.add(p);
            }
        }
        else{
            Points p;
            for (double x = minI; x <= maxI; x +=quanPI) {
                if (x%a <(a/2) ) {
                    y1 = b;
                    p = new Points(x, y1);
                } else {
                    y1 = 0;
                    p = new Points(x, y1);
                }
                //System.out.println("nonAuto" + x + "  " + y1 + " " + x % 2);

                sinPoints.add(p);
            }
        }

        funInit("functionGraphPulse.fxml", "Exp");
    }

    private void displayUnitGraph(double a, double b, double c, double maxI, double minI, double quanPI) {
        Points p;
        double y1;
        sinPoints.clear();
        if (!autoValue) {
            y1=(a*minI)+b;
           p=new Points(minI,y1);
          sinPoints.add(p);
          y1=(a*maxI)+b;
             p=new Points(maxI,y1);
            sinPoints.add(p);
        } else {
                p=new Points(0,0);
                sinPoints.add(p);
                p=new Points(10,10);
                sinPoints.add(p);
        }

        funInit("functionGraph.fxml", "unite");
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

    public void goBackAction() {
        Stage stage = (Stage) goBack.getScene().getWindow();
        stage.close();
        try {
            Pane root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            stage.setTitle("Non-linear functions");
            stage.setScene(new Scene(root, 800, 420));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void autoAction() {
        if (this.auto.getText().equals("Auto")) {
            this.auto.setText("NonAuto");
            autoValue = false;
            System.out.println("false");
        } else {
            this.auto.setText("Auto");
            autoValue = true;
            System.out.println("true");
        }
    }
    public void nonAutoTextFieldEvent(){
        this.auto.setText("NonAuto");
        autoValue = false;
        System.out.println("false");
    }

}
