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
public class ListaLibros {
    
    private Libro[] ListaLibros;
    private int cantidadLibros;
    private int max;

    public ListaLibros(int max) {
        ListaLibros = new Libro[max];
        cantidadLibros = 0;
        this.max = max;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public int getMax() {
        return max;
    }

    public boolean ingresarLibro (Libro libro){
       if(cantidadLibros < max){
           ListaLibros[cantidadLibros] = libro;
           cantidadLibros++;
           return true;
       }else{
           return false;
       }
    }
    
    public Libro getLibroI(int i) {
        if (i >= 0 && i < cantidadLibros){
            return ListaLibros[i];
        }
        else{
            return null;
        }
    }
    
    public Libro encontrarLibro(String Valor) {
        //encuentra valor especificado
        int j;
        for(j=0; j<cantidadLibros; j++) { //para cada elemento,
            if( ListaLibros[j].getISBN().equals(Valor) ){ //¿persona encontrado?
                break; // sale del loop
            }
        }
        
        if(j == cantidadLibros) {
        return null; // no la encontró
        }
        else{
        return ListaLibros[j]; // la encontro
        }
    }
}
