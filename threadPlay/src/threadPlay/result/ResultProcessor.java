package threadPlay.result;

import java.util.ArrayList;
import java.util.List;

public class ResultProcessor implements ResultProcessorI{
     static int capacity;
    int count=0;
   public ResultProcessor(int capacityIn){
        capacity=capacityIn;
    }
     static  List<Integer> resultList=new ArrayList<>(capacity);
    @Override
    public synchronized void addToResultList(int value){
        System.out.println(resultList);
    if(count<capacity){
        resultList.add(value);
        count++;
        System.out.println("count: "+count);
    }
    else
        System.out.println("Capacity Exceeding"+count+" Max capacity is"+capacity);
    }
    @Override
    public void printList(){
        System.out.println("capacity is "+capacity);
        System.out.println("printing "+resultList);
    }
}
