package com.sandagerdi.translationprojectmanager.Repository;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Jóannes
 */
@DatabaseTable(tableName = "clients")
public class Clients {

    // for QueryBuilder to be able to find the fields
    public static final String ClIENT_NAME_FIELD_NAME = "clientName";
    public static final String CLIENT_CONTACTEMAIL_FIELD_NAME = "clientEmail";
    public static final String CLIENT_PHONE_FIELD_NAME = "clientPhone";
    public static final String CLIENT_CONTACTNAME_FIELD_NAME = "clientContactName";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = ClIENT_NAME_FIELD_NAME, canBeNull = false)
    private String clientName;

    @DatabaseField(columnName = CLIENT_CONTACTEMAIL_FIELD_NAME, canBeNull = false)
    private String clientEmail;

    @DatabaseField(columnName = CLIENT_PHONE_FIELD_NAME, canBeNull = false)
    private String clientPhone;

    @DatabaseField(columnName = CLIENT_CONTACTNAME_FIELD_NAME, canBeNull = false)
    private String clientContactName;

    public Clients() {
        // ORMLite needs a no-arg constructor 
    }

    public Clients(String clientName, String clientEmail, String clientPhone, String clientContactName) {
        this.clientName = clientName;
        this.clientContactName = clientContactName;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
    }

    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientContactName() {
        return clientContactName;
    }

    public void setClientContactName(String clientContactName) {
        this.clientContactName = clientContactName;
    }

    @Override
    public int hashCode() {
        return clientName.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != getClass()) {
            return false;
        }
        return clientName.equals(((Clients) other).clientName);
    }
    
    @Override
    public String toString(){
        return this.clientName;
    }

}
