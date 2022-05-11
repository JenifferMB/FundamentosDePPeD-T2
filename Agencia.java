/**
    Interface Agencia com assinatura dos métodos 
 */

import java.rmi.*;

public interface Agencia extends Remote {
    public Boolean abrirConta (String nome, int cpf) throws RemoteException; //nao idempotentes
    public Boolean fecharConta (int idConta) throws RemoteException;
    public Boolean autenticarConta (int idConta) throws RemoteException;
    public Boolean depositar (double deposita) throws RemoteException; //nao idempotentes
    public Boolean retirar (double retira) throws RemoteException;  //nao idempotentes
    public Double saldo (int idConta) throws RemoteException;    
}