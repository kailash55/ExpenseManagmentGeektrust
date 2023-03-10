package com.example.geektrust.expenseManagement.commands;

import com.example.geektrust.expenseManagement.dto.Response;
import com.example.geektrust.expenseManagement.dto.ShowDueResponse;
import com.example.geektrust.expenseManagement.models.Member;
import com.example.geektrust.expenseManagement.models.Room;

import java.util.ArrayList;
import java.util.List;

public class ShowDues implements Command{
    private final String COMMAND_STRING = "DUES";
    String memberName;

    public void parse(String command)
    {

    }

    @Override
    public Response execute(String command) {
        parse(command);
        Member member = Room.getInstance().getMemberByName(memberName);
        List<Member> allMembers = Room.getInstance().getAllMembers();

        List<ShowDueResponse> responseObjects = new ArrayList<ShowDueResponse>();
        for(Member lender : allMembers)
        {
            if(!lender.getName().equals(member.getName()))
            {
                int dueAmount = member.getDueAmountFor(lender);
                responseObjects.add(new ShowDueResponse(lender, dueAmount));
            }
        }

        Response response = new Response();
        response.isSuccess = true;
        response.responseObject = responseObjects;
        return response;
    }

    @Override
    public boolean matches(String command) {
        return false;
    }
}
