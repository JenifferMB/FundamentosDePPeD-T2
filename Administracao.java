/**
    Interface Administracao com assinatura dos métodos 
 */

import java.rmi.*;


public interface Administracao {
    public Boolean abrirConta (String nome, String cpf, Boolean agencia) throws RemoteException;
    public Boolean fecharConta (String cpf, Boolean agencia) throws RemoteException;
    public Boolean autenticarConta (String cpf) throws RemoteException;
    public Boolean depositar (double deposita, String cpf) throws RemoteException;
    public Boolean retirar (double retira, String cpf) throws RemoteException;
    //definir quais que não podem ter problemas, idempotentes
}
