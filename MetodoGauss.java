//TO DO: tornar classe singleton
public class MetodoGauss{

	private static Matriz m;

	public static double[] Calcular(Matriz mat)throws Exception
	{
		if(mat == null)
			throw new Exception("Matriz nula");

		m = (Matriz)mat.clone();

		if(!isSolucionavel())
			throw new Exception("Sistema de equações impossível de se resolver");

		int teste = HaZerosNaDiagonal();

		while(teste >= 0)
		{
			tirarZerosDaDiagonal(teste);
			teste = HaZerosNaDiagonal();
		}

		for(int i=0; i< m.getLinhas(); i++)
		{
			for(int j=0; j<m.getColunas(); j++)
				System.out.print(m.getValor(i,j) + " ");
			System.out.println("");
		}

		tornarDiagonal1();
		transformarEmZeros();
		double[] aux = getResultado();

		return getResultado();
	}

	private static boolean estaNoVetor(double[] vetorDivisao, double[] vetorDivisao2)
	{
		for(int i=0; i<m.getLinhas(); i++)
			if(vetorDivisao[i] != vetorDivisao2[i])
				return false;

		return true;
	}

	public static boolean isSolucionavel()
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


	private static int HaZerosNaDiagonal()
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

	private static void tirarZerosDaDiagonal(int linha){
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
	//TO DO corrigir a troca
	private static void tornarDiagonal1(){
		try{
			for(int i=0; i<m.getLinhas(); i++){
				double aux = m.getValor(i,i);
				for(int n=0; n<m.getLinhas()+1; n++)
					m.incluir(i, n, m.getValor(i,n)/aux);
			}
		}
		catch(Exception ex){}//como todos os valores existem e estão nos parametros da matriz não há possibilidade de erro
	}


	private static void transformarEmZeros(){
		try{
			for(int i=0; i<m.getLinhas(); i++)
				for(int n=0; n<m.getLinhas(); n++)
					if(n!=i && m.getValor(i,n)!=0){//como não devemos zerar zero ou o que esta na diagonal principal fazemos este if
						double[] aux = new double[m.getLinhas()+1];
						aux = passarProVetor(aux, n, m.getValor(i,n));
						subtrair(aux, i);
					}
		}
		catch(Exception ex){}
	}


	private static double[] passarProVetor(double[] aux, int linha, double valorARemover){
		try{
			for(int i=0; i<m.getLinhas()+1; i++)
				aux[i] = m.getValor(linha, i)*-valorARemover;
		}
		catch(Exception ex){}
		return aux;
	}


	private static void subtrair(double[] subtrair, int linha){
		try{
			for(int i=0; i<m.getLinhas()+1; i++){
				double aux = m.getValor(linha, i)-subtrair[i];
				m.incluir(linha, i, aux);
			}
		}
		catch(Exception ex){}
	}

	private static double[] getResultado(){
		double[] aux = null;
		try{
			 aux = new double[m.getLinhas()];
			 for(int i=0; i<m.getLinhas(); i++)
			 	aux[i] = m.getValor(i, m.getLinhas());
		}
		catch(Exception ex){}
		return aux;
	}

	//TO DO: metodo dividir linha pelas proximas
}