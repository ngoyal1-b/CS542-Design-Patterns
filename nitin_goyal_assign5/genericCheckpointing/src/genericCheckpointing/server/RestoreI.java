package genericCheckpointing.server;


import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public interface RestoreI extends StoreRestoreI {
    SerializableObject readObj(String input,FileProcessor fp);
}