class ExibicaoView
{
    PopularListaController ListaController = new PopularListaController();


    public static void ExibirLista(List<int> lista)
    {
        foreach (int item in lista)
        {
            Console.WriteLine(item);
        }
    }

    public static void ExibirTempo(Stopwatch sw, string frase)
    {
        Console.WriteLine(frase + " (ms): " + sw.ElapsedMilliseconds);
    }

    public static void Main(string[] args)
    {
        List<int> listaSort = new List<int>();
        Stopwatch sw = new Stopwatch();
        int quantidade;

        try
        {
            Console.Write("Quantos números deseja trabalhar? ");
            quantidade = int.Parse(Console.ReadLine());

            ListaController.PopularListas(listaSort, quantidade);

            sw.Start();
            listaSort.Sort();
            sw.Stop();
            ExibirTempo(sw, "Ordenando por sort nativo");
            sw.Reset();
            
            sw.Start();
            ListaController.Bolha(listaBolha);
            sw.Stop();
            ExibirTempo(sw, "Ordenando por bolha");
            sw.Reset();

            sw.Start();
            ListaController.Selecao(listaSelecao);
            sw.Stop();
            ExibirTempo(sw, "Ordenando por seleção");
            sw.Reset();

            sw.Start();
            ListaController.Insercao(listaInsercao);
            sw.Stop();
            ExibirTempo(sw, "Exibindo por inserção");
            sw.Reset();
        
        }
        catch (Exception e)
        {
            Console.WriteLine(e.Message);
        }
    }
}