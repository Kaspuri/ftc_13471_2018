package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp (name = "EncoderOpMode")
public class EncoderOpMode extends LinearOpMode{
    DcMotor ArmMotor = null;
    @Override
    public void runOpMode() throws InterruptedException {
        ArmMotor = hardwareMap.dcMotor.get("armmotor");
        ArmMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        ArmMotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        waitForStart();
        float tgtleftStickY = 0;
        while (opModeIsActive()) {
            tgtleftStickY = -this.gamepad1.left_stick_y;
            int tgtlftstck = (int) ((int) 1800.0*tgtleftStickY);
            ArmMotor.setTargetPosition(tgtlftstck);
        }
    }
}
