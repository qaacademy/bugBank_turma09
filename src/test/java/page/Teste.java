package page;

public class Teste {
    public static void main(String[] args) {
        String mensagem = "A conta 1289-5 foi criada com sucesso";
        String[] numConta = mensagem.split("conta|foi");
        String conta = numConta[1].trim();
        String[] contaDigito = conta.split("-");
        conta = contaDigito[0];
        String digito = contaDigito[1];

        System.out.println(conta);
        System.out.println(digito);


    }
}
