/* 
 *  @Author : Lucas Pedrosa Larangeira
 *  Matriculation : 202011430
 *  Creation : 07/03/2022
 *  Last alteration: 13/03/2022
 *  Name: MainController.java
 *  Function: Control everything that happens in the java GUI.
 * 
 *  Music Copyright (c) : UEFA Champions League Official Theme Song
 *  Composer : Tony Britten. Use is subject to license terms.
 * 
 * 
 * 
 * 
 * 
 * 
*/



package controller;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import util.threads.ThreadFather;
import util.threads.ThreadGrandson1;
import util.threads.ThreadGrandson2;
import util.threads.ThreadGreatGrandson;
import util.threads.ThreadSon1;
import util.threads.ThreadSon2;
import util.threads.ThreadSon3;

public class MainController implements Initializable {

  // Images used
  @FXML private ImageView imgFather;
  @FXML private ImageView imgFilho1;
  @FXML private ImageView imgFilho3;
  @FXML private ImageView imgFilho2;
  @FXML private ImageView imgNeto1;
  @FXML private ImageView imgBisneto;
  @FXML private ImageView imgNeto2;

  // Button to start the tree
  @FXML private Button buttonStart;

  // Labels used for display the ages
  @FXML private Label labelFatherAge;
  @FXML private Label labelSon1Age;
  @FXML private Label labelSon2Age;
  @FXML private Label labelSon3Age;
  @FXML private Label labelGrandson1Age;
  @FXML private Label labelGrandson2Age;
  @FXML private Label labelGreatGrandsonAge;

  private MediaPlayer mediaPlayer;

  // Father Thread, used to start the other threads
  private ThreadFather threadFather = new ThreadFather();

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    // Set on the controllers
    threadFather.setController(this);

    buttonStart.setOnAction(Event -> {
      buttonStart.setDisable(true);
      slashMusicPlays();
      threadFather.start();
    });
  }


  /*
   *  Method name: slashMusicPlays
   *  it will try to get the music path and run it
   *  it sometimes doesnt work in some linux versions
   * 
   * 
   */

  public void slashMusicPlays(){
    try{
    Media media = new Media(Paths.get("util/champions.mp3").toUri().toString());
    mediaPlayer = new MediaPlayer(media);
    mediaPlayer.setVolume(0.3);
    mediaPlayer.play();
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

  public void killFather(){ //Method used to change the image referring to father Thread
    imgFather.setImage(new Image("/img/paiIMORTAL.png"));
  }

  public void killSon1(){ //Method used to change the image referring to Son1 Thread
    imgFilho1.setImage(new Image("/img/filho1morto.png"));
  }

  public void killSon2(){ //Method used to change the image referring to Son2 Thread
    imgFilho2.setImage(new Image("/img/filho2morto.png"));
  }

  public void killSon3(){ //Method used to change the image referring to Son3 Thread
    imgFilho3.setImage(new Image("/img/filho3morto.png"));
  }

  public void killGrandson1(){  //Method used to change the image referring to Grandson1 Thread
    imgNeto1.setImage(new Image("/img/neto1morto.png"));
  }
  
  public void killGrandson2(){  //Method used to change the image referring to Grandson2 Thread
    imgNeto2.setImage(new Image("/img/neto2morto.png"));
  }

  public void killGreatGrandson(){  //Method used to change the image referring to GreatGrandson Thread
    imgBisneto.setImage(new Image("/img/bisneto1morto.png"));
  }

  /*
   *  The next lines are just get and set methods
   *  these types are self explanatory
   * 
   * 
   */

  public void setFatherVisible() {
    imgFather.setVisible(true);
  }

  public void setFatherAge(int age) {
    this.labelFatherAge.setText(String.valueOf(age));
  }

  public void setSon1Age(int age) {
    this.labelSon1Age.setText(String.valueOf(age));
  }

  public void setSon2Age(int age) {
    this.labelSon2Age.setText(String.valueOf(age));
  }

  public void setSon3Age(int age) {
    this.labelSon3Age.setText(String.valueOf(age));
  }

  public void setGrandson1Age(int age) {
    this.labelGrandson1Age.setText(String.valueOf(age));
  }

  public void setGrandson2Age(int age) {
    this.labelGrandson2Age.setText(String.valueOf(age));
  }

  public void setGreatGrandsonAge(int age) {
    this.labelGreatGrandsonAge.setText(String.valueOf(age));
  }

  public void setSon1Visible() {
    imgFilho1.setVisible(true);
  }

  public void setSon2Visible() {
    imgFilho2.setVisible(true);
  }

  public void setSon3Visible() {
    imgFilho3.setVisible(true);
  }

  public void setGrandson1Visible() {
    imgNeto1.setVisible(true);
  }

  public void setGrandson2Visible() {
    imgNeto2.setVisible(true);
  }

  public void setGreatGrandsonVisible() {
    imgBisneto.setVisible(true);
  }

}