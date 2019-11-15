/**
 * ownCloud Android client application
 *
 * @author David González Verdugo
 * Copyright (C) 2019 ownCloud GmbH.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.owncloud.android.domain.sharing.sharees

import android.accounts.Account
import android.content.Context
import com.owncloud.android.data.sharing.sharees.ShareeRepository
import com.owncloud.android.data.sharing.sharees.datasources.OCRemoteShareeDataSource
import com.owncloud.android.domain.BaseAsyncUseCase
import com.owncloud.android.lib.common.OwnCloudAccount
import com.owncloud.android.lib.common.OwnCloudClientManagerFactory
import org.json.JSONObject

class GetShareesAsyncUseCase(
    context: Context,
    account: Account,
    private val shareeRepository: ShareeRepository = OCShareeRepository(
        remoteShareeDataSource = OCRemoteShareeDataSource(
            OwnCloudClientManagerFactory.getDefaultSingleton().getClientFor(
                OwnCloudAccount(account, context),
                context
            )
        )
    )
) : BaseAsyncUseCase<ArrayList<JSONObject>, GetShareesAsyncUseCase.Params>() {
    override suspend fun run(params: Params): ArrayList<JSONObject> =
        shareeRepository.getSharees(
            params.searchString,
            params.page,
            params.perPage
        )

    data class Params(
        val searchString: String,
        val page: Int,
        val perPage: Int
    )
}
