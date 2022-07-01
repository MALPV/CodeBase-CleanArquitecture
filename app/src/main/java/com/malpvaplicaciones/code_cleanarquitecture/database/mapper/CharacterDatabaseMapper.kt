package com.malpvaplicaciones.code_cleanarquitecture.database.mapper

import com.malpvaplicaciones.code_cleanarquitecture.core.util.EntityMapper
import com.malpvaplicaciones.code_cleanarquitecture.database.entity.CharacterDatabaseEntity
import com.malpvaplicaciones.code_cleanarquitecture.domain.Character
import javax.inject.Inject

class CharacterDatabaseMapper
@Inject
constructor(): EntityMapper<CharacterDatabaseEntity, Character>{

    override fun mapFromEntity(entity: CharacterDatabaseEntity): Character {
        return Character(
            id = entity.id,
            name = entity.name,
            status = entity.status,
            species = entity.species,
            gender = entity.gender,
            urlImage = entity.urlImage
        )
    }

    override fun mapToEntity(domainModel: Character): CharacterDatabaseEntity {
        return CharacterDatabaseEntity(
            id = domainModel.id,
            name = domainModel.name,
            status = domainModel.status,
            species = domainModel.species,
            gender = domainModel.gender,
            urlImage = domainModel.urlImage
        )
    }

    fun mapFromEntityList(entities: List<CharacterDatabaseEntity>): List<Character>{
        return entities.map { mapFromEntity(it) }
    }
}