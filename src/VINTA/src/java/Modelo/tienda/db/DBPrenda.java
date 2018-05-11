package Modelo.tienda.db;

import java.util.ArrayList;
import Modelo.tienda.Prenda;
import Modelo.tienda.db.conection.DBOracle;

/**
 * Tipos de consultas con Prendas
 */
public class DBPrenda {
    
    private static String selectAllPrendas ="select p.ID, p.TITULO, p.COSTO,cat.CATEGORIA, p.DESCRIPCION, c.CORREO, c.TELEFONO, i.IMAGEN_DIR  " +
"      from  prenda p" +
"      left join categoria cat  on p.ID = cat.CODIGO" +
"      left join contacto c  on p.ID = c.CODIGO" +
"      left join imagen i    on p.ID = i.CODIGO" +
"        order by id" +
"        ";
    private static String insertProcedurePrendas ="insert_prenda";
    private static String deleteProcedurePrendas ="delete_prenda";
    private static String updateProcedurePrendas = "update_prenda";
    
    private DBOracle oracle;
    
    
    public DBPrenda() {
        this.oracle = new DBOracle();
        
    }
   
    /**
     * Selecciona todas las prendas de la BD relacional en oracle
     * cargandolas a una lista de objetos en memoria.
     */
    public ArrayList<Prenda> selectAllPrendas(){
        ArrayList<Prenda> prendas = new ArrayList<>();
        Prenda act;
        ArrayList<ArrayList<String>> consultas;
        ArrayList<String> aux;
        int size_i=0;
        int parametros = 8;
        int id=-1;
        
        //consulta sobre elementos
        this.oracle.conectar();
        //matriz de la tabla consultada
        consultas = oracle.selectSQL(selectAllPrendas, parametros);
        
        size_i = consultas.size();
        for(int i = 0;i < size_i;i++){
            aux = consultas.get(i);
            //Si ya existe el objeto, agregar las demas imagenes
            if( (id == Integer.parseInt(aux.get(0))) 
                    && prendas.size() > 0){
                act = prendas.get( prendas.size() - 1 );//saca el top
                act.addFoto(aux.get(7) );//agregar foto
            }
            else{//sino se crea uno nuevo
                act = new Prenda();
                act.setId(Integer.parseInt( aux.get(0) ));//id
                act.setTitulo(aux.get(1) );//titulo
                act.setCategoria( aux.get(2) );//categoria
                act.setCosto( aux.get(3) );//costo
                act.setDescripcion( aux.get(4) );//descripcion
                act.setEmail(aux.get(5));//correo
                act.setTelefono( aux.get(6) );//telefono
                act.addFoto( aux.get(7) );//agregar foto
                
                prendas.add(act);
                id = Integer.parseInt( aux.get(0));
            }
        }
        this.oracle.desconectar();
        return prendas;
    }
      
    /**
     * Inserta el objeto prenda a la base de datos
     * @param item
     */
    public void insertPrenda(Prenda item){
        String sql = "{call "+insertProcedurePrendas+"(";
        sql+=   "'"+item.getTitulo();
        sql+= "','"+item.getCategoria();
        sql+="','"+item.getCosto();
        sql+="','"+item.getDescripcion();
        sql+="','"+item.getEmail();
        sql+="','"+item.getTelefono()+"',";
        sql+=item.toStringFotos()+") }";
        this.oracle.conectar();
        //this.oracle.ejecutarSQL(sql);
        //this.oracle.desconectar();
        this.oracle.ejectutarSQLProcedure(sql);
        
    }
    
    /**
     * Borrar un elemento de la tabla prendas, y por consiguiente
     * a todas las demas tablas relacionadas con ella.
     * 
     */
    public void deletePrenda(String id){
        String sql ="{call "+ deleteProcedurePrendas+"(";
        sql+= id+")}";
        this.oracle.conectar();
        this.oracle.ejectutarSQLProcedure(sql);
        
    }

    public void updatePrenda(Prenda item){
        String sql = "{call "+updateProcedurePrendas+"(";
        sql+=   item.getId()+",'"+item.getTitulo()+"','"+
                item.getCategoria()+"','"+item.getCosto()+"','"+
                item.getDescripcion()+"','"+item.getEmail()+"','"+
                item.getTelefono()+"',"+item.toStringFotos()+"";
        sql+=")}";
        System.out.println(sql);
        this.oracle.conectar();
        this.oracle.ejectutarSQLProcedure(sql);
        
    }
}
