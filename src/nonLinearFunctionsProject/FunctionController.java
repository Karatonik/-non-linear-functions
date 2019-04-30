package nonLinearFunctionsProject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class FunctionController  implements Initializable {
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series series=new XYChart.Series();
        for(int x=0;x<200;x++) {
            series.getData().add(new XYChart.Data(EditionController.sinPoints.get(x).x,EditionController.sinPoints.get(x).y));
        }
        Graph.getData().addAll(series);

    }
    @FXML
    private LineChart<?, ?> Graph;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
}
