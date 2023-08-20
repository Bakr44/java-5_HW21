package com.example.assignment21.Service;

import com.example.assignment21.Api.ApiExeption;
import com.example.assignment21.DTO.AddressDTO;
import com.example.assignment21.Model.Address;
import com.example.assignment21.Model.Teacher;
import com.example.assignment21.Repositroy.AddressRepositroy;
import com.example.assignment21.Repositroy.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

private final AddressRepositroy addressRepository;
private final TeacherRepository teacherRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO) {
        Teacher teacher=teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher==null){
            throw new ApiExeption("ID Not Found");
        }
        Address address=new Address(null,addressDTO.getArea(),addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
         addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO) {
        Address address1 = addressRepository.findAddressById(addressDTO.getTeacher_id());
                if (address1==null){
                    throw new ApiExeption("Address not found");
                }

        address1.setArea(addressDTO.getArea());
        address1.setStreet(addressDTO.getStreet());
        address1.setBuildingNumber(addressDTO.getBuildingNumber());
         addressRepository.save(address1);
    }

    public void deleteAddress(Integer id) {
        Teacher teacher=teacherRepository.findTeacherById(id);
        Address address =teacher.getAddress();
        if(address==null){
         throw new ApiExeption("Address not found");
        }
        addressRepository.delete(address);
    }




}
