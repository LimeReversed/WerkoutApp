package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.limereversed.werkout.database.entities.ExerciseXExercisePack
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseXExercisePackDao {
    /*
    * Debated whether it should be ExercisePackXExercise or ExerciseXExercise pack.
    * I decided I wanted to assign and unassign upwards. Assign exercise to pack.
    * I usually want to get exerciseIds from exercisePackIds.
    * With all that in mind I want to put this in the ExerciseRepository, not ExercisePackRepository
    * so Exercise should go first.
    */
    @Query("Select * from `exercise_x_exercise_pack_table` where exercise_pack_id=:exercisePackId")
    fun getByExercisePackId(exercisePackId: Long): Flow<ExerciseXExercisePack>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(crossRef: ExerciseXExercisePack)

    @Delete
    suspend fun delete(crossRef: ExerciseXExercisePack)
}