import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o limite do cartão: ");
        double limite = leitura.nextDouble();
        leitura.nextLine(); // limpa enter

        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {

            System.out.println("Digite a descrição da compra:");
            String descricao = leitura.nextLine();

            System.out.println("Digite o valor da compra:");
            double valor = leitura.nextDouble();
            leitura.nextLine(); // limpa enter

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.fazCompra(compra);

            if (compraRealizada) {
                System.out.println("Sua compra foi realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar:");

                String entrada = leitura.nextLine();
                try {
                    sair = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Encerrando aplicação.");
                    sair = 0;
                }
            } else {
                System.out.println("Seu saldo é insuficiente!");
                sair = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");

        Collections.sort(cartao.getCompras());

        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }

        System.out.println("\n***********************");
        System.out.println("\nSaldo do cartão: " + cartao.getSaldo());
    }
}