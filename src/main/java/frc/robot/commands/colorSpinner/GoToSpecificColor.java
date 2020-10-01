/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands.colorSpinner;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ControlPanelSpinner;;

public class GoToSpecificColor extends CommandBase {

  private boolean done = false;
  public ControlPanelSpinner controlPanelSpinner;

  public GoToSpecificColor(ControlPanelSpinner controlPanelSpinner) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.controlPanelSpinner = controlPanelSpinner;
    addRequirements(this.controlPanelSpinner);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    controlPanelSpinner.resetTo0();
    controlPanelSpinner.resetToFalse();
    controlPanelSpinner.spin(Constants.ControlPanelSpinnerConstants.ControlPanelSpinnerMotors.SPIN_SPEED);
      done = false;

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    controlPanelSpinner.spin(Constants.ControlPanelSpinnerConstants.ControlPanelSpinnerMotors.SPIN_SPEED);
    if (controlPanelSpinner.getRevolutionsCounter()>=8){
      if (controlPanelSpinner.reachedColor() == true){
         done = true;
     }
  }
   }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return done;
  }

  // Called once after isFinished returns true

  public void end() {
      controlPanelSpinner.spin(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run

  public void interrupted() {
      end();
  }
}
