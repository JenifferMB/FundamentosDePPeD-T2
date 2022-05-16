public class Conta {
    //nome, cpf, saldo
    private String nome;
    private String id;
    private Double saldo;

    public Conta(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.saldo = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta [id=" + id + ", nome=" + nome + ", saldo=" + saldo + "]";
    }

    
}
