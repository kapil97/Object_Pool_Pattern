package threadPlay.driver;
import threadPlay.result.ResultProcessor;
import threadPlay.result.ResultProcessorI;
import threadPlay.util.*;
import threadPlay.worker.CreateWorker;
import threadPlay.worker.CreateWorkerI;
import java.io.IOException;

/**
 * @author Kamleshwar Ragava
 * @author Jithin Jose
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
		ValidatorI validator=new Validator(args[0],args[1],args[2],args[3],args[4]);
		if(validator.validPrimeDetector()) {
			try {
				FileProcessor fileProcessor = new FileProcessor(args[0]);
				ResultProcessorI results = new ResultProcessor(Integer.parseInt(args[2]));
				results.setIp(args[3]);
				results.setPort(Integer.parseInt(args[4]));
				results.startClient();

				IsPrimeI isPrime = new IsPrime();
				CreateWorkerI createWorker = new CreateWorker(fileProcessor, results, isPrime);
				createWorker.startWorkers(Integer.parseInt(args[1]));
				results.printList();
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			System.exit(0);
		}
	}
	@Override
	public String toString(){
		String returnValue="Prime Detector Class";
		return returnValue;
	}
}
