public class ABR{

private Noeud racine; // Noeud racine de l'arbre

public ABR() {
    this.racine = null; // Initialise la racine à null
}

public Noeud getRacine(){
    return racine;
}

public boolean estVide(){
    return racine == null;
}


public boolean recherche(int cle) {
    return rechercheRecursive(this.racine, cle);
}

private boolean rechercheRecursive(Noeud noeud, int cle) {
    if (noeud == null) { // Si le noeud est null, la clé n'a pas été trouvée
        return false;
    }
    if (noeud.cle == cle) { // Si la clé est égale à celle du noeud, la valeur a été trouvée
        return true;
    }
    if (cle < noeud.cle) { // Si la clé est inférieure à celle du noeud, on recherche dans le sous-arbre gauche
        return rechercheRecursive(noeud.gauche, cle);
    } else { // Si la clé est supérieure à celle du noeud, on recherche dans le sous-arbre droit
        return rechercheRecursive(noeud.droite, cle);
    }
}


public void ajouter(int cle, double contenu) {
    this.racine = ajouter(this.racine, cle, contenu); // Ajoute une valeur dans l'arbre en appelant la fonction ajouter
}

private Noeud ajouter(Noeud noeud, int cle, double contenu) { // Ajoute une valeur dans l'arbre
    if (noeud == null) {
        return new Noeud(cle, contenu); // Crée un nouveau noeud avec la clé et le contenu donnés
    }

    if (cle < noeud.cle) { // Si la clé est inférieure à celle du noeud, on la place dans le sous-arbre gauche
        noeud.gauche = ajouter(noeud.gauche, cle, contenu);
    } else if (cle > noeud.cle) { // Si la clé est supérieure à celle du noeud, on la place dans le sous-arbre droit
        noeud.droite = ajouter(noeud.droite, cle, contenu);
    } else {
        // Clé déjà présente, on ne fait rien
    }

    return noeud; // Retourne le noeud modifié
}
    // Cette méthode supprime un nœud ayant la valeur donnée dans l'arbre
public void supprimer(int cle) {
    racine = supprimer(racine, cle); // Appel de la fonction supprimer avec la racine de l'arbre et la clé à supprimer
}

private Noeud supprimer(Noeud noeud, int cle) {
    if (noeud == null) { // Si le noeud est null, la clé n'a pas été trouvée, donc on ne fait rien
        return null;
    }
    if (cle < noeud.cle) { // Si la clé à supprimer est inférieure à la clé du noeud, on va chercher dans le sous-arbre gauche
        noeud.gauche = supprimer(noeud.gauche, cle);
    } else if (cle > noeud.cle) { // Si la clé à supprimer est supérieure à la clé du noeud, on va chercher dans le sous-arbre droit
        noeud.droite = supprimer(noeud.droite, cle);
    } else { // Si on a trouvé le noeud correspondant à la clé
        if (noeud.gauche == null) { // Si le sous-arbre gauche est null, on retourne le sous-arbre droit
            return noeud.droite;
        } else if (noeud.droite == null) { // Si le sous-arbre droit est null, on retourne le sous-arbre gauche
            return noeud.gauche;
        }
        // Si le noeud a deux enfants, on recherche le noeud qui va le remplacer (le plus petit noeud du sous-arbre droit)
        Noeud minDroit = minimum(noeud.droite);
        noeud.cle = minDroit.cle;
        noeud.contenu = minDroit.contenu;
        noeud.droite = supprimer(noeud.droite, minDroit.cle);
    }
    return noeud;
}

private Noeud minimum(Noeud noeud) {
    while (noeud.gauche != null) { // On cherche le noeud le plus petit dans le sous-arbre gauche
        noeud = noeud.gauche;
    }
    return noeud;
}



// Cette méthode retourne la hauteur de l'arbre
public int hauteur() {
return hauteur(this.racine);
}

// Cette méthode récursive calcule la hauteur d'un sous-arbre en trouvant la hauteur maximale de ses sous-arbres
private int hauteur(Noeud noeud) {
if (noeud == null) {
return 0;
}

return 1 + Math.max(hauteur(noeud.gauche), hauteur(noeud.droite));
}
public String toString() {
  if (estVide()) {
    return "Arbre vide!";
  } else {
    return toStringRecursive(racine);
  }
}

private String toStringRecursive(Noeud n) {
  if (n == null) {
    return "";
  } else {
    String s = n.toString();
    String gauche = toStringRecursive(n.getGauche());
    String droite = toStringRecursive(n.getDroite());
    if (!gauche.isEmpty() || !droite.isEmpty()) {
      s += " (";
      s += gauche.isEmpty() ? "-" : gauche;
      s += ", ";
      s += droite.isEmpty() ? "-" : droite;
      s += ")";
    }
    return s;
  }
}

}