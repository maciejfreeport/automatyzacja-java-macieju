package wordpress.domain;

import java.util.UUID;

public class User {
    private String comment;
    private String userName;
    private String userEmail;

    public static User RandomCommentEntry() {
        User user = new User();

        user.userName = "Tester " + UUID.randomUUID().toString();
        user.userEmail = UUID.randomUUID().toString() + "@test.com";
        user.comment = "Super test " + UUID.randomUUID().toString();
        return user;
    }

    public String getComment() {
        return this.comment;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

}
