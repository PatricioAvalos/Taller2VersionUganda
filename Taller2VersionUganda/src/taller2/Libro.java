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
public class Libro {
    private String ISBN;
    private String Titulo;
    private String Autor;
    private String Año;
    
    public Libro(String ISBN,String Titulo,String Autor,String Año){
        this.ISBN   = ISBN;
        this.Titulo = Titulo;
        this.Autor  = Autor;
        this.Año    = Año;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getAño() {
        return Año;
    }

    public void setAño(String Año) {
        this.Año = Año;
    }
    
    
}
