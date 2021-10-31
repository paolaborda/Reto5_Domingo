package com.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepositorio {

    @Autowired
    private InterfaceReservation crud;

    public List<Reservation> getAll() {
        return (List<Reservation>) crud.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return crud.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return crud.save(reservation);
    }
    public void delete(Reservation reservation){
        crud.delete(reservation);
    }
    public List<Reservation> ReservacionStatusRepositorio (String status){
         return crud.findAllByStatus(status);
     }
     
     public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
         return crud.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<contadorCliente> getClientesRepositorio(){
         List<contadorCliente> res = new ArrayList<>();
         List<Object[]> report = crud.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new contadorCliente((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }   
}
