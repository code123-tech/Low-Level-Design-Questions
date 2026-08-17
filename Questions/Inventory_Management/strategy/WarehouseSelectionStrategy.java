package Questions.Inventory_Management.strategy;

import java.util.List;

import Questions.Inventory_Management.models.Warehouse;

public abstract class WarehouseSelectionStrategy {

    public abstract Warehouse selectWarehouse(List<Warehouse> warehouseList);
}
