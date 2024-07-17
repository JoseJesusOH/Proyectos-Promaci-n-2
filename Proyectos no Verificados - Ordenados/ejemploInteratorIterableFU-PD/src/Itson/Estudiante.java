/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itson;

import java.util.Objects;

/**
 *
 * @author josej
 */
public class Estudiante {
    private String nombre;
    private String curp;
    private String  correo;
    private int id;
    private int celular;

    public Estudiante(String nombre, String curp, String correo, int id, int celular) {
        this.nombre = nombre;
        this.curp = curp;
        this.correo = correo;
        this.id = id;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.curp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (!Objects.equals(this.curp, other.curp)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", curp=" + curp + ", correo=" + correo + ", id=" + id + ", celular=" + celular + '}';
    }
   
    
    
}
