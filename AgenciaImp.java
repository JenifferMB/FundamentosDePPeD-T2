/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class AgenciaImp extends UnicastRemoteObject implements Agencia{

    protected AgenciaImp() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
    }

    @Override
    public int abrirConta(String nome, int cpf) throws RemoteException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Boolean fecharConta(int idConta) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean autenticarConta(int idConta) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double depositar(double deposita) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double retirar(double retira) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double saldo(int idConta) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

  
}
