import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class controller {
	
	private String[][] curr_Arr;
	public int countLoad;
	private String[][] processed;
	
	public controller() {
		curr_Arr = null;
		countLoad = 0;
	}
	
	public String[][] tableData(File csv_file, int width) throws FileNotFoundException {
		String[][] array; // test for 2d array
		int count = 0;
		int line = 0;
		Scanner sc = new Scanner(csv_file);
		sc.useDelimiter(",");
		while(sc.hasNextLine()) {
			sc.nextLine();
			line++;
		}
		System.out.println(line);
		array = new String[line][width];
		sc = new Scanner(csv_file);
		sc.useDelimiter(",");
		for(int i = 0;i < line;i++) {
			while(count < width) {
				array[i][count] = sc.next().replace("\"", "");
				System.out.println("Element: " + count + array[i][count]);
				count++;
			}
			count = 0;
		}
		System.out.println("Roster array created");
		return array;
	}
	
	public String[] generateColumns(ArrayList<String> months, ArrayList<String> days, int dateCount) {
		String[] array = new String[6 + dateCount];
		for(int i = 0; i < (6+dateCount);i++) {
			if(i == 0) {
				array[i] = "ID";
			}
			else if(i==1) {
				array[i] = "First Name";
			}
			else if(i==2) {
				array[i] = "Last Name";
			}
			else if(i==3) {
				array[i] = "Program";
			}
			else if(i==4) {
				array[i] = "Level";
			}
			else if(i==5) {
				array[i] = "ASURITE";
			}
			else {
				array[i] = months.get(i-6).substring(0,3) + " " + days.get(i-6);
			}
		}
		return array;
	}
	
	public String[][] attenAddData(File atten_file, int width) throws FileNotFoundException {
		Scanner sc = new Scanner(atten_file);
		sc.useDelimiter(",");
		countLoad = 0;
		int new_length = width;
		int line = 0;
		while(sc.hasNextLine()) {
			line++;
			sc.nextLine();
		}
		sc = new Scanner(atten_file);
		sc.useDelimiter(",");
		String[][] array = new String[curr_Arr.length][new_length];
		int count = 0;
		for(int i = 0;i < array.length;i++) {
			while(count < new_length) {
				if(count == new_length-1 && (array[i][5].equals(processed[i][0]))) {
					array[i][count] = processed[i][1];
					countLoad++;
					sc.next();
					sc.next();
					/*
					if(sc.hasNext()) {
						
						if(array[i][5].equals(sc.next().replaceAll("[^a-zA-Z]", ""))) {
							System.out.println(array[i][5] + "found");
								array[i][count] = sc.next();
								countLoad++;
							
						} else {
							sc.next();
							
							
						}
					}
					*/
						
					System.out.println(array[i][count]);
					
				} else {
					array[i][count] = curr_Arr[i][count];
				}
				count++;
			}
			count = 0;
			
		}
		curr_Arr = array;
		return array;
		
	}
	
	public String[][] attenTableData(File atten_file, File csv_file, int width) throws FileNotFoundException {
		String [][] array;
		System.out.println("Current atten width: " + width);
		int count = 0;
		int lineCSV = 0;
		int lineA = 0;
		countLoad = 0;
		Scanner sc = new Scanner(csv_file);
		Scanner sc1 = new Scanner(atten_file);
		sc.useDelimiter(",");
		while(sc.hasNextLine()) {
			sc.nextLine();
			lineCSV++;
		}
		while(sc1.hasNextLine()) {
			sc1.nextLine();
			lineA++;
		}
		array = new String[lineCSV][width];
		sc = new Scanner(csv_file);
		sc1 = new Scanner(atten_file);
		sc.useDelimiter(",");
		sc1.useDelimiter(",");
		for(int i = 0;i < lineCSV;i++) {
			while(count < width) {
				if(count > 5 && (array[i][5].equals(processed[i][0]))) {
					array[i][count] = processed[i][1];
					countLoad++;
					
					/*
					if(sc1.hasNext()) {
						
						if(array[i][count-1].equals(sc1.next().replaceAll("[^a-zA-Z]", ""))) {
							System.out.println(array[i][count-1] + "found");
								array[i][count] = sc1.next();
								countLoad++;
							
						} else {
							sc1.next();
							
							
						}
						
						System.out.println(array[i][count]);
					}
					*/
					System.out.println(array[i][count]);
					
				} else {
					array[i][count] = sc.next().replace("\"", "");
					
				}
				count++;
			}
			count = 0;
		}
		System.out.println("Attendance Array Created");
		curr_Arr = array;
		return array;
	}
	
	public String[][] processAttenFile(File atten_file, File csv_file) throws FileNotFoundException {
		int lineC = 0;
		int lineA = 0;
		Scanner sc = new Scanner(csv_file);
		Scanner sc1 = new Scanner(atten_file);
		String str;
		String str2;
		int sum = 0;
		sc.useDelimiter(",");
		sc1.useDelimiter(",");
		while(sc.hasNextLine()) {
			lineC++;
			sc.nextLine();
		}
		processed = new String[lineC][2];
		sc = new Scanner(atten_file);
		sc.useDelimiter(",");
		while(sc.hasNextLine()) {
			lineA++;
			sc.nextLine();
		}
		String[] temp = new String[lineA];
		sc = new Scanner(atten_file);
		sc.useDelimiter(",");
		for(int k = 0;k < lineA;k++) {
			temp[k] = sc.nextLine();
		}
		sc = new Scanner(atten_file);
		sc.useDelimiter(",");
		// loop to check for repeats and sum them
		
		str = "";
		str2 = "";
		for(int i = 0;i < lineC;i++) {
			sc1 = new Scanner(atten_file);
			str = temp[i];
			int index = str.indexOf(",");
			if(i == lineA - 1) { sum = Integer.parseInt(str.substring(index+1,str.length()));}
			else {sum = Integer.parseInt(str.substring(index+1,str.length()-1));}
			str = str.substring(0,index);
			for(int j = i+1; j < lineA;j++) {
				sc1 = new Scanner(atten_file);
				sc1.useDelimiter(",");
				str2 = temp[j];
				int index2 = str2.indexOf(",");
				int sum1;
				if(j == lineA - 1) { sum1 = Integer.parseInt(str2.substring(index2+1,str2.length()));}
				else {sum1 = Integer.parseInt(str2.substring(index2+1,str2.length()-1));}
				
				str2 = str2.substring(0,index2);
				
				if(str2.equals(str)) {
					sum = sum + sum1;
				}
			}
			if(processed[i][0] == null && processed[i][1] == null) {
				processed[i][0] = str;
				processed[i][1] = Integer.toString(sum);
			}
					
			System.out.println("Processed Array " + i + " 0 " + processed[i][0]);
			System.out.println("Processed Array " + i + " 1 " + processed[i][1]);
		}
		return null;
	}
	
	public void writeDataToCSV(String[][] array, String[] column, int lineC, int width) throws FileNotFoundException {
		System.out.println("In the Write to CSV function");
		try (PrintWriter wr = new PrintWriter(new File("testOut.csv"))) {
			StringBuilder sb = new StringBuilder();
			int count = 0;
			for(int j = 0;j < width;j++) {
				sb.append(column[j]+",");
			}
			sb.append("\n");
			for(int i = 0;i < lineC;i++) {
				while (count < width) {
					if(count == width-1) {
						if(i != 0) {
						
							if(i == lineC - 1) {
								sb.append(array[i][count]);
							} else {
								sb.append(array[i][count]+",");
							}
						} else {
							sb.append(array[i][count]);
							sb.append(",");
						}
					} else {
						sb.append(array[i][count]);
						sb.append(",");
					}
					count++;
					
				}
				
				count = 0;
			}
			wr.write(sb.toString());
			System.out.println("Writing function completed");
		}
	}
	
}









