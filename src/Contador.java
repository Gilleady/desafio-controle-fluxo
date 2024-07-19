import java.util.Scanner;

/**
 * Classe principal do programa, responsável por receber a entrada do usuário, validar os parâmetros e realizar a contagem.
 */
public class Contador {

    /**
     * Método principal do programa.
     *
     * @param args Argumentos da linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in); // Cria um objeto Scanner para ler a entrada do usuário.

        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = terminal.nextInt(); // Lê o primeiro parâmetro do usuário.

        System.out.println("Digite o segundo parâmetro");
        int parametroDois = terminal.nextInt(); // Lê o segundo parâmetro do usuário.

        try {
            // Chama o método contar para realizar a contagem e impressão.
            contar(parametroUm, parametroDois);

        } catch (ParametrosInvalidosException exception) {
            // Imprime a mensagem de erro caso ocorra a exceção.
            System.out.println(exception.getMessage());
        }
        finally {
            terminal.close();
        }
    }

    /**
     * Realiza a contagem e impressão dos números entre os parâmetros fornecidos.
     *
     * @param parametroUm O primeiro número da sequência.
     * @param parametroDois O segundo número da sequência.
     * @throws ParametrosInvalidosException Caso o primeiro parâmetro seja maior que o segundo.
     */
    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // Valida se o primeiro parâmetro é maior que o segundo e lança a exceção caso seja.
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = parametroDois - parametroUm; // Calcula a contagem dos números a serem impressos.

        // Realiza o loop for para imprimir os números entre os parâmetros.
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}

/**
 * Classe que representa uma exceção customizada para indicar que os parâmetros fornecidos são inválidos.
 */
class ParametrosInvalidosException extends Exception {

    /**
     * Construtor da classe.
     *
     * @param message Mensagem de erro da exceção.
     */
    public ParametrosInvalidosException(String message) {
        super(message);
    }
}