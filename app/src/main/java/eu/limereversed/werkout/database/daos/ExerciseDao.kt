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

    @Query("Select * from `exercise_table` as `exercise` join `exercise_x_exercise_pack_table` as `exercise_pack` on exercise_pack.exercise_id = exercise.id  where exercise_pack.exercise_pack_id=:exercisePackId")
    fun getByExercisePackId(exercisePackId: Long): Flow<List<ExerciseData>>

    @Query("Select * from `exercise_table` where id in (:ids)")
    fun getByIds(ids: List<Long>): Flow<List<ExerciseData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(exerciseData: ExerciseData): Long

    @Update
    suspend fun update(exerciseData: ExerciseData)

    @Delete
    suspend fun delete(exerciseData: ExerciseData)
}