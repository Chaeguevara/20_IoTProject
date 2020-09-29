package com.frame;

import org.springframework.stereotype.Service;

@Service
public interface Book<T> {
	public void bookclick(T t);

}
