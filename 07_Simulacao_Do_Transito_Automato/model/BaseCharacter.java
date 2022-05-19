package model;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class BaseCharacter extends Thread{

  private String name;
  private double x;
  private double y;
  private ImageView img;
  private int speed = 5;

  public BaseCharacter(String name,ImageView img){
    this.name = name;
    this.img = img;
    this.x = img.getX();
    this.y = img.getY();
  }

  public void moveX(int amount){
    double toSum = (amount > 1? 1 : -1);
    double count = 0;

    while(count != amount){

      setX(getX() + toSum);
      Platform.runLater(() -> {
        img.setX(getX());
      });
      count += toSum;
      toSleeep(getSpeed());
    }
  }

  public void moveY(int amount){
    double toSum = (amount > 1? 1 : -1);
    double count = 0;

    while(count != amount){

      setY(getY() + toSum);
      Platform.runLater(() -> {
        img.setY(getY());
      });
      count += toSum;
      toSleeep(getSpeed());
    }
  }

  public void toSleeep(int miliseconds){
    try {
      Thread.sleep(miliseconds);
    } catch (Exception e) {
      System.out.println("Error sleeping in " + name);
    }
  }

  @Override
  public void run(){
    System.out.println("eae");
  }

  public String getNeime(){
    return this.name;
  }

  public double getX(){
    return this.x;
  }

  public double getY(){
    return this.y;
  }

  public void setY(double y){
    this.y = y;
  }

  public void setX(double x){
    this.x = x;
  }

  public int getSpeed(){
    return this.speed;
  }
  
}