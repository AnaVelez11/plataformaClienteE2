package co.uniquindio.plataforma.utils;

import java.util.Locale;
import java.util.EventObject;

public class CambioIdiomaEvent extends EventObject{
    private final Locale nuevoIdioma;

    public CambioIdiomaEvent(Object source, Locale nuevoIdioma) {
        super(source);
        this.nuevoIdioma = nuevoIdioma;
    }
}
