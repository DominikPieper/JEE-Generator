package de.itemis.jee6.test;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;

import de.itemis.jee6.util.Download;

public class DownloadTest
{
	private final static String HOMEPAGE_URL = "http://eisenbahnsteuerung.org";
	private final static String IMAGE_URL    = HOMEPAGE_URL + "/images/rcc32.gif";
	private final static int    TIMEOUT      = 5000;

	@Test
	public void eisenbahnsteuerung() throws IOException
	{
		final Download download = new Download(HOMEPAGE_URL);

		download.setTimeout(TIMEOUT);
		Assert.assertEquals(TIMEOUT, download.getTimeout());

		final byte [] array = download.downloadArray();
		Assert.assertNotNull(array);

		final String mimeType = download.getMimeType();
		Assert.assertTrue(mimeType.startsWith("text/html"));
	}

	@Test
	public void morknet() throws IOException
	{
		final Download download = new Download("http://morknet.de");

		download.setTimeout(TIMEOUT);
		Assert.assertEquals(TIMEOUT, download.getTimeout());

		final byte [] array = download.downloadArray();
		Assert.assertNotNull(array);

		final String mimeType = download.getMimeType();
		Assert.assertTrue(mimeType.startsWith("text/html"));
	}

	@Test
	public void jee6() throws IOException
	{
		final Download download = new Download("http://jee6-generator.itemis.de");

		download.setTimeout(TIMEOUT);
		Assert.assertEquals(TIMEOUT, download.getTimeout());

		final byte [] array = download.downloadArray();
		Assert.assertNotNull(array);

		final String mimeType = download.getMimeType();
		Assert.assertTrue(mimeType.startsWith("text/html"));
	}

	@Test
	public void itemis() throws IOException
	{
		final Download download = new Download("http://www.itemis.de");

		download.setTimeout(TIMEOUT);
		Assert.assertEquals(TIMEOUT, download.getTimeout());

		final byte [] array = download.downloadArray();
		Assert.assertNotNull(array);

		final String mimeType = download.getMimeType();
		Assert.assertTrue(mimeType.startsWith("text/html"));
	}

	@Test
	public void image() throws IOException
	{
		final Download download = new Download(IMAGE_URL);

		String mimeType = download.getMimeType();
		Assert.assertNull(mimeType);

		final byte [] array = download.downloadArray();
		Assert.assertNotNull(array);

		mimeType = download.getMimeType();
		Assert.assertTrue(mimeType.startsWith("image/gif"));

		BufferedImage image = Download.parse(array);
		Assert.assertNotNull(image);

		mimeType = download.getMimeType();
		Assert.assertTrue(mimeType.startsWith("image/gif"));

		image = download.downloadImage();
		Assert.assertNotNull(image);

		mimeType = download.getMimeType();
		Assert.assertNull(mimeType);
	}

	@Test(expected=FileNotFoundException.class)
	public void error404() throws IOException
	{
		final Download download = new Download("http://morknet.de/404");

		download.setTimeout(TIMEOUT);
		Assert.assertEquals(TIMEOUT, download.getTimeout());

		download.downloadArray();
	}

	@Test(expected=MalformedURLException.class)
	public void malformedUrl() throws IOException
	{
		new Download("morknet");
	}
}
