/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.EmployeeManagerDA;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author fssco
 */
public class EmployeeManager {

    private ArrayList<Person> employees;

    public EmployeeManager() {
        employees = EmployeeManagerDA.getAllEmployees();
    }

    /**
     * @return the employees
     */
    public ArrayList<Person> getEmployees() {
        return employees;
    }

    /**
     * @param employees the employees to set
     */
    public void setEmployees(ArrayList<Person> employees) {
        this.employees = employees;
    }

    public ArrayList<Person> search(LocalDate searchDate) {
        ArrayList<Person> temp = new ArrayList<Person>();

        //
        temp.add(employees.get(0));

        return temp;
    }



}
