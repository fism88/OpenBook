package models;

import java.util.*;

import javax.persistence.*;

import controllers.Application;

import play.db.jpa.*;

@Entity
public class Profile extends Model {
  @OneToOne
  public User owner;
  public String gender; 
  /**
   * The user's locale (ISO Language Code and ISO Country
   */
  public String locale;

  @OneToOne
  public User significantOther; 
  public Date anniversary;

  public String bio; 
  
  /**
   * genders the user is intersted in: Male, Female, Both, Neither
   */
  public String interestedIn; 

  /**
   * The user's birthday, uses javascript: http://www.dynamicdrive.com/dynamicindex7/jasoncalendar.htm
   */
  public Date birthday;

  /**
   *  The user's current city
   */
  @ManyToOne
  public Location location; 
  @ManyToOne
  public Location hometown;

  // not implemented yet!!
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  public List<UserLanguage> languages; 

  /**
   *  The user's political view
   */
  public String political; 
  
  /**
   * The user's favorite quotes
   */
  public String quotes; 
  
  /**
   * The user's relationship
   * status:Single,In a relationship, Engaged,Married,It's
   * complicated,�In an open relationship,�Widowed,Separated,�Divorced,�In
   * a civil union,�In a domestic partnership
   */
  public String relationshipStatus; 

  /** 
   * User's religious views
   */
  public String religion; 

  /** 
   *  A list of the user's education history
   */
   @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
  public List<Enrollment> education; 

  /**
   * A list of the user's work history
   */
  @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
  public List<Employment> work; 


  //CONTACT INFORMATION
  public String phone; // the user's phone number
  public String address; // the user's address
  public String website; // the user's website
  public String email; //the user's email

  public boolean hasAnniversary()
  {
  	return !(relationshipStatus.equals("Single") || relationshipStatus.equals("It's complicated")
  		|| relationshipStatus.equals("Widowed") || relationshipStatus.equals("Separated") || relationshipStatus.equals("Divorced"));
  }

  public Profile(User owner) {

    this.anniversary = null;
    this.bio = "";
    this.birthday = null;
    this.interestedIn = "";
    this.relationshipStatus = "Single";
    this.gender = "";
    this.hometown = null;
    this.location = null;
    this.owner = owner;
    this.political = "";
    this.quotes = "";
    this.significantOther = null;
    this.religion = "";

    this.education = new ArrayList<Enrollment>();
    this.work = new ArrayList<Employment>();

    this.phone = "";
    this.address = "";
    this.website = "";
    this.email = "";

  }
}