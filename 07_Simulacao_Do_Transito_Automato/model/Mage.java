/**
 *  @Author : Lucas Pedrosa Larangeira
 * 
 *  Enrollment : 202011430
 *  Created: 19/05/2022
 *  last change at : 05/22/2022
 *  Name: Mage.java 
 *  
 * 
 *  
 *  Mage thread is the thread used for simulating Mage 'car' actions
 * 
 *
 */

package model;

import javafx.scene.image.ImageView;

public class Mage extends BaseCharacter {

  public Mage(String name, ImageView img) {
    super(name, img);
  }

  @Override
  public void run() {
    while (true) {
      try {
        Variables.semaphore[6].acquire();
        moveY(-120);
        moveY(-80);
        Variables.semaphore[6].release();
        Variables.semaphore[38].release();
        moveY(-40);
        Variables.semaphore[37].acquire();
        Variables.semaphore[17].acquire();
        Variables.semaphore[18].acquire();
        moveY(-120);
        Variables.semaphore[1].acquire();
        moveY(-40);
        moveX(40);
        Variables.semaphore[18].release();
        Variables.semaphore[17].release();
        moveX(135);
        moveX(125);

        // fun fact: the mage gets here BY THE EXACTLY SAME TIME
        // the "warrior" gets at semaphore 6 if no speed has changed

        Variables.semaphore[36].acquire();
        moveX(50);
        moveY(80);
        Variables.semaphore[2].acquire();
        Variables.semaphore[27].acquire();
        moveY(40);
        moveY(40);
        Variables.semaphore[36].release();
        moveY(80);
        Variables.semaphore[15].acquire();
        moveY(40);
        Variables.semaphore[27].release();
        Variables.semaphore[1].release();
        moveY(120);
        Variables.semaphore[15].release();
        Variables.semaphore[2].release();
        moveY(40);
        Variables.semaphore[22].acquire();
        Variables.semaphore[3].acquire();
        moveY(40);
        moveY(120);
        moveX(-175);
        moveX(-40);
        Variables.semaphore[3].release();
        Variables.semaphore[37].release();
        moveX(-95);
        Variables.semaphore[38].acquire();
        Variables.semaphore[23].acquire();
        moveX(-40);
        moveY(-120);
        moveY(-40);
        Variables.semaphore[23].release();
        Variables.semaphore[22].release();
        moveY(-40);
      } catch (Exception e) {
      }
    }
  }

}
