package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Select("SELECT * FROM FILES")
    List<File> getAllFiles();

    @Insert("INSERT INTO FILES(filename, contenttype, filesize, userid, filedata) " +
            " VALUES(#{fileName}, #{contentType}, #{fileSize}, #{userId}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    Integer insertFile(File file);

    @Update("UPDATE FILES SET filename = #{fileName}, contenttype = #{contentType}, " +
            "filesize = #{fileSize}, filedata = #{fileData} WHERE fileId = #{fileId}")
    Integer updateFile(File file);

    @Delete("DELETE FROM FILES WHERE fileId = #{fileId}")
    Integer deleteFile(Integer fileId);

}
