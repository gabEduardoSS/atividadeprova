import java.util.Scanner;
import java.util.Random;

public class jogoFuncoesComplexo {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static int defesa = 1;
    static int vidaHeroi = 60;
    static int vidaMonstro = 50;
    static int pocao = 2;
    static int xp = 0;
    static boolean especialDisponivel = true;
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
        //TODO leve essa logica para uma função chamada Ataque de Mostro()
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
        /*System.out.println("Era uma vez em um reino distante...");
        System.out.println("Um jovem herói chamado Taffeson foi escolhido para enfrentar um terrível monstro.");
        System.out.println("O destino do vilarejo depende de sua coragem e de suas escolhas!");
        System.out.println("Prepare-se para a batalha! \n");

        System.out.println("Bem-vindo ao RPG das Funções!");
        System.out.println("Ajude Taffeson a derrotar o monstro para salvar o vilarejo.\n");*/

        while (vidaHeroi > 0 && vidaMonstro > 0 && emBatalha) {
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
                // TODO: chamar a função atacar()
                // Essa função deve:
                // 1. Gerar um número aleatório entre 8 e 12 para o dano.
                // 2. Ter 20% de chance de ataque crítico (dano dobrado).
                // 3. Mostrar mensagens no console ("Taffeson atacou...", "Crítico!" etc).
                // 4. Retornar a nova vida do monstro após o ataque.
                // vidaMonstro = atacar(vidaMonstro, rand);
                vidaMonstro = atacar(vidaMonstro);
            } else if (escolha == 2) {
                // TODO: chamar a função usarPocao()
                // Essa função deve:
                // 1. Verificar se Taffeson ainda tem poções.
                // 2. Se tiver, recuperar 15 de vida.
                // 3. Mostrar mensagens ("Você usou uma poção", "Não há poções restantes").
                // 4. Retornar a nova vida de Taffeson.
                // vidaHeroi = usarPocao(vidaHeroi, pocao);
                // if (pocao > 0) pocao--; // só gasta se tinha
            } else if (escolha == 3) {
                // TODO: chamar a função defender()
                // Essa função deve:
                // 1. Apenas imprimir uma mensagem avisando que Taffeson está defendendo.
                // 2. Reduzir dano em 50%.
                // defender();
                defender();
            } else if (escolha == 4) {
                // TODO: chamar a função poderEspecial()
                // Essa função deve:
                // 1. Só poder ser usada UMA vez no jogo.
                // 2. Causar 25 de dano fixo no monstro.
                // 3. Mostrar mensagens ("Taffeson usou o poder especial!").
                // if (especialDisponivel) {
                //     vidaMonstro = poderEspecial(vidaMonstro);
                //     especialDisponivel = false;
                // } else {
                //     System.out.println("❌ O poder especial já foi usado!");
                // }
            } else if (escolha == 5) {
                // TODO: chamar a função fugir()
                // Essa função deve:
                // 1. Mostrar mensagem de que Taffeson fugiu da batalha.
                // 2. Encerrar o jogo imediatamente.
                fugir();
                return;
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
        System.out.println(emBatalha);
        if (vidaMonstro <= 0) {
            // TODO: chamar a função ganharXP()
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