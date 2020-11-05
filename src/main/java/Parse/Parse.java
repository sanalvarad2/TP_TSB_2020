package Parse;


import utils.Lector;

public class Parse {
        public static void LoadData (){
            Lector archivo = new Lector();
            try {
                archivo.Lector("src/main/resources/data/descripcion_postulaciones.dsv");

                archivo.ReadFile("Presidente y Vicepresidente de la República", 1);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
}
