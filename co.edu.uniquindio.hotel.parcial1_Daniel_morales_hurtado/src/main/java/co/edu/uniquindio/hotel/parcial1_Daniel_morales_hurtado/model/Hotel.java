package co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.model;

import co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.services.IClientesCrud;
import co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.services.IConsultaServices;
import co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.services.IHabitacionCrud;

import java.util.List;

public class Hotel implements IClientesCrud, IHabitacionCrud, IConsultaServices {
    private List<Cliente> listaClientes;
    private List<Habitacion> listaHabitaciones;

    public Hotel() {
    }

    public List<Habitacion> getListaHabitaciones() {
        return this.listaHabitaciones;
    }
    public List<Cliente> getListaClientes() {
        return this.listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    public void setListaHabitaciones(List<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    @Override
    public boolean crearHabitacion(String numero, String tipo, int precio) {
        Habitacion habitacionExistente = obtenerHabitacion(numero);
        if (habitacionExistente == null) {
            Habitacion habitacion = new Habitacion();
            habitacion.setNumero(numero);
            habitacion.setTipo(tipo);
            habitacion.setPrecio(precio);
            listaHabitaciones.add(habitacion);
            return true;
        }else{
            return false;
        }
    }
    public Habitacion obtenerHabitacion(String numero){
        Habitacion habitacionExistente = null;
        for (Habitacion habitacion : getListaHabitaciones()) {
            if(habitacion.getNumero().equals(numero)){
                habitacionExistente = habitacion ;
                break;
            }
        }
        return habitacionExistente;
    }
    @Override
    public String obtenerDatosHabitacion(String numero) {
        Habitacion habitacionExistente = obtenerHabitacion(numero);
        if (habitacionExistente != null) {
            return habitacionExistente.toString();
        }
        return "";
    }
    @Override
    public boolean actualizarHabitacion(String numero,String tipoNuevo, int precio) {
        Habitacion habitacionExistente = obtenerHabitacion(numero);
        if (habitacionExistente == null) {
            habitacionExistente.setNumero(numero);
            habitacionExistente.setTipo(tipoNuevo);
            habitacionExistente.setPrecio(precio);
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean eliminarHabitacion(String numero) {
        Habitacion habitacionExistente = obtenerHabitacion(numero);
        if (habitacionExistente != null){
            getListaHabitaciones().remove(habitacionExistente);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean crearCliente(String nombre, String Dni, int numeroHabitacion) {
        Cliente clienteExistente = obtenerCliente(Dni);
        if (clienteExistente == null) {
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setDni(Dni);
            cliente.setNumeroHabitacion(numeroHabitacion);
            listaClientes.add(cliente);
            return true;
        }else{
            return false;
        }
    }
    public Cliente obtenerCliente(String Dni){
        Cliente clienteExstente = null;
        for (Cliente cliente : getListaClientes()) {
            if (cliente.getDni().equals(Dni)) {
                clienteExstente = cliente;
                break;
            }
        }
        return clienteExstente;
    }
    public String obtenerDatosCliente(String Dni){
        Cliente clienteExstente = obtenerCliente(Dni);
        if (clienteExstente != null) {
            return clienteExstente.toString();
        }
        return "";
    }
    @Override
    public boolean actualizarCliente(String nombre,String Dni, String DniNuevo, int numeroHabitacion) {
        Cliente clienteExistente = obtenerCliente(Dni);
        if (clienteExistente == null) {
            clienteExistente.setNombre(nombre);
            clienteExistente.setDni(DniNuevo);
            clienteExistente.setNumeroHabitacion(numeroHabitacion);
            return true;
        }else{
            return false;
        }
    }
    public boolean eliminarCliente(String Dni){
        Cliente clienteExstente = obtenerCliente(Dni);
        if (clienteExstente != null) {
            getListaClientes().remove(clienteExstente);
            return true;
        }else{
            return false;
        }
    }

    public int cantidadDineroHabitaciones(){
        int sumatotal = 0;
        for (Habitacion habitacion : getListaHabitaciones()) {
            sumatotal += habitacion.getPrecio();
        }
        return sumatotal;
    }
}

