/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class AdministracaoImp extends UnicastRemoteObject implements Administracao{

    HashMap<String, Conta> map = new HashMap<>();
    protected AdministracaoImp() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub

    }
    @Override
    public Boolean abrirConta(String nome, String cpf, Boolean agencia) throws RemoteException {
        if(agencia){
            if(autenticarConta(cpf)){return false;}
            Conta c = new Conta(nome, cpf);
            map.put(cpf, c);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean fecharConta(String cpf, Boolean agencia) throws RemoteException {
        if(agencia){
            if(!autenticarConta(cpf)){return false;}
            map.remove(cpf);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean autenticarConta(String cpf) throws RemoteException {
        if(map.containsKey(cpf)){return true;}
        return false;
    }
    
    @Override
    public Boolean depositar(double deposita, String cpf) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Boolean retirar(double retira, String cpf) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }


  

    
}