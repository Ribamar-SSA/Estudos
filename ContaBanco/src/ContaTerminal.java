
import java.util.Scanner;

public class ContaTerminal {

    int numero;
    String agencia;
    String nomeCLiente;
    float saldo;


    public static void main(String[] args) {
        ContaTerminal primeiraConta = new ContaTerminal();
        Scanner entrada = new Scanner(System.in);

        System.out.println("digite o nome:");
        primeiraConta.nomeCLiente = entrada.next();

        System.out.println("digite a agencia:");
        primeiraConta.agencia = entrada.next();

        System.out.println("digite o numero:");
        primeiraConta.numero = entrada.nextInt();

        System.out.println("digite o saldo:");
        primeiraConta.saldo = entrada.nextFloat();



        System.out.printf("Olá %s, obrigado por criar uma " +
                        "conta em nosso banco, sua agência é %s, conta " +
                        "%d e seu saldo %.2f já está disponível para saque",
                primeiraConta.nomeCLiente, primeiraConta.agencia,
                primeiraConta.numero,primeiraConta.saldo);
    }


}

