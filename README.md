# Gerenciador-de-Times-1.0
Meu primeiro projeto em Java. Esse projeto consiste em um banco de dados de um RH de um time de Futebol, onde controlamos os dados dos Jogadores, Comissao Técnica e Funcionários.<br />
Dentro desses dados, organizamos os dados pessoas, como Nome, RG, CPF, dados bancários e etc. E organizamos os funcionários em 4 categorias que armazenados em lista: Funcionários Comum, Funcionarios Administrativos, Jogadores e Comissão Técnica.

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

Esse projeto é apenas um esboço, ainda preciso melhorar muita coisa nesse arquivo, como uma criação de interface (que possívelmente no futuro irá se transformar em um aplicativo Android).<br />
Além disso, eu quero melhorar meu código em vários pontos. Um deles é o fato que eu tenho 4 Lists e 4 Maps para armazenar dados de Jogadores, Comissão técnica, Funcionários Comum e Funcionarios Administrativos.<br />
Como eu decidi fazer uma unmodifiableList e unmodifiableMaps, eu acabei sendo obrigado a ter 4 códigos identicos para cada categoria de funcionário, o que dificulta a manuntenção do mesmo, por isso no futuro eu quero ter um jeito de proteger meu código, sem ter o mesmo quadruplicado.

Esse projeto foi feito no Java 17, usando o IntelliJ, sendo um projeto maven.<br />
Plugin utilizados:<br />
- Maven Compiler Plugin <br />
- Jacoco <br />
- JUnit<br />

Espero que venha mais projetos, cada vez mais completos e melhores
