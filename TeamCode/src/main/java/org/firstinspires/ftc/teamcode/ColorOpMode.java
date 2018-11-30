package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is an Autonomous Op Mode for using the color sensor to whacc the gold for Sampling
 * **/

@Autonomous(name = "SamplingOpMode")

public class ColorOpMode extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode()throws InterruptedException{

        ColorSensor color_sensor;
        //DcMotor
        //color_sensor = hardwareMap.color.get("color");

        //int color = color_sensor.alpha();
        //if(color <= /***/){


    }

}
