import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

  public static void main(String[] args) throws Exception {


    Chart celChart=new Chart("Temperatura","Tempo","Celsius", (double) 0);
    Chart lumChart=new Chart("Luminosidade","Tempo","Luminosidade", (double) 0);
    JPanel panel=new JPanel();
    panel.add(celChart.getPanel());
    panel.add(lumChart.getPanel());
    
    JFrame frame=new JFrame();
    frame.add(panel);
    frame.pack();
    frame.setVisible(true);

    while (true) {

      Thread.sleep(100);

      celChart.updateData( getTemperatura());
      lumChart.updateData( getLuminosidade());

    }

  }
  public static Double getTemperatura() {
	  return Math.random() * 20 + 20;
  }
  public static Double getLuminosidade() {
	  return Math.random() * 400 + 100;
  }
}