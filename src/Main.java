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
            do {
                //monstremos un menu y que el usuario pueda elegir entre opcion 1 al 7.
                System.out.println("Elija la opcion que desea realizar...");
                System.out.println("1. Consultar lista de contactos."); //listarContactos()
                System.out.println("2. Buscar contacto"); //buscarContacto(String nombre)
                System.out.println("3. Existencia de contacto"); //existeContacto()
                System.out.println("4. Eliminar contacto"); //eliminarContacto()
                System.out.println("5. Añadir contacto"); //anadirContacto()
                System.out.println("6. Espacio Libre"); //espacioLibre()
                System.out.println("7. Estado de agenda"); //agendaLlena()
                System.out.println("8. Salir");
                System.out.println("Elija la opción que le convenga, escriba el numero....");

                option = scan.nextInt(); //pedimos datos asignando lo que se pida con instancia scanner

                switch (option) {
                    case 1:
                        System.out.println("Ha elegido consultar lista de contactos" );
                        System.out.println("procesando...");
                        for (Contactos agenda: contactos){
                            agenda.showDetails();
                            System.out.println("-----------------------------------");
                        }
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
                        break;
                    case 2:
                        System.out.println("Ha elegido buscar contacto: ");
                        System.out.println("Ingrese el nombre del contacto:");
                        String nom = scan.next();

                        for (Contactos agen : contactos) {
                            // Usamos .equals() y accedemos al nombre del objeto
                            if (agen.getNombre().equals(nom)) {
                                System.out.println("¡Contacto encontrado!");
                                agen.showDetails(); // O muestra los datos que necesites
                            }
                        }
                        System.out.println("-----------------------------------");
                        break;
                    case 3:
                        System.out.println("Ha elegido existencia de contacto : " );
                        Agenda.existeContacto(contactos);
                        System.out.println("-----------------------------------");
                        break;
                    case 4:
                        System.out.println("Ha elegido eliminar contacto: " );
                        contactos = Agenda.eliminarContacto(contactos);
                        System.out.println("-----------------------------------");
                        break;
                    case 5:
                        System.out.println("Ha elegido añadir contacto: " );
                        contactos = Agenda.guardarContacto(contactos);// Actualiza y guarda la lista
                        break;
                    case 6:
                        System.out.println("Ha elegido ver el espacio de agenda: " );
                        Agenda.espacioLibre(contactos);
                        System.out.println("-----------------------------------");
                        break;
                    case 7:
                        System.out.println("Ha elegido ver el estado de la agenda: " );
                        Agenda.agendaLlena(contactos);
                        System.out.println("-----------------------------------");
                        break;

                    default:
                        System.out.println("Fuera de rango...");
                        break;
                }

            }while(option !=8);


        }catch (Exception e){
            System.out.println("Problemas al crear contacto " + e.getMessage());
        }
        scan.close();

    }
}