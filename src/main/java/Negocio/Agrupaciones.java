package Negocio;
import Entidades.Agrupacion;
import oahashtable.TSB_OAHashtable;
import utils.Lector;

import java.util.Collection;

public class Agrupaciones {
    private static TSB_OAHashtable inicial;
    private TSB_OAHashtable agrupaciones;


    public Agrupaciones() {
        this.agrupaciones = new TSB_OAHashtable();
        for (Object o: inicial.values() ) {
            Agrupacion a = (Agrupacion) o;
            Agrupacion newAgrup = new Agrupacion(a.getCodigoCategoria(), a.getNombreCategoria(), a.getCodigoAgrupacion(),a.getNombreAgrupacion());

            agrupaciones.put(a.getCodigo(), newAgrup);
        }
    }

    public static void CargarAgrupaciones(String path){
        Lector lector = new Lector(path + "\\descripcion_postulaciones.dsv");
        inicial = lector.CargarAgrupaciones();
    }

    public Collection getResultados(){
        return agrupaciones.values();
    }

}