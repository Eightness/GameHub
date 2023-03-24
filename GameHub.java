//Albert Lozano y Sergi Marrahy 
//1 DAM - Programación

import java.util.Scanner;

//Team class
public class GameHub {

    //Class attributes
    private static User currentUser;
    private UserManager userManager;
    private VideogameManager videogameManager;
    private ReviewManager reviewManager;
    Scanner input = new Scanner(System.in);
    
    //----------------------------------------------------------------------

    //Functions

    //Function to start app
    public void start() {
        loadObjects();

        showLogInMenu();
        switchLogIn(option());

        showUserMenu();
        switchUser(option());

        showModMenu();
        switchMod(option());

        showAdminMenu();
        switchAdmin(option());
    }

    //Setting objects

    //Setting a User
    private User setUser() {
        System.out.println();
        System.out.print("Introduce nombre: ");
        String name = input.nextLine();
        
        String username;
        do {
            System.out.println();
            System.out.print("Introduce nombre de usuario: ");
            username = input.nextLine();
            if (userManager.usernameExists(username)) {
                System.out.println();
                System.out.println("Nombre de usuario existente, elige otro.");
            }
        } while (userManager.usernameExists(username));

        String mail;
        do {
            System.out.println();
            System.out.print("Introduce correo: ");
            mail = input.nextLine();
            if (userManager.mailExists(mail)) {
                System.out.println();
                System.out.println("Correo ya registrado, elige otro.");
            }
        } while (userManager.mailExists(mail));

        System.out.println();
        System.out.print("Introduce contraseña: ");
        String password = input.nextLine();
        
        User user = new User(name, username, mail, password);
        return user;
    }

    //Setting a Videogame
    private Videogame setVideogame() {
        System.out.println();
        System.out.print("Introduce nombre: ");
        String name = input.nextLine();
        
        System.out.println();
        System.out.print("¿En cuántas plataformas está disponible el juego? ");
        int numPlatforms = input.nextInt();
        
        Videogame.Platform[] platforms = new Videogame.Platform[numPlatforms];
        
        for (int i = 0; i < numPlatforms; i++) {
            System.out.println();
            System.out.println("Introduce plataforma " + (i + 1) + ": ");
            System.out.println("1. PLAYSTATION, 2. XBOX, 3. NINTENDO, 4. PC, 5. SMARTPHONE");
            switch (input.nextInt()) {
                case 1:
                platforms[i] = Videogame.Platform.PLAYSTATION;
                break;
                
                case 2:
                platforms[i] = Videogame.Platform.XBOX;
                break;
                
                case 3:
                platforms[i] = Videogame.Platform.NINTENDO;
                break;
                
                case 4:
                platforms[i] = Videogame.Platform.PC;
                break;
                
                case 5:
                platforms[i] = Videogame.Platform.SMARTPHONE;
                break;
            }
        }
        
        System.out.println();
        System.out.println("¿Cuántos géneros tiene el videojuego?");
        int numGenres = input.nextInt();
        
        Videogame.Genre[] genres = new Videogame.Genre[numGenres];
        
        for (int i = 0; i < numGenres; i++) {
            System.out.println();
            System.out.println("Introduce género " + (i + 1) + ": ");
            System.out.println("1. ACTION, 2. ADVENTURE, 3. ROLEPLAYING, 4. STRATEGY, 5. SIMULATION, 6. PUZZLE, 7. SHOOTER, 8. OTHER");
            switch (input.nextInt()) {
                case 1:
                genres[i] = Videogame.Genre.ACTION;
                break;
                
                case 2:
                genres[i] = Videogame.Genre.ADVENTURE;
                break;
                
                case 3:
                genres[i] = Videogame.Genre.ROLEPLAYING;
                break;
                
                case 4:
                genres[i] = Videogame.Genre.STRATEGY;
                break;
                
                case 5:
                genres[i] = Videogame.Genre.SIMULATION;
                break;
                
                case 6:
                genres[i] = Videogame.Genre.PUZZLE;
                break;
                
                case 7:
                genres[i] = Videogame.Genre.SHOOTER;
                break;
                
                case 8:
                genres[i] = Videogame.Genre.OTHER;
                break;
            }
        }
        
        System.out.println();
        System.out.print("Introduce fecha de lanzamiento (formato dd/mm/aaaa): ");
        String releaseDate = input.nextLine();
        
        Videogame videogame = new Videogame(name, platforms, genres, releaseDate);
        return videogame;
    }
    
    //Setting a Review
    private Review setReview() {
        System.out.println();
        System.out.println("¿Sobre qué videojuego vas a hacer la reseña?");
        videogameManager.showVideogames();
        int election = (input.nextInt() + 1);

        System.out.println();
        System.out.print("Título: ");
        String title = input.nextLine();
        
        System.out.println();
        System.out.print("Cuerpo: ");
        String body = input.nextLine();
        
        System.out.println();
        System.out.print("Valoración (de 1 a 5 estrellas): ");
        int rating = input.nextInt();
        
        System.out.println();
        System.out.println("¿Cuántas horas has jugado al videojuego?");
        double playedHours = input.nextDouble();

        Review review = new Review(title, body, rating, playedHours, videogameManager.videogames[election], currentUser);
        return review;
    }

    //Loading different objects

    //Loading predefined users
    private void loadUsers() {
        //Default admin
        User user0 = new User("Admin", "admin0", "gamehubadmin@gmail.com","1234", User.UserType.ADMIN, false);
        userManager.addUser(user0);
        //2 admin accounts
        User user1 = new User("Albert", "Bertus", "albertlb08@gmail.com", "1234", User.UserType.ADMIN, false);
        userManager.addUser(user1);
        User user2 = new User("Marrahy", "Marra", "sergimarenas@gmail.com", "1234", User.UserType.ADMIN, false);
        userManager.addUser(user2);
        //Default user
        User user3 = new User("User", "RandomUser", "gamehubuser@gmail.com", "1234", User.UserType.USER, false);
        userManager.addUser(user3);
        //Default mod
        User user4 = new User("Mod", "RandomMod", "gamehubmod@gmail.com", "1234", User.UserType.MOD, false);
        userManager.addUser(user4);
    }

    //Loading predefined videogames
    private void loadVideogames() {
        //Minecraft
        Videogame videogame0 = new Videogame("Minecraft", new Videogame.Platform[] {Videogame.Platform.PC, Videogame.Platform.PLAYSTATION, Videogame.Platform.XBOX}, new Videogame.Genre[] {Videogame.Genre.ACTION, Videogame.Genre.ADVENTURE}, "2011");
        videogameManager.addVideogame(videogame0);
        //Horizon Zero Dawn
        Videogame videogame1 = new Videogame("Horizon Zero Dawn", new Videogame.Platform[] {Videogame.Platform.PC, Videogame.Platform.PLAYSTATION, Videogame.Platform.XBOX}, new Videogame.Genre[] {Videogame.Genre.ACTION, Videogame.Genre.ADVENTURE, Videogame.Genre.SHOOTER}, "2017");
        videogameManager.addVideogame(videogame1);
        //Tetris
        Videogame videogame2 = new Videogame("Tetris", new Videogame.Platform[] {Videogame.Platform.PC, Videogame.Platform.SMARTPHONE}, new Videogame.Genre[] {Videogame.Genre.PUZZLE}, "1984");
        videogameManager.addVideogame(videogame2);
        //The Last of Us
        Videogame videogame3 = new Videogame("The Last of Us", new Videogame.Platform[] {Videogame.Platform.PC, Videogame.Platform.PLAYSTATION}, new Videogame.Genre[] {Videogame.Genre.ACTION, Videogame.Genre.ADVENTURE, Videogame.Genre.SHOOTER, Videogame.Genre.PUZZLE}, "2013");
        videogameManager.addVideogame(videogame3);
        //Diablo IV
        Videogame videogame4 = new Videogame("Diablo IV", new Videogame.Platform[] {Videogame.Platform.PC, Videogame.Platform.PLAYSTATION, Videogame.Platform.XBOX}, new Videogame.Genre[] {Videogame.Genre.ACTION, Videogame.Genre.ACTION}, "2023");
        videogameManager.addVideogame(videogame4);
    }

    //Loading predefined reviews
    private void loadReviews() {
        //Review Albert
        Review review0 = new Review("Minecraft mola", "Llevo jugando a este juego más de 10 años y me parece increíble. ¡Además, se desarrolló en Java!", 5, 1250.5, videogameManager.videogames[0], userManager.users[1]);
        reviewManager.addReview(review0);
        //Review Marrahy
        Review review1 = new Review("The Last of Us es una obra de arte", "La historia me cautivó desde el primer momento. Increíbles actores y actrices, ahora mismo me estoy gozando la serie de HBO...", 5, 50.6, videogameManager.videogames[3], userManager.users[2]);
        reviewManager.addReview(review1);
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

    //Submenu for searching users
    private void showSubMenuUsersSearching() {
        System.out.println();
        System.out.println("1. Buscar por nombre.");
        System.out.println("2. Buscar por apodo.");
        System.out.println("3. Buscar por correo.");
        System.out.println("4. Buscar por ban.");
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
        switch (option) {
            case 1:
                logIn();
            break;
            case 2:

            break;
            
            case 3:

            break;
            default:
                break;
        }
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

    //Switch for submenu searching user options
    private void switchSubMenuUser(int option) {

    }

    //Specific functions

    //Log In function
    private void logIn() {
        System.out.println();
        System.out.print("Introduce tu nombre de usuario: ");
        String username = input.nextLine();

        System.out.println();
        System.out.print("Introduce tu contraseña: ");
        String password = input.nextLine();

        if (userManager.getCurrentUser(username, password) == null) {
            System.out.println();
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        } else {
            currentUser = userManager.getCurrentUser(username, password);
        }

    }

    //Register function
    private void register() {
        if (userManager.isFull()) {
            System.out.println();
            System.out.println("No hay espacio para más usuarios.");
            return;
        }
        User newUser = setUser();
        userManager.addUser(newUser);
    }

}
