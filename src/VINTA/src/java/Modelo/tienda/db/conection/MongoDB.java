
package Modelo.tienda.db.conection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import java.io.IOException;
import java.net.UnknownHostException;


public class MongoDB {
    DB BaseDeDatos;
    DBCollection coleccion;
    BasicDBObject tabla= new  BasicDBObject();
  
     public MongoDB(){
            try{
               
               Mongo mongo=new Mongo("localhost",27017);            //conecta con mongo
               BaseDeDatos= mongo.getDB("vinta");                   //se conecta con la coleccion
               coleccion=BaseDeDatos.getCollection("usuarios");     //se conecta con la base de datos
               System.out.println("Base de Datos conectada");       //mensaje de exito
               
            }catch(Exception ex){
                System.out.println("Error al conectar");            //mensaje en caso de que haya error
            }
        }
     
  //elimina de mongo la informacion que corresponde al correo
     public boolean eliminar(String correo){
         tabla.put("correo", correo);       
         coleccion.remove(tabla);                                               //borra de la tabla usuarios, el usuario con ese correo
         return true;
     }
     
     
   //inserta un nuevo usuario
       public boolean insertar(String nombre,String apellidos,String alias,String info, String correo, String sexo, String password){
         tabla.put("nombre", nombre);
         tabla.put("apellidos", apellidos);
         tabla.put("alias", alias);
         tabla.put("info", info);
         tabla.put("correo", correo);
         tabla.put("sexo", sexo);
         tabla.put("password",password);
         coleccion.insert(tabla);                                               //inserta en la tabla usuarios todo lo anterior
         return true;
     }
     
       
       //Actualiza la contrasena guarda la contraseña vieja, la busca y cuando la encuentra 
       //la sobreescribe y luego la guarda
      public boolean actualizarContraseña(String contrasenaVieja,String contrasenaNueva){ 
          tabla.put("password",contrasenaVieja); 
          DBCursor cursor = coleccion.find(tabla); 
          if(cursor.hasNext()) { 
              DBObject nueva = cursor.next(); 
              nueva.put("password", contrasenaNueva); 
              coleccion.save(nueva); 
            }
         return true;
     }

      //recorre hasta encontrar una contraseña que coincida
      //en caso de coincidir levanta una bandera, esta la retorna
     public int iniciarsesion(String contrasena){
        BasicDBObject tabla = new BasicDBObject();
	tabla.put("password", contrasena);
	DBCursor cursor = coleccion.find(tabla);
	
        String contras="";
        
    if (cursor.hasNext()) {
        DBObject objeto = cursor.next();
        contras = (String) objeto.get("password");
    }
    int cont=0;
    if (contrasena.equals(contras))                                             //Si son iguales
   {
        System.out.print("funciona");
        cont=1;                                                                 //levante la bandera
    } else {
        System.out.print("no funciona");
    }
    if (cont==1){                                                               //si la bandera esta levantada
        return 1;                                                               //Retorne 1
    }
    return 0;                                                                   //Sino retorne 0    
     }

      
}