package pspact3;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Raúl
 */
public interface Mensaje extends Remote{
    
    public String longuitud(String entrada)throws RemoteException;
    public String longuitudSinEspacios(String entrada)throws RemoteException;
    public String nPalabras(String entrada)throws RemoteException;
    public String nVocales(String entrada)throws RemoteException;
    public String invertir(String entrada)throws RemoteException;
    public String mayusculas(String entrada)throws RemoteException;
    public String minusculas(String entrada)throws RemoteException;
    public void apagarServidor()throws RemoteException;
    
    
}
