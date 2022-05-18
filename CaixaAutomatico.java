/**
    Interface CaixaAutomatico com assinatura dos métodos 
 */

import java.rmi.*;

public interface CaixaAutomatico {
    public Boolean depositar (double deposita, String cpf, String opId) throws RemoteException; //nao idempotentes
    public Boolean retirar (double retira, String cpf, String opId) throws RemoteException;  //nao idempotentes
    public Double saldo (String cpf) throws RemoteException;    
}
