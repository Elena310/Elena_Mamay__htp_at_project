package test_objects;

import java.util.Objects;

public class UserObject {

    public final int id;
    public final String username;
    public final String realname;
    public final String password;

    public int getId() {
        return id;
    }

    public final String email;

    public UserObject(int id, String username, String realname, String password, String email){
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return this.id + " " + this.username + " " + this.realname + " " + this.password + " " + this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserObject that = (UserObject) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(realname, that.realname) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, realname, password, email);
    }
}
