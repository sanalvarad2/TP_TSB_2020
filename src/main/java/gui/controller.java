package gui;

import Entidades.Region;
import Negocio.Agrupaciones;
import Negocio.Regiones;
import Negocio.Resultados;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class controller {

    public Label lblRuta;
    public ComboBox cmbDistrito;
    public ComboBox cmbSeccion;
    public ComboBox cmbCircuito;
    public ComboBox cmbMesa;
    public ListView lvwResultados;
    private Resultados resultados;

    @FXML
    public void initialize(){
        Path currentRelativePath = Paths.get("./src/main/resources/data");
        lblRuta.setText(currentRelativePath.toAbsolutePath().toString());

    }



    public void seleccionarRuta(ActionEvent actionEvent) {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Seleccionar la ubicación de los datos");
        File directorio = dc.showDialog(null);

        if (directorio != null) {
            lblRuta.setText(directorio.getPath());
        }
    }

    public void cargarDatos(ActionEvent actionEvent) {
        String ruta = lblRuta.getText();
        if (!ruta.equals("...")) {
            Regiones regiones = new Regiones(ruta);
            Agrupaciones.CargarAgrupaciones(ruta);
            resultados = new Resultados(ruta);

            ObservableList ol = FXCollections.observableArrayList(regiones.getRegiones());
            cmbDistrito.setItems(ol);
            cmbDistrito.setDisable(false);


            ObservableList ol1 = FXCollections.observableArrayList(resultados.getResultadosPorRegion("00"));

            lvwResultados.setItems(ol1);

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText("Se debe seleccionar la ubicación de los datos.");
            a.showAndWait();
        }
    }

    public void seleccionarDistrito(ActionEvent actionEvent) {
        cmbSeccion.setValue(null);
        cmbSeccion.setDisable(true);
        cmbCircuito.setValue(null);
        cmbCircuito.setDisable(true);
        cmbMesa.setValue(null);
        cmbMesa.setDisable(true);

        Region distrito = (Region) cmbDistrito.getValue();
        if (distrito != null) {
            ObservableList ol1 = FXCollections.observableArrayList(resultados.getResultadosPorRegion(distrito.getCodigo()));
            lvwResultados.setItems(ol1);

            ObservableList ol = FXCollections.observableArrayList(distrito.getSubRegiones());
            cmbSeccion.setItems(ol);
            cmbSeccion.setDisable(false);
        }
    }

    public void seleccionarSeccion(ActionEvent actionEvent) {
        cmbCircuito.setValue(null);
        cmbCircuito.setDisable(true);
        cmbMesa.setValue(null);
        cmbMesa.setDisable(true);

        Region seccion = (Region) cmbSeccion.getValue();

        if (seccion != null) {
            ObservableList ol1 = FXCollections.observableArrayList(resultados.getResultadosPorRegion(seccion.getCodigo()));
            lvwResultados.setItems(ol1);
            ObservableList ol = FXCollections.observableArrayList(seccion.getSubRegiones());
            cmbCircuito.setItems(ol);
            cmbCircuito.setDisable(false);
        }
    }

    public void seleccionarCircuito(ActionEvent actionEvent) {
        cmbMesa.setValue(null);
        cmbMesa.setDisable(true);

        Region circuito = (Region) cmbCircuito.getValue();

        if (circuito != null) {
            ObservableList ol1 = FXCollections.observableArrayList(resultados.getResultadosPorRegion(circuito.getCodigo()));
            lvwResultados.setItems(ol1);

            ObservableList ol = FXCollections.observableArrayList(circuito.getSubRegiones());
            cmbMesa.setItems(ol);
            cmbMesa.setDisable(false);
        }
    }

    public void seleccionarMesa(ActionEvent actionEvent) {
        Region seccion = (Region) cmbMesa.getValue();
        if (cmbMesa.getValue() != null) {
            ObservableList ol1 = FXCollections.observableArrayList(resultados.getResultadosPorRegion(seccion.getCodigo()));
            lvwResultados.setItems(ol1);
        }
    }


}
