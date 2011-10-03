package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author geovane
 */
public class Recorder {
    private Integer quantity;
    private FileOutputStream files[] = new FileOutputStream[10];
    private FileOutputStream sFile;

    public Recorder(Integer q) throws FileNotFoundException {
        quantity = q;
        for (int i = 0; i < 10; i++) {
            files[i] = new FileOutputStream("src/infiles/arquivo" + i +".dados");
        }
        sFile = new FileOutputStream("src/infiles/busca_100.dados");
    }

    public void populateFiles() throws FileNotFoundException, IOException {
        for (int i = 0; i < 10; i++) {
            new PrintStream(files[i]).println (Generator.randomNumbers(quantity/10, i*(quantity/10), (i+1)*(quantity/10)));
            files[i].close();
        }
        new PrintStream(sFile).println (Generator.randomNumbers(100, 0, quantity));
        sFile.close();
    }

}
