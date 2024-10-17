package tech.ada.rflima.b3testesexercicios.streams;

public class Lambdas {

    public static void main(String[] args) {

        //Pré Java 8
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });
        t1.start();

        //Java 8
        Thread t2 = new Thread(() -> {
            System.out.println("Hello World");
            System.out.println(".");
        });
        t2.start();

        new Processadora().executar(abacatito -> {
            System.out.println(abacatito);
            return true;
        });

    }



}

interface ProcessaPagamento {
    boolean processa(String tipoPagamento);

}

class Processadora {

    public void executar(ProcessaPagamento p) {
        boolean imprimaQualqueurCoisa = p.processa("IMPRIMA QUALQUEUR COISA");
        System.out.println(imprimaQualqueurCoisa);
    };

}
