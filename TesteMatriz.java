import java.io.IOException;
import java.io.BufferedReader;

public class TesteMatriz
{
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

	for (;;)
	{
		System.out.print ("Capacidade desejada para a Agenda: ");
		try
		{
			int cap = Integer.parseInt (entrada.readLine ());
			agenda  = new AgendaConsultavel (cap);
			break;
		}
		catch (IOException e)
		{}
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
