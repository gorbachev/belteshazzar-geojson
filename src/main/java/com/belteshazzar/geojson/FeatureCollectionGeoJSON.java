package com.belteshazzar.geojson;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * A Bean representation of a GeoJSON Feature Collection.
 * 
 * From the GeoJSON Specification version 1.0:
 * 
 * The value corresponding to "features" is an array.
 * Each element in the array is a feature object as
 * defined above.
 */
public class FeatureCollectionGeoJSON extends GeoJSON
{
	public List<FeatureGeoJSON> features;
	public Map<String,JsonNode> properties;

	@Override
	public boolean isValid( PositionValidator validator )
	{
		if ( features==null ) return false;
		if ( features.size()==0 ) return false;

		for ( FeatureGeoJSON feature : features )
		{
			if ( !feature.isValid(validator) ) return false;
		}

		return super.isValid(validator);
	}

	@Override
	public String getType() {
		return "FeatureCollection";
	}
}
