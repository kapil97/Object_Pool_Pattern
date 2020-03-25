package threadPlay.driver;
import threadPlay.result.ResultProcessor;
import threadPlay.result.ResultProcessorI;
import threadPlay.util.FileProcessor;
import threadPlay.util.IsPrime;
import threadPlay.util.IsPrimeI;
import threadPlay.worker.CreateWorker;
import threadPlay.worker.CreateWorkerI;

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
	public static void main(String[] args){

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
		try {
			FileProcessor fileProcessor=new FileProcessor(args[0]);
			ResultProcessorI results=new ResultProcessor(Integer.parseInt(args[2]));
			IsPrimeI isPrime=new IsPrime();
			CreateWorkerI createWorker=new CreateWorker(fileProcessor,results,isPrime);
			createWorker.startWorkers(Integer.parseInt(args[1]));
		}
		catch (IOException e){
			e.printStackTrace();
		}




	}
	@Override
	public String toString(){
		String returnValue="Prime Detector Class";
		return returnValue;
	}
}
