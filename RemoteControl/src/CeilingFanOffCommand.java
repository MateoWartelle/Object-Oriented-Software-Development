
public class CeilingFanOffCommand implements Command {

	CeilingFan Fan;

	public CeilingFanOffCommand(CeilingFan Fan) {
		this.Fan = Fan;
	}
	
	@Override
	public void execute() {
		Fan.off();
	}

	@Override
	public void undo() {
		Fan.high();
		
	}

}
