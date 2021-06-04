// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.samples.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Container(containerName = "TodoItem")
public class TodoItem {
    @Id
    private String id;
    @PartitionKey
    private String description;
    private String owner;
    private boolean finished;

    public TodoItem() {
    }

    public TodoItem(String id, String description, String owner) {
        this.description = description;
        this.id = id;
        this.owner = owner;
        this.finished = false;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinish(boolean finished) {
        this.finished = finished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TodoItem)) {
            return false;
        }
        final TodoItem group = (TodoItem) o;
        return Objects.equals(this.getDescription(), group.getDescription())
                && Objects.equals(this.getOwner(), group.getOwner())
                && Objects.equals(this.getId(), group.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, id, owner);
    }

    @Override
    public String toString() {
        if (id != null) {
            return id + ": " + description;
        } else {
            return description;
        }
    }
}

