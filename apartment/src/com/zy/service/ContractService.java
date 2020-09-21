package com.zy.service;

import java.util.ArrayList;

import com.zy.model.Contract;

public interface ContractService {

	ArrayList<Contract> findAll();

	Contract findInfoById(int cid);

	int add(Contract contract);

	Contract findContractById(int cid);

	void updateContract(Contract contract);

	void delContractById(int cid);

	ArrayList<Contract> findContractAndWords(String field, String keywords);

}
