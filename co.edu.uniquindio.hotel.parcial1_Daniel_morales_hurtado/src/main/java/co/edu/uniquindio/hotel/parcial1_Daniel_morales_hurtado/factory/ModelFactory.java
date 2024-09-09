package co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.factory;

import co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.builder.ClienteBuilder;
import co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.builder.HabitacionBuilder;
import co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.model.Cliente;
import co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.model.Habitacion;
import co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.model.Hotel;
import co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.services.IClientesCrud;
import co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.services.IConsultaServices;
import co.edu.uniquindio.hotel.parcial1_Daniel_morales_hurtado.services.IHabitacionCrud;

import java.util.ArrayList;

public class ModelFactory implements IClientesCrud, IHabitacionCrud, IConsultaServices {

    private static ModelFactory modelFactory;
    private static Hotel hotel;

    private ModelFactory() {
        inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private void inicializarDatos() {
        hotel = new Hotel();
        Habitacion habitacion1 = new HabitacionBuilder()
                .setNumero("101")
                .setTipo("Simple")
                .setPrecio(60000)
                .build();
        Habitacion habitacion2 = new HabitacionBuilder()
                .setNumero("102")
                .setTipo("Doble")
                .setPrecio(90000)
                .build();
        Habitacion habitacion3 = new HabitacionBuilder()
                .setNumero("103")
                .setTipo("Suit")
                .setPrecio(120000)
                .build();
        Cliente cliente1 = new ClienteBuilder()
                .setDni("123456789")
                .setNombre("Daniel Morales")
                .setNumeroHabitacion(101)
                .build();
        Cliente cliente2 = new ClienteBuilder()
                .setDni("12348525")
                .setNombre("Alfredo")
                .setNumeroHabitacion(102)
                .build();
        Cliente cliente3 = new ClienteBuilder()
                .setDni("526456789")
                .setNombre("Miguel")
                .setNumeroHabitacion(103)
                .build();
        hotel.setListaClientes(new ArrayList<>());
        hotel.setListaHabitaciones(new ArrayList<>());
        hotel.getListaClientes().add(cliente1);
        hotel.getListaClientes().add(cliente2);
        hotel.getListaClientes().add(cliente3);
        hotel.getListaHabitaciones().add(habitacion1);
        hotel.getListaHabitaciones().add(habitacion2);
        hotel.getListaHabitaciones().add(habitacion3);
    }

    @Override
    public boolean crearHabitacion(String numero, String tipo, int precio) {
        return hotel.crearHabitacion(numero, tipo, precio);
    }

    @Override
    public String obtenerDatosHabitacion(String numero) {
        return hotel.obtenerDatosHabitacion(numero);
    }

    public String obtenerHabitacion(String numero){
        return hotel.obtenerDatosHabitacion(numero);
    }

    @Override
    public boolean actualizarHabitacion(String numero, String tipoNuevo, int precio) {
        return hotel.actualizarHabitacion(numero, tipoNuevo, precio);
    }

    @Override
    public boolean eliminarHabitacion(String numero) {
        return hotel.eliminarHabitacion(numero);
    }

    @Override
    public boolean crearCliente(String nombre, String dni, int numeroHabitacion) {
        return hotel.crearCliente(nombre, dni, numeroHabitacion);
    }

    @Override
    public String obtenerDatosCliente(String dni) {
        return hotel.obtenerDatosCliente(dni);
    }

    public String obtenerCliente(String Dni){
        return hotel.obtenerDatosCliente(Dni);
    }

    @Override
    public boolean actualizarCliente(String nombre, String dni, String dniNuevo, int numeroHabitacion) {
        return hotel.actualizarCliente(nombre, dni, dniNuevo, numeroHabitacion);
    }

    @Override
    public boolean eliminarCliente(String dni) {
        return hotel.eliminarCliente(dni);
    }

    public int cantidadDineroHabitaciones(){
        return hotel.cantidadDineroHabitaciones();
    }
}
