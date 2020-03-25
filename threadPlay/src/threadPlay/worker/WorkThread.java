package threadPlay.worker;

import threadPlay.util.IsPrime;
import threadPlay.util.FileProcessor;
import threadPlay.result.ResultProcessor;

public class WorkThread implements Runnable{

	IsPrime prime;
	FileProcessor file;
	ResultProcessorI result=new ResultProcessor();

public WorkThread(FileProcessor fp,IsPrime primeObject, ResultProcessor resultObject)
{
	prime=primeObject;
	file=fp;
	result=resultObject;
}	
public void run(){

	int num;

    //call poll()

	String inputString=file.poll();

    //call isPrime();

    while(inputString!=null)
    {
    	num = prime.primeCheck(inputString);
        
        if(num!=0)
            result.addToResultList(num);

    	inputString=file.poll();  	

    }
    //call Results
    }
}
