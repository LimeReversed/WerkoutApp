package eu.limereversed.werkout.repositories

import eu.limereversed.werkout.database.daos.ProgramDao
import eu.limereversed.werkout.database.entities.ProgramData
import kotlinx.coroutines.flow.Flow

// A repository is responsible for communicating with the database.
class ProgramRepository(private val programDao: ProgramDao) {
    fun getAll(): Flow<List<ProgramData>> = programDao.getAll()

    fun getById(id: Long): Flow<ProgramData> = programDao.getById(id)

    fun getByIds(ids: List<Long>): Flow<List<ProgramData>> = programDao.getByIds(ids)

    suspend fun add(programData: ProgramData){
        programDao.add(programData)
    }

    suspend fun update(programData: ProgramData) {
        programDao.update(programData)
    }

    suspend fun delete(programData: ProgramData) {
        programDao.delete(programData)
    }
}