package testCalcAngle;

import java.util.Scanner;

enum Direction{Left, Right}

public class calcAngle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myScan = new Scanner(System.in);
		calcAngle myTest = new calcAngle();
		
		System.out.println("What's the start angle?");
		double ref = myScan.nextDouble();
		System.out.println("What's the targeted turn angle?");
		double angleToTurn = myScan.nextDouble();
		System.out.println("Turn direction is to the right? (0/1)");
		Direction turnDirection = myScan.nextInt() == 1? Direction.Right:Direction.Left;
		System.out.println(turnDirection);
		double actualAngleToTurn = myTest.calcAngleToTurn(ref, angleToTurn, turnDirection);
		System.out.format("Actual angle to turn %f", actualAngleToTurn);
		
		myScan.close();
	}
	
	private double calcAngleToTurn(double ref, double angleToRef, Direction turnDirection){
		Scanner myScan = new Scanner(System.in);
		double angle;
		System.out.println("what's the current angle reading?");
        double current = myScan.nextDouble();
        double delta = getError(ref,current);

        if (turnDirection == Direction.Right)
            angle= angleToRef-delta;
        else
            angle= angleToRef+delta;

        if (angle > 180)  angle -= 360;
        if (angle <= -180) angle += 360;

        myScan.close();
        //ToDo: if angle<0, meaning current position already passed the target position, need to reverse the turn direction.
        return (angle);
    }

    private double getError(double refAngle, double currentAngle) {

        // calculate error in -179 to +180 range, - indicate current to the left of ref. + indicate current to the right of ref
        double robotError = refAngle - currentAngle;
        if (robotError > 180)  robotError -= 360;
        if (robotError <= -180) robotError += 360;
        return robotError;
    }

}
