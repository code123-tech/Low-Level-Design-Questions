package Questions.ParkingLots.ParkingLot2.model.Common;

import java.util.Date;

public class EntityDefinition {

    private String id;
    private Date createdAt;
    private Date updatedAt;

    public EntityDefinition(String id) {
        this.id = id;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
