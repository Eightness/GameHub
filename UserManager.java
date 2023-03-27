//Albert Lozano y Sergi Marrahy 
//1 DAM - Programación

//Class done by Marrahy
public class UserManager {

    //Class attributes
    private int maxUsers = 10;
    public int numUsers = 0;
    public User[] users = new User[maxUsers];

    //----------------------------------------------------------------------

    //Empty constructor
    public UserManager() {

    }
    
    //Constructor that sets the maximum users you can store
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

    //Booleans to check users array status

    //Returns true if there are not users in the array
    public boolean isEmpty() {
        return users[0] == null;
    }

    //Returns true if there is no more space to store users
    public boolean isFull() {
        return numUsers == maxUsers;
    }
    
    //Function to add an user
    public void addUser(User user) {
        users[numUsers] = user;
        numUsers++;
    }

    //Function to remove a user
    public void removeUser(int pos) {
        users[pos] = null;
        for (int i = pos; i < numUsers - 1; i++) {
            users[i] = users[i + 1];
        }
        numUsers--;
    }

    //Function to show all users data
    public void showUsers() {
        for (int i = 0; i < numUsers; i++) {
            System.out.println();
            System.out.println("Usuario " + (i + 1) + ":");
            users[i].showUser();
        }
    }

    //Function to filter by user's name
    public void filterByName(String name) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isName(name)) {
                System.out.println("Usuario " + (i + 1) + ":");
                users[i].showUser();
            }
        }
    }

    //Function to filter by user's username
    public void filterByUserName(String username) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isUserName(username)) {
                System.out.println("Usuario " + (i + 1) + ":");
                users[i].showUser();
            }
        }
    }

    //Function to filter by user's mail
    public void filterByMail(String mail) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isMail(mail)) {
                System.out.println("Usuario " + (i + 1) + ":");
                users[i].showUser();
            }
        }
    }

    //Function to filter by user's type
    public void filterByUserType(User.UserType type) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isUserType(type)) {
                System.out.println("Usuario " + (i + 1) + ":");
                users[i].showUser();
            }
        }
    }

    //Function to filter by banned users
    public void filterByBanned() {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isBanned) {
                System.out.println();
                System.out.println("Usuario " + (i + 1) + ":");
                users[i].showUser();
            }
        }
    }

    //Function to filter by not banned users
    public void filterByNotBanned() {
        for (int i = 0; i < numUsers; i++) {
            if (!users[i].isBanned) {
                System.out.println();
                System.out.println("Usuario " + (i + 1) + ":");
                users[i].showUser();
            }
        }
    }

    //Function to get the current user (logged in user / username and password matches)
    public User getCurrentUser(String username, String password) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isUserName(username) && users[i].correctPassword(password)) {
                return users[i];
            }
        }
        return null;
    }

    //Function to see if a username exists or not
    public boolean usernameExists(String username) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isUserName(username)) {
                return true;
            }
        }
        return false;
    }

    //Function to see if an email is already registered
    public boolean mailExists(String mail) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isMail(mail)) {
                return true;
            }
        }
        return false;
    }

    //Function to modify one user data
    public void editUser(int edit, User user) {
        users[edit - 1] = user;
    }

    //Function to see if there are banned users
    public boolean hasBannedUsers() {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].isBanned) {
                return true;
            }
        }
        return false;
    }

}
