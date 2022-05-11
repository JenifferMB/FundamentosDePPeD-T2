/**
    Interface Administracao com assinatura dos métodos 
 */

import java.rmi.*;


public interface Administracao {
    public Boolean abrirConta (String nome, int cpf, char agencia) throws RemoteException;
    public Boolean fecharConta (int idConta, char agencia) throws RemoteException;
    public Boolean autenticarConta (int idConta) throws RemoteException;
    public Boolean depositar (double deposita) throws RemoteException;
    public Boolean retirar (double retira) throws RemoteException;
    //definir quais que não podem ter problemas, idempotentes
}
