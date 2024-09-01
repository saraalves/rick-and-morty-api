package com.saraalves.rickandmorty.data.repository

import com.saraalves.rickandmorty.data.mapper.character.AllCharacterResponseToModelMapper
import com.saraalves.rickandmorty.data.mapper.location.AllLocationMapperResponseToModelMapper
import org.junit.Before

class GetAllCharacterRepositoryImplTest {

//    @Mock
    private lateinit var locationListMapper : AllLocationMapperResponseToModelMapper
//    @Mock
    private lateinit var characterListMapper: AllCharacterResponseToModelMapper
    private lateinit var fakeRepository: FakeRepository

    @Before
    fun setup(){
//        MockitoAnnotations.openMocks(this)
        fakeRepository = FakeRepository(characterListMapper)
    }
}