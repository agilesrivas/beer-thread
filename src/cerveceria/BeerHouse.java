package cerveceria;

import java.util.Stack;

public class BeerHouse {
	
	private  Stack pilaCervezas;
	private int cantContenedor;
	
	public BeerHouse()
	{
		this.pilaCervezas=new Stack();
	}
	
	public Stack getPilaCervezas() {
		return pilaCervezas;
	}

	public void setPilaCervezas(Stack pilaCervezas) {
		this.pilaCervezas = pilaCervezas;
	}

	public int getCantContenedor() {
		return cantContenedor;
	}

	public void setCantContenedor(int cantContenedor) {
		this.cantContenedor = cantContenedor;
	}

	public synchronized String consumir()
	{
		this.cantContenedor=pilaCervezas.size();
		String objeto="";
		while(this.cantContenedor>=0)
		{
			try
			{
				 
				wait();
			}
			catch(InterruptedException e)
			{
				
			}
		}
		objeto=(String) this.pilaCervezas.pop();
		notify();
		return objeto;
		
	}
	public synchronized void producir(int value)
	{
		this.cantContenedor=this.pilaCervezas.size();
		System.out.println("Valor del productor:"+this.cantContenedor);
		while(this.cantContenedor<=100)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				System.out.println("Contenedor:error->"+e.getMessage());
			}
		}
		//this.pilaCervezas.push(value);
		notify();
		
	}

}
