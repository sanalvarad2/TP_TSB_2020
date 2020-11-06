package Negocio;

import Entidades.Region;
import utils.Lector;

import java.util.Collection;

public class Regiones {
    private Lector lectorRegiones;
    private Lector lectorMesas;
    private Region pais;

    public Regiones(String path) {
        lectorRegiones = new Lector(path+ "\\descripcion_regiones.dsv");
        lectorMesas = new Lector(path + "\\mesas_totales_agrp_politica.dsv");
        pais = lectorRegiones.CargarRegiones();
        //lectorMesas.cargarMesas(pais);

    }

    public Collection getRegiones(){
        return pais.getSubRegiones();
    }
}
