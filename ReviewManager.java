//Albert Lozano y Sergi Marrahy 
//1 DAM - Programación

import java.time.LocalDate;

//Class done by Albert
public class ReviewManager {

    //Class attributes
    private int maxReviews = 100;
    private int numReviews = 0;
    public Review[] reviews = new Review[maxReviews];

    //----------------------------------------------------------------------

    //Constructors

    //Empty constructor
    public ReviewManager() {
        
    }

    //Constructor that sets the maximum reviews you can store
    public ReviewManager(int maxReviews) {
        this.maxReviews = maxReviews;
    }

    //----------------------------------------------------------------------

    //Setters and Getters
    public void setMaxReviews(int maxReviews) {
        this.maxReviews = maxReviews;
    }

    public int getMaxReviews() {
        return maxReviews;
    }

    public void setNumReviews(int numReviews) {
        this.numReviews = numReviews;
    }

    public int getNumReviews() {
        return numReviews;
    }

    //----------------------------------------------------------------------

    //Functions

    //Booleans to check array status

    //Returns true if there's no Reviews stored yet
    public boolean isEmpty() {
        return reviews[0] == null;
    }

    //Returns true if there's no room for more Reviews to be stored
    public boolean isFull() {
        return numReviews == maxReviews;
    }

    //Adding and removing array objects

    //Adds an instance of the Review class to the array
    public void addReview(Review review) {
        reviews[numReviews] = review;
        numReviews++;
    }

    //Removes an instance of the Review class of the array
    public void removeReview(int remove) {
        reviews[remove] = null;
        for (int i = remove; i < (numReviews - 1); i++) {
            reviews[i] = reviews[i + 1];
        }
        numReviews--;
    }

    //Showing array and filtering

    //Shows all Reviews stored
    public void showReviews() {
        for (int i = 0; i < numReviews; i++) {
            System.out.println();
            System.out.println("Reseña " + (i + 1) + ":");
            reviews[i].showReview();
        }
    }
    

    //Shows reviews that have the same rating (or higher) as the parameter
    public void filterByRating(int rating) {
        for (int i = 0; i < numReviews; i++) {
            if (reviews[i].isRating(rating)) {
                System.out.println("Reseña " + (i + 1) + ":");
                reviews[i].showReview();
            }
        }
    }

    //Shows reviews that have the same date (or shorter) as the parameter
    public void filterByDate(LocalDate currentDate) {
        for (int i = 0; i < numReviews; i++) {
            if (reviews[i].isCurrentDate(currentDate)) {
                System.out.println("Reseña " + (i + 1) + ":");
                reviews[i].showReview();
            }
        }
    }

    //Shows reviews that have the same played hours (or more) as the parameter
    public void filterByPlayedHours(double playedHours) {
        for (int i = 0; i < numReviews; i++) {
            if (reviews[i].hasPlayedHours(playedHours)) {
                System.out.println("Reseña " + (i + 1) + ":");
                reviews[i].showReview();
            }
        }
    }

    //Shows reviews that are about a determined videogame name
    public void filterByVideogameName(String name) {
        for (int i = 0; i < numReviews; i++) {
            if (reviews[i].getVideogame().isName(name)) {
                System.out.println("Reseña " + (i + 1) + ":");
                reviews[i].showReview();
            }
        }
    }

    //Shows reviews that are about a determined videogame genre
    public void filterByVideogameGenre(Videogame.Genre genre) {
        for (int i = 0; i < numReviews; i++) {
            if (reviews[i].getVideogame().isGenre(genre)) {
                System.out.println("Reseña " + (i + 1) + ":");
                reviews[i].showReview();
            }
        }
    }

    //Shows reviews that are about a determined videogame platform
    public void filterByVideogamePlatform(Videogame.Platform platform) {
        for (int i = 0; i < numReviews; i++) {
            if (reviews[i].getVideogame().isPlatform(platform)) {
                System.out.println("Reseña " + (i + 1) + ":");
                reviews[i].showReview();
            }
        }
    }

    //Shows reviews that have been published by a determined user
    public void filterByUser(User user) {
        for (int i = 0; i < numReviews; i++) {
            if (reviews[i].isUser(user)) {
                System.out.println();
                System.out.println("Reseña " + (i + 1) + ":");
                reviews[i].showReview();
            }
        }
    }
    
    //Returns true if user hasn't published any reviews yet
    public boolean userHasReviews(User user) {
        for (int i = 0; i < numReviews; i++) {
            if (reviews[i].isUser(user)) {
                return true;
            }
        }
        return false;
    }
}
