/*
 * Copyright (c) 2013-2015 by appPlant UG. All rights reserved.
 *
 * @APPPLANT_LICENSE_HEADER_START@
 *
 * This file contains Original Code and/or Modifications of Original Code
 * as defined in and that are subject to the Apache License
 * Version 2.0 (the 'License'). You may not use this file except in
 * compliance with the License. Please obtain a copy of the License at
 * http://opensource.org/licenses/Apache-2.0/ and read it before using this
 * file.
 *
 * The Original Code and all software distributed under the License are
 * distributed on an 'AS IS' basis, WITHOUT WARRANTY OF ANY KIND, EITHER
 * EXPRESS OR IMPLIED, AND APPLE HEREBY DISCLAIMS ALL SUCH WARRANTIES,
 * INCLUDING WITHOUT LIMITATION, ANY WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, QUIET ENJOYMENT OR NON-INFRINGEMENT.
 * Please see the License for the specific language governing rights and
 * limitations under the License.
 *
 * @APPPLANT_LICENSE_HEADER_END@
 */

package de.appplant.cordova.plugin.notification;
import de.appplant.cordova.plugin.localnotification.LocalNotification;
/**
 * The receiver activity is triggered when a notification is clicked by a user.
 * The activity calls the background callback and brings the launch intent
 * up to foreground.
 */
public class ClickActivity extends AbstractClickActivity {

    /**
     * Called when local notification was clicked by the user. Will
     * move the app to foreground.
     *
     * @param notification
     *      Wrapper around the local notification
     */
    public void onClick(Notification notification) {

        //LocalNotification.fireEvent("click", notification);

        launchApp();

        if (notification.isRepeating()) {
            notification.clear();
        } else {
            notification.cancel();
        }
    }

    /**
     * Build notification specified by options.
     *
     * @param builder
     *      Notification builder
     */
    public Notification buildNotification (Builder builder) {
        return builder.build();
    }

}