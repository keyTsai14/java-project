package com.internet_learn;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/3/6
 **/
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;


public class ImgAuthCode {

    /**
     * 图片的宽度
     */
    private int width = 330;
    /**
     * 图片的高度
     */
    private int height = 40;
    /**
     * 验证码字符个数
     */
    private int codeCount = 5;
    /**
     * 验证码干扰线数
     */
    private int lineCount = 150;
    /**
     * 图片验证码类型
     */
    private ImgCodeType imgCodeType = DEFAULT_TYPE;
    /**
     * 验证码
     */
    private String code = null;
    /**
     * 验证码图片Buffer
     */
    private BufferedImage buffImg = null;

    private static final ImgCodeType DEFAULT_TYPE = ImgCodeType.ENANDNUMBER;

    private static char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public ImgAuthCode() {
        this.createCode();
    }

    /**
     * @param width  图片宽
     * @param height 图片高
     */
    public ImgAuthCode(int width, int height) {
        this.width = width;
        this.height = height;
        this.createCode();
    }

    /**
     * @param width     图片宽
     * @param height    图片高
     * @param codeCount 字符个数
     * @param lineCount 干扰线条数
     */
    public ImgAuthCode(int width, int height, int codeCount, int lineCount,ImgCodeType imgCodeType) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        this.imgCodeType = imgCodeType;
        this.createCode();
    }

    public void createCode() {
        int x = 0, fontHeight = 0, codeY = 0;
        x = width / (codeCount + 2);// 每个字符的宽度
        fontHeight = height - 2;// 字体的高度
        codeY = height - 4;

        // 图像buffer
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        // 将图像填充为白色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        // 创建字体
//        ImgFontByte imgFont = new ImgFontByte();
//        Font font = imgFont.getFont(fontHeight);
        Font font=new Font("微软雅黑",Font.PLAIN, fontHeight);
        g.setFont(font);
        drawRandomLine(g);
        // randomCode记录随机产生的验证码
        StringBuffer randomCode = new StringBuffer();
        // 随机产生codeCount个字符的验证码。
        for (int i = 0; i < codeCount; i++) {
            String strRand = getRandomStr(imgCodeType);
            // 产生随机的颜色值，让输出的每个字符的颜色值都将不同。
            g.setColor(getRandomColor());
            g.drawString(strRand, (i + 1) * x, codeY);
            // 将产生的四个随机数组合在一起。
            randomCode.append(strRand);
        }
        this.code = randomCode.toString();
    }

    private void drawRandomLine(Graphics g){
        //干扰线
        for (int i = 0; i < lineCount; i++) {
            int xs = new Random().nextInt(width);
            int ys = new Random().nextInt(height);
            int xe = xs + new Random().nextInt(width / 8);
            int ye = ys + new Random().nextInt(height / 8);
            g.setColor(getRandomColor());
            g.drawLine(xs, ys, xe, ye);
        }
    }

    public Color getRandomColor(){
        int red = 0, green = 0, blue = 0;
        Random random = new Random();
        red = random.nextInt(255);
        green = random.nextInt(255);
        blue = random.nextInt(255);
        return new Color(red,green,blue);
    }

    public String getRandomStr(ImgCodeType type) {
        switch (type) {
            case ENANDNUMBER:
                return creatENAndNumberCode();
            case HAN:
                return creatHan();
            case EN:
                return creatENCode();
            case NUMBER:
                return creatNumberCode();
            default:
                return creatENAndNumberCode();
        }
    }

    public void write(String path) throws IOException {
        OutputStream sos = new FileOutputStream(path);
        this.write(sos);
    }

    public void write(OutputStream sos) throws IOException {
        ImageIO.write(buffImg, "png", sos);
        sos.close();
    }

    /**
     * 单个汉字
     *
     * @return
     */
    public static String creatHan() {
        String code = "";
        Random random = new Random();
        //一个汉字两个字节
        byte[] bytes = new byte[2];
        bytes[0] = Integer.valueOf(176 + Math.abs(random.nextInt(39))).byteValue();
        bytes[1] = Integer.valueOf(161 + Math.abs(random.nextInt(93))).byteValue();
        try {
            code = new String(bytes, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * 英文字母加数字
     *
     * @return
     */
    public static String creatENAndNumberCode() {
        Random random = new Random();
        return String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
    }

    /**
     * 英文字母
     *
     *
     * @return
     */
    public static String creatENCode() {
        StringBuffer code = new StringBuffer();
        Random random = new Random();
        int s = random.nextInt(25) + 65;
        code.append((char) s);
        return code.toString();
    }


    /**
     * 纯数字验证码
     *
     *
     * @return
     */
    public static String creatNumberCode() {
        StringBuffer code = new StringBuffer();
        Random random = new Random();
        return code.append(random.nextInt(9) + "").toString();
    }


    public BufferedImage getBuffImg() {
        return buffImg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public static void main(String[] args) {
        String randomChineseChar = creatHan();
        String randomEnChar = creatENCode();
        System.out.println("args = [" + randomChineseChar + "]");
        System.out.println("args = [" + randomEnChar + "]");
        // 解码url
        try {
            String decode = URLDecoder.decode("%E7%BB%9D%E4%B8%96%E4%BB%99%E7%8E%8Bt", "UTF-8");
            System.out.println(decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
