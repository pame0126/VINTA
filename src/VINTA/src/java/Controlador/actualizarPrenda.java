/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.tienda.Prenda;
import Modelo.tienda.db.DBPrenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Wifuss
 */
@WebServlet(name = "actualizarPrenda", urlPatterns = {"/actualizarPrenda"})
public class actualizarPrenda extends HttpServlet {

    public actualizarPrenda() {
        super();
    }

   
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigoP = request.getParameter("codigo");
        String tituloP = request.getParameter("titulo");
             String categoriaP = request.getParameter("categoria");
             String costoP = request.getParameter("costo");
             String descripcionP = request.getParameter("descripcion");
             String fotosP = request.getParameter("fotos");
             String emailP = request.getParameter("email");
             String telefonoP = request.getParameter("telefono");
            ArrayList<String> f = new ArrayList<>();
             f.add(fotosP);
             Prenda sql;
        sql = new Prenda(codigoP,tituloP,categoriaP,costoP,descripcionP,f,emailP,telefonoP);
             
             DBPrenda p= new DBPrenda();
             p.updatePrenda(sql);
            response.sendRedirect("index.html");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
