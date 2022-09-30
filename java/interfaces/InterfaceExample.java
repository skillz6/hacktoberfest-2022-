package sarbajit.interfaces;

class Phone{
    public void call() {
        System.out.println("Phone call");
    }
    public void sms() {
        System.out.println("Phone sending SMS");
    }
}

interface ICamera{
    void click();
    void record();
}

interface IMusicPlayer{
    void play();
    void stop();
}

class SmartPhone extends Phone implements ICamera, IMusicPlayer {
    public void videoCall(){
        System.out.println("Smart Phone video calling");
    }
    @Override
    public void click(){
        System.out.println("Smart Phone Clicking Photo");
    }
    @Override
    public void record(){
        System.out.println("Smart Phone recording video");
    }
    @Override
    public void play(){
        System.out.println("Smart Phone playing music");
    }
    @Override
    public void stop(){
        System.out.println("Smart Phone stopped playing music");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone();
        sp.call();
        sp.click();
        sp.play();
    }
}
