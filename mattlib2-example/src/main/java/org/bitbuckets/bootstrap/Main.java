package org.bitbuckets.bootstrap;

import edu.wpi.first.wpilibj.RobotBase;

public class Main {

    public static void main(String[] args) {
        RobotBase.startRobot(MyRobot::new);
    }

}
