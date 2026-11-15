package com.example;

import java.util.List;

//Лев Алекс из мультфильма "Мадагаскар"
public class AlexLion extends Lion {

    //нам не нужно писать Feline feline, тк AlexLion наследник Lion, и мы передаем через super аргументы, на основе которых отработает конструктор родителя(Lion) и AlexLion будет иметь поля feline и hasMane, которые для него подготовит Lion

    public AlexLion(Feline feline) throws Exception{
        super("Самец", feline);
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens(){
        return 0;
    }
}
