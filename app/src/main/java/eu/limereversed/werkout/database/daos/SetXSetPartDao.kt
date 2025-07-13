package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.limereversed.werkout.database.entities.ExercisePackXExercise
import eu.limereversed.werkout.database.entities.ExerciseXSet
import eu.limereversed.werkout.database.entities.ProgramXExercisePack
import eu.limereversed.werkout.database.entities.SetXSetPart
import kotlinx.coroutines.flow.Flow

@Dao
interface SetXSetPartDao {
    @Query("Select * from `set_x_set_part_table` where set_id=:setId")
    fun getBySetId(setId: Long): Flow<SetXSetPart>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(crossRef: SetXSetPart)

    @Delete
    suspend fun delete(crossRef: SetXSetPart)
}