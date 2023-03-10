package com.example.geektrust.expenseManagement.utils;

import com.example.geektrust.expenseManagement.dto.Response;

public class ResponsePrinterFactory {

    public static IResponsePrinter getResponsePrinter(Response response)
    {
        return new ShowDuePrinter(response.responseObject);
    }
}
