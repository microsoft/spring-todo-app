// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.samples.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodoItemTest {

    @Test
    public void testEqualsObject() {
        final TodoItem itemA = new TodoItem();
        final TodoItem itemB1 = new TodoItem("B", "Item B", "Owner of Item B");
        final TodoItem itemB2 = new TodoItem("B", "Item B", "Owner of Item B");
        final Object nonTodoItem = new Object();
        Assertions.assertTrue(itemA.equals(itemA));
        Assertions.assertFalse(itemA.equals(null));
        Assertions.assertFalse(itemA.equals(nonTodoItem));
        Assertions.assertFalse(itemA.equals(itemB1));
        Assertions.assertTrue(itemB1.equals(itemB2));
        Assertions.assertFalse(itemB1.equals(itemA));
    }

}
