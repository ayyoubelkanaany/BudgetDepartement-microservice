package ma.gestionBudget.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ma.gestionBudget.bean.BudgetDepartement;
import ma.gestionBudget.model.dao.BudgetDepartementRepository;
import ma.gestionBudget.model.service.facade.BudgetDepartementService;
import ma.gestionBudget.model.ws.provided.vo.BudgetDepartementVo;
import ma.gestionBudget.model.ws.required.facade.BudgetDepartementCompteComptableRestRequired;
import ma.gestionBudget.model.ws.required.facade.BudgetRestRequired;
import ma.gestionBudget.model.ws.required.facade.DepartementRestRequired;
import ma.gestionBudget.model.ws.required.vo.BudgetVo;
import ma.gestionBudget.model.ws.required.vo.DepartementVo;
import net.bytebuddy.description.annotation.AnnotationValue.ForAnnotationDescription.Loaded;

@Service
public class BudgetDepartementServiceImpl implements BudgetDepartementService {
	
	@Autowired
    private BudgetDepartementRepository budgetDepartementRepository;
	@Autowired
    private BudgetRestRequired budgetRestRequired;
	
	@Autowired
	private DepartementRestRequired departementRestRequired;
	@Autowired
    private BudgetDepartementCompteComptableRestRequired BudgetDepartementCompteComptableRestRequired;
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public int save(BudgetDepartement budgetDepartement) {
		BudgetVo budgetVo = null;
		DepartementVo departementVo = null;
		BudgetDepartement loadedBudgetDepartement = findByReference(budgetDepartement.getReference());
		
		if(budgetDepartement == null) {
			return -1;
		}
		if(loadedBudgetDepartement != null) {
			return -2;
		}
		  if(budgetDepartement.getReference() ==null); 
		  else { 
			  loadedBudgetDepartement = findByReference(budgetDepartement.getReference()); 
		  }
		  
		  if(budgetDepartement.getRefDepartement() == null);
		  else { 
			  departementVo = this.departementRestRequired.findByRefDepartement(budgetDepartement.getRefDepartement()); 
		    } 
		  if(budgetDepartement.getRefBudget() == null); 
		  else {
		  budgetVo = this.budgetRestRequired.findByRefBudget(budgetDepartement.getRefBudget()); }
		  
		  if(loadedBudgetDepartement != null) { 
			  return -2; 
			  } 
		  if(budgetVo == null) {
		  return -3;
		  }
		  
		  if(departementVo == null) { return -4; }
		 
    else {
    	if(budgetDepartement.getId() != null) {
	  	     updateBudgetDepartement(budgetDepartement);
		}
    	else {
    	budgetDepartement.setMontantTotal(budgetDepartement.getMontantFonctionement()+budgetDepartement.getMontantInvestisement()); 
		this.budgetDepartementRepository.save(budgetDepartement);
	
    	}
    	return 1;
	}
		
	}
	
	
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public int updateBudgetDepartement(BudgetDepartement budgetDepartement) {
		if(budgetDepartement.getId() == null) {
		  	     save(budgetDepartement);
		}
		  
    else {
    	budgetDepartement.setMontantTotal(budgetDepartement.getMontantFonctionement()+budgetDepartement.getMontantInvestisement()); 
		this.budgetDepartementRepository.save(budgetDepartement);
		
	}
		return 1;
		
	}

	@Override
	public List<BudgetDepartement> findAll() {
		return this.budgetDepartementRepository.findAll();
	}

	@Override
	public BudgetDepartement findById(Long id) {
		Optional<BudgetDepartement> loadedBudgetDepartement = this.budgetDepartementRepository.findById(id);
	
		if(loadedBudgetDepartement.isPresent()) {
			return loadedBudgetDepartement.get();
		}
		return null;
	}
	@Override
	public List<BudgetDepartement> findByMontantTotal(double montantTotal) {
		return this.budgetDepartementRepository.findByMontantTotal(montantTotal);
	}
	
	@Transactional
	@Override
	public Long deleteByRefBudget(String ref) {
		return this.budgetDepartementRepository.deleteByRefBudget(ref);
	}
	@Transactional
	@Override
	public int deleteById(long id) {
		if(id != 0) {
			////supprimer la liste des budgetdepartementcomptecomptable
			
			 this.budgetDepartementRepository.deleteById(id);
			return 1;
		} else {
			return -1;
		}
		
	}
	
	@Override
	public List<BudgetDepartement> finByRefBudget(String ref) {
		return this.budgetDepartementRepository.findByRefBudget(ref);
	}
	@Override
	public BudgetDepartement findByReference(String ref) {
		return this.budgetDepartementRepository.findByReference(ref);
	}



	@Override
	public int save(List<BudgetDepartement> budgetDepartements) {
		if(budgetDepartements.isEmpty() || budgetDepartements==null) {
			return -2;
		}
		else {
			for(int i=0;i<budgetDepartements.size();i++) {
				save(budgetDepartements.get(i));
			}
			return 2;
		}
		
	}
	
}
