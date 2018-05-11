
package Modelo.tienda;


public class Usuario {
    private int id;
    private String nombre;
    private String apellidos;
    private String alias;
    private String info;
    private String correo;
    private String sexo;
    private String password;

    public Usuario(String nombre, String apellidos, String alias, String correo, String sexo, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.alias = alias;
        this.info = null;
        this.correo = correo;
        this.sexo = sexo;
        this.password = password;
    }

    public Usuario(String nombre, String apellidos, String alias, String info, String correo, String sexo, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.alias = alias;
        this.info = info;
        this.correo = correo;
        this.sexo = sexo;
        this.password = password;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getAlias() {
        return alias;
    }

    public String getInfo() {
        return (info == null)?"":info;
    }

    public String getCorreo() {
        return correo;
    }

    public String getSexo() {
        return sexo;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = (nombre != null && nombre.length() > 1)? nombre:this.nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = (apellidos != null && apellidos.length() > 1)? apellidos:this.apellidos;
    }

    public void setAlias(String alias) {
        this.alias = (alias != null && alias.length() > 1)? alias:this.alias;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setCorreo(String correo) {
        this.correo = (correo != null && correo.length() > 1)? correo:this.correo;
    }

    public void setSexo(String sexo) {
        this.sexo = (sexo != null && sexo.length() > 1)? sexo:this.sexo;
    }

    public void setPassword(String password) {
        this.password = (password != null && password.length() > 1)? password:this.password;
    }
    
    @Override
    public String toString(){
        String str="";
        str+=   getId()+" "+getNombre()+" "+getApellidos()+" "+
                getSexo()+" "+getAlias()+" "+getInfo()+" "+
                getCorreo()+"\n";
        return str;
    }
}
