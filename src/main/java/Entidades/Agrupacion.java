package Entidades;

public class Agrupacion {


    private String codigo_categoria; //0
    private String nombre_categoria; //1
    private int codigo_agrupacion; //2
    private String nombre_agrupacion; //3
    private String codigo_lista;  //4
    private String nombre_lista; //5

    public Agrupacion() {

    }

    public Agrupacion(String codigo_categoria, String nombre_categoria, int codigo_agrupacion, String nombre_agrupacion, String codigo_lista, String nombre_lista) {
        this.codigo_categoria = codigo_categoria;
        this.nombre_categoria = nombre_categoria;
        this.codigo_agrupacion = codigo_agrupacion;
        this.nombre_agrupacion = nombre_agrupacion;
        this.codigo_lista = codigo_lista;
        this.nombre_lista = nombre_lista;
    }

    public String getCodigoCategoria() {
        return codigo_categoria;
    }

    public String getNombreCategoria() {
        return nombre_categoria;
    }

    public int getCodigoAgrupacion() {
        return codigo_agrupacion;
    }

    public String getNombreAgrupacion() {
        return nombre_agrupacion;
    }

    public String getCodigoLista() {
        return codigo_lista;
    }

    public String getNombreLista() {
        return nombre_lista;
    }


    public int getCodigo() {
        return codigo_agrupacion;
    }

    @Override
    public String toString() {
        return "(" + this.nombre_categoria + "; " +  this.codigo_categoria + "; " +  this.nombre_agrupacion + ")";
    }
}
