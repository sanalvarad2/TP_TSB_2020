package gui;

import Entidades.Region;
import Negocio.Agrupaciones;
import Negocio.Regiones;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class controller {

    public Label lblRuta;
    public ComboBox cmbDistrito;
    public ComboBox cmbSeccion;
    public ComboBox cmbCircuito;
    public ComboBox cmbMesa;

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
            ObservableList ol = FXCollections.observableArrayList(regiones.getRegiones());
            cmbDistrito.setItems(ol);
            cmbDistrito.setDisable(false);
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
            ObservableList ol = FXCollections.observableArrayList(circuito.getSubRegiones());
            cmbMesa.setItems(ol);
            cmbMesa.setDisable(false);
        }
    }

    public void seleccionarMesa(ActionEvent actionEvent) {
        if (cmbMesa.getValue() != null) {

        }
    }
}
