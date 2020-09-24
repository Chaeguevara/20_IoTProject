package com.frame;

import java.util.ArrayList;

public interface Search<K1,K2,V> {
	public ArrayList<V> search(K1 k);
	public ArrayList<V> search(K1 k1,K2 k2);
}
