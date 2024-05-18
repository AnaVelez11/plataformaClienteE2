package co.uniquindio.plataforma.controladores;

import co.uniquindio.plataforma.modelo.PlataformaCliente;
import co.uniquindio.plataforma.modelo.Propiedades;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Locale;

public class bienvenidaControlador {
    @FXML
    private Button btnEnvio,btnProcesamiento,btnSocio,btnAdmin,cambiarIdioma;
    @FXML
    private Label label;
    private final PlataformaCliente plataformaCliente = PlataformaCliente.getInstance();
    private final Propiedades propiedades = Propiedades.getInstance();
    private boolean esIngles = false;
    @FXML
    private void cambioIdioma(ActionEvent event) {
        // Cambia el idioma
        if (esIngles) {
            Propiedades.getInstance().setLocale(new Locale("es", "ES"));
        } else {
            Propiedades.getInstance().setLocale(Locale.ENGLISH);
        }
        // Invierte el valor de esIngles para la próxima vez
        esIngles = !esIngles;

        // Actualiza la interfaz de usuario
        actualizarTextos();
    }
    private void actualizarTextos() {
        cambiarIdioma.setText(propiedades.getResourceBundle().getString("TextoCambiarIdioma"));
        btnAdmin.setText(propiedades.getResourceBundle().getString("TextoAdmin"));
        btnEnvio.setText(propiedades.getResourceBundle().getString("TextoEnvio"));
        btnProcesamiento.setText(propiedades.getResourceBundle().getString("TextoProcesamiento"));
        btnSocio.setText(propiedades.getResourceBundle().getString("TextoSocio"));
        label.setText(propiedades.getResourceBundle().getString("TextoLabel"));

    }

    public void irEnvio(ActionEvent event) {
        Object evt = event.getSource();
        if (evt.equals(btnEnvio)) {
            plataformaCliente.loadStage("/ventanas/login2.fxml", event);
        }
    }
    public void irAdmin(ActionEvent event) {
        Object evt = event.getSource();
        if (evt.equals(btnAdmin)) {
            plataformaCliente.loadStage("/ventanas/loginAdmin.fxml", event);
        }
    }
        public void irProcesamiento(ActionEvent event) {
            Object evt = event.getSource();
            if (evt.equals(btnProcesamiento)) {
                plataformaCliente.loadStage("/ventanas/inicioGestorProcesamiento.fxml", event);
            }
        }
    public void irSocio(ActionEvent event) {
        Object evt = event.getSource();
        if (evt.equals(btnSocio)) {
            plataformaCliente.loadStage("/ventanas/login4.fxml", event);
        }
    }
}