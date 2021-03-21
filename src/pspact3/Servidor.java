package pspact3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Raúl
 */
public class Servidor {
    
    public static void main(String[] args) {
        
        try {
            
            Registry registro = LocateRegistry.createRegistry(5555);
            
            Mensaje objeto = new ImplMensaje();
            
            registro.rebind("Mensaje",objeto);
            
            System.out.println("Servidor en linea......");
            
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
}
