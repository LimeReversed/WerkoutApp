package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.limereversed.werkout.database.entities.ExercisePackXExercise
import eu.limereversed.werkout.database.entities.ProgramXExercisePack
import kotlinx.coroutines.flow.Flow

@Dao
interface ExercisePackXExerciseDao {
    @Query("Select * from `exercise_pack_x_exercise_table` where exercise_pack_id=:exercisePackId")
    fun getByExercisePackId(exercisePackId: Long): Flow<ExercisePackXExercise>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(crossRef: ExercisePackXExercise)

    @Delete
    suspend fun delete(crossRef: ExercisePackXExercise)
}