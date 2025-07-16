package eu.limereversed.werkout.repositories

import eu.limereversed.werkout.database.daos.ExercisePackXProgramDao
import eu.limereversed.werkout.database.entities.ExercisePackXProgram
import eu.limereversed.werkout.database.entities.ExerciseXExercisePack

class ExercisePackRepository(private val exercisePackXProgramDao: ExercisePackXProgramDao) {

    suspend fun assignToProgram(exercisePackId: Long, programId: Long) {
        exercisePackXProgramDao.add(ExercisePackXProgram(exercisePackId, programId))
    }

    suspend fun unassignFromProgram(exercisePackId: Long, programId: Long) {
        exercisePackXProgramDao.delete(ExercisePackXProgram(exercisePackId, programId))
    }
}