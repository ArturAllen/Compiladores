# Compiladores
Especificação

* * * * * * * * *
Sumário
1. Iniciando um código na IsiLanguage
1. Declaração e tipos de variáveis
1. Comando de Leitura
1. Comando de Escrita
1. Atribuindo valores a variáveis
1. Operações com conjuntos
1. Comando de decisão
1. Repetição: laço 'para'
1. Repetição: laço 'para' sobre um conjunto
1. Repetição: laço enquanto
1. Erros e avisos
* * * * * * * * *

Projeto desenvolvido para a disciplina de compiladores, oferecida pela UFABC no segundo quadrimestre de 2021, ministrada pelo professor Francisco Isidro Massetto.

O compilador reconhece a linguagem IsiLanguage com algumas modificações e gera código em C.

* * * * * * * * *
1. Iniciando um código na IsiLanguage
* * * * * * * * *

Todo código, deve ser iniciado com "programa", e encerrado com "fimprog;". Um programa deve ter pelo menos uma variável declarada e pelo menos um comando. Todas as declarações e comandos devem ser terminados pelo caracter ';'.

* * * * * * * * *
2. Declaração e tipos de variáveis
* * * * * * * * *

Os tipos de dados da linguagem são: inteiro, decimal, texto, vetor e conjunto. Para declarar uma variável deve-se escrever o tipo da variável e em seguida o seu nome. O nome de uma variável deve, obrigatoriamente, começar com uma letra minúscula e pode conter letras maiúsculas, letras minúsculas e algarismos. Se uma variável receber o mesmo nome de uma variável já declarada, será exibida uma mensagem de erro. Se a variável for um vetor, também deve-se indicar o seu tamanho após o nome. Mais de uma variável pode ser declarada na mesma linha, devendo ser separandas com o caracter ','.

Exemplos de declaração de variáveis:

    inteiro a;
    decimal b, c;
    texto t1, t2, t3;
    conjunto d;
    vetor v 10, array 5;
    
Os tipos inteiro e decimal são equivalentes a int e double, respectivamente, na linguagem C. Texto é equivalente a vetor de caracter (texto t -> char t[256]) e é limitado a 256 caracteres. Vetor é equivalente a vetor de inteiro e terá o tamanho especificado na declaração (vetor v 10 -> int v[10]). É possível acessar a posição de um vetor da seguinte forma: "VETOR[N]", onde VETOR é o nome do vetor e N é um valor inteiro ou uma variável do tipo inteiro. O alcance de um vetor de tamanho n é de 0 a n-1. Uma mensagem de erro será exibida caso VETOR não for do tipo vetor ou se N não for um inteiro ou uma variável do tipo inteiro. O tipo conjunto está definido no arquivo set.h. Um conjunto aceita apenas valores inteiros cada valor está contido apenas uma vez. Um conjunto não aceita valaores maiores ou iguais a 256. Conjuntos são ordenados, então um conjunto contendo 2 e 1 será igual a um conjunto contendo e 2.

* * * * * * * * *
3. Comando de Leitura
* * * * * * * * *

É possível ler uma variável a partir de uma entrada do usuário com o comando de leitura. A sintaxe do comando de leitura é "leia(VAR);", onde VAR é uma variável. Os tipos vetor e conjunto não são passíveis de leitura dessa forma, mas é possível ler posições individuais de um vetor. Uma mensagem de erro será exibida caso a variável seja do tipo vetor ou conjunto.

* * * * * * * * *
4. Comando de Escrita
* * * * * * * * *

O comando de escrita permite que o valor de uma variável seja escrita no console. A sintaxe do comando de escrita é "escreva(VAR)", onde VAR é a variável que se deseja escrever. O tipo vetor não pode ser escrito desta forma, mas é possível escrever posições individuais de um vetor. Uma mensagem de erro será exibida caso a variável seja do tipo vetor. Se a variável for do tipo conjunto, os elementos do conjunto serão escritos, em ordem, entre colchetes e separados por vírgula. o comando "espaco()" imprime um espaço (' ') e "linha" imprime uma quebra de linha ('\n').

* * * * * * * * *
5. Atribuindo valores a variáveis
* * * * * * * * *

É possível atribuir um valor a uma variável através do comando de atribuição. A sintaxe do comando de atribuição é: "VAR=ATT". Se VAR for uma variável do tipo inteiro ou decimal, ou acesso a uma posição de um vetor, ATT poderá ser uma expressão algébrica. Uma expressão algébrica contém um ou mais valores inteiros, decimais, variáveis dos tipos inteiro ou decimal ou acesso a uma posição de um vetor. Cada termo deve estar separado por um operador '+', '-', '/' ou '*'. Se VAR for uma variável do tipo inteiro, há a possibilidade de utilizar o operador '%', com limite de dois termos que devem, obrigatoriamente, ser inteiros ou variáveis do tipo inteiro. Um valor inteiro é composto por um ou mais algarismos entre um e nove. Um valor decimal pode conter um '.' para separar o valor decimal. Se VAR for do tipo vetor, então ATT poderá ser uma declaração implícita dos elementos do vetor, separados por vírgula e entre chaves. O vetor não pode ser vazio. Se VAR for do tipo conjunto, ATT poderá ser uma declaração implícita dos elementos de um conjunto, entre colchetes e separados por vírgula. Um conjunto pode ser vazio. Variáveis do tipo texto não podem ser usadas em atribuições. Mensagens de erro serão exibidas ao atribuir declarações implícitas de vetores e conjuntos a variáveis inteiras e decimais e posições de vetores, ao atribuir expressões algébricas a variáveis do tipo vetor e conjunto, ao utilizar variáves do tipo texto, vetor, conjunto em uma expressão algébrica e ao utilizar variáveis do tipo texto em atribuições. Um aviso (Warning) será exibido caso uma variável utilizada não tenha sido inicializada, isto é, lida ou declarada implicitamente.

Exemplos de atribuições:

    inteiro a, b;
    a=5;
    b=2*a;
    
    inteiro a;
    decimal x, y;
    a=1;
    y=2.5
    x=y/3.01;
    x=a+y;

    vetor v 5;
    v = {8, 2, 4, 0, 6};
    
    conjunto c, d;
    c = [2, 2, 1, 5, 10];
    d = [10, 5, 2, 1]; (Note: c e d denotam o mesmo conjunto)

* * * * * * * * *
6. Operações com conjuntos
* * * * * * * * *

Um conjunto pode sofrer atibuição com a sintaxe "A := B OP C". OP representa um operador, que poderá ser '+', '-', '*' ou '<<', indicando as operações união, diferença, intersecção e inclusão, respectivamente. A e B devem, obrigatoriamente, ser variáveis do tipo conjunto. C deve ser uma variável do tipo conjunto ou, caso a operação seja de inclusão, um inteiro ou uma variável do tipo inteiro. Operações com conjunto são limitadas a dois operandos. 

Exemplo de operações com conjuntos:

    conjunto c, d, e;
    inteiro i;
    
    d=[2, 2, 1, 5, 10];
    e=[10, 5, 2, 1, 23];
    
    c:=d+e; (c=[1,2,5,10,23])
    c:=d*e;	(c=[1,2,5,10])
    c:=d-e; (c=[])
    c:=e-d; (c=[23])
    
    i=7;
    c:=c<<i;(c=[7,23])
    c:=d<<8;(c=[1,2,5,8,10])

* * * * * * * * *
7. Comando de decisão
* * * * * * * * *

O comando de decisão tem a sintaxe "se(EXP OR EXP){CMDS}". Opcionalmente, pode ser adicionado ao final "senao{CMDS}". CMDS pode ser qualquer conjunto não vazio de comandos reconhecíveis pela linguagem. EXP deverá ser uma expressão algébrica e OR um operador relacional. Os operadores relacionais são '<', '>', '<=', '>=', '==', '!=' e funcionam como em C e Java. Os comandos do bloco 'se' serão executados caso a condição expressa entre parêntesis seja verdadeira, e os comandos dentro do bloco senão não serão executados. Por outro lado, se a condição for verdadeira, os comandos dentro do bloco 'se' serão ignorados e somente os comandos do bloco 'senao' serão executados.

* * * * * * * * *
8. Repetição: laço 'para'
* * * * * * * * *

O comando 'para' permite que comandos reconhecíveis pela linguagem sejam executados várias vezes. A sintaxe é "para A de B ate C faca {CMDS}". CMDS pode assumir qualquer comando reconhecível. A deve ser uma variável do tipo inteiro ou decimal, B e C devem ser valores inteiros ou decimais ou variáveis dos tipos inteiros ou decimais. A assumirá inicialmente o valor de B e a cada iteração será incrementada unitariamente enquanto seu valor for menor ou igual a C. Deve-se tomar cuidados para que B seja menor que C, ou o programa entrará em loop perpétuo. 

Exemplo utilizando o comando para:

    inteiro i, fatorial, n;
    
    n=5;
    fatorial=1;
    
    para i de 1 ate n faca{
	      fatorial = fatorial*i;
    }
    escreva(fatorial); (120)

* * * * * * * * *
9. Repetição: laço 'para' sobre um conjunto
* * * * * * * * *

Alternativamente, é possível utilizar o comando 'para' para iterar sobre os elementos de um conjunto com a sintaxe "para A em B faca {CMDS}", onde A é uma variável do tipo inteiro e B é uma variável do tipo conjunto. A cada iteração, A assumira, em ordem crescente, cada elemento do conjunto B. Em ambas as formas do comando para, uma mensagem de erro será impressa caso tipos incompatíves de variáveis sejam utilizados.
Exemplo utilizando o comando para com um conjunto:
    
    inteiro i, somaConjunto;
    conjunto c;
    
    c=[9, 5, 3, 9, 9, 0, 9];
    somaConjunto=0;
    
    para i em c faca{
        somaConjunto=somaConjunto+i;
    }
    escreva(somaConjunto); (17)

* * * * * * * * *
10. Repetição: laço enquanto
* * * * * * * * *

Por fim, o comando 'enquanto' é outra forma de repetir comandos. A sintaxe é "enquanto(EXP OR EXP){CMDS}". A expressão entre parêntesis deve ser de acordo com o que foi descrito no comando 'se'. Os comandos no entre as chaves serão executados enquanto a expressão entre parêntesis for verdadeira.

* * * * * * * * *
11. Erros e avisos
* * * * * * * * *

Ocorrerão erros semânticos ao declarar uma variável de mesmo nome que uma variável já declarada, uso de uma variável não declarada e atribuição entre tipos incompatíveis. Avisos (warnings) serão exibidos se houver acesso a variáveis não inicializadas e não utilização de variáveis.
