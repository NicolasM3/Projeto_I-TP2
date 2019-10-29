public class Matriz{

	private double mat[][];
	private long linhas;

	public Matriz(int linhas){
		mat = new double[linhas][linhas+1];
		this.linhas=linhas;
	}

	public void incluir(int i, int j, double valor) throws Exception{
		if(i < 0 || j < 0)
			throw new Exception("valor invalido");
		mat[i][j] = valor;
	}

	public double getValor(int i, int j)throws Exception{
		if(i < 0 || i < j)
			throw new Exception("valor invalido");
		return mat[i][j];
	}

	public float getLinhas(){
		return this.linhas;
	}


	public String toString(){
		String ret = "";
		for(int i = 0; i < linhas; i++){
			for(int j=0; j<linhas+1; j++)
				ret = Double.toString(mat[i][j]);
		}
		return ret;
	}

	public int HashCode(){
		int ret = 19185;
		for(int i = 0; i < linhas; i++){
			for(int j=0; j<linhas+1; j++)
				ret = 3*19185 + Double.valueOf(mat[i][j]).hashCode();
		}
		return ret;
	}
	public boolean Equals(Object obj){
		if (this==obj)
			return true;

		if (obj==null)
			return false;

		if (this.getClass()!=obj.getClass())
			return false;

		Matriz aux = (Matriz)obj;

		for(int i = 0; i < linhas; i++){
			for(int j=0; j<linhas+1; j++)
				if(aux.mat[i][j] != mat[i][j])
					return false;
		}

		if(aux.linhas != this.linhas)
			return false;

		return true;
	}
	 public Matriz(Matriz m) throws Exception{
		 if(m==null)
		 	throw new Exception("Matriz nula");
		 mat = m.mat;
		 linhas = m.linhas;
	}

	public Object clone(){
		Matriz ret = null;
		try{
			ret = new Matriz(this);
		}
		catch(Exception e){}
		return ret;
	}
}