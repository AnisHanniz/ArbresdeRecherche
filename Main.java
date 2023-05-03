import java.util.*;

public class Main {
        
    private static final int N = 10000; // Taille de l'ensemble d'éléments à ajouter à l'arbre
    private static final int M = 1000; // Nombre d'éléments à supprimer de l'arbre
    private static final int MAX = 1000000; // Valeur maximale possible pour les éléments de l'ensemble
   
    public static void main(String[] args) {
        int[] array = generateRandomArray(N); // Génère un ensemble de N éléments aléatoires
        int[] toDelete = getRandomElements(array, M); // Récupère M éléments aléatoires de l'ensemble précédent
        ABR tree = new ABR(); // Crée un nouvel arbre binaire de recherche
        System.out.println(tree);
        long start = System.nanoTime(); // Démarre un chronomètre
        for (int i = 0; i < N; i++) {
            tree.ajouter(array[i], (double)array[i]); // Ajoute chaque élément de l'ensemble à l'arbre
        }
        long end = System.nanoTime(); // Arrête le chronomètre
        System.out.println("Taille de l'arbre : " + tree.hauteur()); // Affiche la hauteur de l'arbre
        System.out.println("Temps moyen pour l'insertion : " + (end - start) / (double)N + " ns"); // Affiche le temps moyen pour l'ajout des éléments à l'arbre
        
        System.out.println("\n");
        //Enlever pour afficher l'arbre
        //System.out.println(tree);
        System.out.println("\n");
        
        
        start = System.nanoTime(); // Démarre un nouveau chronomètre
        for (int i = 0; i < M; i++) {
            tree.supprimer(toDelete[i]); // Supprime chaque élément aléatoire de l'ensemble précédent de l'arbre
        }
        end = System.nanoTime(); // Arrête le chronomètre
        System.out.println("Temps moyen pour la suppression : " + (end - start) / (double)M + " ns"); // Affiche le temps moyen pour la suppression des éléments de l'arbre
    }

    // Génère un tableau d'entiers aléatoires de taille n
    private static int[] generateRandomArray(int n) {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(MAX);
        }
        return array;
    }

    // Récupère n éléments aléatoires d'un tableau d'entiers donné
    private static int[] getRandomElements(int[] array, int n) {
        int[] result = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            result[i] = array[random.nextInt(array.length)];
        }
        return result;
    }
}