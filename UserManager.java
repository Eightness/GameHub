//Albert Lozano y Sergi Marrahy 
//1 DAM - Programación

//Class done by Marrahy
public class UserManager {

    //Class attributes
    private int maxUsers = 10;
    public int numUsers = 0;
    public User[] users = new User[maxUsers];
    //----------------------------------------------------------------------

    //Void constructor
    public UserManager() {

    }
    //Constructor
    public UserManager(int maxUsers) {
        setMaxUsers(maxUsers);   
    }
    //----------------------------------------------------------------------

    //Setters
    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }
    public void setNumUsers(int numUsers) {
        this.numUsers = numUsers;
    }
    public void setUsers(User[] users) {
        this.users = users;
    }

    //Getters
    public int getMaxUsers() {
        return maxUsers;
    }
    public int getNumUsers() {
        return numUsers;
    }
    public User[] getUsers() {
        return users;
    }
    //----------------------------------------------------------------------

    //Functions
    public boolean isEmpty() {
        return users[0] == null;
    }

    public boolean isFull() {
        return numUsers == maxUsers;
    }
    
    public void addUser(User user) {
        users[numUsers] = user;
        numUsers++;
    }

    public void removeUser(int pos) {
        users[pos] = null;
        for (int i = pos; i < numUsers - 1; i++) {
            users[i] = users[i + 1];
        }
        numUsers--;
    }

    public void showUsers() {
        for (int i = 0; i < numUsers; i++) {
            System.out.println();
            System.out.println("Usuario " + (i + 1) + ":");
            users[i].showUser();
        }
    }

    public void filterByName(String name) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isName(name)) {
                System.out.println("Usuario " + (i + 1) + ":");
                users[i].showUser();
            }
        }
    }

    public void filterByUserName(String username) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isUserName(username)) {
                System.out.println("Usuario " + (i + 1) + ":");
                users[i].showUser();
            }
        }
    }

    public void filterByMail(String mail) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isMail(mail)) {
                System.out.println("Usuario " + (i + 1) + ":");
                users[i].showUser();
            }
        }
    }

    public void filterByUserType(User.UserType type) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isUserType(type)) {
                System.out.println("Usuario " + (i + 1) + ":");
                users[i].showUser();
            }
        }
    }

    public void filterByBanned() {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isBanned) {
                System.out.println();
                System.out.println("Usuario " + (i + 1) + ":");
                users[i].showUser();
            }
        }
    }

    public void filterByNotBanned() {
        for (int i = 0; i < numUsers; i++) {
            if (!users[i].isBanned) {
                System.out.println();
                System.out.println("Usuario " + (i + 1) + ":");
                users[i].showUser();
            }
        }
    }

    public User getCurrentUser(String username, String password) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isUserName(username) && users[i].correctPassword(password)) {
                return users[i];
            }
        }
        return null;
    }

    public boolean usernameExists(String username) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isUserName(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean mailExists(String mail) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isMail(mail)) {
                return true;
            }
        }
        return false;
    }

    public void editUser(int edit, User user) {
        users[edit - 1] = user;
    }

}
