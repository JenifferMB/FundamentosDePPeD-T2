public class Conta {
    //nome, cpf, saldo
    private String nome;
    private int id=0;
    private Double saldo;

    public Conta(String nome, int id, Double saldo) {
        this.nome = nome;
        this.id += 1;
        this.saldo = saldo;
    }

}
