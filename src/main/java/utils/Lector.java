package utils;

import oahashtable.TSB_OAHashtable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lector {

    private String _path = "";
    private Scanner sc;

    public Lector(String path){
        try {
            File text = new File(path);
            sc = new Scanner(text);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public TSB_OAHashtable CargarAgrupaciones(){
        TSB_OAHashtable tabla = new TSB_OAHashtable(11, 0.4f);
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("\\|");
           if(true){

           }
        }
        return tabla;
    }



}
