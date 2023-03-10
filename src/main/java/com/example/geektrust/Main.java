package com.example.geektrust;

import com.example.geektrust.expenseManagement.commands.CommandRegistry;
import com.example.geektrust.expenseManagement.dto.Response;
import com.example.geektrust.expenseManagement.models.Room;
import com.example.geektrust.expenseManagement.utils.IResponsePrinter;
import com.example.geektrust.expenseManagement.utils.ResponsePrinterFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        while(true)
        {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            String commandInput = reader.readLine();

            Response response = CommandRegistry.getInstance().execute(commandInput);
            IResponsePrinter responsePrinter = ResponsePrinterFactory.getResponsePrinter(response);
            responsePrinter.printResponse();
        }
	}
}
