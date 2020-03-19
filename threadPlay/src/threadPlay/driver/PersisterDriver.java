package threadPlay.driver;
import javax.print.attribute.standard.NumberUp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

public class PersisterDriver{
    public static void main(String[] args) {
        final int REQUIRED_NUMBER_OF_ARGS = 2;
        if ((args.length != REQUIRED_NUMBER_OF_ARGS) ||
                (args[0].equals("${port}")) ||
                (args[1].equals("${outputNumStream}"))) {
            System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_ARGS);
            System.exit(0);
        }
        System.out.println("Testing Ant File-persister");
    }

    @Override
    public String toString(){
        String returnValue="Persiter Driver Class";
        return returnValue;
    }
}