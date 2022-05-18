/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class AdministracaoImp extends UnicastRemoteObject implements Administracao{

    HashMap<String, Conta> map = new HashMap<>();
    HashMap<String, Character> idempotencia= new HashMap<>();

    protected AdministracaoImp() throws RemoteException {
        super();
    }

    @Override
    public Boolean abrirConta(String nome, String cpf, Boolean agencia, String opId) throws RemoteException {
        if(idempotencia.containsKey(opId)){
            throw new RemoteException("operação de abrir repetida");
        }
        idempotencia.put(opId, 'a');
        if(agencia){
            if(autenticarConta(cpf)){return false;}
            Conta c = new Conta(nome, cpf);
            map.put(cpf, c);
            return true;
        }
        return false;
    }

    @Override
    public Boolean fecharConta(String cpf, Boolean agencia, String opId) throws RemoteException {
        if(idempotencia.containsKey(opId)){
            throw new RemoteException("operação de fechar repetida");
        }
        idempotencia.put(opId, 'a');

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
    public Boolean depositar(double deposita, String cpf, String opId) throws RemoteException {
        if(idempotencia.containsKey(opId)){
            throw new RemoteException("operação de deposito repetida");
        }
        idempotencia.put(opId, 'a');

        if(deposita<0){return false;}
        if(!autenticarConta(cpf)){return false;}
        Conta c = map.get(cpf);
        double aux = c.getSaldo()+deposita;
        c.setSaldo(aux);
        return true;
    }

    @Override
    public Boolean retirar(double retira, String cpf, String opId) throws RemoteException {
        if(idempotencia.containsKey(opId)){
            throw new RemoteException("operação de retirada repetida");
        }
        idempotencia.put(opId, 'a');

        if(!autenticarConta(cpf)){return false;}
        Conta c = map.get(cpf);
        if(retira<0 || retira > c.getSaldo()){return false;}
        double aux = c.getSaldo()-retira;
        c.setSaldo(aux);
        return true;
    }


    
}