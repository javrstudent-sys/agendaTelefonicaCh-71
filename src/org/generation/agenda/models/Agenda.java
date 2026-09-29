package org.generation.agenda.models;
import org.generation.agenda.exceptions.InvalidData;
import org.generation.agenda.models.Contactos;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda extends Contactos{
    // Capacidad máxima fija de la agenda
    public static final int MAX_CAPACIDAD = 20;

    public Agenda(String nombre, String apellido, Integer numero) throws InvalidData {
        super(nombre, apellido, numero);
    }

    @Override
    public void showDetails() {
        System.out.println("----- Detalles de los contactos -----");
        System.out.println("Nombre " + this.getNombre());
        System.out.println("Apellido " + this.getApellido());
        System.out.println("Numero " + this.getNumero());
    }
    //metodo para delimitar el tamaño
    public static void espacioLibre(ArrayList<Contactos> contactos) {
        int disponibles = MAX_CAPACIDAD - contactos.size();
        System.out.println("Contactos guardados: " + contactos.size());
        System.out.println("Capacidad máxima: " + MAX_CAPACIDAD);
        System.out.println("Espacio libre disponible: " + disponibles + " contacto(s).");
    }

    //Metodo para Verificar si la agenda está llena o cuánto le falta
    public static void agendaLlena(ArrayList<Contactos> contactos) {
        if (contactos.size() >= MAX_CAPACIDAD) {
            System.out.println("El estado de la agenda es: LLENA.");
        } else {
            System.out.println("El estado de la agenda es: DISPONIBLE.");
            System.out.println("Aún puedes agregar " + (MAX_CAPACIDAD - contactos.size()) + " contacto(s).");
        }
    }
    // Método estático para poder invocarlo directamente como Agenda.guardarContacto(...)
    public static ArrayList<Contactos> guardarContacto(ArrayList<Contactos> contactos) {
        Scanner scan = new Scanner(System.in);
        if (contactos.size() >= MAX_CAPACIDAD) {
            System.out.println("Error: La agenda está llena (" + MAX_CAPACIDAD + " contactos max). No se pueden agregar más.");
            return contactos;
        }
        System.out.println("Ingrese el nombre: ");
        String nomb = scan.next();

        System.out.println("Ingrese el apellido: ");
        String ape = scan.next();

        System.out.println("Ingrese el número: ");
        Integer num = scan.nextInt();

        try {
            contactos.add(new Agenda(nomb, ape, num));
            System.out.println("¡Contacto agregado con éxito!");
            System.out.println("Nombre: "+nomb);
            System.out.println("Apellido: "+ape);
            System.out.println("Numero: "+ num);
        } catch (InvalidData e) {
            System.out.println("Error al validar los datos: " + e.getMessage());
        }

        return contactos;
    }

    //metodo para veridicar si existe contacto
    public static ArrayList<Contactos> existeContacto(ArrayList<Contactos> contactos) {
        // 1. Validar primero si la agenda está vacía
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return contactos;
        }

        System.out.println("BUSCAR PERSONA------->");
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el nombre: ");
        String nomb = scan.next();

        System.out.println("Ingrese el apellido: ");
        String ape = scan.next();

        boolean encontrado = false;

        // 2. Recorrer y comparar nombre y apellido
        for (Contactos contacto : contactos) {
            boolean mismoNombre = contacto.getNombre().equalsIgnoreCase(nomb);
            boolean mismoApellido = contacto.getApellido().equalsIgnoreCase(ape);

            if (mismoNombre && mismoApellido) {
                System.out.println("¡El contacto existe en la agenda!");
                contacto.showDetails();
                encontrado = true;
                break; // Detener la búsqueda al encontrarlo
            }
        }

        if (!encontrado) {
            System.out.println("El contacto " + nomb + " " + ape + " NO existe en la agenda.");
        }

        return contactos; // 3. Retornar la lista completa
    }

    public static ArrayList<Contactos> eliminarContacto(ArrayList<Contactos> contactos) {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía, no hay contactos para eliminar.");
            return contactos;
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el nombre del contacto a eliminar: ");
        String nomb = scan.next();

        System.out.println("Ingrese el apellido del contacto a eliminar: ");
        String ape = scan.next();

        // removeIf elimina los elementos que cumplan la condición y devuelve true si borró algo
        boolean eliminado = contactos.removeIf(c ->
                c.getNombre().equalsIgnoreCase(nomb) && c.getApellido().equalsIgnoreCase(ape)
        );

        if (eliminado) {
            System.out.println("¡Contacto " + nomb + " " + ape + " eliminado con éxito!");
        } else {
            System.out.println("No se encontró ningún contacto con ese nombre y apellido.");
        }

        return contactos;
    }
}