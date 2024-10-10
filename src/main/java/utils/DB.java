package main.java.utils;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import main.java.tukano.api.Result;
import org.hibernate.Session;

import main.java.tukano.api.Result;

public class DB {

	public static <T> List<T> sql(String query, Class<T> clazz) {
		return main.java.utils.Hibernate.getInstance().sql(query, clazz);
	}
	
	public static <T> List<T> sql(Class<T> clazz, String fmt, Object ... args) {
		return main.java.utils.Hibernate.getInstance().sql(String.format(fmt, args), clazz);
	}
	
	public static <T> Result<T> getOne(String id, Class<T> clazz) {
		return main.java.utils.Hibernate.getInstance().getOne(id, clazz);
	}
	
	public static <T> Result<T> deleteOne(T obj) {
		return main.java.utils.Hibernate.getInstance().deleteOne(obj);
	}
	
	public static <T> Result<T> updateOne(T obj) {
		return main.java.utils.Hibernate.getInstance().updateOne(obj);
	}
	
	public static <T> Result<T> insertOne( T obj) {
		return Result.errorOrValue(main.java.utils.Hibernate.getInstance().persistOne(obj), obj);
	}
	
	public static <T> Result<Void> transaction(Consumer<Session> c) {
		return main.java.utils.Hibernate.getInstance().execute( c::accept );
	}
	
	public static <T> Result<T> transaction( Function<Session, Result<T>> func) {
		return main.java.utils.Hibernate.getInstance().execute( func );
	}
}
