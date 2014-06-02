package parser;

/**
 * Represents the hurricane info class
 */
public class HurricaneInfo {

	private String name;
	private int minWindSpeed;
	private int maxWindSpeed;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinWindSpeed() {
		return minWindSpeed;
	}

	public void setMinWindSpeed(int minWindSpeed) {
		this.minWindSpeed = minWindSpeed;
	}

	public int getMaxWindSpeed() {
		return maxWindSpeed;
	}

	public void setMaxWindSpeed(int maxWindSpeed) {
		this.maxWindSpeed = maxWindSpeed;
	}

	public HurricaneInfo() {
		super();
	}

	public HurricaneInfo(String name, int minWindSpeed, int maxWindSpeed) {
		super();
		this.name = name;
		this.minWindSpeed = minWindSpeed;
		this.maxWindSpeed = maxWindSpeed;
	}

	@Override
	public String toString() {
		return "HurricaneInfo [name=" + name + ", minWindSpeed=" + minWindSpeed
				+ ", maxWindSpeed=" + maxWindSpeed + "]";
	}

}
