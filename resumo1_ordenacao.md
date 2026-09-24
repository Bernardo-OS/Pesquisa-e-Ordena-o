using System.ComponentModel;
 
Métodos de Ordenação
    - Ordenar é um recurso para busca ou pesquisa otimizada
    - Categorias de algoritmos de ordenação
        - Simplicidade versus complicação (quantidade do código)
            simples:
                - bolha
                - seleção
                - inserção
                - agitação
                - pente
            complicado:
                - merge
                - quick
        - Estabilidade versus instalibilidade
            estável:
                - bolha
                - agitação
                - inserção
                - merge
            instáveis:
                - seleção
                - pente (por causa da distância ou gap ou h)
                - quick (por causa da distância)
        - Complexidade: alta (muito esforço) versus baixa (pouco esforço)
            - como se calcula esforço ou a complexidade em ordenação (QUANTIDADE de comparações + QUANTIDADE de trocas)
            - funções de complexidade:
                - O(n!) - fatorial
                - O(n^k) - polinomial
                - O(n^2) - exponencial
                - O(n . log n) - linear vezes logaritmica
                - O(n) - linear
                - O(log n) - logartimica (todos os algoritmos baseados na filosofia de ÁRVORE)
        - Peculiaridades
            - bolha - agitação - inserção: se a estrutura já estiver ordenada, há baixo esforço - O(n)
            - pente: com a entrada da distância, o pente fica muito melhor em termos de complexidade. O pente trabalha com distância. Enquanto a distância for maior que 1, o método é instável. Quando a distância fica 1, o método se transforma no bolha e fica estável.
            - seleção: se um vetor estiver ordenado, o método continua fazendo o mesmo esforço de ordenação de um vetor desordenado
            - merge e o quick: são baseados em técnicas recursivas. Para cada método, há 2 submétodos
                - merge: chamada recursiva e o submétodo intercalação (ordenação se dá na volta do empilhamento)
                    - Java o utiliza
                - quick: chamada recursiva e o submétodo posicionar (posicionar o pivo no seu lugar certo, no empilhamento)
                    - C# o utiliza
 
    - Outros métodos de ordenação
        - Shell sort: é uma evolução do inserção. Usa a mesma filosofia de melhora do pente com o bolha. Ou seja, aplica uso de distância (gap). Como o pente, o Shell, ao trabalhar com distância, é instável. Mas quando a distância fica 1, ele se transforma no inserção e passa a ser estável.
 
        - Heap sort: baseado na teoria de árvore, porém, dentro de uma lista
 
        - Bucket sort: método de ordenação pelo dígito do número
 
        - Radix sort: melhoria do Bucket
 
 
           
 
void bolha(List<int> lista)
{
    int tmp;
    bool houveTroca;
    int dist = lista.Count();
    do
    {
        dist = (int)(dist / 1.3);
        if (dist < 1)
        {
            dist = 1;
        }
        houveTroca = false;
        for (int i = 0; i+dist < lista.Count() - 1; i++)
        {
            if (lista[i] > lista[i + dist])
            {
                houveTroca = true;
                tmp = lista[i];
                lista[i] = lista[i+dist];
                lista[i+dist] = tmp;
            }
        }
    } while (dist > 1 || houveTroca);
}
