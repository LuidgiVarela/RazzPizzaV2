package ModelArthur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arthu
 */
public class SistemaAvaliacoes {

    private static List<Avaliacao> todasAvaliacoes = new ArrayList<>();

    public static void adicionarAvaliacao(Avaliacao avaliacao) {
        todasAvaliacoes.add(avaliacao);
    }

    public static List<Avaliacao> getTodasAvaliacoes() {
        return todasAvaliacoes;
    }

    public static List<Avaliacao> getAvaliacoesDoDia() {
        List<Avaliacao> doDia = new ArrayList<>();
        for (Avaliacao a : todasAvaliacoes) {
            if (a.getData().equals(LocalDate.now())) {
                doDia.add(a);
            }
        }
        return doDia;
    }

    public static void limparAvaliacoes() {
        todasAvaliacoes.clear();
    }
}