#Métodos de ordenação:

##Bolha:
  começa no index 0, um pergunta para o próximo se é maior, se for, troca.
  É o mais lento dos 3, mas considerado mais simples de lógica.

##Seleção:
  Começa no index 0, e percorre outra vez em mais outro laço de repetição nos demais elementos, se acha um menor, troca posição. É instável (parece bagunçar mais no processo).
  - O laço externo escolhe a posição atual que vai receber o menor valor (começa no 0, depois 1, 2...).Assume temporariamente que o elemento da posição atual é o menor.
  - O laço interno percorre o restante da lista à direita para achar um número realmente menor.
  - Se achar, atualiza o índice do menor. No fim do laço interno, troca o valor da posição atual com o valor do menor índice encontrado.Repete até o vetor inteiro ficar ordenado.
  Segundo menos lento, um pouco mais elaborado com complexidade maior.

##Inserção:
  Começa do segundo elemento da lista, e laço interno compara se há menores para o lado esquerdo.
  - Inicia i no segundo elemento (índice 1). O primeiro elemento (índice 0) já é considerado uma "lista ordenada" de um único item.
  - Guarde o elemento atual em uma variável temporária (chamada de chave ou pivô).
  - Olhe para trás: Compare a chave com os elementos que estão à esquerda dela (na parte ordenada).
  - Desloque os maiores: Enquanto o elemento da esquerda for maior que a sua chave, mova esse elemento uma posição para a direita.
  - Insira a chave: Assim que encontrar um elemento menor (ou chegar ao início da lista), insira a chave na vaga que sobrou.Avance: Vá para o próximo elemento da direita e repita o processo até o fim da lista.
