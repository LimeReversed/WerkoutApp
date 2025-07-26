package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import eu.limereversed.werkout.database.entities.ExerciseData
import eu.limereversed.werkout.database.entities.ProgramData
import eu.limereversed.werkout.database.entities.SetData
import kotlinx.coroutines.flow.Flow

@Dao
interface SetDao {

    @Query("Select * from `set_table`")
    fun getAll(): Flow<List<SetData>>

    @Query("Select * from `set_table` where id=:id")
    fun getById(id: Long): Flow<SetData>

    @Query("Select * from `set_table` where id in (:ids)")
    fun getByIds(ids: List<Long>): Flow<List<SetData>>

    @Query("Select * from `set_table` join `set_x_exercise_table` as `exercise` on exercise.set_id = set_table.id  where exercise.exercise_id=:exerciseId")
    fun getByExerciseId(exerciseId: Long): Flow<List<SetData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(setData: SetData): Long

    @Update
    suspend fun update(setData: SetData)

    @Delete
    suspend fun delete(setData: SetData)
}