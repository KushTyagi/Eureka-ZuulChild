package com.craterzone.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class DynamicObjectMapper<T> {

	public static Object convertObjectToDao(Object dtoObj, Object daoObj) {
		try {
			String[] str1 = new String[] {"name","price","product_code"};
			for(int i=0; i<=str1.length-1; i++) {
				 PropertyDescriptor pd = new PropertyDescriptor(str1[i], dtoObj.getClass());
				 Method getter = pd.getReadMethod();
				 PropertyDescriptor pdwrite = new PropertyDescriptor(str1[i],daoObj.getClass());
			     Method setter = pdwrite.getWriteMethod();	
				 setter.invoke(daoObj, getter.invoke(dtoObj));
				 System.out.println("Set data :"+daoObj.toString()); 
		    }
			return daoObj;
			}catch(Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	public static Object convertObjectToDto(Object daoObj, Object dtoObj) {
		try {
			String[] str1 = new String[] {"name","price","product_code"};
			for(int i=0; i<=str1.length-1; i++) {
				 PropertyDescriptor pd = new PropertyDescriptor(str1[i], daoObj.getClass());
				 Method getter = pd.getReadMethod();
				 PropertyDescriptor pdwrite = new PropertyDescriptor(str1[i],dtoObj.getClass());
			     Method setter = pdwrite.getWriteMethod();	
				 setter.invoke(dtoObj, getter.invoke(daoObj));
				 System.out.println("Set data :"+daoObj.toString()); 
				 return daoObj;
		    }
			}catch(Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
}
