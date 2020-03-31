package threadPlay.result;
import java.util.ArrayList;
import java.util.List;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Result Processing Class
 */
public class ResultProcessor implements ResultProcessorI{
     static int capacity;
     static String persisterIp;
     static int persisterPort;
     Socket clientSocket;
     DataOutputStream data;

    public ResultProcessor(int capacityIn){
        capacity=capacityIn;
        
    }
    /**
     *
     * ip Address setter
     * @param ip
     */
    @Override
    public void setIp(String ip){
        persisterIp=ip;
    }

    /**
     * port setter
     * @param port
     */
    @Override
    public void setPort(int port){
        persisterPort=port;
    }

    /**
     * Start Client
     */
    @Override
    public void startClient()
    {
        try
        {
            clientSocket = new Socket(persisterIp,persisterPort);
            data = new DataOutputStream(clientSocket.getOutputStream());
        }catch(Exception e)
        {   System.out.println("Server is not active");
            e.printStackTrace();
        }

    }

    final List<String> resultList=new ArrayList<>(capacity);

    /**
     * Add to Result List by acquiring Locks
     * @param value
     */
    @Override
    public synchronized void addToResultList(String value) {
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
            readDataFromList();
        }
    }

    /**
     * Read from Result List by acquiring Locks
     */
    @Override
    public synchronized void readDataFromList(){ 
        try
        {
            synchronized(resultList)
            {
                while(resultList.isEmpty())
                {
                    System.out.println("List is empty, Thread "+Thread.currentThread()+" Capacity: " + resultList.size());
                    try {
                        resultList.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String num = resultList.remove(0);
                data.writeUTF(num);
                data.flush();            
                if(num.equals("STOP"))
                {
                    data.close();
                    clientSocket.close();
                }
                resultList.notifyAll();
            }
        }
        catch(Exception e)
        {   System.out.println("Connection Error...");
            e.printStackTrace();
        }
    }

    /**
     * To print the contents of the resultList and its capacity
     */
    @Override
    public void printList(){
        System.out.println("capacity is "+capacity);
        System.out.println("printing "+resultList);
    }
    @Override
    public String toString(){
        return "ResultProcessor Class to persist result and start Connection to server";
    }
}
