package com.java.spring_dasar;

public class Database {
    private static Database database;

    public static Database getInstance(){
        if (database ==  null){
            new Database();
        }
        return database;
    }

    private Database(){

    }
}
