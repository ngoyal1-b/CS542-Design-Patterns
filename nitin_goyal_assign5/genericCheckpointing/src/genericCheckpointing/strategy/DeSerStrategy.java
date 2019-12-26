package genericCheckpointing.strategy;

import java.lang.reflect.InvocationTargetException;

import genericCheckpointing.util.FileProcessor;

public interface DeSerStrategy {
	Object processInput(FileProcessor f) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

}
