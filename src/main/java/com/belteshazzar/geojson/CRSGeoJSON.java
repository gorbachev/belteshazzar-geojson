package com.belteshazzar.geojson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * A Bean representation of a GeoJSON coordinate reference system (CRS) object.
 */
@JsonTypeInfo(use=Id.NAME,include=As.PROPERTY,property="type")
@JsonSubTypes({
	@JsonSubTypes.Type(value=NamedCRSGeoJSON.class,  name="name"),
	@JsonSubTypes.Type(value=LinkedCRSGeoJSON.class, name="link")
})
abstract class CRSGeoJSON implements Validation {}
