package ModelNikolle;

import ModelArthur.Bebida;
import ModelArthur.Pizza;
import ModelArthur.Sobremesa;
import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private final List<Pizza> pizzas;
    private final List<Bebida> bebidas;
    private final List<Sobremesa> sobremesas;

    public Cardapio() {
        pizzas = new ArrayList<>();
        bebidas = new ArrayList<>();
        sobremesas = new ArrayList<>();

        // ➕ Adiciona PIZZAS ao cardápio
        pizzas.add(new Pizza("Mussarela", 35.00, "Molho, mussarela e azeitona"));
        pizzas.add(new Pizza("Calabresa", 35.00, "Molho, mussarela, calabresa, cebola e orégano"));
        pizzas.add(new Pizza("Marguerita", 35.00, "Molho, mussarela, tomate, azeitona e orégano"));
        pizzas.add(new Pizza("Portuguesa", 35.00, "Molho, mussarela, presunto, ovo e azeitona"));
        pizzas.add(new Pizza("Napolitana", 38.00, "Molho, mussarela, presunto, azeitona e orégano"));
        pizzas.add(new Pizza("Frango", 35.00, "Molho, mussarela, tomate e azeitona"));
        pizzas.add(new Pizza("Quatro Queijos", 40.00, "Mussarela, parmesão, provolone e requeijão"));

        // ➕ Adiciona BEBIDAS
        bebidas.add(new Bebida("Coca-Cola", 8.00));
        bebidas.add(new Bebida("Guaraná Antárctica", 8.00));
        bebidas.add(new Bebida("Franta", 7.00));
        bebidas.add(new Bebida("Nutri Néctar Uva", 6.00));
        bebidas.add(new Bebida("Nutri Néctar", 6.00));
        bebidas.add(new Bebida("Água Mineral", 4.00));
        bebidas.add(new Bebida("Água com Gás", 5.00));

        // ➕ Adiciona SOBREMESAS
        sobremesas.add(new Sobremesa("Pudim", 10.00));
        sobremesas.add(new Sobremesa("Mousse de Maracujá", 9.50));
        sobremesas.add(new Sobremesa("Sorvete", 7.00));
    }

    // Getters
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public List<Sobremesa> getSobremesas() {
        return sobremesas;
    }
}
