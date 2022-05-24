/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class AdministracaoImp extends UnicastRemoteObject implements Administracao{

    HashMap<String, Conta> map = new HashMap<>();
    HashMap<String, Character> idempotencia= new HashMap<>();

    protected AdministracaoImp() throws RemoteException {
        super();
    }

    @Override
    public Boolean abrirConta(String nome, String cpf, Boolean agencia, String opId) throws RemoteException {
        if(idempotencia.containsKey(opId)){//se for operação repetida
            throw new RemoteException("operação de abrir conta repetida");//gera exceção
        }
        
        if(agencia){//se for agencia, pode abrir uma conta
            if(autenticarConta(cpf)){return false;}//se a conta ja existe, não cria outra
            Conta c = new Conta(nome, cpf);
            map.put(cpf, c);
            System.out.println("aberto com sucesso");//print de confirmação no terminal do server
            idempotencia.put(opId, 'a');//adiciona a identificação de operação na estrutura de salvamento
            return true;
        }
        //se não for agencia, não pode abrir uma conta
        return false;
    }

    @Override
    public Boolean fecharConta(String cpf, Boolean agencia, String opId) throws RemoteException {
        if(idempotencia.containsKey(opId)){//se for operação repetida
            throw new RemoteException("operação de fechar repetida");//gera exceção
        }

        if(agencia){//se for agencia, pode abrir uma conta
            if(autenticarConta(cpf)==false){return false;}//se a conta não existe, não tem como fechar
            map.remove(cpf);
            System.out.println("fechado com sucesso");//print de confirmação no terminal do server
            idempotencia.put(opId, 'a');//adiciona a identificação de operação na estrutura de salvamento
            return true;
        }
        //se não for agencia, não pode abrir uma conta
        return false;
    }

    @Override
    public Boolean autenticarConta(String cpf) throws RemoteException {
        if(map.containsKey(cpf)){//se a conta existe
            System.out.println("autenticado com sucesso");//print de confirmação no terminal do server
            return true;
        }
        return false;
    }

    @Override
    public Boolean deposito(double valor, String cpf, String opId) throws RemoteException {
        if(idempotencia.containsKey(opId)){//se for operação repetida
            throw new RemoteException("operação de deposito repetida");//gera exceção
        }
        
        if(valor<0){return false;}//se for valor invalido
        if(autenticarConta(cpf)==false){return false;}//se a conta não existe, não tem como depositar
        Conta c = map.get(cpf);             
        double aux = c.getSaldo()+valor;
        c.setSaldo(aux);
        System.out.println("depositado com sucesso");//print de confirmação no terminal do server
        idempotencia.put(opId, 'a');//adiciona a identificação de operação na estrutura de salvamento
        return true;
    }

    @Override
    public Boolean saque(double valor, String cpf, String opId) throws RemoteException {
        if(idempotencia.containsKey(opId)){//se for operação repetida
            throw new RemoteException("operação de retirada repetida");//gera exceção
        }
        
        if(autenticarConta(cpf)==false){return false;}//se a conta não existe, não tem como sacar
        Conta c = map.get(cpf);
        if(valor<0 || valor > c.getSaldo()){return false;}//se for valor invalido
        double aux = c.getSaldo()-valor;
        c.setSaldo(aux);
        System.out.println("retirado com sucesso");//print de confirmação no terminal do server
        idempotencia.put(opId, 'a');//adiciona a identificação de operação na estrutura de salvamento
        return true;
    }

    @Override
    public void conectar(String opId) throws RemoteException {
        idempotencia.put(opId, 'a');//adiciona a identificação de operação na estrutura de salvamento
        System.out.println("conectado com sucesso");//print de confirmação no terminal do server
    }

    @Override
    public Double ConsultaSaldo(String cpf) throws RemoteException {
        if(autenticarConta(cpf)==false){return -0.01;}
        System.out.println("consultado com sucesso");//print de confirmação no terminal do server
        return map.get(cpf).getSaldo();
    }


    
}