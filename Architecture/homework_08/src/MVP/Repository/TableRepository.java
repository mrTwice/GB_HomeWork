package MVP.Repository;

import MVP.Base.Table;

import java.util.ArrayList;
import java.util.List;

public class TableRepository {
    private static TableRepository tableRepository;
    private List<Table> tables;

    private TableRepository(){
        this.tables = new ArrayList<>();
        tables.add(new Table(1, 2));
        tables.add(new Table(1, 4));
        tables.add(new Table(2, 2));
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
