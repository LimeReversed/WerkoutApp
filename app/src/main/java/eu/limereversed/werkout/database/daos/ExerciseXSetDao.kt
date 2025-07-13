package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.limereversed.werkout.database.entities.ExercisePackXExercise
import eu.limereversed.werkout.database.entities.ExerciseXSet
import eu.limereversed.werkout.database.entities.ProgramXExercisePack
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseXSetDao {
    @Query("Select * from `exercise_x_set_table` where exercise_id=:exerciseId")
    fun getByExerciseId(exerciseId: Long): Flow<ExerciseXSet>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(crossRef: ExerciseXSet)

    @Delete
    suspend fun delete(crossRef: ExerciseXSet)
}