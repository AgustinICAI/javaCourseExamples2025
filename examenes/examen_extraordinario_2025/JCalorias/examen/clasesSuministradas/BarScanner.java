package examen.clasesSuministradas;

public class BarScanner {
    private static final String[] EANS = {"111", "112", "113", "114"};
    private static int index = 0;

    // Devuelve secuencialmente un EAN de los existentes
    public String read() {
        String ean = EANS[index];
        index = (index + 1) % EANS.length;
        return ean;
    }
}
