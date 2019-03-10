package com.example.dbtest.models;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public int addByAcademy(int a, int b){
        if(b == 0)
            throw new IllegalArgumentException();

        return a + b + 2;
    }


    public int createNewUserAndGetId(UserEntity userEntity){
        //todo logika zapisywania do bazy i zwracania ID
        //todo PS. metoda save na repo zwraca i nowo utworzonego obiektu
        return userEntity.getId();
    }
}
