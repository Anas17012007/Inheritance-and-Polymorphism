import javax.swing.*;
import java.awt.*;

public class EggTimer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Egg Timer");
        frame.setSize(350, 230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] pilihan = {
            "Setengah Matang - 6 Menit",
            "Matang Sedang - 8 Menit",
            "Matang Sempurna - 10 Menit"
        };

        JComboBox<String> combo = new JComboBox<>(pilihan);

        JLabel waktu = new JLabel("00:00", SwingConstants.CENTER);
        waktu.setFont(new Font("Arial", Font.BOLD, 32));

        JButton mulai = new JButton("Mulai");
        JButton reset = new JButton("Reset");

        int[] sisaWaktu = {0};

        Timer timer = new Timer(1000, e -> {
            sisaWaktu[0]--;

            if (sisaWaktu[0] <= 0) {
                ((Timer) e.getSource()).stop();
                waktu.setText("Telur Siap!");
            } else {
                waktu.setText(String.format("%02d:%02d",
                    sisaWaktu[0] / 60, sisaWaktu[0] % 60));
            }
        });

        mulai.addActionListener(e -> {
            timer.stop();

            int index = combo.getSelectedIndex();

            int[] durasi = {360, 480, 600};
            sisaWaktu[0] = durasi[index];

            waktu.setText(String.format("%02d:%02d",
                sisaWaktu[0] / 60, sisaWaktu[0] % 60));

            timer.start();
        });

        reset.addActionListener(e -> {
            timer.stop();
            sisaWaktu[0] = 0;
            waktu.setText("00:00");
        });

        JPanel tombol = new JPanel();
        tombol.add(mulai);
        tombol.add(reset);

        panel.add(combo);
        panel.add(waktu);
        panel.add(tombol);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}