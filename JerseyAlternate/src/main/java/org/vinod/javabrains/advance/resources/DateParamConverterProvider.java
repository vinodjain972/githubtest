package org.vinod.javabrains.advance.resources;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
@Provider
public class DateParamConverterProvider implements ParamConverterProvider {

	
	public <T> ParamConverter<T> getConverter( final Class<T> rawType, Type genericType, Annotation[] annotations) {
		if (rawType.getName().equals(MyDate.class.getName())) {
			return new ParamConverter<T>() {
				public T fromString(String date) {
					Calendar calendar = Calendar.getInstance();
					if (date.equalsIgnoreCase("tommorow"))
						calendar.add(Calendar.DATE, 1);
					else if (date.equalsIgnoreCase("yesterday"))
						calendar.add(Calendar.DATE, -1);

					MyDate myDate = new MyDate();
					myDate.setDay(calendar.get(Calendar.DATE));
					myDate.setMonth(calendar.get(Calendar.MONTH));
					myDate.setYear(calendar.get(Calendar.YEAR));
					return rawType.cast(myDate);

				}
				public String toString(T myBean) {
					if (myBean == null) {
						return null;
					}
					return myBean.toString();
				}

			};
		}

		return null;

	}
	
}
