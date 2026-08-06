from model/lista.py import lista
from view/ExibirView.py import ExibicaoView

class ListaController:
    def executaProcessamento:
        tempoInicio = 0
        tempoFim = 0

        listaAleatoria = []
        listaSequencial = []

        #Rotina 1 Aleatória:
        inicio = time.perf_counter()



        fim = time.perf_counter()
        ExibicaoView.exibir_lista
        print(f"Demorou: {fim - inicio:.4f} segundos")


        #Rotina 2 Sequencial:
        inicio = time.perf_counter()
        
        
        
        fim = time.perf_counter()
        print(f"Demorou: {fim - inicio:.4f} segundos")