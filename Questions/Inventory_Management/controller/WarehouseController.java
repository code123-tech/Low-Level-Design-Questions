package Questions.Inventory_Management.controller;

import java.util.List;

import Questions.Inventory_Management.models.Warehouse;
import Questions.Inventory_Management.strategy.WarehouseSelectionStrategy;

public class WarehouseController {

    List<Warehouse> warehouseList;
    WarehouseSelectionStrategy warehouseSelectionStrategy;

    WarehouseController(List<Warehouse> warehouseList, WarehouseSelectionStrategy warehouseSelectionStrategy) {
        this.warehouseList = warehouseList;
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
    }

    public void addWarehouse(Warehouse warehouse){
        warehouseList.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse){
        warehouseList.remove(warehouse);
    }

    public Warehouse selectWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy){
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
        return warehouseSelectionStrategy.selectWarehouse(warehouseList);
    }

}
