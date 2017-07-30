/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.EmployeeManager;
import business.Person;
import data.EmployeeManagerDA;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.DateUtil;

/**
 *
 * @author da202057
 */
public class EmployeeListServlet extends HttpServlet {

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
        
        String url = "/index.jsp";
        
        // Get the current action
        String action = request.getParameter("action");
        if (action == null) {
            // The default action
            action = "defaultList";
        }
        
        // Set up the default list of employees.
        EmployeeManager allEmployees = new EmployeeManager();
        ArrayList<Person> employeeList = new ArrayList<Person>();
        employeeList = allEmployees.getEmployees();
        
        if (action.equals("defaultList")) {
            url = "/index.jsp";
        }
        else if (action.equals("searchRequest")) {    
            String hireDateString = request.getParameter("searchDate");
            LocalDate hireDate = LocalDate.parse(hireDateString);
            
            // Override the default list of employees to reflect the 
            // search criteria the user selected from the form.
            String searchCriteria = request.getParameter("optionsDate");
            employeeList = allEmployees.search(hireDate, searchCriteria);

            // Formate the date for output.
            DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
            String searchDateFormatted = dtf.format(hireDate);
            
            request.setAttribute("searchCriteria", searchCriteria);
            request.setAttribute("searchDateFormatted", searchDateFormatted);
        }
        
        // Get a count of all employees that are in the employeeList.
        String listCount = String.valueOf(employeeList.size());
        
        // Get today's date to set the default value of the date input.
        LocalDate today = DateUtil.getDateToday();
        String todayString = DateUtil.formatDateToString(today);
        
        request.setAttribute("listCount", listCount);
        request.setAttribute("todayString", todayString);
        request.setAttribute("employeeList", employeeList);
        
        this.getServletContext().getRequestDispatcher(url)
        .forward(request, response);
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
