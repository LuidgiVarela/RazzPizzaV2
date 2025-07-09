package ModelArthur;
import ModelLuidgi.Cliente;
import ModelLuidgi.BancoUsuarios;
import java.time.LocalDate;

/**
 *
 * @author arthu
 */
public class SimuladorDeDados {
     public static void simular() {
        // Criando clientes fictícios
        Cliente c1 = new Cliente("João Silva", "joao@email.com", "123", "Rua A", "111111", "1");
        Cliente c2 = new Cliente("Maria Souza", "maria@email.com", "456", "Rua B", "222222", "2");
        Cliente c3 = new Cliente("Carlos Lima", "carlos@email.com", "789", "Rua C", "333333", "3");
        Cliente c4 = new Cliente("Ana Paula", "ana@email.com", "321", "Rua D", "444444", "4");
        Cliente c5 = new Cliente("Lucas Martins", "lucas@email.com", "654", "Rua E", "555555", "5");
        Cliente c6 = new Cliente("Fernanda Costa", "fernanda@email.com", "987", "Rua F", "666666", "6");
        Cliente c7 = new Cliente("Gabriel Rocha", "gabriel@email.com", "159", "Rua G", "777777", "7");
        Cliente c8 = new Cliente("Camila Alves", "camila@email.com", "753", "Rua H", "888888", "8");
        Cliente c9 = new Cliente("Bruno Mendes", "bruno@email.com", "852", "Rua I", "999999", "9");
        Cliente c10 = new Cliente("Juliana Prado", "juliana@email.com", "951", "Rua J", "101010", "10");
        Cliente c11 = new Cliente("Rafael Torres", "rafael@email.com", "741", "Rua K", "121212", "11");
        Cliente c12 = new Cliente("Larissa Barros", "larissa@email.com", "963", "Rua L", "131313", "12");
        Cliente c13 = new Cliente("Eduardo Nunes", "eduardo@email.com", "147", "Rua M", "141414", "13");
        Cliente c14 = new Cliente("Patrícia Ribeiro", "patricia@email.com", "258", "Rua N", "151515", "14");
        Cliente c15 = new Cliente("Rodrigo Cunha", "rodrigo@email.com", "369", "Rua O", "161616", "15");
        Cliente c16 = new Cliente("Beatriz Santos", "beatriz@email.com", "159", "Rua P", "171717", "16");
        Cliente c17 = new Cliente("Felipe Cardoso", "felipe@email.com", "753", "Rua Q", "181818", "17");
        Cliente c18 = new Cliente("Aline Batista", "aline@email.com", "852", "Rua R", "191919", "18");
        Cliente c19 = new Cliente("João Silva", "joao@email.com", "321", "Rua S", "202020", "19"); // Repetido
        Cliente c20 = new Cliente("Maria Souza", "maria@email.com", "654", "Rua T", "212121", "20"); // Repetido
        Cliente c21 = new Cliente("Ana Paula", "ana.paula2@email.com", "888", "Rua U", "222333", "21");
        
        // Adicionando os clientes no banco de usuários
        BancoUsuarios.adicionarUsuario(c1);
        BancoUsuarios.adicionarUsuario(c2);
        BancoUsuarios.adicionarUsuario(c3);
        BancoUsuarios.adicionarUsuario(c4);
        BancoUsuarios.adicionarUsuario(c5);
        BancoUsuarios.adicionarUsuario(c6);
        BancoUsuarios.adicionarUsuario(c7);
        BancoUsuarios.adicionarUsuario(c8);
        BancoUsuarios.adicionarUsuario(c9);
        BancoUsuarios.adicionarUsuario(c10);
        BancoUsuarios.adicionarUsuario(c11);
        BancoUsuarios.adicionarUsuario(c12);
        BancoUsuarios.adicionarUsuario(c13);
        BancoUsuarios.adicionarUsuario(c14);
        BancoUsuarios.adicionarUsuario(c15);
        BancoUsuarios.adicionarUsuario(c16);
        BancoUsuarios.adicionarUsuario(c17);
        BancoUsuarios.adicionarUsuario(c18);
        BancoUsuarios.adicionarUsuario(c19);
        BancoUsuarios.adicionarUsuario(c20);
        BancoUsuarios.adicionarUsuario(c21);

        // Criando avaliações
        Avaliacao a1 = new Avaliacao(c1, "Excelente serviço! A entrega foi rápida e o atendimento muito cordial. Super recomendo para todos os meus amigos!", LocalDate.now().minusDays(1));
        Avaliacao a2 = new Avaliacao(c2, "A experiência foi ótima. A interface do aplicativo é intuitiva e os entregadores são muito profissionais.", LocalDate.now().minusDays(2));
        Avaliacao a3 = new Avaliacao(c3, "Fiquei muito satisfeito com o tempo de resposta e com a forma como resolveram meu problema. Parabéns!", LocalDate.now().minusDays(3));
        Avaliacao a4 = new Avaliacao(c4, "Os preços estão muito competitivos e a qualidade do serviço é excelente. Já indiquei para familiares.", LocalDate.now().minusDays(4));
        Avaliacao a5 = new Avaliacao(c5, "Entrega no prazo, produto bem embalado, e ótimo suporte. Recomendo fortemente a plataforma.", LocalDate.now().minusDays(5));
        Avaliacao a6 = new Avaliacao(c6, "Gostei do aplicativo, mas poderia ter mais opções de pagamento. No geral, foi uma boa experiência.", LocalDate.now().minusDays(6));
        Avaliacao a7 = new Avaliacao(c7, "Tive um pequeno problema no pedido, mas a equipe resolveu rapidamente. Atendimento nota 10!", LocalDate.now().minusDays(7));
        Avaliacao a8 = new Avaliacao(c8, "Tudo correu conforme o esperado. A entrega foi eficiente e o motoboy foi educado. Voltarei a usar.", LocalDate.now().minusDays(8));
        Avaliacao a9 = new Avaliacao(c9, "Muito bom! Já fiz vários pedidos e todos chegaram corretamente e dentro do prazo estipulado.", LocalDate.now().minusDays(9));
        Avaliacao a10 = new Avaliacao(c10, "Aplicativo fácil de usar e muito rápido. A logística foi surpreendente. Recomendo para todos.", LocalDate.now().minusDays(10));
        Avaliacao a11 = new Avaliacao(c11, "Serviço excelente! Achei prático, rápido e seguro. Um dos melhores apps que já usei nesse segmento.", LocalDate.now().minusDays(1));
        Avaliacao a12 = new Avaliacao(c12, "Gostei da pontualidade na entrega, da variedade de produtos e da comunicação com os entregadores.", LocalDate.now().minusDays(2));
        Avaliacao a13 = new Avaliacao(c13, "Tive dificuldade para rastrear meu pedido. Poderiam melhorar essa parte, mas o resto foi bom.", LocalDate.now().minusDays(3));
        Avaliacao a14 = new Avaliacao(c14, "Entrega perfeita, chegou até antes do previsto. A embalagem também estava impecável. Parabéns!", LocalDate.now().minusDays(4));
        Avaliacao a15 = new Avaliacao(c15, "Aplicativo bem construído. Fácil de navegar, com bons filtros de busca. Voltarei a usar com certeza.", LocalDate.now().minusDays(5));
        Avaliacao a16 = new Avaliacao(c16, "Recomendo muito! Agilidade, respeito com o cliente e preços justos fazem toda a diferença.", LocalDate.now().minusDays(6));
        Avaliacao a17 = new Avaliacao(c17, "Não tive nenhum problema. Tudo foi conforme o combinado, da escolha ao recebimento do produto.", LocalDate.now().minusDays(7));
        Avaliacao a18 = new Avaliacao(c18, "Atendimento maravilhoso, muito atenciosos. A entrega foi até mais rápida do que eu esperava.", LocalDate.now().minusDays(8));
        Avaliacao a19 = new Avaliacao(c19, "Primeira vez que peço aqui e já gostei. Continuem assim, o serviço está muito bom mesmo.", LocalDate.now().minusDays(9));
        Avaliacao a20 = new Avaliacao(c20, "Já sou cliente há um tempo e sempre me surpreendo positivamente. Ótimo trabalho!", LocalDate.now().minusDays(10));
        Avaliacao a21 = new Avaliacao(c21, "Sou cliente nova e adorei o atendimento. Tudo muito bem organizado e eficiente. Recomendo fortemente!", LocalDate.now().minusDays(1));

        // Adicionando no sistema de avaliações
        SistemaAvaliacoes.adicionarAvaliacao(a1);
        SistemaAvaliacoes.adicionarAvaliacao(a2);
        SistemaAvaliacoes.adicionarAvaliacao(a3);
        SistemaAvaliacoes.adicionarAvaliacao(a4);
        SistemaAvaliacoes.adicionarAvaliacao(a5);
        SistemaAvaliacoes.adicionarAvaliacao(a6);
        SistemaAvaliacoes.adicionarAvaliacao(a7);
        SistemaAvaliacoes.adicionarAvaliacao(a8);
        SistemaAvaliacoes.adicionarAvaliacao(a9);
        SistemaAvaliacoes.adicionarAvaliacao(a10);
        SistemaAvaliacoes.adicionarAvaliacao(a11);
        SistemaAvaliacoes.adicionarAvaliacao(a12);
        SistemaAvaliacoes.adicionarAvaliacao(a13);
        SistemaAvaliacoes.adicionarAvaliacao(a14);
        SistemaAvaliacoes.adicionarAvaliacao(a15);
        SistemaAvaliacoes.adicionarAvaliacao(a16);
        SistemaAvaliacoes.adicionarAvaliacao(a17);
        SistemaAvaliacoes.adicionarAvaliacao(a18);
        SistemaAvaliacoes.adicionarAvaliacao(a19);
        SistemaAvaliacoes.adicionarAvaliacao(a20);
        SistemaAvaliacoes.adicionarAvaliacao(a21);
    }
    
}
