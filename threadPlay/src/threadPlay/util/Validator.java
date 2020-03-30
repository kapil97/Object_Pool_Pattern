package threadPlay.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Validates input files and command line arguments
 */
public class Validator implements ValidatorI {
    String inputFileName;
    String numThreads,capacity,dPort;
    int windowSize;
    public Validator(String inputFileNameIn, String numThreadsIn, String capacityIn,String dportIn){
        inputFileName=inputFileNameIn;
        numThreads=numThreadsIn;
        capacity=capacityIn;
        dPort=dportIn;
    }
    /**
     *
     * @return true if the file is valid or else returns false
     */
    @Override
   public boolean valid(){
        File file=new File(inputFileName);
        Scanner sc = null;
        try {
            sc = new Scanner(new File(inputFileName));

            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                try{
                    int num=Integer.parseInt(data);
                }
                catch (Exception e){
                    System.out.println("Only Integers are allowed");
                    return false;

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(file.length()==0){
            System.out.println("File is empty");
            return false;
        }

        else if(Integer.parseInt(capacity)<=0){
            System.out.println("Capacity cannot be negative");
            return false;
        }
       else if(Integer.parseInt(dPort)<32768&&Integer.parseInt(dPort)>50000){
            System.out.println("Port number should be greater than 32768 and less than 50000");
            return false;
        }
       else return file.exists();
    }
    @Override
    public String toString(){
        String returnValue="This performs Validation and retruns a boolean value" ;
        return returnValue;
    }

}
