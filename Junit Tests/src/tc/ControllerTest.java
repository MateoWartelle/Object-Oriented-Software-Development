package tc;


import static org.junit.Assert.*;

import org.junit.Test;

import code.SimulationController;

public class ControllerTest {

	@Test
	public void testZooSimulation(){	
		SimulationController controller = new SimulationController();
		String[] entryTest = {"*","Sam","Ben","Mary","Joe","*","*"};
		controller.enterZoo(entryTest);
		assertEquals(controller.getListOfPeopleInQueue(),"Joe");
	}
	
	@Test
	public void testZooSimulation2(){	
		SimulationController controller = new SimulationController();
		String[] entryTest = {"*","Sam","Ben","Mary","Joe","*","*","*","*","*"};
		controller.enterZoo(entryTest);
		assertEquals(controller.countPeopleInQueue(),0);
		System.out.println("Unspent: " + controller.countUnspentCoins());
		assertEquals(controller.countUnspentCoins(),2);
	}

}
