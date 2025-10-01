package employee_manage.example.Employee_Management.repository;

import employee_manage.example.Employee_Management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
