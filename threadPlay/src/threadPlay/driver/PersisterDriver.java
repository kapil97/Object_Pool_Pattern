package threadPlay.driver;
import threadPlay.persister.Persister;
import threadPlay.persister.PersisterI;
import threadPlay.util.Validator;
import threadPlay.util.ValidatorI;

/**
 * @author Kamleshwar Ragava
 * @author Jithin Jose
 */

public class PersisterDriver{
    /**
     * Main Method
     * Command line validation happens here
     * takes input as command line arguments
     * @param args
     */
    public static void main(String[] args) {
        final int REQUIRED_NUMBER_OF_ARGS = 2;
        if ((args.length != REQUIRED_NUMBER_OF_ARGS) ||
                (args[0].equals("${port}")) ||
                (args[1].equals("${outputNumStream}"))) {
            System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_ARGS);
            System.exit(0);
        }
        ValidatorI validator=new Validator(args[0]);
        if(validator.validPersisterService()) {
            PersisterI persister = new Persister(args[1]);
            persister.persisterServer(args[0]);
        }
        else
            System.exit(0);
    }

    @Override
    public String toString(){
        String returnValue="Persiter Driver Class";
        return returnValue;
    }
}