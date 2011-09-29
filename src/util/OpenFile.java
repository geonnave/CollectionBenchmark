package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author geovane
 */
public class OpenFile {

    private BufferedReader filesBf[] = new BufferedReader[10];
    private BufferedReader sFileBf;

    public OpenFile() throws IOException {
        FileReader files[] = new FileReader[10];
        FileReader sFile;
        for (int i = 0; i < 10; i++) {
            try {
                files[i] = new FileReader("src/files/arquivo" + i + ".dados");
                filesBf[i] = new BufferedReader(files[i]);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        sFile = new FileReader("src/files/busca_100.dados");
        sFileBf = new BufferedReader(sFile);
        for (int i = 0; i < files.length; i++) {
//            files[i].close();
        }
//        sFile.close();
    }

    public String[] getNumbers() throws IOException {
        String values[] = new String[10000];
        String linha;
        int k = 0;
        boolean fim;
        for (int i = 0; i < 10; i++) {
            fim = false;
            linha = filesBf[i].readLine();
            while (linha != null) {
                values[k] = linha;
                k++;
                linha = filesBf[i].readLine();
            }

        }
        return values;
    }

    public String[] getSearchNumbers() throws IOException {
        String values[] = new String[100];
        String linha = sFileBf.readLine();
        int i = 0;
        while (linha != null) {
            values[i] = sFileBf.readLine();
            linha = sFileBf.readLine();
            i++;
        }
        return values;
    }
}
