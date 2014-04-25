package test;

import main.VerbalMatcher;

public class VerbalMatcherTest {
    public static void main(String[] args) {
        VerbalMatcher VmGreeting = new VerbalMatcher()
                                        .then("Hello")
                                        .or("Hi")
                                        .then(", ")
                                        .then("Petter")
                                        .maybe("!");

        System.out.println(VmGreeting.test("Hello, Petter!"));
        System.out.println(VmGreeting.test("Hi, Petter"));
        System.out.println(VmGreeting.test("Hi, Ololosha!"));
        System.out.println(VmGreeting.toString());
    }
}
