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

package com.owncloud.android.data.capabilities.datasources

import android.content.Context
import androidx.lifecycle.LiveData
import com.owncloud.android.data.OwncloudDatabase
import com.owncloud.android.data.capabilities.db.OCCapabilityDao
import com.owncloud.android.data.capabilities.db.OCCapabilityEntity

class OCLocalCapabilitiesDataSource(
    context: Context,
    private val ocCapabilityDao: OCCapabilityDao = OwncloudDatabase.getDatabase(context).capabilityDao()
) : LocalCapabilitiesDataSource {
    override fun getCapabilitiesForAccountAsLiveData(accountName: String): LiveData<OCCapabilityEntity> =
        ocCapabilityDao.getCapabilitiesForAccountAsLiveData(accountName)

    override fun getCapabilityForAccount(accountName: String): OCCapabilityEntity =
        ocCapabilityDao.getCapabilityForAccount(accountName)

    override fun insert(ocCapabilities: List<OCCapabilityEntity>) {
        ocCapabilityDao.replace(ocCapabilities)
    }
}