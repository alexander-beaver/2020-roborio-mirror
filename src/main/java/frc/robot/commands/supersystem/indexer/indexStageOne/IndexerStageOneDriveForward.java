/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.supersystem.indexer.indexStageOne;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;

import frc.robot.subsystems.IndexerStageOne.ActionState;

import frc.robot.subsystems.IndexerStageOne;

public class IndexerStageOneDriveForward extends CommandBase {
    public IndexerStageOne indexer;

    /**
     * Creates a new IndexerStageOneDriveForward.
     */
    public IndexerStageOneDriveForward(IndexerStageOne indexer) {
        this.indexer = indexer;
        addRequirements(this.indexer);
        // Use addRequirements() here to declare subsystem dependencies.
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        //System.out.println("WE DONT HAVE ACCESS TO THE ROBOT"); preserved her for prosperity

        this.indexer.actionState = ActionState.MOVE_FORWARD;
        indexer.indexerStageOne.drivePercentOutput(Constants.IndexerConstants.IndexerMotionParameters.STAGE_ONE_PERCENT_OUTPUT_FORWARD);
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
        return false;
    }
}
