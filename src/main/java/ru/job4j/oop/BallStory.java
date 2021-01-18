package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare= new Hare();
        WolfWolf wolfwolf = new WolfWolf();
        Fox fox = new Fox();
        hare.meet(ball);
        wolfwolf.attemptedMurder(ball);
        fox.eat(ball);
        ball.wasKilled(fox);
        }
}
