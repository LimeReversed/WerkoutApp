package eu.limereversed.werkout.repositories

import eu.limereversed.werkout.database.daos.ExerciseDao
import eu.limereversed.werkout.database.daos.ExerciseXExercisePackDao
import eu.limereversed.werkout.database.entities.ExerciseData
import eu.limereversed.werkout.database.entities.ExerciseXExercisePack
import kotlinx.coroutines.flow.Flow

class ExerciseRepository(private val exerciseDao: ExerciseDao, private val exerciseXExercisePackDao: ExerciseXExercisePackDao) {
    fun getAll(): Flow<List<ExerciseData>> = exerciseDao.getAll()

    fun getById(id: Long): Flow<ExerciseData> = exerciseDao.getById(id)

    fun getByIds(ids: List<Long>): Flow<List<ExerciseData>> = exerciseDao.getByIds(ids)

    suspend fun add(exerciseData: ExerciseData){
        exerciseDao.add(exerciseData)
    }

    suspend fun update(exerciseData: ExerciseData) {
        exerciseDao.update(exerciseData)
    }

    suspend fun delete(exerciseData: ExerciseData) {
        exerciseDao.delete(exerciseData)
    }

    suspend fun assignToExercisePack(exerciseId: Long, exercisePackId: Long) {
        exerciseXExercisePackDao.add(ExerciseXExercisePack(exerciseId, exercisePackId))
    }

    suspend fun unassignFromExercisePack(exerciseId: Long, exercisePackId: Long) {
        exerciseXExercisePackDao.delete(ExerciseXExercisePack(exerciseId, exercisePackId))
    }
}