package eu.limereversed.werkout.repositories

import eu.limereversed.werkout.database.daos.SetDao
import eu.limereversed.werkout.database.daos.SetXExerciseDao
import eu.limereversed.werkout.database.entities.SetData
import eu.limereversed.werkout.database.entities.ExerciseXExercisePack
import eu.limereversed.werkout.database.entities.SetXExercise
import kotlinx.coroutines.flow.Flow

class SetRepository(private val setDao: SetDao, private val setXExerciseDao: SetXExerciseDao) {
    fun getAll(): Flow<List<SetData>> = setDao.getAll()

    fun getById(id: Long): Flow<SetData> = setDao.getById(id)

    fun getByIds(ids: List<Long>): Flow<List<SetData>> = setDao.getByIds(ids)

    fun getByExerciseId(exerciseId: Long): Flow<List<SetData>> = setDao.getByExerciseId((exerciseId))

    suspend fun add(setData: SetData): Long {
        return setDao.add(setData)
    }

    suspend fun update(setData: SetData) {
        setDao.update(setData)
    }

    suspend fun delete(setData: SetData) {
        setDao.delete(setData)
    }

    suspend fun assignToExercise(setId: Long, exerciseId: Long) {
        setXExerciseDao.add(SetXExercise(setId, exerciseId))
    }

    suspend fun unassignFromExercise(setId: Long, exerciseId: Long) {
        setXExerciseDao.delete(SetXExercise(setId, exerciseId))
    }
}