package launcher;

import java.util.List;

import parser.HurdatParser;
import parser.HurricaneInfo;
import util.Region;


public class Nhc {

	public static void main(String[] args) {
		
		List<HurricaneInfo> list = HurdatParser.getHurricaneInfo(Region.NORTHEAST, 2009);		
		
		for(HurricaneInfo s: list) {
			System.out.println(s.toString());
		}
		
		
	}

}
