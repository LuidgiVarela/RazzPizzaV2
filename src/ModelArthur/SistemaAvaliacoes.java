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

    // Simula avaliações realistas
    public static void simularAvaliacoes() {
        todasAvaliacoes.add(new Avaliacao("Amanda Silva", "amanda.silva@email.com",
        "A pizza estava deliciosa, chegou bem quentinha e antes do horário previsto. Atendimento ótimo!",
        LocalDate.of(2025, 7, 6)));

    todasAvaliacoes.add(new Avaliacao("Carlos Mendes", "carlosm@email.com",
        "Gostei muito da variedade do cardápio. Só achei o refrigerante um pouco quente.",
        LocalDate.of(2025, 7, 5)));

    todasAvaliacoes.add(new Avaliacao("Juliana Costa", "juliana.costa@email.com",
        "Fiz o pedido com borda recheada e veio sem. Tive que ligar para reclamar. Resolveram rápido, mas fiquei chateada.",
        LocalDate.of(2025, 7, 3)));

    todasAvaliacoes.add(new Avaliacao("Paulo Henrique", "paulo@email.com",
        "Achei o valor um pouco alto, mas a qualidade da pizza compensou bastante!",
        LocalDate.of(2025, 7, 2)));

    todasAvaliacoes.add(new Avaliacao("Fernanda Lopes", "fernanda@email.com",
        "Excelente serviço, desde o pedido até a entrega. Nota 10!",
        LocalDate.now()));

    todasAvaliacoes.add(new Avaliacao("João Vitor", "joaovitor_1@email.com",
        "Pizza veio errada, mas o entregador foi super educado e trouxe a correta rapidinho.",
        LocalDate.now()));

    todasAvaliacoes.add(new Avaliacao("Lucas Oliveira", "lucasoliveira@email.com",
        "A melhor calabresa que já comi! Vou pedir de novo com certeza!",
        LocalDate.of(2025, 7, 4)));

    todasAvaliacoes.add(new Avaliacao("Beatriz Ramos", "beatriz@email.com",
        "O app travou durante o pagamento, tive que repetir o processo. Podiam melhorar isso.",
        LocalDate.of(2025, 6, 30)));

    todasAvaliacoes.add(new Avaliacao("Amanda Silva", "amanda.silva@email.com",
        "Pedi novamente a de frango c/ catupiry. Chegou antes do previsto, como da outra vez. Atendimento excelente de novo!",
        LocalDate.of(2025, 7, 9)));

    todasAvaliacoes.add(new Avaliacao("Carlos Mendes", "carlosm@email.com",
        "Terceira vez que peço este mês. Constância na qualidade me impressiona. Só senti falta de mais opções vegetarianas.",
        LocalDate.of(2025, 7, 9)));

    todasAvaliacoes.add(new Avaliacao("João Vitor", "joaovitor_2@email.com",
        "Infelizmente hoje o pedido veio incompleto. Faltou a borda recheada que eu tinha pago. Entrei em contato e resolveram.",
        LocalDate.of(2025, 7, 8)));

    todasAvaliacoes.add(new Avaliacao("Letícia Rocha", "leticia.rocha@email.com",
        "Foi a minha primeira vez pedindo e já fiquei cliente. Massa leve, ingredientes frescos e entrega antes do tempo previsto!",
        LocalDate.of(2025, 7, 5)));

    todasAvaliacoes.add(new Avaliacao("Eduardo Martins", "eduardo@email.com",
        "A embalagem veio um pouco amassada, mas o conteúdo estava perfeito. Sabor marcante e boa quantidade. Vou pedir de novo.",
        LocalDate.of(2025, 7, 4)));

    todasAvaliacoes.add(new Avaliacao("Camila Andrade", "camila.andrade@email.com",
        "Atendimento pelo chat foi rápido e eficiente. Esclareceram minhas dúvidas antes de eu finalizar o pedido. Adorei!",
        LocalDate.of(2025, 7, 3)));

    todasAvaliacoes.add(new Avaliacao("Henrique Dias", "henrique.dias@email.com",
        "Comprei por recomendação de um amigo e não me arrependi. Pizza chegou quentinha e bem montada. Ganharam um novo fã.",
        LocalDate.of(2025, 7, 1)));

    todasAvaliacoes.add(new Avaliacao("Marcela Nunes", "marcela.nunes@email.com",
        "Já é a quarta vez que peço! A pizza chega sempre antes do horário estimado e quentinha. Ontem pedi a vegetariana e até quem não gosta aprovou. Atendimento via chat também é muito eficiente. Recomendo sem pensar duas vezes!",
        LocalDate.of(2025, 7, 10)));

    todasAvaliacoes.add(new Avaliacao("Rafael Teixeira", "rafael.teixeira@email.com",
        "Minha experiência foi ótima. Fiz o pedido no intervalo do trabalho e chegou em 30 minutos. A embalagem estava impecável, o sabor superou as expectativas. Dá pra ver que usam ingredientes de qualidade. Continuem assim!",
        LocalDate.of(2025, 7, 8)));            
    }
    
}