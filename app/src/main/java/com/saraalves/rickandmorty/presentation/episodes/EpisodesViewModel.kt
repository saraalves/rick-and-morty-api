package com.saraalves.rickandmorty.presentation.episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.domain.exception.ConnectionError
import com.saraalves.rickandmorty.domain.model.response.episodes.AllEpisodes
import com.saraalves.rickandmorty.domain.model.response.episodes.SingleEpisode
import com.saraalves.rickandmorty.domain.usecase.episodes.GetAllEpisodesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.random.Random

class EpisodesViewModel(
    private val getAllEpisodesUseCase: GetAllEpisodesUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _allEpisodes = MutableLiveData<AllEpisodes>()
    var allEpisodes: LiveData<AllEpisodes> = _allEpisodes

    private val _episodes = MutableLiveData<List<SingleEpisode>>()
    var episodes: LiveData<List<SingleEpisode>> = _episodes

    private val _loading = MutableLiveData<Boolean>()
    var loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<Pair<Int, Int>>()
    var error: LiveData<Pair<Int, Int>> = _error

    private val page = Random.nextInt(1, 3)

    init {
        getAllEpisodes()
    }

    private fun getAllEpisodes() {
        viewModelScope.launch {
            getAllEpisodesUseCase(page)
                .flowOn(dispatcher)
                .onStart { _loading.value = true }
                .catch { handleError(it) }
                .onCompletion { _loading.value = false }
                .collect { _allEpisodes.value = it}
        }

    }
    private fun handleError(error: Throwable) {
        when (error) {
            is ConnectionError -> _error.value = Pair(R.string.connection_error_title, R.string.connection_error_msg)
            else -> _error.value = Pair(R.string.error_title, R.string.error_msg)
        }
    }
}