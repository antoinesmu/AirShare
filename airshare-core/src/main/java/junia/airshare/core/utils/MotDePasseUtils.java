package junia.airshare.core.utils;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class MotDePasseUtils {

    private static final int LONGUEUR_SEL = 128;
    private static final int LONGUEUR_HASH = 128;

    private static final int NOMBRE_ITERATIONS = 5;
    private static final int MEMOIRE = 65536;
    private static final int PARALLELISME = 1;


    private static Argon2 instancierArgon2() {
        return Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i, LONGUEUR_SEL, LONGUEUR_HASH);
    }

    public static String genererMotDePasse(String motDePasse) {
        return instancierArgon2().hash(NOMBRE_ITERATIONS, MEMOIRE, PARALLELISME, motDePasse);
    }

    public static boolean validerMotDePasse(String motDePasse, String hashCorrect) {
        return instancierArgon2().verify(hashCorrect, motDePasse);
    }

    public static void main(String[] args) {
        System.out.println("Le nouveau mdp est "+genererMotDePasse("pilot"));
        //System.out.println(validerMotDePasse("password_signup", "$argon2i$v=19$m=65536,t=5,p=1$cP69M2fMpAEZ2VJC/0lvoZeAUlP+DLNAzHIKo0mBk3RJZcjY6q8bp/pWnNfRM10X+n3yMoO/TC71uQYbF/VCqushReV5TE0QlBaCSjfzaN5pSQ/NeHHKPXabZH58BXnHJADbFezgXlJ7Djc/2Cfa4OV6sp523JMnMAQDWqM7fsY$PQflpKu/bMmZhZHztiMUZU7QI/8Om/3vxLWTkLdYoUwQmBu+klEUgHXe+azql+T2/bFufWVHpWf3wyvyM63I581jbXkL8wr4JcOjtYUEu0tWedZIMgqokEAglodXlOFKXzXwlFrMyjHXXuftMjw1FQXR7+jhKtIsaT1hQ6P9TIE"));


    }

}
