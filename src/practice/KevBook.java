package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This class is a simple demonstration of a
 * social networks connections using Graphs data structure
 *
 * main objective is:
 *   - Create a user(Node)
 *   - Create a connection(edge)
 *   - Connect two users
 *   - Check if user exists
 *   - Remove connection
 *   - Delete a user
 * */

class KevBook {
    private HashMap<String, User> users = new HashMap<>();

    void setConnection(User conn1, User conn2) {
        if (contains(conn1) && contains(conn2)) {
            List<User> connections1 = conn1.getConnections();
            List<User> connections2 = conn2.getConnections();

            connections1.add(conn2);
            connections2.add(conn1);
        }
    }

    void printAll() {
        for (Map.Entry user : users.entrySet()) {
            User node = (User) user.getValue();
            System.out.println(node.getName());
        }
    }

    User addUser(String name) {
        var user = new User(name);
        if (!contains(user))
            users.put(user.getUsername(), user);
        else
            System.out.println(user.getName() + " already exists!");

        return user;
    }

    private boolean contains(User user) {
        return users.containsKey(user.getUsername());
    }

    void getFriends(User user) {
        try {
            System.out.println("********* " + user.getUsername() + "'s friends ******************");
            for (User conn : user.getConnections()) {
                System.out.println(conn.getName());
            }
        } catch (NullPointerException e) {
//            System.out.println("User does not exist");
        }
    }

    void unFriend(User conn, User conn2) {

        if (conn.isConnected(conn2)) {
            conn.getConnections().remove(conn2);
            conn2.getConnections().remove(conn);
        }
    }

    void deleteAccount(User account) {
        for (User user : account.getConnections()) {
            user.getConnections().remove(account);
        }

        users.remove(account.getUsername());
        account.delete();
    }
}

class User {
    private HashMap<String, Object> user = new HashMap<>();

    User(String name) {
        user.put("username", name.split(" ")[0].toLowerCase());
        user.put("name", name);
        user.put("email", name.replace(" ", ".") + "@kevbook.com");
        user.put("edges", new ArrayList<User>());
    }

    String getUsername() {
        return (String) user.get("username");
    }

    ArrayList<User> getConnections() {
        return (ArrayList<User>) user.get("edges");
    }

    String getName() {
        return (String) user.get("name");
    }

    boolean isConnected(User conn) {
        for (User user : getConnections()) {
            if (user == conn)
                return true;
        }
        return false;
    }

    void delete() {
        user = null;
    }
}
