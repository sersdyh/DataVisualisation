package web_manager;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 
public class D3View extends Application {

	private Scene scene;

	@Override public void start(Stage stage) {
		// create the scene
		String chartType = null; // typos chart
		Parameters p = getParameters();
		List<String> rawArguments = p.getRaw();
		for (String s: rawArguments) {
			chartType = s;
		}
		
		stage.setTitle("D3 View");
		scene = new Scene(new Browser(chartType), 750, 500, Color.web("#666970"));
		stage.setScene(scene);
		stage.show();
		stage.setAlwaysOnTop(false);
    }

}

class Browser extends Region {

	final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    public Browser(String chartType) {
        //apply the styles
        getStyleClass().add("browser");
        // load the web page
        if (chartType.equals("Bar chart")) {
        	webEngine.load("http://localhost/bar_plot.html");
        } else if (chartType.equals("Scatter Plot")) {
        	webEngine.load("http://localhost/scatter_plot.html");
        } else if (chartType.equals("Timeline/Trendline")) {
        	webEngine.load("http://localhost/line_plot.html");
        }
        //add the web view to the scene
        getChildren().add(browser);
    }
	@SuppressWarnings("unused")
	private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }

    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser, 0, 0, w, h, 0, HPos.CENTER, VPos.CENTER);
    }

    @Override protected double computePrefWidth(double height) {
        return 750;
    }

    @Override protected double computePrefHeight(double width) {
        return 500;
    }
}