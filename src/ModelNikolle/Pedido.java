package ModelNikolle;

import ModelArthur.Pizza;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Pedido - representa um pedido feito pelo usuário.
 * Guarda os itens (pizzas) e suas quantidades,
 * calcula o total do pedido e permite listar os itens pedidos.
 */
public class Pedido {

    // Mapa para guardar as pizzas e suas quantidades
    private final Map<Pizza, Integer> itens;

    // Construtor inicia o mapa vazio
    public Pedido() {
        itens = new HashMap<>();
    }

    /**
     * Adiciona uma pizza ao pedido, somando a quantidade passada.
     * Se a pizza já existe no pedido, incrementa a quantidade.
     * @param pizza Pizza a adicionar
     * @param quantidade Quantidade a adicionar
     */
    public void adicionarItem(Pizza pizza, int quantidade) {
        if (pizza == null || quantidade <= 0) return;
        itens.put(pizza, itens.getOrDefault(pizza, 0) + quantidade);
    }

    /**
     * Atualiza a quantidade de uma pizza no pedido.
     * Se a quantidade for zero ou negativa, remove do pedido.
     * @param pizza Pizza a atualizar
     * @param quantidade Nova quantidade
     */
    public void atualizarQuantidade(Pizza pizza, int quantidade) {
        if (pizza == null) return;

        if (quantidade <= 0) {
            itens.remove(pizza);
        } else {
            itens.put(pizza, quantidade);
        }
    }

    /**
     * Remove uma pizza do pedido.
     * @param pizza Pizza a remover
     */
    public void removerItem(Pizza pizza) {
        itens.remove(pizza);
    }

    /**
     * Retorna o valor total do pedido somando preço * quantidade de cada pizza.
     * @return total do pedido em double
     */
    public double calcularTotal() {
        double total = 0.0;
        for (Map.Entry<Pizza, Integer> entry : itens.entrySet()) {
            Pizza pizza = entry.getKey();
            int quantidade = entry.getValue();
            total += pizza.getPreco() * quantidade;
        }
        return total;
    }

    /**
     * Retorna uma lista formatada com a descrição dos itens pedidos,
     * quantidade e subtotal para exibir na interface.
     * @return List<String> com itens formatados
     */
    public List<String> listarItensFormatados() {
        List<String> lista = new ArrayList<>();
        for (Map.Entry<Pizza, Integer> entry : itens.entrySet()) {
            Pizza pizza = entry.getKey();
            int quantidade = entry.getValue();
            double subtotal = pizza.getPreco() * quantidade;
            String linha = pizza.getNome() + " x" + quantidade + " - R$ " + String.format("%.2f", subtotal);
            lista.add(linha);
        }
        return lista;
    }

    /**
     * Retorna o mapa completo de itens e quantidades.
     * Útil para manipulação direta ou outras lógicas.
     * @return Map<Piz, Integer> dos itens pedidos
     */
    public Map<Pizza, Integer> getItens() {
        return new HashMap<>(itens); // devolve cópia para proteger encapsulamento
    }

    /**
     * Representa o pedido em forma de texto (resumo).
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pedido:\n");
        for (Map.Entry<Pizza, Integer> entry : itens.entrySet()) {
            Pizza pizza = entry.getKey();
            int quantidade = entry.getValue();
            sb.append(pizza.getNome())
              .append(" x")
              .append(quantidade)
              .append(" = R$ ")
              .append(String.format("%.2f", pizza.getPreco() * quantidade))
              .append("\n");
        }
        sb.append("Total: R$ ").append(String.format("%.2f", calcularTotal()));
        return sb.toString();
    }

    public void adicionarPizza(Pizza pizza1, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void removerPizza(Pizza pizza1, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
