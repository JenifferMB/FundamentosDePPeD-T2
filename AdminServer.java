/**
 *  Servidor calculadora
 */

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;


public class AdminServer {
    
        public AdminServer(){
            try {
                //Definicao do ip onde o servico ira funcionar
                System.setProperty("java.rmi.server.hostname", "localhost");
                //Registro do servico em uma porta
                LocateRegistry.createRegistry(1099);
                //Cria o objeto que implementa os metodos que serao servidos
                AdministracaoImp adm = new AdministracaoImp();
                //Coloca na porta registrada o servico da administração
                Naming.bind("AdminService", (Remote) adm);
                System.out.println("Conexao estabelecida.");
    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            new AdminServer();
        }
}
