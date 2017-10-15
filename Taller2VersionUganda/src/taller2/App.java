/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

import ucn.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author D4C
 */
public class App implements IApp{
    private ListaClientes  listaClientes;
    private ListaLibros    listaLibros;
    private ListaPrestamos listaPrestamos;
    
    public App(){
        listaClientes  = new ListaClientes(1000);
        listaLibros    = new ListaLibros(1000);
        listaPrestamos = new ListaPrestamos(1000);
    }
    
    public static int Deuda(int NumDias){
        int Deuda;
        int x=0;
        if(NumDias==x){
            return x;
        }
        if(NumDias>=1 && NumDias<=7){
            return Deuda = 100;
        }
        if(NumDias>=8 && NumDias<=14){
            return Deuda = 300;
        }
        else return Deuda=700;
    }
    
    public static boolean ComparadorRangoFechas(Date Fecha, Date FechaA, Date FechaB){
	if(Fecha.after(FechaA) == true && Fecha.before(FechaB)==true){
	return true;
	}
	else{return false;}
    }
    
    public static int DiferenciaDiasDeFechas(Date FechaInicial, Date FechaFinal) {
        long FechaInicialMs = FechaInicial.getTime();
        long FechaFinalMs = FechaFinal.getTime();
        long Diferencia = FechaFinalMs - FechaInicialMs;
        double Dias = Math.floor(Diferencia / (1000 * 60 * 60 * 24));
        return ((int) Dias);
    }
    
    public static Date StringADate(String Fecha)throws ParseException{
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
    Date FechaSalida = formato.parse(Fecha);
    return FechaSalida;
    }
    
    public void LecturaTxtClientes(){
        try {
            ArchivoEntrada Clientes = new ArchivoEntrada("clientes.txt");
            int cantClientes = 0;
            
            while(!Clientes.isEndFile()){
                Registro regCliente = Clientes.getRegistro();
                
                // Se obtienen los datos
                String RUT      = regCliente.getString();
                String Nombre   = regCliente.getString();
                String Apellido = regCliente.getString();
                String Celular  = regCliente.getString();
                String Mail     = regCliente.getString();
                
                Cliente cliente = new Cliente(RUT, Nombre, Apellido, Celular, Mail);
                System.out.println(cliente.getApellido());
                // Se almacenan los datos
                listaClientes.ingresarCliente(cliente);
                
                
                cantClientes++;}
            Clientes.close();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void LecturaTxtLibros(){
        try {
            ArchivoEntrada Libros = new ArchivoEntrada("libros.txt");
            int cantLibros = 0;
            
            while(!Libros.isEndFile()){
                Registro regLibro = Libros.getRegistro();
                
                // Se obtienen los datos
                String ISBN   = regLibro.getString();
                String Titulo = regLibro.getString();
                String Autor  = regLibro.getString();
                String Año    = regLibro.getString();
                
                
                Libro libro = new Libro(ISBN, Titulo, Autor, Año);
                System.out.println(libro.getISBN());
                // Se almacenan los datos
                listaLibros.ingresarLibro(libro); //arreglar
                
                cantLibros++;}
            Libros.close();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void LecturaTxtPrestamos(){
        try {
            ArchivoEntrada Prestamos = new ArchivoEntrada("prestamos.txt");
            int cantPrestamos = 0;
            
            while(!Prestamos.isEndFile()){
                Registro regPrestamo = Prestamos.getRegistro();
                
                // Se obtienen los datos
                int NumReg              = regPrestamo.getInt();
                String Rut              = regPrestamo.getString();
                String ISBN             = regPrestamo.getString();
                String FechaPedido      = regPrestamo.getString();
                String FechaDevolucion  = regPrestamo.getString();
                String FechaDevuelto    = regPrestamo.getString();
                
                
                Prestamo prestamo = new Prestamo(NumReg,Rut,ISBN, FechaPedido, FechaDevolucion, FechaDevuelto);
                System.out.println(prestamo.getISBN());
                // Se almacenan los datos
                listaPrestamos.ingresarPrestamo(prestamo); //arreglar
                
                cantPrestamos++;}
            Prestamos.close();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // RF1
    public void RF1(){
        
        int i;
        int DeudaTotal=0;
        StdOut.println("RF1");
        StdOut.println("Ingrese Rut cliente:");
        String RutIngresado = StdIn.readString();
        
        StdOut.println(listaPrestamos.getCantidadPrestamos());
        //int [] ArrayDeudas = new int[ListaP.getCantidadPrestamos()];
        StdOut.println("Cliente: "+listaClientes.encontrarCliente(RutIngresado).getNombre()+" | RUT: "+RutIngresado);
        for(i=0;i<listaPrestamos.getCantidadPrestamos();i++){
            if(RutIngresado.equals(listaPrestamos.getPrestamoI(i).getRUT())){
                try {
                    int CodigoPrestamo = listaPrestamos.getPrestamoI(i).getNumReg();
                    Date FechaPrestamo = StringADate(listaPrestamos.getPrestamoI(i).getFechaPedido());
                    Date FechaDevoEstimada = StringADate(listaPrestamos.getPrestamoI(i).getFechaDevolucion());
                    
                    if(listaPrestamos.getPrestamoI(i).getFechaDevuelto().equals("0")){
                        int Deuda = 0;
                        DeudaTotal +=Deuda;
                        StdOut.println("CP: "+CodigoPrestamo+" | FPrestamo: "+FechaPrestamo+" | FDEst: "+FechaDevoEstimada+" | FDReal: No hay");
                        StdOut.println("Dif dias: 0"+" Deuda: "+Deuda);
                    }
                    else{
                        Date FechaDevoReal = StringADate(listaPrestamos.getPrestamoI(i).getFechaDevuelto());
                        int DiferenciaDias = DiferenciaDiasDeFechas(FechaDevoEstimada,FechaDevoReal);
                        int Deuda = Deuda(DiferenciaDias);
                        DeudaTotal +=Deuda;
                        StdOut.println("CP: "+CodigoPrestamo+" | FPrestamo: "+FechaPrestamo+" | FDEst: "+FechaDevoEstimada+" | FDReal: "+FechaDevoReal);
                        StdOut.println("Dif dias: "+DiferenciaDias+" Deuda: "+Deuda);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        StdOut.println("Deuda Total: "+DeudaTotal);
    }
    
    // RF2
    public void RF2(){
        
        try {
            int i,j;
            String [] ArrayAuxISBNLibro = new String[listaLibros.getCantidadLibros()];
            int [] ArrayAuxCant = new int[listaLibros.getCantidadLibros()];
            for (i = 0; i < listaLibros.getCantidadLibros(); i++) {
                ArrayAuxISBNLibro[i] = listaLibros.getLibroI(i).getISBN();
                ArrayAuxCant[i] = 0;
            }   StdOut.println("RF2");
            StdOut.println("Ingrese Fecha Inicial: ");
            String FechaInicial = StdIn.readString();
            Date FInicial = StringADate(FechaInicial);
            StdOut.println("Ingrese Fecha Final: ");
            String FechaFinal = StdIn.readString();
            Date FFinal = StringADate(FechaFinal);
            for (i = 0; i < listaLibros.getCantidadLibros(); i++) {
                for (j = 0; j < listaPrestamos.getCantidadPrestamos(); j++) {
                    Date AuxFecha = StringADate(listaPrestamos.getPrestamoI(j).getFechaPedido());
                    if (ComparadorRangoFechas(AuxFecha, FInicial, FFinal)==true) {
                        if(ArrayAuxISBNLibro[i].equals(listaPrestamos.getPrestamoI(j).getISBN())){
                            ArrayAuxCant[i] += 1;
                        }
                    }
                }
            }   for(i=0;i<ArrayAuxISBNLibro.length;i++){
                StdOut.println(ArrayAuxISBNLibro[i]+"     "+ArrayAuxCant[i]);
            }   //ordenamiento
            for(i = 0; i<=ArrayAuxCant.length-2;i++){
                for(j = i+1; j<=ArrayAuxCant.length-1;j++){
                    if(ArrayAuxCant[i]<ArrayAuxCant[j]){
                        
                        String auxISBN; int auxC;
                        
                        auxISBN             = ArrayAuxISBNLibro[i];
                        ArrayAuxISBNLibro[i]       = ArrayAuxISBNLibro[j];
                        ArrayAuxISBNLibro[j]       = auxISBN;
                        
                        auxC               = ArrayAuxCant[i];
                        ArrayAuxCant[i]   = ArrayAuxCant[j];
                        ArrayAuxCant[j]   = auxC;
                        
                    }
                }
            }   StdOut.println("");
            for(i=0;i<ArrayAuxISBNLibro.length;i++){
                StdOut.println(ArrayAuxISBNLibro[i]+"     "+ArrayAuxCant[i]);
            }   StdOut.println("");
            //impresion con valores repetidos
            for(i=0;i<ArrayAuxISBNLibro.length;i++){
                if(i==0){
                    StdOut.println(ArrayAuxISBNLibro[i]+"    "+ArrayAuxCant[i]);
                }
                else{
                    if(ArrayAuxCant[i]==ArrayAuxCant[i-1]){
                        StdOut.println(ArrayAuxISBNLibro[i]+"    "+ArrayAuxCant[i]);
                    }
                    if(ArrayAuxCant[i]!=ArrayAuxCant[i-1]){break;}
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    //RF3
    public void RF3(){
        int i,j;
        int cantzero=0;
        int indice = 0;
        
        for(i=0;i<listaPrestamos.getCantidadPrestamos();i++){
            if(listaPrestamos.getPrestamoI(i).getFechaDevuelto().equals("0")){
                cantzero++;
            }
        }
        
        String [] RUTs = new String[cantzero];
        int [] CodUnicoPrestamo = new int[cantzero];
        Date [] FechaDevEstimada = new Date[cantzero];
        
        for(i=0;i<listaPrestamos.getCantidadPrestamos();i++){
            if(listaPrestamos.getPrestamoI(i).getFechaDevuelto().equals("0")){
                try {
                    RUTs[indice] = listaPrestamos.getPrestamoI(i).getRUT();
                    CodUnicoPrestamo[indice] = listaPrestamos.getPrestamoI(i).getNumReg();
                    FechaDevEstimada[indice] = StringADate(listaPrestamos.getPrestamoI(i).getFechaDevolucion());
                    indice++;
                } catch (ParseException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        for(i = 0; i<=FechaDevEstimada.length-2;i++){
            for(j = i+1; j<=FechaDevEstimada.length-1;j++){
                if(FechaDevEstimada[i].after(FechaDevEstimada[j])){
                
                    Date auxDate; int auxCodU; String auxRut;
                    auxDate                   = FechaDevEstimada[i];
                    FechaDevEstimada[i]  = FechaDevEstimada[j];
                    FechaDevEstimada[j]  = auxDate;
                    
                    auxCodU = CodUnicoPrestamo[i];
                    CodUnicoPrestamo[i] = CodUnicoPrestamo[j];
                    CodUnicoPrestamo[j] = auxCodU;
                    
                    auxRut = RUTs[i];
                    RUTs[i] = RUTs[j];
                    RUTs[j] = auxRut;
                }	
            }
        }
        
        for(i=0;i<FechaDevEstimada.length;i++){
        StdOut.println((i+1)+" // "+CodUnicoPrestamo[i]+" // "+RUTs[i]+" // "+FechaDevEstimada[i]);
        }

    }
    
}
