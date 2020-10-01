/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.FRCLib.Motors.FRCTalonSRX;

public class IndexerStageTwo extends SubsystemBase {
  public FRCTalonSRX indexerStageTwo;


  public static enum ActionState {
    MOVE_FORWARD, MOVE_BACKWARDS, STOP
  }
  public ActionState actionState;


  public DigitalInput sensor;
  public DigitalInput shiftSensor;
  /**
   * Creates a new Indexer.
   */
  public IndexerStageTwo() {
    sensor = new DigitalInput(Constants.IndexerConstants.IndexerSensors.RearSensor.ID);
    shiftSensor = new DigitalInput(Constants.IndexerConstants.IndexerSensors.ShiftSensor.ID);

    indexerStageTwo = new FRCTalonSRX.FRCTalonSRXBuilder(
        Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.CAN_ID)
            .withInverted(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.INVERT)
            .withFeedbackPort(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.FEEDBACK_PORT)
            .withSensorPhase(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.SENSOR_PHASE)
            .withTimeout(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.TIMEOUT)
            .withCurrentLimitEnabled(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.ENABLE_CURRENT_LIMIT)
            .withCurrentLimit(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.CURRENT_LIMIT)
            .withOpenLoopRampRate(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.OPEN_LOOP_RAMP)
            .withNominalOutputForward(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.NOMINAL_OUTPUT_FORWARD)
            .withNominalOutputReverse(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.NOMINAL_OUTPUT_REVERSE)
            .withPeakOutputForward(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.PEAK_OUTPUT_FORWARD)
            .withPeakOutputReverse(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.PEAK_OUTPUT_REVERSE)
            .build();

            addChild("rearSensor", sensor);
            addChild("indexerStageTwo", indexerStageTwo);
  }

  /**
   * Update any states
   */
  public void updateState() {

  }

  public boolean getSensorValue() {
    return sensor.get(); //sensor.get();
  }
  public boolean getShiftSensorValue(){
    return shiftSensor.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    updateState();
  }
}
