package com.open.source.platform.test;

import com.open.source.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class DITestService {

   private int sum;


    public DITestService(int sum) {
        this.sum = sum;
    }

    public void printName() {
        System.out.println(sum);
    }
}
