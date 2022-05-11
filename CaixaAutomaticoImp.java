/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class CaixaAutomaticoImp extends UnicastRemoteObject implements CaixaAutomatico{

    protected CaixaAutomaticoImp() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
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
    public Double saldo(int idConta) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "CaixaAutomaticoImp []";
    }

    
}