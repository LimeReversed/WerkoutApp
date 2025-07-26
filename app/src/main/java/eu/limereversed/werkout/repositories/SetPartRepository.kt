package eu.limereversed.werkout.repositories

import eu.limereversed.werkout.database.daos.SetPartDao
import eu.limereversed.werkout.database.daos.SetPartXExerciseDao
import eu.limereversed.werkout.database.daos.SetPartXSetDao
import eu.limereversed.werkout.database.entities.SetPartData
import eu.limereversed.werkout.database.entities.SetPartXExercise
import eu.limereversed.werkout.database.entities.SetPartXSet
import kotlinx.coroutines.flow.Flow

class SetPartRepository(private val setPartDao: SetPartDao, private val setPartXSetDao: SetPartXSetDao, private val setPartXExerciseDao: SetPartXExerciseDao) {
    fun getAll(): Flow<List<SetPartData>> = setPartDao.getAll()

    fun getById(id: Long): Flow<SetPartData> = setPartDao.getById(id)

    fun getByIds(ids: List<Long>): Flow<List<SetPartData>> = setPartDao.getByIds(ids)

    fun getBySetId(setId: Long): Flow<List<SetPartData>> = setPartDao.getBySetId(setId)

    suspend fun add(setPartData: SetPartData): Long {
        return setPartDao.add(setPartData)
    }

    suspend fun update(setPartData: SetPartData) {
        setPartDao.update(setPartData)
    }

    suspend fun delete(setPartData: SetPartData) {
        setPartDao.delete(setPartData)
    }

    suspend fun assignToSet(setPartId: Long, setId: Long) {
        setPartXSetDao.add(SetPartXSet(setPartId, setId))
    }

    suspend fun unassignFromSet(setPartId: Long, setId: Long) {
        setPartXSetDao.delete(SetPartXSet(setPartId, setId))
    }

    suspend fun assignToExercise(setPartId: Long, exerciseId: Long) {
        setPartXExerciseDao.add(SetPartXExercise(setPartId, exerciseId))
    }

    suspend fun unassignFromExercise(setPartId: Long, exerciseId: Long) {
        setPartXExerciseDao.delete(SetPartXExercise(setPartId, exerciseId))
    }
}