package com.example.dbtest;

import com.example.dbtest.models.MathService;
import com.example.dbtest.models.UserEntity;
import com.example.dbtest.models.repository.VisitRepository;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MathServiceTest {

    @Autowired
    MathService mathService;

    @Mock
    MathService mathServiceMock;

    @Mock
    VisitRepository visitRepository;


    @Test
    public void addByAcademyTest(){
        Assert.assertEquals(6, mathService.addByAcademy(2, 2));
        Assert.assertEquals(0, mathService.addByAcademy(0, -2));
        Assert.assertEquals(-2, mathService.addByAcademy(-2, -2));
        Assert.assertEquals(2, mathService.addByAcademy(-2, 2));
    }

    @Test
    public void shouldAddMethodThrowExceptionWhenBParameterIsZero(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> mathService.addByAcademy(1, 0));
    }

    @Test
    public void shouldAdd(){
        //given
        int a = 10;
        int b = 5;

        //when
        Mockito.when(mathServiceMock.addByAcademy(a, b)).thenReturn(18);

        //then
        Assert.assertEquals(18, mathServiceMock.addByAcademy(a, b));
    }

    @Test
    public void shouldCreateNewUser(){
        //given
        UserEntity userEntity = new UserEntity(1, "Cos");

        //when
        Mockito.when(mathServiceMock.createNewUserAndGetId(userEntity)).thenReturn(1);

        //then
        Assert.assertEquals(1, mathServiceMock.createNewUserAndGetId(userEntity));
    }



}
