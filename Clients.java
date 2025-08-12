public class Clients {
    private String userName;
    private String password;
    private String name;
    private String bio;
    private Chat[] chats;
    private String recoveryCode;
    private String recoveryHelp;

    public String getRecoveryCode() {
        return recoveryCode;
    }

    public void setRecoveryCode(String recoveryCode) {
        this.recoveryCode = recoveryCode;
    }

    public String getRecoveryHelp() {
        return recoveryHelp;
    }

    public void setRecoveryHelp(String recoveryHelp) {
        this.recoveryHelp = recoveryHelp;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setFollowers(String[] followers) {
        this.followers = followers;
    }

    public void setFollowing(String[] following) {
        this.following = following;
    }

    private int numberofchats;
    private int numberOfFollowers;
    private int numberOfFollowing;
    private String[] followers;
    private String[] following;

    public String[] getFollowers() {
        return followers;
    }

    public void setFollowers(String username) {
        for (int i = 0; i < 100; i++) {
            if (followers[i] == null) {
                followers[i] = username;
                break;
            }
        }
    }

    public String[] getFollowing() {
        return following;
    }

    public void setFollowing(String userName) {
        for (int i = 0; i < 100; i++) {
            if (following[i] == null) {
                following[i] = userName;
                break;
            }
        }
    }

    public void setUnfollowing(String username) {
        for (int i = 0; i < 100; i++) {
            if (following[i] != null && following[i].equals(username)) {
                following[i] = null;
                break;
            }
        }
    }

    public void setUnfollower(String username) {
        for (int i = 0; i < 100; i++) {
            if (followers[i] != null && followers[i].equals(username)) {
                followers[i] = null;
                break;
            }
        }

    }

    public Chat[] getChats() {
        return chats;
    }

    public double getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public void setNumberOfFollowers(int numberOfFollowers) {
        this.numberOfFollowers = numberOfFollowers;
    }

    public double getNumberOfFollowing() {
        return numberOfFollowing;
    }

    public void setNumberOfFollowing(int numberOfFollowing) {
        numberOfFollowing = numberOfFollowing;
    }

    public void setChats(Chat[] chats) {
        this.chats = chats;
    }

    public double getNumberofchats() {
        return numberofchats;
    }

    public void setNumberofchats(int numberofchats) {
        this.numberofchats = numberofchats;
    }

    public Clients(String name, String userName, String password, String recoveryCode, String recoveryHelp) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        chats = new Chat[100];
        numberOfFollowers = 0;
        numberOfFollowing = 0;
        followers = new String[100];
        following = new String[100];
        bio = "";
        this.recoveryCode = recoveryCode;
        this.recoveryHelp = recoveryHelp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increasingFollowing() {
        numberOfFollowing = numberOfFollowing + 1;
    }

    public void decreasingFollowing() {
        numberOfFollowing = numberOfFollowing - 1;
    }

    public void increasingFollower() {
        numberOfFollowers = numberOfFollowers + 1;
    }

    public void decreasingFollower() {
        numberOfFollowers = numberOfFollowers - 1;
    }

    public void addMessage(Chat chat) {
        for (int i = 0; i < 100; i++) {
            if (chats[i] == null) {
                chats[i] = chat;
                break;
            }
        }


    }

    @Override
    public String toString() {
        return "Clients{" +
                "userName='" + userName + '\'' +
                ", bio'" + bio + '\'' +
                ", name='" + name + '\'' +
                ", numberOfFollowers=" + numberOfFollowers +
                ", numberOfFollowing=" + numberOfFollowing +
                '}';
    }

    public void showIfo() {
        System.out.println("\u001B[38;2;255;255;0m\t\t\t\t\t\t\t\t " + userName + "\u001B[0m");
        System.out.println("\u001B[38;2;255;165;0m\t\t\t\t\t\t\t\tbio:  " + bio);
        System.out.println("\t\t\t\t\t\t\t\tname: " + name);
        System.out.println("\t\t\t\t\t\t\t\tNumber Of Followers :" + numberOfFollowers);
        System.out.println("\t\t\t\t\t\t\t\tNumber Of Following :" + numberOfFollowing + "\u001B[0m");
        System.out.println("\n");
    }

    public void showinfo2() {
        System.out.println("\u001B[38;2;255;255;0m\t\t\t\t\t\t\t\t" + userName + "\u001B[0m");
        System.out.println("\u001B[38;2;255;165;0m\t\t\t\t\t\t\t\tbio:  " + bio);
        System.out.println("\t\t\t\t\t\t\t\tNumber Of Followers :" + numberOfFollowers);
        System.out.println("\t\t\t\t\t\t\t\tNumber Of Following :" + numberOfFollowing + "\u001B[0m");


    }

    //this methode show followers and following
    public String showFollwerAndFollwing() {
        String followings = "";
        String follower = "";
        for (int i = 0; i < 100; i++) {
            if (following[i] != null) {
                followings = followings + following[i];
            }
            if (followers[i] != null) {
                follower = follower + followers[i];
            }
        }
        return "\u001B[38;2;255;255;0m\nfollowers: " + follower + "\n follwings: " + followings + "\u001B[0m";
    }

    public String showPosts() {
        String post = "";
        for (int i = 0; i < 100; i++) {
            if (chats[i] != null) {
                String text = chats[i].getText();
                post = post + "\n" + i + "_" + text;
            }
        }
        return post;
    }

    public void showPosts2() {
        System.out.println("\n\n\n");
        for (int i = 0; i < 100; i++) {
            if (chats[i] != null) {
                System.out.println(i + "_" + chats[i].getText());
                String[] comment = chats[i].getComments();
                System.out.println("liked: " + chats[i].getNumberoflikes());
                System.out.println("\u001B[33mComments:\n\n\u001B[0m");
                for (int j = 0; j < 100; j++) {
                    if (comment[j] != null) {
                        System.out.println(comment[j]);
                    }
                }

            }
        }
    }


    public void editChat(int index, String newtext) {
        if (chats[index] != null) {
            chats[index].setText(newtext);
        }
    }

    public void deletchat(int index) {
        chats[index] = null;
    }

    public void addcomment(String comment, int indexchat, String username) {
        chats[indexchat].addcommet(comment, username);
    }

    public void like(int indexchat) {
        chats[indexchat].increaselike();
    }

    public void unlike(int indexchat) {
        chats[indexchat].decreaselike();
    }

    public void setFollowing2(int index, String newusername) {
        following[index] = newusername;
    }

    public void setFollower2(int index, String newusername) {
        followers[index] = newusername;
    }

    public void deletecomment(int indexchat, int indexcomment) {
        chats[indexchat].deleteComment(indexcomment);

    }

}
