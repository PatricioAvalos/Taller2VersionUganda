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

// Agregar metodos conversion date
public class Prestamo {
    private int NumReg;
    private String RUT;
    private String ISBN;
    private String FechaPedido;
    private String FechaDevolucion;
    private String FechaDevuelto;

    public Prestamo(int NumReg, String RUT, String ISBN, String FechaPedido, String FechaDevolucion, String FechaDevuelto) {
        this.NumReg = NumReg;
        this.RUT = RUT;
        this.ISBN = ISBN;
        this.FechaPedido = FechaPedido;
        this.FechaDevolucion = FechaDevolucion;
        this.FechaDevuelto = FechaDevuelto;
    }

    public int getNumReg() {
        return NumReg;
    }

    public void setNumReg(int NumReg) {
        this.NumReg = NumReg;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getFechaPedido() {
        return FechaPedido;
    }

    public void setFechaPedido(String FechaPedido) {
        this.FechaPedido = FechaPedido;
    }

    public String getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(String FechaDevolucion) {
        this.FechaDevolucion = FechaDevolucion;
    }

    public String getFechaDevuelto() {
        return FechaDevuelto;
    }

    public void setFechaDevuelto(String FechaDevuelto) {
        this.FechaDevuelto = FechaDevuelto;
    }
    
    
    
   
    
    
}
