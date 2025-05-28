package beans;

import java.time.LocalDate;

//コメント

public class Player {
	 private int id;
	    private int country_id;
	    private int uniform_num;
	    private String position;
	    private String name;
	    private String club;
	    private LocalDate birth; 
	    private double height;
	    private double weight;
	
	 public Player(int id, int country_id, int uniform_num, String position, String name, String club, LocalDate birth, double height, double weight) {
	    this.id = id;
        this.country_id = country_id;
        this.uniform_num = uniform_num;
        this.position = position;
        this.name = name;
        this.club = club;
        this.birth = birth;
        this.height = height;
        this.weight = weight;
}
	 public int getId() {
		 return id;
	 } 
	 public int getCountry_id() {
		 return country_id;
	 }
	 public int getUniform_num() {
		 return uniform_num;
	 }
	 public String getPosition() {
		 return position;
	 }
	 public String getName() {
		 return name;
	 }
	 public String getClub() {
		 return club;
	 }
	 public LocalDate getBirth() {
		 return birth;
	 }
	 public double getHeight() {
		 return height;
	 }
	 public double getWeight() {
		 return weight;
	 }
}
	 
