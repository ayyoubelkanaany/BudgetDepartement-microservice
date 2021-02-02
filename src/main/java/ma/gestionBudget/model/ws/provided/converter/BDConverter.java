package ma.gestionBudget.model.ws.provided.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import ma.gestionBudget.bean.BudgetDepartement;
import ma.gestionBudget.model.ws.provided.vo.BudgetDepartementVo;
@Component
public class BDConverter {
	
	public BudgetDepartement toBean(BudgetDepartementVo vo) {
		if(vo==null) {
		return null;
		}
		else {
			BudgetDepartement bDepartement = new BudgetDepartement();
			if(vo.getMontantFonctionement() != null) {
				bDepartement.setMontantFonctionement(Double.parseDouble(vo.getMontantFonctionement()));
			}
			
			if(vo.getMontantFonctionementRestant()!=null) {
				bDepartement.setMontantFonctionementRestant(Double.parseDouble(vo.getMontantFonctionementRestant()));
			}
			if(vo.getMontantInvestisement() != null) {
				bDepartement.setMontantInvestisement(Double.parseDouble(vo.getMontantInvestisement()));
			}
			
			if(vo.getMontantInvestisementRestant()!=null) {
				bDepartement.setMontantInvestisementRestant(Double.parseDouble(vo.getMontantInvestisementRestant()));
			}
			if(vo.getMontantTotal()!=null) {
				bDepartement.setMontantTotal(Double.parseDouble(vo.getMontantTotal()));
			}
			if(vo.getRefBudget()!=null) {
				bDepartement.setRefBudget(vo.getRefBudget());
			}
			if(vo.getRefDepartement()!=null) {
				bDepartement.setRefDepartement(vo.getRefDepartement());
			}
			if(vo.getId()!=null) {
				bDepartement.setId(vo.getId());
			}
			if(vo.getReference()!=null) {
				bDepartement.setReference(vo.getReference());
			}
			return bDepartement;
		}
	}
	
	
	public BudgetDepartementVo toVo(BudgetDepartement bDepartement) {
		if(bDepartement==null) {
		return null;
		}
		else {
			BudgetDepartementVo vo = new BudgetDepartementVo();
			if(bDepartement.getMontantFonctionement() != null) {
				vo.setMontantFonctionement(bDepartement.getMontantFonctionement().toString());
			}
			
			if(bDepartement.getMontantFonctionementRestant()!=null) {
				vo.setMontantFonctionementRestant(bDepartement.getMontantFonctionementRestant().toString());
			}
			if(bDepartement.getMontantInvestisement() != null) {
				vo.setMontantInvestisement(bDepartement.getMontantInvestisement().toString());
			}
			
			if(bDepartement.getMontantInvestisementRestant()!=null) {
				vo.setMontantInvestisementRestant(bDepartement.getMontantInvestisementRestant().toString());
			}
			if(bDepartement.getMontantTotal()!=null) {
				vo.setMontantTotal(bDepartement.getMontantTotal().toString());
			}
			if(bDepartement.getRefBudget()!=null) {
				vo.setRefBudget(bDepartement.getRefBudget());
			}
			if(bDepartement.getRefDepartement()!=null) {
				vo.setRefDepartement(bDepartement.getRefDepartement());
			}
			if(bDepartement.getId()!=null) {
				vo.setId(bDepartement.getId());
			}
			if(bDepartement.getReference()!=null) {
				vo.setReference(bDepartement.getReference());
			}
			return vo;
		}
	}
	
	
	////////les list 
	public List<BudgetDepartement> toListBean(List<BudgetDepartementVo> vos) {
		if(vos==null || vos.isEmpty()) {
		return null;
		}
		
		else {
			List<BudgetDepartement> bDepartements = new ArrayList<BudgetDepartement>();
			for(int i=0;i<vos.size();i++) {
				bDepartements.add(toBean(vos.get(i)));
			}
			return bDepartements;
		}
	}
	
	
	public List<BudgetDepartementVo> toListVo(List<BudgetDepartement> bDepartements) {
		if(bDepartements==null || bDepartements.isEmpty()) {
		return null;
		}
		else {
			
			List<BudgetDepartementVo> vos = new CopyOnWriteArrayList<BudgetDepartementVo>();
			for(int j=0;j<bDepartements.size();j++) {
				vos.add(toVo(bDepartements.get(j)));
			}
			return vos;
		}
	}
}
