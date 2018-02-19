package org.usfirst.frc.team6851.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Ultrasonic.Unit;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public abstract class SubsystemBase extends Subsystem {

	protected DigitalInput tryInitDigitalInput(int chanel, String name) {
		try {
			DigitalInput di = new DigitalInput(chanel);
			return di;
		} catch (Exception e) {
			if (e.getMessage().contains("Code: -1029")) {
				System.err.println("ERRROR! DigitalInput " + name + " at " + chanel + " is not pluged-in.");
			} else {
				System.err.println(e.getMessage());
			}
			return null;
		}
	}

	protected AnalogPotentiometer tryInitAnalogInput(int chanel, String name) {
		try {
			AnalogPotentiometer ai = new AnalogPotentiometer(chanel);
			//AnalogInput.setGlobalSampleRate(62500);

			return ai;
		} catch (Exception e) {
			if (e.getMessage().contains("Code: -1029")) {
				System.err.println("ERRROR! AnalogPotentiometer " + name + " at " + chanel + " is not pluged-in.");
				System.err.println(e.getMessage());
			} else {
				System.err.println(e.getMessage());
			}
			return null;
		}
	}

	protected Encoder tryInitEncoder(int sourceA, int sourceB, boolean reversed, String name) {
		try {
			Encoder encoder = new Encoder(sourceA, sourceB, reversed, EncodingType.k1X);
			LiveWindow.add(encoder);
			return encoder;

		} catch (Exception e) {
			if (e.getMessage().contains("Code: -1029")) {
				System.err.println("ERRROR! Encoder " + name + "at source A:" + sourceA + " and source B:" + sourceB
						+ " is not pluged-in.");
			} else {
				System.err.println(e.getMessage());
			}
		}
		return null;
	}

	protected Ultrasonic tryInitSensor(int ping, int echo, String name) {
		try {
			Ultrasonic sensor = new Ultrasonic(ping, echo);
			sensor.setAutomaticMode(true);
			sensor.setDistanceUnits(Unit.kInches);
			LiveWindow.add(sensor);
			return sensor;
		} catch (Exception e) {
			System.err.println(
					"ERRROR! Sensor " + name + "of ping:" + ping + " and echo :" + echo + " is not pluged-in.");
			if (e.getMessage() != null)
				System.err.println(e.getMessage());
		}
		return null;
	}
}
