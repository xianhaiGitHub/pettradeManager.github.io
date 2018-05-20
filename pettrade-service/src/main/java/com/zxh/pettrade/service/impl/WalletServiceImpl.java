package com.zxh.pettrade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxh.pettrade.dao.WalletDao;
import com.zxh.pettrade.entity.Wallet;
import com.zxh.pettrade.service.WalletService;



@Transactional
@Service("walletService")
public class WalletServiceImpl implements WalletService {

	@Autowired
    private WalletDao walletDao;
	
	/**
	 * 更新钱包余额
	 */
	@Override
	public void update(Wallet wallet) {
		walletDao.update(wallet);
	}

}
