package Entidades;

public class Agrupacion {


    private String codigo_categoria; //0
    private String nombre_categoria; //1
    private String codigo_agrupacion; //2
    private String nombre_agrupacion; //3

    private int votos;

    public Agrupacion() {
        votos = 0;
    }

    public Agrupacion(String codigo_categoria, String nombre_categoria, String codigo_agrupacion, String nombre_agrupacion) {
        this.codigo_categoria = codigo_categoria;
        this.nombre_categoria = nombre_categoria;
        this.codigo_agrupacion = codigo_agrupacion;
        this.nombre_agrupacion = nombre_agrupacion;
        votos = 0;
    }

    public String getCodigoCategoria() {
        return codigo_categoria;
    }

    public String getNombreCategoria() {
        return nombre_categoria;
    }

    public String getCodigoAgrupacion() {
        return codigo_agrupacion;
    }

    public String getNombreAgrupacion() {
        return nombre_agrupacion;
    }

    public String getCodigo() {
        return codigo_agrupacion;
    }

    @Override
    public String toString() {
        return this.nombre_agrupacion + "; Votos: "+ votos + ";";
    }

    public void AgregarVotos(int votos){
        this.votos += votos;
    }
}
