/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.testFiles;

import database.BoffoDbObject;

/**
 *
 * @author thienle
 */
public class Beef extends BoffoDbObject{
    private String value;
    private String field;
    private String tableName = "Beeeef";
    
    public Beef(String _field, String _value){
        this.field = _field;
        this.value = _value;                
    }
    
    public Beef(){
        
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField(String field) {
        this.field = field;
    }
    
    public static void main(String[] args) {
        BoffoDbObject x = BoffoDbObject.create();
        System.out.println("UUID: " + x.getUuid());
        BoffoDbObject y = x.insert("ahaha", "dasdas");
    }

    /**
     * @return the tableName
     */
    public String getTableName() {
        return tableName;
    }
}
