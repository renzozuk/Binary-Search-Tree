# Implementação de uma Árvore Binária de Busca (ABB)

## Introdução

Este projeto projeto se trata de uma implementação de uma árvore binária de busca. Aqui, será apresentado como compilar e executar o programa, além de apresentar os métodos presentes na implementação.

## Guia para a instalação de software

Neste projeto, utiliza-se a versão 17 do JDK. Portanto, caso você não o tenha instalado, aqui vai algumas instruções de como instalar esta versão do `Java`:

Basta acessar acessar o seu terminal `Linux` e colocar o seguinte comando:

`sudo apt install openjdk-17-jdk`

Para verficar se a instalação ocorreu bem, bastas colocar o seguinte comando no terminal:

`java --version`

A resposta esperada deve ser parecida com essa:

`openjdk 17.0.8.1 2023-08-24`

`OpenJDK Runtime Environment (build 17.0.8.1+1-Ubuntu-0ubuntu122.04)`

`OpenJDK 64-Bit Server VM (build 17.0.8.1+1-Ubuntu-0ubuntu122.04, mixed mode, sharing)`

Além disso, o projeto contém dois arquivos por padrão. Um com uma lista de comandos `commands.txt` e outro com uma entrada para montar uma árvore binária de busca `tree.txt`.

Caso você queira uma lista de comandos personalizada e uma árvore personalizada, você pode por substiruir os arquivos que vêm por padrão pelos seus arquivos. Vale ressaltar que, você deve por nome do arquivo com a lista de comandos de `commands.txt` e o arquivo com a entrada para a árvore de `tree.txt`.

Se tudo ocorreu bem, esta etapa está finalizada.

## Executando e compilando o programa:

Para compilar o programa, basta inserir no terminal:

`javac application/Program.java`

Para executá-lo, primeiro você deve transferir os arquivos `tree.txt` e `commands.txt` para a pasta src. Logo após, basta inserir no terminal:

`java application/Program`


Outra alternativa:

Ao clonar este repositório e realizar os passos acima. Basta escolher sua `IDE` de preferência e importar o projeto nela.

Desta forma, basta executar o programa e ele vai ler os arquivos.

## Modelo dos comandos:

Aqui vai um exemplo de como listar os comandos caso você crie um `commands.txt` personalizado.

Exemplo:

ENESIMO N <br>
POSICAO N <br>
MEDIANA <br>
CHEIA <br>
COMPLETA <br>
IMPRIMA S <br>
REMOVA N <br>


## Desenvolvido por:

Renzo Paulo e Yuri Filgueira.