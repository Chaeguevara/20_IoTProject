package com.sds;

public class Geo {
	private String name;
	private double lat;
	private double lng;
	private String url;
	public Geo() {
	}
	public Geo(String name, double lat, double lng, String url) {
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Geo [name=" + name + ", lat=" + lat + ", lng=" + lng + ", url=" + url + "]";
	}
	
	
}
