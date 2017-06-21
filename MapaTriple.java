package mapas; 

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;


/**
 * Clase que encapsula una base de datos  que contiene parejas de elementos que representan nombres, numeros dni y numeros de la seguridad social .
 * 
 * @author Mihaela Corina Ioan
 * @version 26.04.2016
 */
public class MapaTriple 
{

    private Map<String, String> mapa1;
    private Map<String, Integer> mapa2;
    private Map<Integer, String> mapa3;

    /**Constructor por defecto. Asigna uno valor por defecto al objeto de tipo mapa en formato de coleciones de datos. 
     * 
     */
    public MapaTriple()
    {
        mapa1 = new HashMap<String, String>();
        mapa2 = new HashMap<String, Integer>();
        mapa3 = new HashMap<Integer, String>();

    }

    /**Metodo que inserta en el objeto almacenado el elemento correspondiente a los valores recibidos por parametro.
  * @param dni -  valor para el dni.
  * @param segsocial - valor para el numero de la seguridad social
  * @param nombre - valor para el nombre 
  */
    public void  inserta(String dni, int segsocial, String nombre) throws YaExiste
    {
        Integer seg= new Integer(segsocial);
        if(mapa1.containsKey(dni)){

            throw new YaExiste(" Ya existe un paciente con este numero del dni");
        }  

        if(mapa3.containsKey(seg)){

            throw new YaExiste(" Ya existe un paciente con este numero de seguridad social");
        }
        mapa1.put(dni,nombre);
        mapa2.put(dni,seg);
        mapa3.put(segsocial,nombre);               
        
    }

   /**Metodo que borra el elemento correspondiente a los valores recibidos por parametro  en el objeto almacenado .
  * @param dni -  valor para el dni.
  * @param segsocial - valor para el numero de la seguridad social 
  */
 public void elimina(String dni, int segsocial) throws NoExiste{
        Integer seg= new Integer(segsocial);
        if(!mapa1.containsKey(dni)){

            throw new NoExiste(" No existe un paciente con este numero del dni");
        }  

        if(!mapa3.containsKey(seg)){

            throw new NoExiste(" No existe un paciente con este numero de seguridad social");
        }
        Set s=mapa2.entrySet();
        Iterator it=s.iterator();

        while(it.hasNext())
        {
            Map.Entry m =(Map.Entry)it.next();            
            String clave=(String)m.getKey();
            int valor=(Integer)m.getValue();
            if((!clave.equals(dni))||(valor!=segsocial)){

                throw new NoExiste(" No existe un paciente con estos datos");

            }
            mapa1.remove(dni);
            mapa2.remove(dni);
            mapa3.remove(segsocial);
           

        }

    }

  /**Metodo que devuelve el numero de la seguridad social correspondiente al dni con el valor recibido por parametro.
  * @param dni -  valor para el dni.
  * @return int  - el valor correspondinete al  número de la seguridad social.
  */
 public int segsocial(String dni) throws NoExiste{
         int valor=0;
         
        if(!mapa2.containsKey(dni)){
            throw new NoExiste(" No existe un paciente con este numero de dni");

        }
        Set s=mapa2.entrySet();
        Iterator it=s.iterator();

        while(it.hasNext())
        {
            Map.Entry m =(Map.Entry)it.next();            
            String clave=(String)m.getKey();
            
            if((clave.equals(dni))){
                 valor=(Integer)m.getValue();              
                 
            }


        }
          return valor;       
        
    }

  /**Metodo que devuelve el numero del dni correspondiente al número de la seguridad social  con el valor recibido por parametro.
  * @param segsocial -  valor para el número de la seguridad social.
  * @return String  - el valor correspondinete al dni.
  */
 public String dni(int segsocial) throws NoExiste{
        String clave=new String();
        
        if(!mapa2.containsValue(segsocial)){
            throw new NoExiste(" No existe un paciente con este numero de seguridad social");

        }
        Set s=mapa2.entrySet();
        Iterator it=s.iterator();

        while(it.hasNext())
        {
            Map.Entry m =(Map.Entry)it.next();            
            int valor=(Integer)m.getValue();
            if(valor==segsocial){
                 clave=(String)m.getKey();
                
                
            }


        }
             return clave;

    }

  /**Metodo que devuelve el/los  numero del dni/s correspondiente/s al nombre con el valor recibido por parametro.
  * @param nombre -  valor para el nombre.
  * @return String  - el valor correspondinete del dni.
  */public String dni(String nombre) throws NoExiste {
        String clave=new String();
        String result=new String();
        
        if(!mapa1.containsValue(nombre)){
            throw new NoExiste(" No existe un paciente con este numero de seguridad social");

        }
        Set s=mapa1.entrySet();
        Iterator it=s.iterator();

        while(it.hasNext())
        {
            Map.Entry m =(Map.Entry)it.next();           
            String valor=(String)m.getValue();
            if(valor.equals(nombre)){
               clave=(String)m.getKey();
              
            }
            
           result=result.concat(String.format("%1$10s",clave));
        }
        return result;

    }
  /**Metodo que imprime los valores de  los elementos del objeto implicito.
  * 
  *
  */
 public void muestra(){
        
        Iterator it = mapa1.entrySet().iterator();
        Iterator it1 = mapa2.entrySet().iterator();
      
        System.out.printf("Listado pacientes:\n");
        System.out.printf("**************************************************************\n");
        System.out.printf("*     Dni -      Apellidos/Nombre  -  Numero Seguridad Social  \n");
        System.out.printf("**************************************************************\n");
        while(it.hasNext()&&it1.hasNext())
        {
             Map.Entry m =(Map.Entry)it.next(); 
             Map.Entry e =(Map.Entry)it1.next();
             String clave=(String)m.getKey();
             String clave1=(String)e.getKey();
             if(clave.equals(clave1)){
             
                System.out.printf("%10s%20s%14d\n",m.getKey() , m.getValue(),e.getValue());               
                System.out.printf("|____________________________________________________________|\n");
                
            
            }
       
        }
            }
        }
            
        
       

      



      