package com.viva.image;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageHandlerServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse httpServletResponse) throws ServletException, java.io.IOException {
        String strId = request.getParameter("id");
        if (null == strId || "".equals(strId)) {
            throw new ServletException("Image Parameter error !");
        }
        int id = Integer.parseInt(strId);
        String srcImgFileName = null;
        switch (id) {
            case 1:
                srcImgFileName = getServletContext().getRealPath("/") + "images/1.jpg";
                break;
            case 2:
                break;
            default:
                throw new ServletException("Image Parameter error !");
        }
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream sos = httpServletResponse.getOutputStream();
        //调用PicZoom 类的静态方法 zoom对原始图像进行缩放
        BufferedImage bufferedImage = PicZoom.zoom(srcImgFileName, 180, 180);
        //创建JPEG图像编码器，用于编码内存中的图像数据到JPEG数据输出流
        JPEGImageEncoder jpegImageEncoder = JPEGCodec.createJPEGEncoder(sos);
        //编码BufferedImage 对象到 JPEG 数据输出流
        jpegImageEncoder.encode(bufferedImage);
        sos.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
