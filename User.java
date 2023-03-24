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

    //Void constructor
    public User() {
        
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
    public void showUser() {
        System.out.println();
        System.out.println("Nombre: " + getName());
        System.out.println("Apodo: " + getUsername());
        System.out.println("Email: " + getMail());
        System.out.println("Tipo de usuario: " + getType());
        System.out.println();
    }

    public boolean isName(String name) {
        return getName().equalsIgnoreCase(name);
    }

    public boolean isUserName(String username) {
        return getUsername().equalsIgnoreCase(username);
    }

    public boolean isMail(String mail) {
        return getMail().contains(mail);
    }

    public boolean correctPassword(String password) {
        return getPassword().equals(password);
    }

    public boolean isUserType(UserType type) {
        return getType().equals(type);
    }
}