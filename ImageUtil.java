package cn.com.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
public class ImageUtil {
	
    public static void main(String[] args) throws IOException {
        ImageUtil imageUtil = new ImageUtil();
        imageUtil.specifyProportion();
      /*imageUtil.transferFormat();
        imageUtil.specifySize();
        imageUtil.outStream();
        imageUtil.specifySizeZoom();
        imageUtil.specifyRotate();
        imageUtil.specifyWatermark();
        imageUtil.specifyTailor();
        imageUtil.outBufferStream();
        */

    }
    //指定大小进行缩放 @throws IOException
    private void specifySize() throws IOException {
        /*
         * size(width,height) 若图片横比200小，高比300小，不变
         * 若图片横比200小，高比300大，高缩小到300，图片比例不变 若图片横比200大，高比300小，横缩小到200，图片比例不变
         * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
         */
        Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").size(200, 300).toFile("F:\\2018\\201809\\20180918\\image200*300.jpg");
        Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").size(2560, 2048).toFile("F:\\2018\\201809\\20180918\\image2560*2048.jpg");
    }

    //按照比例进行缩放20190213
    private void specifyProportion() throws IOException {
        //scale(比例)
         
        
       Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").scale(0.25f).toFile("F:\\2018\\201809\\20180918\\image%25.jpg");
       System.out.println("图片已处理OK,请查看谢谢！");
    }

    // 不按照比例，指定大小进行缩放
    
    private void specifySizeZoom() throws IOException {
        // keepAspectRatio(false) 默认是按照比例缩放的
        Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").size(120, 120).keepAspectRatio(false).toFile("F:\\2018\\201809\\20180918\\image_zoom.jpg");
        System.out.println("图片已处理OK,请查看谢谢！");
    }
    //旋转
    private void specifyRotate() throws IOException {
        //rotate(角度),正数：顺时针 负数：逆时针
        Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").size(1280, 1024).rotate(90).toFile("F:\\2018\\201809\\20180918\\image+90.jpg");
        Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").size(1280, 1024).rotate(-90).toFile("F:\\2018\\201809\\20180918\\image-90.jpg");
        System.out.println("图片已处理OK,请查看谢谢！");
    }

    //水印
  
    private void specifyWatermark() throws IOException {
        /**
         * watermark(位置，水印图，透明度)
         */
        Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").size(1280, 1024).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("F:\\2018\\201809\\20180918\\image001.jpg")), 0.5f)
                .outputQuality(0.8f).toFile("F:\\2018\\201809\\20180918\\image_right.jpg");
        Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").size(1280, 1024).watermark(Positions.CENTER, ImageIO.read(new File("F:\\2018\\201809\\20180918\\image001.jpg")), 0.5f)
                .outputQuality(0.8f).toFile("F:\\2018\\201809\\20180918\\image_left.jpg");
        System.out.println("图片已处理OK,请查看谢谢！");
    }

    //裁剪

    private void specifyTailor() throws IOException {
        // 图片中心400*400的区域

        Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").sourceRegion(Positions.CENTER, 400, 400).size(200, 200).keepAspectRatio(false)
                .toFile("F:\\2018\\201809\\20180918\\image_center.jpg");
        // 图片右下400*400的区域
      
        Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").sourceRegion(Positions.BOTTOM_RIGHT, 400, 400).size(200, 200).keepAspectRatio(false)
                .toFile("F:\\2018\\201809\\20180918\\image_right.jpg");
        // 指定坐标

        Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").sourceRegion(600, 500, 400, 400).size(200, 200).keepAspectRatio(false).toFile("F:\\2018\\201809\\20180918\\image_003.jpg");
        System.out.println("图片已处理OK,请查看谢谢！");
    }

    //转化图像格式
   
    private void transferFormat() throws IOException {
        // outputFormat(图像格式)
        Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").size(1280, 1024).outputFormat("png").toFile("F:\\2018\\201809\\20180918\\image.png");
        System.out.println("图片已处理OK,请查看谢谢！");
    }

    // 输出到OutputStream
 
    private void outStream() throws IOException {
        //toOutputStream(流对象)

        OutputStream os = new FileOutputStream("F:\\2018\\201809\\20180918\\image_out.jpg");
        Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").size(1280, 1024).toOutputStream(os);
        System.out.println("图片已处理OK,请查看谢谢！");
    }

    //输出到BufferedImage
   
    private void outBufferStream() throws IOException {
        //asBufferedImage() 返回BufferedImage
  
        BufferedImage thumbnail = Thumbnails.of("F:\\2018\\201809\\20180918\\image.jpg").size(1280, 1024).asBufferedImage();
        ImageIO.write(thumbnail, "jpg", new File("F:\\2018\\201809\\20180918\\image_buffer.jpg"));
        System.out.println("图片已处理OK,请查看谢谢！");
    }


}
