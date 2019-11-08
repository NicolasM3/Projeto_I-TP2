package Matriz;
/**
A classe Matriz representa uma simples Matriz, com base em outra matriz, que armazena os valores double, o n�mero de linhas e oolunas.
Inst�ncias desta classe permitem a reliza��o das opera��es b�sicas de uma matriz, como incluir e pegar valores e imprimir a matriz.
Nela encontramos, por exemplo, m�todos para incluir, excluir e listar valores da matriz.
@author Marcelo S�coli(19185), N�colas Oliveira(19193).
@since 2019.
*/
public class Matriz
{
	/**
	Variavel que armazena uma matriz double.
	*/
	protected double mat[][];
	/**
	Variavel que armazena a quantidade de linhas
	*/
	protected int linhas;
	/**
		Variavel que armazena a quantidade de colunas
	*/
	protected int colunas;


	/**
	Constroi um inst�ncia da classe matriz.
	Recebe a quantidade de linhas e cria um objeto da classe matriz de tamanha (linhas, linhas + 1),
	lan�ando exce��es, se linhas for menor que 1.
	@param linhas quantidade de linhas da matriz.
	@throws Exception se a quantidade de linha for menor que 1.
	*/
	public Matriz(int linhas) throws Exception
	{
		if(linhas < 1)//Verificamos se a quantidade de linhas � valida
			throw new Exception("N�mero de linhas menor que 1");

		mat = new double[linhas][linhas+1];//Instanciamos a matriz
		this.linhas=linhas;
		this.colunas= linhas + 1;//Armazenamos nas colunas a quantidade de linhas + 1
	}

	/**
	Inclui um valor.
	Inclui um valor double na posicao (linha, coluna) da matriz,
	lan�ando exce��es, se a linha ou a coluna for menores que zero.
	@param i linha.
	@param j coluna.
	@param valor valor a ser inserido na matriz.
	@throws Exception se o valor da linha e da coluna for menor que 0.
	*/
	public void incluir(int i, int j, double valor) throws Exception
	{
		if(i < 0 || j < 0 || i > linhas || j > colunas)//Verificamos se os indices n�o s�o menores que 0 ou maiores do que a quantidade de linhas ou colunas.
			throw new Exception("valor invalido");

		mat[i][j] = valor;//Incluimos o valor na matriz.
	}

	/**
	Pega um valor.
	Pega um valor da matriz da posi��o (linha, coluna) e retorna como double,
	lan�ando exce��es, se a linha ou a coluna for menores que zero.
	@param i linha.
	@param j coluna.
	@return um valor do tipo double
	@throws Exception se o valor da linha e da coluna for menor que 0.
	*/
	public double getValor(int i, int j)throws Exception
	{
		if(i < 0 || j < 0 || i > linhas || j > colunas)//Verificamos se os indices n�o s�o menores que 0 ou maiores do que a quantidade de linhas ou colunas.
			throw new Exception("valor invalido");

		return mat[i][j];//Retornamos o valor presente nessa posi��o.
	}

	/**
	Pega a quantidade de linhas.
`	Pega a quantidade de linhas da matriz.
	@return a quantidade de linhas da matriz.
	*/
	public int getLinhas()
	{
		return this.linhas;//Retorna a quantidade de linhas da matriz.
	}

	/**
	Pega a quantidade de colunas.
	Pega a quantidade de colunas da matriz.
	@return a quantidade de colunas da matriz.
	*/
	public int getColunas()
	{
		return this.colunas;//Retorna a quantidade de colunas da matriz.
	}

	/**
	    Gera uma representa��o textual de todo conte�do da matriz.
	    Produz e resulta um String com todos os nomes e telefones contidos
	    na matriz.
	    @return um String contendo todo o conte�do da matriz.
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
	    Calcula o c�digo de espalhamento (ou c�digo de hash) de uma matriz.
	    Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
	    hashcode) da matriz representada pela inst�ncia � qual o m�todo for aplicado.
	    @return o c�digo de espalhamento da agenda chamante do m�todo.
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
	    Verifica se o Object fornecido como par�metro representa uma
	    matriz igual �quela representada pela inst�ncia � qual este
	    m�todo for aplicado, resultando true em caso afirmativo,
	    ou false, caso contr�rio.
	    @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
	            for aplicado.
	    @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
	            m�todo representarem agendas iguais, ou false, caso contr�rio.
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
	    Constroi uma c�pia da inst�ncia da classe Matriz dada.
	    Para tanto, deve ser fornecida uma instancia da classe Matriz para ser
	    utilizada como modelo para a constru��o da nova inst�ncia criada.
	    @param modelo a inst�ncia da classe Matriz a ser usada como modelo.
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
	    Produz e resulta uma c�pia da matriz representada pela inst�ncia
	    � qual o m�todo for aplicado.
	    @return a c�pia da matriz representada pela inst�ncia � qual
	            o m�todo for aplicado.
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