package com.example.geektrust.expenseManagement.models;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Member {
    private String name;
    private List<Expense> expenses;
    private List<Clearance> clearances;

    public Member(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public List<Expense> getExpenses()
    {
        return this.expenses;
    }

    public void addExpense(int amount, List<Member> membersToSplit)
    {

    }

    public void clearDue(int amount, Member member)
    {

    }

    public int getDueAmountFor(Member member)
    {
        throw new NotImplementedException();
    }

    public int getDueAmountFor(List<Member> members)
    {
        throw new NotImplementedException();
    }
}
