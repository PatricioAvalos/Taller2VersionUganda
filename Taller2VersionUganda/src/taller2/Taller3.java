/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2;

import java.io.*;
import ucn.*;
import java.util.*;
import java.text.*;


/**
 *
 * @author D4C
 */
public class Taller3 {
     

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.LecturaTxtClientes();
        app.LecturaTxtLibros();
        app.LecturaTxtPrestamos();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("=========================================");
    System.out.println("     Taller 2     ");
    System.out.println("=========================================");
    System.out.println(" (1) - RF1");
    System.out.println(" (2) - RF2" );
    System.out.println(" (3) - RF3" );    
        
    int op;
        do{  
            System.out.println("\nIngrese una opción del menú: " );
            op = Integer.parseInt(bf.readLine()); 
            switch(op){
                
                case 1: 
                    app.RF1();
                    System.out.println(" (1) - RF1");
                    System.out.println(" (2) - RF2" );
                    System.out.println(" (3) - RF3" ); 
                    break;
                case 2:
                    app.RF2();
                    System.out.println("");
                    System.out.println(" (1) - RF1");
                    System.out.println(" (2) - RF2" );
                    System.out.println(" (3) - RF3" ); 
                    break;
                case 3:
                    app.RF3();
                    System.out.println(" (1) - RF1");
                    System.out.println(" (2) - RF2" );
                    System.out.println(" (3) - RF3" ); 
                    break;    
                default:
                    System.out.println("OPCION NO VALIDA" );
                    break;               
            }
        }while( op != 4 );
     }
    
    }
    

