package TradeTurnover;

import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class Person {  // Абстрактный класс для персонала компании
    private String name;
    private String id;

    public Person(){
        this.name = name;
        this.id = id;
    }

    public Person(String name, String id){
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}

