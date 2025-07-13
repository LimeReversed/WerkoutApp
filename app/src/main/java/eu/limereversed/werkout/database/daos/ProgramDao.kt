package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import eu.limereversed.werkout.database.entities.ProgramData
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgramDao {

    @Query("Select * from `program_table`")
    fun getAll(): Flow<List<ProgramData>>

    @Query("Select * from `program_table` where id=:id")
    fun getById(id: Long): Flow<ProgramData>

    @Query("Select * from `program_table` where id in (:ids)")
    fun getByIds(ids: List<Long>): Flow<List<ProgramData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(programData: ProgramData)

    @Update
    suspend fun update(programData: ProgramData)

    @Delete
    suspend fun delete(programData: ProgramData)
}