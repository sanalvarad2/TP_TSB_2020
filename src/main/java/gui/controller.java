package gui;

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
        String text = lblRuta.getText();
        if (!text.equals("...")) {
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

        if (cmbDistrito.getValue() != null) {
            cmbSeccion.setDisable(false);
        }
    }

    public void seleccionarSeccion(ActionEvent actionEvent) {
        cmbCircuito.setValue(null);
        cmbCircuito.setDisable(true);
        cmbMesa.setValue(null);
        cmbMesa.setDisable(true);

        if (cmbSeccion.getValue() != null) {
            cmbCircuito.setDisable(false);
        } else {

        }
    }

    public void seleccionarCircuito(ActionEvent actionEvent) {
        cmbMesa.setValue(null);
        cmbMesa.setDisable(true);

        if (cmbCircuito.getValue() != null) {
            cmbMesa.setDisable(false);
        } else {

        }
    }

    public void seleccionarMesa(ActionEvent actionEvent) {
        if (cmbMesa.getValue() != null) {

        } else {

        }
    }
}
