package org.usfirst.frc.team2990.joshcontroller;
import edu.wpi.first.wpilibj.Talon;

public class JoshMotorControllor {
	 
	public Talon talon;
	public float accelValue;
	public float target;
	
	public JoshMotorControllor(int motorpwm, float AcelerationMax)
	{
		talon = new Talon(motorpwm);
		accelValue = AcelerationMax;
		
	}
		
	public void UpdateMotor()
	{
		double curr = talon.get();
		float newValue = Lerp((float)curr,target,accelValue);
		
		if (newValue < 0.001) 
		{
			newValue = 0;
		}
		
		talon.set(newValue);
	}
	
	public float Lerp(float v0, float v1, float t)
	{
		return (v0 + t*(v1-v0));
	}
}