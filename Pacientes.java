package mapas;


import java.util.Scanner;

/**
 * Clase principal que utiliza la clase MapaTriple.
 * 
 * @author Mihaela Corina Ioan 
 * @version  26.04.2016
 */
public class Pacientes
{
    public static void main(){
        Scanner sc=new Scanner(System.in);

        MapaTriple mapa=new MapaTriple();
        String nombre, dni=new String();
        int segsocial=0;
        int opcion,entrada ; 

        System.out.printf("       Introduce una opción.      \n");
        System.out.printf("****************************************\n");
        System.out.printf("1. Introducir datos paciente.\n");
        System.out.printf("2. Elimina paciente.\n");
        System.out.printf("3. Buscar numero de la seguridad social.\n");
        System.out.printf("4. Buscar número dni.\n");
        System.out.printf("5. Buscar dni por nombre.\n");
        System.out.printf("6. Listar pacientes .\n");
        System.out.printf("7. Introduce 0 para salir del programa .\n");
        System.out.printf("****************************************\n");

        opcion=sc.nextInt(); sc.nextLine();
        while(opcion!=0){
            switch(opcion){
                case 1:System.out.printf("Introduce el nombre del paciente:  ");
                nombre=sc.nextLine();      
                System.out.printf("Introduce el dni del paciente:  ");
                dni=sc.nextLine();
                System.out.printf("Introduce el número de la seguridad social:  ");
                segsocial=sc.nextInt(); 
                try {
                    mapa.inserta(dni,segsocial,nombre);
                    System.out.printf("_______________________________________\n");
                    System.out.printf("El paciente se ha dado de alta con exito. \n"); 
                    System.out.printf("_______________________________________\n");break;
                } catch (YaExiste e) {

                    e.printStackTrace();

                }

                case 2: System.out.printf("Introduce el dni del paciente:\n");
                        dni=sc.nextLine();
                        System.out.printf("Introduce el número de la seguridad social:\n");
                        segsocial=sc.nextInt(); 
                try {                                               
                    
                    mapa.elimina(dni,segsocial);
                    System.out.printf("_______________________________________\n");
                    System.out.printf("El  paciente se ha eliminado con exito.\n"); 
                    System.out.printf("_______________________________________\n");break;

                } catch (NoExiste e) {

                    e.printStackTrace();

                }   
           
                case 3: System.out.printf("Introduce el dni: ");
                        dni=sc.nextLine();
                try {
                    System.out.printf("____________________________________________________________\n");
                    System.out.printf("El número de la seguridad social es: %s \n",mapa.segsocial(dni));
                    System.out.printf("___________________________________________________________\n");break;

                } catch (NoExiste e) {

                    e.printStackTrace();

                }
                case 4: System.out.printf("Introduce el número de la seguridad social:  \n");
                        segsocial=sc.nextInt(); sc.nextLine();
                try {
                    System.out.printf("__________________________________________________\n");
                    System.out.printf("El número del dni es: %s  \n",mapa.dni(segsocial));
                    System.out.printf("__________________________________________________\n");break;
                    

                } catch (NoExiste e) {

                    e.printStackTrace();

                }
                case 5: System.out.printf("Introduce el nombre: ");
                        nombre=sc.nextLine();
                try {
                    System.out.printf("______________________________________________\n");
                    System.out.printf("El número de dni es: %s \n ",mapa.dni(nombre));
                    System.out.printf("______________________________________________\n");break;

                } catch (NoExiste e) {

                    e.printStackTrace();

                }
                case 6:  mapa.muestra();break;
                case 0: System.out.printf("Fin programa."); break;
                default: System.out.printf("No es una opción corecta\n");
            }
            System.out.printf("****************************************\n");
            System.out.printf("Introduce una opción.\n");
            System.out.printf("****************************************\n");
            System.out.printf("1. Introducir datos paciente.\n");
            System.out.printf("2. Elimina paciente.\n");
            System.out.printf("3. Buscar numero seguridad social.\n");
            System.out.printf("4. Buscar dni.\n");
            System.out.printf("5. Buscar dni por nombre.\n");
            System.out.printf("6. Listar pacientes .\n");
            System.out.printf("7. Introduce 0 para salir del programa .\n");
            System.out.printf("****************************************\n");
            opcion=sc.nextInt();sc.nextLine();
        }

    }
}
