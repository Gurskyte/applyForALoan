/*
Nereikalingas, nes AccRepos klasėje nėra jokių metodų.


package com.loan.repository;

import com.loan.model.Account;
import com.loan.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static com.loan.TestConstants.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    //TestEntityManager to insert an account in the DB and reading it via the find by name API.
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    AccountRepository accountRepository;

    //Test cases
    @Test
    public void whenFindByName_thenReturnAccount() {
        //given
        Account petras = new Account(PERSONAL_NUMBER, NAME, LAST_NAME);
        entityManager.persist(petras);
        entityManager.flush();

        //when
        //Account found = accountRepository.findFirstByName(petras.getName());

        //then
      //  assertThat(found.getName()).isEqualTo(petras.getName());


    }


}*/
