// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import com.ctre.phoenix6.motorcontrol.VictorSPXControlMode;
//import com.ctre.phoenix6.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Climb() {}

  //private final VictorSP climb = new VictorSP(11);//idk which id to use
  private final VictorSP climb = new VictorSP(7);
  private final DigitalInput climbRetractLimiter = new DigitalInput(3);
  private final DigitalInput climbExtendLimiter = new DigitalInput(4);

public Command Extend() {
    return runOnce(() -> climb.set(1))
    .withName("Extend");
  }

  public Command Retract() {
    return runOnce(() -> climb.set(-1))
    .withName("Retract");
  }

  public Command StopClimb() {
    return runOnce(() -> climb.set(0))
    .withName("Stop Climb");
  }

  public boolean getClimbRetractLimiter(){
    return climbRetractLimiter.get();
  }

  public boolean getClimbExtendLimiter(){
    return climbExtendLimiter.get();
  }

  public Command moveClimbCommand(int speed){
    return run(() -> climb.set(speed))
    .withName("Move Climb");
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putData("Raise Climb", Extend());
    SmartDashboard.putData("Lower Climb", Retract());
    SmartDashboard.putData("Stop Climb", StopClimb());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
