package threadPlay.worker;

import threadPlay.result.ResultProcessorI;
import threadPlay.util.IsPrime;
import threadPlay.util.FileProcessor;
import threadPlay.result.ResultProcessor;
import threadPlay.util.IsPrimeI;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;

public class WorkThread implements Runnable, WorkerThreadI {

	IsPrimeI prime;
	FileProcessor fileProcessor;
	ResultProcessorI result;
public WorkThread(FileProcessor fp, IsPrimeI primeObject, ResultProcessorI resultObject)
{
	prime=primeObject;
	fileProcessor=fp;
	result=resultObject;
}
	static List <Thread> pool;

public List<Thread> borrowThreads(int numThreads){
	pool=new ArrayList<>(numThreads);
	for (int i=0;i<numThreads;i++) {
		Thread thread = new Thread(new WorkThread(fileProcessor,prime,result));
		pool.add(thread);
	}
	return pool;
}
public void run(){
 	boolean primeFlag;
	try {
		String inputString = fileProcessor.poll();
		System.out.println("Current string processing:"+inputString);
		if(inputString!=null) {
			primeFlag = prime.primeCheck(inputString);
			if (primeFlag)
				result.addToResultList(Integer.parseInt(inputString));
			while (inputString != null) {
				inputString = fileProcessor.poll();
				System.out.println("Current string processing:"+inputString);
				if(inputString!=null) {
					primeFlag = prime.primeCheck(inputString);
					if (primeFlag)
						result.addToResultList(Integer.parseInt(inputString));
				}
				inputString = fileProcessor.poll();
			}
			if(inputString!=null) {
				System.out.println("Current string processing:"+inputString);
				primeFlag = prime.primeCheck(inputString);
				if (primeFlag)
					result.addToResultList(Integer.parseInt(inputString));
			}
			fileProcessor.close();
		}
	} catch (InvalidPathException e) {
		System.out.println("Invalid File Path");
	} catch (IOException | SecurityException e) {
		System.out.println("File Cannot be read");
	} finally {
		System.out.println("All File Operations are Closed");
	}

	}


}
