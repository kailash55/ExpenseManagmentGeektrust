package com.example.geektrust.expenseManagement.commands;

import com.example.geektrust.expenseManagement.Exceptions.RoomCapacityFullException;
import com.example.geektrust.expenseManagement.dto.Response;
import com.example.geektrust.expenseManagement.models.Member;
import com.example.geektrust.expenseManagement.models.Room;

public class MoveIn implements Command{
    private final String COMMAND_STRING = "MOVE_IN";
    private String memberName;

    private void parse(String command)
    {
        String[] commandParts = command.split(" ");
        memberName = commandParts[1];
    }

    @Override
    public Response execute(String command) throws RoomCapacityFullException {
        parse(command);

        Member member = new Member(memberName);
        Room room = Room.getInstance();
        room.addNewMember(member);

        return new Response();
    }

    @Override
    public boolean matches(String command) {
        String[] commandParts = command.split(" ");
        return commandParts[0].equals(COMMAND_STRING);
    }
}
