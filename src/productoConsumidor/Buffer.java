package productoConsumidor;

import java.util.LinkedList;
import java.util.Queue;
public class Buffer
{
    private final Queue<Integer> bufferCola = new LinkedList<>();
    private int capacidad = 0;

    public Buffer(int capacidad)
    {
        this.capacidad = capacidad;
    }

    //metodo para producir
    public synchronized  void producir(int valor) throws InterruptedException
    {
        while(bufferCola.size()== capacidad)
        {
            //Si la cola esta llena esperamos
            wait();
        }
        bufferCola.add(valor);
        //notificamos a los consumidores que hay un nuevo elemento en el buffer
        notifyAll();
    }

    //Metodo para consumir
    public synchronized int consumir() throws InterruptedException
        {
        while(bufferCola.isEmpty())
        {
            //Si la cola esta vacia esperamos
            wait();
        }
        int valor = bufferCola.poll();
        System.out.println("Valor Consumido: " + valor);
        //Notificamos a los productor que fue consumido un elemto en el buffer
            notifyAll();
            return valor;
        }
}
