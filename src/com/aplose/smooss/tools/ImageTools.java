package com.aplose.smooss.tools;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;

public class ImageTools {
	
	public static String encodeImageBase64(InputStream picture, String format) {
		String pictureBase64 = null;
		try {
			// Encode the picture in base64
			BufferedImage bfr = ImageIO.read(picture);
			byte[] bytes;
			ByteArrayOutputStream outArray = new ByteArrayOutputStream();
			ImageIO.write(bfr, format, outArray);
			bytes = outArray.toByteArray();
			pictureBase64 = Base64.encodeBase64String(bytes);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pictureBase64;
	}
	
	public static String getFileFormat(File picture) {
		String probeResult = null;
		String format = null;
		try {
			probeResult = java.nio.file.Files.probeContentType(picture.toPath());
			switch (probeResult) {
				case "image/jpeg":
					format = "jpg";
					break;
				case "image/png":
					format = "png";
					break;
				default:
					format = "Mauvais format";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return format;
	}
	
	public static File scale(File f) {
		
		BufferedImage bImage = null;
		try {
			bImage = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		float x = (float)1024/bImage.getWidth();
		
        int destWidth=(int) (bImage.getWidth() * x);
        int destHeight=(int) (bImage.getHeight() * x);

        GraphicsConfiguration configuration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        BufferedImage bImageNew = configuration.createCompatibleImage(destWidth, destHeight);
        Graphics2D graphics = bImageNew.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        graphics.drawImage(bImage, 0, 0, destWidth, destHeight, 0, 0, bImage.getWidth(), bImage.getHeight(), null);
        graphics.dispose();
               
        try {
			ImageIO.write(bImageNew, getFileFormat(f), f);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return f;
	        
	}
}
