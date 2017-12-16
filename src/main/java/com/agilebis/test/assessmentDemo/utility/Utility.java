package com.agilebis.test.assessmentDemo.utility;

import java.util.LinkedHashMap;
import org.springframework.stereotype.Component;

@Component
public class Utility {

	public boolean isVoid(String str) {
		return (str==null) || str.isEmpty();
	}
	
	public boolean isVoid(LinkedHashMap<Object, Object> list) {
		return (list==null) || list.isEmpty();
	}
}
