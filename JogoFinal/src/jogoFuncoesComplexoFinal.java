import java.util.Random;
import java.util.Scanner;

public class jogoFuncoesComplexoFinal {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static int danoEspecial = 25;
    static int defesa = 1;
    static int vidaHeroi = 60;
    static int vidaMonstro = 50;
    static int pocao = 2;
    static int xp = 0;
    static boolean especialDisponivel = true;
    static boolean usaPoder = true;
    static boolean emBatalha = true;

    public static int atacar(int vidaMonstro){
        int[] rangeDano = {8, 12};
        int critico = 1;
        String strAtaque = "NORMAL";
        if(rand.nextInt(100 + 1) > 80){
            critico = 2;
            strAtaque = "CRÍTICO";
        }
        int dano = (rand.nextInt(rangeDano[1] - rangeDano[0] + 1) + rangeDano[0]) * critico;
        int vida = vidaMonstro - dano;
        System.out.printf("Tafferson causou %d de dano com um ataque %s%n", dano, strAtaque);
        return vida;
    }

    public static int ataqueDeMonstro(int vidaHeroi, int defesa){
        int ataqueMonstro = rand.nextInt(10) + 5; // dano entre 5 e 15
        boolean critico = rand.nextInt(100) < 15; // 15% de chance crítico
        if (critico) {
            ataqueMonstro *= 2;
            System.out.println("💥 O monstro acertou um CRÍTICO!");
        }
        ataqueMonstro = (int) Math.round((float) ataqueMonstro /defesa);

        vidaHeroi -= ataqueMonstro;
        System.out.println("🐉 O monstro atacou e causou " + ataqueMonstro + " de dano!");
        return vidaHeroi;
    }
    
    public static int usarPocao(int vidaHeroi) {
        int vidaPocao = 15;
        System.out.println("Dos fundos da sua bolsa, você pega uma poção e a bebe");
        if (vidaHeroi < 45) {
            vidaHeroi += vidaPocao;
        } else {
            System.out.println("Pela emoção do momento, você acaba errado a golada e não bebe a poção");
            vidaPocao = 5;
            vidaHeroi += vidaPocao;
        }
        System.out.println("Com ela você recuperou " + vidaPocao + " pontos de vida");
        System.out.println(vidaHeroi);

        return vidaHeroi;
    }

    public static int poderEspecial(int vidaMonstro ,boolean especialDisponivel) {
        vidaMonstro = vidaMonstro - danoEspecial;
        System.out.println("O monstro recebe " + danoEspecial +" de dano ");
        especialDisponivel = false;
        return vidaMonstro;
    }

    public static void defender(){
        defesa = 2;
        System.out.println("\uD83D\uDEE1️Taffeson levantou seu escudo, recebendo 50% a menos de dano!");
    }

    public static void fugir(){
        emBatalha = false;
    }

    public static int ganharXP(){
        int[] rangeXp = {10, 30};
        return rand.nextInt(rangeXp[1] - rangeXp[0] + 1) + rangeXp[0];
    }

    public static void sleep(int tempo){
        try{
            Thread.sleep(tempo);
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String[] args) {
        // História inicial
        System.out.println("Era uma vez em um reino distante...");
        System.out.println("Um jovem herói chamado Taffeson foi escolhido para enfrentar um terrível monstro.");
        System.out.println("O destino do vilarejo depende de sua coragem e de suas escolhas!");
        System.out.println("Prepare-se para a batalha! \n");

        System.out.println("Bem-vindo ao RPG das Funções!");
        System.out.println("Ajude Taffeson a derrotar o monstro para salvar o vilarejo.\n");

        while (vidaHeroi > 0 && vidaMonstro > 0 ) {
            System.out.println("\n❤️ Vida de Taffeson: " + vidaHeroi + " | 🐉 Vida do Monstro: " + vidaMonstro);
            System.out.println("🎒 Poções restantes: " + pocao);
            System.out.println("Escolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar Poção");
            System.out.println("3 - Defender");
            System.out.println("4 - Poder Especial");
            System.out.println("5 - Fugir");
            System.out.println("------------------------");

            System.out.print("Escolha: ");
            int escolha = sc.nextInt();
            System.out.println();

            defesa = 1;
            if (escolha == 1) {
                // chamar a função atacar()
                // Essa função deve:
                // 1. Gerar um número aleatório entre 8 e 12 para o dano.
                // 2. Ter 20% de chance de ataque crítico (dano dobrado).
                // 3. Mostrar mensagens no console ("Taffeson atacou...", "Crítico!" etc).
                // 4. Retornar a nova vida do monstro após o ataque.
                // vidaMonstro = atacar(vidaMonstro, rand);
                vidaMonstro = atacar(vidaMonstro);
            } else if (escolha == 2) {
                System.out.println("Você recua por um momento e procura por uma poção em sua bolsa");
                if (pocao > 0) {
                    pocao = pocao - 1;

                    vidaHeroi = usarPocao(vidaHeroi);
                } else {
                    System.out.println("Mesmo procurando, não encontra nada");
                }
            } else if (escolha == 3) {
                // chamar a função defender()
                // Essa função deve:
                // 1. Apenas imprimir uma mensagem avisando que Taffeson está defendendo.
                // 2. Reduzir dano em 50%.
                // defender();
                defender();
            } else if (escolha == 4) {
                System.out.println("Taffeson se concentra");
                if (usaPoder == true) {
                    vidaMonstro = poderEspecial(vidaMonstro, especialDisponivel);
                    usaPoder = !especialDisponivel;
                } else {
                    System.out.println("Taffeson não pode usar o poder especial");
                }
            } else if (escolha == 5) {
                // chamar a função fugir()
                // Essa função deve:
                // 1. Mostrar mensagem de que Taffeson fugiu da batalha.
                // 2. Encerrar o jogo imediatamente.
                fugir();
                break;
            } else {
                System.out.println("Opção inválida!");
                continue;
            }

            // Turno do monstro
            if(vidaMonstro > 0){
                vidaHeroi = ataqueDeMonstro(vidaHeroi, defesa);
                sleep(2000);
            }
        }
        if (vidaMonstro <= 0) {
            // chamar a função ganharXP()
            // Essa função deve:
            // 1. Gerar um número aleatório entre 10 e 30.
            // 2. Retornar esse valor como experiência (XP).
            // 3. Mostrar mensagem de vitória com o XP ganho.
            xp = ganharXP();
            System.out.println("🎉 Taffeson derrotou o monstro e ganhou " + xp + " XP!");
            System.out.println("🏆 O vilarejo foi salvo graças à bravura de Taffeson!");
        } else if(!emBatalha){
            System.out.println("💀 Taffeson fugiu, abandonando o vilarejo... o vilarejo está em perigo!");
        }
        else {
            System.out.println("💀 Taffeson foi derrotado... o vilarejo está em perigo!");
        }
    }
    
    

    // =============================
    // Funções DEVEM implementar, como exemplo
    // =============================

    // public static int atacar(int vidaMonstro, Random rand) { ... }

    // public static void defender() { ... }

    // public static int poderEspecial(int vidaMonstro) { ... }

}