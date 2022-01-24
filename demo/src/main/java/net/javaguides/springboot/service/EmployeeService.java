package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Candidate;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Candidate> getAllEmployees();
    void saveEmployee(Candidate employee);
    Candidate getEmployeeById(long id);
    void deleteEmployeeById(long id);
    Page<Candidate> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
