class ListaController
{
    public static void PopularListas(List<int> listaBolha, List<int> listaSelecao, List<int> listaInsercao, int quantidade)
    {
        PopularLista(listaBolha, quantidade);
        PopularLista(listaSelecao, quantidade);
        PopularLista(listaInsercao, quantidade);
    }
    public static void PopularLista(List<int> lista, int quantidade)
    {
        Random gerador = new Random();
        for (int i = 0; i < quantidade; i++)
        {
            lista.Add(gerador.Next(100000));
        }
    }

    public static void Bolha(List<int> lista)
    {
        bool houveTroca;
        int tmp;
        long qtdComparacoes = 0, qtdTrocas = 0;

        do
        {
            houveTroca = false;
            for (int i = 0; i < lista.Count() - 1; i++)
            {
                qtdComparacoes++;
                if (lista[i] > lista[i + 1])
                {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = tmp;
                }
            }
        } while (houveTroca);
    }

    public static void Selecao(List<int> lista)
    {
        int posMenor;
        int tmp;
        long qtdComparacoes = 0, qtdTrocas = 0;

        for (int i = 0; i < lista.Count() - 1; i++)
        {
            posMenor = i;
            for (int j = i + 1; j < lista.Count(); j++)
            {
                qtdComparacoes++;
                if (lista[j] < lista[posMenor])
                {
                    posMenor = j;
                }
            }
            if (i != posMenor)
            {
                qtdTrocas++;
                tmp = lista[i];
                lista[i] = lista[posMenor];
                lista[posMenor] = tmp;
            }
        }
        
    }

    public static void Insercao(List<int> lista)
    {
        int i, j;
        int tmp;
        long qtdComparacoes = 0, qtdTrocas = 0;

        for (i = 1; i < lista.Count(); i++)
        {
            tmp = lista[i];
            for (j = i - 1; j >= 0; j--)
            {
                qtdComparacoes++;
                if (tmp < lista[j])
                {
                    lista[j + 1] = lista[j]; //shift eh trocar para o lado
                    qtdTrocas++;
                }
                else break;
            }
            lista[j + 1] = tmp;
            qtdTrocas++;
        }
    }
    
}