package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.limereversed.werkout.database.entities.SetPartXExercise
import kotlinx.coroutines.flow.Flow

@Dao
interface SetPartXExerciseDao {
    @Query("Select * from `set_part_x_exercise_table` where exercise_id=:exerciseId")
    fun getByExerciseId(exerciseId: Long): Flow<SetPartXExercise>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(crossRef: SetPartXExercise)

    @Delete
    suspend fun delete(crossRef: SetPartXExercise)
}