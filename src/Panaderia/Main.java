package Panaderia;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Vitrina vitrina = new Vitrina(4);

        Panadero ana = new Panadero("Ana", "Pandebono", vitrina);
        Panadero luis = new Panadero("Luis", "Almojábana", vitrina);

        Cliente[] clientes = new Cliente[3];
        for(int i = 0; i < clientes.length; i++)
        {
            clientes[i] = new Cliente("Cliente-" + (i + 1), vitrina);
        }

        ana.start();
        luis.start();
        for(Cliente c : clientes)
        {
            c.start();
        }

        //1. main espera a que terminen los panaderos
        ana.join();
        luis.join();

        //2. main pone un CERRADO por cada cliente
        for(int i = 0; i < clientes.length; i++)
        {
            vitrina.hornear(Vitrina.CERRADO);
        }

        //3. main espera a los clientes e imprime el total (debe ser 16)
        int total = 0;
        for(Cliente c : clientes)
        {
            c.join();
            total += c.getComprados();
        }
        System.out.println("Total de panes comprados: " + total);
    }
}