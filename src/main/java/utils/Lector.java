package utils;

import Entidades.Agrupacion;
import Entidades.Region;
import oahashtable.TSB_OAHashtable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Lector {
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

            String codigo = line[0];
           if(codigo.compareTo("000100000000000")==0){
               String nombre_categoria = line[1]; //1
               int codigo_agrupacion = Integer.parseInt(line[2]); //2
               String nombre_agrupacion = line[3]; //3
               Agrupacion agr = new Agrupacion(codigo,nombre_categoria, codigo_agrupacion, nombre_agrupacion);
               tabla.put(codigo_agrupacion, agr);

           }
        }
        return tabla;
    }

    public Region CargarRegiones(){
        Region distrito, seccion, circuito;
        Region pais = new Region("00", "Argentina");
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("\\|");

            String codigo = line[0];
            String nombre = line[1];
            switch (codigo.length()){
                case 2:
                    distrito = pais.getOrPutRegion(codigo);
                    distrito.setNombre(nombre);
                    break;
                case 5:
                    distrito = pais.getOrPutRegion(codigo.substring(0,2));
                    seccion = distrito.getOrPutRegion(codigo);
                    seccion.setNombre(nombre);
                    break;
                case 11:
                    distrito = pais.getOrPutRegion(codigo.substring(0,2));
                    seccion = distrito.getOrPutRegion(codigo.substring(0,5));
                    circuito = seccion.getOrPutRegion(codigo);
                    circuito.setNombre(nombre);
                    break;
            }
        }
        return pais;
    }

    public void cargarMesas(Region pais){
        Region distrito, seccion, circuito, mesas;

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("\\|");
            String codigoCategoria = line[4];
            if(codigoCategoria.compareTo("000100000000000")==0){
                String codDistrito = line[0];
                String codSeccion = line[1];
                String codCircuito = line[2];
                String codMesas = line[3];


                distrito = pais.getOrPutRegion(codDistrito);
                seccion = distrito.getOrPutRegion(codSeccion);
                circuito = seccion.getOrPutRegion(codCircuito);
                circuito.getOrPutRegion(codMesas);
            }

        }

    }

}
