package com.poshidi.plugin.jfreechart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        CategoryDataset ds = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
                "����", //ͼ�����
                "", //Ŀ¼�����ʾ��ǩ
                "", //��ֵ�����ʾ��ǩ
                ds, //���ݼ�
                PlotOrientation.VERTICAL, //ͼ����
                true, //�Ƿ���ʾͼ�������ڼ򵥵���״ͼ����Ϊfalse
                false, //�Ƿ�������ʾ����
                false);         //�Ƿ�����url����

        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();

        BarRenderer3D customBarRenderer = (BarRenderer3D) categoryplot.getRenderer();
        //�趨�����������ɫ
        customBarRenderer.setSeriesPaint(0, Color.decode("#005AB5")); // ��series1 Bar

        customBarRenderer.setSeriesOutlinePaint(0,Color.BLACK);//�߿�Ϊ��ɫ

        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();

        CategoryAxis domainAxis = categoryplot.getDomainAxis();

        /*------����X�������ϵ�����-----------*/
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));

        /*------����X��ı�������------------*/
        domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12));

        /*------����Y�������ϵ�����-----------*/
        numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));

        /*------����Y��ı�������------------*/
        numberaxis.setLabelFont(new Font("����", Font.PLAIN, 12));

        /*------���������˵ײ��������������-----------*/
        chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));

        /*******���������˱��⺺�����������********/
        chart.getTitle().setFont(new Font("����", Font.PLAIN, 12));

        FileOutputStream out = null;
        try {
            out = new FileOutputStream("E://1.jpg");
            ChartUtilities.writeChartAsJPEG(out, 0.5f, chart, 400, 300, null);
        } finally {
            try {
                out.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        ds.addValue(10, "", "����");
        ds.addValue(16, "", "�鱨");
        ds.addValue(8, "", "xx����");
        ds.addValue(9, "", "xxx����");
        return ds;
    }
}