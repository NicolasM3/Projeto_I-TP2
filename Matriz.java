public class Matriz
{

	private double mat[][];
	private int linhas;
	private int colunas;

	public Matriz(int linhas) throws Exception
	{
		if(linhas < 1)
			throw new Exception("Número de linhas menor que 0");

		mat = new double[linhas][linhas+1];
		this.linhas=linhas;
		this.colunas= linhas + 1;
	}

	public void incluir(int i, int j, double valor) throws Exception
	{
		if(i < 0 || j < 0)
			throw new Exception("valor invalido");

		mat[i][j] = valor;
	}

	public double getValor(int i, int j)throws Exception
	{
		if(i < 0 || i < j)
			throw new Exception("valor invalido");

		return mat[i][j];
	}

	public int getLinhas()
	{
		return this.linhas;
	}

	public int getColunas()
	{
		return this.colunas;
	}

	public String toString()
	{
		String ret = "";
		for(int i = 0; i < linhas; i++)
			for(int j=0; j<colunas; j++)
				ret += " valor na posicao: "+i+" , "+j+Double.toString(mat[i][j]);

		ret +="quanidade de linhas: "+linhas;
		ret +="quanidade de colunas: "+colunas;

		return ret;
	}

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
	public boolean Equals(Object obj)
	{
		if (this==obj)
			return true;

		if (obj==null)
			return false;

		if (this.getClass()!=obj.getClass())
			return false;

		Matriz aux = (Matriz)obj;

		for(int i = 0; i < linhas; i++){
			for(int j=0; j<colunas; j++)
				if(aux.mat[i][j] != mat[i][j])
					return false;
		}

		if(aux.linhas != this.linhas || aux.colunas != this.colunas)
			return false;

		return true;
	}
	public Matriz(Matriz m) throws Exception
	{
		 if(m==null)
		 	throw new Exception("Matriz nula");
		 mat = m.mat;
		 linhas = m.linhas;
		 colunas = m.colunas;
	}

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