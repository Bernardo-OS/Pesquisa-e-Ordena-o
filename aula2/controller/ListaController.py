from model.lista import lista
from view.ExibirView import ExibicaoView
import time

class ListaController:

    def __init__(self):
        self.model = ListaModel()
        self.view = TerminalView()

    def executar(self) -> None:

        #Rotina 1 Aleatória:
        inicio = time.perf_counter()
        self.model.popular_lista_aleatoria(quantidade=100000, inicio=100, fim=100000)
        fim = time.perf_counter()

        # Calcula a diferença e converte de nanosegundos para milisegundos
        tempo_ms_aleatoria = (fim - inicio) / 1_000_000
        self.view.exibir_tempo_rotina(1, tempo_ms_aleatoria)

        print(f"Demorou: {tempo_ms_aleatoria} segundos")


        #Rotina 2 Sequencial:
        inicio = time.perf_counter()
        self.model.popular_lista_sequencial(quantidade=100000, inicio=1)
        fim = time.perf_counter()

        # Calcula a diferença e converte de nanosegundos para milisegundos
        tempo_ms_sequencial = (fim - inicio) / 1_000_000
        self.view.exibir_tempo_rotina(1, tempo_ms_sequencial)

        print(f"Demorou: {tempo_ms_sequencial} segundos")