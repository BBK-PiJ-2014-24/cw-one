package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import sml.AddInstruction;
import sml.Machine;
import sml.Registers;

public class TestInstruction_Add {

	Machine m;
	int x,y,z;
	int regX, regY, regZ;
	Registers testRegs;
	
	@Before
	public void setUp(){
	
		regX = 1;
		regY = 2;
		regZ = 3;

		m = new Machine();
		m.setRegisters(new Registers());  // normally set by m.execute()
		
		System.out.println("Register Initialization \n"+ m.getRegisters()); // show empty registers before hand
		
		testRegs = new Registers(); // set up mock register for test comparison
				
	}
	
	/**
	 * Test for adding two positive numbers
	 */
	@Test
	public void test1() {
		
		System.out.println("\nTest 1");
		x = 5;
		y = 6;
		z = 11;
		
		testRegs.setRegister(regX, x); //  populate mock register
		testRegs.setRegister(regY, y);
		testRegs.setRegister(regZ, z);
		
		m.getRegisters().setRegister(regX, x); // add inputs to registers
		m.getRegisters().setRegister(regY, y);
		
		AddInstruction in1 = new AddInstruction("L1", regZ,regX, regY);  // instanstiate Instruction 
		
		System.out.println(in1.toString());
		in1.execute(m);  // Execute Instruction
		System.out.println(m.getRegisters());
		
		Assert.assertTrue("Check Registers for Adding: ", testRegs.equals(m.getRegisters()));
	}
	
	/**
	 * Test for adding two negative numbers
	 */
	@Test
	public void test2() {
		System.out.println("\nTest 2");
		x = -5;
		y = -6;
		z = -11;
		
		testRegs.setRegister(regX, x); // set up mock register
		testRegs.setRegister(regY, y);
		testRegs.setRegister(regZ, z);
		
		m.getRegisters().setRegister(regX, x); // add inputs to registers
		m.getRegisters().setRegister(regY, y);
		
		AddInstruction in1 = new AddInstruction("L1", regZ,regX, regY);  // test method
		
		System.out.println(in1.toString());
		in1.execute(m);
		System.out.println(m.getRegisters());
		
		Assert.assertTrue("Check Registers for Adding: ", testRegs.equals(m.getRegisters()));
	}
	
	

}
