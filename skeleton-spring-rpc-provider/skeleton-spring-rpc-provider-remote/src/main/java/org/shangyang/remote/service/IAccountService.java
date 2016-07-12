package org.shangyang.remote.service;

import java.util.List;

import javax.jws.WebService;

import org.shangyang.remote.dto.Account;

@WebService
public interface IAccountService {

    public void insertAccount(Account account);

    public List<Account> getAccounts(String name);	
    
    public void clear();
	
}
