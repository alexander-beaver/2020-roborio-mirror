package frc.robot.commands.stateTransitions;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.GlobalManager;
import frc.robot.Subsystems;
import frc.robot.commands.supersystem.indexer.IndexerDriveForward;
import frc.robot.commands.supersystem.indexer.indexStageOne.IndexerStageOneDriveForward;
import frc.robot.commands.supersystem.shooter.ShooterRecover;
import frc.robot.commands.supersystem.shooter.ShooterRun;
import frc.robot.commands.supersystem.shooter.ShooterStop;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.Map.entry;

/**
 * @deprecated
 */

public class TriggerMap {
    public Subsystems subsystems;
    //public TransitionCommandGroup tcg;

    public TriggerMap(Subsystems subsystems) {
        this.subsystems = subsystems;
        //this.tcg = new TransitionCommandGroup(this.subsystems);

    }

    public GlobalManager.IndexerManager.IndexerLocationState selectLocationState() {
        return GlobalManager.IndexerManager.locationState;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    /**@deprecated */
	public enum B1C2FAction {
        STOP_MOTORS, NONE
    }
    /**@deprecated */

    public Command newBall() {
        return new SequentialCommandGroup(
            //tcg.stopIndexer(),
            //tcg.incrementIndexerStage()
        );
    }
        /**@deprecated */

    public B1C2FAction evaluateB1C2F() {
        GlobalManager.IndexerManager.IndexerLocationState ls = GlobalManager.IndexerManager.locationState;
        if (ls == GlobalManager.IndexerManager.IndexerLocationState.EMPTY ||
                ls == GlobalManager.IndexerManager.IndexerLocationState.ONE_PC ||
                ls == GlobalManager.IndexerManager.IndexerLocationState.TWO_PC ||
                ls == GlobalManager.IndexerManager.IndexerLocationState.THREE_PC_SHIFTED ||
                ls == GlobalManager.IndexerManager.IndexerLocationState.FOUR_PC_SHIFTED) {
            return B1C2FAction.STOP_MOTORS;
        }

        return B1C2FAction.NONE;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**@deprecated */

    public enum B2C2TAction {
        STOP_MOTORS, NONE, SET_UNCERTAIN
    }
    /**@deprecated */
    public B2C2TAction evaluateB2C2T() {
        GlobalManager.IndexerManager.IndexerLocationState ls = GlobalManager.IndexerManager.locationState;
        if (ls == GlobalManager.IndexerManager.IndexerLocationState.THREE_PC) {
            return B2C2TAction.STOP_MOTORS;
        }
        if (ls == GlobalManager.IndexerManager.IndexerLocationState.EMPTY ||
                ls == GlobalManager.IndexerManager.IndexerLocationState.ONE_PC ||
                ls == GlobalManager.IndexerManager.IndexerLocationState.TWO_PC) {
            return B2C2TAction.SET_UNCERTAIN;
        }
        return B2C2TAction.NONE;
    }
    /**@deprecated */

    public Command onB2C2T() {
        return new SelectCommand(
            Map.ofEntries(
                    //entry(B2C2TAction.STOP_MOTORS, tcg.stopIndexer()),
                    //entry(B2C2TAction.SET_UNCERTAIN, tcg.setIndexerUncertainCommand()),
                    //entry(B2C2TAction.NONE, tcg.bypassCommand())

            ), this::evaluateB2C2T);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean shouldExit() {
        if (GlobalManager.IndexerManager.numBalls <= 0) {
            return true;
        }
        return false;
    }

    public Command onHasShotBall() {
        return new SelectCommand(
            Map.ofEntries(
                    entry(true, new ShooterStop(subsystems.shooter)),
                    entry(false, new ShooterRecover(subsystems.shooter))
            ),
            this::shouldExit
        );
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Command shouldIntake() { System.out.println("Starting ShouldIntake"); 
    Command cmd = new IndexerStageOneDriveForward(subsystems.stageOne); 
    return cmd;
}

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**@deprecated */
    public Boolean needsToShift(){
        if(GlobalManager.IndexerManager.locationState == GlobalManager.IndexerManager.IndexerLocationState.THREE_PC){
            return true;
        }
        return false;
    }
    /**@deprecated */
    public Command shouldShift() {
        return new SelectCommand(
            Map.ofEntries(
                    entry(true, new IndexerDriveForward(subsystems.stageOne, subsystems.stageTwo))
                    //entry(false, tcg.bypassCommand())
            ),
            this::needsToShift
        );
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public enum ShooterMoveType {
        NONE, SPINNING, SPINNINGUP, STOPPED
    }
        public ShooterMoveType shouldSpinup() {
        boolean ta = GlobalManager.TurretManager.targetAcquired;
        boolean sr = GlobalManager.ShooterManager.speedReached;
        

        if (ta == true && sr == false) {
            return ShooterMoveType.SPINNINGUP;
        }
        if (ta == false) {
            return ShooterMoveType.NONE;
        }
        if (ta == true && sr == true) {
            return ShooterMoveType.SPINNING;
        }
        return ShooterMoveType.NONE;
    }

    public ShooterMoveType shouldRun(){
        boolean ta = GlobalManager.TurretManager.targetAcquired;
        boolean sr = GlobalManager.ShooterManager.speedReached;

        if (ta == true && sr == true) {
            return ShooterMoveType.SPINNING;
        }
        return ShooterMoveType.NONE;
    }

    public ShooterMoveType shouldStop(){
        boolean ta = GlobalManager.TurretManager.targetAcquired;

        if (ta == false) {
            return ShooterMoveType.STOPPED;
        }
        return ShooterMoveType.NONE;
    }
    
    public Command shouldSpinnup() {
        return new SelectCommand(
            Map.ofEntries(
                    entry(ShooterMoveType.SPINNINGUP, new ShooterRecover(subsystems.shooter))
            ),

            this::shouldSpinup
        );
    }
    public Command shouldRunCommand() {
        return new SelectCommand(
            Map.ofEntries(
                    entry(ShooterMoveType.SPINNING, new ShooterRun(subsystems.shooter))
            ),

            this::shouldRun
        );
    }

    public Command shouldStopCommand() {
        return new SelectCommand(
            Map.ofEntries(
                    entry(ShooterMoveType.STOPPED, new ShooterStop(subsystems.shooter))
            ),

            this::shouldStop
        );
    }
}
