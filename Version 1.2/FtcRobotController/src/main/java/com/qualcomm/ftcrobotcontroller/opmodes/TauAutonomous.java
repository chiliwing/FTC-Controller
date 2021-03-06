package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.Range;


/**
 * Created by Pbergen on 9/28/2015.
 */
public class TauAutonomous extends OpMode
{
    DcMotor motorRight1;
    DcMotor motorRight2;
    DcMotor motorLeft1;
    DcMotor motorLeft2;
    Servo servo1;
    UltrasonicSensor DistanceSensor;

    double s1position;


    public TauAutonomous()
    {
        s1position = 0.0d;
    }

    public void sleep(long millis)
    {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init()
    {
        motorRight1 = hardwareMap.dcMotor.get("Left1");
        motorRight2 = hardwareMap.dcMotor.get("Left2");
        motorLeft1 = hardwareMap.dcMotor.get("Right1");
        motorLeft2 = hardwareMap.dcMotor.get("Right2");
        DistanceSensor = hardwareMap.ultrasonicSensor.get("Distance");
        motorRight1.setDirection(DcMotor.Direction.REVERSE);
        motorRight2.setDirection(DcMotor.Direction.REVERSE);

        servo1 = hardwareMap.servo.get("servo");
    }

    @Override
    public void loop()
    {
        motorRight1.setPower(0);
        motorRight2.setPower(0);
        motorLeft1.setPower(0);
        motorLeft2.setPower(0);

        sleep(1000); // sleeps for one second

        motorRight1.setPower(1);
        motorRight2.setPower(1);
        motorLeft1.setPower(1);
        motorLeft2.setPower(1);

        sleep(1000);

        motorRight1.setPower(1);
        motorRight2.setPower(1);
        motorLeft1.setPower(0);
        motorLeft2.setPower(0);

        sleep(1000);

        motorRight1.setPower(0);
        motorRight2.setPower(0);
        motorLeft1.setPower(1);
        motorLeft2.setPower(1);

        sleep(1000);

        telemetry.addData("Text", "*** Robot Data***");
        //telemetry.addData("DS","DS"+ String.format("%.2f", DistanceSensor));
        telemetry.addData("DS",  "DS: " + DistanceSensor.getUltrasonicLevel());
        telemetry.addData("Servo",  "Servo: " + servo1.getPosition());


    }

    @Override
    public void stop()
    {
    }
}