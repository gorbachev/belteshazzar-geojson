package com.belteshazzar.geojson;

import java.util.List;

/**
 * A Bean representation of a GeoJSON Polygon geometry object.
 * 
 * From the GeoJSON Specification version 1.0:
 *
 * For type "Point", the "coordinates" member must be a single position.
 */
public class PointGeoJSON extends GeometryGeoJSON
{
	public List<Double> coordinates;
	
	@Override
	public boolean isValid( PositionValidator validator )
	{
		return validator.isValid(coordinates) && super.isValid(validator);
	}
}
