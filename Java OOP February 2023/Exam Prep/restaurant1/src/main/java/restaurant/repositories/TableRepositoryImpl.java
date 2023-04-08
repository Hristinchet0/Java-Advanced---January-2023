package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Map<Integer, Table> tables;

    public TableRepositoryImpl() {
        this.tables = new LinkedHashMap<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return tables.values();
    }

    @Override
    public void add(Table entity) {
        tables.put(entity.getTableNumber(), entity);
    }

    @Override
    public Table byNumber(int number) {
        return tables.get(number);
    }
}