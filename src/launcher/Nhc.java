package launcher;

import java.util.List;

import parser.HurdatParser;
import util.Region;


public class Nhc {

	public static void main(String[] args) {
		
		List<String> list = HurdatParser.getHurricaneInfo(Region.ATLANTIC, 2009);		
		
		for(String s: list) {
			System.out.println(s);
		}
		
		
	}

}
