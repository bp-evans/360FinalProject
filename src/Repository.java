import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;
import java.util.Stack;

import javax.sound.sampled.Line;

public class Repository extends Observable{
	
	private double totalDistance;
	private Stack<Point> points;
	private Stack<Line> lines;
	private int count;
	
	public Repository() {
		this.points = new Stack<Point>();
		this.count = 0;
	}
	public Repository getInstance() {
		return this;
		
	}
	public Stack<Point> getPoints() {
		return this.points;
		
	}
	public Stack<Line> Lines() {
		return null;
		
	}
	public void updatePoints(int dateCount) throws FileNotFoundException {
		String str = "";
		int line = 0;
		this.points = new Stack<Point>();
		File outFil = new File("testOut.csv");
		Scanner sc = new Scanner(outFil);
		sc.useDelimiter(",");
		int index = 0;
		while(sc.hasNextLine()) {
			
			sc.nextLine();
			line++;
		}
		sc = new Scanner(outFil);
		sc.useDelimiter(",");
		int width = 6 + dateCount;
		System.out.println(width);
		System.out.println(line);
		String[][] arr = new String[line][width];
		for(int i = 0;i < line;i++) {
			for(int j = 0;j < width;j++) {
				arr[i][j] = sc.next().replace("\"","");
				System.out.println(arr[i][j]);
			}
		
		}
		str = "";
		String str1 = "";
		Point pt = new Point();
		for(int i = 6;i < width;i++) {
			str = arr[0][i].replaceAll("[^\\d.]", "");
			for(int j = 1;j < line;j++) {
				str1 = str + arr[j][i];
				pt = new Point(1,Integer.parseInt(str1));
				System.out.println("X: " + pt.x + "Y: " + pt.y);
				this.points.push(pt);
			}
		}
		System.out.println("Update pt loop done");
		setChanged();
		notifyObservers("Change");
		//System.out.println(arr.toString());
	}
	
}
