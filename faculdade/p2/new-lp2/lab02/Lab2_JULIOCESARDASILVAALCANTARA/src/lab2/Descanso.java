package lab2;
/**
*
* A classe Descanso representa o descanso de uma pessoa em relação ao número de horas de descanso e ao número de semanas que essa pessoa descansou.
 * @author Júlio César da Silva Alcantara - 122110504
*/

public class Descanso {
	/**
	 * O número de horas descansadas pelo aluno.
	 */
	private int horasDeDescanso;

	/**
	 * O número de semanas descansadas pelo aluno.
	 */
	private int semanasDeDescanso;
	/**
	 * Emote que descreve a sensação do aluno em relação a semana atual.
	 */
	private String emoticon;
	/**
	 * Estado atual do aluno em relação ao seu descanso.
	 */
	private String estadoAtual;
	/**
	 * Cria uma instância de Descanso com horas e semanas de descanso definidas como zero e um, respectivamente.
	 */
	public Descanso() {
		this.horasDeDescanso = 0;
		this.semanasDeDescanso = 1;
		this.emoticon = "";
		this.estadoAtual = "";
	}

	/**
	 * Define o número de horas de descanso.
	 *
	 * @param valor O número de horas de descanso a serem contabilizadas.
	 */
	public void defineHorasDescanso(int valor) {
		this.horasDeDescanso = valor;
	}
	/**
	 * Define o número de semanas de descanso.
	 * @param valor O número de semanas de descanso a ser definido.
	 */
	public void defineNumeroSemanas(int valor) {
		this.semanasDeDescanso = valor;
	}

	/**
	 *  Define o emoticon atual.
	 * @param valor - O emoticon atual a ser definido.
	 */
	public void atribuirEmoticon(String valor){
			this.emoticon = valor;
	}

	/**
	 * Busca o emoticon atual.
	 * @return o emoticon atual.
	 */
	private String getEmoticon(){
		return this.emoticon;
	}
	/**
	 * Retorna o status geral de descanso da pessoa.
	 *
	 * @return "descansado" se a relação entre as horas de descanso
	 * e as semanas de descanso for maior ou igual a 26, "cansado" caso contrário.
	 * CoISA Bônus - acrescenta emoticons que variam conforme o estado atual do estudante.
	 *
	 */
	public String getStatusGeral() {
		if (emoticon.equals("")){
			if(horasDeDescanso / semanasDeDescanso >= 26){
				return "descansado";}
			else {
				return "cansado";
			}

		}else{
			if (horasDeDescanso / semanasDeDescanso >= 26) {
				if(estadoAtual.equals("cansado")) {
					this.estadoAtual = "descansado";
					this.emoticon = "";
					return estadoAtual;
				}else{
					this.estadoAtual = "descansado";
					return estadoAtual + " - " + getEmoticon();
				}
			}else{
				if(estadoAtual.equals("descansado")){
					this.estadoAtual = "cansado";
					this.emoticon = "";
					return estadoAtual;
				}else{
					this.estadoAtual = "descansado";
					return estadoAtual + " - " + getEmoticon();
				}
			}

		}

	}
}
