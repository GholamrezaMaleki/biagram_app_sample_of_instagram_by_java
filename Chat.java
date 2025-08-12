public class Chat {
    private String text;
    private int numberoflikes;
    private String[] liked;
    private String[] comments;

    public int getNumberoflikes() {
        return numberoflikes;
    }

    public Chat(String text) {
        this.text = text;
        this.numberoflikes = 0;
        comments = new String[100];
        liked = new String[100];
    }

    public String[] getLiked() {
        return liked;
    }

    public void setLiked(String[] liked) {
        this.liked = liked;
    }

    public void setNumberoflikes(int numberoflikes) {
        this.numberoflikes = numberoflikes;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void increaselike() {
        numberoflikes++;
    }

    public void decreaselike() {
        numberoflikes--;
    }

    public void addcommet(String comment, String username) {
        for (int i = 0; i < 100; i++) {
            if (comments[i] == null) {
                comments[i] = username + ")  " + i + "_" + comment;
                break;
            }
        }
    }

    public void deleteComment(int indexComment) {

        comments[indexComment] = null;
    }

    public void addlike(String username) {
        for (int i = 0; i < 100; i++) {
            if (liked[i] == null) {
                liked[i] = username;
                increaselike();
                break;
            }
        }
    }

    public void removelike(int index) {
        liked[index] = null;
        decreaselike();
    }


}
