from model.lista.py import Lista

class exibicaoView:

    @staticmethod
    def exibir_lista(lista: list, frase: str) -> None:

        print(frase)
        for item in lista:
            print(item)
        print("--------------------------")
        print(f"Total de registros: {len(lista)}")

    @staticmethod
    def exibir_tempo_rotina(numero_rotina: int, tempo_ms: float) -> None:
        """Exibe o tempo de execução formatado."""
        print(f"Tempo (ms) rotina {numero_rotina}: {tempo_ms:.2f}")
        