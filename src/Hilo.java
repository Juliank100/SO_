/**
 * Práctica de ejecución simultánea de hilos.
 */
public class Hilo {
    public static void main(String[] args) throws InterruptedException {
        Thread hiloUno = crearHilo("Hilo 1");
        Thread hiloDos = crearHilo("Hilo 2");

        hiloUno.start();
        hiloDos.start();

        // Espera a que ambos terminen antes de finalizar el programa.
        hiloUno.join();
        hiloDos.join();

        System.out.println("Los dos hilos terminaron.");
    }

    private static Thread crearHilo(String nombre) {
        return new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(nombre + ": paso " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }, nombre);
    }
}
