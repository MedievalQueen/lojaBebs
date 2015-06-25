/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.VendaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pacote.Venda;

/**
 *
 * @author Ina
 */
@WebServlet(urlPatterns = {"/servletVenda"})
public class servletVenda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
  PrintWriter out = response.getWriter();
        if ("fatur".equals(action)){
           VendaDao vd = new VendaDao();
           List<Venda> lista = new ArrayList<>();
          
           try {
               lista= vd.faturamento(); // out.println("passou");
             //  request.setAttribute("listaf",lista);
              // out.println(lista.get(1).getDataPagamento().getMonth());//março é 2
               List<Float> meses = new ArrayList<Float>();
               for (int i = 0; i < 12; i++) {
                 meses.add(i, 0f);
                }
               for(int i=0;i<lista.size();i++){
                   if(lista.get(i).getDataPagamento().getMonth()==0)
                        meses.add(0, (lista.get(i).getValor()+meses.get(0)));
                    if(lista.get(i).getDataPagamento().getMonth()==1)
                        meses.add(1, (lista.get(i).getValor()+meses.get(1)));
                    if(lista.get(i).getDataPagamento().getMonth()==2)
                        meses.add(2, (lista.get(i).getValor()+meses.get(2)));
                    if(lista.get(i).getDataPagamento().getMonth()==3)
                        meses.add(3, (lista.get(i).getValor()+meses.get(3)));
                    if(lista.get(i).getDataPagamento().getMonth()==4)
                        meses.add(4, (lista.get(i).getValor()+meses.get(4)));
                    if(lista.get(i).getDataPagamento().getMonth()==5)
                        meses.add(5, (lista.get(i).getValor()+meses.get(5)));
                    if(lista.get(i).getDataPagamento().getMonth()==6)
                        meses.add(6, (lista.get(i).getValor()+meses.get(6)));
                    if(lista.get(i).getDataPagamento().getMonth()==7)
                        meses.add(7, (lista.get(i).getValor()+meses.get(7)));
                    if(lista.get(i).getDataPagamento().getMonth()==8)
                        meses.add(8, (lista.get(i).getValor()+meses.get(8)));
                    if(lista.get(i).getDataPagamento().getMonth()==9)
                        meses.add(9, (lista.get(i).getValor()+meses.get(9)));
                    if(lista.get(i).getDataPagamento().getMonth()==10)
                        meses.add(10, (lista.get(i).getValor()+meses.get(10)));
                    if(lista.get(i).getDataPagamento().getMonth()==11)
                        meses.add(11, (lista.get(i).getValor()+meses.get(11)));
                    
               }for (int i = 0; i < 12; i++) {
                 meses.add(12, meses.get(i)+meses.get(12));
                }
            //   out.println(meses.get(2));
               
               request.setAttribute("listaf",meses);
            } catch (SQLException ex) {
                Logger.getLogger(servletLogar.class.getName()).log(Level.SEVERE, null, ex);
                
            }        
             HttpSession session = request.getSession();
            session.setAttribute("redir", "relatFaturamento");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);  
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
