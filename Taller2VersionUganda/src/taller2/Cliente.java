/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

/**
 *
 * @author D4C
 */
public class Cliente {
    private String RUT;
    private String Nombre;
    private String Apellido;
    private String Celular;
    private String EMail;
    
    public Cliente(String RUT,String Nombre, String Apellido,
                    String Celular, String Email){
        this.RUT      = RUT;
        this.Nombre   = Nombre;
        this.Apellido = Apellido;
        this.Celular  = Celular;
        this.EMail    = Email;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }
    
}
