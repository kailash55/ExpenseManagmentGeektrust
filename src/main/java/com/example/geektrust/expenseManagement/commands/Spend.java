package com.example.geektrust.expenseManagement.commands;

import com.example.geektrust.expenseManagement.dto.Response;
import com.example.geektrust.expenseManagement.models.Member;
import com.example.geektrust.expenseManagement.models.Room;
import javafx.scene.media.MediaMarkerEvent;

import java.util.ArrayList;
import java.util.List;

public class Spend implements Command{
    private final String COMMAND_STRING = "SPEND";
    private String spendByMember;
    private List<String> membersToSplit = new ArrayList<String>() {};
    private int amount;


    private void parse(String command)
    {
        String[] commandParts = command.split(" ");
        amount = Integer.parseInt(commandParts[1]);
        spendByMember = commandParts[2];
        membersToSplit.add(commandParts[3]);

        if(commandParts.length == 5) // if there are two members to split the command length will be 5
        {
            membersToSplit.add(commandParts[4]);
        }
    }

    @Override
    public Response execute(String command) {
        parse(command);

        Member spender = Room.getInstance().getMemberByName(spendByMember);
        List<Member> borrowers = new ArrayList<Member>();
        for(String memberName : membersToSplit)
        {
            Member borrower = Room.getInstance().getMemberByName(memberName);
            borrowers.add(borrower);
        }
        spender.addExpense(amount, borrowers);

        Response response = new Response();
        response.commandType = COMMAND_STRING;
        response.isSuccess = true;
        return response;
    }

    @Override
    public boolean matches(String command) {
        return false;
    }
}
