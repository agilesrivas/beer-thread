package cerveceria;

public class BeerConsumer extends Thread {
	
	private int contenido;
	private BeerHouse contenedor;
	
	public BeerConsumer(BeerHouse contenedor)
	{
		this.contenedor=contenedor;
	}

	public int getContenido() {
		return contenido;
	}

	public void setContenido(int contenido) {
		this.contenido = contenido;
	}

	public BeerHouse getContenedor() {
		return contenedor;
	}

	public void setContenedor(BeerHouse contenedor) {
		this.contenedor = contenedor;
	}

	@Override
	public void run() {

		while(this.getContenedor().getPilaCervezas().size()!=0)
		{
			
			System.out.println("Consumido:"+this.contenedor.consumir());
		}
	}
	
	
}
