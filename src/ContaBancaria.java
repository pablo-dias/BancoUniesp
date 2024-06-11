import java.util.ArrayList;

class ContaBancaria implements InterfaceConta {
    private String titular;
    private double saldo;
    private ArrayList<Transacao> historico;
    private String numeroConta;

    public ContaBancaria(String titular, String numeroConta) {
        this.titular = titular;
        saldo = 0;
        historico = new ArrayList<>();
        this.numeroConta = numeroConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        historico.add(new Transacao("Depósito", valor));
    }
    @Override
    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            historico.add(new Transacao("Saque", valor));
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }
    @Override
    public void transferir(ContaBancaria destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            historico.add(new Transacao("Transferência para " + destino.getNumeroConta(), valor));
        }
    }
    @Override
    public void mostrarHistorico() {
        for (Transacao transacao : historico) {
            System.out.println(transacao.getDescricao() + ": " + transacao.getValor());
        }
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Transacao> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<Transacao> historico) {
        this.historico = historico;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
}