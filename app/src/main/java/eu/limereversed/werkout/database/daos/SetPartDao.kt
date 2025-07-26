package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import eu.limereversed.werkout.database.entities.ExerciseData
import eu.limereversed.werkout.database.entities.ProgramData
import eu.limereversed.werkout.database.entities.SetData
import eu.limereversed.werkout.database.entities.SetPartData
import kotlinx.coroutines.flow.Flow

@Dao
interface SetPartDao {

    @Query("Select * from `set_part_table`")
    fun getAll(): Flow<List<SetPartData>>

    @Query("Select * from `set_part_table` where id=:id")
    fun getById(id: Long): Flow<SetPartData>

    @Query("Select * from `set_part_table` where id in (:ids)")
    fun getByIds(ids: List<Long>): Flow<List<SetPartData>>

    @Query("Select * from `set_part_table` join `set_part_x_set_table` on set_part_table.id = set_part_x_set_table.set_part_id  where set_part_x_set_table.set_id = :setId")
    fun getBySetId(setId: Long): Flow<List<SetPartData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(setPartData: SetPartData): Long

    @Update
    suspend fun update(setPartData: SetPartData)

    @Delete
    suspend fun delete(setPartData: SetPartData)
}