package ma.gestionBudget.model.service.facade;

import java.util.List;

import ma.gestionBudget.bean.BudgetDepartement;


public interface BudgetDepartementService {
	public int save(BudgetDepartement budgetDepartement);
	public int save(List<BudgetDepartement> budgetDepartement);
	public int updateBudgetDepartement(BudgetDepartement budgetDepartement);
	public List<BudgetDepartement> findAll();
	public BudgetDepartement findById(Long id);
	public List<BudgetDepartement> findByMontantTotal(double montantTotal);
	public List<BudgetDepartement> finByRefBudget(String ref);
	public Long deleteByRefBudget(String ref); 
	public int deleteById(long id);
    public BudgetDepartement findByReference(String ref);
}
