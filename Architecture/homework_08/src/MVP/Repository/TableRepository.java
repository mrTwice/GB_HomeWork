package MVP.Repository;

import Base.Table;

import java.util.List;

public class TableRepository {
    private static TableRepository tableRepository;
    private List<Table> tables;

    private TableRepository(){
        tableRepository = getTableRepository();
    }

    public static TableRepository getTableRepository(){
        if (tableRepository == null)
            tableRepository = new TableRepository();
        return tableRepository;
    }

    public List<Table> getAllTables(){
        return tables;
    }
}
