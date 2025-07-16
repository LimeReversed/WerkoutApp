package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.limereversed.werkout.database.entities.SetXExercise
import kotlinx.coroutines.flow.Flow

@Dao
interface SetXExerciseDao {
    @Query("Select * from `set_x_exercise_table` where exercise_id=:exerciseId")
    fun getByExerciseId(exerciseId: Long): Flow<SetXExercise>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(crossRef: SetXExercise)

    @Delete
    suspend fun delete(crossRef: SetXExercise)
}