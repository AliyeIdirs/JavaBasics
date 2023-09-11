package regressionsuit.cubecartobjects;

import java.util.List;

public class CustomerGroupObject {
    private String groupName;
    private String groupDescription;

    public CustomerGroupObject(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }
}
