package com.myhcl.sandeep.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.CurvedLineNoiseProducer;

public class CaptchaUtil {
	
	public static Captcha createCaptcha(int width,int hieght) {
		return new Captcha.Builder(width, hieght)
		.addBackground(new GradiatedBackgroundProducer())
		.addText()
		.addNoise(new CurvedLineNoiseProducer())
		.build();
	}
public static String encodeBase64(Captcha captcha) {
	String imageData=null;
		try {
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			ImageIO.write(captcha.getImage(),"png",os);
			byte[] arr=Base64.getEncoder().encode(os.toByteArray());
			imageData=new String(arr);
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		return imageData;
		
	}

}
