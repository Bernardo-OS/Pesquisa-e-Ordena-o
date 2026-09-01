package app.model;

/** 
 * classe Processo
 */
public class Processo implements Comparable<Processo> {
    int id;
    String descricao;

    /**
     * construtor da classe Processo que instancia um objeto com id e descricao
     * @param id
     * @param descricao
     */
    public Processo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * sobreescrita do método toString. Formata a saída em texto do objeto Processo.
     */
    @Override
    public String toString() {
        return "Processo [id=" + id + ", descricao=" + descricao + "]";
    }

    /**
     * sobreescrita do método hashCode. Formata o código criado para idendtificação de objeto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    /**
     * sobreescrita do método equals. Acrescenta atributos para comparação entre objetos.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Processo other = (Processo) obj;
        if (id != other.id)
            return false;
        return true;
    }

    /**
     * sobreescrita do método compareTo. 
     * Reescrição faz controle de exceção caso objeto outro (que será comparado com atual this), for nulo.
     */
    @Override
    public int compareTo(Processo outro) {
        if (outro == null) {
            return 1; // Coloca objetos nulos no final da ordenação
        }
        return Integer.compare(this.id, outro.id);
    }
}