/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}

		double xA = (2.0 * x1 + x2) / 3.0;
		double yA = (2.0 * y1 + y2) / 3.0;

		double xB = (x1 + 2.0 * x2) / 3.0;
		double yB = (y1 + 2.0 * y2) / 3.0;

		double xP = (Math.sqrt(3.0) / 6.0) * (yA - yB) + 0.5 * (xA + xB);
		double yP = (Math.sqrt(3.0) / 6.0) * (xB - xA) + 0.5 * (yA + yB);

		curve(n - 1, x1, y1, xA, yA);
		curve(n - 1, xA, yA, xP, yP);
		curve(n - 1, xP, yP, xB, yB);
		curve(n - 1, xB, yB, x2, y2);
	}

    
	public static void snowFlake(int n) {
		
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		

		double x1 = 0.0, y1 = 0.0;
		double x2 = 1.0, y2 = 0.0;
		double x3 = 0.5, y3 = Math.sqrt(3.0) / 2.0;

		curve(n, x1, y1, x2, y2);
		curve(n, x2, y2, x3, y3);
		curve(n, x3, y3, x1, y1);
	}
}