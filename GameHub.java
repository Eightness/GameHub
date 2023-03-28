//Albert Lozano y Sergi Marrahy 
//1 DAM - Programación

import java.util.Scanner;

//Team class
public class GameHub {

    //Class attributes
    private static User currentUser;    //This will be the logged in user
    private static boolean running = true;  //Auxiliar boolean to run the app
    private static boolean submenu = true;  //Auxiliar boolean to enter a submenu
    private static boolean submenu2 = true; //Auxiliar boolean to enter a submenu from a submenu
    private UserManager userManager = new UserManager();    
    private VideogameManager videogameManager = new VideogameManager();
    private ReviewManager reviewManager = new ReviewManager();
    Scanner input = new Scanner(System.in);
    
    //----------------------------------------------------------------------

    //Functions

    //----------------------------------------------------------------------

    //Function to start app (only public function that will be called by Main class)
    public void start() {
        //Initialization
        loadObjects();  //Loads some users, videogames and reviews (PoC)

        //Welcome
        System.out.println();
        System.out.println("¡Bienvenido@ a GameHub! Aplicación desarrollada por Albert y Marrahy. :)");
        System.out.println("¡Disfrutad compartiendo reseñas sobre diferentes videojuegos!");

        //Main while for the app
        while (running) {

            //Log In menu
            if (currentUser == null) {
                while (true) {
                    showLogInMenu();
                    switchLogIn(option());
                    if (currentUser != null) {
                        break;
                    }
                    if (!running) {
                        break;
                    }
                }
            }

            //User Menu (if the user is a normal user)
             else if (currentUser.isUserType(User.UserType.USER)) {

                System.out.println();
                System.out.println("¡Bienvenido, " + currentUser.getName() + "!");
                System.out.println("Menú para " + currentUser.getType() + ":");
                
                while (true) {
                    showUserMenu();
                    switchUser(option());
                    if (currentUser == null) {
                        break;
                    }
                }
            }

            //Mod Menu (if the user is a mod)
            else if (currentUser.isUserType(User.UserType.MOD)) {

                System.out.println();
                System.out.println("¡Bienvenido, " + currentUser.getName() + "!");
                System.out.println("Menú para " + currentUser.getType() + ":");

                while (true) {
                    showModMenu();
                    switchMod(option());
                    if (currentUser == null) {
                        break;
                    }
                }
            }

            //Admin Menu (if the user is an admin)
            else if (currentUser.isUserType(User.UserType.ADMIN)) {

                System.out.println();
                System.out.println("¡Bienvenido, " + currentUser.getName() + "!");
                System.out.println("Menú para " + currentUser.getType() + ":");

                while (true) {
                    showAdminMenu();
                    switchAdmin(option());
                    if (currentUser == null) {
                        break;
                    }
                }
            }
            
        }

        //Goodbye
        System.out.println();
        System.out.println("¡Muchas gracias por usar nuestra aplicación!");
        System.out.println("¡Hasta pronto!");
        System.out.println();
    }

    //----------------------------------------------------------------------

    //Setting objects

    //----------------------------------------------------------------------

    //Setting a User
    private User setUser() {
        input.nextLine();   //Clean input buffer
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
        input.nextLine();
        String name = "";
        do {
            System.out.println();
            System.out.print("Introduce nombre: ");
            name = input.nextLine();
            if (videogameManager.videogameExists(name)) {
                System.out.println();
                System.out.println("Videojuego ya existente.");
            }
        } while (videogameManager.videogameExists(name));
        
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

                default: System.out.println("Opción inválida.");
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

                default: System.out.println("Opción inválida.");
            }
        }
        
        input.nextLine();
        System.out.println();
        System.out.print("Introduce fecha de lanzamiento (formato dd/mm/aaaa): ");
        String releaseDate = input.nextLine();
        
        Videogame videogame = new Videogame(name, platforms, genres, releaseDate);
        return videogame;
    }
    
    //Setting a Review
    private Review setReview() {
        int election = 0;
        videogameManager.showVideogames();
        
        do {
            System.out.println();
            System.out.print("¿Sobre qué videojuego vas a hacer la reseña? Elige una opción de las anteriores: ");
            election = (input.nextInt() - 1);
            if (election < 0 || election > (videogameManager.numVideogames - 1)) {
                System.out.println();
                System.out.println("Videojuego inválido, elige otro.");
            }
        } while (election < 0 || election > (videogameManager.numVideogames - 1));

        input.nextLine();
        System.out.println();
        System.out.print("Título: ");
        String title = input.nextLine();
        
        System.out.println();
        System.out.print("Cuerpo: ");
        String body = input.nextLine();
        
        System.out.println();
        System.out.print("Valoración (de 1 a 5 estrellas): ");
        int rating = input.nextInt();
        if (rating > 5) {
            rating = 5;
        }
        if (rating < 1) {
            rating = 1;
        }
        
        System.out.println();
        System.out.println("¿Cuántas horas has jugado al videojuego?");
        double playedHours = input.nextDouble();

        Review review = new Review(title, body, rating, playedHours, videogameManager.videogames[election], currentUser);
        return review;
    }

    //----------------------------------------------------------------------

    //Loading different objects

    //----------------------------------------------------------------------

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
        Videogame videogame0 = new Videogame("Minecraft", new Videogame.Platform[] {Videogame.Platform.PC, Videogame.Platform.PLAYSTATION, Videogame.Platform.XBOX}, new Videogame.Genre[] {Videogame.Genre.ACTION, Videogame.Genre.ADVENTURE}, "18/11/2011");
        videogameManager.addVideogame(videogame0);
        //Horizon Zero Dawn
        Videogame videogame1 = new Videogame("Horizon Zero Dawn", new Videogame.Platform[] {Videogame.Platform.PC, Videogame.Platform.PLAYSTATION, Videogame.Platform.XBOX}, new Videogame.Genre[] {Videogame.Genre.ACTION, Videogame.Genre.ADVENTURE, Videogame.Genre.SHOOTER}, "28/02/2017");
        videogameManager.addVideogame(videogame1);
        //Tetris
        Videogame videogame2 = new Videogame("Tetris", new Videogame.Platform[] {Videogame.Platform.PC, Videogame.Platform.SMARTPHONE}, new Videogame.Genre[] {Videogame.Genre.PUZZLE}, "06/06/1984");
        videogameManager.addVideogame(videogame2);
        //The Last of Us
        Videogame videogame3 = new Videogame("The Last of Us", new Videogame.Platform[] {Videogame.Platform.PC, Videogame.Platform.PLAYSTATION}, new Videogame.Genre[] {Videogame.Genre.ACTION, Videogame.Genre.ADVENTURE, Videogame.Genre.SHOOTER, Videogame.Genre.PUZZLE}, "14/06/2013");
        videogameManager.addVideogame(videogame3);
        //Diablo IV
        Videogame videogame4 = new Videogame("Diablo IV", new Videogame.Platform[] {Videogame.Platform.PC, Videogame.Platform.PLAYSTATION, Videogame.Platform.XBOX}, new Videogame.Genre[] {Videogame.Genre.ACTION, Videogame.Genre.ACTION}, "06/06/2023");
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
        //Review randomuser
        Review review2 = new Review("Diablo 4 pinta muy chulo", "Gran improvement pero es simplemente una versión mejorada de Diablo 3", 3, 2.06, videogameManager.videogames[4], userManager.users[3]);
        reviewManager.addReview(review2);

    }

    //Calls all loading functions to simply call this function in method start()
    private void loadObjects() {
        loadUsers();
        loadVideogames();
        loadReviews();
    }

    //----------------------------------------------------------------------

    //Menus

    //----------------------------------------------------------------------

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
        System.out.println("8. Desbanear usuario.");
        System.out.println("9. Cerrar sesión.");
        System.out.println();
    }

    //Admin menu
    private void showAdminMenu() {
        System.out.println();
        System.out.println("1. Administrar videojuegos.");
        System.out.println("2. Administrar usuarios.");
        System.out.println("3. Cerrar sesión.");
        System.out.println();
    }

    //Admin submenu 1
    private void showAdminSubmenu1(){
        System.out.println();
        System.out.println("1. Crear información videojuego.");
        System.out.println("2. Editar información videojuego.");
        System.out.println("3. Eliminar videojuego.");
        System.out.println("4. Mostrar videojuegos.");
        System.out.println("5. Buscar videojuegos.");
        System.out.println("6. Atrás.");
        System.out.println();
    }

    //Admin submenu 1
    private void showAdminSubmenu2(){
        System.out.println();
        System.out.println("1. Crear usuario.");
        System.out.println("2. Modificar datos usuario.");
        System.out.println("3. Eliminar usuario.");
        System.out.println("4. Mostrar usuarios.");
        System.out.println("5. Buscar usuarios.");
        System.out.println("6. Atrás.");
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
        System.out.println("5. Atrás.");
        System.out.println();
    }

    //----------------------------------------------------------------------

    //Input methods

    //----------------------------------------------------------------------

    //Returns an int determined by user input
    private int option() {
        System.out.print("Elige opción: ");
        return input.nextInt();
    }

    //----------------------------------------------------------------------

    //Switches

    //----------------------------------------------------------------------
    
    //Switch for Sign in - Register menu
    private void switchLogIn(int option) {
        switch (option) {
            //Iniciar sesión
            case 1:
                logIn();
            break;
            //Registrarse
            case 2:
                register();
            break;
            //Salir
            case 3:
                running = false;
            break;

            default: System.out.println("Opción inválida.");
        }
    }

    //----------------------------------------------------------------------

    //Swtich for User menu
    private void switchUser(int option) {
        switch (option) {
            //Publicar reseña
            case 1:
                if (reviewManager.isFull()) {
                    System.out.println();
                    System.out.println("No hay espacio para más reseñas.");
                    break;
                }
                reviewManager.addReview(setReview());
            break;
            //Editar reseña
            case 2:
                if (reviewManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No tienes reseñas publicadas que editar.");
                    break;
                }
                reviewManager.filterByUser(currentUser);
                System.out.println();
                System.out.print("Elige la reseña que deseas editar: ");
                int editReview = input.nextInt();
                input.nextLine();
                System.out.println();
                System.out.print("Nuevo título: ");
                String title = input.nextLine();
                System.out.println();
                System.out.print("Nuevo cuerpo: ");
                String body = input.nextLine();
                System.out.println();
                System.out.print("Nueva valoración: ");
                int rating = input.nextInt();
                reviewManager.reviews[editReview - 1].editReview(title, body, rating);
            break;
            //Borrar reseña
            case 3:
                if (reviewManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No tienes reseñas publicadas para borrar.");
                    break;
                }
                reviewManager.filterByUser(currentUser);
                System.out.println();
                System.out.print("Elige la reseña que deseas borrar: ");
                int removeReview = input.nextInt();
                input.nextLine();
                reviewManager.removeReview(removeReview - 1);
            break;
            //Mostrar reseñas
            case 4:
                if (reviewManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No tienes reseñas publicadas para borrar.");
                    break;
                }
                reviewManager.showReviews();
            break;
            //Buscar reseñas
            case 5:
                if (reviewManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No tienes reseñas publicadas para borrar.");
                    break;
                }
                submenu = true;
                while(submenu) {
                    showSubmenuSearching();
                    switchSubmenuSearching(option());
                }
            break;
            //Cerrar sesión
            case 6:
                currentUser = null;
            break;

            default: System.out.println("Opción inválida.");
        }
    }

    //----------------------------------------------------------------------

    //Switch for Mod menu
    private void switchMod(int option) {
        switch (option) {
            //Publicar reseña
            case 1:
                if (reviewManager.isFull()) {
                    System.out.println();
                    System.out.println("No hay espacio para más reseñas.");
                    break;
                }
                reviewManager.addReview(setReview());
            break;
            //Editar reseña
            case 2:
                if (reviewManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No tienes reseñas publicadas que editar.");
                    break;
                }
                reviewManager.filterByUser(currentUser);
                System.out.println();
                System.out.print("Elige la reseña que deseas editar: ");
                int editReview = input.nextInt();
                input.nextLine();
                System.out.println();
                System.out.print("Nuevo título: ");
                String title = input.nextLine();
                System.out.println();
                System.out.print("Nuevo cuerpo: ");
                String body = input.nextLine();
                System.out.println();
                System.out.print("Nueva valoración: ");
                int rating = input.nextInt();
                reviewManager.reviews[editReview - 1].editReview(title, body, rating);
            break;
            //Borrar reseña
            case 3:
                if (reviewManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No tienes reseñas publicadas para borrar.");
                    break;
                }
                reviewManager.filterByUser(currentUser);
                System.out.println();
                System.out.print("Elige la reseña que deseas borrar: ");
                int removeReview = input.nextInt();
                input.nextLine();
                reviewManager.removeReview(removeReview - 1);
            break;
            //Mostrar reseñas
            case 4:
                if (reviewManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No tienes reseñas publicadas para borrar.");
                    break;
                }
                reviewManager.showReviews();
            break;
            //Buscar reseñas
            case 5:
                if (reviewManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No tienes reseñas publicadas para borrar.");
                    break;
                }
                submenu = true;
                while(submenu) {
                    showSubmenuSearching();
                    switchSubmenuSearching(option());
                }
            break;
            //Borrar reseña ajena
            case 6:
                if (reviewManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No tienes reseñas publicadas para borrar.");
                    break;
                }
                reviewManager.showReviews();
                int removeAnyReview = 0;
                do {
                    System.out.println();
                    System.out.print("Elige la reseña que deseas borrar: ");
                    removeAnyReview = input.nextInt();
                    input.nextLine();
                    if (removeAnyReview < 1 || removeAnyReview > reviewManager.numReviews) {
                       System.out.println("");
                       System.out.println("Reseña seleccionada inválida.");
                    }
                } while(removeAnyReview < 1 || removeAnyReview > reviewManager.numReviews);
                reviewManager.removeReview(removeAnyReview - 1);
            break;
            //Banear usuario
            case 7:
                userManager.filterByNotBanned();
                int banUser = 0;
                do {
                    System.out.println();
                    System.out.print("Elige al usuario que deseas banear: ");
                    banUser = input.nextInt();
                    if (banUser < 1 || banUser > userManager.numUsers || userManager.users[banUser - 1].isBanned) {
                        System.out.println();
                        System.out.println("Usuario seleccionado inválido.");
                    }
                } while (banUser < 1 || banUser > userManager.numUsers || userManager.users[banUser - 1].isBanned);
                userManager.users[banUser - 1].banUser();
            break;
            //Desbanear usuario
            case 8:
                if (!userManager.hasBannedUsers()) {
                    System.out.println();
                    System.out.println("No hay usuarios baneados.");
                    break;
                }
                userManager.filterByBanned();
                int unBan = 0;
                do {
                    System.out.println();
                    System.out.print("Elige al usuario que deseas desbanear: ");
                    unBan = input.nextInt();
                    if (unBan < 1 || unBan > userManager.numUsers || !userManager.users[unBan - 1].isBanned) {
                        System.out.println();
                        System.out.println("Usuario seleccionado inválido.");
                    }
                } while (unBan < 1 || unBan > userManager.numUsers || !userManager.users[unBan - 1].isBanned);
                userManager.users[unBan - 1].unbanUser();
            break;
            //Cerrar sesión
            case 9:
                currentUser = null;
            break;
            
            default: System.out.println("Opción inválida.");
        }
    }

    //----------------------------------------------------------------------

    //Switch for Admin menu
    private void switchAdmin(int option) {
        switch (option) {
            //Administrar videojuegos
            case 1:
                submenu = true;
                while (submenu) {
                    showAdminSubmenu1();
                    switchAdminSubmenu1(option());
                }
            break;
            //Administrar usuarios
            case 2:
                submenu = true;
                while (submenu) {
                    showAdminSubmenu2();
                    switchAdminSubmenu2(option());
                }
            break;
            //Cerrar sesión
            case 3:
                currentUser = null;
            break;
            
            default: System.out.println("Opción inválida.");
        }
    }

    //----------------------------------------------------------------------

    //Switch for admin submenu 1
    private void switchAdminSubmenu1(int option){
        switch (option) {
            //Crear información videojuego
            case 1:
                if (videogameManager.isFull()) {
                    System.out.println();
                    System.out.println("Límite de videojuegos alcanzado.");
                    break;
                }
                videogameManager.addVideogame(setVideogame());
            break;
            //Editar información videojuego
            case 2:
                if (videogameManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No hay ningún videojuego en la plataforma actualmente.");
                    break;
                }
                videogameManager.showVideogames();
                System.out.println();
                System.out.print("Elige el videojuego que deseas editar: ");
                int editVideogame = input.nextInt();
                videogameManager.editVideogame(editVideogame, setVideogame());
            break;
            //Eliminar videojuego
            case 3:
                if (videogameManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No hay ningún videojuego en la plataforma actualmente.");
                    break;
                }
                videogameManager.showVideogames();
                System.out.println();
                System.out.print("Elige el videojuego que deseas eliminar: ");
                int removeVideogame = input.nextInt();
                videogameManager.removeVideogame(removeVideogame - 1);
            break;
            //Mostrar videojuegos
            case 4:
                if (videogameManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No hay ningún videojuego en la plataforma actualmente.");
                    break;
                }
                videogameManager.showVideogames();
            break;
            //Buscar videojuegos
            case 5:
                if (videogameManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No hay ningún videojuego en la plataforma actualmente.");
                    break;
                }
                submenu2 = true;
                while (submenu2) {
                    showSubmenuVideogameSearching();
                    switchSubmenuVideogame(option());
                }
            break;
            //Atrás
            case 6:
            submenu = false;
            break;

            default: System.out.println("Opción inválida.");
        }
    }

    //----------------------------------------------------------------------

    //Switch for admin submenu 2
    private void switchAdminSubmenu2(int option) {
        switch (option) {
            //Crear usuario
            case 1:
                if (userManager.isFull()) {
                    System.out.println();
                    System.out.println("Se ha alcanzado el número máximo de usuarios.");
                    break;
                }
                userManager.addUser(setUser());
            break;
            //Modificar datos usuario
            case 2:
                if (userManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No hay usuarios registrados actualmente.");
                    break;
                }
                userManager.showUsers();;
                System.out.println();
                System.out.print("Elige el usuario que deseas modificar: ");
                int editUser = input.nextInt();
                userManager.editUser(editUser, setUser());
            break;
            //Eliminar usuario
            case 3:
                if (userManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No hay usuarios registrados actualmente.");
                    break;
                }
                userManager.showUsers();;
                System.out.println();
                System.out.print("Elige el usuario que deseas eliminar: ");
                int removeUser = input.nextInt();
                userManager.removeUser(removeUser);
            break;
            //Mostrar usuarios
            case 4:
                if (userManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No hay usuarios registrados actualmente.");
                    break;
                }
                userManager.showUsers();
            break;
            //Buscar usuarios
            case 5:
                if (userManager.isEmpty()) {
                    System.out.println();
                    System.out.println("No hay usuarios registrados actualmente.");
                    break;
                }
                submenu2 = true;
                while (submenu2) {
                    showSubMenuUsersSearching();
                    switchSubMenuUser(option());
                }
            break;
            //Atrás
            case 6:
            submenu = false;
            break;

            default: System.out.println("Opción inválida.");
        }
    }

    //----------------------------------------------------------------------

    //Switch for submenu searching options
    private void switchSubmenuSearching(int option) {
        switch (option) {
            //Buscar por videojuego
            case 1:
                submenu2 = true;
                while (submenu2) {
                    showSubmenuVideogameSearching();
                    switchSubmenuVideogame(option());
                }
            break;
            //Buscar por usuario
            case 2:
                userManager.showUsers();
                int election = 0;
                do {
                    System.out.println();
                    System.out.print("Elige un usuario de la lista: ");
                    election = (input.nextInt());
                    if (election < 0 || election > (userManager.numUsers - 1)) {
                        System.out.println();
                        System.out.println("Usuario no válido.");
                    }
                } while (election < 0 || election > (userManager.numUsers - 1));
        
                reviewManager.filterByUser(userManager.users[election - 1]);
            break;
            //Buscar por valoración
            case 3:
                System.out.println();
                System.out.print("Valoración mínima (1 a 5): ");
                int rating = input.nextInt();
                reviewManager.filterByRating(rating);
            break;
            //Buscar por horas jugadas
            case 4:
                System.out.println();
                System.out.print("Introduce un mínimo de horas jugadas: ");
                double numHoursPlayed = input.nextDouble();
                reviewManager.filterByPlayedHours(numHoursPlayed);
            break;
            //Atrás
            case 5:
                submenu = false;
            break;
            
            default: System.out.println("Opción inválida.");
        }
    }

    //----------------------------------------------------------------------

    //Switch for submenu searching videogame options
    private void switchSubmenuVideogame(int option) {
        switch (option) {
            //Buscar por nombre
            case 1:
                input.nextLine();
                System.out.println();
                System.out.print("Introduce el nombre: ");
                String name = input.nextLine();
                videogameManager.filterByName(name);
            break;
            //Buscar por plataforma
            case 2:
                System.out.println();
                System.out.println("Introduce plataforma: ");
                System.out.println("1. PLAYSTATION, 2. XBOX, 3. NINTENDO, 4. PC, 5. SMARTPHONE");
                int platformSelected = input.nextInt();
                switch(platformSelected) {
                    //Filter by PLAYSTATION
                    case 1:
                        videogameManager.filterByPlatform(Videogame.Platform.PLAYSTATION);
                    break;
                    //Filter by XBOX
                    case 2:
                        videogameManager.filterByPlatform(Videogame.Platform.XBOX);
                    break;
                    //Filter by NINTENDO
                    case 3:
                        videogameManager.filterByPlatform(Videogame.Platform.NINTENDO);
                    break;
                    //Filter by PC
                    case 4:
                        videogameManager.filterByPlatform(Videogame.Platform.PC);
                    break;
                    //Filter by SMARTPHONE
                    case 5:
                        videogameManager.filterByPlatform(Videogame.Platform.SMARTPHONE);
                    break;

                    default: System.out.println("Opción inválida.");
                }
            break;
            //Buscar por género
            case 3:
                System.out.println();
                System.out.println("Introduce género: ");
                System.out.println("1. ACTION, 2. ADVENTURE, 3. ROLEPLAYING, 4. STRATEGY, 5. SIMULATION, 6. PUZZLE, 7. SHOOTER, 8. OTHER");
                int genreSelected = input.nextInt();
                switch(genreSelected) {
                    //Filter by ACTION
                    case 1:
                        videogameManager.filterByGenre(Videogame.Genre.ACTION);
                    break;
                    //Filter by ADVENTURE
                    case 2:
                        videogameManager.filterByGenre(Videogame.Genre.ADVENTURE);
                    break;
                    //Filter by ROLEPLAYING
                    case 3:
                        videogameManager.filterByGenre(Videogame.Genre.ROLEPLAYING);
                    break;
                    //Filter by STRATEGY
                    case 4:
                        videogameManager.filterByGenre(Videogame.Genre.STRATEGY);
                    break;
                    //Filter by SIMULATION
                    case 5:
                        videogameManager.filterByGenre(Videogame.Genre.SIMULATION);
                    break;
                    //Filter by PUZZLE
                    case 6:
                        videogameManager.filterByGenre(Videogame.Genre.PUZZLE);
                    break;
                    //Filter by SHOOTER
                    case 7:
                        videogameManager.filterByGenre(Videogame.Genre.SHOOTER);
                    break;
                    //Filter by OTHER
                    case 8:
                        videogameManager.filterByGenre(Videogame.Genre.OTHER);
                    break;

                    default: System.out.println("Opción inválida.");
                }
            break;
            //Atrás
            case 4:
                submenu2 = false;
            break;
            
            default: System.out.println("Opción inválida.");
        }
    }

    //----------------------------------------------------------------------

    //Switch for submenu searching user options
    private void switchSubMenuUser(int option) {
        switch (option) {
            //Buscar por nombre
            case 1:
                input.nextLine();
                System.out.println();
                System.out.print("Introduce nombre: ");
                String name = input.nextLine();

                userManager.filterByName(name);
            break;
            //Buscar por apodo
            case 2:
                input.nextLine();
                System.out.println();
                System.out.print("Introduce nombre de usuario: ");
                String username = input.nextLine();

                userManager.filterByUserName(username);
            break;
            //Buscar por correo
            case 3:
                input.nextLine();
                System.out.println();
                System.out.print("Introduce correo: ");
                String mail = input.nextLine();

                userManager.filterByMail(mail);
            break;
            //Buscar por ban
            case 4:
                userManager.filterByBanned();
            break;
            //Atrás
            case 5:
                submenu2 = false;
            break;
            
            default: System.out.println("Opción inválida.");
        }
    }

    //----------------------------------------------------------------------

    //Specific functions

    //----------------------------------------------------------------------

    //Log In function
    private void logIn() {
        input.nextLine();   //Clean input buffer
        System.out.println();
        System.out.print("Introduce tu nombre de usuario: ");
        String username = input.nextLine();

        System.out.println();
        System.out.print("Introduce tu contraseña: ");
        String password = input.nextLine();

        if (userManager.getCurrentUser(username, password) == null) {
            System.out.println();
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
        else if (userManager.getCurrentUser(username, password).isBanned) {
            System.out.println();
            System.out.println("Estás baneado.");
        }
        else {
            currentUser = userManager.getCurrentUser(username, password);
        }
    }

    //----------------------------------------------------------------------

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