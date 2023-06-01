package lab2;

/**
 * Representa o registro de tempo online de uma disciplina, que contém informações como o nome da disciplina,
 * o tempo online acumulado e a meta de tempo online esperada
 *
 * @author Júlio César da Silva Alcantara - 122110504
 */
public class RegistroTempoOnline {
	/**
	 * O nome da disciplina na qual será registrado o tempo Online.
	 */
	private String nomeDisciplina;
	/**
	 * O tempo total acumulado na disciplina.
	 */
	private int tempoOnlineAcumulado;
	/**
	 * A meta de tempo de estudo da disciplina
	 */
	private int metaTempoOnline;

	/**
	 * Cria um novo registro de tempo online para uma disciplina com a meta de tempo online padrão de 120 minutos.
	 * @param nomeDisciplina O nome da disciplina
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.metaTempoOnline = 120;
	}

	/**
	 * Cria um novo registro de tempo online para uma disciplina com uma meta de tempo online específica.
	 * @param nomeDisciplina O nome da disciplina.
	 * @param metaTempoOnline A meta de tempo online esperada para a disciplina.
	 */
	public RegistroTempoOnline(String nomeDisciplina, int metaTempoOnline) {
		this.nomeDisciplina = nomeDisciplina;
		this.metaTempoOnline = metaTempoOnline;
	}

	/**
	 * Adiciona um tempo online específico ao tempo online acumulado da disciplina.
	 * @param tempoOnline O tempo online a ser adicionado.
	 */
	public void adicionaTempoOnline(int tempoOnline) {
		tempoOnlineAcumulado += tempoOnline;
	}

	/**
	 * Verifica se a meta de tempo online esperada para a disciplina foi atingida.
	 * @return true se a meta foi atingida, false caso contrário.
	 */
	public boolean atingiuMetaTempoOnline() {
		return tempoOnlineAcumulado >= metaTempoOnline;
	}

	@Override
	public String toString() {
		return nomeDisciplina + " " + tempoOnlineAcumulado + "/" + metaTempoOnline;
	}
}