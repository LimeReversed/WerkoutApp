package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.limereversed.werkout.database.entities.ExercisePackXProgram
import kotlinx.coroutines.flow.Flow

@Dao
interface ExercisePackXProgramDao {
    @Query("Select * from `exercise_pack_x_program_table` where program_id=:programId")
    fun getByProgramId(programId: Long): Flow<List<ExercisePackXProgram>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(crossRef: ExercisePackXProgram)

    @Delete
    suspend fun delete(crossRef: ExercisePackXProgram)
}