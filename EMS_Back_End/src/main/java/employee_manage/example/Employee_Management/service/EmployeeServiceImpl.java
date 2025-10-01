package employee_manage.example.Employee_Management.service;

import employee_manage.example.Employee_Management.dto.EmployeeDto;
import employee_manage.example.Employee_Management.entity.Employee;
import employee_manage.example.Employee_Management.exception.ResourceNotFoundException;
import employee_manage.example.Employee_Management.mapper.EmployeeMapper;
import employee_manage.example.Employee_Management.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee createEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId)
               .orElseThrow(()->new ResourceNotFoundException("Employee is not exists with given id "+employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
       Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
               new ResourceNotFoundException("Employee is not exists with given id"+employeeId));

       employee.setFirstName(updateEmployee.getFirstName());
       employee.setLastName(updateEmployee.getLastName());
       employee.setEmail( updateEmployee.getEmail());

       Employee updateEmploye= employeeRepository.save(employee);
       return EmployeeMapper.mapToEmployeeDto(updateEmploye);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException("Employee is not exists with given id"+employeeId));

        employeeRepository.deleteById(employeeId);
    }

}



