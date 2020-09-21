package com.zy.service;

import java.util.ArrayList;

import com.zy.dao.ContractDao;
import com.zy.model.Contract;

public class ContractServiceImpl implements ContractService {
	ContractDao dao=new ContractDao();
	@Override
	public ArrayList<Contract> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public Contract findInfoById(int cid) {
		return dao.dindInfoById(cid);
	}
	@Override
	public int add(Contract contract) {
		
		return dao.add(contract);
	}
	@Override
	public Contract findContractById(int cid) {
		return dao.findContractById(cid);
	}
	@Override
	public void updateContract(Contract contract) {
		dao.updateContract(contract);
		
	}
	@Override
	public void delContractById(int cid) {
		dao.delContractById(cid);
	}
	@Override
	public ArrayList<Contract> findContractAndWords(String field, String keywords) {
		return dao.findContractAndWords(field,keywords);
	}

}
