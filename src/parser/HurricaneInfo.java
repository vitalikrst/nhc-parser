package parser;

/**
 * Represents the hurricane info class
 */
public class HurricaneInfo {

	private String name;
	private int maxWindSpeed;
	private int minWindSpeed;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxWindSpeed() {
		return maxWindSpeed;
	}

	public void setMaxWindSpeed(int maxWindSpeed) {
		this.maxWindSpeed = maxWindSpeed;
	}

	public int getMinWindSpeed() {
		return minWindSpeed;
	}

	public void setMinWindSpeed(int minWindSpeed) {
		this.minWindSpeed = minWindSpeed;
	}

	public HurricaneInfo() {
		super();
	}

	public HurricaneInfo(String name, int maxWindSpeed, int minWindSpeed) {
		super();
		this.name = name;
		this.maxWindSpeed = maxWindSpeed;
		this.minWindSpeed = minWindSpeed;
	}

	@Override
	public String toString() {
		return "HurricaneInfo [name=" + name + ", maxWindSpeed=" + maxWindSpeed
				+ ", minWindSpeed=" + minWindSpeed + "]";
	}

}
