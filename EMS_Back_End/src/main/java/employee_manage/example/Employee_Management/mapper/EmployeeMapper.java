package employee_manage.example.Employee_Management.mapper;

import employee_manage.example.Employee_Management.dto.EmployeeDto;
import employee_manage.example.Employee_Management.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
       return new Employee(
               employeeDto.getId(),
               employeeDto.getFirstName(),
               employeeDto.getLastName(),
               employeeDto.getEmail()
       );


    }




}
