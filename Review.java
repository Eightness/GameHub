
//Albert Lozano y Sergi Marrahy 
//1 DAM - Programación

//Class done by Marrahy
public class Review {

    //Class attributes
    String title, body, date;
    int rating;
    double playedHours;
    Videogame videogame;
    User user;
    //----------------------------------------------------------------------

    //Void constructor
    public Review() {

    }

    //Constructor
    public Review(String title, String body, int rating, String date, Double playedHours, Videogame videogame, User user) {
        setTitle(title);
        setBody(body);
        setRating(rating);
        setDate(date);
        setPlayedHours(playedHours);
        setVideogame(videogame);
        setUser(user);
    }
    
    //----------------------------------------------------------------------

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setPlayedHours(double playedHours) {
        this.playedHours = playedHours;
    }
    public void setVideogame(Videogame videogame) {
        this.videogame = videogame;
    }
    public void setUser(User user) {
        this.user = user;
    }

    //Getters
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }
    public int getRating() {
        return rating;
    }
    public String getDate() {
        return date;
    }
    public double getPlayedHours() {
        return playedHours;
    }
    public Videogame getVideogame() {
        return videogame;
    }
    public User getUser() {
        return user;
    }
    //----------------------------------------------------------------------

    //Functions
    public void showReview() {
        System.out.println();
        System.out.println("Título: " + getTitle());
        System.out.println("Cuerpo: " + getBody());
        System.out.println("Valoración: " + getRating() + "⭐");
        System.out.println("Usuario: " + getUser());
        System.out.println("Videojuego: " + getVideogame());
        System.out.println("Horas jugadas: " + getPlayedHours());
        System.out.println("Fecha de publicación: " + getDate());
        System.out.println();
    }

    public void editReview(String title, String body, int rating) {
        setTitle(title);
        setBody(body);
        setRating(rating);
    }

    public boolean isRating(int rating) {
        return getRating() >= rating;
    }

    public boolean isDate(String date) {
        return getDate().contains(date);
    }

    public boolean hasPlayedHours(Double playedHours) {
        return getPlayedHours() >= playedHours;
    }

    public boolean isVideogame(Videogame videogame) {
        return getVideogame().equals(videogame);
    }

    public boolean isUser(User user) {
        return getUser().equals(user);
    }
}
