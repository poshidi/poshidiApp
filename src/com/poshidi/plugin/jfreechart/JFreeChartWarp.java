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
 * JFreeChart封装类
 * @Author qinshenghui
 * @Date 2015-11-06 13:57
 */
public class JFreeChartWarp {
    //输出柱状图
    public static void printBar(HttpServletResponse res, List<Map<String, String>> list){
        CategoryDataset ds = getDataSet(list);
        JFreeChart chart = ChartFactory.createBarChart3D(
                "数量", //图表标题
                "", //目录轴的显示标签
                "", //数值轴的显示标签
                ds, //数据集
                PlotOrientation.VERTICAL, //图表方向
                true, //是否显示图例，对于简单的柱状图必须为false
                false, //是否生成提示工具
                false);         //是否生成url链接

        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();

        BarRenderer3D customBarRenderer = (BarRenderer3D) categoryplot.getRenderer();
        //设定柱子上面的颜色
        customBarRenderer.setSeriesPaint(0, Color.decode("#005AB5")); // 给series1 Bar

        customBarRenderer.setSeriesOutlinePaint(0,Color.BLACK);//边框为黑色

        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();

        CategoryAxis domainAxis = categoryplot.getDomainAxis();

        /*------设置X轴坐标上的文字-----------*/
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));

        /*------设置X轴的标题文字------------*/
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));

        /*------设置Y轴坐标上的文字-----------*/
        numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));

        /*------设置Y轴的标题文字------------*/
        numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));

        /*------这句代码解决了底部汉字乱码的问题-----------*/
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

        /*******这句代码解决了标题汉字乱码的问题********/
        chart.getTitle().setFont(new Font("宋体", Font.PLAIN, 12));

        OutputStream out = null;
        // 后面两个是图片的大小
        res.setContentType("image/jpeg");
        try {
            ChartUtilities.writeChartAsJPEG(res.getOutputStream(), chart, 500, 300);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取数据
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
