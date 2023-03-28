//Albert Lozano y Sergi Marrahy 
//1 DAM - Programación

//Class done by Albert
public class VideogameManager {

    //Class attributes
    private int maxVideogames = 10;
    public int numVideogames = 0;
    public Videogame[] videogames = new Videogame[maxVideogames];

    //----------------------------------------------------------------------

    //Constructors

    //Empty constructor
    public VideogameManager() {
        
    }

    //Constructor that sets the maximum videogames you can store
    public VideogameManager(int maxVideogames) {
        this.maxVideogames = maxVideogames;
    }

    //----------------------------------------------------------------------

    //Setters
    public void setMaxVideogames(int maxVideogames) {
        this.maxVideogames = maxVideogames;
    }

    public void setNumVideogames(int numVideogames) {
        this.numVideogames = numVideogames;
    }

    //Getters
    public int getMaxVideogames() {
        return maxVideogames;
    }

    public int getNumVideogames() {
        return numVideogames;
    }

    //----------------------------------------------------------------------

    //Functions

    //Booleans to check videogames array status

    //Returns true if there's no videogame stored yet
    public boolean isEmpty() {
        return videogames[0] == null;
    }

    //Returns true if there's no room for adding more videogames
    public boolean isFull() {
        return numVideogames == maxVideogames;
    }

    //Returns true if there's already a game with a determined name
    public boolean videogameExists(String name) {
        for (int i = 0; i < numVideogames; i++) {
            if (videogames[i].isName(name)) {
                return true;
            }
        }
        return false;
    }

    //Adding, removing and editing array objects

    //Adds an instance of the Videogame class to the array 
    public void addVideogame(Videogame videogame) {
        videogames[numVideogames] = videogame;
        numVideogames++;
    }

    //Removes an instance of the Videogame class of the array
    public void removeVideogame(int remove) {
        videogames[remove] = null;
        for (int i = remove; i < (numVideogames - 1); i++) {
            videogames[i] = videogames[i + 1];
        }
        numVideogames--;
    }

    //Function to edit a determined videogame
    public void editVideogame(int edit, Videogame videogame) {
        videogames[edit - 1] = videogame;
    }

    //Showing array and filtering

    //Shows all Videogames stored
    public void showVideogames() {
        for (int i = 0; i < numVideogames; i++) {
            System.out.println();
            System.out.println("Videojuego " + (i + 1) + ":");
            videogames[i].showVideogame();
        }
    }

    //Shows videogames that have the same name as the parameter
    public void filterByName(String name) {
        for (int i = 0; i < numVideogames; i++) {
            if (videogames[i].isName(name)) {
                System.out.println("Videojuego " + (i + 1) + ":");
                videogames[i].showVideogame();
            }
        }
    }

    //Shows videogames that have the same platform as the parameter
    public void filterByPlatform(Videogame.Platform platform) {
        for (int i = 0; i < numVideogames; i++) {
            if (videogames[i].isPlatform(platform)) {
                System.out.println("Videojuego " + (i + 1) + ":");
                videogames[i].showVideogame();
            }
        }
    }

    //Shows videogames that have the same genre as the parameter
    public void filterByGenre(Videogame.Genre genre) {
        for (int i = 0; i < numVideogames; i++) {
            if (videogames[i].isGenre(genre)) {
                System.out.println("Videojuego " + (i + 1) + ":");
                videogames[i].showVideogame();
            }
        }
    }

    //Shows videogames that have the same release date as the parameter
    public void filterByReleaseDate(String releaseDate) {
        for (int i = 0; i < numVideogames; i++) {
            if (videogames[i].isReleaseDate(releaseDate)) {
                System.out.println("Videojuego " + (i + 1) + ":");
                videogames[i].showVideogame();
            }
        }
    }

}
