package com.kq;

import com.kq.entity.Account;
import com.kq.mapper.AccountMapper;
import org.apache.ibatis.submitted.not_null_column.Base;
import org.junit.Test;

import java.util.List;

/**
 * AccountTest
 *
 * @author kq
 * @date 2019-01-26
 */
public class AccountTest  extends BaseTest{


    @Test
    public void getLists() throws Exception {
        AccountMapper accountMapper = sqlSessionManager.getMapper(AccountMapper.class);


        List<Account> list =  accountMapper.getLists();

        System.out.println("list size = "+list);

    }



}
