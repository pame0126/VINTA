
package Modelo.tienda;

import java.util.ArrayList;

public class Prenda {
    private int id;    
    private String titulo;
    private String categoria;
    private String costo;
    private String descripcion;
    private ArrayList<String> fotos;
    private String email;
    private String telfono;

    
    public Prenda(int id, String titulo, String categoria, String costo, String email) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.costo = costo;
        this.email = email;
        this.fotos = new ArrayList<>();
    }

    public Prenda(String id, String titulo, String categoria, String costo, String descripcion, ArrayList<String> fotos, String email, String telfono) {
        this.id = Integer.parseInt(id);
        this.titulo = titulo;
        this.categoria = categoria;
        this.costo = costo;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.email = email;
        this.telfono = telfono;
    }

    public Prenda(String titulo, String categoria, String costo, String email) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.costo = costo;
        this.email = email;
        this.fotos = new ArrayList<>();
    }

    public Prenda(String titulo, String categoria, String costo, String descripcion, ArrayList<String> fotos, String email, String telfono) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.costo = costo;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.email = email;
        this.telfono = telfono;
    }
    
    public Prenda() {
        this.fotos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public String getIdString() {
        return ""+id;
    }
    public String getTitulo() {
        return (titulo == null)? "" : titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return (categoria == null) ? "": categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCosto() {
        return (costo == null) ? "":costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return (descripcion == null)? "":descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<String> getFotos() {
        return fotos;
    }

    public void addFoto(String foto) {
        if(foto!=null){
            this.fotos.add(foto);
        }
    }

    public String getEmail() {
        return (email == null)? "":email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return (telfono == null)?"":telfono;
    }

    public void setTelefono(String telfono) {
        this.telfono = telfono;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        String res = "";
        res+= getId()+" "+getTitulo()+" "+getCategoria()+" "+getCosto()+" "+getDescripcion()+
                " "+getEmail()+" "+getTelefono();
        
        for(int i = 0; i < getFotos().size();i++){
            res+=" "+getFotos().get(i);
        }
        res+="\n";
        return res;
    }
    
    public String toStringFotos(){
        String res = "'";
        int size = getFotos().size() - 1;
        int i = 0;
        while( i < size){
            res+=getFotos().get(i)+",";
            i++;
        }
        res+=getFotos().get(i);
        res+="'";
        return res;
    }
}
