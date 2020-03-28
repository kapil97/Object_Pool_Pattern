package threadPlay.worker;

import java.util.List;

public interface WorkerThreadI {
    List<Thread> borrowThreads(int numThreads);
}
