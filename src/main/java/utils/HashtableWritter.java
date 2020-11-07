
package utils;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.util.Map;


public class HashtableWritter<E extends Map> {

    // nombre del archivo serializado...
    private String arch = "map.dat";


    public HashtableWritter() {
    }

    public HashtableWritter(String nom) {
        arch = nom;
    }

    public boolean write(E ht) {

        try (FileOutputStream ostream = new FileOutputStream(arch)) {

            ObjectOutputStream p = new ObjectOutputStream(ostream);

            p.writeObject(ht);

            p.flush();
        } catch (Exception e) {
            System.out.println(e); //***************************** CHECK
            return false;
        }

        return true;
    }
}
