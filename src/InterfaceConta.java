public interface InterfaceConta {
    void depositar(double valor);

    boolean sacar(double valor);

    void transferir(ContaBancaria destino, double valor);

    public void mostrarHistorico();
}
