package com.viva.image;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PicZoom {

    public static BufferedImage zoom(String srcFileName, int outputWidth, int outputHeight) {
        //使用源图像文件名创建 ImageIcon 对象
        ImageIcon imgIcon = new ImageIcon(srcFileName);
        //得到 Image对象
        Image img = imgIcon.getImage();
        return zoom(img, outputWidth, outputHeight);
    }

    public static BufferedImage zoom(Image srcImage, int outputWight, int outputHeight) {
        //构造一个预定义的图像类型的 BufferedImage 对象
        BufferedImage buffImg = new BufferedImage(outputWight, outputHeight, BufferedImage.TYPE_INT_RGB);
        //创建 Graphics2D 对象，用于在 BufferedImage 对象上画图
        Graphics2D g = buffImg.createGraphics();
        //设置图形上下文的当前颜色为白色
        g.setColor(Color.WHITE);
        //用图形上下文的当前颜色填充指定的矩形区域
        g.fillRect(0, 0, outputWight, outputHeight);
        //按照缩放的大小在BufferedImage 对象上绘制原始图像
        g.drawImage(srcImage, 0, 0, outputWight, outputHeight, null);
        //释放图形上下文使用的系统资源
        g.dispose();
        return buffImg;
    }
}



