import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class jogoFuncoesComplexoFinalTest {
    jogoFuncoesComplexoFinal jogo = new jogoFuncoesComplexoFinal();
    @Test
    void atacar() {
        int vidaMonstro = 50;
        vidaMonstro = jogo.atacar(vidaMonstro);

        assertTrue(42 >= vidaMonstro && vidaMonstro >= 26);

    }

    @Test
    void usarPocao() {
        int vida = jogo.usarPocao(60);
        assertEquals(65, vida, 0);
    }
}