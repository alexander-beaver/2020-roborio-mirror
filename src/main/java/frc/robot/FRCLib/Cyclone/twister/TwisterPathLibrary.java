package frc.robot.FRCLib.Cyclone.twister;

/**
 * This file contains the paths that are commonly used in a TwisterController
 */
public class TwisterPathLibrary {

    public static TwisterPath straightTwoMeters = new TwisterPath("Test Straight", new TwisterPoint[]{new TwisterPoint(2,.5,0)}); 
    public static TwisterPath straightFourMeters = new TwisterPath("Straight 4m", new TwisterPoint[]{new TwisterPoint(0,0), new TwisterPoint(4,0)});
    public static TwisterPath sCurve = new TwisterPath("S Curve", new TwisterPoint[]{new TwisterPoint(2,-1), new TwisterPoint(4, -2), new TwisterPoint(6,0)});
    public static TwisterPath crossField = new TwisterPath("Cross Field", new TwisterPoint[]{new TwisterPoint(-1, -.5)});
    public static TwisterPath reverse = new TwisterPath("Reverse", new TwisterPoint[]{new TwisterPoint(-2, -2), new TwisterPoint(-3, -2)});
}