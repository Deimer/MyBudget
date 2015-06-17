package com.deanlu.mybudget.Models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Deimer on 17/06/2015.
 * ----------------------------------------------------
 * Clase modelo del objeto ingreso con su nombre en ingles Entry.
 * Esta clase usa la libreria ORMLite para manejar la relacion
 * de la clase Entry(ingreso) con la tabla entries en la base de datos
 * Cualquier atributo o propiedad del objeto entry, debe ser agregado
 * aqui para que este se agregue en la base de datos.
 */
@DatabaseTable(tableName = "entries")
public class Entry {

    @DatabaseField(generatedId = true)
    private int id;//LLave primaria

    @DatabaseField(index = true, canBeNull = false)
    private int user_id;
    @DatabaseField(canBeNull = false)
    private String period;
    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField(canBeNull = false)
    private int amount;

    //Constructor vacio para el reflejo del modelo en la api ORMLite
    public Entry(){}

    //Constructor vacio para el reflejo del modelo en la api ORMLite
    public Entry(int userID, String Period, String Name, int Amount){
        this.user_id = userID;
        this.period = Period;
        this.name = Name;
        this.amount = Amount;
    }

    //Getters del objeto
    public int getId() {
        return id;
    }
    public int getUser_id() {
        return user_id;
    }
    public String getPeriod() {
        return period;
    }
    public String getName() {
        return name;
    }
    public int getAmount() {
        return amount;
    }

    //Setters del objeto
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setPeriod(String period) {
        this.period = period;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
