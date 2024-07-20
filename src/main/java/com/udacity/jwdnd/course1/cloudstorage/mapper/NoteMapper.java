package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM NOTES")
    List<Note> getAllNotes();

    @Insert("INSERT INTO NOTES(notetitle, notedescription, userid) " +
            " VALUES(#{noteTitle}, #{noteDescription}, #{userId}")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    Integer insertNotes(Note note);

    @Update("UPDATE NOTES SET notetitle = #{noteTitle}, notedescription = #{noteDescription} " +
                   "WHERE noteid = #{noteId}")
    Integer updateNote(Note note);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteId}")
    Integer deleteNoteById(Integer noteId);
}
