package com.store.Store.repository;

import com.store.Store.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MySqlRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT a FROM Address a JOIN FETCH a.city WHERE a.id IN :ids")
    List<Address> findByIdIn(int[] ids); // пример запроса для массива, только если указан массив


    @Query("SELECT a FROM Address a JOIN FETCH a.city")
    List<Address> findAllWithCity();



    //@Query(value = "SELECT id, Number, Street, Postcode, CONCAT(Street,  ' ', Postcode) as fullname FROM Addresses where id = :address_id",
    //        nativeQuery = true)
    //public Address findByCondition(@Param("address_id") int id);
}
