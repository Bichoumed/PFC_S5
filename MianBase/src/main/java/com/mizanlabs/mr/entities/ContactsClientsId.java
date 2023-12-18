package com.mizanlabs.mr.entities;

import jakarta.persistence.*;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Embeddable
public class ContactsClientsId implements Serializable {
    // Fields
    private Long contactId;
    private Long clientId; // This line was missing

    // Default constructor is needed by JPA
    public ContactsClientsId() {
    }

    // Constructor with fields
    public ContactsClientsId(Long contactId, Long clientId) {
        this.contactId = contactId;
        this.clientId = clientId;
    }

    // Getters and setters
    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    // hashCode and equals must be implemented for composite keys
    @Override
    public int hashCode() {
        // Use a consistent algorithm to calculate hashCode
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contactId == null) ? 0 : contactId.hashCode());
        result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // Standard equals implementation
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContactsClientsId other = (ContactsClientsId) obj;
        if (contactId == null) {
            if (other.contactId != null)
                return false;
        } else if (!contactId.equals(other.contactId))
            return false;
        if (clientId == null) {
            if (other.clientId != null)
                return false;
        } else if (!clientId.equals(other.clientId))
            return false;
        return true;
    }
}
