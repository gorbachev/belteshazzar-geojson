package com.belteshazzar.geojson.test;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;

import com.belteshazzar.geojson.GeoJSON;
import com.belteshazzar.geojson.validation.LonLatValidator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestCase
{
	@Test
	public void testFeatureCollection01()
	{
		test();
	}

	@Test
	public void testFeatureCollection02()
	{
		test();
	}

	@Test
	public void testGeometryCollection01()
	{
		test();
	}

	@Test
	public void testLineString01()
	{
		test();
	}

	@Test
	public void testMultiLineString01()
	{
		test();
	}

	@Test
	public void testMultiPoint01()
	{
		test();
	}

	@Test
	public void testMultiPolygon01()
	{
		test();
	}

	@Test
	public void testPoint01()
	{
		test();
	}

	@Test
	public void testPolygonNoHoles01()
	{
		test();
	}

	@Test
	public void testPolygonWithHoles01()
	{
		test();
	}

	private void test()
	{
		System.out.println("running test");

		String filename = null;
		try
		{
			throw new Exception();
		}
		catch ( Exception ex )
		{
			try
			{
				System.out.println("Called by: " + ex.getStackTrace()[1].getMethodName());
				filename = ex.getStackTrace()[1].getMethodName().substring(4);
				System.out.println("filename = " + filename);
			}
			catch (IndexOutOfBoundsException iex)
			{
				iex.printStackTrace();
				fail("Could not get filename.");
			}
		}
		
		filename = "/" + filename + ".json";
		System.out.println("filename = " + filename);

		URL url = this.getClass().getResource(filename);

		System.out.println("url = " + url);
		try
		{
			ObjectMapper mapper = new ObjectMapper();

			GeoJSON geojson = mapper.readValue(url, GeoJSON.class);
			
			System.out.println("parsed: " + geojson);
			
			System.out.println("isValid = " + geojson.isValid(new LonLatValidator()));
		}
		catch (JsonParseException e)
		{
			e.printStackTrace();
			fail();
		}
		catch (JsonMappingException e)
		{
			e.printStackTrace();
			fail();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			fail();
		}
	}
}
