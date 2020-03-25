package threadPlay.worker;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

    int capacity;
    ThreadPool(int capacityIn){
        capacity=capacityIn;
    }

    List<Thread> pool =new ArrayList<>(capacity);

    void createThreadPool(){
        for(int i=0;i<capacity;i++){
            Thread thread=new Thread(new WorkThread());
            pool.add(thread);
        }
    }
}
