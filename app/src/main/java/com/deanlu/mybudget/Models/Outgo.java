package com.deanlu.mybudget.Models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Deimer on 17/06/2015.
 * ----------------------------------------------------
 * Clase modelo del objeto gasto con su nombre en ingles Outgo.
 * Esta clase usa la libreria ORMLite para manejar la relacion
 * de la clase Outgo(gasto) con la tabla outgoings en la base de datos
 * Cualquier atributo o propiedad del objeto entry, debe ser agregado
 * aqui para que este se agregue en la base de datos.
 */
@DatabaseTable(tableName = "outgoings")
public class Outgo {

    @DatabaseField(generatedId = true)
    private int id;//LLave primaria

    @DatabaseField(index = true, canBeNull = false)
    private int user_id;
    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField(canBeNull = false)
    private int amount;

    //Constructor vacio para el reflejo del modelo en la api ORMLite
    public Outgo(){}

    //Constructor vacio para el reflejo del modelo en la api ORMLite
    public Outgo(int userID, String Name, int Amount){
        this.user_id = userID;
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
    public void setName(String name) {
        this.name = name;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

}
