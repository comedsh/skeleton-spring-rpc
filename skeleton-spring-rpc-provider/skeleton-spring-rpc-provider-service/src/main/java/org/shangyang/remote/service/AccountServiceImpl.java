package org.shangyang.remote.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.commons.lang.StringUtils;
import org.shangyang.remote.dto.Account;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

// 直接将 AccountServiceImpl 暴露成 End Point. 如果要直接使用实现类，而不通过代理，那么需要指定 endpointInterface.
@WebService(serviceName="AccountService2", endpointInterface="org.shangyang.remote.service.IAccountService")
@Service("serviceAccount")
public class AccountServiceImpl implements IAccountService{

	List<Account> accounts = new ArrayList<Account>(5);
	
	public void insertAccount(Account account) {
		
		Assert.notNull(account.getCustomer());
		
		if( account.getCustomer() != null ){
		
			accounts.add( account );
		
		}
		
	}

	public void insertAccount(String accountName) {

		Account account = new Account( accountName );
		
		accounts.add(account);
		
	}	
	
	public List<Account> getAccounts(String name) {
		
		List<Account> accounts = new ArrayList<Account>(5);
		
		for( Account a : this.accounts ){
		
			if( StringUtils.equals(a.getName(), name)){
				
				accounts.add( a );
				
			}
			
		}
		
		return accounts;
	
	}

	public void clear() {
		
		accounts.clear();
		
	}

}
