package employee_manage.example.Employee_Management.exception;

public class ResourceNotFoundException extends  RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }
}
