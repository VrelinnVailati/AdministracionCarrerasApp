package com.isragomez.AdministracionCarrerasApp.Modelos;

public class Carrera {
    private int id;
    private String nombreCarrera;
    private int duracion;

    public Carrera() { }

    public Carrera(String nombreCarrera, int duracion) {
        setNombreCarrera(nombreCarrera);
        setDuracion(duracion);
    }

    public Carrera(int id, String nombreCarrera, int duracion) {
        setId(id);
        setNombreCarrera(nombreCarrera);
        setDuracion(duracion);
    }

    public Carrera(int id) {
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("idCarrera = ").append(id).append("\n");
        sb.append("nombreCarrera = ").append(nombreCarrera).append("\n");
        sb.append("duracion = ").append(duracion).append("\n");
        return sb.toString();
    }
}
