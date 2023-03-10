package com.example.geektrust.expenseManagement.models;

import com.example.geektrust.expenseManagement.Exceptions.RoomCapacityFullException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Room {
    private static Room single_room_instance = null;
    private static Object mutex = new Object();

    private Room(){};

    public static Room getInstance()
    {
        if(single_room_instance == null)
        {
            synchronized (mutex)
            {
                if(single_room_instance==null)
                {
                    single_room_instance = new Room();
                }
            }
        }

        return  single_room_instance;
    }

    private List<Member> members;

    public void addNewMember(Member member) throws RoomCapacityFullException {
        final int MAX_MEMBERS_COUNT = 3;
        if(members.size() == MAX_MEMBERS_COUNT)
        {
            throw new RoomCapacityFullException();
        }
        members.add(member);
    }

    public void removeMember(Member member)
    {

    }

    public Member getMemberByName(String name)
    {
        throw new NotImplementedException();
    }

    public List<Member> getAllMembers()
    {
        return members;
    }
}
