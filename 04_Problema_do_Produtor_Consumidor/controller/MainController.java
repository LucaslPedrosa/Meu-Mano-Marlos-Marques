package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Buffer;
import model.GasStation;
import model.OilRefinery;

public class MainController implements Initializable {

  
  @FXML
  private AnchorPane anchorPaneManagement;

  @FXML
  private ImageView imgShop;

  @FXML
  private ImageView imgProduction;

  @FXML
  private ImageView imgConsumer;

  @FXML
  private AnchorPane anchorPaneProducers;

  @FXML
  private ImageView imgRefinery1;

  @FXML
  private ImageView imgRefinery2;

  @FXML
  private ImageView imgRefinery3;

  @FXML
  private ImageView imgRefinery4;

  @FXML
  private ImageView imgProdToManagment;

  @FXML
  private ImageView imgRefineryTurnOn1;

  @FXML
  private ImageView imgRefineryTurnOn2;

  @FXML
  private ImageView imgRefineryTurnOn3;

  @FXML
  private ImageView imgRefineryTurnOn4;

  @FXML
  private ImageView imgLoadingBar1;

  @FXML
  private ImageView imgProgressBar11;

  @FXML
  private ImageView imgProgressBar12;

  @FXML
  private ImageView imgProgressBar13;

  @FXML
  private ImageView imgLoadingBar2;

  @FXML
  private ImageView imgProgressBar21;

  @FXML
  private ImageView imgProgressBar22;

  @FXML
  private ImageView imgProgressBar23;

  @FXML
  private ImageView imgLoadingBar3;

  @FXML
  private ImageView imgProgressBar31;

  @FXML
  private ImageView imgProgressBar32;

  @FXML
  private ImageView imgProgressBar33;

  @FXML
  private ImageView imgLoadingBar4;

  @FXML
  private ImageView imgProgressBar41;

  @FXML
  private ImageView imgProgressBar42;

  @FXML
  private ImageView imgProgressBar43;

  @FXML
  private AnchorPane anchorPaneConsumers;

  @FXML
  private ImageView imgCar1;

  @FXML
  private ImageView imgCar2;

  @FXML
  private ImageView imgCar3;

  @FXML
  private ImageView imgConsumerToManagment;

  @FXML
  private ImageView imgGasTurnOn1;

  @FXML
  private ImageView imgGasTurnOn2;

  @FXML
  private ImageView imgGasTurnOn3;

  @FXML
  private Label textLabelMoney;

  @FXML
  private Label textLabelOil;

  private OilRefinery refinerys[] = new OilRefinery[4];
  private GasStation stations[] = new GasStation[3];

  private int money = 0;

  private ImageView progressBar[][] = new ImageView[4][3];

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    createThreads();

    startThreads();

    setProgressBar();


    /**
     * Next methods are used to change screens
     * 
     */
    imgConsumer.setOnMouseClicked(Event -> {
      anchorPaneManagement.setVisible(false);
      anchorPaneConsumers.setVisible(true);
    });

    imgProduction.setOnMouseClicked(Event -> {
      anchorPaneManagement.setVisible(false);
      anchorPaneProducers.setVisible(true);
    });

    imgProdToManagment.setOnMouseClicked(Event -> {
      anchorPaneProducers.setVisible(false);
      anchorPaneManagement.setVisible(true);
    });

    imgConsumerToManagment.setOnMouseClicked(Event -> {
      anchorPaneConsumers.setVisible(false);
      anchorPaneManagement.setVisible(true);
    });

    /**
     * Next methods are used to turn refinerys on/off
     * 
     * 
     */

    imgRefineryTurnOn1.setOnMouseClicked(event -> {
      refineryTurnOnOff(0);
    });

    imgRefineryTurnOn2.setOnMouseClicked(event -> {
      refineryTurnOnOff(1);
    });

    imgRefineryTurnOn3.setOnMouseClicked(event -> {
      refineryTurnOnOff(2);
    });

    imgRefineryTurnOn4.setOnMouseClicked(event -> {
      refineryTurnOnOff(3);
    });

    /**
     * Next methods are used to turn GasStations on / off
     * 
     */

    imgGasTurnOn1.setOnMouseClicked(event -> {
      gasStationTurnOnOff(0);
    });

    imgGasTurnOn2.setOnMouseClicked(event -> {
      gasStationTurnOnOff(1);
    });

    imgGasTurnOn3.setOnMouseClicked(event -> {
      gasStationTurnOnOff(2);
    });

  }

  public void updateOil() {
    textLabelOil.setText(String.valueOf(Buffer.liters));
  }

  public void updateMoney() {
    textLabelMoney.setText(String.valueOf(getMoney()));
  }

  public void addMoney(int x) {
    this.money += x;
    updateMoney();
  }

  public int getMoney() {
    return this.money;
  }

  public void refineryTurnOnOff(int witch) {
    refinerys[witch].turnOnOff();
  }

  public void gasStationTurnOnOff(int witch) {
    stations[witch].turnOnOff();
  }

  public void setProgressBar(){
    progressBar[0][0] = imgProgressBar11;
    progressBar[0][1] = imgProgressBar12;
    progressBar[0][2] = imgProgressBar13;

    progressBar[1][0] = imgProgressBar21;
    progressBar[1][1] = imgProgressBar22;
    progressBar[1][2] = imgProgressBar23;

    progressBar[2][0] = imgProgressBar31;
    progressBar[2][1] = imgProgressBar32;
    progressBar[2][2] = imgProgressBar33;

    progressBar[3][0] = imgProgressBar41;
    progressBar[3][1] = imgProgressBar42;
    progressBar[3][2] = imgProgressBar43;
  }

  public void createThreads(){
    refinerys[0] = new OilRefinery(this, imgRefinery1, imgRefineryTurnOn1, imgLoadingBar1, progressBar[0]);
    refinerys[1] = new OilRefinery(this, imgRefinery2, imgRefineryTurnOn2, imgLoadingBar2,progressBar[1]);
    refinerys[2] = new OilRefinery(this, imgRefinery3, imgRefineryTurnOn3, imgLoadingBar3,progressBar[2]);
    refinerys[3] = new OilRefinery(this, imgRefinery4, imgRefineryTurnOn4, imgLoadingBar4,progressBar[3]);

    stations[0] = new GasStation(this, imgCar1, imgGasTurnOn1);
    stations[1] = new GasStation(this, imgCar2, imgGasTurnOn2);
    stations[2] = new GasStation(this, imgCar3, imgGasTurnOn3);
  }

  public void startThreads(){
    refinerys[0].start();
    refinerys[1].start();
    refinerys[2].start();
    refinerys[3].start();

    stations[0].start();
    stations[1].start();
    stations[2].start();
  }

}
