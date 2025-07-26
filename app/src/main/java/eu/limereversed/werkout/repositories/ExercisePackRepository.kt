package eu.limereversed.werkout.repositories

import eu.limereversed.werkout.database.daos.ExercisePackDao
import eu.limereversed.werkout.database.daos.ExercisePackXProgramDao
import eu.limereversed.werkout.database.entities.ExercisePackData
import eu.limereversed.werkout.database.entities.ExercisePackXProgram
import kotlinx.coroutines.flow.Flow

class ExercisePackRepository(private val exercisePackDao: ExercisePackDao, private val exercisePackXProgramDao: ExercisePackXProgramDao) {

    fun getByProgramId(programId: Long): Flow<List<ExercisePackData>> = exercisePackDao.getByProgramId(programId)

    suspend fun add(): Long = exercisePackDao.add()

    suspend fun assignToProgram(exercisePackId: Long, programId: Long) {
        exercisePackXProgramDao.add(ExercisePackXProgram(exercisePackId, programId))
    }

    suspend fun unassignFromProgram(exercisePackId: Long, programId: Long) {
        exercisePackXProgramDao.delete(ExercisePackXProgram(exercisePackId, programId))
    }
}