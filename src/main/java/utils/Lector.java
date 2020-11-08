package utils;

import Entidades.Agrupacion;
import Entidades.Region;
import Negocio.Resultados;
import oahashtable.TSB_OAHashtable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lector {
    private Scanner sc;

    public Lector(String path){
        try {
            File text = new File(path);
            sc = new Scanner(text);

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo cargar el archivo: " + path);
        }
    }

    public TSB_OAHashtable CargarAgrupaciones(){
        TSB_OAHashtable tabla = new TSB_OAHashtable(11, 0.4f);
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("\\|");

            String codigo = line[0];
           if(codigo.compareTo("000100000000000")==0){
               String codigo_agrupacion = line[2]; //2
               String nombre_agrupacion = line[3]; //3
               Agrupacion agr = new Agrupacion(codigo_agrupacion, nombre_agrupacion);
               tabla.put(codigo_agrupacion, agr);

           }
        }
        return tabla;
    }

    private void CargarMesa(Region pais, String codDistrito, String codSeccion, String codCircuito, String codMesa){
        Region distrito, seccion, circuito;
        distrito = pais.getOrPutRegion(codDistrito);
        seccion = distrito.getOrPutRegion(codSeccion);
        circuito = seccion.getOrPutRegion(codCircuito);
        circuito.putIfnotExists(codMesa);

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


    public void sumarVotos(Resultados resultados, Region pais) {
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("\\|");
            if(line[4].compareTo("000100000000000")==0){
                String codAgrupacion = line[5];
                int votos = Integer.parseInt(line[6]);


                CargarMesa(pais, line[0], line[1], line[2], line[3]);
                resultados.contarVotosPorRegion("00",codAgrupacion, votos);

                for (int i = 0; i < 4; i++) {
                    resultados.contarVotosPorRegion(line[i], codAgrupacion,votos);
                }
            }

        }
    }
}
