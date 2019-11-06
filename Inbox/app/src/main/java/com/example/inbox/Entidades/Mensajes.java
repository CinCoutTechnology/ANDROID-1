package com.example.inbox.Entidades;

public class Mensajes {
    private String contacto;
    private String mensaje;

    public Mensajes(String contacto, String mensaje) {
        this.contacto = contacto;
        this.mensaje = mensaje;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
