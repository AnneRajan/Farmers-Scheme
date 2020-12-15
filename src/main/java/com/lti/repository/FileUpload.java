package com.lti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.lti.model.FileInfo;



@Repository
public interface FileUpload extends JpaRepository<FileInfo, String> {

 

}
