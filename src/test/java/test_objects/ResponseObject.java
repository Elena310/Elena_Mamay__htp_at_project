package test_objects;


import java.util.List;

public class ResponseObject {
    public final String code;
    public final List<UserObject> data;

    public ResponseObject(String code, List<UserObject> data) {
        this.code = code;
        this.data = data;
    }

    public List<UserObject> getData(){
        return data;
    }

    @Override
    public String toString(){
        return this.code + " " + this.data.stream();
    }
}
