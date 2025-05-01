package strategy;

import java.util.List;

import models.Warehouse;

public class NearestWarehouseSelectionStrategy extends WarehouseSelectionStrategy{

    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouseList) {
        return warehouseList.get(0);
    }

}
