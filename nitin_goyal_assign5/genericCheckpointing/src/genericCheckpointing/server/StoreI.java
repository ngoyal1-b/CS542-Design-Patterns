package genericCheckpointing.server;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MySpecialTypes;
import genericCheckpointing.util.Results;

public interface StoreI extends StoreRestoreI {
    void writeObj(MyAllTypesFirst aRecord, String wireFormat,Results results);
    void writeObj(MySpecialTypes sRecord, String wireFormat,Results results);
}