package productoConsumidor;

public class Main
{
    public static void main() {
        Buffer buffer = new Buffer(10);

        Productor p= new Productor (buffer);
        Consumidor c= new Consumidor (buffer);

        p.start();
        c.start();

    }
}

