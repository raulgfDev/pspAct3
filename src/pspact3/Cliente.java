package pspact3;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Raúl
 */
public class Cliente {
    
    public static void main(String[] args) {
        
        try {
            
            Registry registro = LocateRegistry.getRegistry("localhost",5555);
            
            Mensaje objeto = (Mensaje) registro.lookup("Mensaje");
            
            Scanner sc = new Scanner(System.in);
            
            String entrada,frase;
            
            do { 
                
                System.out.println("Escriba la operacion a realizar:");
                
                System.out.println("(L)onguitud || (P)alabras || (V)ocales || "
                        + "(I)nvertir || (M)ayusculas || (m)inusculas || "
                        + "(F)in");
                entrada = sc.nextLine();
                
                if(compruebaEntrada(entrada)){

                    System.out.println("\nEscribe frase:");
                    frase = sc.nextLine();
                    System.out.println(selectorMetodoRemoto(entrada, frase, objeto));

                    System.out.println("============================\n");
                    
                }else if(!entrada.equalsIgnoreCase("f")){
                    
                    System.out.println("Operación no existente");
                }

            } while (!entrada.equalsIgnoreCase("F"));
        
            System.out.println("Hasta pronto desde el cliente");
            
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }
    
    public static String selectorMetodoRemoto(String entrada,String frase,Mensaje o) throws RemoteException{
        
        String salida = null;
        
        if(entrada.equalsIgnoreCase("L")){
            salida = o.longuitud(frase) + "\n" + o.longuitudSinEspacios(frase);
        }else if(entrada.equalsIgnoreCase("P")){
            salida = o.nPalabras(frase);
        }else if(entrada.equalsIgnoreCase("V")){
            salida = o.nVocales(frase);
        }else if(entrada.equalsIgnoreCase("I")){
            salida = o.invertir(frase);
        }else if(entrada.equals("M")){
            salida = o.mayusculas(frase);
        }else if(entrada.equals("m")){
            salida = o.minusculas(frase);
        }
        
        return salida;
    }
    
    public static boolean compruebaEntrada(String entrada){
        
        boolean salida = false;
        
        if(entrada.equalsIgnoreCase("L"))salida = true;
        else if(entrada.equalsIgnoreCase("P"))salida = true;
        else if(entrada.equalsIgnoreCase("V"))salida = true;
        else if(entrada.equalsIgnoreCase("I"))salida = true;
        else if(entrada.equals("M"))salida = true;
        else if(entrada.equals("m"))salida = true;

        return salida;
    }
}
                    