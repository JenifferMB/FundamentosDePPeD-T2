/**
    Interface Administracao com assinatura dos métodos 
 */

import java.rmi.*;


public interface Administracao extends Remote{
    public void    conectar(String opId) throws RemoteException;//pra simular injeção de falhas
    public Boolean abrirConta (String nome, String cpf, Boolean agencia, String opId) throws RemoteException;//
    public Boolean fecharConta (String cpf, Boolean agencia, String opId) throws RemoteException;//
    public Boolean autenticarConta (String cpf) throws RemoteException;
    public Boolean deposito (double valor, String cpf, String opId) throws RemoteException;//
    public Boolean saque (double valor, String cpf, String opId) throws RemoteException;//
    public Double ConsultaSaldo(String cpf) throws RemoteException;
    //definir quais que não podem ter problemas, idempotentes
}
