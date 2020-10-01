/////////////////////////////////////////////////////////////////
//                                                             //
// Hello Team 100                                              //
//                                                             //
/////////////////////////////////////////////////////////////////
//                                                             //
// This is Constants.java, where most code changes will occur. //
//                                                             //
// Please check with a programmer or programming mentor before //
// making changes to this file.                                //
//                                                             //
// You most likely will not need to make any changes outside   //
// of this file, unless it is a logic problem.                 //
//                                                             //
// Thanks!                                                     //
//                                                             //
/////////////////////////////////////////////////////////////////

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import frc.robot.FRCLib.Conversions.EncoderConversionFactors;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class DrivetrainConstants {
        public static final boolean DEBUG = true;
        public static final Port NAVX_PORT = SerialPort.Port.kUSB;

        public static final class DrivetrainParameters {
            public static final double MAX_OUTPUT = 1;
            public static final NeutralMode NEUTRAL_MODE = NeutralMode.Brake;
            public static final int TICKS_PER_REV = 2048; // TODO FIGURE OUT ACTUAL VALUE

            // public static final double KF = 11.41199782;

            public static final double KS = 0.162;
            public static final double KV = 0.229;
            public static final double KTRACK_WIDTH = 0.6514; // TODO Change
            public static final double KA = 0.0225;

            public static final double KINEMATICS_MAX_RATE_PER_SIDE = 1;

            public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(
                    KTRACK_WIDTH);

            public static final double RAMSETE_B = 0.7; // From WPILib Docs
            public static final double RAMSETE_ZETA = 2.0; // From WPILib Doc

            public static final double GEARING_RATIO = 12.22;
            public static final double WHEEL_DIAMETER = 0.1542;// METERS

        }

        public static final class AutonConstants {
            public static final double DT = 0.05;
            public static final double MAX_VELOCITY = 6;
            public static final double MAX_ACCELERATION = 3;
            public static final double MAX_JERK = .25;
        

        }

        public static final class DrivetrainMotors {
            // public static final double KP = 0.00026;
            // public static final double KI = 0;
            // public static final double KD = 0;
            // public static final double KF = 0.04455;
            public static final double KP = 0.00211;
            public static final double KI = 0;
            public static final double KD = 0.000211;
            public static final double KF = 0.04455;

            public static final class LeftMaster {
                public static final int CAN_ID = 15;
                public static final double PEAK_OUTPUT_FORWARD = Constants.DrivetrainConstants.DrivetrainParameters.MAX_OUTPUT;
                public static final double PEAK_OUTPUT_REVERSE = -Constants.DrivetrainConstants.DrivetrainParameters.MAX_OUTPUT;
                public static final NeutralMode NEUTRAL_MODE = Constants.DrivetrainConstants.DrivetrainParameters.NEUTRAL_MODE;
                public static final InvertType INVERTED = InvertType.None; //TODO CHANGE BACK
                public static final boolean SENSOR_PHASE = false; //TODO CHANGE BACK
                public static final double KP = Constants.DrivetrainConstants.DrivetrainMotors.KP;
                public static final double KI = Constants.DrivetrainConstants.DrivetrainMotors.KI;
                public static final double KD = Constants.DrivetrainConstants.DrivetrainMotors.KD;
                public static final double KF = Constants.DrivetrainConstants.DrivetrainMotors.KF;

            }

            public static final class LeftFollower {
                public static final int CAN_ID = 14;
                public static final double PEAK_OUTPUT_FORWARD = Constants.DrivetrainConstants.DrivetrainParameters.MAX_OUTPUT;
                public static final double PEAK_OUTPUT_REVERSE = -Constants.DrivetrainConstants.DrivetrainParameters.MAX_OUTPUT;
                public static final NeutralMode NEUTRAL_MODE = Constants.DrivetrainConstants.DrivetrainParameters.NEUTRAL_MODE;
                public static final InvertType INVERTED = InvertType.FollowMaster; //TODO CHANGE BACK
                public static final boolean SENSOR_PHASE = false; //TODO CHANGE BACK

                public static final double KP = Constants.DrivetrainConstants.DrivetrainMotors.KP;
                public static final double KI = Constants.DrivetrainConstants.DrivetrainMotors.KI;
                public static final double KD = Constants.DrivetrainConstants.DrivetrainMotors.KD;
                public static final double KF = Constants.DrivetrainConstants.DrivetrainMotors.KF;

            }

            public static final class RightMaster {
                public static final int CAN_ID = 0;
                public static final double PEAK_OUTPUT_FORWARD = Constants.DrivetrainConstants.DrivetrainParameters.MAX_OUTPUT;
                public static final double PEAK_OUTPUT_REVERSE = -Constants.DrivetrainConstants.DrivetrainParameters.MAX_OUTPUT;
                public static final NeutralMode NEUTRAL_MODE = Constants.DrivetrainConstants.DrivetrainParameters.NEUTRAL_MODE;
                public static final InvertType INVERTED = InvertType.InvertMotorOutput; //TODO CHANGE BACK
                public static final boolean SENSOR_PHASE = false; //TODO CHANGE BACK
                public static final double KP = Constants.DrivetrainConstants.DrivetrainMotors.KP;
                public static final double KI = Constants.DrivetrainConstants.DrivetrainMotors.KI;
                public static final double KD = Constants.DrivetrainConstants.DrivetrainMotors.KD;
                public static final double KF = Constants.DrivetrainConstants.DrivetrainMotors.KF;

            }

            public static final class RightFollower {
                public static final int CAN_ID = 1;
                public static final double PEAK_OUTPUT_FORWARD = Constants.DrivetrainConstants.DrivetrainParameters.MAX_OUTPUT;
                public static final double PEAK_OUTPUT_REVERSE = -Constants.DrivetrainConstants.DrivetrainParameters.MAX_OUTPUT;
                public static final NeutralMode NEUTRAL_MODE = Constants.DrivetrainConstants.DrivetrainParameters.NEUTRAL_MODE;
                public static final InvertType INVERTED = InvertType.FollowMaster; //boolean INVERTED = true;//TODO CHANGE BACK
                public static final boolean SENSOR_PHASE = false;//TODO CHANGE BACK
                public static final double KP = Constants.DrivetrainConstants.DrivetrainMotors.KP;
                public static final double KI = Constants.DrivetrainConstants.DrivetrainMotors.KI;
                public static final double KD = Constants.DrivetrainConstants.DrivetrainMotors.KD;
                public static final double KF = Constants.DrivetrainConstants.DrivetrainMotors.KF;

            }
        }
    }

    public static final class TurretConstants {
        public static final class TurretMotionParameters {
            public static final double PERCENT_OUTPUT_FORWARD = 0.5;
            public static final double TICKS_PER_DEGREE =   TurretMotors.TurretMotor.ENCODER_TICKS_PER_MOTOR_REVOLUTION *
                                                            TurretMotors.TurretMotor.GEARING_RATIO / 360;
        }

        public static final class TurretSensors {
            public static final class FowardSensor {
                public static final int ID = 4;
            }
            public static final class ReverseSensor {
                public static final int ID = 5;
            }
        }
        public static final class TurretMotors {
            public static final class TurretMotor {
                public static final int CAN_ID = 4;

                public static final boolean INVERT = false;
                public static final int FEEDBACK_PORT = 0;
                public static final boolean SENSOR_PHASE = false;
                public static final int ENCODER_TICKS_PER_MOTOR_REVOLUTION = EncoderConversionFactors.CONVERT_ANGLE_TO_TALON_FX_ENCODER_TICKS(360);
                public static final double GEARING_RATIO = 1/1;

                public static final int TIMEOUT = 10;

                public static final boolean ENABLE_CURRENT_LIMIT = true;
                public static final int CURRENT_LIMIT = 25;
                public static final double OPEN_LOOP_RAMP = 0.1;
                public static final double PEAK_OUTPUT_FORWARD = .5;
                public static final double PEAK_OUTPUT_REVERSE = -.5;

                public static final double NOMINAL_OUTPUT_FORWARD = 0;
                public static final double NOMINAL_OUTPUT_REVERSE = 0;
            }
        }
    }

    public static final class IndexerConstants {
        public static final class IndexerSensors {
            public static final class FrontSensor {
                public static final int ID = 0;
            }

            public static final class ShiftSensor{
                public static final int ID = 2;
            }

            public static final class RearSensor {
                public static final int ID = 3;
            }
        }

        public static final class IndexerMotionParameters {
            public static final double STAGE_ONE_PERCENT_OUTPUT_FORWARD = 0.5;
            public static final double STAGE_TWO_PERCENT_OUTPUT_FORWARD = 0.5;

            public static final double STAGE_ONE_PERCENT_OUTPUT_BACKWARD = -0.5;
            public static final double STAGE_TWO_PERCENT_OUTPUT_BACKWARD = -0.5;
        }

        public static final class IndexerMotors {
            public static final class IndexerStageOne {
                public static final int CAN_ID = 8;

                public static final boolean INVERT = false;
                public static final int FEEDBACK_PORT = 0;
                public static final boolean SENSOR_PHASE = false;

                public static final int TIMEOUT = 10;

                public static final boolean ENABLE_CURRENT_LIMIT = true;
                public static final int CURRENT_LIMIT = 25;
                public static final double OPEN_LOOP_RAMP = 0;
                public static final double PEAK_OUTPUT_FORWARD = .5;
                public static final double PEAK_OUTPUT_REVERSE = -.5;

                public static final double NOMINAL_OUTPUT_FORWARD = 0;
                public static final double NOMINAL_OUTPUT_REVERSE = 0;
            }

            public static final class IndexerStageTwo {
                public static final int CAN_ID = 7;
              
                public static final boolean INVERT = true;
                public static final int FEEDBACK_PORT = 0;
                public static final boolean SENSOR_PHASE = true;

                public static final int TIMEOUT = 10;

                public static final boolean ENABLE_CURRENT_LIMIT = true;
                public static final int CURRENT_LIMIT = 25;
                public static final double OPEN_LOOP_RAMP = 0;
                public static final double PEAK_OUTPUT_FORWARD = .5;
                public static final double PEAK_OUTPUT_REVERSE = -.5;

                public static final double NOMINAL_OUTPUT_FORWARD = 0;
                public static final double NOMINAL_OUTPUT_REVERSE = 0;
            }
        }
    }

    public static final class IntakeConstants {
        public static final class IntakeMotionParameters {
            public static final double INTAKE_PERCENT_OUTPUT = 0.5;
            public static final double INTAKE_ZERO = 0;

            public static final int ZEROED_ENCODER_TICKS = 65;

            //public static final double INTAKE_DOWN_DEGREES = EncoderConversionFactors
                   // .CONVERT_ANGLE_TO_MA3_ENCODER_TICKS(-40);  //Ultimate down = 22ticks @ ~-15deg
            //public static final double INTAKE_UP_DEGREES = EncoderConversionFactors
                   // .CONVERT_ANGLE_TO_MA3_ENCODER_TICKS(90);

                   public static final double INTAKE_DOWN_TICKS = 288;
                   public static final double INTAKE_UP_TICKS = 520;
                   public static final double INTAKE_INTAKE_TICKS = 325;
            public static final int ACCEPTABLE_ERROR_TICKS = 10;

            public static final double KP = 6; //6
            public static final double KI = 0;
            public static final double KD = 3; //3
            public static final double KF = 0;
        }

        public static final class IntakeMotors {
            public static final class IntakeSpin {
                public static final int CAN_ID = 9;

                public static final boolean INVERT = true;
                public static final int FEEDBACK_PORT = 0;
                public static final boolean SENSOR_PHASE = false;

                public static final int TIMEOUT = 10;

                public static final boolean ENABLE_CURRENT_LIMIT = true;
                public static final int CURRENT_LIMIT = 25;
                public static final double OPEN_LOOP_RAMP = 0.1;
                public static final double PEAK_OUTPUT_FORWARD = .5;
                public static final double PEAK_OUTPUT_REVERSE = -.5;

                public static final double NOMINAL_OUTPUT_FORWARD = 0;
                public static final double NOMINAL_OUTPUT_REVERSE = 0;
            }

            public static final class IntakePivot {
                public static final int CAN_ID = 10;

                public static final InvertType INVERT = InvertType.InvertMotorOutput;
                public static final int FEEDBACK_PORT = 0;
                public static final boolean SENSOR_PHASE = true;

                public static final int TIMEOUT = 10;

                public static final boolean ENABLE_CURRENT_LIMIT = true;
                public static final int CURRENT_LIMIT = 25;
                public static final double OPEN_LOOP_RAMP = 0.1;
                public static final double PEAK_OUTPUT_FORWARD = .5;
                public static final double PEAK_OUTPUT_REVERSE = -.5;

                public static final double NOMINAL_OUTPUT_FORWARD = 0;
                public static final double NOMINAL_OUTPUT_REVERSE = 0;
            }
        }
    }

    public static final class ShooterConstants {
        public static final class ShooterMotionParameters {
            public static final double RECOVER_PO = ShooterMotionParameters.SHOOT_PO;
            public static final double SHOOT_PO = 0.30;
            public static final double STOP_PO = 0;

        }

        public static final class ShooterSensors {
        }
        public static final class ShooterMotors {
            public static final class ShooterMaster {
                public static final int CAN_ID = 2;

                public static final InvertType INVERT = InvertType.None;
                public static final int FEEDBACK_PORT = 0;
                public static final boolean SENSOR_PHASE = false;

                public static final int TIMEOUT = 10;

                public static final boolean ENABLE_CURRENT_LIMIT = true;
                public static final int CURRENT_LIMIT = 25;
                public static final double OPEN_LOOP_RAMP = 0.1;
                public static final double PEAK_OUTPUT_FORWARD = 1;
                public static final double PEAK_OUTPUT_REVERSE = -1;

                public static final double NOMINAL_OUTPUT_FORWARD = 0;
                public static final double NOMINAL_OUTPUT_REVERSE = 0;
            }

            public static final class ShooterFollower {
                public static final int CAN_ID = 13;

                public static final InvertType INVERT = InvertType.InvertMotorOutput;
                public static final int FEEDBACK_PORT = 0;
                public static final boolean SENSOR_PHASE = false;

                public static final int TIMEOUT = 10;

                public static final boolean ENABLE_CURRENT_LIMIT = true;
                public static final int CURRENT_LIMIT = 25;
                public static final double OPEN_LOOP_RAMP = 0.1;
                public static final double PEAK_OUTPUT_FORWARD = 1;
                public static final double PEAK_OUTPUT_REVERSE = -1;

                public static final double NOMINAL_OUTPUT_FORWARD = 0;
                public static final double NOMINAL_OUTPUT_REVERSE = 0;
            }
        }
    }
    public static final class ControlPanelSpinnerConstants {
        public static final class ControlPanelSpinnerMotors {
            public static final int CAN_ID = 11;

            public static final boolean INVERT = false;
            public static final int FEEDBACK_PORT = 0;
            public static final boolean SENSOR_PHASE = false;

            public static final int TIMEOUT = 10;

            public static final boolean ENABLE_CURRENT_LIMIT = true;
            public static final int CURRENT_LIMIT = 25;
            public static final double OPEN_LOOP_RAMP = 0.1;
            public static final double PEAK_OUTPUT_FORWARD = .75;
            public static final double PEAK_OUTPUT_REVERSE = -.75;

            public static final double NOMINAL_OUTPUT_FORWARD = 0;
            public static final double NOMINAL_OUTPUT_REVERSE = 0;

            public static final double SPIN_SPEED = 0.6;
            public static final double RISE_SPEED = 0.7;
            public static final double LOWER_SPEED = -0.7;
        }
        public static final class ControlPanelSpinnerColors {
            public static final double RGB_RED_VALUE_FOR_YELLOW =0.301;
            public static final double RGB_BLUE_VALUE_FOR_YELLOW =0.148;
            public static final double RGB_GREEN_VALUE_FOR_YELLOW =0.550;
            public static final double RGB_RED_VALUE_FOR_BLUE =0.196;
            public static final double RGB_BLUE_VALUE_FOR_BLUE =0.311;
            public static final double RGB_GREEN_VALUE_FOR_BLUE =0.491;
            public static final double RGB_RED_VALUE_FOR_RED =0.483;
            public static final double RGB_BLUE_VALUE_FOR_RED =0.148;
            public static final double RGB_GREEN_VALUE_FOR_RED =0.371;
            public static final double RGB_RED_VALUE_FOR_GREEN =0.197;
            public static final double RGB_BLUE_VALUE_FOR_GREEN =0.240;
            public static final double RGB_GREEN_VALUE_FOR_GREEN =0.561;
        }
    }
    public static final class DriverCameraConstants {
        public static final class CameraTiltServo {
            public static final int PWM_ID_SERVO = 2;
            public static final double SETPOINT_ONE = 20;
            public static final double SETPOINT_TWO = 40;
        }
    }
}
