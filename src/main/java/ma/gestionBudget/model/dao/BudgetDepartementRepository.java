package ma.gestionBudget.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.gestionBudget.bean.BudgetDepartement;

@Repository
public interface BudgetDepartementRepository extends JpaRepository<BudgetDepartement, Long> {
    public List<BudgetDepartement> findByMontantTotal(double montantTotal);
    public List<BudgetDepartement> findByRefBudget(String ref);
    public Long deleteByRefBudget(String ref); 
    public BudgetDepartement findByReference(String ref);
    public List<BudgetDepartement> findByRefDepartement(String refDepartement);
}