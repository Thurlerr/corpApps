# *Sobre
Sistema desenvolvido em Java com tecnologias legado seguindo o padrão MVC, com JSPs, Servlets e criptografia. Foram utilizadas tecnologias legado para evitar abstrações por fins de estudo.  
Este readme serve como guia para desenvolvimento, referência futura e organização pessoal.

# *Tecnologias utilizadas

- JDK 21 (Kit de Desenvolvimento Java).
- Maven 3.9.9 (Ferramenta de gerenciamento de projetos e dependências).
- Tomcat 10.1.39 (Servidor web e contêiner de servlets e JSPs).
- MySQL (XAMPP) (Sistema de Gerenciamento de Banco de Dados).
- VSCode + Extension Pack for Java para o VSCode.

Como rodar o projeto

Para facilitar configurações que serão mostradas a seguir, sugiro que a seguinte estrutura de diretórios seja seguida: 
Geral: c:\dev\pac2025
Maven: c:\dev\pac2025\maven
Tomcat: c:\dev\pac2025\tomcat

Para que o sistema operacional e os programas saibam onde encontrar os arquivos e executáveis necessários para o projeto funcionar corretamente, é necessário configurar as Variáveis de Ambiente.

No Windows:
- Pesquisar por Editar variaveis de ambiente do sistema.
- Adicionar as Variáveis:

JAVA_HOME c:\Program Files\Java\jdk-21
MAVEN_HOME c:\dev\pac\2025\maven
CATALINA_HOME c:\dev\pac\2025\tomcat

Dentro da variável já existente " Path " , adicionar os seguintes caminhos:

c:\Program Files\Java\jdk-21\bin
c:\dev\pac\2025\maven\bin
c:\dev\pac\2025\tomcat\bin

Verificação do ambiente através do cmd:

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


## Estrutura do Projeto (Padrão MVC)

src/
├── controller/ # Servlets e lógica de controle
├── model/ # Classes de negócio e conexão com o banco
├── view/ # Arquivos JSP
├── util/ # Utilitários como criptografia
└── Main.java # Se necessário, ponto de entrada
## 📄 Modelagem Inicial (Classes e Funções)
## 🔐 Estruturas de Criptografia
## 📦 Dependências Maven
## 🔧 Scripts SQL
  criação de database dentro de pasta sql no caminho:
📚 Referências
