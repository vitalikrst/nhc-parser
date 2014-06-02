package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.FileOpts;
import util.Region;

public class HurdatParser {
	
	
	public static List<String> getHurricaneInfo(Region region, int year) {
		
		List<String> result = new ArrayList<>();
		
		Scanner scanner = FileOpts.getSourceScanner(region);
		
		/**
		 * Loading regexps
		 */
		Properties regexp = new Properties();
		
		try (BufferedReader regexpFile = new BufferedReader(new FileReader("regexp.properties"));) {
			regexp.load(regexpFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * Pattern for the hurricane name
		 */
		Pattern namePattern = Pattern.compile(
				regexp.getProperty("HURDAT2_NameYear").replaceFirst("year", String.valueOf(year)),
				Pattern.CASE_INSENSITIVE);
		
		/**
		 * Pattern for the hurricane data
		 */
		Pattern dataPattern = Pattern.compile(
				regexp.getProperty("HURDAT2_DataYear").replaceFirst("year", String.valueOf(year)),
				Pattern.CASE_INSENSITIVE);
		
		/**
		 * Matchers
		 */
		Matcher nameMatcher = null;
		Matcher dataMatcher = null;

		String line = null;
		String lastNameLine = "";

		int maxWindSpeed = 0;
		String hurricaneName = "";
		
		/**
		 * Datasource iteration
		 */
		while (scanner.hasNextLine()) {

			if (!lastNameLine.equals("")) {
				line = lastNameLine;
				nameMatcher = namePattern.matcher(line);
			} else {
				line = scanner.nextLine();
				nameMatcher = namePattern.matcher(line);
			}
			
			if (nameMatcher.find()) {
				/**
				 * retrieve the hurricane name
				 */
				hurricaneName = nameMatcher.group(6);

				while (scanner.hasNextLine()) {
					line = scanner.nextLine();
					dataMatcher = dataPattern.matcher(line);
					
					/**
					 * determining maximum sustained wind speed in knots
					 */
					if (dataMatcher.find()) {
						int temp = Integer.parseInt(dataMatcher.group(2));
						if (temp >= maxWindSpeed) {
							maxWindSpeed = temp;
						}
					}
					
					nameMatcher = namePattern.matcher(line);
					if (nameMatcher.find()) {
						/**
						 * save last match
						 */
						lastNameLine = scanner.match().group();
						break;
					}
				}
			}
			if (maxWindSpeed > 0 && !hurricaneName.equals("")) {
				result.add(hurricaneName + ": " + maxWindSpeed + " knots");
			}
			maxWindSpeed = 0;
		}
		
		scanner.close();
		
		return result;
	}
	
	public static String getSingleHurricaneInfo(Region region, String hurricaneName) {
		
		String result = null;
		
		/*
		 * 
		 */
		
		return result;
	}
	

}
