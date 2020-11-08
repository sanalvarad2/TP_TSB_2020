package Negocio;

import Entidades.Agrupacion;
import Entidades.Region;
import oahashtable.TSB_OAHashtable;
import utils.Lector;

import java.util.Collection;

public class Resultados {
    private TSB_OAHashtable tablaResultados;

    public Resultados(String path, Region pais) {
        tablaResultados = new TSB_OAHashtable();
        Lector archivoMesas = new Lector(path + "\\mesas_totales_agrp_politica.dsv");
        archivoMesas.sumarVotos(this, pais);
    }

    public void contarVotosPorRegion(String codRegion, String codAgrupacion, int  votos){
        if(tablaResultados.get(codRegion)==null){
            tablaResultados.put(codRegion, new Agrupaciones());
        }
        Agrupaciones ag = (Agrupaciones) tablaResultados.get(codRegion);
        ag.getAgrupacion(codAgrupacion).AgregarVotos(votos);
    }

    public Collection getResultadosPorRegion(String codigoRegion){
        Agrupaciones aux = (Agrupaciones)tablaResultados.get(codigoRegion);
        return aux.getResultados();
    }
}
