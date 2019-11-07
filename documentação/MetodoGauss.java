public class MetodoGauss{

	/**
	instânciando objeto da classe matriz para armazenar os valores.
	*/
	protected static Matriz m;									// matriz

	/**
	Calcula o valor das variáveis.
	Recebe um objeto da classe matriz e calcula o valor dos coeficientes dos sistemas de equações,
	lançando exceções, caso a matriz passada seja nula ou caso o sistema não seja solucionável.
	@param mat Matriz contendo os coeficientes e os valores finais do sistemas de equações.
	@throws Exception se for fornecido uma matriz nula, ou se o sistema fornecido
                      não for solucionável.
	@return um Vetor double com os possíveis X que solucionam a equação.
	*/
	public static double[] Calcular(Matriz mat)throws Exception
	{
		if(mat == null)												// verifica exceções
			throw new Exception("Matriz nula");

		m = (Matriz)mat.clone();									// faz um clone da matriz

		if(!isSolucionavel())										// verifica se o sistema é solucionável
		{
			throw new Exception("Sistema de equações impossível de se resolver");
		}

		int auxiliar = haZerosNaDiagonal();							// declara auxiliar que recebe a linha se há zeros na diagonal
																	// haZerosNaDiagonal() -> retorna < se não houver zeros
																	//				  	   -> retorna a linha se houver zeros


		while(auxiliar >= 0)										// enquanto há zeros na diagonal
		{
			tirarZerosDaDiagonal(auxiliar);							// tira s zero, da posição auxiliar, da diagonal
			auxiliar = haZerosNaDiagonal();							// verifica se ainda há zeros na diagonal
		}

		for(int i = 0; i < m.getLinhas(); i++)						// passa por todas as colunas
		{
			tornarDiagonal(i);										// torna a diagonal presente na coluna 1
			zerarColuna(i);											// zera a coluna
		}

		elementosDiferentesDeZero();								// TO DO: fazer o comentário disso

		return getResultado();										// retorna o resultado
	}

	/**
	Verifica se certo valores de um vetor está em outro vetor.
	Recebe um vetor de valores e um vetor e verifca se esses valores estão contido nesse outro vetor,
	lançando exceções, caso od vetores double forem nulos.
	@param vetorDivisao Vetor com valores a serem verificados.
	@param vetorDivisao2 valor que será procurado
	@throws Exception se um dos vetores passados forem nulos.
	@return um boolean dizendo se estes valores estão em ambos os valores.
	*/
	protected static boolean estaNoVetor(double[] vetorDivisao, double vetorDivisao2) throws Exception
	{
		if(vetorDivisao == null)											// verifica exceção
			throw new Exception("vetor nulo");

		for(int i=0; i<m.getLinhas(); i++)									// passa por todos os elementos do vetor
			if(vetorDivisao[i] != vetorDivisao2)							// verifica se os elementos de i é igual ao valor passado para procurar
				return false;

		return true;
	}

	/**
	Verifica se o sistema de equações lineares é solucionável.
	Verifica se o sistema de equações pode ser resolvido.
	@return Um valor boolean , se for true é solucionável e false não é.
	*/
	protected static boolean isSolucionavel()
	{
		try
		{
			for(int i = 0; i < m.getLinhas()-1; i++)								// passa por todas as colunas até a penultima
			{
				double[] divisoes = new double[m.getLinhas()];						// declara um vetor do tamanho de coeficientes da equação
				for(int j = 0; j < m.getLinhas(); j++)								// passa por todas as linhas
				{
					double divisao2 = m.getValor(i, j) / m.getValor(i + 1, j);		// faz a divisão de um valor pelo valor da linha de baixo
					divisoes[j] = divisao2;											// adiciona no vetor divisões
				}

				double valorQueNaoPodeRepetir = divisoes[0];						// pega um valor do vetor, esse valor não pode se repetir em todo o vetor
				int qtdFoi = 0;														// quantas vezes se repetiu

				if(estaNoVetor(divisoes, valorQueNaoPodeRepetir))					// verifica se está no vetor
					qtdFoi++;														// soma 1 a quantidade de vezes que foi

				if(qtdFoi == m.getLinhas() - 1)										// se o qtdFoi for igual a quantidade de coeficientes
					return false;													// retorna false
			}
		}
		catch(Exception ex)
		{
			System.err.println("Não foi possível verficar se é solucionável");
		}
		return true;
	}

	/**
	Verica se há zeros na diagoal.
	Verifica se há zeros na diagonal e retorna a linha da diagonal, que é igual a coluna, se não houver zeros,
	retornará um valor negativo.
	@return A posição, se houver, e se não houver retorna um valor negativo.
	*/
	protected static int haZerosNaDiagonal()
	{
		try
		{
			for(int i=0; i<m.getLinhas(); i++)		// passa por todas as linhas
				if(m.getValor(i,i) == 0)			// verifica se a posição (linha, linha) é 0
					return i;						// retorna a linha
		}
		catch(Exception ex)
		{}
		return -1;									// retorna um valor negativo
	}

	/**
	Retira os zeros da diagoal.
	Retira os zeros da diagonal passada como parâmetro.
	@param linha Linha qual o zero será retirado.
	*/
	protected static void tirarZerosDaDiagonal(int linha){
		try
		{
			for(int j = 0; j < m.getLinhas() - 1; j++)			// passa por todas as linhas
			{
				int linhaNova = j - 1;							// inicia o valor da linha que receberá a linha anterio

				if(linhaNova < 0)								// se a linha for menor que zero
					linhaNova = m.getLinhas() - 1;				// ele voltará para a ultima linha

				double auxiliar[] = new double[m.getColunas()]; // vetor auxiliar que receberá uma linha

				for(int i = 0; i < m.getColunas(); i++)			// passa por todas as colunas da matriz
				{
					auxiliar[i] = m.getValor(j, i);				// vetor auxiliar recebe os valores da linha i
				}

				for (int i = 0; i < m.getColunas(); i++)		// passa por todas as colunas da matriz
				{
					m.incluir(j, i, m.getValor(linhaNova, i));	// inclui o valor da linhaNova na linha j
					m.incluir(linhaNova, i, auxiliar[i]);		// inclui o valor do vetor auxiliar na linhaNova
				}
			}
			// Move as linha para cima até retirar os zeros da diagonal
		}
		catch(Exception ex){}//como todos os valores existem e estão nos parametros da matriz não há possibilidade de erro
	}

	/**
	Torna a diagonal 1.
	Torna a diagonal 'linha' igual o valor 1.
	@param linha Linha qual a diagonal se tornará 1.
	*/
	protected static void tornarDiagonal(int linha){
		try
		{
			double aux = m.getValor(linha, linha);				// declara a variável que receberá o valor necessário para dividir
			for(int n=0; n<m.getLinhas() + 1; n++)				// passa por todo o vetor
				m.incluir(linha, n, m.getValor(linha,n)/aux);	// inclui no vetor o os valores da posição linha, n dividido por aux
		}
		catch(Exception ex){}//como todos os valores existem e estão nos parametros da matriz não há possibilidade de erro
		// torna a diagonal 1
	}

	/**
	Zera toda a coluna.
	Recebe uma coluna e faz as operações para zerar toda a coluna menos a diagonal.
	@param coluna Coluna que será zerada.
	*/
	protected static void zerarColuna(int coluna){
		// coluna => coluna que será zerada
		try
		{
			for(int j = 0; j < m.getLinhas(); j++)							// passa por todas as linhas
			{
				if(m.getValor(j, coluna) != 0 && j != coluna)				// verifica se o valor de (j, coluna) não é 0 ou se (j, coluna) não é a diagonal
				{
					double aux = m.getValor(j, coluna);						// pega o valor da posição (j, coluna)

					double vetorAux[] = new double[m.getColunas()];

					for(int i = 0; i < m.getColunas(); i++)
					{
						vetorAux[i] = m.getValor(coluna, i) * -aux;			// adiciona no vetor o valor da linha com o sinal trocado
						m.incluir(j, i, m.getValor(j, i) + vetorAux[i]);	// soma os valores do vetorAuxiliar na linha da Matriz
					}
				}
			}
		}
		catch(Exception ex){}
		// zera a coluna
	}

	/**
	Zera os elementos que são diferentes de zero.
	Procura os elementos que ainda não são diferentes de zero e zera eles.
	*/
	protected static void elementosDiferentesDeZero(){
		try{
			for(int i=0; i<m.getLinhas(); i++)
				for(int j=0; j<m.getColunas()-1; j++)
					if(i!=j)
						if(m.getValor(i, j)!=0){
							zerarFinal(i,j);
						}
		}
		catch(Exception e){}
	}

	/**
	Zera os elementos que são diferentes de zero.
	Procura os elementos que ainda não são diferentes de zero e zera eles.
	@param lin Linha do elemento que será zerado.
	@param col COluna do elemento que será zerado.
	*/
	protected static void zerarFinal(int lin, int col){
		try{
			double aux = m.getValor(lin,col);
			double vetorAux[] = new double[m.getColunas()];

			for(int i = 0; i < m.getColunas(); i++)
			{
				vetorAux[i] = m.getValor(col, i) * -aux;
				m.incluir(lin, i, m.getValor(lin, i) + vetorAux[i]);
			}
		}
		catch(Exception e){}
	}

	/**
	Retorna o resultado.
	retorna um vetor double com todos os 'X' que satisfazem as equações.
	@return um vetor double.
	*/
	protected static double[] getResultado(){
		double[] aux = null;							// vetor na qual será colocado a resposta
		try{
			 aux = new double[m.getLinhas()];			// tamanho = variaveis = coeficientes
			 for(int i=0; i<m.getLinhas(); i++)			// passa por todas as linhas
			 	aux[i] = m.getValor(i, m.getLinhas());	// pega os calores da ultima coluna
		}
		catch(Exception ex){}
		// colocou todas as respostas no vetor auxiliar
		return aux;
	}
}