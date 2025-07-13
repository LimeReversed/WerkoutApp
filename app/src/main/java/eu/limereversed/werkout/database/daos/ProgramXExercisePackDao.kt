package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.limereversed.werkout.database.entities.ProgramXExercisePack
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgramXExercisePackDao {
    @Query("Select * from `program_x_exercise_pack_table` where program_id=:programId")
    fun getByProgramId(programId: Long): Flow<ProgramXExercisePack>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(crossRef: ProgramXExercisePack)

    @Delete
    suspend fun delete(crossRef: ProgramXExercisePack)
}