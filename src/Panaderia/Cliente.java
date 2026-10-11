package Panaderia;

public class Cliente extends Thread
{
    private final Vitrina vitrina;
    private int comprados = 0;

    public Cliente(String nombre, Vitrina vitrina)
    {
        super(nombre);
        this.vitrina = vitrina;
    }

    public int getComprados()
    {
        return comprados;
    }

    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                String pan = vitrina.comprar();
                if(pan.equals(Vitrina.CERRADO))
                {
                    //la panaderia cerro, el cliente se va
                    break;
                }
                comprados++;
                //se simula el tiempo de comerse el pan
                Thread.sleep(300);
            }
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}