package com.eventstream.payement.services;

import com.eventstream.payement.exceptions.BalanceNotSufficientException;
import com.eventstream.payement.exceptions.UserNotFoundException;
import com.eventstream.payement.models.Account;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
public  class AccountServiceImpl implements AccountService {

    private  List<Account> accounts;

    @PostConstruct
    public void initData(){
      accounts  = List.of(
                Account.builder().userId(2).balance(300).build(),
                Account.builder().userId(1).balance(200).build(),
                Account.builder().userId(3).balance(100).build()
        );
    }



    @Override
    public void payOrder(int userId, double totalPrice){
      var userAccount = accounts.stream().filter(account -> account.getUserId()==userId)
                                                  .findFirst()
                                                  .orElseThrow(()-> new UserNotFoundException("user with id "+ userId+" not exist"));
        if(userAccount.getBalance()<totalPrice)
            throw new BalanceNotSufficientException("balance not sufficient for user "+userAccount.getUserId());
        userAccount.setBalance(userAccount.getBalance()-totalPrice);

    }
}
