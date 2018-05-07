

public class RemoteLoader {
 
	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();
 
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan CeilingFan = new CeilingFan("Living Room Fan");
		Stereo stereo = new Stereo("Living Room Stereo");

		LightOnCommand livingRoomLightOn = 
				new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = 
				new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenLightOn = 
				new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOff = 
				new LightOffCommand(kitchenLight);
		
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(CeilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(CeilingFan);
		
		StereoOffCommand StereoOff = new StereoOffCommand(stereo);
		StereoOnCommand StereoOn = new StereoOnCommand(stereo);
  
 
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		remoteControl.setCommand(2, ceilingFanHigh, ceilingFanOff);
		remoteControl.setCommand(3, StereoOff, StereoOn);
  
		System.out.println(remoteControl);
 
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		remoteControl.onButtonWasPushed(2);
		remoteControl.offButtonWasPushed(2);
		remoteControl.onButtonWasPushed(3);
		remoteControl.offButtonWasPushed(3);
	}
}
