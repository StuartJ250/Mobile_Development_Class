package com.example.d308jacobson.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.d308jacobson.entities.Excursion;
import com.example.d308jacobson.entities.Vacation;

import java.util.List;

@Dao
public interface ExcursionDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Excursion excursion);

    @Update
    void update(Excursion excursion);

    @Delete
    void delete(Excursion excursion);


    @Query("SELECT * FROM Excursions ORDER BY excursionID ASC")
    List<Excursion> getAllExcursions();

    @Query("SELECT * FROM Excursions WHERE vacationID = :vID ORDER BY excursionID ASC")
    List<Excursion> getAssociatedExcursions(int vID);
}
