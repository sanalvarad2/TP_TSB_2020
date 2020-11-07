
package utils;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;


public class HashtableReader<E extends Map> {

    private String arch = "map.dat";

    public HashtableReader() {
    }

    public HashtableReader(String nom) {
        arch = nom;
    }

    public E read() {
        E ht;

        try {
            FileInputStream istream = new FileInputStream(arch);
            ObjectInputStream p = new ObjectInputStream(istream);

            ht = (E) p.readObject();

            p.close();
            istream.close();
        } catch (Exception e) {
            ht = null;
            System.out.println(e);
        }

        return ht;
    }
}
