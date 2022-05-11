/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class AdministracaoImp extends UnicastRemoteObject implements Administracao{

    protected AdministracaoImp() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
    }

    @Override
    public Boolean abrirConta(String nome, int id, char agencia) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean fecharConta(int idConta, char agencia) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean autenticarConta(int idConta) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean depositar(double deposita) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean retirar(double retira) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "AdministracaoImp []";
    }

    
}