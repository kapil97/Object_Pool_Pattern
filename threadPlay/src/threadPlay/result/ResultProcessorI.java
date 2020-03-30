package threadPlay.result;

public interface ResultProcessorI {
     void addToResultList(String primeNo);
     void printList();
     void readDataFromList();
     void setIp(String ip);
     void setPort(int port);
     void startClient();
}