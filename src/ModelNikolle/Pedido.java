package ModelNikolle;

import ModelArthur.Bebida;
import ModelArthur.Categoria;
import ModelArthur.Categoria;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

//Classe Pedido que guarda os itens Categorias e suas quantidades, calcula o total do pedido e permite listar os itens pedidos
public class Pedido {

    // map que guarda as Categorias e suas quantidades
    private final Map<Categoria, Integer> itens;
    
    public Pedido() {
        itens = new HashMap<>();
    }

    // Adiciona um item ao pedido, somando a quantidade passada
    // Se o item ja existir no pedido, ele incrementa a quantidade
    public void adicionarItem(Categoria item, int quantidade) {
        if (item == null || quantidade <= 0) return;
        itens.put(item, itens.getOrDefault(item, 0) + quantidade);
    }

    
    // atualiza a quantidade de um item no pedido
    public void atualizarQuantidade(Categoria item, int quantidade) {
        if (item == null) return;

        if (quantidade <= 0) {
            itens.remove(item);
        } else {
            itens.put(item, quantidade);
        }
    }

    
    // Remover um item do pedido
    public void removerItem(Categoria item) {
        itens.remove(item);
    }

    
    //Return o valor total do pedido + preço * quantidade de cada item
    public double calcularTotal() {
        double total = 0.0;
        for (Map.Entry<Categoria, Integer> entry : itens.entrySet()) {
            Categoria item = entry.getKey();
            int quantidade = entry.getValue();
            total += item.getPreco() * quantidade;
        }
        return total;
    }

    
     // retorna uma lista com a descrição dos itens pedidos,
    public List<String> listarItensFormatados() {
        List<String> lista = new ArrayList<>();
        for (Map.Entry<Categoria, Integer> entry : itens.entrySet()) {
            Categoria item = entry.getKey();
            int quantidade = entry.getValue();
            double subtotal = item.getPreco() * quantidade;
            String linha = item.getNome() + " x" + quantidade + " - R$ " + String.format("%.2f", subtotal);
            lista.add(linha);
        }
        return lista;
    }

    
    //retorna o map completo de itens e quantidades
    public Map<Categoria, Integer> getItens() {
        return new HashMap<>(itens); // devolve cópia para proteger encapsulamento
    }

    //resumo do pedido em texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pedido:\n");
        for (Map.Entry<Categoria, Integer> entry : itens.entrySet()) {
            Categoria item = entry.getKey();
            int quantidade = entry.getValue();
            sb.append(item.getNome())
              .append(" x")
              .append(quantidade)
              .append(" = R$ ")
              .append(String.format("%.2f", item.getPreco() * quantidade))
              .append("\n");
        }
        sb.append("Total: R$ ").append(String.format("%.2f", calcularTotal()));
        return sb.toString();
    }

    public void adicionarCategoria(Categoria item1, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void removerCategoria(Categoria item1, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void atualizarQuantidade(Bebida bebida1, Object quantidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
