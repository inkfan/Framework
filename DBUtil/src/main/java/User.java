public class User {
    @Column(value = "USERID")
    private int uid;
    @Column(value = "UNAME")
    private String name;

    public User() {
    }

    public User( int uid ,String name ) {
        this.uid = uid;
        this.name = name;
    }

    public int getUid() {
        return uid;
    }

    public void setUid( int uid ) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
}
