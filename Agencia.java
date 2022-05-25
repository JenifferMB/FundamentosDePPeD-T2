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
            Administracao a =  (Administracao) Naming.lookup("rmi://localhost:1099/AdminService");//linka com o server
            a.conectar(s + id++);//chama o metodo conectar, passando o opId de controle
   
            boolean exec = true;
            Scanner n = new Scanner(System.in);
            String iaux;
            Double vaux;
            String nomeaux;
            while (exec) {
                System.out.println();
                System.out.println("1 - AbrirConta");
                System.out.println("2 - Fechar Conta");
                System.out.println("3 - Autenticar Conta");
                System.out.println("4 - Deposito");
                System.out.println("5 - Saque");
                System.out.println("6 - Consulta Saldo");
                System.out.println("0 - sair");
                System.out.println("9 - deposito com injecao de falhas");
            

                int key = n.nextInt();
                n.nextLine();
                switch (key) {
                    case 1://abrir
                    System.out.println("Digite seu identificador (cpf):");
                    iaux = n.nextLine();
                    System.out.println("\nDigite seu nome:");
                    nomeaux=n.nextLine();

                    if(a.abrirConta(nomeaux, iaux, true, s + id++)){
                        System.out.println("\nConta aberta com sucesso!");
                    }else{
                        System.out.println("\nErro na abertura de conta!");
                    }
                    
                    break;

                    case 2://fechar
                    System.out.println("Digite o identificador da conta (cpf): ");
                    iaux = n.nextLine();

                    if(a.fecharConta(iaux, true, s + id++)){
                        System.out.println("\nConta encerrada com sucesso!");
                    }else{
                        System.out.println("\nErro no encerramento de conta!");
                    }

                    
                    break;

                    case 3://autenticar
                    System.out.println("Digite o identificador da conta (cpf): ");
                    iaux = n.nextLine();
                    
                    if(a.autenticarConta(iaux)){
                        System.out.println("\nConta existente!");
                    }else{
                        System.out.println("\nConta nao existente!");
                    } 
                    
                    break;

                    case 4://deposito
                    System.out.println("Digite o identificador da conta (cpf): ");
                    iaux = n.nextLine();
                    System.out.println("Digite o valor a ser depositado: ");
                    vaux = n.nextDouble();
                                        
                    if(a.deposito(vaux, iaux, s + id++)){
                        System.out.println("Deposito realizado com sucesso!");
                    }else{
                        System.out.println("Erro ao realizar o deposito!");
                    }
                    break;

                    case 5://saque
                    System.out.println("Digite o identificador da conta (cpf): ");
                    iaux = n.nextLine();
                    System.out.println("Digite o valor a ser sacado: ");
                    vaux = n.nextDouble();

                    if(a.saque(vaux, iaux, s + id++)){
                        System.out.println("Saque realizado com sucesso!");
                    }else{
                        System.out.println("Erro ao realizar o saque!");
                    }
                    break;

                    case 6://consulta
                    System.out.println("Digite o identificador da conta (cpf): ");
                    iaux = n.nextLine();
                    System.out.print("\nSaldo disponível: ");
                    System.out.println(a.ConsultaSaldo(iaux));//printa o double
                    System.out.println();
                    break;

                    case 9://deposito com injeção de falhas
                    System.out.println("Deposito com injeção de falhas:");
                    System.out.println("Digite o identificador da conta (cpf): ");
                    iaux = n.nextLine();
                    System.out.println("Digite o valor a ser depositado: ");
                    vaux = n.nextDouble(); 
                    String opID =s + id++;

                    if(a.deposito(vaux, iaux, opID)){
                        System.out.println("Deposito realizado com sucesso!");
                    }else{
                        System.out.println("Erro ao realizar o deposito!");
                    }
                    System.out.println("Espera 5 segundos e entao");
                    System.out.println("Repete a chamada com o mesmo opID");
                    System.out.println("Vai gerar excecao");
                    Thread.sleep(5000);

                    
                    if(a.deposito(vaux, iaux, opID)){
                        System.out.println("Deposito realizado com sucesso!");
                    }else{
                        System.out.println("Erro ao realizar o deposito!");
                    }

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

