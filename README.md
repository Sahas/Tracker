# Tracker
Tracking devices and assets


Flow to insert tracking data:
-------------------------------

Create Device Types (GPS, MOBILE etc) ->
Register Device ->
Register Assets (Optional) ->
Send Tracking Data corresponding to Device and Asset(Optional), Supports metadata.


DEVICE TYPE:
----------------
TYPE_ID | TYPE_NAME
--------------------
1       | GPS
2       | MOBILE


DEVICE_DETAILS
---------------------------------
ID    |  NAME         | DEVICE_TYPE_ID
---------------------------------
1     | Device1       | 1
2     | MobDevice     | 2


ASSET TYPE: (Person/Vehicle/ Group etc)
------------------

Similar to DEVICE TYPE


ASSET DETAILS:
--------------------
Similar to Device Details

TRACKING DATA:
------------------------
ID    | DEVICE_ID   | ASSET_ID    | LATITUDE      | LONGITUDE     | TIMESTAMP      | SPEED         | METADATA(Json) 
----------------------------------------------------------------------------------------------------------------------
1     | 1           | null        | 17.385044     | 78.486671     | 24-01-2018:13:45| 12           | {"country": "India"} 
                                                                    +02:00



