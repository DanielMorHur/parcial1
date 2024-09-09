package co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public String nombre;
    public String Dni;
    public int numeroHabitacion;
    public String email;
    public List<Cliente> listaClientes = new ArrayList();
    public Cliente(String nombre, String Dni, int numeroHabitacion) {
        this.nombre = nombre;
        this.Dni = Dni;
        this.numeroHabitacion = numeroHabitacion;
    }

    public Cliente() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public List<Cliente> getListaClientes() {
        return this.listaClientes;
    }

    public void setClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;

    }

    public String toString() {
        return "Nombre= " + nombre +
                " Dni= " + Dni +
                " NumeroHabitacion= " + numeroHabitacion;
    }
}