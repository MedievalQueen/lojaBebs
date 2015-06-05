/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.DaoImagem;
import Dao.DaoProduto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import pacote.Categoria;
import pacote.Imagem;
import pacote.Produto;

/**
 *
 * @author hednisk
 */
@WebServlet(urlPatterns = {"/servletCadastrarProd"})
@MultipartConfig
public class servletCadastrarProd extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
 
            Produto p = new Produto();
            Categoria c=new Categoria();
            int id=Integer.valueOf(request.getParameter("cat"));
            c.setIdCategoria(id);
            c.setStatus(1);
            //c.setNome(request.getParameter("cat"));VERRRRRRRRRRRRRRRRRRRRRRRRRR
            p.setNome((String)request.getParameter("produto"));
            p.setCategoria(c);
            p.setDescricao((String)request.getParameter("descr"));
            p.setValor(Float.valueOf(request.getParameter("valor")));
            p.setQuantidade(Integer.valueOf(request.getParameter("qtd")));
            p.setStatus(1);
            // FAZER Conexao DAO passando cliente
            DaoProduto daoprod= new DaoProduto();
            int idp=daoprod.add(p); 
            //--------------------UPLOAD IMAGEM----------------------
            final String path = request.getParameter("destino");
            final Part filePart = request.getPart("arq");
            final String fileName = getFileName(filePart);

            OutputStream outp = null;
            InputStream filecontent = null;
            final PrintWriter writer = response.getWriter();

            try {
                outp = new FileOutputStream(new File(path + File.separator
                        + fileName));
                filecontent = filePart.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    outp.write(bytes, 0, read);
                }
              // String s=path+"\\"+fileName;
                String s="images/"+fileName;
                Imagem im=new Imagem();
                im.setFoto(s);
                im.setIdProduto(idp);

                DaoImagem daoi=new DaoImagem();
                daoi.add(im);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/servletLogar");
            rd.forward(request,response);
              //  LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
                  //      new Object[]{fileName, path});
            } catch (FileNotFoundException fne) {
                writer.println("You either did not specify a file to upload or are "
                        + "trying to upload a file to a protected or nonexistent "
                        + "location.");
                writer.println("<br/> ERROR: " + fne.getMessage());

                //LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
                //        new Object[]{fne.getMessage()});
            } catch (SQLException ex) {
                Logger.getLogger(servletCadastrarProd.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (outp != null) {
                    outp.close();
                }
                if (filecontent != null) {
                    filecontent.close();
                }
                if (writer != null) {
                    writer.close();
                }
            }
          
            /*
            //pegar id produto e inserir imagem com id produto
            InputStream inputStream = null; // input stream of the upload file
            // obtains the upload file part in this multipart request
            Part filePart = request.getPart("arq");
            if (filePart != null) {       
                // obtains input stream of the upload file
                inputStream = filePart.getInputStream();
            }
            Imagem1 im=new Imagem1();
            im.setIdProduto(13);
          //  im.setFoto((Blob) inputStream);
            DaoImagem1 daoi=new DaoImagem1();
            try {
                daoi.add(im,inputStream);
            } catch (SQLException ex) {
                Logger.getLogger(servletCadastrarProd1.class.getName()).log(Level.SEVERE, null, ex);
            }     */       
            //if(inseriu de boa){
           // RequestDispatcher rd = getServletContext().getRequestDispatcher("/servletLogar");
           // rd.forward(request,response);
            //}else{
            
            //}
        }
    }

    private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
   // LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
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