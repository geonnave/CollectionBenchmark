package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author geovane
 */
public class OpenFile {

    private BufferedReader filesBf[] = new BufferedReader[10];
    private BufferedReader sFileBf;

    public OpenFile() {
        FileReader files[] = new FileReader[10];
        FileReader sFile;
        for (int i = 0; i < 10; i++) {
            try {
                files[i] = new FileReader("src/files/arquivo" + i + ".dados");
                filesBf[i] = new BufferedReader(files[i]);
                if (i == 0) {
                    sFile = new FileReader("src/files/busca_100.dados");
                    sFileBf = new BufferedReader(sFile);
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public String[] getNumbers() throws IOException {
        String values[] = new String[10000];
//        StringBuffer bf[] = new StringBuffer[10000];
        String linha;
        int k = 0;
        boolean fim;
        for (int i = 0; i < 10; i++) {
            fim = false;
            linha = filesBf[i].readLine();
//            for (int j = 0; j < 1000; j++) {
            while (!(linha == null)) {
//                System.out.println(linha);
                values[k] = linha;
                k++;
                linha = filesBf[i].readLine();
            }

        }
        for (String string : values) {
            System.out.println(string);
        }
        return values;
    }
}
