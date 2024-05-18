package co.uniquindio.plataforma.controladores;

import co.uniquindio.plataforma.modelo.Cliente;
import co.uniquindio.plataforma.modelo.Noticia;
import co.uniquindio.plataforma.modelo.PlataformaCliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class inicioGestorEnvioControlador {
    @FXML
    private Button btnIniciar;
    @FXML
    private Button btnAtras;

    private final PlataformaCliente plataformaCliente = PlataformaCliente.getInstance();

    public void atras(ActionEvent event) {
        plataformaCliente.loadStage("/ventanas/bienvenida.fxml", event);
    }
}
