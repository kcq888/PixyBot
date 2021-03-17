// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PixySubsystem;

public class PixyVisionStartCommand extends CommandBase {
  private PixySubsystem _pixySubsystem;;
  /** Creates a new PixyCommand. */
  public PixyVisionStartCommand(PixySubsystem pixySubsystem) {
    _pixySubsystem = pixySubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(_pixySubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    _pixySubsystem.resetVisionEnd();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    String pixyVersion = _pixySubsystem.getVersion();
    SmartDashboard.putString("Pixy Version", pixyVersion);
    _pixySubsystem.getTargetDistance();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (_pixySubsystem.getVisionEnd());
  }
}
