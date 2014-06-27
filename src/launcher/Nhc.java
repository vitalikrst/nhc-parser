package launcher;

import java.util.List;

import parser.HurdatParser;
import parser.HurricaneInfo;
import util.Region;

public class Nhc {

	public static void main(String[] args) {

		List<HurricaneInfo> list = HurdatParser.getHurricaneInfo(Region.NORTHEAST, 1988);

		if (list == null) {
			System.out.println("No data");
		} else {
			for (HurricaneInfo s : list) {
				System.out.println(s.toString());
			}
		}
		
//		HurricaneInfo obj = HurdatParser.getSingleHurricaneInfo(Region.NORTHEAST, "GIL");
//		
//		System.out.println(obj.toString());

	}

}
