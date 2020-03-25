package threadPlay.result;

import java.util.ArrayList;
import java.util.List;

public class ResultProcessor implements ResultProcessorI{
    int capacity;
    int count=0;
   public ResultProcessor(int capacityIn){
        capacity=capacityIn;
    }
    List<Integer> resultList=new ArrayList<>(capacity);
    @Override
    public void addToResultList(int value){
    if(count<capacity){
        resultList.add(value);
        count++;
    }
    else{
        //wait signal to be sent
    }
    }

}
