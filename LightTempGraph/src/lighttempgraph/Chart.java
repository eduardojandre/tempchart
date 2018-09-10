package lighttempgraph;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JPanel;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.lines.SeriesLines;

public class Chart {
	final XYChart chart;
	JPanel chartPanel;
	String seriesName;
	XChartPanel<XYChart> chartPane;
	ArrayList<Double> tempData;
	ArrayList<Double> timeData;
	public Chart(String title,String eixoX,String eixoY,Double initialValue) {
		
	    tempData=new ArrayList<Double>();
	    timeData=new ArrayList<Double>();

	    timeData.add((double) 0);
	    tempData.add((double) initialValue);
		
		chart = QuickChart.getChart(title, eixoX, eixoY, eixoY, timeData, tempData);
		
		seriesName=eixoY;
                               
                chart.getStyler().setLegendVisible(false);
                

	    chartPane = new XChartPanel<XYChart>(chart);
	}
	public XChartPanel<XYChart> getPanel(){
		return chartPane;
	}
	public void updateChart(Double newValue) {
		Double last=timeData.get(timeData.size()-1);
		if(timeData.size()>100) {
			timeData.remove(0);
			tempData.remove(0);
		}
		timeData.add(last+1);
		tempData.add((double) newValue);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

	          public void run() {

	            chart.updateXYSeries(seriesName, timeData, tempData, null);
	            chartPane.repaint();
	          }
	        });
	}
}
