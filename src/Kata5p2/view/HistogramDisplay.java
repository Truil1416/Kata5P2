package Kata5p2.view;

import Kata5p2.model.Histogram;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    private final Histogram<String> histogram;
    
    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(CreatePanel());
        pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel CreatePanel(){
        ChartPanel chartPanel = new ChartPanel(CreateChart(CreateDataSet()));
        return chartPanel;
    }
    
    private JFreeChart CreateChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("", "Dominios email", "Nº de emails", dataSet, PlotOrientation.VERTICAL, false, false, rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset CreateDataSet(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        //dataSet.addValue(10, "", "ulpgc.es");
        //dataSet.addValue(14, "", "hotmail.es");
        //dataSet.addValue(5, "", "gmail.es");
        for (String key : histogram.keySet()){
            dataSet.addValue(histogram.get(key), "", key);
        }
        return dataSet;
    }
}
