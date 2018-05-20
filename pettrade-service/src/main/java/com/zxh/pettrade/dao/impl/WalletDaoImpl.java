package com.zxh.pettrade.dao.impl;

import org.springframework.stereotype.Repository;

import com.zxh.pettrade.dao.WalletDao;
import com.zxh.pettrade.entity.Wallet;

@Repository("walletDao")
public class WalletDaoImpl extends BaseDaoImpl<Wallet> implements WalletDao{

}
