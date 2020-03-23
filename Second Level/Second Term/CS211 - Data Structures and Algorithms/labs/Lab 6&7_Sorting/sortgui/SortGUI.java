// *** Look at lines 133-136 and make the necessary changes there. ***
package lab5_sort.sortgui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

// These static imports mean we can just use RED instead of Color.RED etc.
import static java.awt.Color.*;
import static lab5_sort.sortgui.Sorter.State.*;
import static lab5_sort.sortgui.SortGUI.SortType.*;

/**
 * Provides a graphical way to observe and control any sorting algorithm that
 * is implemented by a class which extends the Sorter class.
 *
 * @author Iain Hewson
 */
public class SortGUI extends JPanel implements Observer {

   /** Needs one of these since JPanel is serializable. */
   public static final long serialVersionUID = 1;

   /** Represents the possible sorts that can be done. */
   public static enum SortType {
      /** An implementation of insertion sort (provided by us). */
      INSERTION,
      /** A shell sort (which must be implemented by you). */   
      SHELL
   };

   /** Holds the type of the current sort. */
   private SortType sortType;

   /** Button to start, pause, and resume sorting. */
   private JButton startButton = new JButton("Start");
   
   /** Selector to choose whether to do shell sort or insertion sort. */
   private JCheckBox sortSelector = new JCheckBox("Shell Sort");

   /** Shows how many comparisons have been done so far. */
   private JLabel comparisons = new JLabel("Comparisons: 0");

   /** Shows the value of H if we are doing shell sort. */
   private JLabel hLabel = new JLabel();

   /** Width of graphical representation (also how many numbers to sort. */
   private int width;

   /** Height of graphical representation (max value of numbers to sort. */
   private int height;

   /** Holds the current sorter being displayed. */
   private Sorter sorter;
   
   /** Flag to say whether to have tiny pauses during sorting. */
   private boolean slower = true;
   
   /**
    * Create a new SortGUI with the given dimensions and type.
    *
    * @param width how many numbers to sort (and display).
    * @param height maximum value for the randomly generated numbers to sort.
    * @param type which sorting algorithm to use.
    */
   public SortGUI(int width, int height, SortType type) {
      this.width = width;
      this.height = height;
      sortType = type;
      setLayout(new BorderLayout());
      DrawingPanel drawingPanel = new DrawingPanel();
      drawingPanel.setPreferredSize(new Dimension(width, height));
      add(drawingPanel);
      add(BorderLayout.SOUTH, makeControlPanel());
      JPanel topPanel = new JPanel(new BorderLayout());
      topPanel.add(BorderLayout.EAST, hLabel);
      topPanel.add(BorderLayout.WEST, comparisons);
      add(BorderLayout.NORTH, topPanel);
      reset();
   }
   
   /**
    * Create a control panel which holds a start/pause/resume button, a reset
    * button, a sort selector, and two speed buttons (faster and slower).
    *
    * @return the control panel.
    */
   private JPanel makeControlPanel() {
      JPanel controlPanel = new JPanel();
      controlPanel.add(startButton);
      controlPanel.add(makeResetButton());
      startButton.addActionListener(new StartButtonListener());
      controlPanel.add(sortSelector);
      sortSelector.setSelected(sortType == SHELL);
      sortSelector.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            sortType = (sortType == SHELL ? INSERTION : SHELL);
            reset();
         }
      });
      controlPanel.add(makeSpeedSelectors());
      return controlPanel;
   }

   /**
    * Create a button to reset things to a position ready to sort.
    *
    * @return a button to reset things to a position ready to sort.
    */
   private JButton makeResetButton() {
      JButton resetButton = new JButton("Reset");
      resetButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            reset();
         }
      });
      return resetButton;
   }
   
   /**
    * (Re)initialise things so that we are ready to perform a sort.
    */
   private void reset() {
      if (sorter != null) {
         sorter.setState(RUNNING);  // don't leave old sorter paused
         sorter.deleteObserver(this);
      }
      if (sortType == INSERTION) {
         sorter = new InsertionSort(makeNums(width, height));
      } else {
         System.err.println(
               "Implement ShellSort and alter lines 133-136 of SortGUI.java");
         System.exit(0); // delete lines 133-135, and uncomment the line below
      //   sorter = new ShellSort(makeNums(width, height));
      }
      sorter.addObserver(this);
      startButton.setText("Start");
      sortSelector.setEnabled(true);
      update(null,null);
   }
 
   /**
    * Listener for the start button.
    */
   private class StartButtonListener implements ActionListener {

      /**
       * Perform the appropriate action when the start button is pressed
       * (either start, pause, or resume).
       *
       * @param e the event triggered when the button is pressed.
       */
      public void actionPerformed(ActionEvent e) {
         switch (sorter.getState()) {
            case READY:    
               Runnable r = new Runnable() {
                  public void run() {
                     sorter.sortNums();
                  }
               };
               new Thread(r).start();
               sorter.setState(RUNNING);
               sortSelector.setEnabled(false);
               startButton.setText("Pause");
               break;
            case RUNNING:
               sorter.setState(PAUSED);
               startButton.setText("Resume");
               break;
            default:
               sorter.setState(RUNNING);
               startButton.setText("Pause");
               break;
         }
      }
   }

   /**
    * Create a panel containing two selectors (slower and faster) to control
    * the speed of the sort.
    *
    * @return a panel containing the speed selectors.
    */
   private JPanel makeSpeedSelectors() {
      JPanel speedPanel = new JPanel();
      ButtonGroup group = new ButtonGroup();
      speedPanel.add(makeSpeedButton("Slower", group, true));
      speedPanel.add(makeSpeedButton("Faster", group, false));
      return speedPanel;
   }
   
   /**
    * Create a radio button with the given name, belonging to the given group,
    * which sets the value of the datafield slower to the value of isSlow when
    * pressed.
    *
    * @param name the name of the button.
    * @param group the buttongroup to add the button to.
    * @param isSlow the value to set datafield slower to when pressed.
    * @return the radiobutton.
    */
   private JRadioButton makeSpeedButton(String name, ButtonGroup group,
         final boolean isSlow) {
      JRadioButton button = new JRadioButton(name);
      group.add(button);
      button.setSelected(isSlow);
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            slower = isSlow;
         }
      });
      return button;
   }
   
      
   /**
    * Whenever the observed sorter object changes this method is called and
    * we update the things we are interested in.
    *
    * @param obs the thing we are observing.
    * @param obj whatever got passed from the notifyObservers() method.
    */
   public void update(Observable obs, Object obj) {
      hLabel.setText(sortType == INSERTION ?
            "" : "H:     " + sorter.getH() + "          ");
      comparisons.setText("Comparisons: " + sorter.getComparisons());
      if (slower) {
         try {
            Thread.sleep(1);
         } catch (InterruptedException e) {
            System.err.println(e);
         }
      }
      repaint();
   }
   
   /**
    * This panel is used to show a graphical representation of the numbers
    * which are being sorted.
    */
   private class DrawingPanel extends JPanel {
      
      /** Needs one of these since JPanel is serializable. */
      public static final long serialVersionUID = 2;
      
      /**
       * This method gets called when the panel needs to be repainted.
       * Black vertical lines drawn on it to represent numbers which are
       * being sorted. Two coloured lines are also drawn to show each
       * comparison, so we can see where we are up to.
       * 
       * @param g the Graphics context in which to paint.
       */
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         // draw a line for each value in the sorter's array of integers
         for (int i = 0; i < sorter.size(); i++) {
            g.drawLine(i, height, i, height - sorter.getValue(i));
         }
         int i = sorter.getI(), j = sorter.getJ();
         // draw coloured lines to show each comparison
         if (i >= 0 && j >= 0 && i < sorter.size() && j < sorter.size()) {
            g.setColor(RED);
            g.drawLine(i, 0, i, height);
            g.setColor(GREEN);
            g.drawLine(j, 0, j, height);
         }
      }
      
   } // end class DrawingPanel
   
   /**
    * Creates and displays a SortGUI.  By default an insertion sort is shown.
    * This can be changed to shell sort by passing '-s' on the command line.
    *
    * @param args '-s' as the first command line argument will display a shell
    *             sort instead of an insertion sort.
    */
   public static void main(String[] args) {
      JFrame f = new JFrame("Sorting Demo");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel panel = new JPanel();
      panel.add(new SortGUI(400, 200,
               (args.length > 0 && "-s".equals(args[0])) ? SHELL : INSERTION));
      f.getContentPane().add(panel);
      f.pack();
      f.setVisible(true);
   }
   
   /**
    * Make an array of random integers between 0 and upper.
    *
    * @param count how many integers to put in the array.
    * @param upper the (inclusive) upper bound for the integers.
    */
   public static Integer[] makeNums(int count, int upper) {
      Integer[] nums = new Integer[count];
      for (int i = 0; i < nums.length; i++) {
         nums[i] = (int) (Math.random() * (upper+1));
      }
      return nums;
   }
   
}
