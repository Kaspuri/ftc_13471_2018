/*
Copyright 2017 FIRST Tech Challenge Team 13471

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */
@TeleOp (name = "MainOpMode")

public class MainOpMode extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    DcMotor leftmotor;
    DcMotor rightmotor;

    DcMotor botArmMotor;
    //DcMotor topArmMotor;

    CRServo crservo1;
    CRServo crservo2;


    @Override
    public void runOpMode() throws InterruptedException{
        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");

        botArmMotor = hardwareMap.dcMotor.get("armmotor");
        //topArmMotor = hardwareMap.dcMotor.get("elbowmotor");

        crservo1 = hardwareMap.crservo.get("crservo1");
        crservo2 = hardwareMap.crservo.get("crservo2");
        //
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        crservo1.setDirection(DcMotorSimple.Direction.FORWARD);
        crservo2.setDirection(DcMotorSimple.Direction.FORWARD);
        // Wait for the g

        // run until the end of the match (driver presses STOP)


        waitForStart();

        double tgtLeftMotorPower = 0.5;
        double tgtRightMotorPower = 0.5;

        double tgtleftStickY = 0;
        double tgtleftStickX = 0;


        double tgtBotMotorPower = 0.5;
        //double tgtTopMotorPower = 0.5;

        double tgtleftStickY2 = 0;
       // double tgtrightStickY2 = 0;

        while (opModeIsActive()) {

            //---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---

            //Driving the Robot

            tgtleftStickY = -this.gamepad1.left_stick_y;
            tgtleftStickX = this.gamepad1.left_stick_x;


            tgtLeftMotorPower = (tgtleftStickY - tgtleftStickX);
            tgtRightMotorPower = -(tgtleftStickY + tgtleftStickX);


            leftmotor.setPower(tgtLeftMotorPower);
            rightmotor.setPower(tgtRightMotorPower);

            //---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---

            //control the sweeper

            //move stuff inwards
            if(gamepad2.x) {
                crservo1.setPower(1);
                crservo2.setPower(-1);

            //move stuff outwards
            }else if(gamepad2.b){
                crservo1.setPower(-1);
                crservo2.setPower(1);

            //stop the sweeper
            } else if(gamepad2.a) {
                crservo1.setPower(0);
                crservo2.setPower(0);
            }

            //---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---
            //move the arm

            tgtleftStickY2 = this.gamepad2.left_stick_y  ;
            //tgtrightStickY2 = this.gamepad2.right_stick_y;


            tgtBotMotorPower = (tgtleftStickY2);
            //tgtTopMotorPower = (tgtrightStickY2);


            botArmMotor.setPower(tgtBotMotorPower/1.5);
            //topArmMotor.setPower(tgtTopMotorPower/3);

            //---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---=---

            //telemetry

            telemetry.addData("Left Motor Power", leftmotor.getPower());
            telemetry.addData("Right Motor Power", rightmotor.getPower());
            telemetry.addData("CRS1 Power", crservo1.getPower());
            telemetry.addData("CRS2 Power", crservo2.getPower());
            telemetry.addData("Arm Motor Power", botArmMotor.getPower());
            //telemetry.addData("Elbow Motor Power", topArmMotor.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }

    }
}
