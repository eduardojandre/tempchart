package lighttempgraph;

import br.pro.turing.javino.Javino;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    private static boolean stop = false;
    private static Javino jBridge = new Javino("C:\\Python27");
    
  public static void main(String[] args) throws Exception {
    Chart celChart=new Chart("Temperatura","Tempo","Celsius", (double) 0);
    Chart lumChart=new Chart("Luminosidade","Tempo","Luminosidade", (double) 0);
    JPanel panel=new JPanel();
    panel.add(celChart.getPanel());
    panel.add(lumChart.getPanel());
    
    JFrame frame=new JFrame();
    frame.add(panel);
    frame.pack();
    
    frame.setResizable(false);
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenDimension = tk.getScreenSize();
    int screenHeight = screenDimension.height;
    int screenWidth = screenDimension.width;
    frame.setLocation(screenWidth / 20, screenHeight / 4);
   
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    frame.setVisible(true);
    
    while (true) {

      Thread.sleep(10);

      celChart.updateChart( getTemperatura());
      lumChart.updateChart( getLuminosidade());

    }

  }
  public static Double getTemperatura() {
       String answer = "-1";
        if(jBridge.requestData("COM4","temp")){
             answer = jBridge.getData();
        }
	return Double.parseDouble(answer);
  }
  public static Double getLuminosidade() {
       String answer = "-1";
        if(jBridge.requestData("COM4","lux")){
             answer = jBridge.getData();
        }
	return Double.parseDouble(answer);
  }
}