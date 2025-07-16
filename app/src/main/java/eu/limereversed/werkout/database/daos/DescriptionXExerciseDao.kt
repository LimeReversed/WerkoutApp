package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.limereversed.werkout.database.entities.DescriptionXExercise
import kotlinx.coroutines.flow.Flow

@Dao
interface DescriptionXExerciseDao {
    @Query("Select * from `description_x_exercise_table` where exercise_id=:exerciseId")
    fun getByExerciseId(exerciseId: Long): Flow<DescriptionXExercise>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(crossRef: DescriptionXExercise)

    @Delete
    suspend fun delete(crossRef: DescriptionXExercise)
}