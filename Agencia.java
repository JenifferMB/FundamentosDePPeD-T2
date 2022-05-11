/**
    Interface Agencia com assinatura dos métodos 
 */

import java.rmi.*;

public interface Agencia extends Remote {
    public int abrirConta (String nome, int cpf) throws RemoteException;
    public Boolean fecharConta (int idConta) throws RemoteException;
    public Boolean autenticarConta (int idConta) throws RemoteException;
    public Double depositar (double deposita) throws RemoteException;
    public Double retirar (double retira) throws RemoteException;
    public Double saldo (int idConta) throws RemoteException;
}