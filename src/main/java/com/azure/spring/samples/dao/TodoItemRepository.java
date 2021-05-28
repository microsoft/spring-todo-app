// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.samples.dao;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.samples.model.TodoItem;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends CosmosRepository<TodoItem, String> {
}
