
package Modelo.tienda;


import java.util.ArrayList;
import Modelo.tienda.db.DBPrenda;
import Modelo.tienda.db.conection.DBOracle;
import javax.activation.DataSource;
import javax.annotation.Resource;


public class Tienda {

    public static void main(String[] args) {
  
        DBPrenda x = new DBPrenda();
        ArrayList<Prenda> ps = x.selectAllPrendas();
        System.out.println(ps.size());
        //x.conectar();
        //x.desconectar();
        /*
        ArrayList<String> f = new ArrayList<>();
             f.add("hola");
        Prenda p= new Prenda("prueba","asd","15000","llsaas",f,"elena@gmail.com","85714644");
        pr.insertPrenda(p);*/
        //pr.insertImagen(101,"/foto/101");
        //x.conectar();
        //x.ejectutarSQLProcedure("{call INSERT_PRENDA('esto es una prueba','asd','12300','llf sk','delia@gmail.com','85714644', null) }");
        //{call+ insert_prenda('as','asd','asd','sd','elena@gmail.com','85714644','hola') }
        //x.desconectar();

        
    }
     
    
}
