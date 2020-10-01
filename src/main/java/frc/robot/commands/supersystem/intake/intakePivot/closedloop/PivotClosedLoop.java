/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.supersystem.intake.intakePivot.closedloop;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems;

public class PivotClosedLoop extends CommandBase {

  public Subsystems subsystems;
  public int setpoint;
  /**
   * Creates a new PivotClosedLoop.
   */
  public PivotClosedLoop(Subsystems subsystems, int setpoint) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.subsystems = subsystems;
    this.setpoint = setpoint;
    addRequirements(this.subsystems.intakePivot);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.subsystems.intakePivot.pivot.drivePosition(setpoint);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(this.subsystems.intakePivot.pivot.getSelectedSensorPosition() -this.setpoint) < Constants.IntakeConstants.IntakeMotionParameters.ACCEPTABLE_ERROR_TICKS ;
  }
}
