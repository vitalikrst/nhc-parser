package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class FileOpts {
	
	/**
	 * Load the data source from the URL and return a Scanner object for source iteration
	 */
	public static Scanner getSourceScanner(Region region) {
		
		URL url = null;
		Scanner scanner = null;
		
		Properties source = new Properties();

		try (BufferedReader sourceFile = new BufferedReader(new FileReader("source.properties"));) {
			
			source.load(sourceFile);

			if (region == Region.ATLANTIC) {
				url = new URL(source.getProperty("atlanticdb"));
			} else if (region == Region.NORTHEAST) {
				url = new URL(source.getProperty("northeastdb"));
			}
			
			scanner = new Scanner(url.openStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return scanner;
	}
	
	/**
	 * Save the results to a file
	 */
	public static void writeToFile(List<String> list, String filename) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false));) {
			for (String s: list) {
				bw.write(s);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
