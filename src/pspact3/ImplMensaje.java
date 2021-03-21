
package pspact3;

import java.rmi.*;
import java.rmi.server.*;


/**
 *
 * @author Raúl
 */
public class ImplMensaje extends UnicastRemoteObject implements Mensaje{
    
    public ImplMensaje() throws RemoteException{
        
        super();
    }
 
    @Override
    public String longuitud(String entrada) throws RemoteException{
        
        int largo = entrada.length();
        
        String salida = "La longuitud de la frase contando los espacios es: " + 
                largo;

        return salida;
    }
    
    @Override
    public String longuitudSinEspacios(String entrada)throws RemoteException{
        
        String salida;
        
        String [] lista = entrada.split(" ");
        
        int largo = 0;
        
        for(int i = 0; i < lista.length; i++){
            
            largo += lista[i].length();
        }
        
        salida = "La longuitud de la frase sin espacios es: " + largo;
        
        return salida;
    }
    
    @Override
    public String nPalabras(String entrada)throws RemoteException{
        
        String salida = "El numero de palabras es: ";
        
        String [] lista = entrada.split(" ");
        
        int largo = lista.length;
        
        return salida + largo;
    }
    
    @Override
    public String nVocales(String entrada)throws RemoteException{
        
        String salida = "El numero de vocales es: ";
        
        String [] lista = entrada.split("");
        
        int contador = 0;
        
        for(String i:lista){
            
            if(i.equalsIgnoreCase("a")){
              contador ++;  
            }else if(i.equalsIgnoreCase("e")){
                contador++;
            }else if(i.equalsIgnoreCase("i")){
                contador++;
            }else if (i.equalsIgnoreCase("o")){
                contador++;
            }else if(i.equalsIgnoreCase("u")){
                contador++;
            }
        }
        
        return salida + contador;
    }

    @Override
    public String invertir(String entrada)throws RemoteException{
        
        StringBuilder sb = new StringBuilder(entrada);
        
        String salida = sb.reverse().toString();
        
        return salida;
    }
    
    @Override
    public String mayusculas(String entrada)throws RemoteException{
        
        String salida = entrada.toUpperCase();
        
        return salida;
    }
    
    @Override
    public String minusculas(String entrada)throws RemoteException{
        
        String salida = entrada.toLowerCase();
        
        return salida; 
    }
    
    @Override
    public void apagarServidor()throws RemoteException{
        
        System.out.println("\nFin ejecucion servidor");
        System.out.println("Hasta pronto de parte del servidor");
        System.exit(0);
    }   
}
