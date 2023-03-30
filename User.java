//Albert Lozano y Sergi Marrahy 
//1 DAM - Programación

//Class done by Marrahy
public class User {

    //Enum
    
    public enum UserType {
        ADMIN, MOD, USER
    }

    //Class attributes
    String name, username, mail, password;
    UserType type;
    boolean isBanned;

    //----------------------------------------------------------------------

    //Empty constructor
    public User() {
        
    }

    //Constructor for the user
    public User(String name, String username, String mail, String password) {
        setName(name);
        setUsername(username);
        setMail(mail);
        setPassword(password);
        setType(UserType.USER);
        setBanned(false);
    }

    //Constructor
    public User(String name, String username, String mail, String password, UserType type, boolean isBanned) {
        setName(name);
        setUsername(username);
        setMail(mail);
        setPassword(password);
        setType(type);
        setBanned(isBanned);
    }
    
    //----------------------------------------------------------------------

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setType(UserType type) {
        this.type = type;
    }
    public void setBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getMail() {
        return mail;
    }
    public String getPassword() {
        return password;
    }
    public UserType getType() {
        return type;
    }
    public boolean getIsBanned() {
        return isBanned;
    }
    //----------------------------------------------------------------------

    //Functions

    //Function to show user data
    public void showUser() {
        System.out.println();
        System.out.println("Nombre: " + getName());
        System.out.println("Apodo: " + getUsername());
        System.out.println("Email: " + getMail());
        System.out.println("Tipo de usuario: " + getType());
    }
    
    //Booleans to do simple checks on the object (help other methods and more legible)

    //Returns true if a String equals the user's name (ignoring case)
    public boolean isName(String name) {
        return getName().equalsIgnoreCase(name);
    }

    //Returns true if a String equals the user's username (ignoring case)
    public boolean isUserName(String username) {
        return getUsername().equalsIgnoreCase(username);
    }

    //Returns true if a String is contained within the user's mail (ignoring case)
    public boolean isMail(String mail) {
        return getMail().toLowerCase().contains(mail.toLowerCase());
    }

    //Returns true if the introduced password matches the user's password
    public boolean correctPassword(String password) {
        return getPassword().equals(password);
    }

    //Returns true if the type equals the actual user's type
    public boolean isUserType(UserType type) {
        return getType().equals(type);
    }

    //Returns true if the specified user is banned
    public boolean isBanned(User user) {
        return getIsBanned() == true;
    }

    //Function to ban a user
    public void banUser() {
        this.isBanned = true;
    }

    //Function to unban a user
    public void unbanUser() {
        this.isBanned = false;
    }
}