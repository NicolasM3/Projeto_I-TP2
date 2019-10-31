//TO DO: tornar classe singleton
public class MetodoGauss{

	private static Matriz m;
	private static double ret[] = new double[10];

	public static double[] Calcular(Matriz mat)throws Exception
	{
		if(mat == null)
			throw new Exception("Matriz nula");

		m = (Matriz)mat.clone();

		if(!isSolucionavel())
			throw new Exception("Sistema de equações impossível de se resolver");

		HaZerosNaDiagonal();
		//transformarEmZeros();
		//getResultado();



		return ret;
	}

	private static boolean estaNoVetor(double valorAVerificar, double[] vetor)
	{
		for(double a:vetor)
			if(a == valorAVerificar)
			{
				return true;
			}

		return false;
	}

	public static boolean isSolucionavel()
	{
		try
		{
			double divisaoColuna [];
			for(int j = 0; j < m.getColunas() - 2; j++)
			{
				divisaoColuna = new double[m.getLinhas()];
				for(int i = 0; i < m.getLinhas(); i++)
				{
					//System.err.println(m.getValor(j, i) + " " + m.getValor(j+1, i));
					double result = m.getValor(j, i) / m.getValor(j + 1, i);
					if(estaNoVetor(result, divisaoColuna))
						return false;
				}
			}
		}
		catch(Exception ex)
		{
			System.err.println("Não foi possível verficar se é solucionável");
		}
		return true;
	}


	private static void HaZerosNaDiagonal() throws Exception
	{
		try
		{
			for(int i=0; i<m.getLinhas(); i++)
				if(m.getValor(i,i) == 0)
				{
					tirarZerosDaDiagonal(i);
				}
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

	// TO DO: arrumar método tirarZerosDaDiagonal()
	private static void tirarZerosDaDiagonal(int i){
		try
		{
			boolean achou=false;
			for(int n=0; n<m.getLinhas()+1; n++)
				if(m.getValor(i, n)!=0 && achou==false)
				 {
					m.incluir(i, i, m.getValor(i, n));
					m.incluir(i, n, 0.0);
					achou=true;
				}
		}
		catch(Exception ex){}//como todos os valores existem e estão nos parametros da matriz não há possibilidade de erro
	}

	/*private void void tornarDiagonal1(){
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


	private double[] passarProVetor(double[] aux, int linha, double valorARemover){
		try{
			for(int i=0; i<m.getLinhas()+1; i++)
				aux[i] = m.getValor(linha, i)*-valorARemover;
		}
		catch(Exception ex){}
		return aux;
	}


	private void subtrair(double[] subtrair, int linha){
		try{
			for(int i=0; i<m.getLinhas()+1; i++){
				double aux = m.getValor(linha, i)-subtrair[i];
				m.incluir(linha, i, aux);
			}
		}
		catch(Exception ex){}
	}

	private double[] getResultado(){
		double[] aux = null;
		try{
			 aux = new double[m.getLinhas()];
			 for(int i=0; i<m.getLinhas(); i++)
			 	aux[i] = m.getValor(i, m.getLinhas());
		}
		catch(Exception ex){}
		return aux;
	}

	public double[] calculoGauss(){
		tirarZerosDaDiagonal();
		tornarDiagonal1();
		transformarEmZeros();
		return getResultado();
	}*/
	//TO DO: metodo dividir linha pelas proximas
}