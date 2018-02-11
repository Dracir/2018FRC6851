package org.usfirst.frc.team6851.robot.commands.autonomous;

import org.usfirst.frc.team6851.robot.commands.claw.DropPowerCube;
import org.usfirst.frc.team6851.robot.commands.driving.MoveDistance;
import org.usfirst.frc.team6851.robot.commands.driving.MoveUntilNearWall;
import org.usfirst.frc.team6851.robot.commands.driving.TurnRobotCommand;

public class AutoSideDropSwitchThenPowercube extends AutonomousCommand {

	public AutoSideDropSwitchThenPowercube(boolean angleReversed) {
		double angleFactor = angleReversed ? -1 : 1; 
		
		addSequential(new MoveDistance(20*12,MoveSpeedFast));
		addSequential(new DropPowerCube());
		
		addSequential(new MoveDistance(-10*12,MoveSpeedFast));
		
		addSequential(new TurnRobotCommand(90 * angleFactor, MoveSpeedFast));
		
		
		addSequential(new MoveDistance(2*12, MoveSpeedLow));
		addSequential(new TurnRobotCommand(90 * angleFactor, MoveSpeedFast));
	}
	

}