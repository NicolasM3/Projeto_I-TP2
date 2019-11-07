import java.io.*;
import Matriz.*;

public class TesteMatriz
{
	public static void main (String[] args)
    {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		for (;;)
		{
			try
			{
				System.out.print ("Capacidade desejada para a Matriz: ");
				int cap = Integer.parseInt (entrada.readLine ());
				Matriz m  = new Matriz(cap);
			}
			catch (NumberFormatException e)
			{
				System.err.println ("Nao foi digitado um numero inteiro\n\n");
			}
			catch (Exception e)
			{
				System.err.println (e.getMessage()+"\n\n");
			}
		}
	}
}
