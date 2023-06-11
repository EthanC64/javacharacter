package Javacharacter;

import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Javacharacter {
    private int atk;
    private int def;
    private int hp;
    private String name;
    private boolean isDead = false;

    Javacharacter(int def, int hp, String name) {
        int randomInt = (int) Math.floor((20.0 * Math.random()));
        this.atk = randomInt;
        this.def = def;
        this.hp = hp;
        this.name = name;
    }

    // public void specialattack(Javacharacter opponent) {
    // opponent.def = 0;
    // opponent.hp = opponent.hp - this.atk;
    // System.out.println(this.name + " uses special attack!" + opponent.name + "
    // takes " + this.atk + " damage!");
    // }

    // public void attack(Javacharacter opponent) {
    // int randomAttack = (int) Math.floor((20.0 * Math.random()));
    // System.out.println(this.name + " attacks " + opponent.name);
    // if (opponent.def < randomAttack) {
    // opponent.hp = opponent.hp + opponent.def - randomAttack;
    // }
    // }
    public void attack(Javacharacter opponent) {
        int randomAttack = (int) Math.floor((20.0 * Math.random()));
        int randomChoice = (int) Math.floor((2 * Math.random())); // Generate a random choice between 0 and 1

        if (randomChoice == 0) {
            // Regular Attack
            System.out.println(this.name + " performs a regular attack on " + opponent.name);
            if (opponent.def < randomAttack) {
                opponent.hp = opponent.hp + opponent.def - randomAttack;
            }
        } else {
            // Special Attack
            System.out.println(this.name + " uses a special attack on " + opponent.name);
            opponent.def = 0;
            opponent.hp = opponent.hp - randomAttack;
            System.out.println(this.name + " deals " + randomAttack + " damage to " + opponent.name);
        }
    }

    public boolean checkAlive() {
        boolean result = true;
        if (this.hp <= 0) {
            System.out.println(this.name + " is dead");
            System.out.println(this.name + " loses the game");
            result = false;
        }

        return result;
    }

    public void printStats() {
        System.out.println(this.name + "'s defense:" + this.def);
        System.out.println(this.name + "'s hp:" + this.hp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input knight def:");
        int knightDef = scanner.nextInt();
        System.out.println("Input knight hp:");
        int knightHp = scanner.nextInt();
        System.out.println("Input the name for the Knight:");
        String knightName = scanner.next();

        Javacharacter knight = new Javacharacter(knightDef, knightHp, knightName);
        knight.printStats();

        System.out.println("Input demon def:");
        int demonDef = scanner.nextInt();
        System.out.println("Input demon hp:");
        int demonHp = scanner.nextInt();
        System.out.println("Input the name for the demon:");
        String demonName = scanner.next();

        Javacharacter demon = new Javacharacter(demonDef, demonHp, demonName);
        demon.printStats();

        int randomInt = (int) Math.floor((2 * Math.random()));

        while (knight.checkAlive() && demon.checkAlive()) {
            if (randomInt == 0) {
                knight.attack(demon);
                System.out.println("The knight attacked the Demon for " + knight.atk + " damage");
                randomInt = 1;
            } else {
                demon.attack(knight);
                System.out.println("The Demon attacked the Knight for " + demon.atk + " damage");
                randomInt = 0;
            }
        }
        if (demon.hp <= 0) {
            System.out.println("The Knight won.");

        } else if (knight.hp <= 0) {
            System.out.println("The Demon won.");
        }
    }

    // make log of fight/attacks
    // fix code/logic(dead or alive)
}
