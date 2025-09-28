import java.util.Scanner;
import java.util.Random;

public class JogoPTjoao {
    static Random rand = new Random();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vidaHeroi = 60;
        int vidaMonstro = 50;
        int pocao = 2;
        int xp = 0;
        boolean especialDisponivel = true;
        boolean usaPoder = true;

        int min = 30;
        int max = 50;
        int XPaleatorio = rand.nextInt(max - min + 1) + min;

        // História inicial
        System.out.println("Era uma vez em um reino distante...");
        System.out.println("Um jovem herói chamado Taffeson foi escolhido para enfrentar um terrível monstro.");
        System.out.println("O destino do vilarejo depende de sua coragem e de suas escolhas!");
        System.out.println("Prepare-se para a batalha! \n");

        System.out.println("Bem-vindo ao RPG das Funções!");
        System.out.println("Ajude Taffeson a derrotar o monstro para salvar o vilarejo.\n");

        while (vidaHeroi > 0 && vidaMonstro > 0) {
            System.out.println("\n❤️ Vida de Taffeson: " + vidaHeroi + " | 🐉 Vida do Monstro: " + vidaMonstro);
            System.out.println("🎒 Poções restantes: " + pocao);
            System.out.println("Escolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar Poção");
            System.out.println("3 - Defender");
            System.out.println("4 - Poder Especial");
            System.out.println("5 - Fugir");

            int escolha = sc.nextInt();

            if (escolha == 1) {
                // TODO: chamar a função atacar()
                // Essa função deve:
                // 1. Gerar um número aleatório entre 8 e 12 para o dano.
                // 2. Ter 20% de chance de ataque crítico (dano dobrado).
                // 3. Mostrar mensagens no console ("Taffeson atacou...", "Crítico!" etc).
                // 4. Retornar a nova vida do monstro após o ataque.
                // vidaMonstro = atacar(vidaMonstro, rand);
            } else if (escolha == 2) {
                // TODO: chamar a função usarPocao()
                System.out.println("Você recua por um momento e procura por uma poção em sua bolsa");
                if (pocao > 0) {
                    pocao = pocao - 1;

                    vidaHeroi = usarPocao(vidaHeroi);
                } else {
                    System.out.println("Mesmo procurando, não encontra nada");
                }
            } else if (escolha == 3) {
                // TODO: chamar a função defender()
                // Essa função deve:
                // 1. Apenas imprimir uma mensagem avisando que Taffeson está defendendo.
                // 2. Reduzir dano em 50%.
                // defender();
            } else if (escolha == 4) {
                System.out.println("Taffeson se concentra");
                if (usaPoder == true) {
                    vidaMonstro = poderEspecial(vidaMonstro, especialDisponivel);
                    usaPoder = !especialDisponivel;
                } else {
                    System.out.println("Taffeson não pode usar o poder especial");
                }
                
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
                fugir();
                return;
            } else {
                System.out.println("Opção inválida!");
                continue;
            }

            // Turno do monstro
            //TODO leve essa logica para uma função chamada Ataque de Mostro()
            int ataqueMonstro = rand.nextInt(10) + 5; // dano entre 5 e 15
            boolean critico = rand.nextInt(100) < 15; // 15% de chance crítico
            if (critico) {
                ataqueMonstro *= 2;
                System.out.println("💥 O monstro acertou um CRÍTICO!");
            }
            vidaHeroi -= ataqueMonstro;
            System.out.println("🐉 O monstro atacou e causou " + ataqueMonstro + " de dano!");
        }

        if (vidaMonstro <= 0) {
            // TODO: chamar a função ganharXP()
            // Essa função deve:
            // 1. Gerar um número aleatório entre 10 e 30.
            // 2. Retornar esse valor como experiência (XP).
            // 3. Mostrar mensagem de vitória com o XP ganho.
            // xp = ganharXP();
            System.out.println("🎉 Taffeson derrotou o monstro e ganhou " + xp + " XP!");
            System.out.println("🏆 O vilarejo foi salvo graças à bravura de Taffeson!");
        } else {
            System.out.println("💀 Taffeson foi derrotado... o vilarejo está em perigo!");
        }
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
        int danoEspecial = 25;
        vidaMonstro -= danoEspecial;
        System.out.println("O monstro recebe " + danoEspecial +" de dano, e fica com " + vidaMonstro + " de vida");
        especialDisponivel = false;
        return danoEspecial;
    }
    
    public static void fugir () {
        System.out.println("Taffeson foje, com medo e assustado");
        System.out.println("O monstro ri triunfante");
    }
}


    // =============================
    // Funções DEVEM implementar, como exemplo
    // =============================

    // public static int atacar(int vidaMonstro, Random rand) { ... }

    // public static void defender() { ... }

    // public static int poderEspecial(int vidaMonstro) { ... }
