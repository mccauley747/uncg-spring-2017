package database;

//import com.sun.xml.internal.bind.v2.model.core.ID;
import java.util.UUID;

public class BoffoDbObject {

    protected String ID;
    protected UUID UUID;
    protected boolean active;

    public BoffoDbObject(){

    }
    /**
     *
     */
    public void load(String name){

    }

    /**
     *
     */
    public void save(){

    }

    /**
     *
     */
    public void add(){

    }

    /**
     *
     */
    public void update(){

    }

    /**
     *
     */
    public boolean delete(){
        return active;
    }

    /**
     *
     */
     String create(){
        //create an entry

        //return the UUID
        UUID uuid = UUID.randomUUID();
        String randomUUID = uuid.toString();
        return randomUUID;
    }
}
