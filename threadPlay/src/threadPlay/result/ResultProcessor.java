package threadPlay.result;
import java.util.ArrayList;
import java.util.List;

public class ResultProcessor implements ResultProcessorI{
     static int capacity;
   public ResultProcessor(int capacityIn){
        capacity=capacityIn;
    }
    final List<Integer> resultList=new ArrayList<>(capacity);
    @Override
    public synchronized void addToResultList(int value) {
        synchronized (resultList)
        {
            while (resultList.size() == capacity)
            {
                System.out.println("List is full, Thread "+Thread.currentThread()+" Capacity: " + resultList.size());
                try {
                    resultList.wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            resultList.add(value);
            resultList.notifyAll();
        }
    }
    @Override
    public synchronized void readDataFromList(){
        // Write socket code here
    }

    @Override
    public void printList(){
        System.out.println("capacity is "+capacity);
        System.out.println("printing "+resultList);
    }
}
