package com.example.finaltest.assistance;

import org.springframework.stereotype.Component;

@Component
public class ChuanHoaTenAssistance {
    public String chuanHoaTen(String name){
        name = name.trim().toLowerCase();
        while (name.contains("  ")){
            name = name.replace("  ", " ");
        }
        return name;
    }
}
