package Negocio;

import Entidades.Region;
import utils.Lector;

import java.util.Collection;

public class Regiones {
    private Lector lectorRegiones;
    private Region pais;

    public Regiones(String path) {
        lectorRegiones = new Lector(path+ "\\descripcion_regiones.dsv");
        pais = lectorRegiones.CargarRegiones();
    }

    public Collection getRegiones(){
        return pais.getSubRegiones();
    }

    public Region getPais(){
        return pais;
    }
}
