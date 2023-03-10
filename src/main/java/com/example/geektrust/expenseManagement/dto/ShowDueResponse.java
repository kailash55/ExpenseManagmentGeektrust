package com.example.geektrust.expenseManagement.dto;

import com.example.geektrust.expenseManagement.models.Member;

public class ShowDueResponse {
    Member member;
    int amount;

    public ShowDueResponse(Member member, int amount)
    {
        this.member = member;
        this.amount = amount;
    }
}
