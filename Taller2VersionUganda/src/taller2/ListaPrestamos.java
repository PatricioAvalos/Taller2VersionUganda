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
public class ListaPrestamos {
    private Prestamo[] ListaPrestamos;
    private int cantidadPrestamos;
    private int max;

    public ListaPrestamos(int max) {
        ListaPrestamos = new Prestamo[max];
        cantidadPrestamos = 0;
        this.max = max;
    }

    public int getCantidadPrestamos() {
        return cantidadPrestamos;
    }

    public int getMax() {
        return max;
    }
    
    public boolean ingresarPrestamo (Prestamo prestamo){
       if(cantidadPrestamos < max){
           ListaPrestamos[cantidadPrestamos] = prestamo;
           cantidadPrestamos++;
           return true;
       }else{
           return false;
       }
    }
    
    public Prestamo getPrestamoI(int i) {
        if (i >= 0 && i < cantidadPrestamos){
            return ListaPrestamos[i];
        }
        else{
            return null;
        }
    }
    
    public Prestamo encontrarPrestamo(String Valor) {
        //encuentra valor especificado
        int j;
        for(j=0; j<cantidadPrestamos; j++) { //para cada elemento,
            if( ListaPrestamos[j].getISBN().equals(Valor) ){ //¿persona encontrado?
                break; // sale del loop
            }
        }
        
        if(j == cantidadPrestamos) {
        return null; // no la encontró
        }
        else{
        return ListaPrestamos[j]; // la encontro
        }
    }
    
}
