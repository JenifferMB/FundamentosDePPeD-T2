/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.Naming;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Agencia extends UnicastRemoteObject{

    private static final String s= "Agencia, op:";
    private static int id =0;
    

    protected Agencia() throws RemoteException {
        super();
    }
        
    

    public static void main(String[] args) {
        
        try {
            //Procura pelo servico de admin no IP e porta definidos
            Administracao a = (Administracao) Naming.lookup("rmi://localhost:1099/AdminService");//linka com o server
            a.conectar(s + id++);//chama o metodo conectar, passando o opId de controle
   
            
            System.out.println("1 - AbrirConta");
            System.out.println("2 - Fechar Conta");
            System.out.println("3 - Autenticar Conta");
            System.out.println("4 - Depósito");
            System.out.println("5 - Saque");
            System.out.println("6 - Consulta Saldo");
            System.out.println("0 - sair");
            boolean exec = true;
            Scanner n = new Scanner(System.in);
            String iaux;
            Double vaux;
            String nomeaux;
            while (exec) {

                int key = n.nextInt();
                switch (key) {
                    case 1://abrir
                    System.out.println("Digite seu identificador (cpf):");
                    iaux = n.next();
                    System.out.println("Digite seu nome:");
                    nomeaux=n.nextLine();
                    a.abrirConta(nomeaux, iaux, true, s + id++);
                    break;

                    case 2://fechar
                    System.out.println("Digite o identificador da conta (cpf): ");
                    iaux = n.next();
                    a.fecharConta(iaux, true, s + id++);
                    break;

                    case 3://autenticar
                    System.out.println("Digite o identificador da conta (cpf): ");
                    iaux = n.next();
                    a.autenticarConta(iaux);
                    break;

                    case 4://deposito
                    System.out.println("Digite o identificador da conta (cpf): ");
                    iaux = n.next();
                    System.out.println("Digite o valor a ser depositado: ");
                    vaux = n.nextDouble();
                    a.depositar(vaux, iaux, s + id++);
                    break;

                    case 5://saque
                    System.out.println("Digite o identificador da conta (cpf): ");
                    iaux = n.next();
                    System.out.println("Digite o valor a ser depositado: ");
                    vaux = n.nextDouble();
                    a.retirar(vaux, iaux, s + id++);
                    break;

                    case 6://consulta
                    System.out.println("Digite o identificador da conta (cpf): ");
                    iaux = n.next();
                    System.out.print("Saldo disponível: ");
                    System.out.println(a.ConsultaSaldo(iaux));//printa o double
                    break;

                    case 0://sair
                    exec=false;
                
                    default:
                    break;
                }
            
            }} catch (Exception e) {
                e.printStackTrace();
                }
    }
  
}

