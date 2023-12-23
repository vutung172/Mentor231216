package com.fukuoka.unit3;

public class Car {
    private String brand;
    private String color;
    private float   price;
    private float   speed = 0F;
    private boolean engineStatus = false;
    private boolean lightStatus =false;

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean isEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(boolean engineStatus) {
        this.engineStatus = engineStatus;
    }

    public boolean isLightStatus() {
        return lightStatus;
    }

    public void setLightStatus(boolean lightStatus) {
        this.lightStatus = lightStatus;
    }

    public Car(String brand, String color, float price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public boolean start(){
        this.engineStatus = true;
        System.out.println("Động cơ đã bật");
        return this.lightStatus;
    }
    public boolean stop(){
        if (!this.engineStatus){
            System.out.println("Động cơ chưa được bật");
        }
        this.engineStatus = false;
        System.out.println("Động cơ đã tắt");
        setLightStatus(false);
        setSpeed(0F);
        return this.engineStatus;
    }

    public float acceleration() {
        if (!this.engineStatus) {
            System.out.println("Động cơ chưa bật");
        } else {
            this.speed = this.getSpeed()+10;
        }
        return this.speed;
    }
    public float deceleration(){
        if (!this.engineStatus) {
            System.out.println("Động cơ chưa bật");
        } else if (this.getSpeed() <= 0){
            this.speed = this.getSpeed();
        } else {
            this.speed = this.getSpeed()-10;
        }
        return this.speed;
    }
    public boolean turnOnLight(){
        if (!this.engineStatus){
            System.out.println("Động cơ chưa được bât");
            this.lightStatus = false;
        } else {
            this.lightStatus = true;
        }
        return this.lightStatus;
    }
    public boolean turnOffLight(){
        if (!this.engineStatus){
            System.out.println("Động cơ chưa được bât");
            this.lightStatus = false;
        } else if (!this.isLightStatus()){
            System.out.println("Đèn chưa được bật");
        } else {
            this.lightStatus = false;
        }
        return this.lightStatus;
    }
}