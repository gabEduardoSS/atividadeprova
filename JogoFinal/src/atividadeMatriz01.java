import java.util.Scanner;

public class atividadeMatriz01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.printf("Insira um número na posição [%d,%d] da matriz: ", r+1, c+1);
                matriz[r][c] = input.nextInt();
            }
        }
        System.out.println("Sua matriz ficou:");
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.printf(" %d ", matriz[r][c]);

            }
            System.out.println();
        }

    }
}
