package Questions.Inventory_Management.strategy;

import java.util.List;

import Questions.Inventory_Management.models.Warehouse;

public class NearestWarehouseSelectionStrategy extends WarehouseSelectionStrategy{

    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouseList) {
        return warehouseList.get(0);
    }

}
