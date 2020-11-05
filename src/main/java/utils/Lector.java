package utils;

import oahashtable.TSB_OAHashtable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lector{

    private String _path = "";
    private Scanner sc;
    Agrupacion agrupacion;


    public Lector() {

        this.Lector(this._path);
    }

    public Lector(String path) {
        this._path = path;
        this.Lector(path);

    }

    public void Lector(String path){
        try {
            File text = new File(path);
            sc = new Scanner(text);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ReadFile(String criterio, int posicion){
        TSB_OAHashtable tabla = new TSB_OAHashtable(10);
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("\\|");
           if(line[posicion].equals(criterio)){
               String codigo_categoria= line[0];
               int codigo_agrupuacion = Integer.parseInt(line[2]);
               String nombre_agrupacion= line[1];
                 agrupacion = new Agrupacion(codigo_agrupuacion, nombre_agrupacion);
                 tabla.put(agrupacion.getCodigo(), agrupacion);
                //debería retornar la tabla
           }
        }
        System.out.println(tabla);
    }



}
