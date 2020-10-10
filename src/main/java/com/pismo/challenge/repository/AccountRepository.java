package com.pismo.challenge.repository;

import com.pismo.challenge.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
