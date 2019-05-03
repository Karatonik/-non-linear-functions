package nonLinearFunctionsProject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.util.ResourceBundle;

public class FunctionController implements Initializable {

    @FXML
    private LineChart<?, ?> Graph;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    private ScatterChart<?, ?> GraphPulse;

    public void initialize(URL url, ResourceBundle rb) {
        switch (MainController.select) {
            case 1: {
                sinGraph();
                break;
            }
            case 2: {
                expGraph();
                break;
            }
            case 3: {
                pulseGraph();
                break;
            }
            case 4: {
                unitGraph();
                break;
            }

        }
    }


    public void sinGraph() {
        XYChart.Series series = new XYChart.Series();
        Double set;
        if(EditionController.autoValue){
            set=50.0;

        }else{
            set =EditionController.value;
        }
        for (int x = 0; x <= set; x++) {
            Double x1 = EditionController.sinPoints.get(x).x;
            String x2 = x1.toString();
            series.getData().add(new XYChart.Data(x2, EditionController.sinPoints.get(x).y));
        }
        Graph.getData().addAll(series);

    }

    public void expGraph() {
        XYChart.Series series = new XYChart.Series();
        Double set;
        if(EditionController.autoValue){
            set=10.0;

        }else{
            set =EditionController.value;
        }
        for (int x = 0; x <=set; x++) {
            Double x1 = EditionController.sinPoints.get(x).x;
            String x2 = x1.toString();
            series.getData().add(new XYChart.Data(x2, EditionController.sinPoints.get(x).y));
        }
        Graph.getData().addAll(series);

    }

    public void pulseGraph() {
        XYChart.Series series = new XYChart.Series();
        Double set;
        if(EditionController.autoValue){
            set=100.0;

        }else{
            set =EditionController.value;
        }
        for (int x = 0; x <=set; x++) {
            Double x1 = EditionController.sinPoints.get(x).x;
            String x2 = x1.toString();
            series.getData().add(new XYChart.Data(x2, EditionController.sinPoints.get(x).y));
        }
        GraphPulse.getData().addAll(series);

    }

    public void unitGraph() {
        XYChart.Series series = new XYChart.Series();
        for (int x = 0; x <=2; x++) {
            Double x1 = EditionController.sinPoints.get(x).x;
            String x2 = x1.toString();
            series.getData().add(new XYChart.Data(x2, EditionController.sinPoints.get(x).y));
        }
        Graph.getData().addAll(series);


    }
}
