package database;

import java.util.UUID;

public class BoffoDbObject {

    protected String ID;
    protected UUID UUID;
    protected boolean active;

    public BoffoDbObject(){

    }

    public void load(String name){

    }

    public void save(){

    }

    public void add(){

    }

    public void update(){

    }

    public boolean delete(){
        return active;
    }

    public String create(){
        //create an entry

        //return the UUID
        return UUID.randomUUID().toString();
    }
}
