package productoConsumidor;

public class Productor extends Thread
{
    private final Buffer buffer;

    public Productor(Buffer buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public void run()
    {
        int valor = 1;
        try
        {
            while(true)
            {
                buffer.producir(valor++);
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