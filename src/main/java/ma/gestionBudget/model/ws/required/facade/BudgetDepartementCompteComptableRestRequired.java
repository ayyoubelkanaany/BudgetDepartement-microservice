package ma.gestionBudget.model.ws.required.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ma.gestionBudget.model.ws.provided.vo.BudgetDepartementVo;
import ma.gestionBudget.model.ws.required.vo.BudgetDepartementCompteComptableVo;


@FeignClient(name = "BUDGETDEPARTEMENTCOMPTECOMPTABLE-SERVICE")
public interface BudgetDepartementCompteComptableRestRequired {
	
	@RequestMapping(value = "/budgetDepartementCompteComptables/all",method = RequestMethod.POST)
	public int save(@RequestBody List<BudgetDepartementCompteComptableVo> budgetDepartementCompteComptableVos);
	
	@RequestMapping(value = "/budgetDepartementCompteComptables/refBudgetDepartement/{refBudgetDepartement}",method = RequestMethod.DELETE)
	public int deleteByRefBudgetDepartement(@PathVariable String refBudgetDepartement);
		
	@RequestMapping(value = "/budgetDepartementCompteComptables",method = RequestMethod.POST)
	public int save(@RequestBody BudgetDepartementCompteComptableVo budgetDepartementCompteComptableVo);
	
	
	@RequestMapping(value = "/budgetDepartementCompteComptables",method = RequestMethod.GET)
	public List<BudgetDepartementCompteComptableVo> findAll();

	
	@RequestMapping(value = "/budgetDepartementCompteComptables",method = RequestMethod.PUT)
	public BudgetDepartementCompteComptableVo updateBudgetDepartementCompteComptable(@RequestBody BudgetDepartementCompteComptableVo budgetDepartement);
	
	
	@RequestMapping(value = "/budgetDepartementCompteComptables/ref/{ref}",method = RequestMethod.PUT)
	public List<BudgetDepartementCompteComptableVo> findByrefBudgetDepartement(@PathVariable String ref);
	
	
	@RequestMapping(value = "/budgetDepartementCompteComptables/id/{id}",method = RequestMethod.GET)
	public BudgetDepartementCompteComptableVo findById(@PathVariable Long id);
}
