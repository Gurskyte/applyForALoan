package com.loan.service;

import com.loan.model.Account;
import com.loan.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    //TestEntityManager to insert an Employee in the DB and reading it via the find by name API.
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    AccountRepository accountRepository;

    //Test cases
/*    @Test
    public void whenFindByName_thenReturnAccount() {
        //given
        Account alex = new Account("alex", "lame");
        entityManager.persist(alex);
        entityManager.flush();

        //when
        Account found = accountRepository.findFirstByName(alex.getName());

        //then
        assertThat(found.getName()).isEqualTo(alex.getName());


    }*/


}
