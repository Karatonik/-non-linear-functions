package nonLinearFunctionsProject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class FunctionController implements Initializable {

    @FXML
    private LineChart<?, ?> Graph;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;

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
        for (int x = 0; x <=20; x++) {
            Double x1 = EditionController.sinPoints.get(x).x;
            String x2 = x1.toString();
            series.getData().add(new XYChart.Data(x2, EditionController.sinPoints.get(x).y));
        }
        Graph.getData().addAll(series);

    }

    public void pulseGraph() {

    }

    public void unitGraph() {

    }
}
