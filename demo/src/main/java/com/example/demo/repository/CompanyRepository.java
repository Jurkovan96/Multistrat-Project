package com.example.demo.repository;

import com.example.demo.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    List<Company> findAll();

    List<Company> findByCompanyName(String companyName);

    Company findByUserId(Integer userId);

    Company findAllByAddress_AddressId(Integer address_addressId);

    @Modifying
    @Transactional
    @Query("update Company c set c.password=:password, c.email=:email, c.phoneNumber=:phone, c.companyName=:companyName, c.companyCode=:companyCode, c.contactPerson=:contactPerson where c.userId=:id")
    void updateStudent(@Param("id") Integer id, @Param("password") String password, @Param("email") String email,
                       @Param("companyName") String companyName, @Param("companyCode") String companyCode,
                       @Param("contactPerson") String contactPerson, @Param("phone") String phone);

}
