//Albert Lozano y Sergi Marrahy 
//1 DAM - Programación

import java.time.LocalDate;

//Class done by Marrahy
public class Review {

    //Class attributes
    private String title, body;
    private int rating;
    private double playedHours;
    private Videogame videogame;
    private User user;
    private LocalDate currentDate;
    
    //----------------------------------------------------------------------

    //Empty constructor
    public Review() {

    }

    //Full constructor
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

    //Function to show all review data
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

    //Function to edit a review
    public void editReview(String title, String body, int rating) {
        setTitle(title);
        setBody(body);
        setRating(rating);
    }

    //Booleans to do simple checks and help the source code to be more legible

    //Returns true if the review has a minimum rating
    public boolean isRating(int rating) {
        return getRating() >= rating;
    }

    //Returns true if the current date is the same date as a review's date
    public boolean isCurrentDate(LocalDate currentDate) {
        return getCurrentDate().equals(currentDate);
    }

    //Returns true if the review has a minimum played hours
    public boolean hasPlayedHours(double playedHours) {
        return getPlayedHours() >= playedHours;
    }

    //Returns true if a specified videogame is the same as the review's videogame
    public boolean isVideogame(Videogame videogame) {
        return getVideogame().equals(videogame);
    }

    //Returns true if a specified user is the same as the review's user
    public boolean isUser(User user) {
        return getUser() == user;
    }

}
