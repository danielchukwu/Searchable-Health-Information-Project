import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class Main {

    static void mandemGui () {

        // jframe creation and setting of size and layout
        JFrame f = new JFrame("Searchable Health Information App");
        f.setSize(500, 500);
        f.setLayout(new GridLayout(2, 1));

        // creating text and button. A user can only search for information on
        // - shortness of breath, sleeplessness, toothache
        JTextField search = new JTextField();
        f.add(search);
        JButton button = new JButton("search");
        f.add(button);

        // frame visibility = true
        f.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchNow = search.getText();

                if (searchNow.equals("shortness of breath")) {
                    informationGui("shortness of breath", "Avoiding smoking, secondhand smoke and areas with high " +
                                   "air pollution or elevations over 5,000 feet may help ease shortness of breath. " +
                                   "Losing weight and exercising regularly may also help.");    // call the method informationGui with this texts

                } else if (searchNow.equals("sleeplessness")){
                    informationGui("sleeplessness", "Treatment for insomnia consists of improving sleep habits, behaviour therapy and " +
                                   "identifying and treating underlying causes. Sleeping pills may also be used, but " +
                                   "should be monitored for side effects.");      // call the method informationGui with this texts

                } else if (searchNow.equals("toothache")) {
                    informationGui("toothache", "Flossing and brushing regularly to remove irritating food particles may help reduce " +
                                   "toothache. Using pain relievers may also provide temporary relief, but it's best to limit use of " +
                                   "topical medications containing benzocaine.");      // call the method informationGui with this texts

                } else {
                    informationGui(searchNow, "No Result Found");    // call method informationGui with this texts
                }
            }
        });
    }

    static void informationGui (String userSearched, String information) {
        // jframe creation and setting of size and layout
        JFrame f = new JFrame("Mandem Project Presentation");
        f.setSize(1800, 500);

        // creating label
        JLabel infoLabel = new JLabel(information);
        f.add(infoLabel);

        // frame visibility = true
        f.setVisible(true);

        // write search and result to file
        try {
            FileWriter file = new FileWriter("mandemfile.txt");
            file.write("Search - " + userSearched + ". Result - " + information);
            file.close();

        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public static void main (String [] args) {
        mandemGui();
    }
}
