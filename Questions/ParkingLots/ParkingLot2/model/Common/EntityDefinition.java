package Questions.ParkingLots.ParkingLot2.model.Common;

import java.util.Date;

public class EntityDefinition {

    private String id;
    private Date createdAt;
    private Date updatedAt;

    public EntityDefinition(String id, Date createdAt, Date updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
