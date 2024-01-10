package domain;

import java.io.Serializable;

import jakarta.persistence.*;


@Entity
@Table(name="persona")//En este caso se coloca esta anotacion para definir el nombre de la tabla que va a buscar en la BD

public class Persona implements Serializable {
    

    private static final long serialVersionUID = 1L;

    @Column(name="id_persona")//Como en este caso no coincide el atributo con su equivalente en la base de datos se debe definir de
    //esta manera con Column.
    @Id 
    private int idPersona;

    private String nombre; //En este caso al ser igual el atributo que su valor en la base de datos no se debe definir
    private String apellido;
    private String email;
    private String telefono;

    public Persona() {
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
                + ", telefono=" + telefono + "]";
    }

    

    

    


    
}
