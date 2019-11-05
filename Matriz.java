public class Matriz
{

	private double mat[][];
	private int linhas;
	private int colunas;


	//TO DO: docs desse metodo
	public Matriz(int linhas) throws Exception
	{
		if(linhas < 1)
			throw new Exception("Número de linhas menor que 1");

		mat = new double[linhas][linhas+1];
		this.linhas=linhas;
		this.colunas= linhas + 1;
	}

	/**
	Inclui um valor.
	Inclui um valor double na posicao (linha, coluna) da matriz,
	lançando exceções, se a linha ou a coluna for menores que zero.
	@param i linha.
	@param j coluna.
	@param valor valor a ser inserido na matriz.
	@throws Exception se o valor da linha e da coluna for menor que 0.
	*/
	public void incluir(int i, int j, double valor) throws Exception
	{
		if(i < 0 || j < 0)
			throw new Exception("valor invalido");

		mat[i][j] = valor;
	}

	/**
	Pega um valor.
	Pega um valor da matriz da posição (linha, coluna) e retorna como double,
	lançando exceções, se a linha ou a coluna for menores que zero.
	@param i linha.
	@param j coluna.
	@return um valor do tipo double
	@throws Exception se o valor da linha e da coluna for menor que 0.
	*/
	public double getValor(int i, int j)throws Exception
	{
		if(i < 0 || j < 0)
			throw new Exception("valor invalido");

		return mat[i][j];
	}

	/**
	Pega a quantidade de linhas.
`	Pega a quantidade de linhas da matriz.
	@return a quantidade de linhas da matriz.
	*/
	public int getLinhas()
	{
		return this.linhas;
	}

	/**
	Pega a quantidade de colunas.
	Pega a quantidade de colunas da matriz.
	@return a quantidade de colunas da matriz.
	*/
	public int getColunas()
	{
		return this.colunas;
	}

	// TODO:  escolher toString()
	/* public String toString()
	{
		String ret = "";
		for(int i = 0; i < linhas; i++)
			for(int j=0; j<colunas; j++)
				ret += " valor na posicao: "+ i +" , "+ j + ": " + Double.toString(mat[i][j])+ "\n";

		ret +="quanidade de linhas: "+linhas;
		ret +="quanidade de colunas: "+colunas;

		return ret;
	} */

	/**
	    Gera uma representação textual de todo conteúdo da matriz.
	    Produz e resulta um String com todos os nomes e telefones contidos
	    na matriz.
	    @return um String contendo todo o conteúdo da matriz.
    */
	public String toString()
	{
		String ret = "Matriz["+ linhas +"]["+ colunas +"] = \n";
		for(int i = 0; i < linhas; i++)
		{
			for(int j=0; j<colunas; j++)
				ret += mat[i][j] + " ";
			ret += "\n";
	}


		return ret;
	}

	/**
	    Calcula o código de espalhamento (ou código de hash) de uma matriz.
	    Calcula e resulta o código de espalhamento (ou código de hash, ou ainda o
	    hashcode) da matriz representada pela instância à qual o método for aplicado.
	    @return o código de espalhamento da agenda chamante do método.
    */
	public int HashCode()
	{
		int ret = 19185;
		for(int i = 0; i < linhas; i++)
		{
			for(int j=0; j<colunas; j++)
				ret = 3*ret + Double.valueOf(mat[i][j]).hashCode();
		}
		ret = 3*ret + Integer.valueOf(linhas).hashCode();
		ret = 3*ret + Integer.valueOf(colunas).hashCode();
		return ret;
	}

	/**
	    Verifica a igualdade entre duas matrizes.
	    Verifica se o Object fornecido como parâmetro representa uma
	    matriz igual àquela representada pela instância à qual este
	    método for aplicado, resultando true em caso afirmativo,
	    ou false, caso contrário.
	    @param  obj o objeto a ser comparado com a instância à qual esse método
	            for aplicado.
	    @return true, caso o Object fornecido ao método e a instância chamante do
	            método representarem agendas iguais, ou false, caso contrário.
    */
	public boolean Equals(Object obj)
	{
		if (this==obj)
			return true;

		if (obj==null)
			return false;

		if (this.getClass()!=obj.getClass())
			return false;

		Matriz aux = (Matriz)obj;

		for(int i = 0; i < linhas; i++)
			for(int j=0; j<colunas; j++)
				if(aux.mat[i][j] != this.mat[i][j])
					return false;

		if(aux.linhas != this.linhas || aux.colunas != this.colunas)
			return false;

		return true;
	}

	/**
	    Constroi uma cópia da instância da classe Matriz dada.
	    Para tanto, deve ser fornecida uma instancia da classe Matriz para ser
	    utilizada como modelo para a construção da nova instância criada.
	    @param modelo a instância da classe Matriz a ser usada como modelo.
	    @throws Exception se o modelo for null.
    */
	public Matriz(Matriz m) throws Exception
	{
		 if(m==null)
		 	throw new Exception("Matriz nula");
		 mat = m.mat;
		 linhas = m.linhas;
		 colunas = m.colunas;
	}

	/**
	    Clona uma matriz.
	    Produz e resulta uma cópia da matriz representada pela instância
	    à qual o método for aplicado.
	    @return a cópia da matriz representada pela instância à qual
	            o método for aplicado.
    */
	public Object clone()
	{
		Matriz ret = null;
		try
		{
			ret = new Matriz(this);
		}
		catch(Exception e){}
		return ret;
	}
}