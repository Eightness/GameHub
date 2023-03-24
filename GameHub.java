//Albert Lozano y Sergi Marrahy 
//1 DAM - Programación

import java.util.Scanner;

//Team class
public class GameHub {

    //Class attributes
    private User currentUser;
    private UserManager userManager;
    private VideogameManager videogameManager;
    private ReviewManager reviewManager;
    Scanner input = new Scanner(System.in);
    
    //----------------------------------------------------------------------

    //Functions

    //Function to start app
    public void start() {
        loadObjects();
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
        //Default admin
        User admin0 = new User("admin", "admin0", "gamehubadmin@gmail.com","1234", User.UserType.ADMIN, false);
        userManager.addUser(admin0);
        //2 admin accounts
        User admin1 = new User("Albert", "Bertus", "albertlb08@gmail.com", "1234", User.UserType.ADMIN, false);
        userManager.addUser(admin1);
        User admin2 = new User("Marrahy", "Marra", "sergimarenas@gmail.com", "1234", User.UserType.ADMIN, false);
        userManager.addUser(admin2);
        //Default user
        User user0 = new User("user", "user0", "gamehubuser@gmail.com", "1234", User.UserType.USER, false);
        userManager.addUser(user0);
        //Default mod
        User mod0 = new User("mod", "mod0", "gamehubmod@gmail.com", "1234", User.UserType.MOD, false);
        userManager.addUser(mod0);
    }

    //Loading predefined videogames
    private void loadVideogames() {
        Videogame.Platform[] platMinecraft = {Videogame.Platform.PC, Videogame.Platform.PLAYSTATION, Videogame.Platform.XBOX};
        Videogame.Genre[] genMinecraft = {Videogame.Genre.ACTION, Videogame.Genre.ADVENTURE};
        Videogame videogame0 = new Videogame("Minecraft", platMinecraft, genMinecraft, "2011");
        videogameManager.addVideogame(videogame0);


        Videogame.Platform[] platHorizonZeroDawn = {Videogame.Platform.PC, Videogame.Platform.PLAYSTATION, Videogame.Platform.XBOX};
        Videogame.Genre[] genHorizonZeroDawn = {Videogame.Genre.ACTION, Videogame.Genre.ADVENTURE, Videogame.Genre.SHOOTER};
        Videogame videogame1 = new Videogame("Horizon Zero Dawn", platHorizonZeroDawn, genHorizonZeroDawn, "2017");
        videogameManager.addVideogame(videogame1);


        Videogame.Platform[] platTetris = {Videogame.Platform.PC, Videogame.Platform.SMARTPHONE};
        Videogame.Genre[] genTetris = {Videogame.Genre.PUZZLE};
        Videogame videogame2 = new Videogame("Tetris", platTetris, genTetris, "1984");
        videogameManager.addVideogame(videogame2);


        Videogame.Platform[] plaTLOU = {Videogame.Platform.PC, Videogame.Platform.PLAYSTATION};
        Videogame.Genre[] genTLOU = {Videogame.Genre.ACTION, Videogame.Genre.ADVENTURE, Videogame.Genre.SHOOTER, Videogame.Genre.PUZZLE};
        Videogame videogame3 = new Videogame("The las of us", plaTLOU, genTLOU, "2013");
        videogameManager.addVideogame(videogame3);


        Videogame.Platform[] platDiablo4 = {Videogame.Platform.PC, Videogame.Platform.PLAYSTATION, Videogame.Platform.XBOX};
        Videogame.Genre[] genDiablo4 = {Videogame.Genre.ACTION, Videogame.Genre.ACTION};
        Videogame videogame4 = new Videogame("Diablo IV", platDiablo4, genDiablo4, "2023");
        videogameManager.addVideogame(videogame4);
    }

    //Loading predefined reviews
    private void loadReviews() {

    }

    //Loads everything
    private void loadObjects() {
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
        System.out.println("2. Editar reseña.");
        System.out.println("3. Borrar reseña.");
        System.out.println("4. Mostrar reseñas.");
        System.out.println("5. Buscar reseñas.");
        System.out.println("6. Cerrar sesión.");
        System.out.println();
    }

    //Mod menu
    private void showModMenu() {
        System.out.println();
        System.out.println("1. Publicar reseña.");
        System.out.println("2. Editar reseña.");
        System.out.println("3. Borrar reseña.");
        System.out.println("4. Mostrar reseñas.");
        System.out.println("5. Buscar reseñas.");
        System.out.println("6. Borrar reseña ajena.");
        System.out.println("7. Banear usuario.");
        System.out.println("8. Cerrar sesión.");
        System.out.println();
    }

    //Admin menu
    private void showAdminMenu() {
        System.out.println();
        System.out.println("1. Añadir videojuego.");
        System.out.println("2. Editar videojuego.");
        System.out.println("3. Eliminar videojuego.");
        System.out.println("4. Crear usuario.");
        System.out.println("5. Modificar datos usuario.");
        System.out.println("6. Eliminar usuario.");
        System.out.println("7. Mostrar reseñas.");
        System.out.println("8. Cerrar sesión.");
        System.out.println();
    }

    //Submenu for reviews searching options
    private void showSubmenuSearching() {
        System.out.println();
        System.out.println("1. Buscar reseñas por videojuego.");
        System.out.println("2. Buscar reseñas por usuario.");
        System.out.println("3. Buscar reseñas por valoración.");
        System.out.println("4. Buscar reseñas por horas jugadas.");
        System.out.println("5. Atrás.");
        System.out.println();
    }

    //Submenu for searching reviews by Videogame
    private void showSubmenuVideogameSearching() {
        System.out.println();
        System.out.println("1. Buscar por nombre del videojuego.");
        System.out.println("2. Buscar por género del videojuego.");
        System.out.println("3. Buscar por plataforma del videojuego.");
        System.out.println("4. Atrás.");
        System.out.println();
    }

    //Switches

    //Returns an int determined by user input
    private int option() {
        System.out.print("Elige opción: ");
        return input.nextInt();
    }

    //Switch for Sign in - Register menu
    private void switchLogIn(int option) {

    }

    //Swtich for User menu
    private void switchUser(int option) {

    }

    //Switch for Mod menu
    private void switchMod(int option) {

    }

    //Switch for Admin menu
    private void switchAdmin(int option) {

    }

    //Switch for submenu searching options
    private void switchSubmenuSearching(int option) {

    }

    //Switch for submenu searching videogame options
    private void switchSubmenuVideogame(int option) {

    }

}
