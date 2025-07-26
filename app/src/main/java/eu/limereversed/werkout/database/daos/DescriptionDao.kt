package eu.limereversed.werkout.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import eu.limereversed.werkout.database.entities.DescriptionData
import kotlinx.coroutines.flow.Flow

@Dao
interface DescriptionDao {

    @Query("Select * from `description_table`")
    fun getAll(): Flow<List<DescriptionData>>

    @Query("Select * from `description_table` where id=:id")
    fun getById(id: Long): Flow<DescriptionData>

    @Query("Select * from `description_table` where id in (:ids)")
    fun getByIds(ids: List<Long>): Flow<List<DescriptionData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(descriptionData: DescriptionData): Long

    @Update
    suspend fun update(descriptionData: DescriptionData)

    @Delete
    suspend fun delete(descriptionData: DescriptionData)
}