package genericCheckpointing.strategy;

import genericCheckpointing.util.Results;
import genericCheckpointing.util.SerializableObject;

public interface SerStrategy {
	void processInput(SerializableObject sObject,Results results);
}
