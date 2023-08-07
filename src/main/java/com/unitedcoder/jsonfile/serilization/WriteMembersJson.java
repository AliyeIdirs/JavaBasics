package com.unitedcoder.jsonfile.serilization;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.unitedcoder.jsonfile.serilization.MainJson;
import com.unitedcoder.jsonfile.serilization.Members;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteMembersJson {
    public static void main(String[] args) {
        List<Members> members= new ArrayList<>();
        members.add(new Members("Molecule Man",29,"Dan Jukes"));
        members.add(new Members("Mademe Uppercut",39,"Jane Wilson"));
        members.add(new Members("Eternal Flame",1000000,"Unknown"));

        MainJson mainJson=new MainJson("Super hero squad","Metro City",
                2016,"Super tower",true,members);

        JsonMapper mapper=new JsonMapper();
        try {
            mapper.writeValue(new File("jsonfile/Members.json"),mainJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
