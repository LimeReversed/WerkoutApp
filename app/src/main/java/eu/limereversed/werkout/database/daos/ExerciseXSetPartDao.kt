package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.limereversed.werkout.database.entities.ExercisePackXExercise
import eu.limereversed.werkout.database.entities.ExerciseXSet
import eu.limereversed.werkout.database.entities.ExerciseXSetPart
import eu.limereversed.werkout.database.entities.ProgramXExercisePack
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseXSetPartDao {
    @Query("Select * from `exercise_x_set_part_table` where exercise_id=:exerciseId")
    fun getByExerciseId(exerciseId: Long): Flow<ExerciseXSetPart>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(crossRef: ExerciseXSetPart)

    @Delete
    suspend fun delete(crossRef: ExerciseXSetPart)
}