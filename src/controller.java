import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class controller {
	public controller() {
		
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
	
	public String[][] attenTableData(File atten_file, File csv_file, int width) throws FileNotFoundException {
		String [][] array;
		int count = 0;
		int lineCSV = 0;
		int lineA = 0;
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
				if(count == 6) {
					for(int j = 0;j < lineA;j++) {
						if(sc1.hasNext()) {
							if(array[j][count-1].equals(sc1.next())) {
								array[j][count] = sc1.next();
							} else {
								sc1.next();
							}
							System.out.println(array[j][count]);
						}
						
					}
				} else {
					array[i][count] = sc.next().replace("\"", "");
				}
				count++;
			}
			count = 0;
		}
		System.out.println("Attendance Array Created");
		return array;
	}
	
}
