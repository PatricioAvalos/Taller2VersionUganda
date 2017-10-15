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
public class ListaClientes {
    
    private Cliente[] ListaClientes;
    private int cantidadClientes;
    private int max;

    public ListaClientes(int max) {
        ListaClientes = new Cliente[max];
        cantidadClientes = 0;
        this.max = max;
    }

    public int getCantidadClientes() {
        return cantidadClientes;
    }

    public int getMax() {
        return max;
    }
    
    public boolean ingresarCliente (Cliente cliente){
       if(cantidadClientes < max){
           ListaClientes[cantidadClientes] = cliente;
           cantidadClientes++;
           return true;
       }else{
           return false;
       }
    }
    
    public Cliente getClienteI(int i) {
        if (i >= 0 && i < cantidadClientes){
            return ListaClientes[i];
        }
        else{
            return null;
        }
    }
    
    public Cliente encontrarCliente(String Valor) {
        //encuentra valor especificado
        int j;
        for(j=0; j<cantidadClientes; j++) { //para cada elemento,
            if( ListaClientes[j].getRUT().equals(Valor) ){ //¿persona encontrado?
                break; // sale del loop
            }
        }
        
        if(j == cantidadClientes) {
        return null; // no la encontró
        }
        else{
        return ListaClientes[j]; // la encontro
        }
        }
        
}
