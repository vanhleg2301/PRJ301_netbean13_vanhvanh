/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SortServlet", urlPatterns = {"/sort"})
public class SortServlet extends HttpServlet {

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
        DAO dao = new DAO();
        String option = request.getParameter("Sort");
        String cateID = request.getParameter("cid");
        String categoryIDSort = null;
        if (request.getParameter("cateID") != "") {
            categoryIDSort = request.getParameter("cateID");
        }
        List<Product> listPBID = dao.getAllProductByCateID(cateID);
        List<Category> listC = dao.getAllCategory();
        request.setAttribute("listC", listC);
        request.setAttribute("listP", listPBID);
        List<Product> list;
        switch (option) {
            case "1":
                if (categoryIDSort == null) {
                    list = dao.SortByPriceAsc();
                    request.setAttribute("listP", list);
                } else {
                    list = dao.SortByPriceAsc(Integer.parseInt(categoryIDSort));
                    request.setAttribute("listP", list);
                }
                break;
            case "2":
                if (categoryIDSort == null) {
                    list = dao.SortByPriceDesc();
                    request.setAttribute("listP", list);
                } else {
                    list = dao.SortByPriceDes(Integer.parseInt(categoryIDSort));
                    request.setAttribute("listP", list);
                }
                break;
            case "3":
                list = dao.SortByNameAsc();
                request.setAttribute("listP", list);
                break;
            case "4":
                list = dao.SortByNameDesc();
                request.setAttribute("listP", list);
                break;
            default:
        }
        request.setAttribute("cateID", categoryIDSort);
        request.getRequestDispatcher("products.jsp").forward(request, response);
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
