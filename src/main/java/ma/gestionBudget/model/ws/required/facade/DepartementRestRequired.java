package ma.gestionBudget.model.ws.required.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import io.swagger.annotations.ApiOperation;
import ma.gestionBudget.model.ws.required.vo.DepartementVo;

@FeignClient(name = "DEPARTEMENT-SERVICE")
public interface DepartementRestRequired {
	@RequestMapping(value = "/departement/refDepartement/{refDepartement}",method = RequestMethod.GET)
	public DepartementVo findByRefDepartement(@PathVariable String refDepartement);
}
