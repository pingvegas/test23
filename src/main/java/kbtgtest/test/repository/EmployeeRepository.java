package kbtgtest.test.repository;

import jakarta.persistence.EntityManager;
import kbtgtest.test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer > {
    Optional<Employee> findEmployeeByLastName(String lastName);

}
