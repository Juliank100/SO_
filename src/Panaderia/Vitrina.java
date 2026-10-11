package Panaderia;

import java.util.LinkedList;
import java.util.Queue;

public class Vitrina
{
    //Pan especial que avisa a los clientes que la panaderia cerro
    public static final String CERRADO = "CERRADO";

    private final Queue<String> panes = new LinkedList<>();
    private final int capacidad;

    public Vitrina(int capacidad)
    {
        this.capacidad = capacidad;
    }

    //metodo para hornear (antes producir)
    public synchronized void hornear(String pan) throws InterruptedException
    {
        while(panes.size() == capacidad)
        {
            //Si la vitrina esta llena el panadero espera
            wait();
        }
        panes.add(pan);
        System.out.println(Thread.currentThread().getName() + " horneó " + pan
                + " | vitrina: " + panes.size() + "/" + capacidad);
        //notificamos a los clientes que hay un nuevo pan en la vitrina
        notifyAll();
    }

    //Metodo para comprar (antes consumir)
    public synchronized String comprar() throws InterruptedException
    {
        while(panes.isEmpty())
        {
            //Si la vitrina esta vacia el cliente espera
            wait();
        }
        String pan = panes.poll();
        System.out.println(Thread.currentThread().getName() + " compró " + pan
                + " | vitrina: " + panes.size() + "/" + capacidad);
        //Notificamos a los panaderos que se libero un espacio en la vitrina
        notifyAll();
        return pan;
    }
}