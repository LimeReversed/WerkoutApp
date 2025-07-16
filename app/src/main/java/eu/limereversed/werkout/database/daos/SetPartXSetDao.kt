package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.limereversed.werkout.database.entities.SetPartXSet
import kotlinx.coroutines.flow.Flow

@Dao
interface SetPartXSetDao {
    @Query("Select * from `set_part_x_set_table` where set_id=:setId")
    fun getBySetId(setId: Long): Flow<SetPartXSet>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(crossRef: SetPartXSet)

    @Delete
    suspend fun delete(crossRef: SetPartXSet)
}