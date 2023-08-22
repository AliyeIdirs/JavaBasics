package com.unitedcoder.lambdaandstream;
import com.unitedcoder.cubecartautomation.LoginUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<LoginUser> loginUsers= new ArrayList<>();
                loginUsers.add(new LoginUser("user1","123"));
                loginUsers.add(new LoginUser("user3","My1"));
                loginUsers.add(new LoginUser("user2","43A"));

        List<LoginUser> sortedList=loginUsers.stream().sorted(Comparator.comparing(LoginUser::getUserName)).collect(Collectors.toList());
        System.out.println(sortedList);

        loginUsers.stream().filter(user->user.getUserName().equals("user1")).forEach(System.out::println);


    }
}
