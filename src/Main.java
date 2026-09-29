import org.generation.agenda.exceptions.InvalidData;
import org.generation.agenda.models.Contactos;
import org.generation.agenda.models.Agenda;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidData {
        //Creando un array list
        ArrayList<Contactos> contactos = new ArrayList<>();
        Integer option = 0;

        contactos.add(new Agenda("Andres", "Carrizosa", 55896352));
        contactos.add(new Agenda("Luis", "Perez", 55896352));
        contactos.add(new Agenda("Angel", "Coria", 55896352));
        Scanner scan = new Scanner(System.in);



        try {
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


        }catch (Exception e){
            System.out.println("Problemas al crear contacto " + e.getMessage());
        }
        scan.close();

    }
}