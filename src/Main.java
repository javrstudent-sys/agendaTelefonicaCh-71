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



        }catch (Exception e){
            System.out.println("Problemas al crear contacto " + e.getMessage());
        }
        scan.close();

    }
}