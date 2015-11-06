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

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.List;

/**
 * JFreeChart��װ��
 * @Author qinshenghui
 * @Date 2015-11-06 13:57
 */
public class JFreeChartWarp {
    //�����״ͼ
    public static void printBar(HttpServletResponse res, List<Map<String, String>> list){
        CategoryDataset ds = getDataSet(list);
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

        OutputStream out = null;
        // ����������ͼƬ�Ĵ�С
        res.setContentType("image/jpeg");
        try {
            ChartUtilities.writeChartAsJPEG(res.getOutputStream(), chart, 500, 300);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //��ȡ����
    private static CategoryDataset getDataSet(List<Map<String, String>> list) {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        for(int i = 0; i <list.size(); i++){
            Map obj = list.get(i);
            String name = (String) obj.get("name");
            Integer val = Integer.parseInt(obj.get("value").toString());
            ds.addValue(val, "", name);
        }
        return ds;
    }
}
