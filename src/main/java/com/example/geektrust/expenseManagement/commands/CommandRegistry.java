package com.example.geektrust.expenseManagement.commands;

import com.example.geektrust.expenseManagement.dto.Response;

import java.util.HashSet;
import java.util.Set;

public class CommandRegistry {
    Set<Command> commands = new HashSet<>();

    private static CommandRegistry single_command_registry_instance = null;
    private static Object mutex = new Object();

    private CommandRegistry()
    {

    };

    public static CommandRegistry getInstance()
    {
        if(single_command_registry_instance == null)
        {
            synchronized (mutex)
            {
                if (single_command_registry_instance == null)
                {
                    single_command_registry_instance = new CommandRegistry();
                }
            }
        }
        return single_command_registry_instance;
    }

    public Response execute(String commandInput)
    {
        Response response = null;
        for(Command command : commands)
        {
            if(command.matches(commandInput))
                response = command.execute(commandInput);
        }

        return response;
    }
}
