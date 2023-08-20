package com.example.assignment21.Repositroy;

import com.example.assignment21.Model.Address;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepositroy extends JpaRepository<Address,Integer> {

Address findAddressById(Integer id);


}
