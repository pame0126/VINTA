package Modelo.tienda.db.conection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class DBOracle {
     static Connection cn;
    static Statement s;
    static ResultSet rs;
    private String host;
    private String user;
    private String password;
    private String port;
    private String dir;
    private Statement stmt;
    private Connection con;
    
    public DBOracle() {
        host = "localhost";
        user = "wifuss";
        password = "prueba";
        port = "1521";
        dir = "prueba";
    }
    
    public DBOracle(String h, String u, String p, String po, String s) {
	port=po;
	host=h;
	password=p;
	dir=s;
	user=u;
    }

    public boolean conectar() {
	try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@"+host+":"+port+":"+dir,user,password);
            stmt=con.createStatement();
            
            return true;
	}
	
        catch(ClassNotFoundException | SQLException e){
            return false;
	}
    }
    
public String ejecutarConsulta(String consulta, int cantParametros) { // Cambia este método para hacer con la consulta lo que gustes
		try {
 
			ResultSet res;
                    res = stmt.executeQuery(consulta);
			String devolver="";
                        
			while(res.next()) {
				for(int i=1; i<=cantParametros; i++) {
					devolver+=res.getString(i)+" ";
				}
				devolver+="\n";
			}
			
                    return devolver;
		}
		catch (SQLException SQLException) {
			System.out.println(SQLException);
		}
                return null;
	}
    
    /**
     * Ejecuta SQL que no contenga retorno
     * @param consulta
     */
    public void ejecutarSQL(String consulta){
        try {
            ResultSet rs=stmt.executeQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(DBOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void ejectutarSQLProcedure(String str){
         try {
             CallableStatement cstmt = con.prepareCall(str);
             cstmt.execute();
             cstmt.close();
         } catch (SQLException ex) {
             Logger.getLogger(DBOracle.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    /**
     * Ejecuta Consulta SQL que tengan retorno
     * @param consulta
     * @param cantParametros
     * @return 
     */
    public ArrayList<ArrayList<String>> selectSQL(String consulta, int cantParametros) {
        try {
            ResultSet res;
            res = stmt.executeQuery(consulta);
            ArrayList<String> dev;
            ArrayList<ArrayList<String>> devolver;
            devolver = new ArrayList<>();
            while(res.next()) {
                dev = new ArrayList<>();
                for(int i=1; i<=cantParametros; i++) {
                    //dev+=rs.getString(i)+" ";
                    dev.add(res.getString(i));
		}
		devolver.add(dev);
            }

            return devolver;
	}
        catch (SQLException SQLException) {
            System.out.println("Saltó la escepción\n"+SQLException);
	}
        
	
        return null;
    }
    
    
    public boolean desconectar() {
        try {
            con.close();
            return true;
	}
	catch (Exception SQLException) {
            return false;
	}
    }
    
    /**
     * Ejecuta Consulta SQL que tengan retorno
     */
    public ArrayList<ArrayList<String>> selectSQLProcedure(String consulta, String declaracion, int cantParametros) {
        try {
            
            stmt.execute(declaracion);
            ResultSet rs=stmt.executeQuery(consulta);
            ArrayList<String> dev;
            ArrayList<ArrayList<String>> devolver;
            devolver = new ArrayList<>();
            while(rs.next()) {
                dev = new ArrayList<>();
                for(int i=1; i<=cantParametros; i++) {
                    //dev+=rs.getString(i)+" ";
                    dev.add(rs.getString(i));
		}
		devolver.add(dev);
            }

            return devolver;
	}
        catch (Exception SQLException) {
            System.out.println("Saltó la escepción\n"+SQLException);
	}
        
	
        return null;
    }
}