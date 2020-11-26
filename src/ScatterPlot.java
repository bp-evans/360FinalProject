/*
Name: Brandon, Cameron, Ismael
Class ID: 70606
Assignment: Final Project
Description: This is the ScatterPlot class which is used in 
			 the menu whenever the user selects "Plot Data".
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.XYPlot;  
import org.jfree.data.xy.XYDataset;  
import org.jfree.data.xy.XYSeries;  
import org.jfree.data.xy.XYSeriesCollection;

public class ScatterPlot extends JFrame{
	
	public ScatterPlot() {
        XYDataset dataset = createDataset();
		JFreeChart chart = ChartFactory.createScatterPlot(" ", "X-Axis", "Count", dataset);
		
		XYPlot plot = (XYPlot)chart.getPlot();
		plot.setBackgroundPaint(new Color(255,228,196));
		
		ChartPanel panel = new ChartPanel(chart);
		setContentPane(panel);
	}
	
	public XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series = new XYSeries("Student Attendance");
		
		//NOTE: here is where we would add the information to be plotted
		
		return dataset;
	}

}
