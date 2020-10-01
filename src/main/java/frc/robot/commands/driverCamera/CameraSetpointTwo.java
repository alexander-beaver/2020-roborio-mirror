package frc.robot.commands.driverCamera;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CameraTiltServo;;

public class CameraSetpointTwo extends CommandBase {
  private CameraTiltServo servo;
  private boolean done = false;
  
  /**
   * Creates a new UnlockClimber.
   */
  public CameraSetpointTwo(CameraTiltServo cts) {
    servo = cts;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(servo);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    servo.setpointTwo();
    done = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    done = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}