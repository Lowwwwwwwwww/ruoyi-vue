package com.ruoyi.common.utils;


import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Base64.Decoder;

/**
 * @ClassName PicUtil
 * @Description 图片工具类
 * @Author lixianhua
 * @Date 2019/12/9 15:05
 * @Version 1.0
 */
public class PicUtil {

    /**
     * 功能描述: 获取图片文件名称
     *
     * @auther: lixianhua
     * @date: 2019/12/8 15:21
     * @param:
     * @return:
     */
//    public static String getPicName(String tableName, Integer id) {
//        String timeStr = TimesUtil.getServerDateTime(8, new Date());
//        return tableName + "__base64Img__id__" + String.valueOf(id) + "__" + timeStr + ".jpg";
//    }

    /**
     * 将图片压缩包名称分解为指定相对路径，用于内网下载图片后存放指定路径(注意打包时命名中的时间格式是："yyyy-MM-dd-HH-mm-ss")
     *
     * @param zipFileName
     * @return
     */
//    public static String picZipNameToRelativePath(String zipFileName) {
//        zipFileName = zipFileName.replace(CommonConstants.ZIP_IMAGE_FILE_NAME_PREFIX, "");
//        StringTokenizer token = new StringTokenizer(zipFileName, "-");
//        String year = token.nextToken();
//        String month = token.nextToken();
//        String day = token.nextToken();
//        return year + File.separator + month + File.separator + day + File.separator;
//    }

    /**
     * 功能描述: base64字符串转字节数组
     *
     * @auther: lixianhua
     * @date: 2019/12/8 15:52
     * @param:
     * @return:
     */
    public static byte[] stringToInputStream(String imgStr) {
        Decoder decoder = Base64.getDecoder();
        byte[] b = Base64.getMimeDecoder().decode(imgStr);
//        byte[] b = decoder.decode(imgStr);
        return b;
    }

    //base64字符串转byte[]
    public static byte[] base64String2ByteFun(String base64Str) {
        return org.apache.commons.codec.binary.Base64.decodeBase64(base64Str);
    }

    //byte[]转base64
    public static String byte2Base64StringFun(byte[] b) {
        return org.apache.commons.codec.binary.Base64.encodeBase64String(b);
    }

    /**
     * 获取用于保存访问图片的本地相对路径： 年/月/日/   hjt
     *
     * @return
     */
//    public static String getPicRelativePath(Date date) {
//        //Date date=new Date();
//        String year = TimesUtil.getYearOfDate(date) + "";
//        String month = TimesUtil.getMonthOfDate(date) + "";
//        String day = TimesUtil.getDayOfDate(date) + "";
//        return year + File.separator + month + File.separator + day + File.separator;
//    }

   /* public static String pngToJpg() throws Exception {

        File file=new File("C:\\Users\\Lenovo\\Desktop\\1.jpg");
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
       // System.out.println( Base64.getEncoder().encodeToString(buffer));
        String base64Image=Base64.getEncoder().encodeToString(buffer);
        //将png图片转换为jpg图片
        try {
            //如果是png格式的则转换为jpg格式，然后再传给人连服务器
            //read image file
            BufferedImage bufferedImage = ImageIO.read(inputFile);
            // create a blank, RGB, same width and height, and a white background
            BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
                    bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            //TYPE_INT_RGB:创建一个RBG图像，24位深度，成功将32位图转化成24位
            newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
          //  String newPath = imagePath.replace(".png",".jpg");// df.format(new Date())+"_"+userId;
            // write to jpeg file
            ImageIO.write(newBufferedImage, "jpg", new File(newPath));
            returnPath=newPath;
        }
        catch (Exception ex) {

        }





    }*/

   public static final String PIC_PRE = "data:image/jpeg;base64,";


   /**
    * @author ：ygy
    * @date   ： 下午7:09
    * @description： 裁剪 图片
    */

//    public static String cut(String imageUrl, String bbox) throws IOException {
//
//        String []value=bbox.replace(" ","").split(",");
//        int x = Integer.valueOf(value[0]);
//        int y = Integer.valueOf(value[1]);
//        int width = Integer.valueOf(value[2]) - Integer.valueOf(value[0]);
//        int height = Integer.valueOf(value[3]) - Integer.valueOf(value[1]);
//
//        ImageInputStream iis = null;
//        OutputStream out=null;
//
//        URL url = null;
//        try {
//
//            SSLUtil.ignoreSsl();
//            url=new URL(imageUrl);
//            iis = ImageIO.createImageInputStream(url.openStream());
//
//            /*
//             * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
//             * 参数：formatName - 包含非正式格式名称 .（例如 "jpeg" 或 "tiff"）等 。
//             */
//            Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("jpg");
//            ImageReader reader = it.next();
//            // 获取图片流
//
//            /*
//             * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。
//             * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
//             */
//            reader.setInput(iis, true);
//
//            /*
//             * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O
//             * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的
//             * getDefaultReadParam 方法中返回 ImageReadParam 的实例。
//             */
//            ImageReadParam param = reader.getDefaultReadParam();
//            /*
//             * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
//             * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
//             */
//            Rectangle rect = new Rectangle(x, y, width, height);
//            // 提供一个 BufferedImage，将其用作解码像素数据的目标。
//            param.setSourceRegion(rect);
//            /*
//             * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的
//             * BufferedImage 返回。
//             */
//            BufferedImage bi = reader.read(0, param);
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(bi, "jpg", baos);
//            byte[] bytes = baos.toByteArray();
////            return PIC_PRE+Base64.getEncoder().encodeToString(bytes);
//            return Base64.getEncoder().encodeToString(bytes);//返回不加前缀的 base64码
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        } finally {
//            if (iis != null)
//                iis.close();
//            if (out != null)
//                out.close();
//        }
//    }

    /**
     * 将本地图片转换成Base64编码字符串
     *
     * @param imgFile 图片目录路径
     * @return
     */
    public static String getImgFileToBase64(String imgFile) {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream inputStream = null;
        byte[] buffer = null;
        //读取图片字节数组
        try {
            inputStream = new FileInputStream(imgFile);
            int count = 0;
            while (count == 0) {
                count = inputStream.available();
            }
            buffer = new byte[count];
            inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    // 关闭inputStream流
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 对字节数组Base64编码
        return new BASE64Encoder().encode(buffer);
    }

    public static void main(String[] args) {
//        try {
//            String s = cut("https://172.16.1.155:443/group1/M00/71/62/rBABm17mzSSAVf58AACn76AM57M264.jpg", "0,0,80,80");
//            System.out.println(s);
//        } catch (Exception e) {
//        }

//        System.out.println(getImgFileToBase64("/home/ygy/testUnzip/布控人员/张冰_372637488598473629.jpg"));
    }


}
