import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroConta cadastroConta = new CadastroConta();

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Visualizar saldo");
            System.out.println("6. Histórico de transações");
            System.out.println("7. Listar contas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do titular: ");
                    String nomeTitular = scanner.nextLine();
                    System.out.print("Tipo de conta (C - Corrente, P - Poupança): ");
                    char tipoConta = scanner.next().charAt(0);
                    System.out.print("Digite o valor inicial: ");
                    double valorInicial = scanner.nextDouble();
                    scanner.nextLine();
                    String numeroConta = "BU" + (int) (Math.random() * 1000); // Polimorfismo
                    if (tipoConta == 'C' || tipoConta == 'c') {
                        ContaCorrente novaContaCorrente = new ContaCorrente(nomeTitular, numeroConta);
                        novaContaCorrente.depositar(valorInicial);
                        cadastroConta.adicionarConta(novaContaCorrente);
                        System.out.println("Conta criada com sucesso. Número da conta: " + numeroConta);
                    } else if (tipoConta == 'P' || tipoConta == 'p') {
                        ContaPoupanca novaContaPoupanca = new ContaPoupanca(nomeTitular, numeroConta);
                        novaContaPoupanca.depositar(valorInicial);
                        cadastroConta.adicionarConta(novaContaPoupanca);
                        System.out.println("Conta criada com sucesso. Número da conta: " + numeroConta);
                    } else {
                        System.out.println("Tipo de conta inválido.");
                    }
                    break;
                case 2:
                    System.out.println("De qual conta deseja depositar?");
                    String contaDepositoString = scanner.nextLine();
                    ContaBancaria contaDeposito = cadastroConta.buscarConta(contaDepositoString);

                    System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    contaDeposito.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso.");
                    break;
                case 3:
                    System.out.println("De qual conta deseja sacar?");
                    String contaSaqueString = scanner.nextLine();
                    ContaBancaria contaSaque = cadastroConta.buscarConta(contaSaqueString);

                    System.out.print("Digite o valor a sacar: ");
                    double valorSaque = scanner.nextDouble();
                    contaSaque.sacar(valorSaque);
                    break;
                case 4:
                    System.out.println("De qual conta deseja transferir?");
                    String contaTransferenciaSaque = scanner.nextLine();
                    ContaBancaria contaDeduzida = cadastroConta.buscarConta(contaTransferenciaSaque);

                    System.out.println("Para qual conta deseja transferir?");
                    String contaTransferenciaDeposito = scanner.nextLine();
                    ContaBancaria contaAdicionada = cadastroConta.buscarConta(contaTransferenciaDeposito);

                    System.out.print("Digite o valor a transferir: ");
                    double valorTransferencia = scanner.nextDouble();
                    contaDeduzida.transferir(contaAdicionada, valorTransferencia);
                    break;
                case 5:
                    System.out.println("De qual conta deseja ver saldo?");
                    String contaSaldoString = scanner.nextLine();
                    ContaBancaria contaSaldo = cadastroConta.buscarConta(contaSaldoString);

                    System.out.println("Saldo: " + contaSaldo.getSaldo());
                    break;
                case 6:
                    System.out.println("De qual conta deseja ver histórico?");
                    String contaHistoricoString = scanner.nextLine();
                    ContaBancaria contaHistorico = cadastroConta.buscarConta(contaHistoricoString);

                    System.out.println("Histórico de transações:");
                    contaHistorico.mostrarHistorico();
                    break;
                case 7:
                    cadastroConta.listarContas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}