package org.shangyang.remote.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.shangyang.remote.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@WebService(serviceName="AccountService")
@Component
public class AccountServiceEndpoint {

    @Autowired
    private IAccountService biz;

    @WebMethod
    public void insertAccount(Account acc) {
        biz.insertAccount(acc);
    }

    @WebMethod
    public List<Account> getAccounts(String name) {
    	
        return biz.getAccounts(name);
        
    }
    
    @WebMethod
    public void clear(){
    	biz.clear();
    }
	
}
