public class MetodoGauss{

	/**
	instânciando objeto da classe matriz para armazenar os valores.
	*/
	protected static Matriz m;

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
		if(mat == null)
			throw new Exception("Matriz nula");

		m = (Matriz)mat.clone();

		if(!isSolucionavel())
			throw new Exception("Sistema de equações impossível de se resolver");

		int teste = haZerosNaDiagonal();

		while(teste >= 0)
		{
			tirarZerosDaDiagonal(teste);
			teste = haZerosNaDiagonal();
		}

		for(int i = 0; i < m.getLinhas(); i++)
		{
			tornarDiagonal(i);
			zerarColuna(i);
			//System.out.println(i);
		}

		//System.out.println(mat.toString());

		elementosDiferentesDeZero();

		double[] aux = getResultado();

		return getResultado();
	}

	/**
	Verifica se certo valores de um vetor está em outro vetor.
	Recebe um vetor de valores e um vetor e verifca se esses valores estão contido nesse outro vetor,
	lançando exceções, caso od vetores double forem nulos.
	@param vetorDivisao Vetor com valores a serem verificados.
	@param vetorDivisao2 Segundo vetor para comparação.
	@throws Exception se um dos vetores passados forem nulos.
	@return um boolean dizendo se estes valores estão em ambos os valores.
	*/
	protected static boolean estaNoVetor(double[] vetorDivisao, double[] vetorDivisao2) throws Exception
	{
		if(vetorDivisao == null || vetorDivisao2 == null)
			throw new Exception("Um dos vetores nulos");

		for(int i=0; i<m.getLinhas(); i++)
			if(vetorDivisao[i] != vetorDivisao2[i])
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
			double[] divisao = new double[m.getLinhas()];
			double[] divisao2 = new double[m.getLinhas()];
			for(int i = 0; i < m.getLinhas()-2; i++)
			{
				for(int j = 0; j < m.getLinhas(); j++)
				{
					//System.err.println(m.getValor(j, i) + " " + m.getValor(j+1, i) + "\n " + i);
					divisao[j] = m.getValor(i, j) / m.getValor(i + 1, i);
					divisao2[j] = m.getValor(i+1, j) / m.getValor(i + 2, i);
				}
				if(estaNoVetor(divisao, divisao2))
					return false;
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
			for(int i=0; i<m.getLinhas(); i++)
				if(m.getValor(i,i) == 0)
				{
					return i;
				}
		}
		catch(Exception ex)
		{}
		return -1;
	}

	/**
	Retira os zeros da diagoal.
	Retira os zeros da diagonal passada como parâmetro.
	@param linha Linha qual o zero será retirado.
	*/
	protected static void tirarZerosDaDiagonal(int linha){
		try
		{
			for(int j = 0; j < m.getLinhas() - 1; j++)
			{
				int linhaNova = j - 1;

				if(linhaNova < 0)
					linhaNova = m.getLinhas() - 1;

				double auxiliar[] = new double[m.getColunas()];

				for(int i = 0; i < m.getColunas(); i++)
				{
					auxiliar[i] = m.getValor(j, i);
				}

				for (int i = 0; i < m.getColunas(); i++)
				{
					m.incluir(j, i, m.getValor(linhaNova, i));
					m.incluir(linhaNova, i, auxiliar[i]);
				}
			}
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
			double aux = m.getValor(linha, linha);
			for(int n=0; n<m.getLinhas() + 1; n++)
				m.incluir(linha, n, m.getValor(linha,n)/aux);
		}
		catch(Exception ex){}//como todos os valores existem e estão nos parametros da matriz não há possibilidade de erro
	}

	/**
	Zera toda a coluna.
	Recebe uma coluna e faz as operações para zerar toda a coluna menos a diagonal.
	@param coluna Coluna que será zerada.
	*/
	protected static void zerarColuna(int coluna){
		try
		{
			for(int j = 0; j < m.getLinhas(); j++)
			{
				if(m.getValor(j, coluna) != 0 && j != coluna)
				{
					double aux = m.getValor(j, coluna);
					//System.out.println("a : " + aux);

					double vetorAux[] = new double[m.getColunas()];

					for(int i = 0; i < m.getColunas(); i++)
					{
						vetorAux[i] = m.getValor(coluna, i) * -aux;
						m.incluir(j, i, m.getValor(j, i) + vetorAux[i]);
						//System.out.print(vetorAux[i] + " ");
					}
					//System.out.println(m.toString());
				}
			}
		}
		catch(Exception ex){}
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
		double[] aux = null;
		try{
			 aux = new double[m.getLinhas()];
			 for(int i=0; i<m.getLinhas(); i++)
			 	aux[i] = m.getValor(i, m.getLinhas());
		}
		catch(Exception ex){}
		return aux;
	}
}