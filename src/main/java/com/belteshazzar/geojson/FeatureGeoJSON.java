package com.belteshazzar.geojson;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * A Bean representation of a GeoJSON Feature.
 * 
 * From the GeoJSON Specification version 1.0:
 * 
 * A feature object must have a member with the name "geometry". The value
 * of the geometry member is a geometry object as defined above or a JSON
 * null value.
 * 
 * A feature object must have a member with the name "properties". The value
 * of the properties member is an object (any JSON object or a JSON null
 * value).
 * 
 * If a feature has a commonly used identifier, that identifier should be
 * included as a member of the feature object with the name "id".
 */
public class FeatureGeoJSON extends GeoJSON
{
	public GeoJSON geometry;
	public Map<String,JsonNode> properties;
	public String id;

	@Override
	public boolean isValid( PositionValidator validator )
	{
		if (geometry==null ) return false;
		if ( !geometry.isValid(validator) ) return false;

		return super.isValid(validator);
	}
}
