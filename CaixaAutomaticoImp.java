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
    public Boolean depositar(double deposita, String cpf, String opId) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean retirar(double retira, String cpf, String opId) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double saldo(String cpf) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

  public static void main(String[] args) {
      
    try {
        //Procura pelo servico de admin no IP e porta definidos
        Administracao a = (Administracao) Naming.lookup("rmi://localhost:1099/AdminService");

        /*
        System.out.println("1 - soma");
        System.out.println("2 - sub");
        System.out.println("3 - mult");
        System.out.println("4 - div");
        System.out.println("5 - store");
        System.out.println("6 - load");
        System.out.println("0 - sair");
        boolean exec = true;
        double result;
        while (exec) {

            int key = in.nextInt();
            switch (key) 
        }
        */
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
    
    
}