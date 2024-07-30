package commandPatternExample;

public class CommandPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Light livingRoomLight = new Light();

	        Command lightOn = new LightOnCommand(livingRoomLight);
	        Command lightOff = new LightOffCommand(livingRoomLight);

	        RemoteControl remote = new RemoteControl();

	        // Turn the light on
	        remote.setCommand(lightOn);
	        remote.pressButton();

	        // Turn the light off
	        remote.setCommand(lightOff);
	        remote.pressButton();
	}

}
