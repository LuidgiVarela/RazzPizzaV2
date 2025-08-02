# RazzPizza 🍕

Sistema de gerenciamento de pizzaria com interface gráfica, desenvolvido em Java.

## 📋 Descrição

O **RazzPizza** é um sistema desktop criado para simular o funcionamento de uma pizzaria. O projeto permite que clientes façam pedidos, avaliem os serviços, e que administradores e entregadores gerenciem as operações da pizzaria. Possui estrutura orientada a objetos e interface gráfica interativa.

## 🚀 Funcionalidades principais

- 📦 Cadastro de pizzas, bebidas e sobremesas  
- 👥 Sistema de usuários (Cliente, Administrador, Entregador)  
- 💳 Suporte a múltiplos métodos de pagamento (Dinheiro, Cartão, Pix)  
- ⭐ Sistema de avaliações e feedback  
- 📉 Aplicação de descontos  
- 🖥️ Interface gráfica desenvolvida com Java Swing  

## 🧱 Estrutura do projeto

O projeto está dividido em pacotes que representam diferentes módulos e autores:

```
src/
├── ModelArthur/     # Entidades relacionadas a pagamento, cardápio e avaliações
├── ModelLuidgi/     # Entidades de usuário, sessão e descontos
├── ModelNikolle/    # Gerenciamento de cardápio e pedidos
├── ViewArthur/      # Telas gráficas para avaliação e feedback
```

## 🛠️ Tecnologias utilizadas

- Java 8+
- Java Swing (GUI)
- Orientação a Objetos

## 📦 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/LuidgiVarela/RazzPizzaV2.git
   ```

2. Compile e execute o projeto:
   - Utilize uma IDE como **NetBeans** ou **IntelliJ IDEA**
   - Ou compile manualmente via terminal:
     ```bash
         javac -d build/classes src/**/*.java
         java -cp build/classes razzpizzav3.RazzPizzaV3
     ```


## 📄 Licença

Este projeto é apenas para fins educacionais e não possui uma licença oficial.
