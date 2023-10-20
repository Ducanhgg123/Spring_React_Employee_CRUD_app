package com.ducanh.test1.DAO;

import com.ducanh.test1.Entity.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImple  implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EmployeeEntity findEmployeeById(int id) {
        EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class,id);
        return employeeEntity;
    }

    @Override
    public List<EmployeeEntity> findEmployees() {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery("From EmployeeEntity ", EmployeeEntity.class);
        return query.getResultList();
    }

    @Override
    public EmployeeEntity deleteEmployee(int id) {
        EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class,id);
        entityManager.remove(employeeEntity);
        return employeeEntity;
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        employeeEntity = entityManager.merge(employeeEntity);
        return employeeEntity;
    }
}
