# *Sobre
Sistema desenvolvido em Java com tecnologias legado seguindo o padrão MVC, com JSPs, Servlets e criptografia. Foram utilizadas tecnologias legado para evitar abstrações por fins de estudo.  
Este readme serve como guia para desenvolvimento, referência futura e organização pessoal.

# *Tecnologias utilizadas

- JDK 21 (Kit de Desenvolvimento Java).
- Maven 3.9.9 (Ferramenta de gerenciamento de projetos e dependências).
- Tomcat 10.1.39 (Servidor web e contêiner de servlets e JSPs).
- MySQL (XAMPP para uso local) (Sistema de Gerenciamento de Banco de Dados).
- VSCode + Extension Pack for Java para o VSCode.

Como rodar o projeto

Pré-requisitos
- Java JDK 21 instalado e configurado (java -version).
- Maven 3.9.9 instalado (mvn -version).
- Apache Tomcat 10.1.39 instalado.
- MySQL rodando (local ou remoto), com as credenciais e banco de dados criados conforme o script em /sql/ CHANGE//

Verificação do ambiente através do terminal:

java -version
javac -version
Verificar se a versão está na 21
mvn -version
Verificar se a versão está na 3.9.9
Levantar o TOMCAT
No Terminal, execute
startup.bat
Parar a execução
shutdown.bat

Após instalar as tecnologias da aba pré-requisitos e clonar o repositório:

### 1- Configure o banco de dados
- Crie o banco de dados usando o script SQL na pasta /sql/.
- Atualize as credenciais de conexão no arquivo responsável DBConnection.java CHANGE//
### 2- Buildar e compilar com o Maven
- Compile o projeto com o Maven (mvn clean package no terminal da sua IDE com a pasta do projeto aberto)
### 3- Deploy no Tomcat: 
- O comando mvn clean package gera um arquivo .war dentro de /target . Copie o arquivo war para webapps/ localizada na pasta de instalação do Tomcat. CHANGE//
### 4- Acessar no navegador
com o Tomcat levantado, (startup.bat no windows no seu terminal), acesse http://localhost:8080/solucred para acessar o sistema.


## Estrutura do Projeto (Padrão MVC)

src/
├── controller/ # Servlets e lógica de controle
├── model/ # Classes de negócio e conexão com o banco
├── view/ # Arquivos JSP
├── util/ # Utilitários como criptografia
└── Main.java # ponto de entrada
## 📄 Modelagem Inicial (Classes e Funções)
## 🔐 Estruturas de Criptografia
## 📦 Dependências Maven
## 🔧 Scripts SQL
  criação de database dentro de pasta sql no caminho:
📚 Referências
