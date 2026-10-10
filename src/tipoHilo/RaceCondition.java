package tipoHilo;

/**
 * Demostración intencional de una condición de carrera.
 * El contador no está protegido: el resultado puede ser menor que el esperado.
 */
public class RaceCondition {
    static int counter = 0;

    public void runTest(int threads, int iterations) throws InterruptedException {
        counter = 0;
        Thread[] workers = new Thread[threads];

        for (int i = 0; i < threads; i++) {
            workers[i] = new Thread(() -> {
                for (int j = 0; j < iterations; j++) {
                    counter++; // Operación no segura: lectura, suma y escritura no son atómicas.
                }
            }, "Trabajador-" + (i + 1));
            workers[i].start();
        }

        for (Thread worker : workers) {
            worker.join();
        }

        int expected = threads * iterations;
        System.out.println("Esperado = " + expected + " | Obtenido = " + counter);
        System.out.println("Ejecuta el programa varias veces: el valor obtenido puede variar.");
    }
}
