package app.cliente;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class cliente {

    private cliente() {}

    public static void main(String[] args) {
 
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9400);
            Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

         Scanner scanner = new Scanner(System.in);

        double num1, num2, resultado;
        int escolha = -1;

        System.out.println("Digite o primeiro número: ");
        num1 = scanner.nextDouble();

       
        do {
            exibirMenu();

            System.out.println("Escolha a operação (1, 2, 3, 4): ");
            escolha = scanner.nextInt();

            if (escolha < 1 || escolha > 4) {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }

        } while (escolha < 1 || escolha > 4);
    

        System.out.println("Digite o segundo número: ");
        num2 = scanner.nextDouble();


        

        switch (escolha) {
            case 1:
                resultado = num1 + num2;
                System.out.println("Resultado da adição:"+num1+" + "+ num2+ " = "+ resultado);
                break;
            case 2:
                resultado = num1 - num2;
                System.out.println("Resultado da subtração: "+num1+" - "+ num2+ " = "+ resultado);
                break;
            case 3:
                resultado = num1 * num2;
                System.out.println("Resultado da multiplicação: "+num1+" x "+ num2+ " = "+ resultado);
                break;
            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("Resultado da divisão: "+num1+" / "+ num2+ " = "+ resultado);
                } else {
                    System.out.println("Não é possível dividir por zero.");
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    
        scanner.close();
    }


    private static void exibirMenu() {
        System.out.println("Escolha a operação:");
        System.out.println("1. Adição");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");
    }
    
    }
