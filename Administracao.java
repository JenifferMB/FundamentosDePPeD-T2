/**
    Interface Administracao com assinatura dos métodos 
 */

import java.rmi.*;


public interface Administracao {
    public Boolean abrirConta (String nome, String cpf, Boolean agencia, String opId) throws RemoteException;//
    public Boolean fecharConta (String cpf, Boolean agencia, String opId) throws RemoteException;//
    public Boolean autenticarConta (String cpf) throws RemoteException;
    public Boolean depositar (double deposita, String cpf, String opId) throws RemoteException;//
    public Boolean retirar (double retira, String cpf, String opId) throws RemoteException;//
    //definir quais que não podem ter problemas, idempotentes
}
