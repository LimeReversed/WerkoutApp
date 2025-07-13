package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.limereversed.werkout.database.entities.ExercisePackXExercise
import eu.limereversed.werkout.database.entities.ExerciseXDescription
import eu.limereversed.werkout.database.entities.ExerciseXSet
import eu.limereversed.werkout.database.entities.ProgramXExercisePack
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseXDescriptionDao {
    @Query("Select * from `exercise_x_description_table` where exercise_id=:exerciseId")
    fun getByExerciseId(exerciseId: Long): Flow<ExerciseXDescription>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(crossRef: ExerciseXDescription)

    @Delete
    suspend fun delete(crossRef: ExerciseXDescription)
}