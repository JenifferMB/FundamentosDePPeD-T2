/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class CaixaAutomatico extends UnicastRemoteObject{
  protected CaixaAutomatico() throws RemoteException {
        super();
    }

public static void main(String[] args) {

    String s= "CaixaAutomatico";
    int id = 0;
      
    try {
        //Procura pelo servico de admin no IP e porta definidos
        Administracao a = (Administracao) Naming.lookup("rmi://localhost:1099/AdminService");//linka com o server
        a.conectar(s + id++);//chama o metodo conectar, passando o opId de controle

        
        System.out.println("1 - Depósito");
        System.out.println("2 - Saque");
        System.out.println("3 - Consulta Saldo");
        System.out.println("0 - sair");
        boolean exec = true;
        Scanner n = new Scanner(System.in);
        String iaux;
        Double vaux;
        while (exec) {

            int key = n.nextInt();
            switch (key) {
                case 1://deposito
                System.out.println("Digite o identificador da conta (cpf): ");
                iaux = n.next();
                System.out.println("Digite o valor a ser depositado: ");
                vaux = n.nextDouble();
                a.depositar(vaux, iaux, s + id++);
                break;

                case 2://saque
                System.out.println("Digite o identificador da conta (cpf): ");
                iaux = n.next();
                System.out.println("Digite o valor a ser depositado: ");
                vaux = n.nextDouble();
                a.retirar(vaux, iaux, s + id++);
                break;

                case 3://consulta
                System.out.println("Digite o identificador da conta (cpf): ");
                iaux = n.next();
                System.out.print("Saldo disponível: ");
                System.out.println(a.ConsultaSaldo(iaux));
                break;

                case 0://sair
                exec=false;

                default:
                break;
            }
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
    
    
}