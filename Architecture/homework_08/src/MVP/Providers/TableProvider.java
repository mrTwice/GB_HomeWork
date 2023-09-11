package MVP.Providers;

import MVP.Base.Guest;
import MVP.Base.Table;
import MVP.Repository.TableRepository;

import java.util.Date;
import java.util.List;

public class TableProvider {
    private TableRepository tableRepository;

    public TableProvider() {
        this.tableRepository = TableRepository.getTableRepository();
    }

    public List<Table> getTablesByHallID(int idHall){
        List<Table> allTables = tableRepository.getAllTables();
        List<Table> hallTables = null;
        for (Table table: allTables) {
            if(table.getIdHall() == idHall)
                hallTables.add(table);
        }
        return hallTables;
    }

    public boolean tableIsBusy(int idTable, int idHall){
        boolean isBusy = true;
        List<Table> hallTables = getTablesByHallID(idHall);
        for (Table table: hallTables) {
            if (table.getId() == idTable)
                isBusy = table.getTableStatus();
        }
        return isBusy;
    }

    public Table findTableByID(int idTable, int idHall){
        Table table = null;
        List<Table> hallTables = getTablesByHallID(idHall);
        for (Table tableInList: hallTables) {
            if (tableInList.getId() == idTable)
                table = tableInList;
        }
        return table;
    }

    public Table getTableByID(int idTable, int idHall ){
        Table table = null;
        List<Table> tables = getTablesByHallID(idHall);
        for (Table tableInList: tables) {
            if ((idTable == tableInList.getId()))
                table = tableInList;
        }
        return table;
    }

    public boolean reserveTable(int idHall, int idTable, Date dateReserve, Guest guest){
        if(tableIsBusy(idTable, idHall)){
            return false;
        }
        Table table = findTableByID(idTable, idHall);
        table.setTableStatusIsBusy();
        table.setGuest(guest);
        table.setReserveDate(dateReserve);
        return true;
    }

    public boolean unReserveTable(int idHall, int idTable){
        if (tableIsBusy(idTable, idHall)){
            Table table = findTableByID(idTable, idHall);
            table.setTableStatusIsFree();
            table.setReserveDate(null);
            table.setGuest(null);
            return true;
        }
        return false;
    }

}
