import java.util.Arrays;
import java.util.Scanner;

public class atividadeVetor01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] numeros = new int[10];
        int menorNumero = 0;
        int maiorNumero = 0;
        for(int i = 0; i < numeros.length; i++) {
            System.out.print("Insira um número: ");
            int numero =  input.nextInt();
            numeros[i] = numero;
            if(i != 0){
                if(numeros[i] > maiorNumero){
                    maiorNumero = numeros[i];
                } else if(numeros[i] < menorNumero) {
                    menorNumero = numeros[i];
            }
            } else{
                menorNumero = numeros[i];
                maiorNumero = numeros[i];
            }
        }
        System.out.printf("No array: %s, o maior valor é %s, e o menor é %s", Arrays.toString(numeros), maiorNumero, menorNumero);
    }
}
