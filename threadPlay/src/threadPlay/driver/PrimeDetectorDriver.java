package threadPlay.driver;
import javax.print.attribute.standard.NumberUp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

/**
 * @author Kamleshwar Ragava
 *
 */

public class PrimeDetectorDriver {
	/**
	 * Main Method
	 * Command line validation happens here
	 * takes input as command line arguments
	 * @param args
	 */
	public static void main(String[] args) {

		final int REQUIRED_NUMBER_OF_ARGS = 6;
		if ((args.length != REQUIRED_NUMBER_OF_ARGS) || 
				(args[0].equals("${inputNumStream}")) || 
				(args[1].equals("${numThreads}")) ||
				(args[2].equals("${capacity}")) ||
				(args[3].equals("${persisterServiceIP}")) ||
				(args[4].equals("${persisterServicePort}")) ||
				(args[5].equals("${debugValue}"))) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_ARGS);
			System.exit(0);
		}
		System.out.println("Testing Ant File");
	}
	@Override
	public String toString(){
		String returnValue="Prime Detector Class";
		return returnValue;
	}
}
