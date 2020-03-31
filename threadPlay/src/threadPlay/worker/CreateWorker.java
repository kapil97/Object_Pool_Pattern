package threadPlay.worker;
import threadPlay.result.ResultProcessorI;
import threadPlay.util.FileProcessor;
import threadPlay.util.IsPrimeI;

import java.util.ArrayList;
import java.util.List;

/**
 * Create Worker Class to Start and Join threads
 */
public class CreateWorker implements CreateWorkerI {
    FileProcessor fileProcessor;
    ResultProcessorI results;
    IsPrimeI isPrime;
    List<Thread> threadList=new ArrayList<>();
    public CreateWorker(FileProcessor fpObjectIn, ResultProcessorI resultsObjIn, IsPrimeI primeObjectIn){
    fileProcessor=fpObjectIn;
    results=resultsObjIn;
    isPrime=primeObjectIn;
    }

    /**
     * To start WorkerThread, start the number of threads and join them
     * @param numThreads
     */
    @Override
    public void startWorkers(int numThreads){
        try {
            WorkerThreadI workThreadI = new WorkThread(fileProcessor, isPrime, results);
            threadList = workThreadI.borrowThreads(numThreads);
            for (Thread thread : threadList) {
                thread.start();
            }

            for (Thread thread : threadList) {
                thread.join();
            }
            results.addToResultList("STOP");
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
