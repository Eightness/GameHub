//Albert Lozano y Sergi Marrahy 
//1 DAM - Programación

//Class done by Albert
public class Videogame {

    //Enums
    public enum Platform {
        PLAYSTATION, XBOX, NINTENDO, PC, SMARTPHONE
    }

    public enum Genre {
        ACTION, ADVENTURE, ROLEPLAYING, STRATEGY, SIMULATION, PUZZLE, SHOOTER, OTHER 
    }
    
    //Class attributes
    private String name;
    private Platform[] platforms = new Platform[4];
    private Genre[] genres = new Genre[7];
    private String releaseDate;

    //----------------------------------------------------------------------

    //Constructors

    //Empty constructor
    public Videogame() {

    }

    //Full constructor
    public Videogame(String name, Platform[] platforms, Genre[] genres, String releaseDate) {
        this.name = name;
        this.platforms = platforms;
        this.genres = genres;
        this.releaseDate = releaseDate;
    }

    //----------------------------------------------------------------------

    //Setters and Getters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPlatforms(Platform[] platforms) {
        this.platforms = platforms;
    }

    public Platform[] getPlatforms() {
        return platforms;
    }

    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }

    public Genre[] getGenres() {
        return genres;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    //----------------------------------------------------------------------

    //Functions

    //Function to show videogame data
    public void showVideogame() {
        System.out.println();
        System.out.println("Nombre: " + getName());
        System.out.println("Plataforma(s): " + getPlatforms());
        System.out.println("Género: " + getGenres());
        System.out.println("Fecha de lanzamiento: " + getReleaseDate());
    }

    //Booleans to do simple checks on the object

    //Returns true if a String equals to the videogame's name
    public boolean isName(String name) {
        return name.equalsIgnoreCase(this.name);
    }

    //Returns true if a Genre is the same as (at least one of) the videogame's genres
    public boolean isGenre(Genre genre) {
        for (int i = 0; i < genres.length; i++) {
            if (genre == genres[i]) {
                return true;
            }
        }
        return false;
    }

    //Returns true if a Platform is the same as (at least one of) the videogame's platforms
    public boolean isPlatform(Platform platform) {
        for (int i = 0; i < platforms.length; i++) {
            if (platform == platforms[i]) {
                return true;
            }
        }
        return false;
    }

    //Returns true if a String equals or is contained within the videogame's release date
    public boolean isReleaseDate(String releaseDate) {
        return this.releaseDate.contains(releaseDate);
    }

}
