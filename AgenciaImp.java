/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class AgenciaImp extends UnicastRemoteObject implements Agencia{

    private String s= "agencia";
    private int id =0;

    protected AgenciaImp() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
    }
        
    @Override
    public Boolean abrirConta(String nome, int id, String opId) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Boolean fecharConta(int idConta, String opId) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Boolean autenticarConta(int idConta) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Boolean depositar(double deposita, String opId) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Boolean retirar(double retira, String opId) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Double saldo(int idConta) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    
  
}
