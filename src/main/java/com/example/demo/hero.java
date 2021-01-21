package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class hero {
    int atc;
    int hp;

    int skillname(String name) {
        System.out.println("这个技能的名字是" + name);
        return 1;
    }

    public int getAtc() {
        return atc;
    }

    public void setAtc(int atc) {
        this.atc = atc;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public static hero getLina() {
        return Lina;
    }

    public static void setLina(hero lina) {
        Lina = lina;
    }

    public static hero getSven() {
        return Sven;
    }

    public static void setSven(hero sven) {
        Sven = sven;
    }

    public static hero getLich() {
        return Lich;
    }

    public static void setLich(hero lich) {
        Lich = lich;
    }

    public static hero getNevermore() {
        return Nevermore;
    }

    public static void setNevermore(hero nevermore) {
        Nevermore = nevermore;
    }

    void attack(hero who_attack, hero target) {
        target.hp = target.hp - who_attack.atc;
        who_attack.hp = who_attack.hp - target.atc;
        System.out.println(who_attack + "对" + target + "执行了攻击");
        System.out.println(who_attack + "的剩余血量：" + who_attack.hp);
        System.out.println(target + "的剩余血量：" + Lina.hp);
    }

    public hero(String name) {
        System.out.println("这个英雄的名字是" + name);
    }


    static hero Lina = new hero("Lina");
    static hero Sven = new hero("Sven");
    static hero Lich = new hero("Lich");
    static hero Nevermore = new hero("Nevermore");

    public void test() {
        hero Lina = new hero("Lina");
    }

    static class TestHero extends hero {
        int name;
        int age;

        public TestHero(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "TestHero{" +
                    "atc=" + atc +
                    ", hp=" + hp +
                    ", name=" + name +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Sven.hp = 5;
        Sven.atc = 4;
        Lina.hp = 5;
        Lina.atc = 3;
        Sven.attack(Sven, Lina);
        TestHero testHero = new TestHero("章三");
        testHero.atc = 11;
        testHero.hp = 11;
        System.out.println(testHero);
    }
}


