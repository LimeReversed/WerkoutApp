package eu.limereversed.werkout.repositories

import eu.limereversed.werkout.database.daos.DescriptionDao
import eu.limereversed.werkout.database.daos.DescriptionXExerciseDao
import eu.limereversed.werkout.database.entities.DescriptionData
import eu.limereversed.werkout.database.entities.DescriptionXExercise
import kotlinx.coroutines.flow.Flow

class DescriptionRepository(private val descriptionDao: DescriptionDao, private val descriptionXExerciseDao: DescriptionXExerciseDao) {
    fun getAll(): Flow<List<DescriptionData>> = descriptionDao.getAll()

    fun getById(id: Long): Flow<DescriptionData> = descriptionDao.getById(id)

    fun getByIds(ids: List<Long>): Flow<List<DescriptionData>> = descriptionDao.getByIds(ids)

    suspend fun add(descriptionData: DescriptionData): Long {
        return descriptionDao.add(descriptionData)
    }

    suspend fun update(descriptionData: DescriptionData) {
        descriptionDao.update(descriptionData)
    }

    suspend fun delete(descriptionData: DescriptionData) {
        descriptionDao.delete(descriptionData)
    }

    suspend fun assignToExercise(descriptionId: Long, exerciseId: Long) {
        descriptionXExerciseDao.add(DescriptionXExercise(descriptionId, exerciseId))
    }

    suspend fun unassignFromExercise(descriptionId: Long, exerciseId: Long) {
        descriptionXExerciseDao.delete(DescriptionXExercise(descriptionId, exerciseId))
    }
}