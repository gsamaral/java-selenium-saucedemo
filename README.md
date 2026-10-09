# Java + Selenium WebDriver — SauceDemo

Projeto de exemplo de automação web com **Java 17**, **Selenium WebDriver**, **JUnit 5** e **Maven**, seguindo práticas de Clean Code e Page Object Model.

Site sob teste: https://www.saucedemo.com/

## Cenários automatizados

| ID | Cenário | Validação |
|---|---|---|
| CT01 | Login válido | Página Products e produtos visíveis |
| CT02 | Senha inválida | Mensagem de credenciais inválidas |
| CT03 | Login sem usuário | Mensagem de usuário obrigatório |
| CT04 | Adicionar produto ao carrinho | Contador igual a 1 |
| CT05 | Consultar o carrinho | Título, quantidade e nome do produto |

## Pré-requisitos

- JDK 17 ou superior
- Maven
- Google Chrome
- Conexão com a internet

Verifique as instalações:

```bash
java -version
mvn -version
```

## Instalação e execução

Extraia o ZIP, abra o terminal na pasta do projeto e execute:

```bash
mvn test
```

Para executar sem abrir a janela do navegador:

```bash
mvn test -Dheadless=true
```

Selenium Manager, incluído nas versões atuais do Selenium, gerencia a resolução do driver compatível. A primeira execução pode precisar de internet.

## Estrutura

```text
java-selenium-saucedemo/
├── pom.xml
├── README.md
├── .gitignore
└── src/test/java/com/qa/
    ├── config/DriverFactory.java
    ├── pages/
    │   ├── BasePage.java
    │   ├── LoginPage.java
    │   ├── InventoryPage.java
    │   └── CartPage.java
    └── tests/
        ├── BaseTest.java
        ├── LoginTests.java
        └── CartTests.java
```

## Boas práticas aplicadas

- **Page Object Model:** seletores e ações da interface ficam nas classes de página.
- **Responsabilidade única:** configuração do driver, páginas e testes são separados.
- **Clean Code:** nomes descritivos, métodos pequenos e asserções claras.
- **Esperas explícitas:** `WebDriverWait` e `ExpectedConditions`; não usa `Thread.sleep()`.
- **Isolamento:** cada teste cria e encerra sua instância do navegador.
- **Configuração de execução:** opção headless via propriedade de sistema.
- **Sem credenciais pessoais:** usa as credenciais públicas do site de demonstração.

## Observações

O site é externo e pode ficar indisponível ou mudar. Os seletores refletem a interface conhecida do SauceDemo e podem precisar de manutenção caso o site seja alterado. As credenciais de demonstração utilizadas são `standard_user` / `secret_sauce`.

## Ideias para evoluir

1. Testar remoção de produtos do carrinho.
2. Automatizar o checkout até a confirmação do pedido.
3. Capturar screenshots em caso de falha.
4. Adicionar relatórios Allure ou Extent Reports.
5. Integrar com GitHub Actions.
