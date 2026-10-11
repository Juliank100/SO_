package productoConsumidor;

public class Consumidor extends Thread
{
    private final Buffer buffer;

    public Consumidor(Buffer buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                buffer.consumir();
                //se simula el tiempo de consumo
                Thread.sleep(500);
            }
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
