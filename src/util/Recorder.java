package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author geovane
 */
public class Recorder {

    private FileOutputStream files[] = new FileOutputStream[10];
    private FileOutputStream sFile;

    public Recorder() throws FileNotFoundException {
        for (int i = 0; i < 10; i++) {
            try
            {
                files[i] = new FileOutputStream("src/files/arquivo" + i +".dados");
            }
            catch (Exception e)
            {
                System.err.println(e);
            }
        }
        sFile = new FileOutputStream("src/files/busca_100.dados");
    }

    public void populateFiles() throws FileNotFoundException {
        for (int i = 0; i < 10; i++) {
            try
            {
                new PrintStream(files[i]).println (Generator.randomNumbers(1000, i*1000, (i+1)*1000));
                files[i].close();
                if (i == 0) {
                    new PrintStream(sFile).println (Generator.randomNumbers(100, 0, 10000));
                    sFile.close();
                }
            }
            catch (Exception e)
            {
                System.err.println(e);
            }
        }
    }

}
