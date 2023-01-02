package com.restapi.employeemicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class Employeecontroller {
    @Autowired
    EmployeeRepository employeerepository;


    @GetMapping("/getmsg/{username}")
    public String getgreetings(@PathVariable String username) {

        return "hay Good " + username;

    }

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        Set<PhoneNumber>phoneNumberSet =employee.getPhoneNumber();
        phoneNumberSet.forEach(phoneNumber -> phoneNumber.setEmployee(employee));
        return employeerepository.save(employee);


    }

    @GetMapping("/findallemployee")
    public List<Employee> gelallemployee() {
       // return employeerepository.findAll();
        return new ArrayList<>(CacheManager.cache.values());

    }

    @GetMapping("/findemployeebyid/{empID}")
    public String getemployeebyId(@PathVariable int empID) {
       // Optional<Employee> employee = employeerepository.findById(empID);
        //Optional => Its avoid the NullPointer Exception.
        Employee employee = CacheManager.cache.get(empID);
//        if (employee.isPresent())
//            return employee.get().toString();
        if (employee!=null)
          return employee.toString();
        else
            return "employee is not available for this id";

    }

    @PutMapping("/updateemployee/{Empid}")
    public String updateEmployee(@PathVariable int Empid, @RequestBody Employee employee) {
        Optional<Employee> oldEmployee = employeerepository.findById(Empid);
        if (oldEmployee.isPresent()) {
            //return employeerepository.save(employee).toString();
            //transformer -- new values --old --old
            oldEmployee.get().setEmpName(employee.getEmpName());
            oldEmployee.get().setEmpSal(employee.getEmpSal());
            return employeerepository.save(oldEmployee.get()).toString();

        } else {
            return "Employee is not present for this given Id unable to update";
        }

        }


        @DeleteMapping("/deleteemployee/{EmpID}")

        public String deleteEmployee(@PathVariable int EmpID){
            Optional<Employee> employee1  = employeerepository.findById(EmpID);
            if (employee1.isPresent()){
                employeerepository.deleteById(EmpID);
                return "employee with "+ EmpID +"is delete sucessfully";
            }else{

                return "employee with "+ EmpID +"is not present for delete";
            }
    }














    }
