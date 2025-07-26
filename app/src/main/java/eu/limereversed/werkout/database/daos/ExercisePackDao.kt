package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import eu.limereversed.werkout.database.entities.ExercisePackData
import eu.limereversed.werkout.database.entities.ExerciseData
import eu.limereversed.werkout.database.entities.ProgramData
import eu.limereversed.werkout.database.entities.SetData
import eu.limereversed.werkout.database.entities.SetPartData
import kotlinx.coroutines.flow.Flow

@Dao
interface ExercisePackDao {

    @Query("Select * from `exercise_pack_table`")
    fun getAll(): Flow<List<ExercisePackData>>

    @Query("Select * from `exercise_pack_table` where id=:id")
    fun getById(id: Long): Flow<ExercisePackData>

    @Query("Select * from `exercise_pack_table` where id in (:ids)")
    fun getByIds(ids: List<Long>): Flow<List<ExercisePackData>>

    @Query("Select * from `exercise_pack_table` " +
            "join `exercise_pack_x_program_table` " +
            "on exercise_pack_x_program_table.exercise_pack_id = exercise_pack_table.id  " +
            "where exercise_pack_x_program_table.program_id=:programId")
    fun getByProgramId(programId: Long): Flow<List<ExercisePackData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(exerciseData: ExerciseData = ExerciseData()): Long

    @Update
    suspend fun update(exercisePackData: ExercisePackData)

    @Delete
    suspend fun delete(exercisePackData: ExercisePackData)
}