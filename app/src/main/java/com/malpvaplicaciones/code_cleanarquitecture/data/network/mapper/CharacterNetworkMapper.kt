package com.malpvaplicaciones.code_cleanarquitecture.data.network.mapper

import com.malpvaplicaciones.code_cleanarquitecture.core.util.EntityMapper
import com.malpvaplicaciones.code_cleanarquitecture.domain.Character
import com.malpvaplicaciones.code_cleanarquitecture.data.network.response.CharacterNetworkEntity
import javax.inject.Inject

class CharacterNetworkMapper
@Inject
constructor(): EntityMapper<CharacterNetworkEntity, Character>{

    override fun mapFromEntity(entity: CharacterNetworkEntity): Character {
        return Character(
            id = entity.id,
            name = entity.name,
            status = entity.status,
            species = entity.species,
            gender = entity.gender,
            urlImage = entity.image
        )
    }

    override fun mapToEntity(domainModel: Character): CharacterNetworkEntity {
        return CharacterNetworkEntity(
            id = domainModel.id,
            name = domainModel.name,
            status = domainModel.status,
            species = domainModel.species,
            gender = domainModel.gender,
            image = domainModel.urlImage
        )
    }

    fun mapFromEntityList(entities: List<CharacterNetworkEntity>): List<Character>{
        return entities.map { mapFromEntity(it) }
    }
}