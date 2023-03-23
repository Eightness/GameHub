//Albert Lozano y Sergi Marrahy 
//1 DAM - Programación

import java.util.Scanner;

//Team class
public class GameHub {

    //Class attributes
    private UserManager userManager;
    private VideogameManager videogameManager;
    private ReviewManager reviewManager;
    Scanner input = new Scanner(System.in);
    
    //----------------------------------------------------------------------

    //Functions

    //Function to start app
    public void start() {
        loadEverything();
    }

    //Setting objects

    //Setting a User
    private User setUser() {
        User user = new User();
        return user;
    }

    //Setting a Videogame
    private Videogame setVideogame() {
        Videogame videogame = new Videogame();
        return videogame;
    }

    //Setting a Review
    private Review setReview() {
        Review review = new Review();
        return review;
    }

    //Loading different objects

    //Loading predefined users
    private void loadUsers() {

    }

    //Loading predefined videogames
    private void loadVideogames() {

    }

    //Loading predefined reviews
    private void loadReviews() {

    }

    //Loads everything
    private void loadEverything() {
        loadUsers();
        loadVideogames();
        loadReviews();
    }

    //Menus

    //Showing

    //Sign in - Register menu
    private void showLogInMenu() {
        System.out.println();
        System.out.println("1. Iniciar sesión.");
        System.out.println("2. Registrarse.");
        System.out.println("3. Salir.");
        System.out.println();
    }

    //User menu
    private void showUserMenu() {
        System.out.println();
        System.out.println("1. Publicar reseña.");
        System.out.println("2. Edita.");
        System.out.println();
    }

    //Mod menu
    private void showModMenu() {

    }

    //Admin menu
    private void showAdminMenu() {

    }

    //Switches

    //Switch for Sign in - Register menu
    private void switchLogIn() {

    }

    //Swtich for User menu
    private void switchUser() {

    }

    //Switch for Mod menu
    private void switchMod() {

    }

    //Switch for Admin menu
    private void switchAdmin() {

    }

}
