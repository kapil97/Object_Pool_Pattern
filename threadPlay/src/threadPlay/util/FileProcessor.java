package threadPlay.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public final class FileProcessor {
    private BufferedReader reader;
    private String line;

    public FileProcessor(String inputFilePath)
            throws InvalidPathException, SecurityException, IOException {

        if (!Files.exists(Paths.get(inputFilePath))) {
            throw new FileNotFoundException("invalid input file or input file in incorrect location");
        }

        reader = new BufferedReader(new FileReader(new File(inputFilePath)));
        line = reader.readLine();
    }

    /**
     * to pull a line and send it to the driver for further processing
     * @return
     * @throws NumberFormatException
     * @throws IOException
     */
    public synchronized String poll() throws NumberFormatException, IOException {
        if (null == line) return null;

        String newValue = (line.trim());
        line = reader.readLine();
        return newValue;
    }

    public synchronized void close() throws IOException {
        try {
            reader.close();
            line = null;
        } catch (IOException e) {
            throw new IOException("failed to close file", e);
        }
    }
    @Override
    public String toString(){
        String returnValue="File Processor Class which will process file line by line";
        return returnValue;
    }
}
