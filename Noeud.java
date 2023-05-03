public class Noeud {
    int cle;
    double contenu;
    Noeud gauche, droite;
    
    // Constructeur pour initialiser un Noeud avec une valeur donnée
    public Noeud(int cle,double contenu) {
        this.cle = cle;
        this.contenu = contenu;
        this.gauche = null;
        this.droite = null;
    }
    
    // Accesseur pour récupérer la valeur du Noeud
    public int getCle(){
        return cle;
    }
    
    public double getContenu(){
        return contenu;
    }
    
    // Accesseurs pour récupérer les sous-arbres gauche et droit
    public Noeud getGauche() {
        return gauche;
    }
    
    public Noeud getDroite() {
        return droite;
    }
    
    // Mutateurs pour modifier les sous-arbres gauche et droit
    public void setGauche(Noeud gauche) {
        this.gauche = gauche;
    }
    
    public void setDroite(Noeud droite) {
        this.droite = droite;
    }
    
    // Vérifie si le Noeud est une feuille (i.e. n'a pas de sous-arbre gauche ni droit)
    public boolean estFeuille() {
        return (gauche == null && droite == null);
    }
    
    public String toString() {
    String s = "Noeud(" + cle + ", " + contenu + ")";
    if (gauche != null) {
        s += " [G:" + gauche.toString() + "]";
    }
    if (droite != null) {
        s += " [D:" + droite.toString() + "]";
    }
    return s;
}


}
