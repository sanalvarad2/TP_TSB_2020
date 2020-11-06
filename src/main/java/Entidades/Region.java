package Entidades;

import oahashtable.TSB_OAHashtable;

import java.util.Collection;

public class Region  {
    String codigo;
    String nombre;
    TSB_OAHashtable subRegiones;

    public Region(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        subRegiones = new TSB_OAHashtable();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Collection getSubRegiones() {
        return subRegiones.values();
    }

    public Region getOrPutRegion(String codigo){
        Region region = (Region) subRegiones.get(codigo);
        if(region == null){
            subRegiones.put(codigo, new Region(codigo, ""));
        }
        return (Region) subRegiones.get(codigo);
    }

    @Override
    public String toString() {
        return "("+ codigo+ ") " + nombre;
    }
}
