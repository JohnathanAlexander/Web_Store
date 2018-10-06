package com.portfolio.onlineStore.service;

import java.util.List;

import com.portfolio.onlineStore.common.Storage;

public abstract class Service{
	public abstract Object retrieve(List<Object> o);
	
	protected Storage storage = new Storage();
	
}
