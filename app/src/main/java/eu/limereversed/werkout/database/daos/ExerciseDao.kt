package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import eu.limereversed.werkout.database.entities.ExerciseData
import eu.limereversed.werkout.database.entities.ProgramData
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query("Select * from `exercise_table`")
    fun getAll(): Flow<List<ExerciseData>>

    @Query("Select * from `exercise_table` where id=:id")
    fun getById(id: Long): Flow<ExerciseData>

    @Query("Select * from `exercise_table` where id in (:ids)")
    fun getByIds(ids: List<Long>): Flow<List<ExerciseData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(exerciseData: ExerciseData)

    @Update
    suspend fun update(exerciseData: ExerciseData)

    @Delete
    suspend fun delete(exerciseData: ExerciseData)
}