package search.city;



public class City { 
    public int id;
    public String country;
    public double latitude;
    public double longitude;
    
    //public City() {}
    
    public void print() {
        System.out.println(country);
    }
    
    public int getId() {return id;}
    
    public String getCountry() {return country;}
    
    public double getLongitude() {return longitude;}
    
    public double getLatitude() {return latitude;}

    public void setId(int id) {
	this.id = id;
    }
    
    public void setCountry(String country) {
	this.country = country;
    }
    
    public void setLongitude(double longitude) {
	this.longitude = longitude;
    }
    
    public void setLatitude(double latitude) {
	this.latitude = latitude;
    }
    

}
