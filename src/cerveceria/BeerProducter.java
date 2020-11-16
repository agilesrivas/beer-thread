package cerveceria;

import java.util.HashMap;
import java.util.Random;

public class BeerProducter extends Thread{

	
		private HashMap<String,String>porProducir;
		private Random numeroAleatorio;
		private BeerHouse contenedor;
		
		public BeerProducter(BeerHouse contenedor)
		{
			this.contenedor=contenedor;
			this.numeroAleatorio=new Random();
			this.porProducir=new HashMap<>();
		}
		


		public void setPorProducir(HashMap<String, String> porProducir) {
			this.porProducir = porProducir;
		}
		public Random getNumeroAleatorio() {
			return numeroAleatorio;
		}

		public void setNumeroAleatorio(Random numeroAleatorio) {
			this.numeroAleatorio = numeroAleatorio;
		}
		public BeerHouse getContenedor() {
			return contenedor;
		}
		public void setContenedor(BeerHouse contenedor) {
			this.contenedor = contenedor;
		}

		public String produccionAleatoria()
		{
			String valor=Integer.toString(this.numeroAleatorio.nextInt(10));
			System.out.println("valor del aleatorio:"+valor);
			return this.porProducir.get(valor);	
		}
		@Override
		public void run()
		{
			String valor=produccionAleatoria();
			this.contenedor.getPilaCervezas().push(valor);
			
			System.out.println("El valor producido es:"+valor);
			
			while(this.contenedor.getPilaCervezas().size()>=100)
			{
				try
				{
					Thread.sleep(1500);
				}
				catch(InterruptedException e)
				{
				
				}
			}
			
		}






		public HashMap<String, String> getPorProducir1() {
			// TODO Auto-generated method stub
			return this.porProducir;
		}
	
	

}
