package com.hicode.swing;

import com.QLTV.utils.XImage;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class TK_TheLoai {

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Thống Kê Theo Thể Loại", dataset, true, true, true);
        return chart;
    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Giáo khoa tham khảo", new Double(100 * 823 / 5677));
        dataset.setValue("Kinh Tế", new Double(100 * 612 / 5677));
        dataset.setValue("Nuôi dạy con", new Double(100 * 625 / 5677));
        dataset.setValue("Sách ngoại ngữ", new Double(100 * 708 / 5677));
        dataset.setValue("Tâm lý - Kĩ năng sống", new Double(100 * 694 / 5677));
        dataset.setValue("Thiếu nhi", new Double(100 * 697 / 5677));
        dataset.setValue("Tiểu sử hồi kí", new Double(100 * 843 / 5677));
        dataset.setValue("Văn Học", new Double(100 * 675 / 5677));

        return dataset;
    }

    public static void main() {
        JFreeChart pieChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(pieChart);
        JFrame frame = new JFrame();
                                frame.setIconImage(XImage.getappicon());

        frame.add(chartPanel);
        frame.setTitle("Biểu Đồ Thống Kê Theo Thể Loại");
        frame.setSize(600, 400);
        frame.setLocation(570, 330);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
