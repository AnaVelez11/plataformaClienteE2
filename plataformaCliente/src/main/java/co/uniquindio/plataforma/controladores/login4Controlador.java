package co.uniquindio.plataforma.controladores;
import co.uniquindio.plataforma.modelo.PlataformaCliente;
import co.uniquindio.plataforma.modelo.Propiedades;
import co.uniquindio.plataforma.utils.CambioIdiomaEvent;
import co.uniquindio.plataforma.utils.CambioIdiomaListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class login4Controlador implements Initializable, CambioIdiomaListener {
    @FXML
    private TextField usuario;
    @FXML
    private PasswordField ide;
    @FXML
    private Button btnAtras,btnIniciar;

    private final PlataformaCliente plataformaCliente = PlataformaCliente.getInstance();
    private final Propiedades propiedades = Propiedades.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Propiedades.getInstance().addCambioIdiomaListener(this);
        actualizarTextos();
    }
    public void onCambioIdioma(CambioIdiomaEvent evento) {
        // Se llama cuando se cambia el idioma

        // Actualiza las cadenas de texto según el nuevo idioma
        actualizarTextos();
    }
    private void actualizarTextos() {
        usuario.setPromptText(propiedades.getResourceBundle().getString("TextoUsuario"));
        ide.setPromptText(propiedades.getResourceBundle().getString("TextoContrasena"));
        btnIniciar.setText(propiedades.getResourceBundle().getString("TextoIniciar"));
        btnAtras.setText(propiedades.getResourceBundle().getString("TextoAtras"));

    }

    public void iniciarSesion(ActionEvent event) {
        long id = Long.parseLong(ide.getText());
        String nombre = usuario.getText();

        try {
            // Llama al método existeSocioPublicador para verificar la existencia del SocioPublicador
            boolean mensaje = plataformaCliente.existeSocioPublicador(id, nombre);

            if(mensaje){
                plataformaCliente.loadStage("/ventanas/inicioSocioPublicador.fxml", event);
            }else{
                // Acceso incorrecto
                mostrarMensaje(Alert.AlertType.ERROR, "Credenciales incorrectas");
            }
        } catch (Exception e) {
            mostrarMensaje(Alert.AlertType.ERROR, "Error durante el inicio de sesión");
        }
    }

    public void mostrarMensaje(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();
    }
    public void atras(ActionEvent event) {
        Object evt = event.getSource();
        if (evt.equals(btnAtras)) {
            plataformaCliente.loadStage("/ventanas/bienvenida.fxml", event);
        }

    }
}
