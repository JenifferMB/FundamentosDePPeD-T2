/**
    Interface Agencia com assinatura dos métodos 
 */

import java.rmi.*;

public interface Agencia extends Remote {
    public Boolean abrirConta (String nome, int id, String opId) throws RemoteException; //nao idempotentes
    public Boolean fecharConta (int idConta, String opId) throws RemoteException;//
    public Boolean autenticarConta (int idConta) throws RemoteException;
    public Boolean depositar (double deposita, String opId) throws RemoteException; //nao idempotentes
    public Boolean retirar (double retira, String opId) throws RemoteException;  //nao idempotentes
    public Double saldo (int idConta) throws RemoteException;    
}