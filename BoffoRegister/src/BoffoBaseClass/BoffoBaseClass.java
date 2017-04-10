package BoffoBaseClass;
/*
author Ray Cockerham
*/

public abstract class BoffoBaseClass{

    protected void print(){
         //sends necessary data to utility class
    }
   
    protected boolean save(/*arguments*/){
        //create DbEntry();
        return true;
    }
    
    //gets data from database
    //protected abstract something LoadData();
    
    protected void newEvent(String message){
        //make an event
    }
    
    protected void loadThisPanel(){
        
    }
}