package org.generation.agenda.models;
import org.generation.agenda.exceptions.InvalidData;

public abstract class Contactos {

    private String nombre;
    private String apellido;
    private Integer numero;

    public Contactos(String nombre, String apellido, Integer numero) throws InvalidData{
        setNombre(nombre);
        setApellido(apellido);
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws InvalidData {
        if(nombre == null || (nombre.trim().isEmpty())) throw new InvalidData("El nombre no puede estar vacio");
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws InvalidData{
        if(apellido == null || (apellido.trim().isEmpty())) throw new InvalidData("El apellido no puede estar vacio");
        this.apellido = apellido;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public abstract void showDetails();


}
