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

package com.owncloud.android.domain.sharing.shares.model

data class OCShare(
    val id: Int? = null,
    val fileSource: Long,
    val itemSource: Long,
    val shareType: ShareType,
    val shareWith: String?,
    val path: String,
    val permissions: Int,
    val sharedDate: Long,
    val expirationDate: Long,
    val token: String?,
    val sharedWithDisplayName: String?,
    val sharedWithAdditionalInfo: String?,
    val isFolder: Boolean,
    val userId: Long,
    val remoteId: Long,
    var accountOwner: String = "",
    val name: String?,
    val shareLink: String?
)

/**
 * Enum for Share Type, with values:
 * -1 - No shared
 * 0 - Shared by user
 * 1 - Shared by group
 * 3 - Shared by public link
 * 4 - Shared by e-mail
 * 5 - Shared by contact
 * 6 - Federated
 *
 * @author masensio
 */

enum class ShareType constructor(val value: Int) {
    NO_SHARED(-1),
    USER(0),
    GROUP(1),
    PUBLIC_LINK(3),
    EMAIL(4),
    CONTACT(5),
    FEDERATED(6);

    companion object {
        fun fromValue(value: Int): ShareType? {
            return when (value) {
                -1 -> NO_SHARED
                0 -> USER
                1 -> GROUP
                3 -> PUBLIC_LINK
                4 -> EMAIL
                5 -> CONTACT
                6 -> FEDERATED
                else -> null
            }
        }
    }
}
