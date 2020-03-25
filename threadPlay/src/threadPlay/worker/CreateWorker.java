package threadPlay.worker;

import threadPlay.result.ResultProcessor;
import threadPlay.result.ResultProcessorI;
import threadPlay.util.FileProcessor;
import threadPlay.util.IsPrimeI;

public class CreateWorker implements CreateWorkerI {
    FileProcessor fileProcessor;
    ResultProcessorI results;
    IsPrimeI isPrime;

    public CreateWorker(FileProcessor fpObjectIn, ResultProcessorI resultsObjIn, IsPrimeI primeObjectIn){
    fileProcessor=fpObjectIn;
    results=resultsObjIn;
    isPrime=primeObjectIn;
    }
    @Override
    public void startWorkers(int numThreads){

    }
}
