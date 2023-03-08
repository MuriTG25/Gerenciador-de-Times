# Gerenciador-de-Times
Meu primeiro projeto em Java. Esse projeto consiste em um banco de dados de um RH de um time de Futebol, onde controlamos os dados dos Jogadores, Comissao Técnica e Funcionários.<br />
Dentro desses dados, organizamos os dados pessoas, como Nome, RG, CPF, dados bancários e etc. E organizamos os funcionários em 4 categorias que armazenados em lista: Funcionários Comum, Funcionarios Administrativos, Jogadores e Comissão Técnica.

# Versão 1.0

Esse projeto tem como motivo principal mostrar o que eu aprendi no curso de "Java e Orientação a Objetos" e outros cursos Java.<br />
Nesse projeto eu coloco em prática algumas coisas que eu aprendi no curso, como criação de classes e objetos, enum, classes abstratas, final class, interface e classes de teste.<br />
Uso de getters e setters nos métodos, verificação de método com if, cálculos com atributos, uso de enum para armazenar números, criação de Lists e Maps.<br />
A escolha do LinkedList em comissão técnica e em jogadores e ArrayList em Funcionários ADM e Comum se deve ao fato que jogadores e comissão tem uma rotatividade grande, especialmente em times pequenos, por isso optei em uma list que privilegie menos gasto de memória e se organize melhor com exclusão e adição de objetos. Já os outros funcionários, preferi a Array pela rotatividade menor e pelo fato dos clubes de futebol, principalmente os pequenos, não contarem com muitos funcionários. <br /> 
Dentro dos maps e Lists, criação de unmodifiableList e unmodifiableMaps, métodos próprios de adicionar e remover da List e Maps, organização por nome e cargo.<br />
Uso de expressões lambdas e Method References.<br />
Throw de exceção em métodos, com uma Exception criada em uma classe própria.<br />
Testes automatizados de vários métodos com JUnit.<br />
Leitura e escrita de arquivos com métodos do Java.io como: 
- Criação de arquivos properties para armazenamento de dados de Login.<br />
- Leitura de arquivo .csv e converter o mesmo para criação de Jogadores, Funcionários e Comissão Técnica e ao mesmo tempo adicioná-los em List e Maps de forma automática.

Esse projeto foi feito no Java 17, usando o IntelliJ, sendo um projeto maven.<br />
Plugin utilizados:<br />
- Maven Compiler Plugin <br />
- Jacoco <br />
- JUnit<br />

# Versão 1.1

Esse projeto tem como motivo principal mostrar o que eu aprendi no curso de "Aprofunde em Java com arquitetura e padrões de projeto" e outros cursos Java.<br />
Nesse projeto eu coloco em prática algumas coisas que eu aprendi no curso, como os principios de Clean Architecture,Design Patterns e SOLID, protocolo HTTP Request, e etc..<br />
Refatorei muito meu código, usando esses principios, para facilitar a manuntenção e leitura do mesmo, com um código mais desacoplado<br />
Como por exemplo minha classe de lista de funcionários estava uma bagunça, e se utlizando desses princípios, separei o mesmo em muitos arquivos e deixei a leitura e manuntenção muito mellhor<br />
Criei uma classe Funcionarios para poder linkar todos as classes, Jogadores, Comissão técnica, Funcionários Comum e Funcionarios Administrativos e ter que repetir menos códigos que estavam duplicados em AtletasEComissao e FuncionariosGerais<br />
Uso maior de Interfaces, para o código ser mais dependente do mesmo e não de classes<br />
Separei os arquivos em 4 grupos: 
- Domínio, onde se encontram os dados principais dos funcionarios 
- Aplicacao, processos relacionados que se utilizam dos dados do domínio 
- Infraestrutura, todos os códigos que se relacionam o projeto com o mundo exterior
- InterfaceAPP(em breve), que no futuro vai ficar tudo que estiver relacionado com a tela do aplicativo.

Outras melhorias:
- Além da importação no conversor de csv para criar lista de Funcionários, eu fiz a exportação que faz o inverso .
- Substitui salário e outros números que usavam double para Big Decimal para melhorar a precisao dos cálculos
- Criei códigos de reajuste anual para Funcionários Administrativos e Comum
- Separação dos dados pessoais em 2 arquivos, o de Endereço, e de documentos, que permanece em dados pessoais
- Melhoria de verificação de CPF, CNPJ, e-mail, e telefone, que conta com um código ainda mais complexo
- Uso do HTTP Request para pegar um json de lista de Bancos quem tem no Brasil e transformando-o em maps (ainda necessita de melhorias)
- Refatoracao grande na lista de Funcionarios, e divisão do mesmo em vários arquivos
- Refatoracão em Bonificação
- Verificação de todos os testes em Junit, até aqueles que retornam uma resposta em System.out.println ou criação de arquivo

Esse projeto foi feito no Java 17, usando o IntelliJ, sendo um projeto maven.<br />
Plugin utilizados:<br />
- Maven Compiler Plugin
- Jacoco 
- JUnit
- OpenCSV
- Spring-Boot Starter Test
- Junit5 Capture System Output Extension

# Próximos passos:
- Converter esse projeto em Kotlin
- Vincular esse projeto a um banco de dados
- Usar esse projeto para gerar um APP
- Criar a interface do APP
