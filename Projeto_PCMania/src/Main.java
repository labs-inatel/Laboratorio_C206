import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        Cliente total = new Cliente("Iza Lopes Ribeiro",1234567890);
        String nome1 = total.getNome();
        long cpf1 = total.getCpf();
        System.out.println("\nCliente: " + nome1 + ", CPF: " + cpf1);

        System.out.println("Bem-vindo a PC Mania!");
        System.out.println("\nVenha conferir nossas promoções:"); // mostrar as promoções

        Computador promocao = new Computador();

        Computador carrinho1 = new Computador();
        Computador carrinho2 = new Computador();
        Computador carrinho3 = new Computador();

        carrinho1.preco = 1300;
        carrinho2.preco = 1800;
        carrinho3.preco = 2800;

        promocao.mostraPCConfigs();

        System.out.println("\nPor favor, digite os seguintes códigos para compra dos produtos de nossa loja:");
        System.out.println("\n1 - promocao 1: R$ " + carrinho1.preco);
        System.out.println("2 - promocao 2: R$ " + carrinho2.preco);
        System.out.println("3 - promocao 3: R$ " + carrinho3.preco);

        System.out.println("\nCaso queira finalizar compras, por favor digite 0.");
        Scanner entrada = new Scanner(System.in);
        int entrada01 = entrada.nextInt();

        while(entrada01 == 1 || entrada01 == 2 || entrada01 == 3){

            if (entrada01 == 1) {
                total.soma = total.CalculaTotalCompra(carrinho1.preco);
                System.out.println("\nAcrescentado ao carrinho de compras!\n");
            }
            if (entrada01 == 2) {
                total.soma = total.CalculaTotalCompra(carrinho2.preco);
                System.out.println("\nAcrescentado ao carrinho de compras!\n");
            }
            if (entrada01 == 3) {
                total.soma = total.CalculaTotalCompra(carrinho3.preco);
                System.out.println("\nAcrescentado ao carrinho de compras!\n");
            }
            entrada01 = entrada.nextInt();
        }
        entrada.nextLine();

        System.out.println("Valot total da compra efetuada: R$ " + total.soma);
    }
}
