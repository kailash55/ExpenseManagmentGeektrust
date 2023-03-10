package com.example.geektrust.expenseManagement.utils;

import com.example.geektrust.expenseManagement.dto.ShowDueResponse;

import java.util.List;

public class ShowDuePrinter implements IResponsePrinter{

    List<ShowDueResponse> response;

    public ShowDuePrinter(Object object)
    {
        response = (List<ShowDueResponse>) object;
    }


    @Override
    public void printResponse() {

    }
}
