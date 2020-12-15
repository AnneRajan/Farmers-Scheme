package com.lti.service;
import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.lti.model.FileInfo;
import com.lti.repository.FileUpload;


@Service
public class FileStorageService {

  @Autowired
  private FileUpload fileupload;

  public FileInfo store(String email_id,String getrole,MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
 
   
    FileInfo f = new FileInfo(fileName, file.getContentType(), email_id,getrole,file.getBytes());

    return fileupload.save(f);
  }

  public FileInfo getFile(String id) {
    return fileupload.findById(id).get();
  }
  
  public Stream<FileInfo> getAllFiles( ) {
    return fileupload.findAll().stream();
  }
  
 
}
