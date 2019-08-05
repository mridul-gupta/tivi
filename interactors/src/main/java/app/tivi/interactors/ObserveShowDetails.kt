/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.tivi.interactors

import app.tivi.data.repositories.shows.ShowRepository
import app.tivi.data.resultentities.ShowDetailed
import app.tivi.util.AppCoroutineDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveShowDetails @Inject constructor(
    private val showRepository: ShowRepository,
    private val dispatchers: AppCoroutineDispatchers
) : SubjectInteractor<ObserveShowDetails.Params, ShowDetailed>() {
    override val dispatcher: CoroutineDispatcher = dispatchers.io

    override fun createObservable(params: Params): Flow<ShowDetailed> {
        return showRepository.observeShow(params.showId)
    }

    data class Params(val showId: Long)
}