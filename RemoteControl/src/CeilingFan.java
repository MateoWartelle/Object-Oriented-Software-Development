
public class CeilingFan {
	String location = "";

	public CeilingFan(String location) {
		this.location = location;
	}

	public void high() {
		System.out.println(location + " fan is on and set it high");
	}
	public void on() {
		System.out.println(location + " fan is on");
	}

	public void off() {
		System.out.println(location + " fan is off");
	}
}

