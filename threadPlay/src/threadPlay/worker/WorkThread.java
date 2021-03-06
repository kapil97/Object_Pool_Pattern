package threadPlay.worker;
import threadPlay.result.ResultProcessorI;
import threadPlay.util.FileProcessor;
import threadPlay.util.IsPrimeI;
import java.io.IOException;
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

	/**
	 * Function to borrow from thread pool
	 * @param numThreads
	 * @return threadList
	 */
	public List<Thread> borrowThreads(int numThreads){
	pool=new ArrayList<>(numThreads);
	for (int i=0;i<numThreads;i++) {
		Thread thread = new Thread(new WorkThread(fileProcessor,prime,result));
		pool.add(thread);
	}
	return pool;
}
	/**
	 * run method of the thread
	 */
	public void run(){
		try{
			String input=fileProcessor.poll();
			while(input!=null) {
				boolean primeFlag=prime.primeCheck(input);
				if(primeFlag)
				result.addToResultList(input);
				input=fileProcessor.poll();
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
