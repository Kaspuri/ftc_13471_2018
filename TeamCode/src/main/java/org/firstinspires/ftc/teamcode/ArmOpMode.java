package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;


//This program is for moving the arm using encoders
@TeleOp (name = "EncoderOpMode")
public class ArmOpMode extends LinearOpMode
{
    DcMotor ArmMotor = null;
    DcMotor ElbowMotor = null;

    @Override
    public void runOpMode()  {
        ArmMotor = hardwareMap.dcMotor.get("armmotor");
        ElbowMotor = hardwareMap.dcMotor.get("elbowmotor");

       // ArmMotor.setMode(DcMotorController.RunMode.RUN_USING_MOTORS);

        waitForStart();


    }
}