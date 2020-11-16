package cerveceria;



public class Main {

	private static BeerHouse contenedor;
    private static Thread productor;
    private static Thread [] consumidores;
    private static final int CANTIDADCONSUMIDORES = 5;
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        contenedor = new BeerHouse();
        BeerProducter productor1=new BeerProducter(contenedor);
        productor1.getPorProducir1().put("1", "ale");
        productor1.getPorProducir1().put("2", "alej");
        productor1.getPorProducir1().put("3", "alejan");
        productor1.getPorProducir1().put("4", "alejandr");
        productor1.getPorProducir1().put("5", "alejandrito");
        productor1.getPorProducir1().put("6", "alejandruto");
        productor1.getPorProducir1().put("7", "alejandrritu");
        productor1.getPorProducir1().put("8", "alejandroto");
        productor = new Thread(productor1);
        consumidores = new Thread[CANTIDADCONSUMIDORES];
 
       for(int i = 0; i < CANTIDADCONSUMIDORES; i++)
        {
            consumidores[i] = new Thread(new BeerConsumer(contenedor));
            consumidores[i].start();
        }
         
        productor.start();
        
        
    }    

}
