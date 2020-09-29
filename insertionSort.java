public class insertionSort {

    /*
    [1],  [6], [5], [3], [7], [9], [10], [2], [112], [45], [65]

    #1:
    [1],  [5], [6], [3], [7], [9], [10], [2], [112], [45], [65]

    #2:
    [1],  [3], [5], [6], [7], [9], [10], [2], [112], [45], [65]

    #3:
    [1],  [2], [3], [5], [6], [7], [9], [10], [112], [45], [65]

    #4:
    [1],  [2], [3], [5], [6], [7], [9], [10], [45], [112], [65]

    #5:
    [1],  [2], [3], [5], [6], [7], [9], [10], [45], [65], [112]
     */

    public static void main(String[] args) {

        // Angabe unsortierte Liste
        int[] line = {
                1, 6, 5, 3, 7, 9, 10, 2, 112, 45, 65
        };

        insertion(line);


    }

    public static void insertion(int[] line) {

        // Durchläuft den Array
        for (int i = 1; i < line.length - 1; i++) {

            // Kontrolliert, ob der rechte Wert größer ist als der linke
            while (line[i] > line[i + 1]) {

                // speichert Zahlen
                int k = line[i + 1];
                int l = line[i];

                // überschreibt die Zahlen
                line[i + 1] = l;
                line[i] = k;

                // Verringert um eins --> nächstes Zahlenpaar wird verglichen
                i--;
            }

        }
        // Ausgabe gesamt Array
        for (int j = 0; j < line.length; j++) {
            System.out.println(line[j]);

        }
    }
}
