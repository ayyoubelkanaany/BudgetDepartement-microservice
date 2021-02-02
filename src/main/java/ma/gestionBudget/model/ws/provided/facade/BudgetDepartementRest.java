package ma.gestionBudget.model.ws.provided.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.gestionBudget.bean.BudgetDepartement;
import ma.gestionBudget.model.service.impl.BudgetDepartementServiceImpl;
import ma.gestionBudget.model.ws.provided.converter.BDConverter;
import ma.gestionBudget.model.ws.provided.vo.BudgetDepartementVo;
import ma.gestionBudget.model.ws.required.facade.BudgetDepartementCompteComptableRestRequired;
import ma.gestionBudget.model.ws.required.vo.BudgetDepartementCompteComptableVo;
import net.bytebuddy.asm.Advice.Return;

@CrossOrigin(origins = "http://localhost:4200")
@Api("Cette class permet de gerer les traiements relative aux budgets à savoir Save, FindAll, ...etc.")
@RestController
public class BudgetDepartementRest {
	@Autowired
	private BudgetDepartementCompteComptableRestRequired budgetDepartementCompteComptableRestRequired;
	
	@Autowired
	private BudgetDepartementServiceImpl budgetDepartementServiceImpl;


	@Autowired
	private BDConverter bdconveter;
			
	
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgetDepartement par budget")
	@RequestMapping(value = "/budgetDepartements/reference/{reference}",method = RequestMethod.GET)
	public BudgetDepartementVo findByReference(@PathVariable String reference) {
		return bdconveter.toVo(budgetDepartementServiceImpl.findByReference(reference));
	}

	
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgetDepartement par budget")
	@RequestMapping(value = "/budgetDepartements/refBudget/{refBudget}",method = RequestMethod.GET)
     public List<BudgetDepartementVo> finByRefBudget(@PathVariable String refBudget) {
		return bdconveter.toListVo((budgetDepartementServiceImpl.finByRefBudget(refBudget)));
	}
	
	
	
	@ApiOperation("Cette methode permet de supprimer les budgetDepartement par budget")
     @RequestMapping(value = "/budgetDepartements/refBudgetDepartement/{refBudgetDepartement}",method = RequestMethod.DELETE)
	public Long deleteByRefBudget(@PathVariable String refBudgetDepartement) {
		this.budgetDepartementCompteComptableRestRequired.deleteByRefBudgetDepartement(refBudgetDepartement);
		return budgetDepartementServiceImpl.deleteByRefBudget(refBudgetDepartement);
	}

	
	
	
    @ApiOperation("Cette methode permet de supprimer les budgetDepartement par id")
    @RequestMapping(value = "/budgetDepartements/id/{id}",method = RequestMethod.DELETE)
	public int deleteById(@PathVariable long id) {
    	BudgetDepartement loadedBudgetDepartement = this.budgetDepartementServiceImpl.findById(id);
    	this.budgetDepartementCompteComptableRestRequired.deleteByRefBudgetDepartement(loadedBudgetDepartement.getReference());
    	return budgetDepartementServiceImpl.deleteById(id);
	}
	
    
    @ApiOperation("Cette methode permet de stocker un budgetDepartement")
	@RequestMapping(value = "/budgetDepartements/all",method = RequestMethod.POST)
    public int save(@RequestBody List<BudgetDepartementVo> budgetDepartementVos) {
		return budgetDepartementServiceImpl.save(bdconveter.toListBean(budgetDepartementVos));
		
	}

	@ApiOperation("Cette methode permet de stocker un budgetDepartement")
	@RequestMapping(value = "/budgetDepartements",method = RequestMethod.POST)
	public int save(@RequestBody BudgetDepartementVo budgetDepartementvo) {
		 budgetDepartementServiceImpl.save(bdconveter.toBean(budgetDepartementvo));
		return budgetDepartementCompteComptableRestRequired.save(budgetDepartementvo.getBudgetDepartementCompteComptableVo());
		
	}
		
	
	
	@ApiOperation("Cette methode permet de mettre ajour un BudgetDepartementVo")
     @RequestMapping(value = "/budgetDepartements",method = RequestMethod.PUT)
	public int updateBudgetDepartement(@RequestBody BudgetDepartementVo budgetDepartementVo) {
		return budgetDepartementServiceImpl.updateBudgetDepartement(bdconveter.toBean(budgetDepartementVo));
	}
		
	
	@ApiOperation("Cette methode permet de retourner la liste des BudgetDepartementVo ")
     @RequestMapping(value = "/budgetDepartements",method = RequestMethod.GET)
	public List<BudgetDepartementVo> findAll() {
		return bdconveter.toListVo(budgetDepartementServiceImpl.findAll());
	}
	
	
	
	@ApiOperation("Cette methode permet de trouver un BudgetDepartementVo avec son Id")
    @RequestMapping(value = "/budgetDepartements/id/{id}",method = RequestMethod.GET)
	public BudgetDepartementVo findById(@PathVariable Long id) {
		return bdconveter.toVo(budgetDepartementServiceImpl.findById(id));
	}
	
	
	
	@ApiOperation("Cette methode permet de trouver un BudgetDepartementVo avec Le MontantTotal")
    @RequestMapping(value = "/budgetDepartements/montantTotal/{montantTotal}",method = RequestMethod.GET)
	public List<BudgetDepartementVo> findByMontantTotal(@PathVariable double montantTotal) {
		return bdconveter.toListVo(budgetDepartementServiceImpl.findByMontantTotal(montantTotal));
	}

}
