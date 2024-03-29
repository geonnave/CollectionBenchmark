package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author geovane
 */
public class OpenFile {
    private Integer quantity;
    private BufferedReader filesBf[] = new BufferedReader[10];
    private BufferedReader sFileBf;

    public OpenFile(Integer q) throws IOException {
        quantity = q;
        FileReader files[] = new FileReader[10];
        FileReader sFile;
        for (int i = 0; i < 10; i++) {
            files[i] = new FileReader("src/infiles/arquivo" + i + ".dados");
            filesBf[i] = new BufferedReader(files[i]);
        }
        sFile = new FileReader("src/infiles/busca_100.dados");
        sFileBf = new BufferedReader(sFile);
    }

    public String[] getNumbers() throws IOException {
        String values[] = new String[quantity];
        String linha;
        int k = 0;
        boolean fim;
        for (int i = 0; i < 10; i++) {
            fim = false;
            linha = filesBf[i].readLine();
            while (linha != null && !linha.equals("")) {
                values[k] = linha;
                linha = filesBf[i].readLine();
                k++;
            }
        }
        return values;
    }

    public String[] getSearchNumbers() throws IOException {
        String values[] = new String[100];
        String linha = sFileBf.readLine();
        int i = 0;
        while (linha != null && !linha.equals("")) {
            values[i] = linha;
            linha = sFileBf.readLine();
            i++;
        }
        return values;
    }
}
