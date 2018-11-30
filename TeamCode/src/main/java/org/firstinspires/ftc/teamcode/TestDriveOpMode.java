package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp (name = "TestDriveOpMode")

public class TestDriveOpMode extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    DcMotor leftmotor;
    DcMotor rightmotor;


    @Override
    public void runOpMode() throws InterruptedException{
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();

        double tgtLeftMotorPower = 0.5;
        double tgtRightMotorPower = 0.5;

        double tgtleftStickY = 0;
        double tgtleftStickX = 0;

        while (opModeIsActive()) {


            tgtleftStickY = -this.gamepad1.left_stick_y;
            tgtleftStickX = this.gamepad1.left_stick_x;


            tgtLeftMotorPower = (tgtleftStickY - tgtleftStickX);
            tgtRightMotorPower = -(tgtleftStickY + tgtleftStickX);


            leftmotor.setPower(tgtLeftMotorPower);
            rightmotor.setPower(tgtRightMotorPower);

            
            telemetry.addData("Left Motor Power", leftmotor.getPower());
            telemetry.addData("Right Motor Power", rightmotor.getPower());
            //telemetry.addData("CRS1 Power", crservo1.getPower());
            //telemetry.addData("CRS2 Power", crservo2.getPower());
            //telemetry.addData("Arm Motor Power", botArmMotor.getPower());
            //telemetry.addData("Elbow Motor Power", topArmMotor.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }

    }
}
