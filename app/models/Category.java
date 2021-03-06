package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Category extends Model {

  public String name;

  @OneToMany(mappedBy="category", cascade=CascadeType.ALL)
  public List<FThread> threads;

  public Category(String name) {
    this.name = name;

  }
  
  public FThread get_most_recent(){
    return FThread.find("category = ? order by postedAt desc", this).first();
  }
}