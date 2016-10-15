package com.ebp.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ShoppingCart {
	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	private double prices;
	
	public ShoppingCart() {
		super();
	}

	public ShoppingCart(Map<Integer, CartItem> map, double prices) {
		super();
		this.map = map;
		this.prices = prices;
	}

	public Map<Integer, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}

	public double getPrices() {
		Set<Entry<Integer,CartItem>> set = map.entrySet();
		double totalprice = 0;
		for (Entry<Integer, CartItem> entry : set) {
			totalprice += entry.getValue().getPrice();
		}
		this.prices = totalprice;
		System.out.println(totalprice);
		//round（参数）是最接近参数的整数是几,通俗讲就是四舍五入.
		//以下是四舍五入并保留2位小数
		this.prices = Math.round(prices * 100) / 100.0;	
		return prices;
	}

	
	
}
