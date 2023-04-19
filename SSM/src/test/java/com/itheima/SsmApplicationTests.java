package com.itheima;

import com.fasterxml.jackson.datatype.jsr310.deser.YearDeserializer;
import com.itheima.dao.Book;
import com.itheima.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;

@SpringBootTest
class SsmApplicationTests {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void selectTest() {
        System.out.println(bookMapper.getById(1));
    }

    @Test
    void insertTest(){
        Year year = Year.now();
        Book book = new Book(null, "唐吉可德", "大仲马", 120.11f, year, "好看的书", 10);
        int res = bookMapper.insertBook(book);
        System.out.println("res " + res);
    }

    @Test
    void updateTest(){
        int res = bookMapper.updateBookByName("唐吉可德", 7);
        System.out.println(res);
    }

    @Test
    void deleteTest1(){
        int res = bookMapper.deleteById(7);
        System.out.println(res);
    }

    @Test
    void deteleTest2(){
        int res = bookMapper.deleteByName("唐吉可德");
        System.out.println(res);
    }

    @Test
    public void test(){
        DateFormat df = new SimpleDateFormat("yyyy");

        Date date = null;
        try{
            date = df.parse("2011");
        }catch(ParseException e){

        }

        System.out.println("date " + date);
    }

    @Test
    public void test2(){
        Year year = Year.of(2011);
        System.out.println(year.getClass());                // class java.time.Year
        System.out.println(Year.class);                     // class java.time.Year
        System.out.println(year.getClass() == Year.class);   // true
        System.out.println(year);
    }
}
