package com.example.geektrust.expenseManagement.commands;

import com.example.geektrust.expenseManagement.Exceptions.RoomCapacityFullException;
import com.example.geektrust.expenseManagement.dto.Response;

public interface Command {
    Response execute(String command) throws RoomCapacityFullException;
    boolean matches(String command);
}
