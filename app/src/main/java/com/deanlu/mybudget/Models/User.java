package com.deanlu.mybudget.Models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

/**
 * Created by Deimer on 17/06/2015.
 * ----------------------------------------------------
 * Clase modelo del objeto usuario con su nombre en ingles User.
 * Esta clase usa la libreria ORMLite para manejar la relacion
 * de la clase User(usuario) con la tabla users en la base de datos
 * Cualquier atributo o propiedad del objeto user, debe ser agregado
 * aqui para que este se agregue en la base de datos.
 */
@DatabaseTable(tableName = "users")
public class User {

    @DatabaseField(generatedId = true)
    private int id;//LLave primaria

    @DatabaseField(canBeNull = false)
    private String first_name;
    @DatabaseField(canBeNull = false)
    private String last_name;
    @DatabaseField(index = true, canBeNull = false)
    private String email;
    @DatabaseField(canBeNull = false)
    private Date birthdate;
    @DatabaseField(canBeNull = false)
    private String gender;
    @DatabaseField(canBeNull = false)
    private String password;
    @DatabaseField(index = true, canBeNull = false)
    private String username;

    //Constructor vacio para el reflejo del modelo en la api ORMLite
    public User(){}

    public User(String firstName,String lastName, String Email, Date birthDate, String Gender, String Password, String UserName){
        this.setFirst_name(firstName);
        this.setLast_name(lastName);
        this.setEmail(Email);
        this.setBirthdate(birthDate);
        this.setGender(Gender);
        this.setPassword(Password);
        this.setUsername(UserName);
    }

    //Getters del objeto
    public int getId() {
        return id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getEmail() {
        return email;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public String getGender() {
        return gender;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }

    //Setters del objeto
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
