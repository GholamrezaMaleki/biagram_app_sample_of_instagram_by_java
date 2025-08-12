import java.util.Random;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Biagram {
    private Clients clients[];
    private int numberofClients;

    public int getIndexEnteredClient() {
        return indexEnteredClient;
    }

    public void setIndexEnteredClient(int indexEnteredClient) {
        this.indexEnteredClient = indexEnteredClient;
    }

    private int indexEnteredClient;

    public Clients[] getClients() {
        return clients;
    }

    public int getNumberofClients() {
        return numberofClients;
    }

    public void setNumberofClients(int numberofClients) {
        this.numberofClients = numberofClients;
    }

    public void setClients(Clients[] clients) {
        this.clients = clients;
    }

    public Biagram() {
        numberofClients = 100;
        clients = new Clients[numberofClients];
    }

    //this methode make the shae of Entering
    public void shapeOfEntering() {
        System.out.println("\n" + "\u001B[38;2;0;130;201m(1)\u001B[0m" +
                "\t\u001B[38;2;0;130;201m              * \n" +
                "\t  |   _    _  |   _  \n" +
                "\t  |  | |  | | |  | |  \n" +
                "\t  |  |_|  |_| |  | |  \n" +
                "\t  |     ____| |  | |   \n\u001B[0m");
        System.out.println("\n" + "\u001B[38;2;218;112;214m(2)\u001B[0m" +
                "\t\u001B[38;2;218;112;214m                      \n" +
                "\t   _      _    _  *     _ _  ___   _     _    \n" +
                "\t  |_|    |_   | | |    |  |   |   |_    |_|   \n" +
                "\t  |  \\   |_   |_| |    |      |   |_    |  \\    \n" +
                "\t  |   \\     ____| | |__|      |         |   \\   \n\u001B[0m");
        System.out.println("\u001B[38;2;148;0;211m(3)forgot password\u001B[0m");
    }

    //to add client
    public void addClient(Clients client) {
        for (int i = 0; i < numberofClients; i++) {
            if (clients[i] == null) {
                clients[i] = client;
                break;
            }
        }
    }

    //to find a client
    public int findClient(String username) {
        for (int i = 0; i < numberofClients; i++) {
            if (clients[i] != null && clients[i].getUserName().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    //check true password
    public boolean checkpassword(int indexclient, String password) {
        if (clients[indexclient].getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    //check powerful password
    public boolean checkpowerfulpassword(String password) {
        char[] pass = new char[password.length()];
        pass = password.toCharArray();
        boolean smallLetter = false;
        boolean cpaitalLetter = false;
        boolean sighChar = false;
        boolean number = false;
        for (int i = 0; i < password.length(); i++) {
            if (pass[i] >= 'a' && pass[i] <= 'z') {
                smallLetter = true;
            } else if (pass[i] >= 'A' && pass[i] <= 'Z') {
                cpaitalLetter = true;
            } else if (pass[i] == '@' || pass[i] == '&') {
                sighChar = true;
            } else if (pass[i] >= '0' && pass[i] <= '9') {
                number = true;
            }

        }
        if (password.length() >= 10 && smallLetter == true && cpaitalLetter == true && sighChar == true && number == true) {
            return true;
        }
        return false;
    }

    //check true userName
    public boolean checkUserName(String username) {
        if (findClient(username) == -1) {
            return true;
        }
        return false;
    }

    //this methode manage the entering
    public boolean manageEntering(char select, Scanner scanner) {
        switch (select) {
            case '1':

                String securityCode = generateRandomString(4);
                System.out.println("\u001B[38;2;255;0;0m please input to recognize that you are not a robot \u001B[0m");
                System.out.println("Security Code :  " + securityCode);
                String inputCode = scanner.next();
                if (inputCode.compareTo(securityCode) != 0) {
                    break;
                }
                System.out.println("\u001B[38;2;0;255;0m please enter your user name ");
                System.out.println("****************************\u001B[0m");
                int indexOfclient = findClient(scanner.next());
                System.out.println("\u001B[38;2;0;255;0m please enter your password ");
                System.out.println("****************************\u001B[0m");
                String password = scanner.next();
                Main.cls();
                if (indexOfclient == -1) {
                    System.out.println("\u001B[38;2;255;0;0m there isn't an acount with this username");
                    System.out.println("please check it again or register \u001B[0m");
                    break;
                } else if (checkpassword(indexOfclient, password) == true) {
                    System.out.println("\u001B[38;2;0;255;0m you are successfully entered \u001B[0m");
                    indexEnteredClient = indexOfclient;
                    return true;
                } else {
                    System.out.println("\u001B[38;2;255;0;0m your password is wrong please try again \u001B[0m");

                }
                break;

            case '2':

                String securityCode2 = generateRandomString(4);
                System.out.println("\u001B[38;2;255;0;0mplease input to recognize that you are not a robot \u001B[0m");
                System.out.println("Security Code :  " + securityCode2);
                String inputCode2 = scanner.next();
                if (inputCode2.compareTo(securityCode2) != 0) {
                    break;
                }
                System.out.println("\u001B[38;2;0;255;0m please enter your name");
                System.out.println("***********************\u001B[0m");
                String name = scanner.next();
                boolean checkusername = false;
                String username = "";
                while (checkusername == false) {
                    System.out.println("\u001B[38;2;0;255;0m please enter your username\u001B[0m");
                    System.out.println("\u001B[38;2;255;165;0m your username must not be repetitious \u001B[0m");
                    System.out.println("\u001B[38;2;0;255;0m*********************** \u001B[0m");
                    username = scanner.next();
                    if (checkUserName(username) == true) {
                        checkusername = true;
                    }

                }
                String pass = getStringPassowrd(scanner);
                System.out.println("to help you to recovery your account please input a code and help note");
                System.out.println("code :");
                String recoveryCode = scanner.next();
                System.out.println("help note");
                String recoveryHelp = scanner.next();
                addClient(new Clients(name, username, pass, recoveryCode, recoveryHelp));
                System.out.println("\u001B[38;2;0;255;0m you are successfully added \u001B[0m");
                indexEnteredClient = findClient(username);
                return true;
            case '3':
                String securityCode3 = generateRandomString(4);
                System.out.println("\u001B[38;2;255;0;0mplease input to recognize that you are not a robot \u001B[0m");
                System.out.println("Security Code :  " + securityCode3);
                String inputCode3 = scanner.next();
                if (inputCode3.compareTo(securityCode3) != 0) {
                    break;
                }
                System.out.println("\u001B[38;2;0;255;0m please enter your user name ");
                System.out.println("****************************\u001B[0m");
                int indexOfClient = findClient(scanner.next());
                if (indexOfClient == -1) {
                    System.out.println("\u001B[38;2;255;0;0m there isn't an acount with this username");
                    System.out.println("please check it again or register \u001B[0m");
                    break;
                } else {
                    System.out.println("\u001B[38;2;0;255;0m please enter your recovery code ");
                    System.out.println("****************************\u001B[0m");
                    System.out.println("Help Note: " + clients[indexOfClient].getRecoveryHelp());
                    String recoveryCodeInputed = scanner.next();
                    if (clients[indexOfClient].getRecoveryCode().equals(recoveryCodeInputed)) {
                        String newPassword = getStringPassowrd(scanner);
                        clients[indexOfClient].setPassword(newPassword);
                        indexEnteredClient = indexOfClient;
                        return true;
                    }

                }


            default:
                break;
        }
        return false;
    }

    //this methode control powerful password
    private String getStringPassowrd(Scanner scanner) {
        boolean checkpass = false;
        String pass = "";
        while (checkpass == false) {
            System.out.println("\u001B[38;2;0;255;0m please enter your password \u001B[0m");
            System.out.println("\u001B[38;2;255;165;0m your password must grater than 10 charactor and contain numbers,small and capital letter and @ and & \u001B[0m");
            System.out.println("\u001B[38;2;0;255;0m ***********************\u001B[0m");
            pass = scanner.next();
            if (checkpowerfulpassword(pass) == true) {
                checkpass = true;
            }
            Main.cls();
        }
        return pass;
    }

    //this methode control crucial work
    public boolean mainManage(char select1, Scanner scanner) {
        int index = indexEnteredClient;
        switch (select1) {
            case '1':
                clients[indexEnteredClient].showIfo();
                // System.out.println(clients[index].toString());
                System.out.println("\u001B[38;2;0;255;0m(1) Followers And Follwings ");
                System.out.println("(2) perivois page");
                System.out.println("(3) edit profile");
                System.out.println("(4) set bio");
                System.out.println("(5) log out\u001B[0m");
                char select2 = scanner.next().charAt(0);
                Main.cls();
                if (select2 == '1') {
                    System.out.println(clients[index].showFollwerAndFollwing());
                    System.out.println("(1) posts of following");
                    System.out.println("(2) Home page");
                    char selectshowpost = scanner.next().charAt(0);
                    if (selectshowpost == '1') {
                        showpostsFromfollowing();
                    } else
                        break;
                } else if (select2 == '2') {
                } else if (select2 == '3') {
                    System.out.println("\u001B[38;2;0;255;0m(1) edit name");
                    System.out.println("(2) edit username");
                    System.out.println("(3) edit password\u001B[0m");
                    char selectEdit = scanner.next().charAt(0);
                    Main.cls();
                    switch (selectEdit) {
                        case '1':
                            System.out.println("\u001B[38;2;0;255;0m please enter your name");
                            System.out.println("***********************\u001B[0m");
                            String name = scanner.next();
                            Main.cls();
                            clients[indexEnteredClient].setName(name);
                            break;
                        case '2':
                            boolean checkusername = false;
                            String username = "";
                            while (checkusername == false) {
                                System.out.println("\u001B[38;2;0;255;0m please enter your username");
                                System.out.println("your password must not be repetitious");
                                System.out.println("***********************\u001B[0m");
                                username = scanner.next();
                                Main.cls();
                                if (checkUserName(username) == true) {
                                    checkusername = true;
                                }

                            }
                            for (int i = 0; i < clients[indexEnteredClient].getNumberOfFollowers(); i++) {
                                int indexf = findClient(clients[indexEnteredClient].getFollowers()[i]);
                                for (int j = 0; j < 100; j++) {
                                    if (clients[indexf].getFollowing()[j] != null && clients[indexf].getFollowing()[j].equals(clients[indexEnteredClient].getUserName())) {
                                        clients[indexf].setFollowing2(j, username);
                                    }
                                }
                            }
                            for (int i = 0; i < clients[indexEnteredClient].getNumberOfFollowing(); i++) {
                                int indexf = findClient(clients[indexEnteredClient].getFollowing()[i]);
                                for (int j = 0; j < 100; j++) {
                                    if (clients[indexf].getFollowers()[j] != null && clients[indexf].getFollowers()[j].equals(clients[indexEnteredClient].getUserName())) {
                                        clients[indexf].setFollower2(j, username);
                                    }
                                }
                            }
                            clients[indexEnteredClient].setUserName(username);

                            break;
                        case '3':
                            boolean checkpass = false;
                            String pass = "";
                            while (checkpass == false) {
                                System.out.println("\u001B[38;2;0;255;0m please enter your password");
                                System.out.println("your password must grater than 10 charactor and contain numbers,small and capital letter and @ and & ");
                                System.out.println("***********************\u001B[0m");
                                pass = scanner.next();

                                if (checkpowerfulpassword(pass) == true) {
                                    checkpass = true;
                                }
                                Main.cls();
                            }
                            clients[indexEnteredClient].setPassword(pass);
                            break;
                    }
                } else if (select2 == '4') {
                    scanner.nextLine();
                    clients[indexEnteredClient].setBio(scanner.nextLine());
                } else if (select2 == '5')
                    return false;
                break;
            case '2':
                searchUserName(scanner);
                break;
            case '3':
                System.out.println("\u001B[38;2;0;255;0m(1) send post");
                System.out.println("(2) review and edit post");
                System.out.println("(3) previous page\u001B[0m");
                String select4 = scanner.next();
                Main.cls();
                switch (select4) {
                    case "1":
                        System.out.println("\u001B[38;2;0;255;0m please input");
                        System.out.println("you can create text posts with a character limitation of up to 200 \u001B[0m");
                        boolean finish = false;

                        StringBuilder result = new StringBuilder();
                        System.out.println("\u001B[38;2;255;165;0m to end text type @ in a new line and enter a Enter \u001B[0m");
                        while (true) {
                            String line = scanner.nextLine();
                            if (line.equals("@")) {
                                break;
                            }
                            result.append(line);
                            result.append("\n\t");
                        }

                        if (result.length() >= 200) {
                            result = new StringBuilder(result.substring(0, 200));
                        }
                        clients[indexEnteredClient].addMessage(new Chat(valueOf(result)));
                        break;
                    case "2":
                        clients[indexEnteredClient].showPosts2();
                        System.out.println("\u001B[38;2;0;255;0m (1) edit post...");
                        System.out.println("(2) delete post...");
                        System.out.println("(3) previous page\u001B[0m");
                        char edit = scanner.next().charAt(0);
                        Main.cls();
                        if (edit == '1') {
                            clients[indexEnteredClient].showPosts2();
                            System.out.println("\u001B[38;2;0;255;0m please type the number of post \u001B[0m");
                            int number = 0;
                            while (true) {
                                try {
                                    number = Integer.parseInt(scanner.nextLine());
                                    break;
                                } catch (Exception e) {
                                }
                            }

                            //برای اعداد دیگه درستش کن
                            Chat[] chat2 = clients[indexEnteredClient].getChats();
                            if (chat2[number] == null) {
                                break;
                            }
                            boolean end = false;
                            StringBuilder result2 = new StringBuilder();
                            System.out.println("\u001B[38;2;255;165;0m to end text type @ in a new line and enter a Enter \u001B[0m");
                            while (true) {
                                String line = scanner.nextLine();
                                if (line.equals("@")) {
                                    break;
                                }
                                result2.append(line);
                                result2.append("\n\t");
                            }

                            if (result2.length() >= 200) {
                                result2 = new StringBuilder(result2.substring(0, 200));
                            }
                            clients[indexEnteredClient].editChat(number, valueOf(result2));
                        } else if (edit == '2') {
                            clients[indexEnteredClient].showPosts2();
                            int number = 0;
                            System.out.println("\u001B[38;2;0;255;0m please type the number of post \u001B[0m");
                            while (true) {

                                try {
                                    number = Integer.parseInt(scanner.nextLine());
                                    break;
                                } catch (Exception e) {
                                }
                            }
                            clients[indexEnteredClient].deletchat(number);
                        } else if (edit == '3')
                            break;
                        break;
                    case "3":
                        return true;
                }

            default:
                break;
        }
        return true;
    }

    private void searchUserName(Scanner scanner) {
        System.out.println("\u001B[38;2;0;255;0m please enter a username\u001B[0m");
        String username = scanner.next();
        Main.cls();
        int indexOfClient = findClient(username);
        if (clients[indexEnteredClient].getUserName().equals(username)) {
            indexOfClient = -1;
        }
        if (indexOfClient != -1) {
            clients[indexOfClient].showinfo2();
            boolean followed = following(username);
            if (followed == true) {
                System.out.println("\u001B[38;2;0;255;0m you are following him/her \u001B[0m");
            }

            boolean exit = false;
            char select3 = '3';
            while (exit == false) {
                System.out.println("\u001B[38;2;0;255;0m(1) follow");
                System.out.println("(2) unfollow");
                System.out.println("(3) posts");
                System.out.println("(4)  previous page \u001B[0m");
                select3 = scanner.next().charAt(0);
                Main.cls();
                if (followed == true && select3 == '1')
                    System.out.println("\u001B[38;2;255;0;0m you have followed \u001B[0m");
                else if (followed == false && select3 == '2')
                    System.out.println(" \u001B[38;2;255;0;0myou havan't followed \u001B[0m");

                else if (select3 >= '1' && select3 <= '4')
                    exit = true;
            }

            switch (select3) {
                case '1':
                    follow(username);
                    break;
                case '2':
                    unfollow(username);
                    break;
                case '3':
                    clients[indexOfClient].showPosts2();
                    System.out.println("\u001B[38;2;0;255;0m(1) send comment");
                    //System.out.println("(2) delete comment");
                    System.out.println("(2) delete comment");
                    System.out.println("(3) like");
                    System.out.println("(4) dislike");
                    System.out.println("(5) Home page \u001B[0m");
                    char comment = scanner.next().charAt(0);
                    Main.cls();
                    if (comment == '1') {
                        clients[indexOfClient].showPosts2();
                        System.out.println(" \u001B[38;2;0;255;0m please input the number of the text \u001B[0m");
                        int select5 = 0;
                        while (true) {
                            try {
                                select5 = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (Exception e) {

                            }
                        }

                        Chat[] chat3 = clients[indexOfClient].getChats();
                        if (chat3[select5] == null) {
                            break;
                        }
                        System.out.println("\u001B[38;2;0;255;0m please enter a comment \u001B[0m");

                        StringBuilder result = new StringBuilder();
                        System.out.println("\u001B[38;2;255;165;0m to end text type @ in a new line and enter a Enter \u001B[0m");
                        while (true) {
                            String line = scanner.nextLine();
                            if (line.equals("@")) {
                                break;
                            }
                            result.append(line);
                            result.append("\n\t");
                        }
                        if (result.length() >= 51) {
                            result = new StringBuilder(result.substring(0, 51));
                        }

                        clients[indexOfClient].addcomment(valueOf(result), select5, clients[indexEnteredClient].getUserName());
                    } else if (comment == '2') {
                        clients[indexOfClient].showPosts2();
                        System.out.println("\u001B[38;2;0;255;0m please enter the number of chat \u001B[0m");
                        int indexchat = 0;
                        while (true) {
                            try {
                                indexchat = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (Exception e) {

                            }
                        }
                        Main.cls();
                        clients[indexOfClient].showPosts2();
                        System.out.println(" \u001B[38;2;0;255;0m please enter the number of comment \u001B[0m");
                        int indexcomment = 0;
                        while (true) {
                            try {
                                indexcomment = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (Exception e) {

                            }
                        }
                        if (deleteCommentPermission(indexOfClient, indexchat, indexcomment) == true) {
                            clients[indexOfClient].deletecomment(indexchat, indexcomment);
                        }
                    } else if (comment == '3') {
                        clients[indexOfClient].showPosts2();
                        System.out.println("\u001B[38;2;0;255;0m please enter the number of chat \u001B[0m");
                        int indexofchat = 0;
                        while (true) {
                            try {
                                indexofchat = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (Exception e) {

                            }
                        }
                        Main.cls();
                        if (likepermission(indexOfClient, indexofchat) == false) {
                            like(indexOfClient, indexofchat);
                        }
                    } else if (comment == '4') {
                        clients[indexOfClient].showPosts2();
                        System.out.println("\u001B[38;2;0;255;0m please enter the number of chat \u001B[0m");
                        int indexofchat = 0;
                        while (true) {
                            try {
                                indexofchat = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (Exception e) {

                            }
                        }
                        Main.cls();
                        if (likepermission(indexOfClient, indexofchat) == true) {
                            dislike(indexOfClient, indexofchat);
                        }
                    } else
                        break;
                    break;
                case '4':
                    break;
                default:
                    break;
            }

        } else
            System.out.println("\u001B[38;2;255;0;0m there isn't any information ... \u001B[0m");
    }

    //this methode show posts from following
    public void showpostsFromfollowing() {
        for (int i = 0; i < 100; i++) {
            if (clients[indexEnteredClient] != null && clients[indexEnteredClient].getFollowing()[i] != null && findClient(clients[indexEnteredClient].getFollowing()[i]) != -1) {
                clients[findClient(clients[indexEnteredClient].getFollowing()[i])].showPosts2();
            }
        }
    }

    //by this methode we can follow other users
    public void follow(String username) {

        clients[indexEnteredClient].setFollowing(username);
        clients[indexEnteredClient].increasingFollowing();
        clients[findClient(username)].setFollowers(clients[indexEnteredClient].getUserName());
        clients[findClient(username)].increasingFollower();
    }

    //by this methode we can unfollow other users
    public void unfollow(String username) {
        clients[indexEnteredClient].setUnfollowing(username);
        clients[indexEnteredClient].decreasingFollowing();
        clients[findClient(username)].setUnfollower(clients[indexEnteredClient].getUserName());
        clients[findClient(username)].decreasingFollower();

    }

    public void writeMessage(String text) {
        int index = indexEnteredClient;
        clients[index].addMessage(new Chat(text));

    }

    //this methode make the shape of main page
    public void shapeOfMainPage() {
        System.out.println("\n" +
                "\t\u001B[38;2;255;255;0m                              \n" +
                "\t  **********************************************    \n " +
                "\t  *                                            *     \n" +
                "\t  *              (1) profile                   *       \n" +
                "\t  *                                            *     \n" +
                "\t  *              (2) search Q                  *        \n" +
                "\t  *                                            *       \n" +
                "\t  *              (3) post                      *       \n" +
                "\t  *                                            *      \n" +
                "\t  *                                            *     \n" +
                "\t  **********************************************  \n\u001B[0m");


    }

    //this methode check following
    public boolean following(String username) {
        String[] ary = clients[indexEnteredClient].getFollowing();
        for (int i = 0; i < 100; i++) {
            if (ary[i] != null && ary[i].equals(username)) {
                return true;
            }
        }
        return false;
    }

    //this methode check delete comment permission
    public boolean deleteCommentPermission(int indexClient, int indexchat, int indexcomment) {

        Chat[] chat3 = new Chat[100];
        chat3 = clients[indexClient].getChats();
        String[] comment2 = new String[0];
        if (chat3[indexchat] != null && chat3[indexchat].getComments() != null) {
            comment2 = chat3[indexchat].getComments();

            if (comment2[indexcomment] != null && comment2[indexcomment].substring(0, clients[indexEnteredClient].getUserName().length()).equals(clients[indexEnteredClient].getUserName())) {
                return true;
            }
        }
        return false;
    }

    //this methode like others
    public void like(int indexofclient, int indexofchat) {
        if (clients[indexofclient].getChats()[indexofchat] != null) {
            clients[indexofclient].getChats()[indexofchat].addlike(clients[indexEnteredClient].getUserName());
        }

    }

    //this methode dislike others
    public void dislike(int indexofclient, int indexofchat) {
        for (int i = 0; i < 100; i++) {
            if (clients[indexofclient].getChats()[indexofchat] != null && clients[indexofclient].getChats()[indexofchat].getLiked()[i] != null && clients[indexofclient].getChats()[indexofchat].getLiked()[i].equals(clients[indexEnteredClient].getUserName())) {
                clients[indexofclient].getChats()[indexofchat].removelike(i);
            }
        }
    }

    //this methode check like permission
    public boolean likepermission(int indexofclient, int indexofchat) {
        for (int i = 0; i < 100; i++) {
            if (clients[indexofclient].getChats()[indexofchat] != null && clients[indexofclient].getChats()[indexofchat].getLiked()[i] != null && clients[indexofclient].getChats()[indexofchat].getLiked()[i].equals(clients[indexEnteredClient].getUserName())) {
                return true;
            }
        }
        return false;
    }

    //this methode make a random code to recognize that user isn't a robot
    public static String generateRandomString(int length) {
        String characters = "A0BCD1EFG3H5IJ7KLMN9OPQR8STU45VW6XYZa7bcdef8ghij9klmno0pqr3st6uvw7xyz0123456789";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            randomString.append(randomChar);
        }

        return randomString.toString();
    }

}
