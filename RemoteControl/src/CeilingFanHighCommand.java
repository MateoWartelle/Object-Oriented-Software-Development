
public class CeilingFanHighCommand implements Command {
	CeilingFan Fan;

	public CeilingFanHighCommand(CeilingFan Fan) {
		this.Fan = Fan;
	}

	@Override
	public void execute() {
		Fan.high();
	}

	@Override
	public void undo() {
		Fan.off();
	}
}
