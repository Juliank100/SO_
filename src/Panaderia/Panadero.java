package Panaderia;

public class Panadero extends Thread
{
    private final Vitrina vitrina;
    private final String tipoPan;

    public Panadero(String nombre, String tipoPan, Vitrina vitrina)
    {
        super(nombre);
        this.tipoPan = tipoPan;
        this.vitrina = vitrina;
    }

    @Override
    public void run()
    {
        try
        {
            for(int i = 1; i <= 8; i++)
            {
                vitrina.hornear(tipoPan + "-" + i);
                //se simula el tiempo de hornear
                Thread.sleep(800);
            }
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}