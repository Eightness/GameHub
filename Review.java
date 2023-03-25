//Albert Lozano y Sergi Marrahy 
//1 DAM - Programación

import java.time.LocalDate;

//Class done by Marrahy
public class Review {

    //Class attributes
    String title, body;
    int rating;
    double playedHours;
    Videogame videogame;
    User user;
    LocalDate currentDate;
    
    //----------------------------------------------------------------------

    //Void constructor
    public Review() {

    }

    //Constructor
    public Review(String title, String body, int rating, double playedHours, Videogame videogame, User user) {
        setTitle(title);
        setBody(body);
        setRating(rating);
        setCurrentDate();
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
    public void setCurrentDate() {
        this.currentDate = LocalDate.now();
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
    public LocalDate getCurrentDate() {
        return currentDate;
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
        System.out.println("Valoración: " + getRating() + " estrellas");
        System.out.println("Usuario: " + getUser().getUsername());
        System.out.println("Videojuego: " + getVideogame().getName());
        System.out.println("Horas jugadas: " + getPlayedHours());
        System.out.println("Fecha de publicación: " + getCurrentDate());
    }

    public void editReview(String title, String body, int rating) {
        setTitle(title);
        setBody(body);
        setRating(rating);
    }

    public boolean isRating(int rating) {
        return getRating() >= rating;
    }

    public boolean isCurrentDate(LocalDate currentDate) {
        return getCurrentDate().equals(currentDate);
    }

    public boolean hasPlayedHours(double playedHours) {
        return getPlayedHours() >= playedHours;
    }

    public boolean isVideogame(Videogame videogame) {
        return getVideogame().equals(videogame);
    }

    public boolean isUser(User user) {
        return getUser().equals(user);
    }
}
