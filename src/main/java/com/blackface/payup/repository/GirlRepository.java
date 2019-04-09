package com.blackface.payup.repository;

import com.blackface.payup.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Author:lwenm
 * Description:
 * Date:2019/4/9
 * Time:21:49
 **/
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //通过年龄来查询
    public List<Girl> findByAge(Integer age);

    Optional<Girl> findById(Integer id);

}
