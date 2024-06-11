import java.util.ArrayList;

class CadastroConta {
    private ArrayList<ContaBancaria> contas;

    public CadastroConta() {
        contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            System.out.println("Lista de contas cadastradas:");
            for (ContaBancaria conta : contas) {
                System.out.println("Titular: " + conta.getTitular() + ", Número da Conta: " + conta.getNumeroConta());
            }
        }
    }
}