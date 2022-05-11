/**
    Interface CaixaAutomatico com assinatura dos métodos 
 */

import java.rmi.*;

public interface CaixaAutomatico {
    public Boolean depositar (double deposita) throws RemoteException; //nao idempotentes
    public Boolean retirar (double retira) throws RemoteException;  //nao idempotentes
    public Double saldo (int idConta) throws RemoteException;    
}
