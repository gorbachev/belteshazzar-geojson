package com.belteshazzar.geojson;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * A Bean representation of a GeoJSON base object.
 */
@JsonTypeInfo(use=Id.NAME,include=As.PROPERTY,property="type")
@JsonSubTypes({
	@JsonSubTypes.Type(value=PointGeoJSON.class,				name="Point"),
	@JsonSubTypes.Type(value=MultiPointGeoJSON.class,			name="MultiPoint"),
	@JsonSubTypes.Type(value=LineStringGeoJSON.class,			name="LineString"),
	@JsonSubTypes.Type(value=MultiLineStringGeoJSON.class,		name="MultiLineString"),
	@JsonSubTypes.Type(value=PolygonGeoJSON.class,				name="Polygon"),
	@JsonSubTypes.Type(value=MultiPolygonGeoJSON.class,			name="MultiPolygon"),
	@JsonSubTypes.Type(value=GeometryCollectionGeoJSON.class,	name="GeometryCollection"),
	@JsonSubTypes.Type(value=FeatureGeoJSON.class,				name="Feature"),
	@JsonSubTypes.Type(value=FeatureCollectionGeoJSON.class,	name="FeatureCollection")
})
public abstract class GeoJSON implements Validation
{
	public CRSGeoJSON crs;
	public List<Double> bbox;
	protected Map<String,JsonNode> properties;

	@JsonAnySetter
	public void add(String key, JsonNode value)
	{
		properties.put(key, value);
	}

	@JsonAnyGetter
	public Map<String,JsonNode> getProperties()
	{
		return properties;
	}
	    
	@Override
	public boolean isValid( PositionValidator validator )
	{
		if ( crs!=null && !crs.isValid(validator) ) return false;
		if ( !validator.isValidBB(bbox) ) return false;
		return true;
	}

	public abstract String getType();
}
