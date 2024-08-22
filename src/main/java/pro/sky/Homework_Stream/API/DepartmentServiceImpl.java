package pro.sky.Homework_Stream.API;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public Employee maxSalary (int departmentId){
        return employeeServiceImpl.allEmployees()
                .stream()
                .filter(employee -> departmentId == employee.departmentId())
                .max(Comparator.comparingInt(Employee::salary))
                .orElse(null);
    }

    @Override
    public Employee minSalary (int departmentId){
        return employeeServiceImpl.allEmployees()
                .stream()
                .filter(employee -> departmentId == employee.departmentId())
                .min(Comparator.comparingInt(Employee::salary))
                .orElse(null);
    }

    @Override
    public List<Employee> allByDept (int departmentId){
        return employeeServiceImpl.allEmployees()
                .stream()
                .filter(employee -> departmentId == employee.departmentId())
                .toList();
    }

    @Override
    public Map<Integer, List <Employee>> groupByDept (){
        return employeeServiceImpl.allEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::departmentId));
    }
}