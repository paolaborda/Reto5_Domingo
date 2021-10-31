
package com.user;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SkateRepository {
  @Autowired  
  private InterfaceSkate crud;
  
  public List<Skate>getAll(){
      return (List<Skate>) crud.findAll();
  }
  public Optional <Skate> getSkate(int id){
  return crud.findById(id);
  }
  public Skate save(Skate skate){
      return crud.save(skate);
  }
  public void delete(Skate skate){
        crud.delete(skate);
    }
}
